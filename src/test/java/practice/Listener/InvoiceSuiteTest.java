package practice.Listener;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcas.crm.baseTest.BaseClass2;

public class InvoiceSuiteTest extends BaseClass2{

	@Test
	public void createSuiteInvoiceTest() {
		System.out.println("execute createInvoiceTest");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	
	
	@Test
	public void createInvoiceWithConactTest() {
		System.out.println("execute createInvoiceWithConactTest");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
}
