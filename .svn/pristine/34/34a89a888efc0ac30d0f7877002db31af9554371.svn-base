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
import com.pageFactory.desktopReception.login_PF;

public class TC14261_VerifyCustomerCanBeSetToSuspended_EDD extends BaseTest{

	private login_PF objlogin_PF;
	private CustomerProfile_Suspension objCustomerProfile_Suspension ;
	private CommonView objCommonView;

	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");	
		objCustomerProfile_Suspension = new CustomerProfile_Suspension(this);
		objCommonView = new CommonView(this);
		objlogin_PF = new login_PF(this);
	}

	@DataProvider(name = "TestDataProvider")
	public Object[][] getDataProvider(Method method, ITestContext context) {
		Object[][] testData = loadDataProvider(method.getName(), "/CustomerData/EDDCustomerDetails");
		return testData;
	}

	@Title("Test 14261")
	@Description("Verify a customer can be set to Suspended_EDD")
	@Test(dataProvider = "TestDataProvider")
	public void tc14261_SetSuspendedEDDToCustomerProfile(String strRun, Hashtable<String, String> dataSetValue)
	{
		loadTestData(strRun, dataSetValue);
		this.setEnviorment();
		this.setEnviorment();
		objlogin_PF.login();
		objCustomerProfile_Suspension.navigateToCustomerTab();
		objCustomerProfile_Suspension.findCustomerByUsingNumber(getObjUtilities().dpString("CustomerNumber"));
		objCustomerProfile_Suspension.clickOnfindButton();
		objCommonView.setSuspension(getObjUtilities().dpString("Suspension Type"));
		objCommonView.verifyFieldsOnSuspensionScreen();
		objCommonView.verifySuspensionStatusDisplayOnCustomerDetailsPage(getObjUtilities().dpString("Suspension Type"));
		objCustomerProfile_Suspension.closeTab();
	}
	
	@AfterMethod
	private void tearDown(ITestResult result) {
		tearDownWebEnvironment();
		objCustomerProfile_Suspension = null;
		objCommonView = null;
		objlogin_PF = null;
	}
}
