package crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgWithPhoneNumPage {

	WebDriver driver;
    public OrgWithPhoneNumPage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
    @FindBy(name = "accountname")
    private WebElement orgNameEdt;
    
    @FindBy(id = "phone")
    private WebElement phoneNumDB;
    
    @FindBy(xpath = "//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;
    
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getPhoneNum() {
		return phoneNumDB;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
    
    public void createOrg(String orgName, String phoneNum) {
    	orgNameEdt.sendKeys(orgName);
    	phoneNumDB.sendKeys(phoneNum);
    	saveBtn.click();
    }
}
