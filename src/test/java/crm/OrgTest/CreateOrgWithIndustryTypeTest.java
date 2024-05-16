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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
import crm.objectRepositoryUtility.OrganizationWithIndAndTypePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithIndustryTypeTest extends BaseClass {

	@Test
	public void createOrgWithIndustryTypeTest() throws Throwable {

		String orgName = eLib.getDataFromExcelFile("Org", 4, 2) + jLib.getRandomNum();
		String industry = eLib.getDataFromExcelFile("Org", 4, 3);
		String type = eLib.getDataFromExcelFile("Org", 4, 4);

		HomePage h = new HomePage(driver);
		h.getOrgLink().click();

		OrganisationPage cnp = new OrganisationPage(driver);
		cnp.getcreateNewOrgBtn().click();

		// enter all the details and create org
		OrganizationWithIndAndTypePage cno = new OrganizationWithIndAndTypePage(driver);
		cno.createOrg(orgName, industry, type);

		// verify industry and type dropdown Expected result

		OrgVerificationPage ovp = new OrgVerificationPage(driver);
		String actIndustry = ovp.getIntustryDb().getText();
		if (actIndustry.equals(industry)) {
			System.out.println(industry + "   is verified== PASS");
		} else {
			System.out.println(industry + "  is not verified == FAIL");
		}

		String actType = ovp.getTypeDb().getText();
		if (actType.equals(type)) {
			System.out.println(type + "  is verified== PASS");
		} else {
			System.out.println(type + "  is not verified == FAIL");
		}
	}

}
