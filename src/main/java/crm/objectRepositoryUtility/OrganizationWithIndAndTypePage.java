package crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationWithIndAndTypePage {

	WebDriver driver;
    public OrganizationWithIndAndTypePage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
    @FindBy(name = "accountname")
    private WebElement orgNameEdt;
    
    @FindBy(name = "industry")
    private WebElement industryDB;
    
    @FindBy(name = "accounttype")
    private WebElement typeDB;
    
    @FindBy(xpath = "//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;
    
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDB() {
		return industryDB;
	}

	public WebElement getTypeDB() {
		return typeDB;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
    
    public void createOrg(String orgName, String industry, String type) {
    	orgNameEdt.sendKeys(orgName);
    	Select sel= new Select(industryDB);
    	sel.selectByVisibleText(industry);
    	Select sel1= new Select(typeDB);
    	sel1.selectByVisibleText(type);
    	saveBtn.click();
    }
    
}
