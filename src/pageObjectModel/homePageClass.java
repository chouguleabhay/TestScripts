package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class homePageClass extends basePageClass {
	@FindBy(how=How.LINK_TEXT, using="Home")
	WebElement logonHeading;
	
	public homePageClass(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		}
	public void gotoSkills(){
		driver.findElement(By.id("Skills")).click();;
		
	}
	public void gotoEducation(){
		driver.findElement(By.id("Education")).click();		
	}
	public boolean isSkillinTheList(String skill){
		return driver.findElement(By.id(skill)).isDisplayed();
	}
	public boolean isHomePageOpened(){
		return logonHeading.getText().toString().contains("Home");	
	}
}
