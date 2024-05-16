package crm.ContactTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comCast.crm.ListenerUtility.listenerImpClass;
import com.comcas.crm.baseTest.BaseClass;

import crm.generic.webDriverUtility.UtilityClassObject;
import crm.objectRepositoryUtility.ConVerificationPage;
import crm.objectRepositoryUtility.CreateConDatePage;
import crm.objectRepositoryUtility.CreateConWithOrgPage;
import crm.objectRepositoryUtility.CreateNewContactPage;
import crm.objectRepositoryUtility.CreateNewOrganizationPage;
import crm.objectRepositoryUtility.HomePage;
import crm.objectRepositoryUtility.OrgVerificationPage;
import crm.objectRepositoryUtility.OrganisationPage;
import crm.objectRepositoryUtility.createConactPage;

@Listeners(com.comCast.crm.ListenerUtility.listenerImpClass.class)
public class createContactWith3ScrptsTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createContactTest() throws Throwable {
         
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String lastName = eLib.getDataFromExcelFile("Contact", 1, 2) + jLib.getRandomNum();
        
		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact Page");
		HomePage h = new HomePage(driver);
		h.getContactLink().click();
        
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create contact page");
		createConactPage ccp = new createConactPage(driver);
		ccp.getcreateNewContactBtn().click();
        
		UtilityClassObject.getTest().log(Status.INFO, "Create a new lastname");
		CreateNewContactPage cnc = new CreateNewContactPage(driver);
		cnc.createCon(lastName);
		//Assert.fail();
		UtilityClassObject.getTest().log(Status.INFO,lastName + "=====>create a new contact");
		// verify the header
		ConVerificationPage cvp = new ConVerificationPage(driver);
		String actLastName = cvp.getLastNameMsg().getText();
		
		//Soft Assert
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actLastName, lastName);
		soft.assertAll();
	}

	
	@Test(groups = "regressionTest")
	public void createContactWithSupportDateTest() throws Throwable {

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
		//hardAssert
		boolean status= actStartDate.contains(startDate);
		Assert.assertEquals(status, true);

		String actEndDate = cvp.getEndDate().getText();
		boolean status1= actEndDate.contains(endDate);
		Assert.assertTrue(status1);

	}

	@Test(groups = "regressionTest")
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
		
		boolean status =actOrgName.contains(orgName);
		Assert.assertTrue(status);
		
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
		boolean flag = actLastName.contains(lastName);
		Assert.assertTrue(flag);

		// verify the header
		String actOrgName1 = cvp.getOrgNameEdt().getText();
		boolean flag1 = actOrgName1.contains(orgName);
		Assert.assertTrue(flag1);

	}

}
