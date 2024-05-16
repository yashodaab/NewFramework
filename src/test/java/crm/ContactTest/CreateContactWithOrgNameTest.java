package crm.ContactTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import crm.objectRepositoryUtility.ConVerificationPage;
import crm.objectRepositoryUtility.CreateConWithOrgPage;
import crm.objectRepositoryUtility.CreateNewOrganizationPage;
import crm.objectRepositoryUtility.HomePage;
import crm.objectRepositoryUtility.LogOutPage;
import crm.objectRepositoryUtility.LoginPage;
import crm.objectRepositoryUtility.OrgVerificationPage;
import crm.objectRepositoryUtility.OrganisationPage;
import crm.objectRepositoryUtility.createConactPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrgNameTest extends BaseClass {

	@Test
	public void createContactWithOrgNameTest() throws Throwable {

		String orgName = eLib.getDataFromExcelFile("Contact", 7, 2) + jLib.getRandomNum();
		String lastName = eLib.getDataFromExcelFile("Contact", 7, 3);

		HomePage h = new HomePage(driver);
		h.getOrgLink().click();

		OrganisationPage cnp = new OrganisationPage(driver);
		cnp.getcreateNewOrgBtn().click();

		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.createOrg(orgName);

		OrgVerificationPage ovp = new OrgVerificationPage(driver);
		String actOrgName = ovp.getOrgNameDB().getText();
		if (actOrgName.equals(orgName)) {
			System.out.println(orgName + " is created == PASS");
		} else {
			System.out.println(orgName + "  is not created == FAIL");
		}

		h.getContactLink().click();

		createConactPage ccp = new createConactPage(driver);
		ccp.getcreateNewContactBtn().click();

		CreateConWithOrgPage cop = new CreateConWithOrgPage(driver);
		cop.createCon1(lastName);
		cop.getPlusSign().click();

		wLib.switchNewBrowserTab(driver, "module=Accounts");

		cop.createCon(orgName);
		cop.getSearchNow().click();

		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click(); // using dynamic xpah

		wLib.switchNewBrowserTab(driver, "Contacts&action");

		cop.getSaveBtn().click();

		// verify Header msg Expected result
		ConVerificationPage cvp = new ConVerificationPage(driver);
		String actLastName = cvp.getLastNameMsg().getText();
		if (actLastName.equals(lastName)) {
			System.out.println(lastName + "  is created == PASS");
		} else {
			System.out.println(lastName + "  is not created == FAIL");
		}

		// verify the header
		String actOrgName1 = cvp.getOrgNameEdt().getText();
		if (actOrgName1.trim().equals(orgName)) {
			System.out.println(orgName + "   is verified== PASS");
		} else {
			System.out.println(orgName + "  is not verrified ===FAIL");
		}

	}
}
