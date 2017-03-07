package NewFramework;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Action;



public class LibraryFunctions {
	
	static WebDriver driver;
	public static WebDriver fn_LaunchBrowser(String browserName){		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Lync321/workspace/TestCases/externalDrivers/chromedriver.exe");
		System.setProperty("webdriver.ie.driver", "/TestCases/externalDrivers/IEDriverServer.exe");
		
		if(browserName.equals("FF")){
		ProfilesIni ffProfile = new ProfilesIni();
		FirefoxProfile customFFProfile = ffProfile.getProfile("FirefoxWebDriverProfile");
			
		driver = new FirefoxDriver(customFFProfile);
		}else if(browserName.equals("IE")){
			driver = new InternetExplorerDriver();
		}else if(browserName.equals("CH")){
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	public static void fn_openURL(String url){
		driver.get(url);
		fn_ImplisitWait(Constants.implWait);
		driver.manage().window().maximize();
	}
	
	public static void fn_closeBrowser(){
		driver.quit();
	}
	
	public static Actions fn_findMouseOverAction(WebElement we){
		Actions actObj =new Actions(driver);
		actObj.moveToElement(we).build().perform();
		return actObj;
	}

	public static void fn_mouseOver(String element){
		try {
			WebElement ele1 = fn_findLocator(element);
			fn_findMouseOverAction(ele1);
		}catch(Exception e){
			e.printStackTrace();
			fn_TakeScreenShot(Constants.ScreenShotFilePath);
		}
		
	}
	
	public static String fn_TakeScreenShot(String destFilePath){
		String TS= fn_getTimeStamp();
		TakesScreenshot tss = (TakesScreenshot) driver;
		File srcFileObject =tss.getScreenshotAs(OutputType.FILE);
		destFilePath =destFilePath+TS+".png";
		File DestFileObj = new File(destFilePath);
			try {
				FileUtils.copyFile(srcFileObject, DestFileObj);
			} catch (IOException e) {			
				e.printStackTrace();
			}
		return destFilePath;
	}
	
	public static String fn_getTimeStamp(){
		DateFormat DF= DateFormat.getTimeInstance();
		Date dte = new Date();
		String dateValue = DF.format(dte);
		dateValue=dateValue.replaceAll(":","_");
		dateValue=dateValue.replaceAll(",", "");
		return dateValue;
	}
	
	public static boolean fn_SelectChkBox(String passXpath){
		WebElement ele = fn_findLocator(passXpath);
		if(!ele.isSelected()){
			ele.click();
			System.out.println("Element is checked");
			return true;
		}
		else{
			System.out.println("Element is not checked");
			return false;
		}	
	}
	
	public static boolean fn_UnChkBox(String passXpath){
		WebElement ele = fn_findLocator(passXpath);
		if(ele.isSelected()){
			ele.click();
			System.out.println("Element is Unchecked");
			return true;
		}
		else{
			System.out.println("Element is not Unchecked");
			return false;
		}	
	}
	
	public static void fn_SelDropDown(String passXpath, String selValue, Constants.type type){
		try{
		WebElement ele = fn_findLocator(passXpath);
		Select dropdown = new Select(ele);
			if(type==Constants.type.ByIndex){
				int temp = Integer.parseInt(selValue);		
				dropdown.selectByIndex(temp);
			} else if(type==Constants.type.ByValue){
				dropdown.selectByValue(selValue);
			} else if(type==Constants.type.ByVisibleText){
				dropdown.selectByVisibleText(selValue);
			}
			else{
				System.out.println("Argument not found");
			}
		} catch (Exception e){
			e.printStackTrace();
			fn_TakeScreenShot(Constants.ScreenShotFilePath);
		}		
	}
	
	public static void fn_SelRadiobtn(String elePath){
		List<WebElement> radios= driver.findElements(By.name("xys"));
		for(int i=0;i<radios.size();i++){
			String sValue = radios.get(i).getAttribute("value");
			if(sValue.equalsIgnoreCase("tools")){
				radios.get(i).click();
				break;
			}
		}		
	}
	
	public static void fn_RightClick(String btnpath){
		WebElement ele = fn_findLocator(btnpath);
		Actions actions = new Actions(driver);
		Action action = actions.contextClick(ele).build();
		action.perform();		
	}
	
	public static void fn_DoubleClick(String elePath){
		WebElement ele = fn_findLocator(elePath);
		Actions action = new Actions(driver);
		action.doubleClick(ele);
		action.perform();
	}
	
	public static void fn_DragDrop(String source, String dest){
		try{
			WebElement sorce = fn_findLocator(source);			
			WebElement target = fn_findLocator(dest);
			(new Actions(driver)).dragAndDrop(sorce, target).perform();
		} catch(Exception e){
			e.printStackTrace();
		}		
	}	
	
	public static void fn_ImplisitWait(int impleWait){
		driver.manage().timeouts().implicitlyWait(impleWait, TimeUnit.SECONDS);
	}
	
	public static void fn_ExlicitWait(int expleWait, String elePath){
		WebDriverWait wait = new WebDriverWait(driver,expleWait);
		try{
		WebElement ele1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elePath)));
		ele1.click();		
		} catch(Exception e){
			System.out.println(e.toString());
			fn_TakeScreenShot(Constants.ScreenShotFilePath);
			System.out.println("Failed to click");
		}
	}
	
	public static void  fn_BrowserNavigate(String navigateOption){
		switch(navigateOption){
			case "get":
				driver.get(Constants.url);
				break;
			case "navigate":
				driver.navigate().forward();
				System.out.println("Sucessfully navigated Forward");
				break;
			case "back":
				driver.navigate().back();
				System.out.println("Sucessfully navigated Back");
				break;
			case "refresh":
				driver.navigate().refresh();
				System.out.println("Sucessfully navigated refresh");
				break;
			case "deleteAllcookies":
				driver.manage().deleteAllCookies();
				break;
			default :
				System.out.println("Invalid option selected");
		}
	}
	
	public static boolean isElementPresent(WebElement el){
		return el.isDisplayed();		
	}
	
	public static void fn_click(By by){		
		try
		{
		WebElement button = driver.findElement(by);
		if(isElementPresent(button))
			{
			button.click();		
			}
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Element not found");
		}
	}
	
	public static void fn_PassValueToText(String elePath, String text){
		WebElement textbox= fn_findLocator(elePath);
		textbox.clear();
		textbox.sendKeys(text);
	}
	
	public static String[] fn_SplitVariable(String str){
		String[] tmp;
		String delimeter ="#";		
		tmp = str.split(delimeter);	
		return tmp;
	}
	
	public static WebElement fn_findLocator(String str){
		By by = fn_by(str);
		WebElement ele = driver.findElement(by);
		return ele;
				
	}
	
	public static By fn_by(String str){
		String[] tmp =fn_SplitVariable(str);
		String locator = tmp[0];
		String value = tmp[1];
		By by = null;
		switch(locator){
		case "id":
			by = By.id(value);
			break;
		case "name":
			by = By.name(value);
			break;
		case "className":
			by = By.className(value);
			break;
		case "xpath":
			by = By.xpath(value);
			break;
		default : break;
		}		
		return by;
	}
	
	
	@SuppressWarnings("unchecked")
	public static List keyvaluePair(String searchKey){
		Map<String, List<String>> map;
		map =Constants.pair();
		System.out.println("Feating keys and multiple values");
		String key = null;
		List<String> values = null;
		for(Map.Entry<String, List<String>> entry : map.entrySet()){
			key = entry.getKey();
			if (key ==searchKey){
			values = entry.getValue();
			break;
			}

		}
		return values;
	}
	
	public static WebElement actualKeyValues(String key){
		List<String> str;
		String Locator = null;
		String value = null; 
		str = keyvaluePair(key);
		for(int i=0;i<str.size();i++){
			if(i==0){
			Locator = str.get(i);
			}
			else{
			value = str.get(i);
			}
		}
		
		System.out.println(Locator);
		System.out.println(value);
		
		switch(Locator){
		case "id":
			WebElement ele1 = driver.findElement(By.id(value));
			return ele1;
			
		default:
			WebElement ele = driver.findElement(By.xpath(value));
			return ele;		
		}		
	}
	
	public static void test(String str){
		WebElement ele = actualKeyValues(str);
		ele.click();
	}
	
	public static void pressKeys() throws InterruptedException{
		WebElement ele = driver.findElement(By.xpath(".//*[@id='txtUsername']"));
		boolean bool = ele.isEnabled();
		System.out.println(bool);
		try{
		ele.sendKeys("admin");
		Thread.sleep(2000);
		ele.sendKeys(Keys.TAB);
	
		
	//	Actions act = new Actions(driver);
	//	act.keyDown(Keys.NUMPAD9);
		
		System.out.println("_________________");
		}catch(NotFoundException e){
			e.printStackTrace();
		}
		
	}
	
	public static void getCurrentHostName() throws UnknownHostException{
		InetAddress localMachine = InetAddress.getLocalHost();
		String hostname = localMachine.getHostName();
		String hostaddress = localMachine.getHostAddress();		
		
		System.out.println("HostName : " + hostaddress + "hostadress :"+ hostname);
		System.out.println(System.getProperty("user.name"));
		

	}

}
