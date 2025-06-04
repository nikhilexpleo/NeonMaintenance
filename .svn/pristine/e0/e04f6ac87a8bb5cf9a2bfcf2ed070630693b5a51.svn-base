package com.scripts.noen.LEO_Tables;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Title;

import com.generic.BaseTest;
import com.pageFactory.CashierManagerTC.BalancePage;
import com.pageFactory.CashierManagerTC.SideNavigation_Transaction;
import com.pageFactory.CashierManagerTC.TopNavigation_CashDesk;
import com.pageFactory.CashierManagerTC.TopNavigation_Credit;
import com.pageFactory.LEOTables.TopNavigation_TableAccounting;
import com.pageFactory.desktopReception.login_PF;



public class LEO_TableAccounting_RegisterVisitInPIT extends BaseTest
{
	private TopNavigation_TableAccounting objTopNavTableAcc;
	private login_PF objlogin_PF;
	//@Title("Register new customer in Neon and Performing  deposit on and off functionality ")
	
	@BeforeClass
	private void setUp(){
		
		initializeWebEnvironment("Neon");
	}
	
	@Test(priority = 0)
	public void checkBalanceDetails()
	{
		//create New Credit Account
		objTopNavTableAcc = new TopNavigation_TableAccounting(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();	
	//	objTopNavCashDesk.importCurrencyRate();
	//	objTopNavCashDesk.redeemCurrency();
		objTopNavTableAcc.registerVisitInPIT();
		//objTopNavCashDesk.issueReplacementCheque();
		objlogin_PF.logout();
		
	}
// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objTopNavTableAcc = null;
		objlogin_PF= null;
	}
}
