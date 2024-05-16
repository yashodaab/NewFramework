package crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteOrgPage {
		
		WebDriver driver;
	    public DeleteOrgPage(WebDriver driver) {
	    	this.driver=driver;
	    	PageFactory.initElements(driver, this);
	    
	}
	    
	    @FindBy(name = "search_text")
	    private WebElement searchEdt;
	    
	    @FindBy(name = "search_field")
	    private WebElement searchDD;
	    
	    @FindBy(name ="submit")
	    private WebElement searchNow;
	    
	    @FindBy(xpath = "//img[@title='Create Organization...']")
		private WebElement createNewOrgBtn;

		public WebElement getcreateNewOrgBtn() {
			return createNewOrgBtn;
		}
	    
		public WebElement getSearchEdt() {
			return searchEdt;
		}

		public WebElement getSearchDD() {
			return searchDD;
		}

		public WebElement getSearchNow() {
			return searchNow;
		}
	    
	    
}
