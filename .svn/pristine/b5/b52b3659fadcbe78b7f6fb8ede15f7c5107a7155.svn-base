package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import views.CommonView;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.gratuitiesIncomeAccountTranscation_PF;
import com.pageFactory.desktopReception.incentivesRedeemedAndIssued_PF;
import com.pageFactory.desktopReception.login_PF;

public class incentivesRedeemedAndIssued extends BaseTest{
	
	private incentivesRedeemedAndIssued_PF  objincentivesRedeemedAndIssued_PF;
	private login_PF objlogin_PF;
	CommonView objCommonView;
	
	public void setEnviormentVariables()
	{
		initializeWebEnvironment("Neon");
		objincentivesRedeemedAndIssued_PF= new incentivesRedeemedAndIssued_PF(this);
		objlogin_PF = new login_PF(this);
		objCommonView = new CommonView(this);
	}
	
	@Test
	public void VerifyMajorIncentivesRedeemedAndIssued()
	{	
		this.setEnviormentVariables();
		objlogin_PF.login();
		objincentivesRedeemedAndIssued_PF.navigateToMajorPlayerIncentivesIssuedTab();
	//	objincentivesRedeemedAndIssued_PF.addAmountDetailsAndSave();
		objCommonView.verifyAccountTypeAndSetAmmount("MAJOR PLAYER INCENTIVES ","5","Process Transaction: Major Player Incentives Issued");
		objlogin_PF.logout();		
	}
	
	
	// Closing the browser
		@AfterClass
		private void tearDown() 
		{
			tearDownWebEnvironment();
			objlogin_PF = null;
			objCommonView = null;
			objincentivesRedeemedAndIssued_PF = null;
		}
}
