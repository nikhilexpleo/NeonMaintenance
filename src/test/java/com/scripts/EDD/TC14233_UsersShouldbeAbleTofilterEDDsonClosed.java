package com.scripts.EDD;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import com.generic.BaseTest;
import com.pageFactory.EDD.CustomerProfile_Suspension;
import com.pageFactory.desktopReception.CustomerDueDiligenceFilter_PF;
import com.pageFactory.desktopReception.login_PF;

public class TC14233_UsersShouldbeAbleTofilterEDDsonClosed extends BaseTest{
	private CustomerDueDiligenceFilter_PF objCustomerDueDiligenceFilter_PF;
	private login_PF objlogin_PF;
	private CustomerProfile_Suspension objCustomerProfile_Suspension ;
	
	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");	
		objCustomerDueDiligenceFilter_PF = new CustomerDueDiligenceFilter_PF(this);
		objCustomerProfile_Suspension = new CustomerProfile_Suspension(this);
		objlogin_PF = new login_PF(this);
	}	

	@Title("Test 14233")
	@Description("Users should be able to filter EDD's on Closed ")
	@Test
	public void tc14233_SetActualLossValueCanbeEnteredWhenCreatingManualEDDRecord()
	{
		this.setEnviorment();
		objlogin_PF.login();
		objCustomerDueDiligenceFilter_PF.NavigateToCustomerTab();
		objCustomerDueDiligenceFilter_PF.clickOnDueDiligence();
		
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Casino");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Date Range");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("From");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("To");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Number");
		
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("State");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Status");
		objCustomerProfile_Suspension.verifyLabelsOnSuspensionScreens("Reason For Creation");
		
		objCustomerDueDiligenceFilter_PF.selectDateRange("This Month");
		objCustomerDueDiligenceFilter_PF.selectState("Closed");
		objCustomerDueDiligenceFilter_PF.clickONFilter();
		objCustomerDueDiligenceFilter_PF.verifyDueDiligenceFilterTableHeaders();
		objCustomerDueDiligenceFilter_PF.verifySearchResultDisplayAsPerSearchCirteria("Due Diligence State","Closed");
		
	}
	
	@AfterMethod
	private void tearDown(ITestResult result) {
		tearDownWebEnvironment();
		objCustomerProfile_Suspension = null;
		objCustomerDueDiligenceFilter_PF = null;
		objlogin_PF = null;
	}
}
