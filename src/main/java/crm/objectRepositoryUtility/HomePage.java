package crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
    public HomePage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
	@FindBy(linkText ="Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText ="Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText ="Campaigns")
	private WebElement campaignLink;
	
	@FindBy(linkText ="More")
	private WebElement moreLink;
	
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}
	
	public WebElement getMoreLink() {
		return moreLink;
	}

	
	//if required create business library ,in organisation and contact module no need here becoz we are performing single action(only one click)

	public void navigateToCampaignPage() {
		
		Actions act= new Actions(driver);
		act.moveToElement(moreLink).perform();
		campaignLink.click();
	}
	
}
