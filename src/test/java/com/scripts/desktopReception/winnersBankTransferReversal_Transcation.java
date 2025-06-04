package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.accountTransactions_PF;
import com.pageFactory.desktopReception.login_PF;
import com.pageFactory.desktopReception.winnersBankTransferReversal_Transcation_PF;

public class winnersBankTransferReversal_Transcation extends BaseTest {

	private	winnersBankTransferReversal_Transcation_PF objwinnersBankTransferReversal_Transcation_PF;
	private login_PF objlogin_PF;
	private accountTransactions_PF objaccountTransactions_PF; 

	public void setEnviormentVariables()
	{
		initializeWebEnvironment("Neon");
		objwinnersBankTransferReversal_Transcation_PF= new winnersBankTransferReversal_Transcation_PF(this);
		objlogin_PF = new login_PF(this);
		objaccountTransactions_PF = new accountTransactions_PF(this);
	}
	@Test
	public void VerifyWinnersBankTransferTranscation() throws InterruptedException
	{
		this.setEnviormentVariables();
		objlogin_PF.login();
		objwinnersBankTransferReversal_Transcation_PF.navigateTowinnersBankTransferTab();
		//	objwinnersBankTransferReversal_Transcation_PF.addAmountDetailsAndSave();
		objwinnersBankTransferReversal_Transcation_PF.setAmount("2");
		objaccountTransactions_PF.setComment("Test purpose Only ");
		objwinnersBankTransferReversal_Transcation_PF.setBankNameAndsetSwiftCode();
		objaccountTransactions_PF.clickOnSave();

		if(objaccountTransactions_PF.getConfirmationMessage("This customer has not visited today. Do you wish to continue?"))
			
		{objaccountTransactions_PF.clickOnYes();}

		//if(objaccountTransactions_PF.getConfirmationMessage("Process Transaction: Winners Bank Transfer"))
		{objaccountTransactions_PF.clickOnYes();}

		//if(objaccountTransactions_PF.getConfirmationMessage("Transaction completed"))
		{objaccountTransactions_PF.clickOnOk();}


		objwinnersBankTransferReversal_Transcation_PF.getReferenceNumber();
		objaccountTransactions_PF.verifyNewButtonDisplayed();
		objaccountTransactions_PF.clickOnNewButton();
		objaccountTransactions_PF.clickcloseButton();



		objwinnersBankTransferReversal_Transcation_PF.winnersBankTransferReversalTranscation();
		objaccountTransactions_PF.setComment("Test purpose Only");
		objaccountTransactions_PF.clickOnSave();

		//if(objaccountTransactions_PF.getConfirmationMessage("This person has no visit record for today. Generate a visit for this customer?"))
		{objaccountTransactions_PF.clickOnYes();}

		//if(objaccountTransactions_PF.getConfirmationMessage("Process Transaction: Winners Bank Transfer Reversal"))
		{objaccountTransactions_PF.clickOnYes();}

		//if(objaccountTransactions_PF.getConfirmationMessage("Transaction completed"))
		{objaccountTransactions_PF.clickOnOk();}


		objwinnersBankTransferReversal_Transcation_PF.getReferenceNumber();
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
		objwinnersBankTransferReversal_Transcation_PF = null;
		objaccountTransactions_PF = null;
		objlogin_PF = null;
	}
}
