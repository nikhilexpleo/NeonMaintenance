package com.scripts.noen.CustomerProfileTC;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.CashierManagerTC.TopNavigation_CashDesk;
import com.pageFactory.CustomerProfileTC.custProfile_SettingPin_PF;
import com.pageFactory.desktopReception.customerProfile_ViewAdd_InterestsNPrefernces_PF;
import com.pageFactory.desktopReception.login_PF;

public class Test6440_SettingPinNumber extends BaseTest{

	private custProfile_SettingPin_PF objcustProfile_SettingPin_PF;
	private customerProfile_ViewAdd_InterestsNPrefernces_PF objcustomerProfile_ViewAdd_InterestsNPrefernces_PF;
	private TopNavigation_CashDesk objTopNavigation_CashDesk;
	private login_PF objlogin_PF;

	public void setEnviorment()
	{
		objcustProfile_SettingPin_PF = new custProfile_SettingPin_PF(this);
		objcustomerProfile_ViewAdd_InterestsNPrefernces_PF = new customerProfile_ViewAdd_InterestsNPrefernces_PF(this);
		objTopNavigation_CashDesk = new TopNavigation_CashDesk(this);
		objlogin_PF = new login_PF(this);
	}

	@Test
	public void setPinNumber()
	{
		initializeWebEnvironment("Neon");	
		setEnviorment();
		objlogin_PF.login();
		objcustomerProfile_ViewAdd_InterestsNPrefernces_PF.navigateToCustomerTab();
		objcustomerProfile_ViewAdd_InterestsNPrefernces_PF.findCustomer();
		objcustomerProfile_ViewAdd_InterestsNPrefernces_PF.clickOnActionButton();
		objcustProfile_SettingPin_PF.verifySetPin();
		objcustProfile_SettingPin_PF.ClickSetPin();
		objTopNavigation_CashDesk.verifyCustomerNameLabelDisplyed();
		objTopNavigation_CashDesk.verifyAndGetCustomerNameValue();
		objcustProfile_SettingPin_PF.verifyCustomerNumberLabelDisplyed();
		objcustProfile_SettingPin_PF.verifyAndGetCustomerNumberValue();
//		objTopNavigation_CashDesk.verifyDOBLabelDisplayed();
//		objTopNavigation_CashDesk.verifyAndGetDOBValue();
		objcustProfile_SettingPin_PF.verifyPinLabel();
		objcustProfile_SettingPin_PF.verifyConfirmPinLabel();
		objcustProfile_SettingPin_PF.setPinLabel("1456");
		objcustProfile_SettingPin_PF.setConfirmPinLabel("1234");
		objcustProfile_SettingPin_PF.clickOnSave();
		objcustProfile_SettingPin_PF.verifyErrormessage();
		objcustProfile_SettingPin_PF.clickOnOk();
		objcustProfile_SettingPin_PF.setPinLabel("1234");
		objcustProfile_SettingPin_PF.setConfirmPinLabel("1234");
		objcustProfile_SettingPin_PF.clickOnSave();
		objcustomerProfile_ViewAdd_InterestsNPrefernces_PF.closeTab();
		objlogin_PF.logout();	
		tearDown();
	}

	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objcustomerProfile_ViewAdd_InterestsNPrefernces_PF = null;
		objcustProfile_SettingPin_PF = null;
		objlogin_PF = null;
	}

}
