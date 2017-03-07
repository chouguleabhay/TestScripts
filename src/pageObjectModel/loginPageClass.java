package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class loginPageClass extends basePageClass {
	
	@FindBy(id="user_login")
//	@CacheLookup
	WebElement username;
	
	@FindBy(name="pwd") 
//	@CacheLookup
	WebElement userpassword;
	
	@FindBy(how= How.ID, using="wp-submit") 
//	@CacheLookup
	WebElement logonButton;
	
	@FindBy(how=How.LINK_TEXT,using="Lost your password?")
//	@CacheLookup
	WebElement forgotPassword;
	
		
	public loginPageClass(WebDriver driver) {
		super(driver);
		PageFactory .initElements(driver, this);
	}
	
	public homePageClass login_WordPress(String userName, String password){
		try{
		username.sendKeys(userName);
		userpassword.sendKeys(password);		
		logonButton.click();		
			}
		catch(Exception e){
			e.printStackTrace();
		}
		return new homePageClass(driver);
	}
	
	
	
		
}
