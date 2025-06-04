package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.accountTransactions_PF;
import com.pageFactory.desktopReception.homeNavigations;
import com.pageFactory.desktopReception.login_PF;

public class accountTransction extends BaseTest {

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
	public void verifyBadBeatJackpotBC() throws InterruptedException
	{
		this.setEnviormentVariables();
		objlogin_PF.login();
		
		/*objaccountTransactions_PF.navigateToTranscationATab();
		objaccountTransactions_PF.addAmountAndSave();
		
		objaccountTransactions_PF.navigateTransationAReversalTab();
		objaccountTransactions_PF.addAmountAndSave();*/
		
	/*	objhomeNavigations.navigateToTransactionsSideBar("Bad Beat Jackpot B Reversal");
	//	objaccountTransactions_PF.navigateTransationBReversalTab();
		objaccountTransactions_PF.addAmountAndSave();
		
		objhomeNavigations.navigateToTransactionsSideBar("Bad Beat Jackpot C");
		//	objaccountTransactions_PF.navigateTransationBReversalTab();
		//objaccountTransactions_PF.navigateToTranscationCTab();
		objaccountTransactions_PF.addAmountAndSave();
		
		objhomeNavigations.navigateToTransactionsSideBar("Bad Beat Jackpot C Reversal");
		//	objaccountTransactions_PF.navigateTransationBReversalTab();
	//	objaccountTransactions_PF.navigateTransationCReversalTab();
		objaccountTransactions_PF.addAmountAndSave();*/
		
		
		
		
		
		
		
		objhomeNavigations.navigateToTransactionsSideBar("Bad Beat Jackpot B");
		objaccountTransactions_PF.verifyAccountType("BAD BEAT JACKPOT B");
		objaccountTransactions_PF.setAmount("5");
		objaccountTransactions_PF.setComment("Test purpose Only ");
		objaccountTransactions_PF.clickOnSave();
		
		if(objaccountTransactions_PF.getConfirmationMessage("Process Transaction: Bad Beat Jackpot B"))
		objaccountTransactions_PF.clickOnYes();
		
		//objaccountTransactions_PF.getConfirmationMessage("Transaction completed");
		objaccountTransactions_PF.clickOnOk();
		
		objaccountTransactions_PF.verifyNewButtonDisplayed();
		objaccountTransactions_PF.clickOnNewButton();
		objaccountTransactions_PF.clickcloseButton();
		
		
		objhomeNavigations.navigateToTransactionsSideBar("Bad Beat Jackpot B Reversal");

		objaccountTransactions_PF.verifyAccountType("BAD BEAT JACKPOT B");
		objaccountTransactions_PF.setAmount("5");
		objaccountTransactions_PF.setComment("Test purpose Only ");
		objaccountTransactions_PF.clickOnSave();
		
		if(objaccountTransactions_PF.getConfirmationMessage("Process Transaction: Bad Beat Jackpot B Reversal"))
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
		objaccountTransactions_PF = null;
	}
	
	
}
