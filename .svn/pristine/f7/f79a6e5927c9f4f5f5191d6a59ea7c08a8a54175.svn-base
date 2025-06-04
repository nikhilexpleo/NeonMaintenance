package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.accountTransactions_PF;
import com.pageFactory.desktopReception.directCrediToAccount_PF;
import com.pageFactory.desktopReception.homeNavigations;
import com.pageFactory.desktopReception.login_PF;

public class directCrediToAccount extends BaseTest{
	private directCrediToAccount_PF objdirectCrediToAccount_PF;
	private login_PF objlogin_PF;
	private accountTransactions_PF objaccountTransactions_PF;
	private homeNavigations objhomeNavigations;
	
	public void setEnviormentVariables()
	{
		initializeWebEnvironment("Neon");
		objaccountTransactions_PF= new accountTransactions_PF(this);
		objdirectCrediToAccount_PF= new directCrediToAccount_PF(this);
		objhomeNavigations = new homeNavigations(this);	
		objlogin_PF = new login_PF(this);		
	}
	
	@Test
	public void verifyDirectCrediToAccountTab() throws InterruptedException
	{
		this.setEnviormentVariables();
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objdirectCrediToAccount_PF.navigateTodirectCreditToAccountTab();
	//	objdirectCrediToAccount_PF.addAmountDetailsAndSave();
		
		objaccountTransactions_PF.verifyAccountType("BANK");
		objaccountTransactions_PF.setAmount("1");
		objaccountTransactions_PF.setComment("Test purpose Only ");
		objaccountTransactions_PF.clickOnSave();
		
		if(objaccountTransactions_PF.getConfirmationMessage("This customer has not visited today. Do you wish to continue?"))
			objaccountTransactions_PF.clickOnYes();
		
		if(objaccountTransactions_PF.getConfirmationMessage("Process Transaction: Direct Customer Credit To LinkCo Account"))
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