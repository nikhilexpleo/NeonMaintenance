package com.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestResult;

public class CustomReporterHelperNew {
	// Local variables
		String strExcelFilePath = "";
		private XSSFWorkbook workbook;

		private XSSFSheet summarySheet;
		private XSSFRow summaryCurrentRow;
		int intSummarySheetRowCounter = 0;

		private XSSFSheet passSheet;
		private XSSFRow passSheetCurrentRow;
		int intPassSheetRowCounter = 0;

		private XSSFSheet failSheet;
		private XSSFRow failSheetCurrentRow;
		int intFailSheetRowCounter = 0;

		private XSSFSheet skipSheet;
		private XSSFRow skipSheetCurrentRow;
		int intSkipSheetRowCounter = 0;

		/**
			Start excel report
		 */
		public void startExcelReport(ITestResult result, String status)
		{
			String completeTestClassPath = result.getTestClass().getName();
			String packageName = completeTestClassPath.substring(0, completeTestClassPath.lastIndexOf("."));
			String testClassName = result.getTestClass().getRealClass().getSimpleName();
			String methodName = result.getMethod().getMethodName();
			
			//String temp = methodName.substring(methodName.indexOf("_") + 1);
			//String RMID = temp.substring(0, temp.indexOf("_"));
			double executionTime = (result.getEndMillis() - result.getStartMillis())/1000.0;
			Pojo objPojo = (Pojo) result.getInstance();

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String reportDate = dateFormat.format(date).toString();		
			// Excel report file path
			strExcelFilePath =  System.getProperty("user.dir") + "/target/custom-reports/ExcelReports_" + reportDate + ".xlsx";
			File reportFile = new File(strExcelFilePath);
			try
			{
				// If file not exist create new with summary sheet and sheet for running script details
				if(!reportFile.exists())
				{
					new File(System.getProperty("user.dir") + "/target/custom-reports").mkdir();
					reportFile.createNewFile();

					String reportTemplet = System.getProperty("user.dir") + "/src/main/resources/externalResources/Custom_Design_Files/Excel/reportTemplet.xlsx"; 
					workbook = (XSSFWorkbook)WorkbookFactory.create(new FileInputStream(reportTemplet));
					summarySheet = workbook.getSheet("TestSummary");
					intSummarySheetRowCounter = 1;
					summaryCurrentRow = summarySheet.getRow(intSummarySheetRowCounter);

					passSheet = workbook.createSheet("PassTestReport");
					passSheetCurrentRow = passSheet.createRow(0);
					this.createHeaderRowPass(passSheetCurrentRow);
					intPassSheetRowCounter = intPassSheetRowCounter + 1;
					passSheetCurrentRow = passSheet.createRow(intPassSheetRowCounter);

					failSheet = workbook.createSheet("FailTestReport");
					failSheetCurrentRow = failSheet.createRow(0);
					this.createHeaderRowFailSkipped(failSheetCurrentRow);
					intFailSheetRowCounter = intFailSheetRowCounter + 1;
					failSheetCurrentRow = failSheet.createRow(intFailSheetRowCounter);

					skipSheet = workbook.createSheet("SkippedTestReport");
					skipSheetCurrentRow = skipSheet.createRow(0);
					this.createHeaderRowFailSkipped(skipSheetCurrentRow);
					intSkipSheetRowCounter = intSkipSheetRowCounter + 1;
					skipSheetCurrentRow = skipSheet.createRow(intSkipSheetRowCounter);
				}
				else // If file exist update report sheet
				{
					workbook = (XSSFWorkbook)WorkbookFactory.create(new FileInputStream(strExcelFilePath));

					summarySheet = workbook.getSheet("TestSummary");
					intSummarySheetRowCounter = 1;
					summaryCurrentRow = summarySheet.getRow(intSummarySheetRowCounter); 

					passSheet = workbook.getSheet("PassTestReport");
					intPassSheetRowCounter = passSheet.getLastRowNum() + 1;
					passSheetCurrentRow = passSheet.createRow(intPassSheetRowCounter);

					failSheet = workbook.getSheet("FailTestReport");
					intFailSheetRowCounter = failSheet.getLastRowNum() + 1;
					failSheetCurrentRow = failSheet.createRow(intFailSheetRowCounter);

					skipSheet = workbook.getSheet("SkippedTestReport");
					intSkipSheetRowCounter = skipSheet.getLastRowNum() + 1;
					skipSheetCurrentRow = skipSheet.createRow(intSkipSheetRowCounter);
				}

				if(status.equalsIgnoreCase("pass"))
					this.addExcelPassStep(packageName, testClassName, methodName, String.valueOf(executionTime));
				if(status.equalsIgnoreCase("fail"))
				{
					String seleniumException = result.getThrowable().getClass().getName();
					String seleniumExceptionMessage = result.getThrowable().getMessage();
					String exception = seleniumException.contains("java.lang.AssertionError") ? "Application Side Issue - AssertionError" : "Selenium Side Issue - " + seleniumExceptionMessage;

					this.addExcelFailStep(packageName, testClassName, methodName, exception, String.valueOf(executionTime));
				}
				if(status.equalsIgnoreCase("skipped"))
					this.addExcelSkippedStep(packageName, testClassName, methodName, "Pre -Condition Failed", String.valueOf(executionTime));

				updateSummarySheet(status);

				endExcelReport();
			}catch(Exception exception){
				exception.printStackTrace();
			}
		}

		/**
		 *  Add pass step in excel report
		 */
		public void createHeaderRowPass(XSSFRow headerRow)
		{
			this.createHeaderCell(headerRow, 0, "Sr. No.");
			this.createHeaderCell(headerRow,1, "Time Stamp");
			this.createHeaderCell(headerRow,2, "Module");
			this.createHeaderCell(headerRow,3, "Class Name");
			this.createHeaderCell(headerRow,4, "Method Name");
			this.createHeaderCell(headerRow,5, "Execution Time"); 
			this.createHeaderCell(headerRow,6, "Customer Name"); 
		}

		/**
		 *  Add pass step in excel report
		 */
		public void createHeaderRowFailSkipped(XSSFRow headerRow)
		{
			this.createHeaderCell(headerRow, 0, "Sr. No.");
			this.createHeaderCell(headerRow,1, "Time Stamp");
			this.createHeaderCell(headerRow,2, "Module");
			this.createHeaderCell(headerRow,3, "Class Name");
			this.createHeaderCell(headerRow,4, "Method Name");
			this.createHeaderCell(headerRow,5, "Exception"); 
			this.createHeaderCell(headerRow,6, "Execution Time"); 
			this.createHeaderCell(headerRow,7, "Customer Name"); 
		}


		/**
		 *  Add pass step in excel report
		 */
		public void addExcelPassStep(String module, 
				String className, String methodName, String executionTime)
		{
			this.createSheetCellRightAlliged(passSheetCurrentRow, 0, String.valueOf(intPassSheetRowCounter));
			this.createSheetCellCenterAlliged(passSheetCurrentRow, 1, getCurrentDateTime());
			this.createSheetCell(passSheetCurrentRow, 2, module);
			this.createSheetCell(passSheetCurrentRow, 3, className);
			this.createSheetCell(passSheetCurrentRow, 4, methodName);
			this.createSheetCellCenterAlliged(passSheetCurrentRow, 5, executionTime); 
			this.createSheetCellCenterAlliged(passSheetCurrentRow, 6, System.getProperty("currentCustomerNum")); 
		}

		/**
		 *  Add fail step in excel report
		 */
		public void addExcelFailStep(String module, String className, String methodName, String exception, String executionTime)
		{
			this.createSheetCellRightAlliged(failSheetCurrentRow, 0, String.valueOf(intPassSheetRowCounter));
			this.createSheetCellCenterAlliged(failSheetCurrentRow, 1, getCurrentDateTime());
			this.createSheetCell(failSheetCurrentRow, 2, module);
			this.createSheetCell(failSheetCurrentRow, 3, className);
			this.createSheetCell(failSheetCurrentRow, 4, methodName);
			this.createSheetFailStepCell(failSheetCurrentRow, 5, exception); 
			this.createSheetCellCenterAlliged(failSheetCurrentRow, 6, executionTime); 
			this.createSheetCellCenterAlliged(failSheetCurrentRow, 7, System.getProperty("currentCustomerNum")); 
		}

		/**
		 *  Add fail step in excel report
		 */
		public void addExcelSkippedStep(String module, 
				String className, String methodName, String exception, String executionTime)
		{
			this.createSheetCellRightAlliged(skipSheetCurrentRow, 0, String.valueOf(intSkipSheetRowCounter));
			this.createSheetCellCenterAlliged(skipSheetCurrentRow, 1, getCurrentDateTime());
			this.createSheetCell(skipSheetCurrentRow, 2, module);
			this.createSheetCell(skipSheetCurrentRow, 3, className);
			this.createSheetCell(skipSheetCurrentRow, 4, methodName);
			this.createSheetSkippedStepCell(skipSheetCurrentRow, 5, exception); 
			this.createSheetCellCenterAlliged(skipSheetCurrentRow, 6, executionTime); 
			this.createSheetCellCenterAlliged(skipSheetCurrentRow, 7, System.getProperty("currentCustomerNum")); 
		}

		public void updateSummarySheet(String status){
			if(status.equalsIgnoreCase("pass")){
				int passCount = (int)summaryCurrentRow.getCell(0).getNumericCellValue() + 1;//tInteger.parseInt(this.getCellValue(summaryCurrentRow, 0)) + 1;
				this.createSheetCellCenterAlligedNumeric(summaryCurrentRow, 0, String.valueOf(passCount));
			}
			else if(status.equalsIgnoreCase("fail")){
				int failCount = (int)summaryCurrentRow.getCell(1).getNumericCellValue() + 1;//Integer.parseInt(this.getCellValue(summaryCurrentRow, 1)) + 1;
				this.createSheetCellCenterAlligedNumeric(summaryCurrentRow, 1, String.valueOf(failCount));
			}
			else if(status.equalsIgnoreCase("skipped")){
				int skippedCount = (int)summaryCurrentRow.getCell(2).getNumericCellValue() + 1;// Integer.parseInt(this.getCellValue(summaryCurrentRow, 2)) + 1;
				this.createSheetCellCenterAlligedNumeric(summaryCurrentRow, 2, String.valueOf(skippedCount));
			}

			int totalCount = (int)summaryCurrentRow.getCell(3).getNumericCellValue() + 1; //Integer.parseInt(this.getCellValue(summaryCurrentRow, 3)) + 1;
			this.createSheetCellCenterAlligedNumeric(summaryCurrentRow, 3, String.valueOf(totalCount));
		}


		/**
		 * End excel report
		 * @throws IOException
		 */

		public void endExcelReport() throws IOException  
		{
			this.autoSetColumnWidth();

			// writing the workbook object into the file created in startReport()
			FileOutputStream fileOutputStream = new FileOutputStream(strExcelFilePath);
			workbook.write(fileOutputStream);
			fileOutputStream.flush();
			fileOutputStream.close();
		}

		public void createSheetCell(XSSFRow row, int cellNumber, String value)
		{
			XSSFCell cell = row.createCell(cellNumber);
			cell.setCellValue(new XSSFRichTextString(value));
			cell.setCellStyle(getCellStyleLeftAlliged());
		}

		public void createSheetCellCenterAlliged(XSSFRow row, int cellNumber, String value)
		{
			XSSFCell cell = row.createCell(cellNumber);
			cell.setCellValue(new XSSFRichTextString(value));
			cell.setCellStyle(getCellStyleCenterAlliged());
		}

		public void createSheetCellCenterAlligedNumeric(XSSFRow row, int cellNumber, String value)
		{
			XSSFCell cell = row.createCell(cellNumber);
			cell.setCellValue(Integer.parseInt(value));
			cell.setCellStyle(getCellStyleCenterAlliged());
		}

		public void createSheetCellRightAlliged(XSSFRow row, int cellNumber, String value)
		{
			XSSFCell cell = row.createCell(cellNumber);
			cell.setCellValue(new XSSFRichTextString(value));
			cell.setCellStyle(getCellStyleRightAlliged());
		}

		public void createSheetPassStepCell(XSSFRow row, int cellNumber)
		{
			XSSFCell cell = row.createCell(cellNumber);
			cell.setCellValue(new XSSFRichTextString("PASS"));
			cell.setCellStyle(getPassCellStyle());
		}

		public void createSheetFailStepCell(XSSFRow row, int cellNumber, String value)
		{
			XSSFCell cell = row.createCell(cellNumber);
			cell.setCellValue(new XSSFRichTextString(value));
			cell.setCellStyle(getFailCellStyle());
		}

		public void createSheetSkippedStepCell(XSSFRow row, int cellNumber, String value)
		{
			XSSFCell cell = row.createCell(cellNumber);
			cell.setCellValue(new XSSFRichTextString(value));
			cell.setCellStyle(getSkippedCellStyle());
		}

		public void createHeaderCell(XSSFRow row, int cellNumber, String value)
		{
			XSSFCell cell = row.createCell(cellNumber);
			cell.setCellValue(new XSSFRichTextString(value));
			cell.setCellStyle(this.getHeaderCellStyle());
		}

		private XSSFCellStyle getCellStyleLeftAlliged()
		{
			XSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			//cellStyle.setFillForegroundColor(HSSFColor.LIGHT_BLUE.index);
			//cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			return cellStyle;
		}

		private XSSFCellStyle getCellStyleCenterAlliged()
		{
			XSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			//cellStyle.setFillForegroundColor(HSSFColor.LIGHT_BLUE.index);
			//cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			return cellStyle;
		}

		private XSSFCellStyle getCellStyleRightAlliged()
		{
			XSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			//cellStyle.setFillForegroundColor(HSSFColor.LIGHT_BLUE.index);
			//cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			return cellStyle;
		}

		private XSSFCellStyle getPassCellStyle()
		{
			XSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			cellStyle.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
			cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			return cellStyle;
		}

		private XSSFCellStyle getFailCellStyle()
		{
			XSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			cellStyle.setFillForegroundColor(HSSFColor.RED.index);
			cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			return cellStyle;
		}

		private XSSFCellStyle getSkippedCellStyle()
		{
			XSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			cellStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
			cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			return cellStyle;
		}

		private XSSFCellStyle getHeaderCellStyle()
		{
			XSSFFont headerFont = workbook.createFont(); 
			headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			headerFont.setFontName("Arial");
			XSSFCellStyle cellStyle = workbook.createCellStyle(); 
			cellStyle.setFont(headerFont);
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
			cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			return cellStyle;
		}

		public void createSummaryLinkCell(XSSFRow row, int cellNumber, String value, String nevigationSheet)
		{
			XSSFCell cell = row.createCell(cellNumber);
			cell.setCellValue(new XSSFRichTextString(value));
			CreationHelper createHelper = workbook.getCreationHelper();
			Hyperlink link = createHelper.createHyperlink(Hyperlink.LINK_DOCUMENT);
			link.setAddress("'" + nevigationSheet + "'!A1");
			cell.setHyperlink(link);
			cell.setCellStyle(getHlinkCellStyle());
		}

		private XSSFCellStyle getHlinkCellStyle()
		{
			XSSFCellStyle cellStyle = workbook.createCellStyle();
			Font hlink_font = workbook.createFont();
			hlink_font.setUnderline(Font.U_SINGLE);
			hlink_font.setColor(IndexedColors.BLUE.getIndex());
			hlink_font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			hlink_font.setFontName("Arial");
			cellStyle.setFont(hlink_font);
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
			cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

			return cellStyle;
		}

		private String getCurrentDateTime()
		{
			SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date now = new Date();
			return sdfDate.format(now);
		}
		public void autoSetColumnWidth()
		{
			passSheet.autoSizeColumn(0);
			passSheet.autoSizeColumn(1);
			passSheet.autoSizeColumn(2);
			passSheet.autoSizeColumn(3);
			passSheet.autoSizeColumn(4);
			passSheet.autoSizeColumn(5);
			passSheet.autoSizeColumn(6);
			passSheet.autoSizeColumn(7);
			passSheet.autoSizeColumn(8);
			passSheet.autoSizeColumn(9);
			passSheet.autoSizeColumn(10);

			failSheet.autoSizeColumn(0);
			failSheet.autoSizeColumn(1);
			failSheet.autoSizeColumn(2);
			failSheet.autoSizeColumn(3);
			failSheet.autoSizeColumn(4);
			failSheet.autoSizeColumn(5);
			failSheet.autoSizeColumn(6);
			failSheet.autoSizeColumn(7);
			failSheet.autoSizeColumn(8);
			failSheet.autoSizeColumn(9);
			failSheet.autoSizeColumn(10);

			skipSheet.autoSizeColumn(0);
			skipSheet.autoSizeColumn(1);
			skipSheet.autoSizeColumn(2);
			skipSheet.autoSizeColumn(3);
			skipSheet.autoSizeColumn(4);
			skipSheet.autoSizeColumn(5);
			skipSheet.autoSizeColumn(6);
			skipSheet.autoSizeColumn(7);
			skipSheet.autoSizeColumn(8);
			skipSheet.autoSizeColumn(9);
			skipSheet.autoSizeColumn(10);
		}  


}
