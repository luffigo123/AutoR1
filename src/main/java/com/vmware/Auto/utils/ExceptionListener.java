package com.vmware.Auto.utils;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ExceptionListener extends TestListenerAdapter{
	@Override
	public void onTestFailure(ITestResult testResult) {
		Throwable exceptionThrowable = testResult.getThrowable();
		if (exceptionThrowable!=null) {
			Log.getInstance().handleException(exceptionThrowable);
		}
	}

	@Override
	public void onConfigurationFailure(ITestResult testResult) {
		Throwable exceptionThrowable = testResult.getThrowable();
		if (exceptionThrowable!=null) {
			Log.getInstance().handleException(exceptionThrowable);
		}
		if (testResult.getMethod().getMethodName().equals("suiteSetUp")) {
			TestBase.suiteCleanUp();
		}
	}
}
