package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import views.CommonView;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.chipsAddRemove_PF;
import com.pageFactory.desktopReception.foodAndBeverageIncome_Tranasction_PF;
import com.pageFactory.desktopReception.gratuitiesIncomeAccountTranscation_PF;
import com.pageFactory.desktopReception.login_PF;

public class gratuitiesIncomeAccountTranscation extends BaseTest{
	

	private gratuitiesIncomeAccountTranscation_PF objgratuitiesIncomeAccountTranscation_PF;
	private login_PF objlogin_PF;
	CommonView objCommonView;
	
	public void setEnviormentVariables()
	{
		initializeWebEnvironment("Neon");
		objgratuitiesIncomeAccountTranscation_PF= new gratuitiesIncomeAccountTranscation_PF(this);
		objlogin_PF = new login_PF(this);
		objCommonView = new CommonView(this);
	}
	
	@Test
	public void verifygratuitiesIncomeAccoun()
	{
		this.setEnviormentVariables();	
		objlogin_PF.login();
		objgratuitiesIncomeAccountTranscation_PF.navigateTogratuitiesTroncTab();
		//objgratuitiesIncomeAccountTranscation_PF.addAmountDetailsAndSave();
		objCommonView.verifyAccountTypeAndSetAmmount("GRATUITIES","1","Process Transaction: Gratuities - Tronc");
		
		objgratuitiesIncomeAccountTranscation_PF.navigateTogratuitiesTroncReversalTab();
		//objgratuitiesIncomeAccountTranscation_PF.addAmountDetailsAndSave();
		objCommonView.verifyAccountTypeAndSetAmmount("GRATUITIES","1","Process Transaction: Gratuities - Tronc Reversal");
		
		/*objgratuitiesIncomeAccountTranscation_PF.navigateTogratuitiesNonTroncTab();
		objgratuitiesIncomeAccountTranscation_PF.addAmountDetailsAndSave();*/
		objlogin_PF.logout();		
	}
	
	
	// Closing the browser
		@AfterClass
		private void tearDown() 
		{
			tearDownWebEnvironment();
			objlogin_PF = null;
			objCommonView = null;
			objgratuitiesIncomeAccountTranscation_PF = null;
		}
}
