package NewFramework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import NewFramework.LibraryFunctions;


public class commonFunctions{
	public static void actionOpenApps(String brower, String URL ){
		LibraryFunctions.fn_LaunchBrowser(brower);
		LibraryFunctions.fn_openURL(URL);		
	}
	public static void actionCloseApp(){
		LibraryFunctions.fn_closeBrowser();
	}
	public static void actionMouseOver(String ele){
		LibraryFunctions.fn_mouseOver(ele);	
		LibraryFunctions.fn_SelDropDown("", "", Constants.type.ByIndex);
	}
	public static void actionRightclk(String btnPath){
		LibraryFunctions.fn_RightClick(btnPath);
	}
	public static void actionDoubleclk(String btnPath){
		LibraryFunctions.fn_DoubleClick(btnPath);

	}
	public static void actionNavigate(String nav){
		LibraryFunctions.fn_BrowserNavigate(nav);		
	}
	public static void actionClk(String Locator){
		LibraryFunctions.fn_findLocator(Locator).click();		
	}

}