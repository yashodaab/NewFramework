package crm.OrgTest;

import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.comcas.crm.baseTest.BaseClass;

import crm.generic.fileUility.ExcelFileUtility;
import crm.generic.fileUility.PropertyFileUtility;
import crm.generic.webDriverUtility.JavaUtility;
import crm.generic.webDriverUtility.WebDriverUtility;
import crm.objectRepositoryUtility.CreateNewOrganizationPage;
import crm.objectRepositoryUtility.HomePage;
import crm.objectRepositoryUtility.LogOutPage;
import crm.objectRepositoryUtility.LoginPage;
import crm.objectRepositoryUtility.OrgVerificationPage;
import crm.objectRepositoryUtility.OrganisationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisationTest extends BaseClass {

	@Test
	public void createOrganisationTest() throws Throwable {

		String orgName = eLib.getDataFromExcelFile("Org", 1, 2) + jLib.getRandomNum();

		// Step2 navigate to organisation
		HomePage h = new HomePage(driver);
		h.getOrgLink().click();

		// Step3 Click on create organisation
		OrganisationPage cnp = new OrganisationPage(driver);
		cnp.getcreateNewOrgBtn().click();

		// Step4 enter all details and create new organisation
		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.createOrg(orgName);

		// verify Header msg Expected result
		OrgVerificationPage ovp = new OrgVerificationPage(driver);
		String headerInfo = ovp.getHeaderMsg().getText();
		if (headerInfo.contains(orgName)) {
			System.out.println(orgName + "  is created == PASS");
		} else {
			System.out.println(orgName + "  is not created == FAIL");
		}

		// verify Header oorgName info Expected result
		String actOrgName = ovp.getOrgNameDB().getText();
		if (actOrgName.equals(orgName)) {
			System.out.println(orgName + " is created == PASS");
		} else {
			System.out.println(orgName + "  is not created == FAIL");
		}

	}

}
