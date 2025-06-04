package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.accountTransactions_PF;
import com.pageFactory.desktopReception.bank_PF;
import com.pageFactory.desktopReception.homeNavigations;
import com.pageFactory.desktopReception.login_PF;

public class Test6342_CashFromBank extends BaseTest {

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
	public void VerifyCashFromBankTab() throws InterruptedException
	{
		this.setUpEnviorment();
		objlogin_PF.login();
		objhomeNavigations.navigateToTransactionsSideBar("Cash From Bank");
		objaccountTransactions_PF.verifyAccountType("BANK");
		objaccountTransactions_PF.setAmount("1");
		objaccountTransactions_PF.setComment("Test purpose Only ");
		objaccountTransactions_PF.clickOnSave();

		if(objaccountTransactions_PF.getConfirmationMessage("Process Transaction: Cash From Bank"))
			objaccountTransactions_PF.clickOnYes();

	//	if(objaccountTransactions_PF.getConfirmationMessage("Transaction completed"))
			objaccountTransactions_PF.clickOnOk();

		objaccountTransactions_PF.verifyNewButtonDisplayed();
		objaccountTransactions_PF.clickOnNewButton();
		objaccountTransactions_PF.clickcloseButton();
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
