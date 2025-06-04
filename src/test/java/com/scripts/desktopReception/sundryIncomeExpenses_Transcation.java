package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import views.CommonView;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.ballTicketsSold_PF;
import com.pageFactory.desktopReception.foodAndBeverageIncome_Tranasction_PF;
import com.pageFactory.desktopReception.login_PF;
import com.pageFactory.desktopReception.sundryIncomeExpenses_Transcation_PF;

public class sundryIncomeExpenses_Transcation extends BaseTest{

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
	public void VerifysundryIncomeExpenses()
	{
		this.setEnviormentVariables();
		objlogin_PF.login();
		objsundryIncomeExpenses_Transcation_PF.navigateTosundryIncomeTab();
		//objsundryIncomeExpenses_Transcation_PF.addAmountDetailsAndSave();
		objCommonView.verifyAccountTypeAndSetAmmount("SUNDRY INCOME","1","Process Transaction: Sundry Income");

		objsundryIncomeExpenses_Transcation_PF.navigateToSundryIncomeReversalTab();
		//objsundryIncomeExpenses_Transcation_PF.addAmountDetailsAndSave();
		objCommonView.verifyAccountTypeAndSetAmmount("SUNDRY INCOME","1","Process Transaction: Sundry Income Reversal");
		
		/*objsundryIncomeExpenses_Transcation_PF.navigateToSundryCostsTab();
		//objsundryIncomeExpenses_Transcation_PF.addAmountDetailsAndSave();
		objCommonView.verifyAccountTypeAndSetAmmount("Sundry Costs","1","Process Transaction: Sundry Costs");
		
		objsundryIncomeExpenses_Transcation_PF.navigateToSundryCostsReversalTab();
		//objsundryIncomeExpenses_Transcation_PF.addAmountDetailsAndSave();
		objCommonView.verifyAccountTypeAndSetAmmount("Sundry Costs","1","Process Transaction: Sundry Costs Reversal");
		*/
		
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

