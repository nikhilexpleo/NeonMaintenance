package com.scripts.noen.CashierAndManagerTC;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Title;

import com.generic.BaseTest;
import com.pageFactory.CashierManagerTC.TopNavigation_Credit;
import com.pageFactory.desktopReception.login_PF;

public class AddDebitCardManualSameCard extends BaseTest{

	private TopNavigation_Credit objTopNavCredit;
	private login_PF objlogin_PF;
	@Title(" Add/view/void debit card")
	@BeforeClass
	private void setUp(){

		initializeWebEnvironment("Neon");
		objTopNavCredit = new TopNavigation_Credit(this);
		objlogin_PF = new login_PF(this);
	}

	@Test(priority=1)
	public void VerifyAddDebitCardManualSameCard()
	{
		objlogin_PF.login();	
		//Add Debit card
		objTopNavCredit.clicktopNavigationCredit();	
		objTopNavCredit.ClickOnDebitCardMenu();
		objTopNavCredit.clickOnAddDebitCard();
		objTopNavCredit.addDebitCard("Manual");
		objTopNavCredit.addDebitCardForSameCard();

		/*objTopNavCredit.clicktopNavigationCredit();	
		objTopNavCredit.NavigteToViewDebitCards();
		objTopNavCredit.viewAndVoidDebitCard();
		//objlogin_PF.logout();
*/
	}
	@Test(priority=2)
	public void ViewVoidDebitCard()
	{

		objTopNavCredit.clicktopNavigationCredit();	
		objTopNavCredit.NavigteToViewDebitCards();
		objTopNavCredit.viewAndVoidDebitCard();
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
