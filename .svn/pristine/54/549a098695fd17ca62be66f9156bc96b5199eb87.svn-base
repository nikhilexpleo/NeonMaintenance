package com.scripts.noen.CashierAndManagerTC;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.CashierManagerTC.TopNavigation_PlayerTracking;
import com.pageFactory.CustomerProfileTC.MachineCount;
import com.pageFactory.desktopReception.login_PF;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

public class Test6685_MachineCount extends BaseTest
{
	private login_PF objlogin_PF;
	private TopNavigation_PlayerTracking objTopNavigation_PlayerTracking;
	private MachineCount objMachineCount;

	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");
		objTopNavigation_PlayerTracking = new TopNavigation_PlayerTracking(this);
		objMachineCount = new MachineCount(this);
		objlogin_PF = new login_PF(this);
	}

	@DataProvider(name = "TestDataProvider")
	public Object[][] getDataProvider(Method method, ITestContext context) {
		Object[][] testData = loadDataProvider(method.getName(), "/CustomerData/CustomerDetails");
		return testData;
	}

	@Title("Test 6685 and 6687")
	@Description("Add new machine count")
	@Test(dataProvider = "TestDataProvider")
	public void tc6685_AddNewMachineCount(String strRun, Hashtable<String, String> dataSetValue)
	{
		loadTestData(strRun, dataSetValue);
		this.setEnviorment();
		objlogin_PF.login();
		objTopNavigation_PlayerTracking.navigateToMachines();
		objMachineCount.navigateToMachineCountMenu();
		objMachineCount.clickOnMachineNewCountMenu();
		objMachineCount.verifyNClickaddMachineBtn();
		//	Test #6687 -Manager_Electronic Gaming and Machine Count_003 
		objMachineCount.setMachineNumber("fsdf");
		objMachineCount.verifymachineNotFoundMsg();
		//Test6685
		objMachineCount.setMachineNumber(getObjUtilities().dpString("Machine Number"));
		/*objMachineCount.setQuantity();
		objMachineCount.getCount();*/
		//

		objMachineCount.clickOnCommit();
		objlogin_PF.logout();
	}

	@AfterMethod()
	private void tearDown(ITestResult result) 
	{
		tearDownWebEnvironment();
		objMachineCount =  null;
		objlogin_PF = null;
	}
}
