package practice.Listener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcas.crm.baseTest.BaseClass;
import com.comcas.crm.baseTest.BaseClass2;

import crm.generic.webDriverUtility.UtilityClassObject;

@Listeners(com.comCast.crm.ListenerUtility.listenerImpClass.class)
public class executeFailTest extends BaseClass{

		@Test
		public void createInvoiceTest() {
			System.out.println("execute createInvoiceTest");
			
			UtilityClassObject.getTest().log(Status.INFO, "hi Kaveri");
			String actTitle = driver.getTitle();
			Assert.assertEquals(actTitle, "Login");
			System.out.println("step-1");
			System.out.println("step-2");
			System.out.println("step-3");
			System.out.println("step-4");
		}
		
		
}
