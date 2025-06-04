package com.scripts.noen.Reports;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.Reports.Report_Registration;
import com.pageFactory.desktopReception.CustomerEntry_UsingDOBName_PF;
import com.pageFactory.desktopReception.login_PF;

public class Test6444_AttendanceDetailReport extends BaseTest {

	private CustomerEntry_UsingDOBName_PF objCustomerEntry_UsingDOBName_PF;
	private login_PF objlogin_PF;
	private Report_Registration objReport_Registration;
	
	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");	
		objReport_Registration = new Report_Registration(this);
		objCustomerEntry_UsingDOBName_PF = new CustomerEntry_UsingDOBName_PF(this);
		objlogin_PF = new login_PF(this);
	}

	@Test
	public void Test6444verifyAttendanceDetailReport()
	{
		setEnviorment();
		objlogin_PF.login();
		objCustomerEntry_UsingDOBName_PF.clickOnCustomerTab();
		objCustomerEntry_UsingDOBName_PF.clickOnreceptionTab();
		objCustomerEntry_UsingDOBName_PF.getvisitorsCount();
		objReport_Registration.closeButton();
		//objReport_Registration.setZoomLevel();
		objReport_Registration.clickOnReportTab();
		objReport_Registration.clickOnAttendenceTab();
		objReport_Registration.clickOnAttendenceDetailReportTab();
		objReport_Registration.setDateRange();
		objReport_Registration.clickOnGenrate();	
		objReport_Registration.verifyAndClickExport();
		objReport_Registration.verifyAndClickExportToExcel();
		objReport_Registration.saveExcel();
		/*objReport_Registration.setDefaultZoomLEvel();
		objlogin_PF.logout();*/
		//objReport_Registration.verifyAttendanceDataInExcelSheet();
//		objReport_Registration.verifyData(3);
//		objReport_Registration.compareValue1();
//		objReport_Registration.setDefaultZoomLEvel();
//		objReport_Registration.closeButton();
		objlogin_PF.logout();
		
	}
	
	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objReport_Registration = null;
		objlogin_PF = null;
		objCustomerEntry_UsingDOBName_PF = null;
	}
}
