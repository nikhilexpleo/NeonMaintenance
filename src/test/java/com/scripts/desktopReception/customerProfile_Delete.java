package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.customerProfile_Delete_PF;
import com.pageFactory.desktopReception.login_PF;

public class customerProfile_Delete extends BaseTest {

	private customerProfile_Delete_PF  objcustomerProfile_Delete_PF;
	private login_PF objlogin_PF;
	
	@Test(priority = 2)
	public void DeleteCustomerProfile()
	{
		initializeWebEnvironment("Neon");	
		objcustomerProfile_Delete_PF = new customerProfile_Delete_PF(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objcustomerProfile_Delete_PF.navigateToCustomerTab();
		objcustomerProfile_Delete_PF.findCustomer();
		objcustomerProfile_Delete_PF.deleteCustomerProfiles();
		objcustomerProfile_Delete_PF.closeCustomerFindTab();	
		objcustomerProfile_Delete_PF.findDeletedAccount();
		objcustomerProfile_Delete_PF.closeCustomerFindTab();	
		objlogin_PF.logout();	
		//tearDown();
	}
	
	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
	
	}
}
