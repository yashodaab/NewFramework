package crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateConDatePage {


	WebDriver driver;
    public CreateConDatePage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
    @FindBy(name = "lastname")
    private WebElement lastNameEdt;
    
    @FindBy(name = "support_start_date")
    private WebElement startDatedb;
    
    @FindBy(name = "support_end_date")
    private WebElement endDatedb;
    
    @FindBy(xpath = "//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;
	
    public WebElement getOrgNameEdt() {
		return lastNameEdt;
	}
    
	public WebElement getSaveBtn() {
		return saveBtn;
	}

   public WebElement getStartDate() {
		return startDatedb;
	}

	public WebElement getEndDate() {
		return endDatedb;
	}

	//Business library
	public void createCon(String lastName, String startDate, String endDate) {
		lastNameEdt.sendKeys(lastName);
		startDatedb.clear();
		startDatedb.sendKeys(startDate);
		endDatedb.clear();
		endDatedb.sendKeys(endDate);
		saveBtn.click();
    }
}
