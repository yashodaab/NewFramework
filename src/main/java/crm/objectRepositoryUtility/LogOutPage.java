package crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {

	WebDriver driver;
    public LogOutPage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement imgOut;
	
	@FindBy(linkText = "Sign Out")
	private WebElement logOutln;
	
	public WebElement getImgOut() {
		return imgOut;
	}

	public WebElement getLogOutln() {
		return logOutln;
	}
	
	public void logOut() {
		Actions act = new Actions(driver);
		act.moveToElement(imgOut).perform();
		logOutln.click();
	}
}
