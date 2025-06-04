package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.CustomerDueDiligenceFilter_PF;
import com.pageFactory.desktopReception.login_PF;

public class CustomerDueDiligenceFilter extends BaseTest
{

	private CustomerDueDiligenceFilter_PF objCustomerDueDiligenceFilter_PF;
	private login_PF objlogin_PF;


	@Test(priority = 0)
	public void Customer_ManageDueDiligenceFilter()
	{
		initializeWebEnvironment("Neon");
		objCustomerDueDiligenceFilter_PF = new CustomerDueDiligenceFilter_PF(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objCustomerDueDiligenceFilter_PF.NavigateToCustomerTab();
		objCustomerDueDiligenceFilter_PF.clickOnDueDiligence();
		objCustomerDueDiligenceFilter_PF.setFilter();
		objlogin_PF.logout();	


	}
	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();

	}
}
