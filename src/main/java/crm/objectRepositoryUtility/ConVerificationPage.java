package crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConVerificationPage {

	WebDriver driver;
    public ConVerificationPage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
	@FindBy(id = "dtlview_Last Name")
	private WebElement lastNameMsg;
	
	@FindBy(id= "dtlview_Support Start Date")
	private WebElement startDate;
	
	@FindBy(id= "dtlview_Support End Date")
	private WebElement endDate;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgNameEdt;
	
	public WebElement getLastNameMsg() {
		return lastNameMsg;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}
	
	
}
