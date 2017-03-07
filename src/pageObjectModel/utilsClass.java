package pageObjectModel;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;

public class utilsClass {
	static WebDriver driver;
	public static void waitForSomeTime(){
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public static WebDriver accessBrowser(){
	//		driver = new FirefoxDriver();
			ProfilesIni ffProfile = new ProfilesIni();
			FirefoxProfile customFFProfile = ffProfile.getProfile("FirefoxWebDriverProfile");
			driver = new FirefoxDriver(customFFProfile);
			driver.get("http://demosite.center/wordpress/wp-login.php");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
	//		Log.info("Successfully maximized");
			return driver;
	}
	
	public static void closeBrowser(){
		driver.quit();
	}
	
	public static Actions fn_findMouseOverAction(WebElement ele){
		Actions actObj =new Actions(driver);		
		actObj.moveToElement(ele).build().perform();
		return actObj;		
	}
	
	
	public static String[] makePostQuickTest(int number){
		String[] str = new String[2];
		String idfirstpart = "//*[@id='post-";
		String idlastpart = "']/th/input";
		String actulaxPath = "']/td[1]/div[1]/span[2]/a";
		
		String id =idfirstpart + number + idlastpart;
		String xpath = idfirstpart + number + actulaxPath;
		str[0] = id;
		str[1] = xpath;
		
		return str;
	}
	
	public static void fn_TakeScreenShot(String destFilePath){
		TakesScreenshot tss = (TakesScreenshot) driver;
		File srcFileObject =tss.getScreenshotAs(OutputType.FILE);
		File destFolder = directory();
		String S1 = destFolder +"/"+ destFilePath;
		File DestFileObj = new File(S1);
			try {
				FileUtils.copyFile(srcFileObject, DestFileObj);
			} catch (IOException e) {			
				e.printStackTrace();				
			}
	//	return destFilePath;
	}
	
	public static File directory(){
		  File file = new File("./Screenshots");
	        if (!file.exists()) {
	            if (file.mkdir()) {
	                System.out.println("Directory is created!");
	            } else {
	                System.out.println("Failed to create directory! or directory already exist");
	            }
	        }		
		return file;		
	}
	
}
