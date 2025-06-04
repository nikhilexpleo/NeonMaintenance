package com.scripts.noen.Reports;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.LEOTables.TopNavigation_TableAccounting;
import com.pageFactory.Reports.Report_Registration;
import com.pageFactory.desktopReception.CustomerEntry_UsingDOBName_PF;
import com.pageFactory.desktopReception.login_PF;

public class Test6300_TableDailyResultsReport extends BaseTest{

	private login_PF objlogin_PF;
	private Report_Registration objReport_Registration;
	private TopNavigation_TableAccounting objTableAccounting;
	
	public void setEnviorment()
	{
		initializeWebEnvironment("Neon");	
		objReport_Registration = new Report_Registration(this);
		objTableAccounting = new TopNavigation_TableAccounting(this);
		objlogin_PF = new login_PF(this);
	}

	@Test
	public void verifyTest6300TableDailyResultsReport ()
	{
		setEnviorment();
		objlogin_PF.login();
		
		objTableAccounting.NavigateToTableAccountingTab();
		objTableAccounting.clickOnTableFill();
		objReport_Registration.tableAddAndRemoveAsset();
		objTableAccounting.CloseTab();
	
		//objReport_Registration.setZoomLevel();
		objReport_Registration.clickOnReportTab();
		objReport_Registration.clickOnTablesTab();
		objReport_Registration.clickOnTableDailyResultsReportTab();
		//objReport_Registration.setDefaultZoomLEvel();
		
		objReport_Registration.clickOnGenrate();	
	
		objReport_Registration.verifyAndClickExport();
		objReport_Registration.verifyAndClickExportToExcel();
		objReport_Registration.saveExcel();
	//	objReport_Registration.setDefaultZoomLEvel();
		objlogin_PF.logout();
		
		objReport_Registration.verifyTableDataINexcel();
		objReport_Registration.compareValue1();
	
	}
	

	
	// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
		objReport_Registration = null;
		objlogin_PF = null;
		objTableAccounting  = null;
	}

}
