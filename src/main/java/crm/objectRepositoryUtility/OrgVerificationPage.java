

package crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgVerificationPage {

	WebDriver driver;
    public OrgVerificationPage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	
	@FindBy(id = "dtlview_Organization Name")
	private WebElement orgNameDB;
	
	@FindBy(id="dtlview_Industry")
	private WebElement intustryDb;
	
	@FindBy(id="dtlview_Type")
	private WebElement typeDb;
	
	@FindBy(id="dtlview_Phone")
	private WebElement phoneNumDb;
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getOrgNameDB() {
		return orgNameDB;
	}

	public WebElement getIntustryDb() {
		return intustryDb;
	}

	public WebElement getTypeDb() {
		return typeDb;
	}

	public WebElement getPhoneNumDb() {
		return phoneNumDb;
	}
	
	
}
