package com.scripts.noen.CustomerProfileTC;

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
import com.pageFactory.CustomerProfileTC.CustomerRegistration;
import com.pageFactory.desktopReception.customerProfile_ViewAdd_InterestsNPrefernces_PF;
import com.pageFactory.desktopReception.login_PF;

public class Test6389_91_CustDBMatched extends BaseTest {

	private CustomerRegistration objCustomerRegistration;
	private customerProfile_ViewAdd_InterestsNPrefernces_PF objcustomerProfile_ViewAdd_InterestsNPrefernces_PF;
	private login_PF objlogin_PF;

	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");	
		objCustomerRegistration = new CustomerRegistration(this);
		objcustomerProfile_ViewAdd_InterestsNPrefernces_PF = new customerProfile_ViewAdd_InterestsNPrefernces_PF(this);
		objlogin_PF = new login_PF(this);
	}


	@DataProvider(name = "TestDataProvider")
	public Object[][] getDataProvider(Method method, ITestContext context) {
		Object[][] testData = loadDataProvider(method.getName(), "/CustomerData/CustomerDetails");
		return testData;
	}

	@Title("Test6389/91")
	@Description("Normal Registration")
	@Test(dataProvider = "TestDataProvider")
	public void tc6389_NormalRegistration(String strRun, Hashtable<String, String> dataSetValue)
	{
		loadTestData(strRun, dataSetValue);
		this.setEnviorment();
		objlogin_PF.login();
		objcustomerProfile_ViewAdd_InterestsNPrefernces_PF.navigateToCustomerMenu();
		objCustomerRegistration.clickOnRegistration();
		objCustomerRegistration.registration(getObjUtilities().dpString("DateOfBirth"), getObjUtilities().dpString("Name"),
				getObjUtilities().dpString("Postcode"),getObjUtilities().dpString("StreetAddress"), getObjUtilities().dpString("City"),
				getObjUtilities().dpString("Telephone"),getObjUtilities().dpString("Email Id"),getObjUtilities().dpString("CustomerNumber"));
		objCustomerRegistration.clickOnMatchButton();
		objCustomerRegistration.verifyMessageDisplay();
		//objCustomerRegistration.verifyElementDisplayInDisableMode();
		objlogin_PF.logout();
	}

	@AfterMethod()
	private void tearDown(ITestResult result) 
	{
		tearDownWebEnvironment();
		objCustomerRegistration =  null;
		objlogin_PF = null;

	}

}
