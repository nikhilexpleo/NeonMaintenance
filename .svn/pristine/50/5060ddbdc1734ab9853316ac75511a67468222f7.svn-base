package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Title;

import com.generic.BaseTest;
import com.pageFactory.CashierManagerTC.TopNavigation_Credit;
import com.pageFactory.desktopReception.login_PF;

public class CreditTransactions001  extends BaseTest
{

	private TopNavigation_Credit objTopNavCredit;
	private login_PF objlogin_PF;
	

	@BeforeClass
	private void setUp(){

		initializeWebEnvironment("Neon");
	}
	@Title(" Add debit card as Electronic")
	@Test
	public void addDebitCardAsElectronic()
	{

		objTopNavCredit = new TopNavigation_Credit(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		
		//Add Debit card
		objTopNavCredit.clicktopNavigationCredit();	
		objTopNavCredit.ClickOnDebitCardMenu();
		objTopNavCredit.clickOnAddDebitCard();
		objTopNavCredit.addDebitCard("Electronic");
		objTopNavCredit.close();

		/*objTopNavCredit.clicktopNavigationCredit();	
		objTopNavCredit.clickOnAddDebitCard();
		objTopNavCredit.addDebitCard("Manual");
		objTopNavCredit.addDebitCardForSameCard();

		objTopNavCredit.clicktopNavigationCredit();	
		objTopNavCredit.NavigteToViewDebitCards();
		objTopNavCredit.viewAndVoidDebitCard();*/
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
