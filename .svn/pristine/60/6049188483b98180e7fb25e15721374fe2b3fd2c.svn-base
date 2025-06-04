package com.scripts.noen.Reception.OpeningGamingDay;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Title;

import com.generic.BaseTest;
import com.pageFactory.CashierManagerTC.BalancePage;
import com.pageFactory.CashierManagerTC.SideNavigation_Transaction;
import com.pageFactory.CashierManagerTC.TopNavigation_CashDesk;
import com.pageFactory.CashierManagerTC.TopNavigation_Credit;
import com.pageFactory.CashierManagerTC.TopNavigation_View;
import com.pageFactory.LEOTables.TopNavigation_TableAccounting;
import com.pageFactory.desktopReception.login_PF;



public class TableAccounting_TableFillAddAsset extends BaseTest
{
	private TopNavigation_TableAccounting objTableAccounting;
	private login_PF objlogin_PF;
	//@Title("Register new customer in Neon and Performing  deposit on and off functionality ")
	
	@BeforeClass
	private void setUp(){	
		initializeWebEnvironment("Neon");
	}
	
	@Test
	public void verifyTableFillAndCredit()
	{
		objTableAccounting = new TopNavigation_TableAccounting(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objTableAccounting.NavigateToTableAccountingTab();
		objTableAccounting.clickOnTableFill();
		objTableAccounting.tableAddAndRemoveAsset();
		objTableAccounting.CloseTab();
		objTableAccounting.NavigateToTableAccountingTab();
		objTableAccounting.clickOnTabeleCreadit();
		objTableAccounting.tableAddAndRemoveAsset();
		objTableAccounting.CloseTab();		
		objlogin_PF.logout();
		
	
		//objTopNavCashDesk.issueReplacementCheque();
	}
// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objTableAccounting =null;
		objlogin_PF =null;
	}
}
