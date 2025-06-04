package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.customerProfile_AddAssociates_PF;
import com.pageFactory.desktopReception.login_PF;

public class customerProfile_AddAssociates extends BaseTest{
	private customerProfile_AddAssociates_PF objcustomerProfile_AddAssociates_PF;;
	private login_PF objlogin_PF;
	
	@Test(priority = 0)
	public void addAssociatesToCustomerProfile()
	{
		initializeWebEnvironment("Neon");	
		objcustomerProfile_AddAssociates_PF= new customerProfile_AddAssociates_PF(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objcustomerProfile_AddAssociates_PF.navigateToCustomerTab();
		objcustomerProfile_AddAssociates_PF.findCustomer();
		objcustomerProfile_AddAssociates_PF.clickAssociatesTab();
		objcustomerProfile_AddAssociates_PF.add_AssociatesToCustAccount();
		objcustomerProfile_AddAssociates_PF.viewAssociatedUserDetails();
		objcustomerProfile_AddAssociates_PF.closeTab();
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
