package com.scripts.noen.CashierAndManagerTC;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Title;

import com.generic.BaseTest;
import com.pageFactory.CashierManagerTC.BalancePage;
import com.pageFactory.CashierManagerTC.SideNavigation_Transaction;
import com.pageFactory.desktopReception.login_PF;



public class PokerAccountONAndOFF extends BaseTest
{
	private SideNavigation_Transaction objSideNaviTrans;
	private login_PF objlogin_PF;
	//@Title("Register new customer in Neon and Performing  deposit on and off functionality ")
	
	@BeforeClass
	private void setUp(){
		
		initializeWebEnvironment("Neon");
	}
	
	@Test(priority = 0)
	public void PokerAccountONAndOFF()
	{
		
		objSideNaviTrans = new SideNavigation_Transaction(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objSideNaviTrans.clickSideTransaction();
		objSideNaviTrans.pokervoucherON();
		objSideNaviTrans.functionPoker();
		
		objSideNaviTrans.pokervoucherOFF();
		objSideNaviTrans.functionPoker();
		objlogin_PF.logout();
		//tearDown();
	
	
	}
// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
	
	}
}
