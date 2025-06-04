package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.customerProfile_ViewExpensesDetails_PF;
import com.pageFactory.desktopReception.customerProfile_ViewVisitsDetails_PF;
import com.pageFactory.desktopReception.login_PF;

public class customerProfile_ViewVisitsDetails extends BaseTest {
	
	
	private customerProfile_ViewVisitsDetails_PF  objcustomerProfile_ViewVisitsDetails_PF ;
	private login_PF objlogin_PF;
	
	@Test(priority = 0)
	public void viewVisitsDetails()
	{
		initializeWebEnvironment("Neon");	
		objcustomerProfile_ViewVisitsDetails_PF = new customerProfile_ViewVisitsDetails_PF(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objcustomerProfile_ViewVisitsDetails_PF.navigateToCustomerTab();
		objcustomerProfile_ViewVisitsDetails_PF.findCustomer();
		objcustomerProfile_ViewVisitsDetails_PF.clickVisitsTab();
		objcustomerProfile_ViewVisitsDetails_PF.setFilter();
		objcustomerProfile_ViewVisitsDetails_PF.viewReords();
		objcustomerProfile_ViewVisitsDetails_PF.closeTab();
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
