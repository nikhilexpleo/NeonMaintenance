package com.scripts.noen.CashierAndManagerTC;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Title;

import com.generic.BaseTest;
import com.pageFactory.CashierManagerTC.BalancePage;
import com.pageFactory.desktopReception.login_PF;


public class BalanceDetailsVerification extends BaseTest
{
	private BalancePage objBalancePage;
	private login_PF objlogin_PF;

	@BeforeClass
	private void setUp(){
		
		initializeWebEnvironment("Neon");
	}
	
	@Test
	public void checkAndVerifyViewsTransactionOfThroughoutGamingDay()
	{
		
		objBalancePage = new BalancePage(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objBalancePage.viewTransactionOfThroughoutGamingDay();
		objlogin_PF.logout();
		
	}
// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objBalancePage = null;
		objlogin_PF = null;
	}
}
