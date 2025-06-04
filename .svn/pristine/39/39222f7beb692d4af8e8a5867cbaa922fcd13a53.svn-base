package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.Reception_Entry_PF;
import com.pageFactory.desktopReception.login_PF;
import com.pageFactory.desktopReception.viewCustomerInCasino_PF;

public class viewCustomerCasino extends BaseTest{

	
	private viewCustomerInCasino_PF objviewCustomerInCasino_PF;
	private login_PF objlogin_PF;
	
	
	@Test
	public void viewCustomerCasino()
	{
		initializeWebEnvironment("Neon");
		objviewCustomerInCasino_PF= new viewCustomerInCasino_PF(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objviewCustomerInCasino_PF.viewCustomers();
		objlogin_PF.logout();	
	
	}
	
		// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objviewCustomerInCasino_PF = null;
		objlogin_PF =null;
	}
}
