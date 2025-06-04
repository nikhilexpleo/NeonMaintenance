package com.scripts.noen.CashierAndManagerTC;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Title;

import com.generic.BaseTest;
import com.pageFactory.CashierManagerTC.BalancePage;
import com.pageFactory.CashierManagerTC.SideNavigation_Transaction;
import com.pageFactory.CashierManagerTC.TopNavigation_Credit;
import com.pageFactory.desktopReception.login_PF;



public class CreditAccountTestCases extends BaseTest
{
	private TopNavigation_Credit objTopNavCredit;
	private login_PF objlogin_PF;
	
	@Title(" Create new Credit account")

	@BeforeClass
	private void setUp(){

		initializeWebEnvironment("Neon");
	}

	@Test
	public void addCreditBankDeatils_CreditAccountTC()
	{

		objTopNavCredit = new TopNavigation_Credit(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		//create New Credit Account
		objTopNavCredit.clicktopNavigationCredit();		
		objTopNavCredit.clickcredit_CreditAccounts();
		objTopNavCredit.clickCreditAccounts_CreateNewButton();
		objTopNavCredit.creditAccounts_CreateNewAccount();
		objTopNavCredit.close();
		//Add bank Account
		objTopNavCredit.clicktopNavigationCredit();		
		objTopNavCredit.clickcredit_CreditAccounts();
		objTopNavCredit.creditAccounts_AddBankAccount();
		objlogin_PF.logout();

	}
	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objTopNavCredit = null;
		objlogin_PF = null;

	}
}
