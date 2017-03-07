package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedOutClass extends basePageClass{

	@FindBy(className = "message")
	WebElement loggedOutMsg;
	
	@FindBy(id="login_error")
	WebElement loginError;
	
	public LoggedOutClass(WebDriver driver) {
		super(driver);
		PageFactory .initElements(driver, this);
	}
	
	public boolean isLoggedOut(){		
		return loggedOutMsg.getText().toString().contains("You are now logged out.");	
	}
	
	public boolean isLoginFailed(){
		return loginError.getText().toString().contains("ERROR");
	}

}
