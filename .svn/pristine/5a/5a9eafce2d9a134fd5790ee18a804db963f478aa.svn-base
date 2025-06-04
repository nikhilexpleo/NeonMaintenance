package com.scripts.noen.Reports;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.Reports.Report_Registration;
import com.pageFactory.desktopReception.customer_RegisterAndViewDetails_PF;
import com.pageFactory.desktopReception.login_PF;

public class Test6448_RegistrationSummaryReport extends BaseTest{
	private login_PF objlogin_PF;
	private Report_Registration objReport_Registration;
	private customer_RegisterAndViewDetails_PF objneonReg_PF;
	
	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");	
		objReport_Registration = new Report_Registration(this);
		objneonReg_PF = new customer_RegisterAndViewDetails_PF(this);
		objlogin_PF = new login_PF(this);
	}

	@Test(priority = 0)
	public void Test6448verifyRegistrationSummaryReport()
	{
		setEnviorment();
		objlogin_PF.login();
		//objReport_Registration.setZoomLevel();
		objReport_Registration.clickOnReportTab();
		objReport_Registration.clickORregistrationTab();
		objReport_Registration.clickORegistrationSummaryReportTab();
	//	objReport_Registration.setDefaultZoomLEvel();
		objReport_Registration.setDateRange();
		objReport_Registration.clickOnGenrate();	
		objReport_Registration.verifyAndClickExport();
		objReport_Registration.verifyAndClickExportToExcel();
		objReport_Registration.saveExcel();
	//	objReport_Registration.setDefaultZoomLEvel();
		objReport_Registration.closeButton();
		objlogin_PF.logout();
		objReport_Registration.verifyData(4);
		objReport_Registration.updateNumber();
	//	objReport_Registration.setDefaultZoomLEvel();
		tearDown();
		
	/*	objReport_Registration.setDefaultZoomLEvel();
		objReport_Registration.closeButton();
		
		objneonReg_PF.registration();
		objReport_Registration.closeButton();
		
		objReport_Registration.setZoomLevel();
		objReport_Registration.clickOnReportTab();
		objReport_Registration.clickORregistrationTab();
		objReport_Registration.clickORegistrationSummaryReportTab();
		objReport_Registration.setDateRange();
		objReport_Registration.clickOnGenrate();	
		objReport_Registration.verifyAndClickExport();
		objReport_Registration.verifyAndClickExportToExcel();
		objReport_Registration.saveExcel();
		objReport_Registration.closeWind();
		objReport_Registration.setDefaultZoomLEvel();
		objlogin_PF.logout();
		objReport_Registration.verifyData(4);
		objReport_Registration.compareValue();*/
	}

	@Test(priority = 1)
	public void reportregister()
	{
		setEnviorment();
		objlogin_PF.login();
		objneonReg_PF.registration();
		objlogin_PF.logout();
		tearDown();
		
	}

	@Test(priority = 2)
	public void Test6448verifyReportRegistrationSummaryReport()
	{
		setEnviorment();
		objlogin_PF.login();
		objReport_Registration.setZoomLevel();
		objReport_Registration.clickOnReportTab();
		objReport_Registration.clickORregistrationTab();
		objReport_Registration.clickORegistrationSummaryReportTab();
		objReport_Registration.setDefaultZoomLEvel();
		objReport_Registration.setDateRange();
		objReport_Registration.clickOnGenrate();	
		objReport_Registration.verifyAndClickExport();
		objReport_Registration.verifyAndClickExportToExcel();
		objReport_Registration.saveExcel();	
		objReport_Registration.closeButton();
		objReport_Registration.setDefaultZoomLEvel();
		objlogin_PF.logout();
		objReport_Registration.verifyData(4);
		objReport_Registration.compareValue();
		
	}

	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objReport_Registration = null;
		objneonReg_PF = null;
		objlogin_PF = null;
	}
}
