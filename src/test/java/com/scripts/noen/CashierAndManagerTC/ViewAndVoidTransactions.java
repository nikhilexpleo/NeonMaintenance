package com.scripts.noen.CashierAndManagerTC;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Title;

import com.generic.BaseTest;
import com.pageFactory.CashierManagerTC.BalancePage;
import com.pageFactory.desktopReception.login_PF;


public class ViewAndVoidTransactions extends BaseTest
{
	private BalancePage objBalancePage;
	private login_PF objlogin_PF;
	@BeforeClass
	private void setUp(){
		
		initializeWebEnvironment("Neon");
	}
	
	@Test(priority = 0)
	public void verifyBalancePageDetails()
	{

		objBalancePage = new BalancePage(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objBalancePage.viewBalanceCheckDetails();
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
