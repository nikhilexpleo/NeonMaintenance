package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.customerProfile_ViewCreditDetail_PF;
import com.pageFactory.desktopReception.login_PF;

public class customerProfile_ViewCreditDetail extends BaseTest{
	private customerProfile_ViewCreditDetail_PF objcustomerProfile_ViewCreditDetail_PF;
	private login_PF objlogin_PF;
	
	@Test(priority = 0)
	public void viewCreditDetails()
	{
		initializeWebEnvironment("Neon");	
		objcustomerProfile_ViewCreditDetail_PF= new customerProfile_ViewCreditDetail_PF(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objcustomerProfile_ViewCreditDetail_PF.navigateToCustomerTab();
		objcustomerProfile_ViewCreditDetail_PF.findCustomer();
		objcustomerProfile_ViewCreditDetail_PF.viewCreditDetails();
		objcustomerProfile_ViewCreditDetail_PF.closeTab();
		objlogin_PF.logout();	
		tearDown();
	}
	
	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		//tearDownWebEnvironment();
	
	}
}
