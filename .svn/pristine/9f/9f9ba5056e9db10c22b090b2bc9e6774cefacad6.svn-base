package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import views.CommonView;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.login_PF;
import com.pageFactory.desktopReception.sundryIncomeExpenses_Transcation_PF;

public class Test6368_69_SundryExpensesAndReversal extends BaseTest{
	private	sundryIncomeExpenses_Transcation_PF objsundryIncomeExpenses_Transcation_PF;
	private login_PF objlogin_PF;

	CommonView objCommonView;

	public void setEnviormentVariables()
	{
		initializeWebEnvironment("Neon");
		objsundryIncomeExpenses_Transcation_PF= new sundryIncomeExpenses_Transcation_PF(this);
		objlogin_PF = new login_PF(this);
		objCommonView = new CommonView(this);
	}
	
	@Test
	public void VerifySundryExpensesAndReversal()
	{
		this.setEnviormentVariables();
		objlogin_PF.login();
		objsundryIncomeExpenses_Transcation_PF.navigateToSundryCostsTab();
		//objsundryIncomeExpenses_Transcation_PF.addAmountDetailsAndSave();
		objCommonView.verifyAccountTypeAndSetAmmount("Sundry Costs","1","Process Transaction: Sundry Costs");
		
		objsundryIncomeExpenses_Transcation_PF.navigateToSundryCostsReversalTab();
		//objsundryIncomeExpenses_Transcation_PF.addAmountDetailsAndSave();
		objCommonView.verifyAccountTypeAndSetAmmount("Sundry Costs","1","Process Transaction: Sundry Costs Reversal");	
		objlogin_PF.logout();
	}

	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objlogin_PF = null;
		objCommonView = null;
		objsundryIncomeExpenses_Transcation_PF = null;
	}
}
