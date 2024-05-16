package crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createConactPage {

	WebDriver driver;
    public createConactPage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createNewContactBtn;

	public WebElement getcreateNewContactBtn() {
		return createNewContactBtn;
	}
}
