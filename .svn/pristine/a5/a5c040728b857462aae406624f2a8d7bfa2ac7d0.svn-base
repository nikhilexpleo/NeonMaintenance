package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.customerProfile_ViewExpensesDetails_PF;
import com.pageFactory.desktopReception.login_PF;

public class customerProfile_ViewExpensesDetails extends BaseTest {
	private customerProfile_ViewExpensesDetails_PF  objcustomerProfile_ViewExpensesDetails_PF ;
	private login_PF objlogin_PF;
	
	@Test(priority = 0)
	public void viewExpensesDetails()
	{
		initializeWebEnvironment("Neon");	
		objcustomerProfile_ViewExpensesDetails_PF = new customerProfile_ViewExpensesDetails_PF (this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objcustomerProfile_ViewExpensesDetails_PF.navigateToCustomerTab();
		objcustomerProfile_ViewExpensesDetails_PF.findCustomer();
		objcustomerProfile_ViewExpensesDetails_PF.clickAuditTab();
		//objcustomerProfile_ViewExpensesDetails_PF.setFilter();
		objcustomerProfile_ViewExpensesDetails_PF.viewReords();		
		objcustomerProfile_ViewExpensesDetails_PF.closeTab();
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
