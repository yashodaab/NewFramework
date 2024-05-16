package com.comCast.crm.ListenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcas.crm.baseTest.BaseClass;
import com.comcas.crm.baseTest.BaseClass2;

import crm.generic.webDriverUtility.UtilityClassObject;

public class listenerImpClass implements ITestListener, ISuiteListener{
     
		  public static ExtentReports report;
          public  ExtentTest test;
			
			public void onStart(ISuite suite) {
				
				String time = new Date().toString().replace(" ", "_").replace(":", "_");
				ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
				spark.config().setDocumentTitle("CRM test suite Results");
				spark.config().setReportName("RM report");
				spark.config().setTheme(Theme.DARK);
				
				//add env information and create test
			    report = new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("OS", "Windows-10");
				report.setSystemInfo("BROWSER","Firefox-115");
		     
		System.out.println("Report configuration");
	}

	
	public void onFinish(ISuite suite) {
		report.flush();
		System.out.println("Report Backup");
	}

	
	public void onTestStart(ITestResult result) {
		
		System.out.println("========="+result.getMethod().getMethodName()+">===Start=====");
	    test =report.createTest(result.getMethod().getMethodName());
	    UtilityClassObject.setTest(test);
	    test.log(Status.INFO, result.getMethod().getMethodName()+"===> STARTED <====");
	}

	
	public void onTestSuccess(ITestResult result) {
		System.out.println("========="+result.getMethod().getMethodName()+"==>====End====");
		 test.log(Status.PASS, result.getMethod().getMethodName()+"===> COMPLETED <====");
		 
	}

	
	public void onTestFailure(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		
		TakesScreenshot tks = (TakesScreenshot)UtilityClassObject.getDriver();
		String filePath = tks.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filePath, testName+"_"+time);
		 test.log(Status.FAIL, result.getMethod().getMethodName()+"===> FAILED <====");
		/*EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass2.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		
		File dst =new File("./ScreenShot/"+testName+"+"+time+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}

	
	public void onTestSkipped(ITestResult result) {
		 test.log(Status.SKIP, result.getMethod().getMethodName()+"===> SKIPPED <====");
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
	}
	

	
}
