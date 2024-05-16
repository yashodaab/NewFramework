package com.comCast.crm.ListenerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListenerImp implements IRetryAnalyzer{

	int count=0;
	int limitCount= 5;
	@Override
	public boolean retry(ITestResult result) {
	  
		if(count<limitCount) {
			count++;
			return true;
		}
		return false;
	}

	
}
