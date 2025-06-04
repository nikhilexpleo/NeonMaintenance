package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.generic.BaseTest;
import com.pageFactory.desktopReception.customerProfile_ViewGamingDetails_PF;
import com.pageFactory.desktopReception.login_PF;

public class customerProfile_ViewGamingDetails extends BaseTest {
	
	private customerProfile_ViewGamingDetails_PF  objcustomerProfile_ViewGamingDetails_PF ;
	private login_PF objlogin_PF;
	
	@Test(priority = 0)
	public void viewGamingDetails()
	{
		initializeWebEnvironment("Neon");	
		objcustomerProfile_ViewGamingDetails_PF = new customerProfile_ViewGamingDetails_PF(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objcustomerProfile_ViewGamingDetails_PF.navigateToCustomerTab();
		objcustomerProfile_ViewGamingDetails_PF.findCustomer();
		objcustomerProfile_ViewGamingDetails_PF.clickGamingTab();
		objcustomerProfile_ViewGamingDetails_PF.setFilter();
		objcustomerProfile_ViewGamingDetails_PF.viewReords();
		objcustomerProfile_ViewGamingDetails_PF.closeTab();
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
