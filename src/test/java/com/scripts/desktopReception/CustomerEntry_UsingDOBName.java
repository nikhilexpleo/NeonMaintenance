package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.CustomerEntry_UsingDOBName_PF;
import com.pageFactory.desktopReception.login_PF;

public class CustomerEntry_UsingDOBName extends BaseTest{
	private CustomerEntry_UsingDOBName_PF objCustomerEntry_UsingDOBName_PF;
	private login_PF objlogin_PF;
	
	
	@Test
	public void checkCustomerEntryUsingNameDOB()
	{
		initializeWebEnvironment("Neon");
		objCustomerEntry_UsingDOBName_PF= new CustomerEntry_UsingDOBName_PF(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		
		objCustomerEntry_UsingDOBName_PF.customerEntryUsingDOB();
		objCustomerEntry_UsingDOBName_PF.customerEntryUsingName();
		
		//objlogin_PF.logout();	
		
	}
	
		// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objCustomerEntry_UsingDOBName_PF =null;
		objlogin_PF = null;
	}
}
