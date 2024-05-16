package crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateConWithOrgPage {

	WebDriver driver;
    public CreateConWithOrgPage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
    @FindBy(name = "lastname")
    private WebElement lastNameEdt;
    
    @FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
    private WebElement plusSign;
    
    @FindBy(name = "search_text")
    private WebElement searchBox;
    
    @FindBy(name = "search")
    private WebElement searchNow;
    
    
    @FindBy(xpath = "//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;
	
    public WebElement getOrgNameEdt() {
		return lastNameEdt;
	}
    
	public WebElement getPlusSign() {
		return plusSign;
	}


	public WebElement getSearchBox() {
		return searchBox;
	}


	public WebElement getSearchNow() {
		return searchNow;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createCon( String orgName) {
		searchBox.sendKeys(orgName);
	}
	
	public void createCon1( String lastName) {
		lastNameEdt.sendKeys(lastName);
	}
}
