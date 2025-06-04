package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.accountTransactions_PF;
import com.pageFactory.desktopReception.homeNavigations;
import com.pageFactory.desktopReception.login_PF;

public class TC6327_28_BadBeatJackpotCAndReversal  extends BaseTest {

	private accountTransactions_PF objaccountTransactions_PF;
	private login_PF objlogin_PF;
	private homeNavigations objhomeNavigations;
	
	public void setEnviormentVariables()
	{
		initializeWebEnvironment("Neon");
		objaccountTransactions_PF= new accountTransactions_PF(this);
		objlogin_PF = new login_PF(this);
		objhomeNavigations = new homeNavigations(this);	
	}
	
	@Test
	public void verifyBadBeatJackpotCAndReversalTab() throws InterruptedException
	{
		this.setEnviormentVariables();
		objlogin_PF.login();
		objhomeNavigations.navigateToTransactionsSideBar("Bad Beat Jackpot C");
		objaccountTransactions_PF.verifyAccountType("BAD BEAT JACKPOT C");
		objaccountTransactions_PF.setAmount("5");
		objaccountTransactions_PF.setComment("Test purpose Only ");
		objaccountTransactions_PF.clickOnSave();
		
		if(objaccountTransactions_PF.getConfirmationMessage("Process Transaction: Bad Beat Jackpot C"))
		objaccountTransactions_PF.clickOnYes();
		
		//if(objaccountTransactions_PF.getConfirmationMessage("Transaction completed"))
			objaccountTransactions_PF.clickOnOk();
		
		objaccountTransactions_PF.verifyNewButtonDisplayed();
		objaccountTransactions_PF.clickOnNewButton();
		objaccountTransactions_PF.clickcloseButton();
		
		
		objhomeNavigations.navigateToTransactionsSideBar("Bad Beat Jackpot C Reversal");

		objaccountTransactions_PF.verifyAccountType("BAD BEAT JACKPOT C");
		objaccountTransactions_PF.setAmount("5");
		objaccountTransactions_PF.setComment("Test purpose Only ");
		objaccountTransactions_PF.clickOnSave();
		
		if(objaccountTransactions_PF.getConfirmationMessage("Process Transaction: Bad Beat Jackpot C Reversal"))
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
		objhomeNavigations = null;
		objlogin_PF = null ;
	}
	
	
}
