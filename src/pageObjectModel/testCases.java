package pageObjectModel;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class testCases {
	WebDriver driver;
	
	@Before
	public void beforeExecution(){
		
	}
	
	
	@Test(priority=0)
	public void presswordLogin(){
		driver = utilsClass.accessBrowser();
		loginPageClass login_Page = new loginPageClass(driver);
		LoggedOutClass logout_page = new LoggedOutClass(driver);
		homePageClass home_page = new homePageClass(driver);
		
		login_Page.login_WordPress("admin", "demo123");	
		utilsClass.waitForSomeTime();
		Assert.assertTrue(home_page.isHomePageOpened());
		login_Page.logoutLink();
		utilsClass.waitForSomeTime();
		Assert.assertTrue(logout_page.isLoggedOut());		
	}
	
	@Test(priority=1)
	public void invalidLogin(){	
		driver = utilsClass.accessBrowser();
		System.out.println(driver.getTitle());
		loginPageClass login_Page = new loginPageClass(driver);
		LoggedOutClass logout_page = new LoggedOutClass(driver);
//		homePageClass home_page = new homePageClass(driver);
		
		login_Page.login_WordPress("admin", "demo12");	
		utilsClass.waitForSomeTime();		
		Assert.assertTrue(logout_page.isLoginFailed());
	}
	
	@Test(priority=3)
	public void selectPosts(){
		
		driver = utilsClass.accessBrowser();
		loginPageClass login_Page = new loginPageClass(driver);
		login_Page.login_WordPress("admin", "demo123");
		utilsClass.fn_findMouseOverAction(driver.findElement(By.linkText("Posts")));
	//	driver.findElement(By.linkText("All Posts")).click();
		
		List<WebElement> ele= driver.findElements(By.xpath("//li[contains(text(),'All Posts')]/following-sibling::*"));
	//	Log.info("Message found : ");
		for(WebElement e1 : ele){
			System.out.println(e1.getText().toString());
		//	Log.info("Message found : " + e1.getText().toString());
		}
		
	/*	List<WebElement> allChkBoxes = driver.findElements(By.xpath("//*[starts-with(@id,'post-')]/th/input"));
		
		for(WebElement we : allChkBoxes){
			if(!driver.findElement(By.xpath("//*[starts-with(@id,'post-')]/td[2]/a")).getText().toString().contains("admin")){
			we.click();
			}
			System.out.println("required element not found");
		}*/		
	}
	
	@Test
	public void postsPage(){
		driver = utilsClass.accessBrowser();
		loginPageClass login_Page = new loginPageClass(driver);
		postsPageClass post_Page = new postsPageClass(driver);
		login_Page.login_WordPress("admin", "demo123");
		utilsClass.waitForSomeTime();
		login_Page.clkMenuPosts();
		utilsClass.waitForSomeTime();
		Assert.assertTrue(post_Page.ispostsPageOpened());
		int value= 44;
		String[] str = utilsClass.makePostQuickTest(value);
				
		WebElement ele = driver.findElement(By.xpath(str[0]));
		utilsClass.fn_findMouseOverAction(ele);
		ele.findElement(By.xpath(str[1])).click();		
		driver.findElement(By.linkText("Cancel")).click();
		
		utilsClass.waitForSomeTime();
		int value1= 62;
		String[] str1 = utilsClass.makePostQuickTest(value1);
				
		WebElement ele1 = driver.findElement(By.xpath(str1[0]));
		utilsClass.fn_findMouseOverAction(ele1);
		ele.findElement(By.xpath(str1[1])).click();		
		driver.findElement(By.linkText("Cancel")).click();

	}
	
}
