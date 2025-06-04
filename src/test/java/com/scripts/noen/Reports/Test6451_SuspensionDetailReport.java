package com.scripts.noen.Reports;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.Reports.Report_Registration;
import com.pageFactory.desktopReception.login_PF;

public class Test6451_SuspensionDetailReport extends BaseTest {
	private login_PF objlogin_PF;
	private Report_Registration objReport_Registration;
	
	
	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");	
		objReport_Registration = new Report_Registration(this);
	
		objlogin_PF = new login_PF(this);
	}

	@Test(priority = 1)
	public void Test6451verifyCurrentSuspensionReport() throws InterruptedException
	{
		setEnviorment();
		objlogin_PF.login();
		//objReport_Registration.setZoomLevel();
		objReport_Registration.clickOnReportTab();
		objReport_Registration.clickOnSuspensionsTab();
		objReport_Registration.clickOnSuspensionDetailReport();
		
		//objReport_Registration.setDefaultZoomLEvel();
		//objReport_Registration.setDateRange();
		objReport_Registration.clickOnGenrate();	
		//objReport_Registration.setDefaultZoomLEvel();
		
		objReport_Registration.verifyAndClickExport();
		objReport_Registration.verifyAndClickExportToExcel();
		objReport_Registration.saveExcel();
	//	objReport_Registration.setDefaultZoomLEvel();
		objReport_Registration.closeButton();
		objlogin_PF.logout();	
		objReport_Registration.verifyLiftedSuspensionReport();
		
		
		/*objReport_Registration.verifyData(3);
		objReport_Registration.compareValue1();*/
		
		
	}
	

	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objReport_Registration = null;
		objlogin_PF = null;
	}


}
