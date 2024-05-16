package crm.OrgTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcas.crm.baseTest.BaseClass;

import crm.objectRepositoryUtility.CreateNewOrganizationPage;
import crm.objectRepositoryUtility.DeleteOrgPage;
import crm.objectRepositoryUtility.HomePage;
import crm.objectRepositoryUtility.OrgVerificationPage;
import crm.objectRepositoryUtility.OrgWithPhoneNumPage;
import crm.objectRepositoryUtility.OrganisationPage;
import crm.objectRepositoryUtility.OrganizationWithIndAndTypePage;

public class CreateOrgWith4Scripts extends BaseClass {

	@Test(groups = "smokeTest")
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
		
		boolean status =headerInfo.contains(orgName);
		Assert.assertEquals(status, true);

		// verify Header oorgName info Expected result
		String actOrgName = ovp.getOrgNameDB().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actOrgName, orgName);
		soft.assertAll();

	}

	@Test(groups = "regressionTest")
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
		Assert.assertEquals(actIndustry, industry);

		String actType = ovp.getTypeDb().getText();
		Assert.assertEquals(actType, type);
	}

	@Test(groups = "regressionTest")
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
		SoftAssert ass= new SoftAssert();
		ass.assertEquals(actPhoneNum, phoneNum);
		ass.assertAll();
	}

	@Test(groups = "regressionTest")
	public void deleteOrgNameTest() throws Throwable {

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
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actOrgName, orgName);
		soft.assertAll();

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
