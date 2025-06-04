package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.generic.BaseTest;
import com.pageFactory.desktopReception.customerHistoricalAndEstimatedVisitEntry_PF;
import com.pageFactory.desktopReception.login_PF;

public class customerHistoricalAndEstimatedVisitEntry extends BaseTest{
	
	private customerHistoricalAndEstimatedVisitEntry_PF objcustomerHistoricalAndEstimatedVisitEntry_PF;
	private login_PF objlogin_PF;
	
	
	@Test(priority = 0)
	public void checkcustomerHistoricalAndEstimatedVisitEntry()
	{
		initializeWebEnvironment("Neon");
		objcustomerHistoricalAndEstimatedVisitEntry_PF= new customerHistoricalAndEstimatedVisitEntry_PF(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		
		objcustomerHistoricalAndEstimatedVisitEntry_PF.navigateTohistoricalVisitEntryTab();
		objcustomerHistoricalAndEstimatedVisitEntry_PF.addCustomerVisitEntryDetails();
		
		//objcustomerHistoricalAndEstimatedVisitEntry_PF.navigateToestimatedVisitEntryTab();
		//objcustomerHistoricalAndEstimatedVisitEntry_PF.details();
		objlogin_PF.logout();	
		tearDown();
	}
	
		// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
	
	}

}
