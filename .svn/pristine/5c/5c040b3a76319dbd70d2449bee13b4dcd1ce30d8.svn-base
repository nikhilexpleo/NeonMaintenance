package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.customerProfile_ViewAdd_InterestsNPrefernces_PF;
import com.pageFactory.desktopReception.login_PF;

public class customerProfile_ViewAdd_InterestsNPrefernces extends BaseTest{

	private customerProfile_ViewAdd_InterestsNPrefernces_PF objcustomerProfile_ViewAdd_InterestsNPrefernces_PF;
	private login_PF objlogin_PF;
	
	@Test(priority = 0)
	public void verifyViewAddInterestsNPrefernces()
	{
		initializeWebEnvironment("Neon");	
		objcustomerProfile_ViewAdd_InterestsNPrefernces_PF= new customerProfile_ViewAdd_InterestsNPrefernces_PF(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objcustomerProfile_ViewAdd_InterestsNPrefernces_PF.navigateToCustomerTab();
		objcustomerProfile_ViewAdd_InterestsNPrefernces_PF.findCustomer();
		objcustomerProfile_ViewAdd_InterestsNPrefernces_PF.clickOnActionButton();
		objcustomerProfile_ViewAdd_InterestsNPrefernces_PF.addInterestsNPrefernces();
		objcustomerProfile_ViewAdd_InterestsNPrefernces_PF.viewInterestsNPrefernces();
		objcustomerProfile_ViewAdd_InterestsNPrefernces_PF.closeTab();
		objlogin_PF.logout();	
		tearDown();
	}
	
	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objlogin_PF = null;
		objcustomerProfile_ViewAdd_InterestsNPrefernces_PF = null;
		
	}
}
