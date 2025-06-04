package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.ErrorOverUnderAccountTranscation_PF;
import com.pageFactory.desktopReception.accountTransactions_PF;
import com.pageFactory.desktopReception.bank_PF;
import com.pageFactory.desktopReception.homeNavigations;
import com.pageFactory.desktopReception.login_PF;

public class errorOverUnderAccountTranscation extends BaseTest {


	private ErrorOverUnderAccountTranscation_PF objErrorOverUnderAccountTranscation_PF;
	private login_PF objlogin_PF;
	private accountTransactions_PF objaccountTransactions_PF;
	private homeNavigations objhomeNavigations;
	
	public void setUpEnviorment()
	{
		initializeWebEnvironment("Neon");
		objErrorOverUnderAccountTranscation_PF= new ErrorOverUnderAccountTranscation_PF(this);
		objaccountTransactions_PF= new accountTransactions_PF(this);
		objlogin_PF = new login_PF(this);
		objhomeNavigations = new homeNavigations(this);	
	}
	@Test
	public void addAmount_ErrorOverAndUnderAccount() 
	{
		this.setUpEnviorment();
		objlogin_PF.login();
		objErrorOverUnderAccountTranscation_PF.navigateToErrorOverTab();
		//objErrorOverUnderAccountTranscation_PF.addAmountDetailsAndSave();
		objaccountTransactions_PF.verifyAccountType("ERROR ACCOUNT");
		objaccountTransactions_PF.setAmount("4");
		objaccountTransactions_PF.setComment("Test purpose Only ");
		objaccountTransactions_PF.clickOnSave();

		if(objaccountTransactions_PF.getConfirmationMessage("Process Transaction: Error Over"))
			objaccountTransactions_PF.clickOnYes();

		//if(objaccountTransactions_PF.getConfirmationMessage("Transaction completed"))
			objaccountTransactions_PF.clickOnOk();

		objaccountTransactions_PF.verifyNewButtonDisplayed();
		objaccountTransactions_PF.clickOnNewButton();
		objaccountTransactions_PF.clickcloseButton();
		
		
		
		objErrorOverUnderAccountTranscation_PF.navigateToErrorUnderTab();
		//objErrorOverUnderAccountTranscation_PF.addAmountDetailsAndSave();
		objaccountTransactions_PF.verifyAccountType("ERROR ACCOUNT");
		objaccountTransactions_PF.setAmount("4");
		objaccountTransactions_PF.setComment("Test purpose Only ");
		objaccountTransactions_PF.clickOnSave();

		if(objaccountTransactions_PF.getConfirmationMessage("Process Transaction: Error Under"))
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
		
		}
}
