package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class postsPageClass extends basePageClass{

	@FindBy(how=How.XPATH,using="//*[@id='wpbody-content']/div[4]/h2")
	WebElement postPage;
	
	@FindBy(how=How.LINK_TEXT,using="All Posts")
	WebElement allPosts;
	
	@FindBy(how=How.LINK_TEXT,using="Add New")
	WebElement addNewPost;
	
	@FindBy(how=How.LINK_TEXT,using="Categories")
	WebElement postCategories;
	
	@FindBy(how=How.LINK_TEXT,using="Tags")
	WebElement postTags;
	
	
	
	public postsPageClass(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean ispostsPageOpened(){
		return postPage.getText().toString().contains("Posts");
	}	
	
}
