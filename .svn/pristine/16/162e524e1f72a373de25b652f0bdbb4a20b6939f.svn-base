package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.ballyTickets_PF;
import com.pageFactory.desktopReception.login_PF;

public class ballyTickets extends BaseTest {

	private ballyTickets_PF objballyTickets_PF;
	private login_PF objlogin_PF;

	@Test(priority = 0)
	public void VerifyballyTickets()
	{
		initializeWebEnvironment("Neon");
		objballyTickets_PF= new ballyTickets_PF(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();

		/*objballyTickets_PF.navigateToBallyTicketsCountedTab();
		objballyTickets_PF.addAmountDetailsAndSave();
		 */
		// BallyTickets Issued Tab display for Bally club only
		objballyTickets_PF.navigateToBallyTicketsIssuedTab();
		objballyTickets_PF.addAmountDetailsAndSave();

		// BallyTickets Reversal Tab display for Bally club only
		objballyTickets_PF.navigateToballyTicketsIssuedReversalTab();
		objballyTickets_PF.addAmountDetailsAndSave();

		// Bally Tickets Replayed Tab display for Bally club only
		objballyTickets_PF.navigateToBallyTicketsReplayedTab();
		objballyTickets_PF.addAmountDetailsAndSave();

		// Bally Tickets Replayed Reversal Tab display for Bally club only
		objballyTickets_PF.navigateToballyTicketsReplayedReversalTab();
		objballyTickets_PF.addAmountDetailsAndSave();

		// Bally Tickets Write off Tab display for Bally club only
		objballyTickets_PF.navigateToBallyTicketsWriteoffTab();
		objballyTickets_PF.addAmountDetailsAndSave();

		// Bally Tickets Write off Reversal Tab display for Bally club only
		objballyTickets_PF.navigateToBallyTicketsWriteoffReversalTab();
		objballyTickets_PF.addAmountDetailsAndSave();

		objlogin_PF.logout();	

		tearDown();
	}

	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objballyTickets_PF = null;
		objlogin_PF = null;
		
	}


}
