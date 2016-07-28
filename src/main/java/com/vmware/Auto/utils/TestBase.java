package com.vmware.Auto.utils;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public abstract class TestBase {
	public String featureName = null;
	public String testId = null;
	public String testName = null;
	public String testDescription = null;
	protected static Log log = null;

//	protected Config cfg = Config.getInstance();
	/**
	 * Method to initialize all necessary instance, create VC session
	 */
	@BeforeSuite(alwaysRun=true)
	public void suiteSetUp() throws Exception {
		System.out.println("=============TestBase.suiteSetUp==============");
		log = Log.getInstance();
		log.testSetBegin();
	}
	
	/**
	 * Every test case must implement this method
	 * and mark as annotation '@BeforeTest'.
	 * In the method, call super method 'setCaseInfo()' 
	 *  by given all test case info like ID, Name, Feature, Description
	 */
	public abstract void testBegin()
		      throws Exception;
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param feature
	 * @param description
	 */
	public void setCaseInfo(String id, String name,
			String feature, String description){
		this.testId = id;
		this.testName = name;
		this.featureName = feature;
		this.testDescription = description;
		Log.getInstance().testCaseBegin(id, name, feature, description);
	}
	
	@AfterClass(alwaysRun=true)
	public void testEnd(){
		Log.getInstance().testCaseEnd(null);
	}
	
	/**
	 * Method to clean up, log out VC session
	 */
    @AfterSuite(alwaysRun=true)
    public static void suiteCleanUp() {
        System.out.println("=============TestBase.suiteCleanUp==============");
        log.testSetEnd();
    }
}
