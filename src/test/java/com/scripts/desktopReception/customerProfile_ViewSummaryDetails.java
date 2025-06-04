package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.customerProfile_ViewSummaryDetails_PF;
import com.pageFactory.desktopReception.login_PF;

public class customerProfile_ViewSummaryDetails extends BaseTest{
	
	private customerProfile_ViewSummaryDetails_PF  objcustomerProfile_ViewSummaryDetails_PF ;
	private login_PF objlogin_PF;
	
	@Test(priority = 0)
	public void viewSummaryDetails()
	{
		initializeWebEnvironment("Neon");	
		objcustomerProfile_ViewSummaryDetails_PF = new customerProfile_ViewSummaryDetails_PF(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objcustomerProfile_ViewSummaryDetails_PF.navigateToCustomerTab();
		objcustomerProfile_ViewSummaryDetails_PF.findCustomer();
		objcustomerProfile_ViewSummaryDetails_PF.clickSummaryTab();
		objcustomerProfile_ViewSummaryDetails_PF.viewReords();
		objcustomerProfile_ViewSummaryDetails_PF.closeTab();
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
