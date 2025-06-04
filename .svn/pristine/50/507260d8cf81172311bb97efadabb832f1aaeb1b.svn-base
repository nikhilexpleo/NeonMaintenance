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



public class AddViewAndDeleteThirdPartyBankAccount extends BaseTest
{
	private TopNavigation_Credit objTopNavCredit;
	private login_PF objlogin_PF;


	@Title("Add/view/Delete third party account in Neon")
	public void setEnviormentVariables()
	{
		objTopNavCredit = new TopNavigation_Credit(this);
		objlogin_PF = new login_PF(this);
	}
	@BeforeClass
	private void setUp(){

		initializeWebEnvironment("Neon");
	}

	@Test
	public void checkAddViewAndDeleteThirdPartyBankAccount() throws InterruptedException 
	{
		setEnviormentVariables();
		objlogin_PF.login();
		//Create /add Third party account
		objTopNavCredit.clicktopNavigationCredit();
		objTopNavCredit.clickcredit_thirdPartyAccount();
		objTopNavCredit.clickthirdPartyAcc_CreateNewButton();
		objTopNavCredit.createthirdPartyAcc();
		//delete and view  Third party account details
		objTopNavCredit.clicktopNavigationCredit();
		objTopNavCredit.clickcredit_thirdPartyAccount();
		objTopNavCredit.viewThirdPartyAccountDetails();
		objTopNavCredit.deleteCreatedThirdPartyAccount();
		objlogin_PF.logout();
		tearDown();

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
