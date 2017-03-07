package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class skillListPageClass extends basePageClass {

	public skillListPageClass(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	public void addSkill(){
		driver.findElement(By.id("Skills")).click();		
	}
	public void editSkill(String strName){
		driver.findElement(By.id("Skills")).click();		
	}
	public void deleteSkill(String strName){
		driver.findElement(By.id("Skills")).click();
		utilsClass.waitForSomeTime();
	}
}
