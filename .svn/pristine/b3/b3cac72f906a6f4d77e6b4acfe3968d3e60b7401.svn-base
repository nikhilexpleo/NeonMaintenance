package com.scripts.noen.CashierAndManagerTC;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Title;

import com.generic.BaseTest;
import com.pageFactory.CashierManagerTC.BalancePage;
import com.pageFactory.CashierManagerTC.SideNavigation_Transaction;
import com.pageFactory.CashierManagerTC.TransactionPage;
import com.pageFactory.desktopReception.login_PF;



public class ViewAndvoidTransactionFromViews extends BaseTest
{
	private TransactionPage objTransPage;
	private login_PF objlogin_PF;
	@BeforeClass
	private void setUp(){
		
		initializeWebEnvironment("Neon");
	}
	
	@Test(priority = 0)
	public void checkViewAndvoidTransactionFromViews()
	{
		
		objTransPage = new TransactionPage(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objTransPage.goToTransactionsList();
		objTransPage.viewAndVoidTransaction();
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
