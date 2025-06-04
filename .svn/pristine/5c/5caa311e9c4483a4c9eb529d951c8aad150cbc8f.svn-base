package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.ballTicketsSold_PF;
import com.pageFactory.desktopReception.login_PF;

public class ballyTicketSold extends BaseTest {

	private ballTicketsSold_PF objballTicketsSold_PF;
	private login_PF objlogin_PF;
	
	@Test
	public void VerifyballyTicketsSoldTab()
	{
		initializeWebEnvironment("Neon");
		objballTicketsSold_PF= new ballTicketsSold_PF(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objballTicketsSold_PF.clickOnTransaction();
		objballTicketsSold_PF.navigateToBallyTicketsSoldTab();
		objballTicketsSold_PF.addAmountDetailsAndSave();
		objballTicketsSold_PF.navigateToBallyTicketsSoldReversalTab();
		objballTicketsSold_PF.addAmountDetailsAndSave();
		objlogin_PF.logout();	
		
	}
	
	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		//tearDownWebEnvironment();
		objballTicketsSold_PF = null;
		objlogin_PF = null;
	}
}