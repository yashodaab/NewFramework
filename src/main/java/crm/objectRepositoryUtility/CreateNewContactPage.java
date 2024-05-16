package crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {

	WebDriver driver;
    public CreateNewContactPage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
    @FindBy(name = "lastname")
    private WebElement lastNameEdt;
    
    @FindBy(xpath = "//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;
	
    public WebElement getOrgNameEdt() {
		return lastNameEdt;
	}
    
	public WebElement getSaveBtn() {
		return saveBtn;
	}


	//Business library
	public void createCon(String lastName) {
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
    }
}
