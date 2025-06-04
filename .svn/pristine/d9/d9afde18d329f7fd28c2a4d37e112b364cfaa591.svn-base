package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.cashier_AssetEntry_PF;
import com.pageFactory.desktopReception.login_PF;

public class cashier_AssetEntry extends BaseTest {
	private cashier_AssetEntry_PF objcashier_AssetEntry_PF;
	private login_PF objlogin_PF;
	
	@Test(priority = 0)
	public void viewcashier_AssetEntryDetails()
	{
		initializeWebEnvironment("Neon");	
		objcashier_AssetEntry_PF= new cashier_AssetEntry_PF(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objcashier_AssetEntry_PF.navigateToBalanceTab();
		objcashier_AssetEntry_PF.setAssentEntryForClosingCash();
		objcashier_AssetEntry_PF.closeTab();
		objcashier_AssetEntry_PF.verifyBalance();
		objcashier_AssetEntry_PF.close();
		
		objlogin_PF.logout();	
		;
	}
	
	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objcashier_AssetEntry_PF = null;
		objlogin_PF = null;
		
		
	}
}
