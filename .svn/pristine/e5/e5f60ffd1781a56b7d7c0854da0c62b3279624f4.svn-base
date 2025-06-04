package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import views.CommonView;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.login_PF;
import com.pageFactory.desktopReception.setupCreditDebit_Transcation_PF;
import com.pageFactory.desktopReception.sundryIncomeExpenses_Transcation_PF;

public class setupCreditDebit_Transcation extends BaseTest{

	private setupCreditDebit_Transcation_PF objsetupCreditDebit_Transcation_PF;
	private login_PF objlogin_PF;
	private CommonView objCommonView;
	
	public void setEnviormentVariables()
	{
		initializeWebEnvironment("Neon");
		objsetupCreditDebit_Transcation_PF= new setupCreditDebit_Transcation_PF(this);
		objlogin_PF = new login_PF(this);
		objCommonView = new CommonView(this);
		objlogin_PF.login();
	}
	@Test
	public void verifySetupCreaditDebit()
	{
		this.setEnviormentVariables();
		objsetupCreditDebit_Transcation_PF.navigateToSetupCreditTab();
		//objsetupCreditDebit_Transcation_PF.addAmountDetailsAndSave();
		objCommonView.verifyAccountTypeAndSetAmmount("SETUP","1","Process Transaction: Setup Credit");



		objsetupCreditDebit_Transcation_PF.navigateTosetupDebitTab();
		//objsetupCreditDebit_Transcation_PF.addAmountDetailsAndSave();
		objCommonView.verifyAccountTypeAndSetAmmount("SETUP","1","Process Transaction: Setup Debit");

		objlogin_PF.logout();	

	}

	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objlogin_PF = null;
		objsetupCreditDebit_Transcation_PF = null;
		objCommonView = null;	
	}
}
