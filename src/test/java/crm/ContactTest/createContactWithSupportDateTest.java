package crm.ContactTest;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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
import crm.objectRepositoryUtility.CreateConDatePage;
import crm.objectRepositoryUtility.CreateNewContactPage;
import crm.objectRepositoryUtility.HomePage;
import crm.objectRepositoryUtility.LogOutPage;
import crm.objectRepositoryUtility.LoginPage;
import crm.objectRepositoryUtility.createConactPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createContactWithSupportDateTest extends BaseClass {

	@Test
	public void CreateContactWithSupportDateTest() throws Throwable {

		String lastName = eLib.getDataFromExcelFile("Contact", 4, 2) + jLib.getRandomNum();

		HomePage h = new HomePage(driver);
		h.getContactLink().click();

		createConactPage ccp = new createConactPage(driver);
		ccp.getcreateNewContactBtn().click();

		String startDate = jLib.getSystemDateYYYYDDMM();
		String endDate = jLib.getRequireDateYYYYDDMM(30);

		CreateConDatePage cnc = new CreateConDatePage(driver);
		cnc.createCon(lastName, startDate, endDate);

		// verify start date and end date
		ConVerificationPage cvp = new ConVerificationPage(driver);
		String actStartDate = cvp.getStartDate().getText();
		if (actStartDate.equals(startDate)) {
			System.out.println(startDate + "   is verified== PASS");
		} else {
			System.out.println(startDate + "  is not verrified ===FAIL");
		}

		String actEndDate = cvp.getEndDate().getText();
		if (actEndDate.equals(endDate)) {
			System.out.println(endDate + "   is verified== PASS");
		} else {
			System.out.println(endDate + "  is not verrified ===FAIL");
		}

	}

}
