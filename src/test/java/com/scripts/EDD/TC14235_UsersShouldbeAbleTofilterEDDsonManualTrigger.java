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
import views.CommonView;

import com.generic.BaseTest;
import com.pageFactory.EDD.CustomerProfile_Suspension;
import com.pageFactory.desktopReception.CustomerDueDiligenceFilter_PF;
import com.pageFactory.desktopReception.login_PF;

public class TC14235_UsersShouldbeAbleTofilterEDDsonManualTrigger extends BaseTest{
	private CustomerDueDiligenceFilter_PF objCustomerDueDiligenceFilter_PF;
	private login_PF objlogin_PF;
	private CustomerProfile_Suspension objCustomerProfile_Suspension ;
	private CommonView objCommonView;

	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");	
		objCustomerDueDiligenceFilter_PF = new CustomerDueDiligenceFilter_PF(this);
		objCustomerProfile_Suspension = new CustomerProfile_Suspension(this);
		objlogin_PF = new login_PF(this);
		objCommonView = new CommonView(this);
	}

	@DataProvider(name = "TestDataProvider")
	public Object[][] getDataProvider(Method method, ITestContext context) {
		Object[][] testData = loadDataProvider(method.getName(), "/CustomerData/EDDCustomerDetails");
		return testData;
	}

	@Title("Test 14235")
	@Description("Users should be able to filter EDD's on Complete")
	@Test(dataProvider = "TestDataProvider")
	public void tc14231_filterEDDRecordsByComplete(String strRun, Hashtable<String, String> dataSetValue)
	{
		loadTestData(strRun, dataSetValue);
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

		//objCustomerDueDiligenceFilter_PF.selectDateRange("This Calendar Quarter");
		objCustomerDueDiligenceFilter_PF.selectStatus("Manual");
		objCustomerDueDiligenceFilter_PF.clickONFilter();
		objCustomerDueDiligenceFilter_PF.verifyDueDiligenceFilterTableHeaders();
		objCustomerDueDiligenceFilter_PF.verifySearchResultDisplayAsPerSearchCirteria("Number",getObjUtilities().dpString("CustomerNumber"));
		//objCustomerDueDiligenceFilter_PF.verifySearchResultDisplayAsPerSearchCirteria("Number","1955207144");
	}

	@AfterMethod
	private void tearDown(ITestResult result) {
		tearDownWebEnvironment();
		objCustomerProfile_Suspension = null;
		objCustomerDueDiligenceFilter_PF = null;
		objlogin_PF = null;
	}
}