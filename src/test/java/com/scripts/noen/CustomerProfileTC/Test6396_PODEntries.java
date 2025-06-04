package com.scripts.noen.CustomerProfileTC;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.CustomerProfileTC.EstimatedVisitEntryPOD_PF;
import com.pageFactory.CustomerProfileTC.custProfile_SettingPin_PF;
import com.pageFactory.desktopReception.customerProfile_ViewAdd_InterestsNPrefernces_PF;
import com.pageFactory.desktopReception.login_PF;

public class Test6396_PODEntries extends BaseTest
{
	private EstimatedVisitEntryPOD_PF objEstimatedVisitEntryPOD_PF;
	private custProfile_SettingPin_PF objcustProfile_SettingPin_PF;
	private customerProfile_ViewAdd_InterestsNPrefernces_PF objcustomerProfile_ViewAdd_InterestsNPrefernces_PF;
	private login_PF objlogin_PF;
	
	
	public void setEnviorment()
	{
		objEstimatedVisitEntryPOD_PF = new EstimatedVisitEntryPOD_PF(this);
		objcustomerProfile_ViewAdd_InterestsNPrefernces_PF = new customerProfile_ViewAdd_InterestsNPrefernces_PF(this);
		objcustProfile_SettingPin_PF = new custProfile_SettingPin_PF(this);
		objlogin_PF = new login_PF(this);
	}

	@Test
	public void verifyTest6396_PODEntries()
	{
		initializeWebEnvironment("Neon");	
		setEnviorment();
		objlogin_PF.login();
		objcustomerProfile_ViewAdd_InterestsNPrefernces_PF.navigateToCustomerMenu();
		objEstimatedVisitEntryPOD_PF.navigateToEstimatedVisitEntry();
		objEstimatedVisitEntryPOD_PF.verifyHoursLabel();
		objEstimatedVisitEntryPOD_PF.verifyVisitsLabel();
		objEstimatedVisitEntryPOD_PF.verifyLeaversLabel();
		objEstimatedVisitEntryPOD_PF.setGamingDate();
		objEstimatedVisitEntryPOD_PF.setVisits();
		objcustProfile_SettingPin_PF.clickOnSave();
		objEstimatedVisitEntryPOD_PF.closeTab();
		objlogin_PF.logout();	
	}

	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objcustomerProfile_ViewAdd_InterestsNPrefernces_PF = null;
		objcustProfile_SettingPin_PF = null;
		objEstimatedVisitEntryPOD_PF = null;
		objlogin_PF = null;
	}
	
}
