package practice.Listener;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcas.crm.baseTest.BaseClass2;

public class retryAnalyzerTest {

	@Test(retryAnalyzer = com.comCast.crm.ListenerUtility.RetryListenerImp.class)
	public void activateSimTest() {
		System.out.println("execute activateSimTest");
		Assert.assertEquals("", "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
}
