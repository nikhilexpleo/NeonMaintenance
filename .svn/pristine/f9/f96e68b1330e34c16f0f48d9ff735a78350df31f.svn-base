package com.scripts.noen.Reports;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.CustomerProfileTC.CustomerRegistration;
import com.pageFactory.Reports.Report_Registration;
import com.pageFactory.desktopReception.customerProfile_ViewAdd_InterestsNPrefernces_PF;
import com.pageFactory.desktopReception.login_PF;

public class Test6447_ReportRegistrationDeatils extends BaseTest 
{
	private login_PF objlogin_PF;
	private Report_Registration objReport_Registration;
	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");	
		objReport_Registration = new Report_Registration(this);
		objlogin_PF = new login_PF(this);
	}

	@Test
	public void Test6447verifyRegistrationDeatilsReport()
	{
		setEnviorment();
		objlogin_PF.login();
	//	objReport_Registration.setZoomLevel();
		objReport_Registration.clickOnReportTab();
		objReport_Registration.clickORregistrationTab();
		objReport_Registration.clickORegistrationDetailTab();
		objReport_Registration.setDateRange();
	//	objReport_Registration.setDefaultZoomLEvel();
		objReport_Registration.clickOnGenrate();	
		objReport_Registration.verifyAndClickExport();
		objReport_Registration.verifyAndClickExportToExcel();
		objReport_Registration.saveExcel();
	//	objReport_Registration.setDefaultZoomLEvel();
		objReport_Registration.closeButton();
		//objReport_Registration.setDefaultZoomLEvel();
		objlogin_PF.logout();
		objReport_Registration.verifyDataInExcelSheet();
		
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
