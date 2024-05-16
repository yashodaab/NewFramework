package crm.OrgTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.comcas.crm.baseTest.BaseClass;

import crm.generic.fileUility.ExcelFileUtility;
import crm.generic.fileUility.PropertyFileUtility;
import crm.generic.webDriverUtility.JavaUtility;
import crm.generic.webDriverUtility.WebDriverUtility;
import crm.objectRepositoryUtility.CreateNewOrganizationPage;
import crm.objectRepositoryUtility.DeleteOrgPage;
import crm.objectRepositoryUtility.HomePage;
import crm.objectRepositoryUtility.LogOutPage;
import crm.objectRepositoryUtility.LoginPage;
import crm.objectRepositoryUtility.OrgVerificationPage;
import crm.objectRepositoryUtility.OrganisationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class deleteOrgNameTest extends BaseClass {

	@Test
	public void DeleteOrgNameTest() throws Throwable {

		String orgName = eLib.getDataFromExcelFile("Org", 10, 2) + jLib.getRandomNum();

		// Step2 navigate to organisation
		HomePage h = new HomePage(driver);
		h.getOrgLink().click();

		// Step3 Click on create organisation
		OrganisationPage cnp = new OrganisationPage(driver);
		cnp.getcreateNewOrgBtn().click();

		// Step4 enter all details and create new organisation
		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.createOrg(orgName);

		// verify Header oorgName info Expected result
		OrgVerificationPage ovp = new OrgVerificationPage(driver);
		String actOrgName = ovp.getOrgNameDB().getText();
		if (actOrgName.equals(orgName)) {
			System.out.println(orgName + " is created == PASS");
		} else {
			System.out.println(orgName + "  is not created == FAIL");
		}

		// Step5 go back to organisation page
		h.getOrgLink().click();
		// search for organisation
		DeleteOrgPage dop = new DeleteOrgPage(driver);
		dop.getSearchEdt().sendKeys(orgName);
		wLib.select(dop.getSearchDD(), "Organization Name");
		dop.getSearchNow().click();
		// in dynamic web table select and del org
		driver.findElement(By.xpath("//a[text()='" + orgName + "']/../../td[8]/a[text()='del']")).click();

		wLib.switchToAlertAndAccept(driver);

	}
}
