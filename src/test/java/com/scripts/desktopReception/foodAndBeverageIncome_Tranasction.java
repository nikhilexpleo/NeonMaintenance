package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import views.CommonView;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.chipsAddRemove_PF;
import com.pageFactory.desktopReception.foodAndBeverageIncome_Tranasction_PF;
import com.pageFactory.desktopReception.login_PF;

public class foodAndBeverageIncome_Tranasction extends BaseTest{

	private foodAndBeverageIncome_Tranasction_PF objfoodAndBeverageIncome_Tranasction_PF;
	private login_PF objlogin_PF;
	CommonView objCommonView;
	
	public void setEnviormentVariables()
	{
		initializeWebEnvironment("Neon");
		objfoodAndBeverageIncome_Tranasction_PF= new foodAndBeverageIncome_Tranasction_PF(this);
		objlogin_PF = new login_PF(this);
		objCommonView = new CommonView(this);
	}
	@Test
	public void verifyfoodAndBeverageIncomeAccount()
	{
		this.setEnviormentVariables();
		objlogin_PF.login();
		objfoodAndBeverageIncome_Tranasction_PF.navigateToFnBIncomeTab();
		//objfoodAndBeverageIncome_Tranasction_PF.addAmountDetailsAndSave();
		objCommonView.verifyAccountTypeAndSetAmmount("F&B INCOME","1","Process Transaction: F&B Income");
		
		objfoodAndBeverageIncome_Tranasction_PF.navigateToFnBIncomeReversalTab();
	//	objfoodAndBeverageIncome_Tranasction_PF.addAmountDetailsAndSave();
		objCommonView.verifyAccountTypeAndSetAmmount("F&B INCOME","1","Process Transaction: F&B Income Reversal");
		objlogin_PF.logout();	
			
	}
	
	// Closing the browser	
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objCommonView = null;
		objlogin_PF = null;
		objfoodAndBeverageIncome_Tranasction_PF = null;
	}
}
