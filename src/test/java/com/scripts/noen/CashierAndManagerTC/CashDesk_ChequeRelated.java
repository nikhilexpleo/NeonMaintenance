package com.scripts.noen.CashierAndManagerTC;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Title;

import com.generic.BaseTest;
import com.pageFactory.CashierManagerTC.BalancePage;
import com.pageFactory.CashierManagerTC.SideNavigation_Transaction;
import com.pageFactory.CashierManagerTC.TopNavigation_CashDesk;
import com.pageFactory.CashierManagerTC.TopNavigation_Credit;
import com.pageFactory.desktopReception.login_PF;



public class CashDesk_ChequeRelated extends BaseTest
{
	private TopNavigation_CashDesk objTopNavCashDesk;
	private login_PF objlogin_PF;
	
	@BeforeClass
	private void setUp(){
		
		initializeWebEnvironment("Neon");
	}
	
	@Test
	public void CashDesk_PayWinnerChequeIssueNReplacementCheque()
	{
		//
		objTopNavCashDesk = new TopNavigation_CashDesk(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objTopNavCashDesk.clickTopNavCashDesk();
		objTopNavCashDesk.clickCashDesk_payWinners();	
		objTopNavCashDesk.issueCheque();
		objTopNavCashDesk.issueReplacementCheque();
		objTopNavCashDesk.clickTopNavCashDesk();
		objTopNavCashDesk.redeemCheque();
		objlogin_PF.logout();
		tearDown();
	}
// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objTopNavCashDesk = null;
		objlogin_PF = null;
	
	}
}
