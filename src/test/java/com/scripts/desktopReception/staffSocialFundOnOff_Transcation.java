package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import views.CommonView;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.login_PF;
import com.pageFactory.desktopReception.pettyCashIssuedRepaid_Transcation_PF;
import com.pageFactory.desktopReception.staffSocialFundOnOff_Transcation_PF;

public class staffSocialFundOnOff_Transcation extends BaseTest {
	
	private staffSocialFundOnOff_Transcation_PF objstaffSocialFundOnOff_Transcation_PF;
	private login_PF objlogin_PF;
	CommonView objCommonView;

	public void setEnviormentVariables()
	{
		initializeWebEnvironment("Neon");
		objstaffSocialFundOnOff_Transcation_PF= new staffSocialFundOnOff_Transcation_PF(this);
		objlogin_PF = new login_PF(this);
		objCommonView = new CommonView(this);
	}
	
	@Test
	public void verifystaffSocialFundOnOffTranscation()
	{
		this.setEnviormentVariables();
		objlogin_PF.login();
		
		objstaffSocialFundOnOff_Transcation_PF.navigateTostaffSocialFundOnTab();
	//	objstaffSocialFundOnOff_Transcation_PF.addAmountDetailsAndSave();
		objCommonView.verifyAccountTypeAndSetAmmount("STAFF SOCIAL FUND","1","Process Transaction: Staff Social Fund On");
		
		objstaffSocialFundOnOff_Transcation_PF.navigateTostaffSocialFundOffTab();
	//	objstaffSocialFundOnOff_Transcation_PF.addAmountDetailsAndSave();
		objCommonView.verifyAccountTypeAndSetAmmount("STAFF SOCIAL FUND","1","Process Transaction: Staff Social Fund Off");
		
		objlogin_PF.logout();		
	}
	
	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objlogin_PF = null;
		objCommonView = null;
		objstaffSocialFundOnOff_Transcation_PF = null;
	}
}
