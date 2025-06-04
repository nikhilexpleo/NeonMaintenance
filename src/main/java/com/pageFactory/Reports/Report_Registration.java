package com.pageFactory.Reports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;

import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;


public class Report_Registration {

	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	Properties objConfig=new Properties();
	String message="",custNumber="";
	String NeonUser,NeonPass,env;
	String user = "", cellData, value;
	static String refId_FE = "", refId_BE,date,conDate,vistorCnt1,tableNm,tableFillValue;
	private Pojo objPojo;

	public Report_Registration(Pojo pojo)
	{
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		objPojo = pojo;
		pojo.getObjConfig();
		NeonUser=pojo.getNeonUser();
		NeonPass=pojo.geNeonPassword();	
		custNumber =pojo.getUser();
		System.out.println(" custNumber = " +custNumber);
	}
	private By ReportsTab=By.xpath("//li[@id='Reports_Menu']//a[contains(.,'Reports')]");
	private By repotAudit = By.xpath("//li[@id='Reports_Audit_Menu']//a");

	private By customersSubTab=By.xpath("//a[@id='CustomerManagement_CustomerMaintenance_Menu']");

	private By reportTab=By.xpath("//li[@id='Reports_Menu']//a[contains(.,'Reports')]");

	private By attendenceTab=By.xpath("//li[@id='Reports_AttendanceReports_Menu']//a[contains(.,'Attendance')]");
	private By attendenceSummaryTab=By.xpath("//a[@id='AttendanceReports_AttendanceSummaryReport_Menu' and text()='Attendance Summary']");	
	private By attendenceDetailReportTab=By.xpath("//a[@id='AttendanceReports_AttendanceDetailReport_Menu']");	
	private By attendanceSummaryByHourReportTab=By.xpath("//a[@id='AttendanceReports_AttendanceSummaryByHourReport_Menu']");	


	private By registrationTab=By.xpath("//li[@id='Reports_RegistrationReports_Menu']//a[contains(.,'Registration')]");
	private By registrationDetailTab=By.xpath("//a[@id='RegistrationReports_RegistrationDetailReport_Menu'][contains(.,'Registration Detail')]");
	private By registrationSummaryReportTab=By.xpath("//a[@id='RegistrationReports_RegistrationSummaryReport_Menu'][contains(.,'Registration Summary')]");

	private By SuspensionsTab=By.xpath("//li[@id='Reports_SuspensionReports_Menu']//a[contains(.,'Suspensions')]");
	private By CurrentSuspensionsReportTab=By.xpath("//a[@id='SuspensionReports_CurrentSuspensionsReport_Menu']");	
	private By LiftedSuspensionsReportTab=By.xpath("//a[@id='SuspensionReports_LiftedSuspensionsReport_Menu']");	
	private By SuspensionDetailReport=By.xpath("//a[@id='SuspensionReports_SuspensionDetailReport_Menu']");	

	private By TablesTab=By.xpath("//li[@id='Reports_TablesReport_Menu']//a[contains(.,'Tables')]");
	private By TableDailyResultsReportTab=By.xpath("//a[@id='TablesReport_TableDailyResultsReport_Menu']");
	private By tableAccounting_CreateTable_SaveButton = By.cssSelector("button[accesskey='s']");


	private By export=By.xpath("//button[@id='buttonExport']");
	private By exportToCSV=By.xpath("//ul[@class='dropdown-menu']//li//a[@id='exportToCSV']");	
	private By exportToExcel=By.xpath("//ul[@class='dropdown-menu']//li//a[@id='exportToExcel']");	
	private By dropdw1 = By.xpath("//select[@id='ReportInterval_Id']//option[@value='3']");
	private By startDate = By.xpath("//input[@id='StartGamingDate']");	
	private By dropdw = By.xpath("//select[@id='ReportInterval_Id']");
	private By genrate =By.xpath("//button[@id='buttonGenerate']");
	private By closeIconTab=By.xpath("//div[@class='buttonbar']//div//button");
	private By cashDesKDate = By.xpath("//li[@id='cashDeskDate']");
	private By closeBtn = By.xpath("//button[@accesskey='x']");
	private By visitorCount=By.xpath("//div[@id='divCustomersCount']");
	private By EstimatedTotalVisits=By.xpath("//tfoot//tr//td[@data-grid-column-key='Visits']");
	private By tableAccounting_tablefill_selectTable = By.cssSelector("select#dropDownGamingTable");	
	private By tableAccounting_tablefill_selectAsset = By.cssSelector("input[name='item[10].Quantity']");	
	private By tableAccounting_tablefill_selectAsset1 = By.cssSelector("input[name='item[4].Quantity']");	
	private By tableAccounting_tablefill_comment = By.cssSelector("textarea#Comment");	
	private By processCompleteMsg=By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'Process Transaction: ')]");
	private By totalQuantity=By.xpath("//span[@data-ig-format='Currency']");
	private By totalValue=By.xpath("//span[@data-ig-format='Decimal']");

	private By okBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'OK')]");
	private By voidYesButton = By.cssSelector("button[data-ig-type='YES']"); 

	public void genrateRegistrationDetailReport()
	{
		objWrapperFunctions.setZoomLevel();
		try {
			Thread.sleep(15000);
			objWrapperFunctions.verifyIsElementPresent(ReportsTab);
			objWrapperFunctions.clickByScript(ReportsTab);
			objWrapperFunctions.clickByScript(attendenceTab);
			objWrapperFunctions.clickByScript(attendenceSummaryTab);
			objWrapperFunctions.clickByScript(attendenceSummaryTab);

			/*
			date=objWrapperFunctions.getRandomDate();
			conDate=objUtilities.getFormatedDate(date,"ddmmyyyy","dd/mm/yyyy");
			objWrapperFunctions.setText(startDate,conDate);
			String get = objWrapperFunctions.getAttributeValue(startDate, "value");
			System.out.println(get);
			 */

			objWrapperFunctions.click(dropdw);
			objWrapperFunctions.selectDropDownOption(dropdw, "Today");
			//.selectDropDownByRandomIndex(dropdw,21,1);
			//objWrapperFunctions.clickByScript(dropdw1);
			objWrapperFunctions.clickByScript(genrate);
			Thread.sleep(10000);
			objWrapperFunctions.clickByScript(export);
			objWrapperFunctions.clickByScript(exportToExcel);
			Thread.sleep(10000);
			Runtime.getRuntime().exec(System.getProperty("user.dir") + "/AutoIt3/saveCsv.exe");
			System.out.println("sdfsdf");
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();	
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void setDateRange()
	{
		objWrapperFunctions.waitForElementToBeClickable(dropdw);
		objUtilities.logReporter("Click on DateRange dropdw ", objWrapperFunctions.click(dropdw), false);	
		objUtilities.logReporter("select today as DateRange  ",objWrapperFunctions.selectDropDownOption(dropdw, "Today"), false);

	}
	public void setZoomLevel()
	{
		try {
			Thread.sleep(12000);
			objWrapperFunctions.setZoomLevel();
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void saveExcel()
	{
		try {
			Thread.sleep(15000);

			Runtime.getRuntime().exec(System.getProperty("user.dir") + "/AutoIt3/saveCsv.exe");
			//objPojo.getWaitMethods().sleep(5000);
			Thread.sleep(6000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void closeWind()
	{
		try {
			Thread.sleep(10000);

			Runtime.getRuntime().exec(System.getProperty("user.dir") + "/AutoIt3/closeWin.exe");
			//objPojo.getWaitMethods().sleep(5000);
			Thread.sleep(6000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setDefaultZoomLEvel()
	{try {
		Thread.sleep(8000);
		objWrapperFunctions.setDefaultZoomLevel();

		Thread.sleep(13000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void clickOnGenrate()
	{
		objWrapperFunctions.waitForElementPresence(genrate);;
		objWrapperFunctions.waitForElementToBeClickable(genrate);
		objUtilities.logReporter("Click on genrate ", objWrapperFunctions.clickByScript(genrate), false);
		try {
			Thread.sleep(13000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//objPojo.getWaitMethods().sleep(10000);
	}

	public void verifyAndClickExport()
	{
		objWrapperFunctions.waitForElementPresence(export);
		objUtilities.logReporter("Verify  export", objWrapperFunctions.verifyIsElementPresent(export), false);
		objWrapperFunctions.waitForElementToBeClickable(export);
		objUtilities.logReporter("Click on export", objWrapperFunctions.clickByScript(export), false);
	}

	public void verifyAndClickExportToExcel()
	{
		objWrapperFunctions.waitForElementPresence(exportToExcel);
		objUtilities.logReporter("Verify  export", objWrapperFunctions.verifyIsElementPresent(exportToExcel), false);
		objWrapperFunctions.waitForElementToBeClickable(exportToExcel);
		objUtilities.logReporter("Click on export", objWrapperFunctions.clickByScript(exportToExcel), false);
	}
	public void clickOnReportTab()
	{
		objWrapperFunctions.waitForElementPresence(reportTab);;
		objWrapperFunctions.waitForElementToBeClickable(reportTab);
		objUtilities.logReporter("Click on Report Tab ", objWrapperFunctions.clickByScript(reportTab), false);
	}
	public void clickOnAttendenceTab()
	{
		objWrapperFunctions.waitForElementPresence(attendenceTab);;
		objUtilities.logReporter("Verify  attendence Tab ", objWrapperFunctions.verifyIsElementPresent(attendenceTab), false);
		objWrapperFunctions.waitForElementToBeClickable(attendenceTab);
		objUtilities.logReporter("Click on attendence Tab", objWrapperFunctions.clickByScript(attendenceTab), false);
	}

	public void clickOnAttendenceDetailReportTab()
	{	
		objUtilities.logReporter("Verify  attendence Detail ReportTab ", objWrapperFunctions.verifyIsElementPresent(attendenceDetailReportTab), false);
		objWrapperFunctions.waitForElementToBeClickable(attendenceDetailReportTab);
		objUtilities.logReporter("Click on attendence Detail Report Tab ", objWrapperFunctions.clickByScript(attendenceDetailReportTab), false);
	}

	public void clickOnAttendenceSummaryTab() throws InterruptedException
	{	Thread.sleep(500);
		objUtilities.logReporter("Verify  attendence Summary Tab ", objWrapperFunctions.verifyIsElementPresent(attendenceSummaryTab), false);
		objWrapperFunctions.waitForElementToBeClickable(attendenceSummaryTab);
		objUtilities.logReporter("Click on attendence Summary Tab ", objWrapperFunctions.clickByScript(attendenceSummaryTab), false);
	}

	public void clickOnAttendanceSummaryByHourReportTab()
	{	
		objWrapperFunctions.waitForElementPresence(attendanceSummaryByHourReportTab);
		objWrapperFunctions.waitForElementToBeClickable(attendanceSummaryByHourReportTab);
		objUtilities.logReporter("Verify  attendanceSummaryByHourReportTab ", objWrapperFunctions.verifyIsElementPresent(attendanceSummaryByHourReportTab), false);
		objWrapperFunctions.waitForElementToBeClickable(attendanceSummaryByHourReportTab);
		objUtilities.logReporter("Click on attendanceSummaryByHourReportTab ", objWrapperFunctions.clickByScript(attendanceSummaryByHourReportTab), false);
	}


	public void clickORregistrationTab()
	{
		objWrapperFunctions.waitForElementPresence(registrationTab);;
		objUtilities.logReporter("Verify  Registration Tab ", objWrapperFunctions.verifyIsElementPresent(registrationTab), false);
		objWrapperFunctions.waitForElementToBeClickable(registrationTab);
		objUtilities.logReporter("Click on Registration Tab ", objWrapperFunctions.clickByScript(registrationTab), false);
	}

	public void clickORegistrationDetailTab()
	{	
		if(objWrapperFunctions.checkElementDisplyed(registrationDetailTab)==false)
		{
			objWrapperFunctions.waitForElementToBeClickable(registrationTab);
			objUtilities.logReporter("Click on Registration Tab ", objWrapperFunctions.clickByScript(registrationTab), false);
			objUtilities.logReporter("Verify  registration Detail Tab ", objWrapperFunctions.verifyIsElementPresent(registrationDetailTab), false);
			objWrapperFunctions.waitForElementToBeClickable(registrationDetailTab);
			objUtilities.logReporter("Click on Registration Detail Tab ", objWrapperFunctions.clickByScript(registrationDetailTab), false);
		}
		else
		{
			objUtilities.logReporter("Verify  registration Detail Tab ", objWrapperFunctions.verifyIsElementPresent(registrationDetailTab), false);
			objWrapperFunctions.waitForElementToBeClickable(registrationDetailTab);
			objUtilities.logReporter("Click on Registration Detail Tab ", objWrapperFunctions.clickByScript(registrationDetailTab), false);
		}
	}

	public void clickORegistrationSummaryReportTab()
	{	
		if(objWrapperFunctions.checkElementDisplyed(registrationDetailTab)==false)
		{
			objWrapperFunctions.waitForElementToBeClickable(registrationTab);
			objUtilities.logReporter("Click on Registration Tab ", objWrapperFunctions.clickByScript(registrationTab), false);
			objUtilities.logReporter("Verify  registration Summary Report Tab ", objWrapperFunctions.verifyIsElementPresent(registrationSummaryReportTab), false);
			objWrapperFunctions.waitForElementToBeClickable(registrationSummaryReportTab);
			objUtilities.logReporter("Click on Registration Summary Report  Tab ", objWrapperFunctions.clickByScript(registrationSummaryReportTab), false);
		}
		else{
			objUtilities.logReporter("Verify  registration Summary Report Tab ", objWrapperFunctions.verifyIsElementPresent(registrationSummaryReportTab), false);
			objWrapperFunctions.waitForElementToBeClickable(registrationSummaryReportTab);
			objUtilities.logReporter("Click on Registration Summary Report  Tab ", objWrapperFunctions.clickByScript(registrationSummaryReportTab), false);
		}
	}


	public void clickOnSuspensionsTab()
	{
		objWrapperFunctions.waitForElementPresence(SuspensionsTab);
		objUtilities.logReporter("Verify  SuspensionsTab ", objWrapperFunctions.verifyIsElementPresent(SuspensionsTab), false);
		objWrapperFunctions.waitForElementToBeClickable(SuspensionsTab);
		objUtilities.logReporter("Click on Suspensions Tab", objWrapperFunctions.clickByScript(SuspensionsTab), false);
	}

	public void clickOnCurrentSuspensionsReportTab()
	{	
		objUtilities.logReporter("Verify CurrentSuspensionsReportTab", objWrapperFunctions.verifyIsElementPresent(CurrentSuspensionsReportTab), false);
		objWrapperFunctions.waitForElementToBeClickable(CurrentSuspensionsReportTab);
		objUtilities.logReporter("Click on CurrentSuspensionsReportTab ", objWrapperFunctions.clickByScript(CurrentSuspensionsReportTab), false);
	}

	public void clickOnLiftedSuspensionsReportTab()
	{	
		objUtilities.logReporter("Verify  Lifted Suspensions ReportTab ", objWrapperFunctions.verifyIsElementPresent(LiftedSuspensionsReportTab), false);
		objWrapperFunctions.waitForElementToBeClickable(LiftedSuspensionsReportTab);
		objUtilities.logReporter("Click on LiftedSuspensions Report Tab ", objWrapperFunctions.clickByScript(LiftedSuspensionsReportTab), false);
	}

	public void clickOnSuspensionDetailReport() throws InterruptedException
	{	Thread.sleep(500);
		objUtilities.logReporter("Verify  SuspensionDetailReport ", objWrapperFunctions.verifyIsElementPresent(SuspensionDetailReport), false);
		objWrapperFunctions.waitForElementToBeClickable(SuspensionDetailReport);
		objUtilities.logReporter("Click on SuspensionDetailReport ", objWrapperFunctions.clickByScript(SuspensionDetailReport), false);
	}


	public void clickOnTablesTab()
	{
		objWrapperFunctions.waitForElementPresence(TablesTab);
		objUtilities.logReporter("Verify Tables Tab ", objWrapperFunctions.verifyIsElementPresent(TablesTab), false);
		objWrapperFunctions.waitForElementToBeClickable(TablesTab);
		objUtilities.logReporter("Click on Tables Tab", objWrapperFunctions.clickByScript(TablesTab), false);
	}

	public void clickOnTableDailyResultsReportTab()
	{	
		objUtilities.logReporter("Verify TableDailyResultsReportTab", objWrapperFunctions.verifyIsElementPresent(TableDailyResultsReportTab), false);
		objWrapperFunctions.waitForElementToBeClickable(TableDailyResultsReportTab);
		objUtilities.logReporter("Click on TableDailyResultsReportTab ", objWrapperFunctions.clickByScript(TableDailyResultsReportTab), false);
	}



	public void verifyDataInExcelSheet()
	{
		verifyDataInExcel(10,1, custNumber);
	}

	public void verifyAttendanceDataInExcelSheet()
	{
		verifyDataInExcel(10,3,custNumber);
	}
	public void verifySusoenionReport()
	{
		verifyDataInExcel(10,1,custNumber);
	}


	public void verifyLiftedSuspensionReport()
	{
		verifyDataInExcel(10,2,custNumber);
	}
	public void verifyDataInExcel(int rowNum,int cno,String vrifyText) 
	{
		try {
			File f = getTheNewestFile("C:/Users/11801/Downloads");
			FileInputStream file = new FileInputStream(f);
			System.out.println(file);
			HSSFWorkbook workbook;
			workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheetAt(0);
			int clmNo = 0;
			org.apache.poi.ss.usermodel.Row testDataRow;
			testDataRow = sheet.getRow((rowNum - 1));
			org.apache.poi.ss.usermodel.Cell testDataCell = testDataRow.getCell(clmNo, Row.RETURN_BLANK_AS_NULL);
			//headerRow = sheet.getRow(9);
			int r = sheet.getLastRowNum();
			System.out.println("r = " +r);
			for(int i=rowNum;i<=r;i++)
			{
				testDataCell = sheet.getRow(i).getCell(cno);
				DataFormatter formatter = new DataFormatter();
				String cellData = formatter.formatCellValue(testDataCell);
				System.out.println(cellData);
				if(cellData.equalsIgnoreCase(vrifyText))
				{
					System.out.println("Record found");
					break;
				}
			}
			FileOutputStream fileOut = new FileOutputStream(f);
			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void verifyData(int cno)
	{
		File f = getTheNewestFile("C:/Users/11801/Downloads/test");
		FileInputStream file;
		try {
			file = new FileInputStream(f);
			System.out.println(file);
			HSSFWorkbook workbook;
			workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheetAt(0);
			int r = sheet.getLastRowNum();
			System.out.println("r = " +r);
			Cell testDataCell = sheet.getRow(r-1).getCell(cno);
			//  double f1= testDataCell.getNumericCellValue();
			// System.out.println("satest dsat = " +f1);
			DataFormatter formatter = new DataFormatter();
			refId_FE = formatter.formatCellValue(testDataCell);
			System.out.println("sdsddd= " +refId_FE);    
			FileOutputStream fileOut = new FileOutputStream(f);
			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
			file.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public File getTheNewestFile(String filePath) {
		File theNewestFile = null;
		File dir = new File(filePath);
		File[] files = dir.listFiles();

		if (files.length > 0) {
			/* The newest file comes first */
			Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
			theNewestFile = files[0];
		}
		System.out.println("path = " +theNewestFile);
		return theNewestFile;
	}

	public void compareValue()
	{

		System.out.println("refId_FE  " +refId_FE);
		if(Integer.valueOf(refId_FE) > Integer.valueOf(refId_BE))
		{
			System.out.println("greather than ");
		}
		else{
			System.out.println("both /lessare same value ");
		}
	}

	public void updateNumber()
	{
		objWrapperFunctions.updateInConfig(refId_FE, "web.reportNum");
		refId_BE = refId_FE;
	}


	public void closeButton()
	{
		objWrapperFunctions.waitForElementPresence(closeBtn);
		objWrapperFunctions.waitForElementToBeClickable(closeBtn);
		objUtilities.logReporter("Click on closeBtn ", objWrapperFunctions.clickByScript(closeBtn), false);
	}
	public void getvisitorsCount()
	{
		vistorCnt1=objWrapperFunctions.getText(visitorCount);
		System.out.println(" No. of visitors is "+vistorCnt1);	
	}

	public void compareValue1()
	{
		System.out.println("refId_FE  " +vistorCnt1);
		if(((refId_FE)).contentEquals(vistorCnt1))
		{
			System.out.println("Both value are same");
		}
		else{
			System.out.println(" Different values are displayed ");
		}
	}

	public void verifyTableDataINexcel()
	{
		verifyTableDataInExcel(10,2,6,tableNm);
	}
	public void tableAddAndRemoveAsset()
	{
		objUtilities.logReporter("Select  table", objWrapperFunctions.selectDropDownByIndex(tableAccounting_tablefill_selectTable, 1), false);

		tableNm = objWrapperFunctions.getSelectedValueFromDropDown(tableAccounting_tablefill_selectTable);
		System.out.println("Table Name =" +tableNm);
		if(objWrapperFunctions.checkElementDisplyed(tableAccounting_tablefill_selectAsset))
		{
			objUtilities.logReporter("Select Asset", objWrapperFunctions.setText(tableAccounting_tablefill_selectAsset,"1"), false);
		}
		else
		{
			objUtilities.logReporter("Select Asset", objWrapperFunctions.setText(tableAccounting_tablefill_selectAsset1,"1"), false);
		}
		objUtilities.logReporter("Enter Comment", objWrapperFunctions.setText(tableAccounting_tablefill_comment, "Test Purpose"), false);

		vistorCnt1 = objWrapperFunctions.getText(totalQuantity);
		String qty = objWrapperFunctions.getText(totalValue);
		System.out.println("Total Value  = "+vistorCnt1 );
		System.out.println("Total Quantity = "+qty);
		objUtilities.logReporter("Click on save", objWrapperFunctions.click(tableAccounting_CreateTable_SaveButton), false);
		String msg = objWrapperFunctions.getText(processCompleteMsg);
		if(objWrapperFunctions.checkElementDisplyed(processCompleteMsg))
		{
			System.out.println(msg);
		}
		clickOkOrYes();
		clickOkOrYes();
	}

	public void verifyTableDataInExcel(int rowNum,int cno,int cno1,String vrifyText) 
	{
		try {//C:\Users\bhadv\Downloads\Test
			File f = getTheNewestFile("C:/Users/bhadv/Downloads/test");
			FileInputStream file = new FileInputStream(f);
			System.out.println(file);
			HSSFWorkbook workbook;
			workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheetAt(0);
			int clmNo = 0;
			org.apache.poi.ss.usermodel.Row testDataRow;
			testDataRow = sheet.getRow((rowNum - 1));
			org.apache.poi.ss.usermodel.Cell testDataCell = testDataRow.getCell(clmNo, Row.RETURN_BLANK_AS_NULL);
			org.apache.poi.ss.usermodel.Cell testDataCell1 = testDataRow.getCell(clmNo, Row.RETURN_BLANK_AS_NULL);
			//headerRow = sheet.getRow(9);
			int r = sheet.getLastRowNum();
			System.out.println("r = " +r);
			for(int i=rowNum;i<=r;i++)
			{
				testDataCell = sheet.getRow(i).getCell(cno);
				DataFormatter formatter = new DataFormatter();
				String cellData = formatter.formatCellValue(testDataCell);
				System.out.println(cellData);
				if(cellData.equalsIgnoreCase(vrifyText))
				{
					System.out.println("Record found");
					testDataCell1 = sheet.getRow(i).getCell(cno1);
					DataFormatter formatter1 = new DataFormatter();
					refId_FE = formatter1.formatCellValue(testDataCell1);
					System.out.println(refId_FE);
					break;
				}
			}
			FileOutputStream fileOut = new FileOutputStream(f);
			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void clickOkOrYes(){
		//System.out.println("Closing Pop-up :"+count);
		//	objWrapperFunctions.waitForElementPresence(voidYesButton);
		if(objWrapperFunctions.checkElementDisplyed(voidYesButton)){
			objWrapperFunctions.pressEnterBtn(voidYesButton);
		}else if(objWrapperFunctions.checkElementDisplyed(okBtn)){
			objWrapperFunctions.pressEnterBtn(okBtn);
		}
		objWrapperFunctions.waitForElementPresence(okBtn);		
	}

	public void getestimatedVisits()
	{
		vistorCnt1=objWrapperFunctions.getText(EstimatedTotalVisits);
		System.out.println(" getestimatedVisits "+vistorCnt1);	
	}
}

