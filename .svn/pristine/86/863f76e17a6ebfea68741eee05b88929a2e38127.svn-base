package com.scripts.noen.CashierAndManagerTC;

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
import com.pageFactory.CashierManagerTC.TopNavigation_PlayerTracking;
import com.pageFactory.CustomerProfileTC.MachineCount;
import com.pageFactory.desktopReception.login_PF;

public class Test6686_MachineCount02 extends BaseTest{

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

	@Title("Test6686")
	@Description("Add Electronic Roulette (ER) machine count")
	@Test(dataProvider = "TestDataProvider")
	public void tc6686_AddNewMachineCount(String strRun, Hashtable<String, String> dataSetValue)
	{
		loadTestData(strRun, dataSetValue);
		this.setEnviorment();
		objlogin_PF.login();
		objTopNavigation_PlayerTracking.navigateToMachines();
		objMachineCount.navigateToMachineCountMenu();
		objMachineCount.clickOnMachineNewCountMenu();
		objMachineCount.verifyNClickaddMachineBtn();
	
		objMachineCount.setMachineNumber(getObjUtilities().dpString("Machine Number"));
		objMachineCount.setQuantity();
		objMachineCount.getCount();

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


