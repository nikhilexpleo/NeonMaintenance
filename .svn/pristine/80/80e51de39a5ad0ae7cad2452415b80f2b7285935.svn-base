package com.scripts.noen.CashierAndManagerTC;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.CashierManagerTC.TopNavigation_PlayerTracking;
import com.pageFactory.CustomerProfileTC.MachineCount;
import com.pageFactory.desktopReception.login_PF;


public class Test6689_MachineCount05 extends BaseTest{

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

	@Test
	public void tc6689_LatMachineCount()
	{
		this.setEnviorment();
		objlogin_PF.login();
		objTopNavigation_PlayerTracking.navigateToMachines();
		objMachineCount.navigateToMachineCountMenu();
		objMachineCount.clickOnMachineLastCountMenu();
		objMachineCount.clickOnAction();
		objMachineCount.verifyAndClickUpdateReading();
		//objMachineCount.updateReadingToZero();
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
