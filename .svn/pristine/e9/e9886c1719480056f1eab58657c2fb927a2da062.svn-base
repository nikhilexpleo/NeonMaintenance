package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.Reception_Entry_PF;
import com.pageFactory.desktopReception.login_PF;


public class Reception_Entry extends BaseTest{
	
	
	private Reception_Entry_PF objReception_Entry_PF;
	private login_PF objlogin_PF;
	
	@Test(priority = 0)
	public void VerifyReception_Entry()
	{
		initializeWebEnvironment("Neon");
		objReception_Entry_PF= new Reception_Entry_PF(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objReception_Entry_PF.navigateToReceptionTab();
		objReception_Entry_PF.customerEntry();
		objReception_Entry_PF.lapsedCustomer();
		//objReception_Entry_PF.suspendedCustomer();
		//objReception_Entry_PF.barredCustomersEntry();
		objReception_Entry_PF.customerEntry_CustomersFromOtherCasino();
		objReception_Entry_PF.closeTab();
		objlogin_PF.logout();	

	}
	
		// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		//tearDownWebEnvironment();
		objlogin_PF = null;
		objReception_Entry_PF = null;
	}
}
