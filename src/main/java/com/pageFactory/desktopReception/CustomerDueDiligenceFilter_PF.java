package com.pageFactory.desktopReception;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class CustomerDueDiligenceFilter_PF {

	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	static String filterValue,filterCasino;
	WebDriver webdriver;
	private Pojo objPojo;
	private int MIN_DEFAULT_SLEEP_TIMEOUT = 1;
	
	public CustomerDueDiligenceFilter_PF(Pojo pojo)
	{
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
		webdriver = pojo.getDriver();
		//custNumber=pojo.getUser();		
		this.objPojo = pojo ;
	}


	private By customerTab=By.xpath("//li[@id='CustomerManagement_Menu']//a[contains(.,'Customers')]");
	private By dueDiligenceTab=By.cssSelector("a#CustomerManagement_EnhancedDueDiligence_Menu");
	private By dueDiligence_StateFilterDropdown = By.xpath("//select[@id='Status']");
	private By dueDiligence_FilterButton = By.xpath("//button[@id='buttonFind']");
	private By dueDiligence_StateFilter = By.cssSelector("td[data-grid-column-key='DueDiligenceState']");
	private By dueDiligence_ResetButton = By.xpath("//button[@id='buttonReset']");
	private By dueDiligence_okButton = By.xpath("//button[@data-ig-type='OK']");
	private By dueDiligence_NoRecordsFoundMessage = By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'No Records Found')]");
	private By dueDiligence_FindAcc_clickDetails = By.cssSelector("td.text-center button.btn-primary.btn-secured");
	private By dueDiligence_CustDetails_Name = By.cssSelector("h1#layoutCaption");
	private By dueDiligence_CustDetails_NextSteps = By.xpath("//div[@id='expanderEDDNextSteps']//h3[contains(.,'Next Steps')]");
	private By dueDiligence_CustDetails_Customer  = By.xpath("//div[@id='expanderEDDCustomer']//h3[contains(.,'Customer')]");
	private By dueDiligence_CustDetails_DueDiligence  = By.xpath("//div[@id='expanderEDDDetails']//h3[contains(.,'Due Diligence')]");
	private By dueDiligence_CustDetails_Outcome  = By.xpath("//div[@id='expanderEDDOutcome']//h3[contains(.,'Outcome')]");
	private By dueDiligence_CustDetails_Conversations  = By.xpath("//div[@id='expanderEDDConversations']//h3[contains(.,'Conversations')]");
	private By dueDiligence_CustDetails_RGConversations = By.xpath("//div[@id='expanderEDDRGConversations']//h3[contains(.,'RG Conversations')]");
	private By dueDiligence_CustDetails_Attachments  = By.xpath("//div[@id='expanderEDDAttachments']//h3[contains(.,'Attachments')]");	
	private By dueDiligence_div = By.xpath("//div[@class='ig-body ig-main-content-container-fluid']");

	private By dueDiligence_CasinoFilterDropDown = By.cssSelector("select#dropDownCasino");
	private By dueDiligence_CasinoFilterDropDown_option = By.xpath("//select[@id='dropDownCasino']");
	private By dueDiligence_CasinoFilter = By.cssSelector("td[data-grid-column-key='CasinoName']");
	private By dueDiligence_DateRangeDropDown = By.cssSelector("select#ReportInterval_Id");

	private By dueDiligence_Number = By.xpath("//input[@id='Number']");
	private By dueDiligence_StatusFilterDropdown = By.xpath("//select[@id='FindStatus']");
	
	//private By dueDiligence_CasinoFilter = By.cssSelector("td[data-grid-column-key='CasinoName']");
	By filter_DateRang = By.xpath("//select[@id='ReportInterval_Id']");
	By table = By.xpath("//table[@class='grid datagrid table ig-table']");
	By detailsButton = By.xpath("//button[@class='btn-primary btn-secured'][contains(text(),'Details')]");
	By dueDiligencePage_Outcome_Decison = By.xpath("//select[@id='DueDiligence_Outcome_Decision']");
			
	By dueDiligencePage_CurrentState = By.xpath("//label[contains(text(),'Current State')]/following-sibling::p");		
	By FiltersArrow= By.xpath("//i[@id='FindEnhancedDueDiligence_caret']");

			
	public void clickOnDetails()
	{
		objUtilities.logReporter("Click on details Button ", 
				objWrapperFunctions.clickByScript(objWrapperFunctions.getElementOfIndex(detailsButton,1)), false);		
	
	}
	
	public String getDecisionValue()
	{
		String decision = objPojo.getObjWrapperFunctions().getSelectedValueFromDropDown(dueDiligencePage_Outcome_Decison);
		return decision ;
	}
	
	public String getCurrentStatus()
	{
		String CurrentStatus = objPojo.getObjWrapperFunctions().getText(dueDiligencePage_CurrentState);
		return CurrentStatus ;
	}
	public void NavigateToCustomerTab()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objUtilities.logReporter("Click on Customer tab", objWrapperFunctions.click(customerTab), false);
	}

	public void clickOnDueDiligence()
	{
		objUtilities.logReporter("Click on dueDiligence tab", objWrapperFunctions.click(dueDiligenceTab), false);
	}

	public void searchRecordByNumber(String number)
	{
		objUtilities.logReporter("Enter Number",
				objWrapperFunctions.setText(dueDiligence_Number, number), false);
	}
	public void clickOnFiltersArrow()
	{//i[@id='FindEnhancedDueDiligence_caret']
		objUtilities.logReporter("Click on filters Arrow", 
				objWrapperFunctions.click(FiltersArrow), false);	
	}
	public void clickONFilter()
	{
		objUtilities.logReporter("Click on filter button", 
				objWrapperFunctions.click(dueDiligence_FilterButton), false);	
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectState(String state)
	{
		objUtilities.logReporter("Click on stateFilter dropdown", 
				objWrapperFunctions.click(dueDiligence_StateFilterDropdown), false);
		objUtilities.logReporter("Click on stateFilter dropdown", 
				objWrapperFunctions.selectDropDownByVisibleText(dueDiligence_StateFilterDropdown,state), false);
	}
  
	public void selectStatus(String status)
	{
		objUtilities.logReporter("Click on statusFilter dropdown", 
				objWrapperFunctions.click(dueDiligence_StatusFilterDropdown), false);
		objUtilities.logReporter("Click on statusFilter dropdown", 
				objWrapperFunctions.selectDropDownByVisibleText(dueDiligence_StatusFilterDropdown,status), false);
	}
	
	public void selectDateRange(String option)
	{
		objUtilities.logReporter("Click on Date Range dropdown ", 
				objWrapperFunctions.click(dueDiligence_DateRangeDropDown), false);
		objUtilities.logReporter("Select DateRange", 
				objWrapperFunctions.selectDropDownByVisibleText(dueDiligence_DateRangeDropDown,option), false);
	}
	
	public void selectCasino(String option)
	{
		objUtilities.logReporter("Click on Casino dropdown ", 
				objWrapperFunctions.click(dueDiligence_CasinoFilterDropDown), false);
		objUtilities.logReporter("Select DateRange", 
				objWrapperFunctions.selectDropDownByVisibleText(dueDiligence_CasinoFilterDropDown,option), false);
	}
	
	public void verifyDueDiligenceFilterTableHeaders()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objUtilities.logReporter(" verifyDueDiligenceFilterTableHeaders ", 
				objWrapperFunctions.verifyTableHeaders(table,"Number","Name","Reason For Creation","Loss Value","Casino","Date Opened","Date Closed","Last Visit","Visits Since Opened","Due Diligence State"), false);	
	}
	
	public void verifySearchResultDisplayAsPerSearchCirteria(String columnheader, String contentToVarify)
	{
		objUtilities.logReporter(" Verify Results  ", 
				this.verifyTableContentAgainstToColumn(table,columnheader,contentToVarify), false);	
		
		
		//verifyTableContentAgainstToColumn
	}
	public void setFilter()
	{
		//objUtilities.logReporter("Click on stateFilter dropdown", objWrapperFunctions.selectDropDownByRandomIndex(dueDiligence_StateFilterDropdown,3,1), false);
		objUtilities.logReporter("Click on stateFilter dropdown", objWrapperFunctions.selectDropDownByIndex(dueDiligence_StateFilterDropdown,1), false);
		filterValue = objWrapperFunctions.getAttributeValue(dueDiligence_StateFilterDropdown, "value");
		System.out.println(filterValue);
		
		objUtilities.logReporter("Click on casino dropdown", objWrapperFunctions.selectDropDownByIndex(dueDiligence_DateRangeDropDown,6), false);
		
		objUtilities.logReporter("Click on casino dropdown", objWrapperFunctions.selectDropDownByIndex(dueDiligence_CasinoFilterDropDown,2), false);
		//objUtilities.logReporter("Click on casino dropdown", objWrapperFunctions.selectDropDownOption(dueDiligence_CasinoFilterDropDown,"_BALLY","value"), false);
		//filterCasino = objWrapperFunctions.getAttributeValue(dueDiligence_CasinoFilterDropDown, "value");
		
		filterCasino = objWrapperFunctions.getSelectedValueFromDropDown(dueDiligence_CasinoFilterDropDown);
		System.out.println(filterCasino);	
		objUtilities.logReporter("Click on filter button", objWrapperFunctions.click(dueDiligence_FilterButton), false);
		VerifyResult(dueDiligence_StateFilter,dueDiligence_CasinoFilter);
	}


	public void VerifyResult(By locator,By locator1)
	{
		if(objWrapperFunctions.checkElementDisplyed(dueDiligence_NoRecordsFoundMessage))
		{
			System.out.println(objWrapperFunctions.getText(dueDiligence_NoRecordsFoundMessage));
			objWrapperFunctions.verifyIsElementPresent(dueDiligence_okButton);
			objUtilities.logReporter("Click on ok button", objWrapperFunctions.click(dueDiligence_okButton), false);
		}
		else
		{
			//	String arrSateFilterValue[]=objWrapperFunctions.getElementTextArray(dueDiligence_StateFilter);

			String arrFilterValue[]=objWrapperFunctions.getElementTextArray(locator);
			String arrCasinoFilterValue[]=objWrapperFunctions.getElementTextArray(locator1);
			for (int i = 0; i < arrFilterValue.length; i++) 
			{
				if(arrFilterValue[i].contains(filterValue) && arrCasinoFilterValue[i].contains(filterCasino) )
				{
					System.out.println("State : " +i+" "+arrFilterValue[i] + " | Casino : " +i+ " " +arrCasinoFilterValue[i]);
				}
				else
				{
					System.out.println("Filter result is not displayed as per selected filter");
				}
			}
			customerDueDiligenceDetails();
		}
	}


	public void customerDueDiligenceDetails()
	{

		objUtilities.logReporter("Click on Details Button", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(dueDiligence_FindAcc_clickDetails, 1)), false);
		System.out.println(objWrapperFunctions.getText(dueDiligence_CustDetails_Name));
		objUtilities.logReporter("Verify Customer section displayed ", objWrapperFunctions.verifyIsElementPresent(dueDiligence_CustDetails_Customer), false);

		objUtilities.logReporter("Verify DueDiligence section displayed ", objWrapperFunctions.verifyIsElementPresent(dueDiligence_CustDetails_DueDiligence), false);
		objWrapperFunctions.scrollTab(dueDiligence_div);
		objWrapperFunctions.scrollTab(dueDiligence_CustDetails_NextSteps);
		objUtilities.logReporter("Verify Next Steps section displayed ", objWrapperFunctions.verifyIsElementPresent(dueDiligence_CustDetails_NextSteps), false);
		objUtilities.logReporter("Verify Outcome section displayed ", objWrapperFunctions.verifyIsElementPresent(dueDiligence_CustDetails_Outcome), false);
		objUtilities.logReporter("Verify Conversation section displayed ", objWrapperFunctions.verifyIsElementPresent(dueDiligence_CustDetails_Conversations), false);
		objUtilities.logReporter("Verify RG Conversation section displayed ", objWrapperFunctions.verifyIsElementPresent(dueDiligence_CustDetails_RGConversations), false);
		objUtilities.logReporter("Verify Attachment section displayed ", objWrapperFunctions.verifyIsElementPresent(dueDiligence_CustDetails_Attachments), false);
	}

	public boolean verifyTableContentAgainstToColumn(By locator, String... headerVerify)
	{
		Hashtable<String, String> dataColumnHeader = new Hashtable<String, String>();
		int intColumnNumber = 1;
		boolean blnverify = false;
		try {
			WebElement weResultTable = objPojo.getObjWrapperFunctions().processElement(locator);
			List<WebElement> weColumnsHeaders = weResultTable.findElements(By.xpath(".//thead/tr/th"));
			for (WebElement weColumnHeader : weColumnsHeaders)
			{
				((JavascriptExecutor)webdriver).executeScript("arguments[0].scrollIntoView(true);", weColumnHeader);
				objPojo.getWaitMethods().sleep(MIN_DEFAULT_SLEEP_TIMEOUT);
				String strHeader = weColumnHeader.getText().trim();
				if (!strHeader.equals(""))
					dataColumnHeader.put(strHeader, String.valueOf(intColumnNumber));
				intColumnNumber++;
			}

			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) 
			{
				
				if(headerVerify != null && headerVerify.length > 0)
				{
					boolean returnVal = false;
					//System.out.println(headerVerify.length);
					for(int intHeader = 0 ; intHeader < headerVerify.length ; intHeader++)
					{
						//System.out.println(headerVerify +  " " +intHeader);
						WebElement weExceptedClm = weRow.findElement(By.xpath(".//td[" + dataColumnHeader.get(headerVerify[intHeader])
								+ "]"));
						
					//	System.out.println(" weExceptedClm : " + weExceptedClm);
						System.out.println(" weExceptedClm : " + weExceptedClm.getText());
						intHeader ++;
						System.out.println(" contentToVerifyFirst : " + headerVerify[intHeader]);
						if (weExceptedClm.getText().trim().equalsIgnoreCase(headerVerify[intHeader]))
						{
							
							returnVal = true;
							System.out.println("blnverify " +blnverify);
						}
						else
						{
							returnVal = false;
							break;
						}

					}
					return returnVal;	
				}
				
			}
			return blnverify;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
		
	}	
	
	
	
	// Harshvardhan YadverifyTableContentAgainstToColumn
		public boolean verifyTableContentAgainstToColumn(By locator, String columnHeaderFirst, String contentToVerifyFirst)
		{
			Hashtable<String, String> dataColumnHeader = new Hashtable<String, String>();
			int intColumnNumber = 1;
			boolean blnverify = false;
			try {
				WebElement weResultTable = this.objPojo.getObjWrapperFunctions().processElement(locator);
				List<WebElement> weColumnsHeaders = weResultTable.findElements(By.xpath(".//thead/tr/th"));
				for (WebElement weColumnHeader : weColumnsHeaders)
				{
					((JavascriptExecutor)webdriver).executeScript("arguments[0].scrollIntoView(true);", weColumnHeader);
					objPojo.getWaitMethods().sleep(MIN_DEFAULT_SLEEP_TIMEOUT);
					String strHeader = weColumnHeader.getText().trim();
					if (!strHeader.equals(""))
						dataColumnHeader.put(strHeader, String.valueOf(intColumnNumber));
					intColumnNumber++;
				}

				List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
				for (WebElement weRow : weRows) 
				{
					WebElement weExceptedClm = weRow.findElement(By.xpath(".//td[" + dataColumnHeader.get(columnHeaderFirst)
							+ "]"));
					System.out.println(" weExceptedClm : " + weExceptedClm);
					//((JavascriptExecutor) objPojo.getWebDriverProvider().getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", weExceptedClm);
					System.out.println(" weExceptedClm : " + weExceptedClm.getText());
					System.out.println(" contentToVerifyFirst : " + contentToVerifyFirst);
					if (weExceptedClm.getText().trim().equalsIgnoreCase(contentToVerifyFirst))
					{
						blnverify = true;
						System.out.println("blnverify" +blnverify);
						return blnverify;
					}

				}
				return blnverify;
			} catch (Exception exception) {
				exception.printStackTrace();
				return false;
			}
		}
}

