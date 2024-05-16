package com.comcas.crm.baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import crm.generic.dataBase.Utility.DataBaseUtility;
import crm.generic.fileUility.ExcelFileUtility;
import crm.generic.fileUility.PropertyFileUtility;
import crm.generic.webDriverUtility.JavaUtility;
import crm.generic.webDriverUtility.UtilityClassObject;
import crm.generic.webDriverUtility.WebDriverUtility;
import crm.objectRepositoryUtility.LogOutPage;
import crm.objectRepositoryUtility.LoginPage;

public class BaseClass {

	public DataBaseUtility dbLib = new DataBaseUtility();
	public PropertyFileUtility fLib = new PropertyFileUtility();
	public ExcelFileUtility eLib = new ExcelFileUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver = null;
	public  WebDriver sdriver= null;

   
	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void conFigBS() throws Throwable {

		System.out.println("===== connect to db, Report config====");
		dbLib.getDbConnection();
	}

	
	@BeforeClass(groups = { "smokeTest", "regressionTest" })

	public void conFigBC() throws Throwable {
		System.out.println("====Launch Browser=====");
		String BROWSER =fLib.getDataFromPropertiesFile("browser");
		//String BROWSER=System.getProperty("browser");

		if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else {
			driver = new EdgeDriver();
		}
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void conFigBM() throws Throwable {
		System.out.println("===Login to App===");
		String Url = fLib.getDataFromPropertiesFile("url");
		String Username = fLib.getDataFromPropertiesFile("username");
		String Password = fLib.getDataFromPropertiesFile("password");
		//String URL=System.getProperty("url",fLib.getDataFromPropertiesFile("url"));
		//String USERNAME=System.getProperty("url",fLib.getDataFromPropertiesFile("username"));
		//String PASSWORD=System.getProperty("url",fLib.getDataFromPropertiesFile("password"));
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(Url, Username, Password);
	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void conFigAM() {
		System.out.println("===LogOut to app====");
		LogOutPage lop = new LogOutPage(driver);
		lop.logOut();
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void conFigAC() {
		System.out.println("===close the browser===");
		driver.quit();
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void conFigAS() throws Throwable {

		
		System.out.println("===close db connection, report Backup====");
		dbLib.closeDbConnection();
	}
}
