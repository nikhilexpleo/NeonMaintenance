package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.gratuitiesIncomeAccountTranscation_PF;
import com.pageFactory.desktopReception.login_PF;

public class GratuitiesNonTroncTab extends BaseTest {

	private gratuitiesIncomeAccountTranscation_PF objgratuitiesIncomeAccountTranscation_PF;
	private login_PF objlogin_PF;
	
	
	@Test(priority = 0)
	public void verifygratuitiesIncomeAccoun()
	{
		initializeWebEnvironment("Neon");
		objgratuitiesIncomeAccountTranscation_PF= new gratuitiesIncomeAccountTranscation_PF(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();	
		objgratuitiesIncomeAccountTranscation_PF.navigateTogratuitiesNonTroncTab();
		objgratuitiesIncomeAccountTranscation_PF.addAmountDetailsAndSave();
		objlogin_PF.logout();				
	}
	
	// Closing the browser
		@AfterClass
		private void tearDown() 
		{
			tearDownWebEnvironment();
			objlogin_PF = null;
			objgratuitiesIncomeAccountTranscation_PF = null;
		}
}
