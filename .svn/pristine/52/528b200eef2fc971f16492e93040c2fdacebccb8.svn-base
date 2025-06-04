package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.accountTransactions_PF;
import com.pageFactory.desktopReception.ballTicketsSold_PF;
import com.pageFactory.desktopReception.bank_PF;
import com.pageFactory.desktopReception.homeNavigations;
import com.pageFactory.desktopReception.login_PF;

public class bank extends BaseTest {

	private bank_PF objbank_PF;
	private accountTransactions_PF objaccountTransactions_PF;
	private login_PF objlogin_PF;
	private homeNavigations objhomeNavigations;

	public void setUpEnviorment()
	{
		initializeWebEnvironment("Neon");
		objbank_PF= new bank_PF(this);
		objaccountTransactions_PF= new accountTransactions_PF(this);
		objlogin_PF = new login_PF(this);
		objhomeNavigations = new homeNavigations(this);	
	}
	@Test
	public void VerifyBankingTab() 
	{
		this.setUpEnviorment();
		objlogin_PF.login();
/*		objbank_PF.navigateToBankingTab();
		objbank_PF.addAmountDetailsAndSave()*/;

		objhomeNavigations.navigateToTransactionsSideBar("Banking");
		objaccountTransactions_PF.verifyAccountType("BANK");
		objaccountTransactions_PF.setAmount("5");
		objaccountTransactions_PF.setComment("Test purpose Only ");
		objaccountTransactions_PF.clickOnSave();

		if(objaccountTransactions_PF.getConfirmationMessage("Process Transaction: Banking"))
			objaccountTransactions_PF.clickOnYes();

		//if(objaccountTransactions_PF.getConfirmationMessage("Transaction completed"))
			objaccountTransactions_PF.clickOnOk();

		objaccountTransactions_PF.verifyNewButtonDisplayed();
		objaccountTransactions_PF.clickOnNewButton();
		objaccountTransactions_PF.clickcloseButton();

	//	objbank_PF.navigateToCashFromBankTab();
	//	objbank_PF.addAmountDetailsAndSave();

		/*	objbank_PF.navigateTocashFloatIssuedTab();
		objbank_PF.addAmountDetailsAndSave();

		objbank_PF.navigateTocashFloatReturnedTab();
		objbank_PF.addAmountDetailsAndSave();*/
		objlogin_PF.logout();	
	}

	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objaccountTransactions_PF = null;
		objlogin_PF = null;
		objhomeNavigations = null;

	}
}