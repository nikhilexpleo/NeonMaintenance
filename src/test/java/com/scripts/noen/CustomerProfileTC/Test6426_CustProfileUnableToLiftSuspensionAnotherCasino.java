package com.scripts.noen.CustomerProfileTC;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.CustomerProfileTC.CustProfile_EditSuspensionAnotherCasino_PF;
import com.pageFactory.desktopReception.customerProfile_AddEditViewBarredSuspension_PF;
import com.pageFactory.desktopReception.customerProfile_AddSuspendedSuspension_PF;
import com.pageFactory.desktopReception.customerProfile_ViewAdd_InterestsNPrefernces_PF;
import com.pageFactory.desktopReception.login_PF;

public class Test6426_CustProfileUnableToLiftSuspensionAnotherCasino extends BaseTest
{

	private CustProfile_EditSuspensionAnotherCasino_PF  objCustProfile_EditSuspensionAnotherCasino_PF ;
	private customerProfile_ViewAdd_InterestsNPrefernces_PF objcustomerProfile_ViewAdd_InterestsNPrefernces_PF;
	private login_PF objlogin_PF;
	private customerProfile_AddSuspendedSuspension_PF objcustomerProfile_AddSuspendedSuspension_PF;
	private customerProfile_AddEditViewBarredSuspension_PF objcustomerProfile_AddEditViewBarredSuspension_PF;

	public void setEnviorment()
	{
		objCustProfile_EditSuspensionAnotherCasino_PF = new CustProfile_EditSuspensionAnotherCasino_PF(this);
		objcustomerProfile_ViewAdd_InterestsNPrefernces_PF = new customerProfile_ViewAdd_InterestsNPrefernces_PF(this);
		objcustomerProfile_AddEditViewBarredSuspension_PF = new customerProfile_AddEditViewBarredSuspension_PF(this);
		objcustomerProfile_AddSuspendedSuspension_PF =new customerProfile_AddSuspendedSuspension_PF(this); 
		objlogin_PF = new login_PF(this);
	}

	@Test
	public void verifyTest6426CustProfile_UnableToLiftSuspensionAnotherCasino()
	{
		initializeWebEnvironment("Neon");	
		setEnviorment();
		objlogin_PF.login();
		objcustomerProfile_ViewAdd_InterestsNPrefernces_PF.navigateToCustomerTab();
		objCustProfile_EditSuspensionAnotherCasino_PF.getGamingClub();
		objCustProfile_EditSuspensionAnotherCasino_PF.selectCasino();
		objCustProfile_EditSuspensionAnotherCasino_PF.selectSuspendedCheckBox();
		objCustProfile_EditSuspensionAnotherCasino_PF.findCustomer();
		objCustProfile_EditSuspensionAnotherCasino_PF.clickOnDetails();
		objcustomerProfile_AddSuspendedSuspension_PF.clickSuspensionsTab();
		objcustomerProfile_AddSuspendedSuspension_PF.clickOnLift();
		//objCustProfile_EditSuspensionAnotherCasino_PF.verifyLiftMessage();
		objCustProfile_EditSuspensionAnotherCasino_PF.clickONOkButton();	
		objlogin_PF.logout();	
	}

	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objcustomerProfile_ViewAdd_InterestsNPrefernces_PF = null;	
		objCustProfile_EditSuspensionAnotherCasino_PF = null;
		objcustomerProfile_AddSuspendedSuspension_PF = null;
		objcustomerProfile_AddEditViewBarredSuspension_PF = null;	
		objlogin_PF = null;
	}

}
