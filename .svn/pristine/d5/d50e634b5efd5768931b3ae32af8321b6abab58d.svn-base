package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import views.CommonView;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.bank_PF;
import com.pageFactory.desktopReception.login_PF;
import com.pageFactory.desktopReception.sundryIncomeExpenses_Transcation_PF;

public class cashFloatIssuedReturnedTab extends BaseTest {
	private bank_PF objbank_PF;
	private login_PF objlogin_PF;
	CommonView objCommonView;

	public void setEnviormentVariables()
	{
		initializeWebEnvironment("Neon");
		objbank_PF= new bank_PF(this);
		objlogin_PF = new login_PF(this);
		objCommonView = new CommonView(this);
	}
	@Test
	public void VerifycashFloatIssuedReturnedTab()
	{
		this.setEnviormentVariables();
		objlogin_PF.login();
		objbank_PF.navigateTocashFloatIssuedTab();
		//objbank_PF.addAmountDetailsAndSave();
		objCommonView.verifyAccountTypeAndSetAmmount("CASH FLOATS","5","Process Transaction: Cash Float Issued");
		
		objbank_PF.navigateTocashFloatReturnedTab();
	//	objbank_PF.addAmountDetailsAndSave();
		objCommonView.verifyAccountTypeAndSetAmmount("CASH FLOATS","5","Process Transaction: Cash Float Returned");

		//objlogin_PF.logout();	
	}

	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objlogin_PF = null;
		objCommonView = null;
		objbank_PF= null;
	}

}
