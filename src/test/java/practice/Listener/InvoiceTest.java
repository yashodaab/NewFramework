package practice.Listener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcas.crm.baseTest.BaseClass;
import com.comcas.crm.baseTest.BaseClass2;

@Listeners(com.comCast.crm.ListenerUtility.listenerImpClass.class)
public class InvoiceTest extends BaseClass2{

	@Test
	public void createInvoiceTest() {
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
