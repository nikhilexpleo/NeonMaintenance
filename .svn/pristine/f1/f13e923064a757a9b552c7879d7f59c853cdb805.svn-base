package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.accountTransactions_PF;
import com.pageFactory.desktopReception.bank_PF;
import com.pageFactory.desktopReception.homeNavigations;
import com.pageFactory.desktopReception.login_PF;

public class CentralCharityDonationsReversal extends BaseTest {
	
	private bank_PF objbank_PF;
	private login_PF objlogin_PF;
	private accountTransactions_PF objaccountTransactions_PF;
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
	public void VerifyCentralCharityDonationsReversalTab()
	{
		this.setUpEnviorment();	
		objlogin_PF.login();

		objbank_PF.navigateToCentralCharityDonationsTab();
		//objbank_PF.addAmountDetailsAndSave();
		objaccountTransactions_PF.verifyAccountType("CENTRAL CHARITY DONATIONS");
		objaccountTransactions_PF.setAmount("1");
		objaccountTransactions_PF.setComment("Test purpose Only ");
		objaccountTransactions_PF.clickOnSave();

		if(objaccountTransactions_PF.getConfirmationMessage("Process Transaction: Central Charity Donations"))
			objaccountTransactions_PF.clickOnYes();

		//if(objaccountTransactions_PF.getConfirmationMessage("Transaction completed"))
			objaccountTransactions_PF.clickOnOk();

		objaccountTransactions_PF.verifyNewButtonDisplayed();
		objaccountTransactions_PF.clickOnNewButton();
		objaccountTransactions_PF.clickcloseButton();

		
		objbank_PF.navigateToCentralCharityDonationsReversalTab();
	//	objbank_PF.addAmountDetailsAndSave();
		//Central Charity Donations Reversal
		
		objaccountTransactions_PF.verifyAccountType("CENTRAL CHARITY DONATIONS");
		objaccountTransactions_PF.setAmount("1");
		objaccountTransactions_PF.setComment("Test purpose Only ");
		objaccountTransactions_PF.clickOnSave();

		if(objaccountTransactions_PF.getConfirmationMessage("Process Transaction: Central Charity Donations Reversal"))
			objaccountTransactions_PF.clickOnYes();

		//if(objaccountTransactions_PF.getConfirmationMessage("Transaction completed"))
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
		objbank_PF = null; 
		objlogin_PF = null;
	}
}
