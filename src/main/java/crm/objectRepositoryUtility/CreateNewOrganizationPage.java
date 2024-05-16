package crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage {

	WebDriver driver;
    public CreateNewOrganizationPage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
    @FindBy(name = "accountname")
    private WebElement orgNameEdt;
    
    @FindBy(xpath = "//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;
	
    public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}
    
	public WebElement getSaveBtn() {
		return saveBtn;
	}


	//Business library
	public void createOrg(String orgName) {
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
    }
    
}
