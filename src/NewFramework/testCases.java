package NewFramework;
import org.openqa.selenium.WebElement;

import NewFramework.commonFunctions;

public class testCases {
	public static void TC1(){
		commonFunctions.actionOpenApps(Constants.CH,Constants.url);
		commonFunctions.actionMouseOver(Constants.mouseOverEle);
		commonFunctions.actionCloseApp();
	}
	public static void TC2(){
		//LibraryFunctions.temp("className");
		// LibraryFunctions.test("txtbox");
		 Constants.defineFunc();
	}
	public static void TC3() throws InterruptedException{
		WebElement ele1 = LibraryFunctions.fn_findLocator(Constants.Loginbtn);
	}
	
	public static void main(String[] args) throws InterruptedException {
		TC3();
	}	
}

