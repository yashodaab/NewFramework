package crm.ContactTest;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.comcas.crm.baseTest.BaseClass;

import crm.generic.fileUility.ExcelFileUtility;
import crm.generic.fileUility.PropertyFileUtility;
import crm.generic.webDriverUtility.JavaUtility;
import crm.generic.webDriverUtility.WebDriverUtility;
import crm.objectRepositoryUtility.ConVerificationPage;
import crm.objectRepositoryUtility.CreateNewContactPage;
import crm.objectRepositoryUtility.HomePage;
import crm.objectRepositoryUtility.LogOutPage;
import crm.objectRepositoryUtility.LoginPage;
import crm.objectRepositoryUtility.createConactPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest extends BaseClass {

	@Test
	public void createContactTest() throws Throwable {
		// Create Object for File uttility we get it from baseClass
		// login from BaseClass
		String lastName = eLib.getDataFromExcelFile("Contact", 1, 2) + jLib.getRandomNum();

		HomePage h = new HomePage(driver);
		h.getContactLink().click();

		createConactPage ccp = new createConactPage(driver);
		ccp.getcreateNewContactBtn().click();

		CreateNewContactPage cnc = new CreateNewContactPage(driver);
		cnc.createCon(lastName);

		// verify the header
		ConVerificationPage cvp = new ConVerificationPage(driver);
		String actLastName = cvp.getLastNameMsg().getText();
		if (actLastName.equals(lastName)) {
			System.out.println(lastName + "   is verified== PASS");
		} else {
			System.out.println(lastName + "  is not verrified ===FAIL");
		}
	}

}
