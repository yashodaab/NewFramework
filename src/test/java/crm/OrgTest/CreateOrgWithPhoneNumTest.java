package crm.OrgTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
import crm.objectRepositoryUtility.HomePage;
import crm.objectRepositoryUtility.LogOutPage;
import crm.objectRepositoryUtility.LoginPage;
import crm.objectRepositoryUtility.OrgVerificationPage;
import crm.objectRepositoryUtility.OrgWithPhoneNumPage;
import crm.objectRepositoryUtility.OrganisationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithPhoneNumTest extends BaseClass {

	@Test
	public void createOrgWithPhoneNumTest() throws Throwable {

		String orgName = eLib.getDataFromExcelFile("Org", 7, 2) + jLib.getRandomNum();
		String phoneNum = eLib.getDataFromExcelFile("Org", 7, 3);

		HomePage h = new HomePage(driver);
		h.getOrgLink().click();

		OrganisationPage cnp = new OrganisationPage(driver);
		cnp.getcreateNewOrgBtn().click();

		// enter all the details and create org
		OrgWithPhoneNumPage owp = new OrgWithPhoneNumPage(driver);
		owp.createOrg(orgName, phoneNum);

		OrgVerificationPage ovp = new OrgVerificationPage(driver);
		String actPhoneNum = ovp.getPhoneNumDb().getText();
		if (actPhoneNum.equals(phoneNum)) {
			System.out.println(phoneNum + "   is verified== PASS");
		} else {
			System.out.println(phoneNum + "  is not verrified ===FAIL");
		}
	}
}
