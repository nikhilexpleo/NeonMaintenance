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



public class ReturnedCheque extends BaseTest
{
	private TopNavigation_Credit objTopNavCredit;
	private login_PF objlogin_PF;
	//@Title("Register new customer in Neon and Performing  deposit on and off functionality ")
	
	@BeforeClass
	private void setUp(){
		
		initializeWebEnvironment("Neon");
	}
	
	@Test
	public void checkReturnedCheque()
	{
		//create New Credit Account
		objTopNavCredit = new TopNavigation_Credit(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objTopNavCredit.returnedUnpaidChequeFromBank();
		objlogin_PF.logout();
		
	}
// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objlogin_PF = null;
		objTopNavCredit = null;
	}
}
