package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.customerProfile_AddAssociates_PF;
import com.pageFactory.desktopReception.customerProfile_ViewAuditDetails_PF;
import com.pageFactory.desktopReception.login_PF;

public class customerProfile_ViewAuditDetails extends BaseTest {

	
	private customerProfile_ViewAuditDetails_PF objcustomerProfile_ViewAuditDetails_PF;
	private login_PF objlogin_PF;
	
	@Test(priority = 0)
	public void viewAuditDetails()
	{
		initializeWebEnvironment("Neon");	
		objcustomerProfile_ViewAuditDetails_PF= new customerProfile_ViewAuditDetails_PF(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		
		objcustomerProfile_ViewAuditDetails_PF.navigateToCustomerTab();
		objcustomerProfile_ViewAuditDetails_PF.findCustomer();
		objcustomerProfile_ViewAuditDetails_PF.clickAuditTab();
		objcustomerProfile_ViewAuditDetails_PF.viewReords();
		objcustomerProfile_ViewAuditDetails_PF.closeTab();
		
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
