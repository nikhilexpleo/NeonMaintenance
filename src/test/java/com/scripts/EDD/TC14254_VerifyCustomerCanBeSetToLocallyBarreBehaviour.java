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
import com.pageFactory.desktopReception.customer_RegisterAndViewDetails_PF;
import com.pageFactory.desktopReception.login_PF;

public class TC14254_VerifyCustomerCanBeSetToLocallyBarreBehaviour extends BaseTest{
	private login_PF objlogin_PF;
	private CustomerProfile_Suspension objCustomerProfile_Suspension ;
	private CommonView objCommonView;
	private customer_RegisterAndViewDetails_PF objneonReg_PF;

	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");	
		objCustomerProfile_Suspension = new CustomerProfile_Suspension(this);
		objneonReg_PF = new customer_RegisterAndViewDetails_PF(this);
		objCommonView = new CommonView(this);
		objlogin_PF = new login_PF(this);
	}

//	@DataProvider(name = "TestDataProvider")
//	public Object[][] getDataProvider(Method method, ITestContext context) {
//		Object[][] testData = loadDataProvider(method.getName(), "/CustomerData/EDDCustomerDetails");
//		return testData;
//	}

	@Title("Test 14254")
	@Description("Verify a customer can be set to Locally Barred - Behaviour ")
	@Test
	public void tc14254_SetLocallyBarredBehaviourToCustomerProfile()
	{
		//loadTestData(strRun, dataSetValue);
		this.setEnviorment();
		objlogin_PF.login();
		objneonReg_PF.registration();
		objCustomerProfile_Suspension.navigateToCustomerTab();
		objCustomerProfile_Suspension.findCustomerByUsingNumber(objneonReg_PF.custNumber);
		objCustomerProfile_Suspension.clickOnfindButton();
		objCommonView.setSuspension("Locally Barred - Behaviour");
		objCommonView.verifyFieldsOnSuspensionScreen();
		//objCommonView.verifySuspensionStatusDisplayOnCustomerDetailsPage(getObjUtilities().dpString("Suspension Type"));
		//objCustomerProfile_Suspension.closeTab();
		objCommonView.saveSuspension();
	}
	
	@AfterMethod
	private void tearDown(ITestResult result) {
		tearDownWebEnvironment();
		objCustomerProfile_Suspension = null;
		objCommonView = null;
		objlogin_PF = null;
	}
}