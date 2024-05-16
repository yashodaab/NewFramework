package practice.test;

import org.testng.annotations.Test;

import com.comcas.crm.baseTest.BaseClass;

import crm.objectRepositoryUtility.LoginPage;

/**
 * test class for contact module 
 * @author Kaveri
 * 
 */

public class SearchContactTest extends BaseClass{

	/**
	 * Scenario : login ()==> navigateContact==> createContact()==verify
	 */
	@Test
	public void searchContactTest() {
		/*Step1 login to app*/
	LoginPage lp = new LoginPage(driver);
	lp.loginToApp("url", "username", "password");
	}
}
