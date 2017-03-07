package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class basePageClass {
	protected WebDriver driver;
	@FindBy(id="wp-admin-bar-my-account")
	WebElement myAdmin;
	
	@FindBy(linkText="Log Out")
	WebElement clkLogout;
	
	@FindBy(how=How.LINK_TEXT,using="Posts")
	WebElement menuPosts;
	
	public basePageClass(WebDriver driver){
		this.driver= driver;		
	}
	public LoggedOutClass logoutLink(){
		utilsClass.fn_findMouseOverAction(myAdmin);	
		clkLogout.click();
		return new LoggedOutClass(driver);
	}	
	
	public boolean moMenuPosts(){
		return menuPosts.getText().toString().contains("Posts");	
	}
	
	public postsPageClass clkMenuPosts(){
		menuPosts.click();
		return new postsPageClass(driver);
	}
	
	
	public void chanagePassword(){
		
	}
	
	public void help(){
		
	}

}
