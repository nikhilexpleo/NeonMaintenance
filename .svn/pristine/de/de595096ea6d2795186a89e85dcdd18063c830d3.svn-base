package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.issueNewCard_LostAndReplacementCard_PF;
import com.pageFactory.desktopReception.login_PF;

public class issueNewCard_LostAndReplacementCard extends BaseTest{
	
	private issueNewCard_LostAndReplacementCard_PF objissueNewCard_LostAndReplacementCard_PF;
	private login_PF objlogin_PF;
	
	@Test(priority = 0)
	public void issueNew_LostAndReplacementCardToCustomer()
	{
		initializeWebEnvironment("Neon");	
		objissueNewCard_LostAndReplacementCard_PF= new issueNewCard_LostAndReplacementCard_PF(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objissueNewCard_LostAndReplacementCard_PF.navigateToCustomerTab();
		objissueNewCard_LostAndReplacementCard_PF.findCustomer();
		objissueNewCard_LostAndReplacementCard_PF.issueNewCard_lostCard();
		objissueNewCard_LostAndReplacementCard_PF.issueNewCard_ReplacementCard();
		objissueNewCard_LostAndReplacementCard_PF.closeTab();
		objlogin_PF.logout();	
		tearDown();
	}
	
	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
	
	}
}
