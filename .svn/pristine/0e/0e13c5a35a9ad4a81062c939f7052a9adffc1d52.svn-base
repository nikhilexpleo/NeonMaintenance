package com.scripts.SAWCustomers;

import java.util.Hashtable;
import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;
import views.CommonView;

import com.generic.BaseTest;
import com.pageFactory.EDD.CustomerProfile_Suspension;
import com.pageFactory.desktopReception.customer_RegisterAndViewDetails_PF;
import com.pageFactory.desktopReception.login_PF;

public class verifySAWIconDisplayOnCustomerProfiles extends BaseTest{

	private login_PF objlogin_PF;
	private CustomerProfile_Suspension objCustomerProfile_Suspension ;
	private customer_RegisterAndViewDetails_PF objcustomer_RegisterAndViewDetails_PF;

	//@BeforeClass
	@BeforeMethod
	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");	
		objCustomerProfile_Suspension = new CustomerProfile_Suspension(this);	
		objlogin_PF = new login_PF(this);
		objcustomer_RegisterAndViewDetails_PF = new customer_RegisterAndViewDetails_PF(this);
		objlogin_PF.login();
	}

	@DataProvider(name = "TestDataProvider")
	public Object[][] getDataProvider(ITestContext context) {
		Object[][] testData = loadMultiDataProvider("/CustomerData/SAWCustomerDetails");
		return testData;
	}

	@Title("Verify customer is SAW or Not")
	@Description("Verify customer is SAW or Not ")
	@Test(dataProvider = "TestDataProvider")
	public void tc14252_VerifycustomerisSAWorNot(String CustomerNumber)
	{
		System.setProperty("currentCustomerNum", CustomerNumber);
		/*if(objCustomerProfile_Suspension.checkCloseButtonDisplay())
			{objCustomerProfile_Suspension.closeTab();}*/
		objCustomerProfile_Suspension.navigateToCustomerTab();
		objCustomerProfile_Suspension.findCustomerByUsingNumber(CustomerNumber);
		objCustomerProfile_Suspension.clickOnfindButton();
		objcustomer_RegisterAndViewDetails_PF.verifySAWImageDisplayOrNot();
		objCustomerProfile_Suspension.closeTab();
	}

	//@AfterClass
	@AfterMethod
	private void tearDown() {
		tearDownWebEnvironment();
		objCustomerProfile_Suspension = null;
		objcustomer_RegisterAndViewDetails_PF = null;
		objlogin_PF = null;
	}

}
