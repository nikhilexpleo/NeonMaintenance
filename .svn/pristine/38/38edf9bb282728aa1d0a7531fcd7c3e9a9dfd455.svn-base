package com.scripts.noen.CashierAndManagerTC;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.CashierManagerTC.TopNavigation_Credit;
import com.pageFactory.desktopReception.login_PF;

public class cheque_addViewVoidClear extends BaseTest {

	private TopNavigation_Credit objTopNavCredit;
	private login_PF objlogin_PF;
	//@Title("Register new customer in Neon and Performing  deposit on and off functionality ")
	
	@BeforeClass
	private void setUp(){
		
		initializeWebEnvironment("Neon");
	}	
	@Test(priority = 0)
	public void chequeAddViewVoid()
	{
		
		objTopNavCredit = new TopNavigation_Credit(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objTopNavCredit.clicktopNavigationCredit();
		objTopNavCredit.clickCheque();
		objTopNavCredit.ClickOnAddCheque();
		objTopNavCredit.addCheque();
		objTopNavCredit.viewAndVoidCheque();
		
		objTopNavCredit.clicktopNavigationCredit();
		objTopNavCredit.clickCheque();
		objTopNavCredit.addCheque();
		objTopNavCredit.redeemCheque();	
		objTopNavCredit.chequeClearance();
	//	objlogin_PF.logout();
		
	}
// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		//tearDownWebEnvironment();
		objTopNavCredit = null;
		objlogin_PF= null;
	}
}
