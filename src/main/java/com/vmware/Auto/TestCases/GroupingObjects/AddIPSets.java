package com.vmware.Auto.TestCases.GroupingObjects;

import java.util.ArrayList;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.vmware.Auto.model.GroupingObjects.IPSets;
import com.vmware.Auto.service.GroupingObjects.IPSetsService;
import com.vmware.Auto.utils.TestBaseLog;
import com.vmware.Auto.utils.TestData;

public class AddIPSets extends TestBaseLog{
	
	@BeforeClass(alwaysRun=true)
	public void testBegin() throws Exception {
		setCaseInfo("GOIS001", "AddIPSets", "Grouping Objects", 
				"Add IPSets","API","P0");
	}
	
	@Test(groups = {"GroupingObjects"},alwaysRun=true)
	public void addIPSets() throws Exception {
		IPSetsService ipSetsService = new IPSetsService();
		IPSets ipSets = null;
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("192.168.1.1");
		arrayList.add("192.168.2.1-192.168.2.10");
		
		for (String G11nInput : TestData.AllTestData)
		{
			ipSets = new IPSets(G11nInput,arrayList);
			log.info("Add a new IPSets for deleting");
			ipSetsService.addIPSets(ipSets);
			log.verifyTrue("Add IPSets Successfully!", ipSetsService.isExist(G11nInput));
			ipSetsService.deleteTIPSets(G11nInput);
			log.verifyFalse("Delete IPSets Successfully!", ipSetsService.isExist(G11nInput));
		}
		
	}

	@AfterClass(alwaysRun=true)
	public void afterTest() throws Exception {
		Thread.sleep(5000);
	}
}
