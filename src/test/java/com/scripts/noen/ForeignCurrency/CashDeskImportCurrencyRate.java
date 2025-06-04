package com.scripts.noen.ForeignCurrency;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.CashierManagerTC.TopNavigation_CashDesk;
import com.pageFactory.desktopReception.login_PF;

public class CashDeskImportCurrencyRate extends BaseTest
{

	private TopNavigation_CashDesk objTopNavCashDesk;
	private login_PF objlogin_PF;
	//@Title("Register new customer in Neon and Performing  deposit on and off functionality ")

	private void setUp(){

		initializeWebEnvironment("Neon");
		objTopNavCashDesk = new TopNavigation_CashDesk(this);
		objlogin_PF = new login_PF(this);
	}

	@Test
	public void CashDeskImportCurrencyRate()
	{
		//create New Credit Account
		setUp();
		objlogin_PF.login();		
		objTopNavCashDesk.importCurrencyRate();
		objlogin_PF.logout();	
		tearDown();
	}
	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objlogin_PF = null;
		objTopNavCashDesk =null;
	}
}
