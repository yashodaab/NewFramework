package crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.generic.webDriverUtility.WebDriverUtility;

/**
 * @author Kaveri
 * 
 * contains login page elements and business Lib like login()
 * 
 */
public class LoginPage extends WebDriverUtility{        //Rule 1 create separate Java class for every page

	//Rule 3 Object intilization(we can do it in test script also)
	WebDriver driver;
	    public LoginPage(WebDriver driver) {
	    	this.driver=driver;
	    	PageFactory.initElements(driver, this);
	    }
	       //Rule 2 Object creation
	    
	    @FindBy(name="user_name")
	     private WebElement usernameEdt;
	
	    @FindBy(name="user_password")
	    private WebElement passwordEdt;
	
	    @FindBy(id="submitButton")
	    private WebElement loginBtn;
	   
	    //Rule 4 Object Encapsulation

		public WebElement getUsernameEdt() {
			return usernameEdt;
		}

		public WebElement getPasswordEdt() {
			return passwordEdt;
		}

		public WebElement getLoginBtn() {
			return loginBtn;
		}
		
		//Rule 5 Object Utilization (In test Scripts  instead of accessing elements  directly use public getter methods)
	    //provide action Business library
		
		/**
		 * loin to app based on username, password url arguments
		 * @param Url
		 * @param username
		 * @param password
		 */
		
		public void loginToApp(String Url ,String username, String password) {
			waitForPageToLoad(driver);
			driver.get(Url);
			driver.manage().window().maximize();
			usernameEdt.sendKeys(username);
			passwordEdt.sendKeys(password);
			loginBtn.click();
		}

		
}
