package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.ballyTickets_PF;
import com.pageFactory.desktopReception.login_PF;

public class ballyTicketsCounted extends BaseTest
{
	private ballyTickets_PF objballyTickets_PF;
	private login_PF objlogin_PF;

	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");
		objballyTickets_PF= new ballyTickets_PF(this);
		objlogin_PF = new login_PF(this);
	}
	
	@Test
	public void VerifyballyTickets()
	{
		setEnviorment();
		objlogin_PF.login();	
		objballyTickets_PF.navigateToBallyTicketsCountedTab();
		objballyTickets_PF.addAmountDetailsAndSave();
		objlogin_PF.logout();	
	}

	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objlogin_PF = null;
		objballyTickets_PF = null;

	}

}
