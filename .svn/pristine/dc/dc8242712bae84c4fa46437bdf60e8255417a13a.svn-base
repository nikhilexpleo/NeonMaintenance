package com.scripts.noen.Reports;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.Reports.Report_Registration;
import com.pageFactory.desktopReception.customerProfile_AddSuspendedSuspension_PF;
import com.pageFactory.desktopReception.login_PF;

public class Test6449_CurrentSuspensionReport extends BaseTest {

	private login_PF objlogin_PF;
	private Report_Registration objReport_Registration;
	private customerProfile_AddSuspendedSuspension_PF objcustomerProfile_AddSuspendedSuspension_PF;
	
	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");	
		objReport_Registration = new Report_Registration(this);
		objcustomerProfile_AddSuspendedSuspension_PF= new customerProfile_AddSuspendedSuspension_PF(this);
		objlogin_PF = new login_PF(this);
	}

	@Test(priority = 1)
	public void Test6449verifyCurrentSuspensionReport()
	{
		setEnviorment();
		objlogin_PF.login();
		
		/*objcustomerProfile_AddSuspendedSuspension_PF.navigateToCustomerTab();
		objcustomerProfile_AddSuspendedSuspension_PF.addsuspension();
		objReport_Registration.closeButton();
		*/
		
		//objReport_Registration.setZoomLevel();
		objReport_Registration.clickOnReportTab();
		objReport_Registration.clickOnSuspensionsTab();
		objReport_Registration.clickOnCurrentSuspensionsReportTab();
	//	objReport_Registration.setDefaultZoomLEvel();
		
		objReport_Registration.clickOnGenrate();	
		
		
		objReport_Registration.verifyAndClickExport();
		objReport_Registration.verifyAndClickExportToExcel();
		objReport_Registration.saveExcel();
		objReport_Registration.setDefaultZoomLEvel();
		objReport_Registration.closeButton();
		
		objlogin_PF.logout();
		
		/*objReport_Registration.setDefaultZoomLEvel();
		objlogin_PF.logout();*/
	//objReport_Registration.verifySusoenionReport();
		
		
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
