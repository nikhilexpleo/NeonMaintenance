package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.login_PF;
import com.pageFactory.desktopReception.tableProgressiveJackpotPayout_PF;

public class tableProgressiveJackpotPayout extends BaseTest {

	private tableProgressiveJackpotPayout_PF objtableProgressiveJackpotPayout_PF;
	private login_PF objlogin_PF;
	
	
	@Test
	public void verifyTableProgressiveJackpotPayout()
	{
		initializeWebEnvironment("Neon");
		objtableProgressiveJackpotPayout_PF= new tableProgressiveJackpotPayout_PF(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		
		objtableProgressiveJackpotPayout_PF.navigateToTableProgressiveJackpotPayoutTab();
		objtableProgressiveJackpotPayout_PF.addAmountDetailsAndSave();
			
		objlogin_PF.logout();	
	}
	
	
	// Closing the browser
		@AfterClass
		private void tearDown() 
		{
			tearDownWebEnvironment();
			objtableProgressiveJackpotPayout_PF = null;
			objlogin_PF = null;
		}
}
