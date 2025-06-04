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
import com.pageFactory.CashierManagerTC.TopNavigation_View;
import com.pageFactory.desktopReception.login_PF;



public class View_Authorizations_AlarmsAlerts extends BaseTest
{
	private TopNavigation_View objTopNavView;
	private login_PF objlogin_PF;
	//@Title("Register new customer in Neon and Performing  deposit on and off functionality ")
	
	@BeforeClass
	private void setUp(){
		
		initializeWebEnvironment("Neon");
	}
	
	@Test(priority = 0)
	public void checkView_Authorizations_AlarmsAlerts()
	{
		//create New Credit Account
		objTopNavView = new TopNavigation_View(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objTopNavView.viewAndConfirmAuthorizations();
	//	objTopNavView.viewAlarms();
		objTopNavView.viewAlerts();
		objlogin_PF.logout();
		
	}
// Closing the browser
	@AfterClass
	private void tearDown() 
	{
	//tearDownWebEnvironment();
	objlogin_PF = null;
	objTopNavView = null;
	}
}
