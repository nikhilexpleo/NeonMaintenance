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
import com.pageFactory.desktopReception.login_PF;



public class ExchangeTravellersCheque extends BaseTest
{
	private TopNavigation_CashDesk objTopNavigation_CashDesk;
	private login_PF objlogin_PF;

	@BeforeClass
	private void setUp(){
		
		initializeWebEnvironment("Neon");
	}
	
	@Test(priority = 0)
	public void exchangeTravellersCheque() throws InterruptedException
	{
		//create New Credit Account
		objTopNavigation_CashDesk = new TopNavigation_CashDesk(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objTopNavigation_CashDesk.exchangeTravellersCheque();
		objlogin_PF.logout();
		tearDown();
	}
// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		//tearDownWebEnvironment();
		objTopNavigation_CashDesk = null;
		objlogin_PF = null;
	}
}
