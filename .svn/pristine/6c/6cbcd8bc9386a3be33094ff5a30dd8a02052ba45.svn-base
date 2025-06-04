package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import views.CommonView;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.gratuitiesIncomeAccountTranscation_PF;
import com.pageFactory.desktopReception.login_PF;
import com.pageFactory.desktopReception.pettyCashIssuedRepaid_Transcation_PF;

public class pettyCashIssuedRepaid_Transcation extends BaseTest {

	private pettyCashIssuedRepaid_Transcation_PF objpettyCashIssuedRepaid_Transcation_PF;
	private login_PF objlogin_PF;
	CommonView objCommonView;

	public void setEnviormentVariables()
	{
		initializeWebEnvironment("Neon");
		objpettyCashIssuedRepaid_Transcation_PF= new pettyCashIssuedRepaid_Transcation_PF(this);
		objlogin_PF = new login_PF(this);
		objCommonView = new CommonView(this);
	}

	
	@Test
	public void verifyPettyCashIssuedRepaid()
	{
		this.setEnviormentVariables();
		objlogin_PF.login();

		objpettyCashIssuedRepaid_Transcation_PF.navigateToPettyCashIssuedTab();
		//objpettyCashIssuedRepaid_Transcation_PF.addAmountDetailsAndSave();
		objCommonView.verifyAccountTypeAndSetAmmount("PETTY CASH EXPENDITURE","1","Process Transaction: Petty Cash Issued");
		
		objpettyCashIssuedRepaid_Transcation_PF.navigateToPettyCashRepaidTab();
		//objpettyCashIssuedRepaid_Transcation_PF.addAmountDetailsAndSave();
		objCommonView.verifyAccountTypeAndSetAmmount("PETTY CASH EXPENDITURE","1","Process Transaction: Petty Cash Repaid");
		
		objlogin_PF.logout();	


	}
	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objlogin_PF = null;
		objCommonView = null;
		objpettyCashIssuedRepaid_Transcation_PF = null;
	}
}
