package com.scripts.noen.Reports;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.CustomerProfileTC.EstimatedVisitEntryPOD_PF;
import com.pageFactory.Reports.Report_Registration;
import com.pageFactory.desktopReception.CustomerEntry_UsingDOBName_PF;
import com.pageFactory.desktopReception.customerProfile_ViewAdd_InterestsNPrefernces_PF;
import com.pageFactory.desktopReception.login_PF;

public class Test6446_AttendanceSummarybyHourReport extends BaseTest
{
	private EstimatedVisitEntryPOD_PF objEstimatedVisitEntryPOD_PF;
	private login_PF objlogin_PF;
	private Report_Registration objReport_Registration;
	private customerProfile_ViewAdd_InterestsNPrefernces_PF objcustomerProfile_ViewAdd_InterestsNPrefernces_PF;
	
	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");	
		objReport_Registration = new Report_Registration(this);
		objcustomerProfile_ViewAdd_InterestsNPrefernces_PF = new customerProfile_ViewAdd_InterestsNPrefernces_PF(this);
		objEstimatedVisitEntryPOD_PF = new EstimatedVisitEntryPOD_PF(this);
		objlogin_PF = new login_PF(this);
	}

	@Test
	public void Test6446AttendanceSummarybyHourReport()
	{
		setEnviorment();
		objlogin_PF.login();
		objcustomerProfile_ViewAdd_InterestsNPrefernces_PF.navigateToCustomerMenu();
		objEstimatedVisitEntryPOD_PF.navigateToEstimatedVisitEntry();
		objReport_Registration.getestimatedVisits();
		objReport_Registration.closeButton();
		//objReport_Registration.setZoomLevel();
		objReport_Registration.clickOnReportTab();
		objReport_Registration.clickOnAttendenceTab();
		objReport_Registration.clickOnAttendanceSummaryByHourReportTab();
	//	objReport_Registration.setDefaultZoomLEvel();
		//	objReport_Registration.setDateRange();
		objReport_Registration.clickOnGenrate();	
		objReport_Registration.verifyAndClickExport();
		objReport_Registration.verifyAndClickExportToExcel();
		objReport_Registration.saveExcel();
	//	objReport_Registration.setDefaultZoomLEvel();
		/*objReport_Registration.setDefaultZoomLEvel();
		objlogin_PF.logout();*/
		objReport_Registration.closeButton();
		objlogin_PF.logout();
		objReport_Registration.verifyData(4);
		objReport_Registration.compareValue1();
	}

	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objReport_Registration = null;
		objEstimatedVisitEntryPOD_PF = null;
		objlogin_PF = null;
	}
}
