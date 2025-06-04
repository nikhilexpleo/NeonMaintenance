package com.scripts.noen.Reception.OpeningGamingDay;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.CashierManagerTC.BalancePage;
import com.pageFactory.desktopReception.login_PF;




public class View_OpeningGamingDay extends BaseTest
{
	private BalancePage objBalancePage;
	private login_PF objlogin_PF;
	@BeforeClass
	private void setUp(){
		
		initializeWebEnvironment("Neon");
	}
	
	@Test(priority = 0)
	public void checkBalanceDetails()
	{
		//create New Credit Account
		objBalancePage = new BalancePage(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objBalancePage.viewTransactionOfThroughoutGamingDay();
		objlogin_PF.logout();
		tearDown();
	
		//objTopNavCashDesk.issueReplacementCheque();
	}
// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		//tearDownWebEnvironment();
	
	}
}
