package com.pageFactory.CashierManagerTC;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.generic.ExcelIterator;
import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class BalancePage
{
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	String message="";
	String NeonUser,NeonPass;
	ExcelIterator objExcel=new ExcelIterator();
	static String refId_FE="",custName="",date="",cardnum="", conDate="";
	//static int cardnum;

	public BalancePage(Pojo pojo){
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
		NeonUser=pojo.getNeonUser();
		NeonPass=pojo.geNeonPassword();	
	}

	private By userName=By.id("Username");
	private By password=By.id("Password");
	private By signBtn=By.xpath("//button[@class='btn btn-lg btn-primary btn-block ig-signin-button']");
	private By okBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'OK')]");

	private By findBtn=By.xpath("//button[@id='buttonFind']");
	private By collapsedBtn=By.xpath("//button[@class='collapsor active']");
	private By DateRangeDropDown_ThisCalendarQuarter=By.xpath("//select[@id='ReportInterval_Id']//option[contains(.,'This Calendar Quarter')]");

	private By DateRangeDropDown=By.xpath("//select[@id='ReportInterval_Id']");
	private By closeBtn=By.xpath("//div//button[@accesskey='x']");

	//private By exportToCSV=By.xpath("//ul[@class='dropdown-menu']//li//a[@id='exportToCSV']");
	private By viewTab=By.cssSelector("div.ig-navbar-menu li#View_Menu");
	private By balanceMenu=By.cssSelector("div.ig-navbar-menu li#View_Menu div.container-accordion-inner ul li a#View_Balance_Menu");
	private By viewBalanceText=By.cssSelector("div.buttonbar div h2");
	//private By getDetailsOnPage = By.cssSelector("div#main-content div.content.ig-old-layout.ig-host-key.ng-scope div#formBalances div#tblBalancing table tbody tr td");

	private By getDetailsOnPage = By.xpath("//div[@id='tblBalancing']//table[@class='datagrid']//tbody");
	private By viewOnBalacePage=By.cssSelector("div#tblBalancing table tbody tr td button.btn-primary.btn-secured");
	private By refreshBalanceButton=By.xpath("//button[@id='buttonRefreshBalance'][contains(.,'Refresh Balance')]");
	private By viewOnDetailsPage = By.cssSelector("button#buttonView");
	private By okViewOnDetailsPage = By.cssSelector("button[data-ig-type='OK']");
	private By voidOnDetailsPage = By.cssSelector("button#buttonVoid");
	private By voidNoButton = By.cssSelector("button[data-ig-type='NO']");
	private By voidYesButton = By.cssSelector("button[data-ig-type='YES']");
	private By voidOKButton = By.cssSelector("button[data-ig-type='OK']");
	private By selecttransaction = By.cssSelector("td[data-grid-column-key='Status']");
	private By pageselect = By.cssSelector("a[ng-hide='pageNumber === results.currentPageNo']");
	private By popUpTitle = By.xpath("//h2[@class='modal-title']");
	private By selectRecord = By.xpath("//table[@class='grid datagrid']//tbody//tr[2]");	
	private By pageTitle = By.xpath("//h2[@id='layoutCaption']");	
	private By tableCountRecords= By.xpath("//table[@class='grid datagrid']//tbody");


	//private By transcationDetails_GamingDate= By.xpath("//label[contains(.,'Gaming Date')]");
	private By transcationDetails_GamingDate= By.xpath("th[contains(.,'Gaming Date')]");
	private By transcationDetails_GamingDateValue= By.xpath("//label[contains(.,'Gaming Date')]//following-sibling::span");	
	private By transcationDetails_CashDesk= By.xpath("//label[contains(text(),'Cash Desk')]");
	private By transcationDetails_CashDeskValue= By.xpath("//label[contains(text(),'Cash Desk')]/following-sibling::span");
	private By transcationDetails_TransactionType= By.xpath("//label[contains(.,'Transaction Type')]");
	private By transcationDetails_TransactionTypeValue= By.xpath("//label[contains(.,'Transaction Type')]//following-sibling::span");
	private By transcationDetails_Account= By.xpath("//label[contains(.,'Account')]");
	//private By transcationDetails_AccountValue= By.xpath("//div//div[2]//div[@class='two-col']//div[1]//div[4]//span");
	private By transcationDetails_AccountValue= By.xpath("//label[contains(.,'Account')]//following-sibling::span");

	private By transcationDetails_ActualDateTime= By.xpath("//label[contains(.,'Actual Date / Time')]");
	//private By transcationDetails_ActualDateTimeValue= By.xpath("//div//div[2]//div[@class='two-col']//div[2]//div[1]//span");

	private By transcationDetails_ActualDateTimeValue= By.xpath("//label[contains(.,'Actual Date / Time')]//following-sibling::span");

	private By transcationDetails_CasinoValue= By.xpath("//label[contains(text(),'Casino')]//following-sibling::span");	

	private By transcationDetails_status= By.xpath("//label[contains(.,'Status')]");
	private By transcationDetails_statusValue= By.xpath("//label[contains(.,'Status')]//following-sibling::span");

	private By transcationDetails_Reference= By.xpath("//label[contains(.,'Reference')]");
	private By transcationDetails_ReferenceValue= By.xpath("//label[contains(.,'Reference')]//following-sibling::span");

	private By transcationDetails_OtherDetails= By.xpath("//label[contains(.,'Other Details')]");
	private By transcationDetails_OtherDetailsValue= By.xpath("//label[contains(.,'Other Details')]//following-sibling::span");

	private By transcationDetails_Asset= By.xpath("//th[@data-grid-column-key='Asset']");
	private By transcationDetails_Quantity= By.xpath("//th[@data-grid-column-key='Quantity']");
	private By transcationDetails_value= By.xpath("//th[@data-grid-column-key='Value']");

	private By transcationDetails_Currency= By.xpath("//label[contains(.,'Currency')]");
	private By transcationDetails_CurrencyValue= By.xpath("//label[contains(.,'Currency')]//following-sibling::span");

	private By transcationDetails_ForeignAmount= By.xpath("//label[contains(.,'Foreign Amount')]");
	private By transcationDetails_ForeignAmountValue= By.xpath("//label[contains(.,'Foreign Amount')]//following-sibling::span");

	private By transcationDetails_PaymentAmount= By.xpath("//label[contains(.,'Payment Amount')]");
	private By transcationDetails_PaymentAmountValue= By.xpath("//label[contains(.,'Payment Amount')]//following-sibling::span");

	private By transcationDetails_ForeignRemaining= By.xpath("//label[contains(.,'Foreign Remaining')]");
	private By transcationDetails_ForeignRemainingValue= By.xpath("//label[contains(.,'Foreign Remaining')]//following-sibling::span");
	private By transcationDetails_ExchangeRate= By.xpath("//label[contains(.,'Exchange Rate')]");
	private By transcationDetails_ExchangeRateValue= By.xpath("//label[contains(.,'Exchange Rate')]//following-sibling::span");

	private By transcationDetails_ValuRemaining= By.xpath("//label[contains(.,'Value Remaining')]");
	private By transcationDetails_ValueRemainingValue= By.xpath("//label[contains(.,'Value Remaining')]//following-sibling::span");
	private By transcationDetails_Audit= By.xpath("//legend[contains(.,'Audit')]");

	private By transcationDetails_CreditAccount= By.xpath("//legend[contains(.,'Credit Account')]");

	private By transcationDetails_Name= By.xpath("//label[contains(.,'Name')]");
	private By transcationDetails_NameValue= By.xpath("//label[contains(.,'Name')]//following-sibling::span");


	private By transcationDetails_DateOfBirth= By.xpath("//label[contains(.,'Date Of Birth')]");
	private By transcationDetails_DateOfBirthValue= By.xpath("//label[contains(.,'Date Of Birth')]//following-sibling::span");

	private By transcationDetails_Number= By.xpath("//label[contains(.,'Number')]");
	private By transcationDetails_NumberValue= By.xpath("//label[contains(.,'Number')]//following-sibling::span");


	private By transcationDetails_Type= By.xpath("//label[contains(.,'Type')]");
	private By transcationDetails_TypeValue= By.xpath("//label[contains(.,'Type')]//following-sibling::span");

	private By transcationDetails_AccountNumber= By.xpath("//label[contains(.,'Account Number')]");
	private By transcationDetails_AccountNumberValue= By.xpath("//label[contains(.,'Account Number')]//following-sibling::span");

	private By transcationDetails_Amount= By.xpath("//label[contains(.,'Amount')]");
	private By transcationDetails_AmountValue= By.xpath("//label[contains(.,'Amount')]//following-sibling::span");

	private By transcationDetails_ChequeDate= By.xpath("//label[contains(.,'Cheque Date')]");
	private By transcationDetails_ChequeDateValue= By.xpath("//label[contains(.,'Cheque Date')]//following-sibling::span");
	private By transcationDetails_ClearanceType= By.xpath("//label[contains(.,'Clearance Type')]");
	private By transcationDetails_ClearanceTypeValue= By.xpath("//label[contains(.,'Clearance Type')]//following-sibling::span");

	private By transcationDetails_ScheduledBankingDate= By.xpath("//label[contains(.,'Scheduled Banking Date')]");
	private By transcationDetails_ScheduledBankingDateValue= By.xpath("//label[contains(.,'Scheduled Banking Date')]//following-sibling::span");


	private By Balance_OpeningSection = By.xpath("//tbody//tr[2]//td[1][contains(.,'Opening')]");
	private By Balance_OpeningSection_Cash = By.xpath("//tbody//tr[2]//td[2][contains(.,'Cash')]");
	private By Balance_OpeningSection_CashBalance = By.xpath("//tbody//tr[2]//td[4]//span");

	private By Balance_OpeningSection_Chips = By.xpath("//tbody//tr[3]//td[2][contains(.,'Chips')]");
	private By Balance_OpeningSection_ChipsBalance = By.xpath("//tbody//tr[3]//td[4]//span");

	private By Balance_OpeningSection_ForeignCurrency = By.xpath("//tbody//tr[4]//td[2][contains(.,'Foreign Currency')]");
	private By Balance_OpeningSection_ForeignCurrencyBalance = By.xpath("//tbody//tr[4]//td[4]//span");

	private By Balance_OpeningSection_Credit = By.xpath("//tbody//tr[5]//td[2][contains(.,'Credit')]");
	private By Balance_OpeningSection_CreditBalance = By.xpath("//tbody//tr[5]//td[4]//span");


	private By Balance_TransactionsSection = By.xpath("//tbody//tr[6]//td[1][contains(.,'Transactions')]");
	private By Balance_TransactionsSection_Cash = By.xpath("//tbody//tr[6]//td[2][contains(.,'Cash Transactions')]");
	private By Balance_TransactionsSection_CashBalance = By.xpath("//tbody//tr[6]//td[4]//span");

	private By Balance_TransactionsSection_Chips = By.xpath("//tbody//tr[7]//td[2][contains(.,'Chip Transactions')]");
	private By Balance_TransactionsSection_ChipsBalance = By.xpath("//tbody//tr[7]//td[4]//span");

	private By Balance_TransactionsSection_TableCount = By.xpath("//tbody//tr[8]//td[2][contains(.,'Table Count')]");
	private By Balance_TransactionsSection_TableCountBalance = By.xpath("//tbody//tr[8]//td[4]//span");

	private By Balance_TransactionsSection_MachineCount = By.xpath("//tbody//tr[9]//td[2][contains(.,'Machine Count')]");
	private By Balance_TransactionsSection_MachineCountBalance = By.xpath("//tbody//tr[9]//td[4]//span");

	private By Balance_TransactionsSection_Tips = By.xpath("//tbody//tr[10]//td[2][contains(.,'Tips')]");
	private By Balance_TransactionsSection_TipsBalance = By.xpath("//tbody//tr[10]//td[4]//span");



	//private By Balance_ClosingSection = By.xpath("//tbody//tr[11]//td[1][contains(.,'Closing')]");
	private By Balance_ClosingSection = By.xpath("//td[contains(.,'Closing')]");	
	private By Balance_ClosingSection_Cash = By.xpath("//tbody//tr[11]//td[2][contains(.,'Cash')]");
	//private By Balance_ClosingSection_CashBalance = By.xpath("//td[contains(.,'Closing')]//following-sibiling::span");
	private By Balance_ClosingSection_CashBalance = By.xpath("//tbody//tr[11]//td[3]//span");

	private By Balance_ClosingSection_Chips = By.xpath("//tbody//tr[12]//td[2][contains(.,'Chips')]");
	private By Balance_ClosingSection_ChipsBalance = By.xpath("//tbody//tr[12]//td[3]//span");

	private By Balance_ClosingSection_ForeignCurrency = By.xpath("//tbody//tr[13]//td[2][contains(.,'Foreign Currency')]");
	private By Balance_ClosingSection_ForeignCurrencyBalance = By.xpath("//tbody//tr[13]//td[3]//span");

	private By Balance_ClosingSection_Credit = By.xpath("//tbody//tr[14]//td[2][contains(.,'Credit')]");
	private By Balance_ClosingSection_CreditBalance = By.xpath("//tbody//tr[14]//td[3]//span");

	private By Balance_SummarySection = By.xpath("//td[contains(.,'Summary')]");
	private By Balance_SummarySection_TotalBalance = By.xpath("//tbody//tr[15]//td[3]//span");
	private By Balance_SummarySection_TotalBalance1 = By.xpath("//tbody//tr[15]//td[4]//span");

	private By Balance_StatusSection = By.xpath("//td[contains(.,'Status')]");
	//private By Balance_Status = By.xpath("//tbody//tr[16]//td[4]//span");
	private By Balance_Status_Balance = By.xpath("//tfoot//tr//td[3]//span");
	private By Balance_Status_Over = By.xpath("//tfoot//tr//td[4]//span");
	
	public void viewTransactionOfThroughoutGamingDay(){		
		try 
		{		
			clickView_Balance();
			objWrapperFunctions.waitForElementPresence(viewOnBalacePage);
			objUtilities.logReporter("Click on View Button on balance Page", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(viewOnBalacePage, 0)), false);
			Thread.sleep(5000);	
			SetFilter();
			Thread.sleep(20000);
			viewTransactionDetails();

			clickView_Balance();	
			objUtilities.logReporter("Click on View Button on balance Page", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(viewOnBalacePage, 1)), false);
			SetFilter();
			Thread.sleep(12000);
			viewTransactionDetails();

			clickView_Balance();	
			objUtilities.logReporter("Click on View Button on balance Page", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(viewOnBalacePage, 2)), false);
			//SetFilter();
			System.out.println(objWrapperFunctions.getText(pageTitle));
			//objWrapperFunctions.displayTableContent(tableCountRecords);
			objUtilities.logReporter("Click on closeBtn", objWrapperFunctions.click(closeBtn), false);

			clickView_Balance();	
			objUtilities.logReporter("Click on View Button on balance Page", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(viewOnBalacePage, 4)), false);
			//SetFilter();
			System.out.println(objWrapperFunctions.getText(pageTitle));
			objWrapperFunctions.displayTableContent(tableCountRecords);
			objUtilities.logReporter("Click on closeBtn", objWrapperFunctions.click(closeBtn), false);

			clickView_Balance();	
			objUtilities.logReporter("Click on View Button on balance Page", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(viewOnBalacePage, 7)), false);
			objUtilities.logReporter("Click on find button ", objWrapperFunctions.click(findBtn), false);
			Thread.sleep(8000);
			objUtilities.logReporter("Click on record ", objWrapperFunctions.click(selectRecord), false);
			//viewTransactionDetails();
			viewCurrencyTranscationDetails();

			clickView_Balance();	
			objUtilities.logReporter("Click on View Button on balance Page", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(viewOnBalacePage, 8)), false);
			objUtilities.logReporter("Click on find button ", objWrapperFunctions.click(findBtn), false);
			Thread.sleep(8000);
			viewCreditTranscationDetails();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void SetFilter()
	{
		objUtilities.logReporter("Click on collpse button ", objWrapperFunctions.click(collapsedBtn), false);	
		objUtilities.logReporter("Click on DateRange dropdown ", objWrapperFunctions.click(DateRangeDropDown), false);
		objUtilities.logReporter("select This Calendar Quarter option ", objWrapperFunctions.click(DateRangeDropDown_ThisCalendarQuarter), false);
		objUtilities.logReporter("Click on find button ", objWrapperFunctions.click(findBtn), false);

	}
	public void viewTransactionDetails()
	{
		try
		{
			objWrapperFunctions.waitForElementToBeClickable(viewOnDetailsPage);
			objUtilities.logReporter("Click on View Button on balance Page", objWrapperFunctions.click(viewOnDetailsPage), false);		
			Thread.sleep(500);
			System.out.println(objWrapperFunctions.getText(popUpTitle)+ " Details pop up displayed");
			objUtilities.logReporter("verify gaming date label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_GamingDate), false);	
			System.out.println("Gaming Date : "+objWrapperFunctions.getText(transcationDetails_GamingDateValue));

			//objUtilities.logReporter("verify Cash Desk label presence", objWrapperFunctions.checkElementDisplyed(transcationDetails_CashDesk), false);
			//System.out.println("Cash Desk : "+objWrapperFunctions.getText(transcationDetails_CashDesk));
			System.out.println("Cash Desk : "+objWrapperFunctions.getText(transcationDetails_CashDeskValue));

			objUtilities.logReporter("verify Transaction Type label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_TransactionType), false);	
			System.out.println("Transaction Type: "+objWrapperFunctions.getText(transcationDetails_TransactionTypeValue));

			objUtilities.logReporter("verify Account label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_Account), false);	
			System.out.println("Account : "+objWrapperFunctions.getText(transcationDetails_AccountValue));

			objUtilities.logReporter("verify  ActualDateTime label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_ActualDateTime), false);	
			System.out.println("Actual DateTime : "+objWrapperFunctions.getText(transcationDetails_ActualDateTimeValue));

			//objUtilities.logReporter("verify Casino label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_Casino), false);	
			System.out.println("Casino : "+objWrapperFunctions.getText(transcationDetails_CasinoValue));

			objUtilities.logReporter("verify status label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_status), false);	
			System.out.println("status: "+objWrapperFunctions.getText(transcationDetails_statusValue));




			objUtilities.logReporter("verify Reference label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_Reference), false);	
			System.out.println("Reference : "+objWrapperFunctions.getText(transcationDetails_ReferenceValue));

			objUtilities.logReporter("verify OtherDetails label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_OtherDetails), false);	
			System.out.println("Other Details : "+objWrapperFunctions.getText(transcationDetails_OtherDetailsValue));

			objUtilities.logReporter("verify Asset label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_Asset), false);	

			objUtilities.logReporter("verify Quantity label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_Quantity), false);	
			objUtilities.logReporter("verify Value label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_value), false);	
			objWrapperFunctions.verifyIsElementPresent(okViewOnDetailsPage);
			objWrapperFunctions.waitForElementToBeClickable(okViewOnDetailsPage);

			objUtilities.logReporter("Click on ok Button on balance Page", objWrapperFunctions.doubleClick(okViewOnDetailsPage), false);	
			objWrapperFunctions.waitForElementToBeClickable(closeBtn);
			objUtilities.logReporter("Click on closeBtn", objWrapperFunctions.click(closeBtn), false);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void viewCurrencyTranscationDetails()
	{
		objUtilities.logReporter("Click on View Button on balance Page", objWrapperFunctions.click(viewOnDetailsPage), false);		
		try {
			Thread.sleep(5000);

			System.out.println(objWrapperFunctions.getText(popUpTitle)+ " Details pop up displayed");
			objUtilities.logReporter("verify gaming date label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_GamingDate), false);	
			System.out.println("Gaming Date : "+objWrapperFunctions.getText(transcationDetails_GamingDateValue));

			System.out.println("Cash Desk : "+objWrapperFunctions.getText(transcationDetails_CashDeskValue));

			objUtilities.logReporter("verify Transaction Type label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_TransactionType), false);	
			System.out.println("Transaction Type: "+objWrapperFunctions.getText(transcationDetails_TransactionTypeValue));

			objUtilities.logReporter("verify Currency label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_Currency), false);	
			System.out.println("Currency : "+objWrapperFunctions.getText(transcationDetails_CurrencyValue));


			objUtilities.logReporter("verify Foreign Amount label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_ForeignAmount), false);	
			System.out.println("Foreign Amount Type: "+objWrapperFunctions.getText(transcationDetails_ForeignAmountValue));

			objUtilities.logReporter("verify Payment Amount label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_PaymentAmount), false);	
			System.out.println("Payment Amount : "+objWrapperFunctions.getText(transcationDetails_PaymentAmountValue));

			objUtilities.logReporter("verify Foreign Remaining label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_ForeignRemaining), false);	
			System.out.println("Foreign Remaining : "+objWrapperFunctions.getText(transcationDetails_ForeignRemainingValue));

			objUtilities.logReporter("verify Exchange Rate label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_ExchangeRate), false);	
			System.out.println("Exchange Rate : "+objWrapperFunctions.getText(transcationDetails_ExchangeRateValue));


			objUtilities.logReporter("verify  ActualDateTime label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_ActualDateTime), false);	
			System.out.println("Actual DateTime : "+objWrapperFunctions.getText(transcationDetails_ActualDateTimeValue));

			//objUtilities.logReporter("verify Casino label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_Casino), false);	
			System.out.println("Casino : "+objWrapperFunctions.getText(transcationDetails_CasinoValue));

			objUtilities.logReporter("verify status label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_status), false);	
			System.out.println("status: "+objWrapperFunctions.getText(transcationDetails_statusValue));

			objUtilities.logReporter("verify Audit label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_Audit), false);	
			objWrapperFunctions.waitForElementToBeClickable(okViewOnDetailsPage);
			objUtilities.logReporter("Click on ok Button on balance Page", objWrapperFunctions.doubleClick(okViewOnDetailsPage), false);	
			objWrapperFunctions.waitForElementToBeClickable(closeBtn);
			objUtilities.logReporter("Click on closeBtn", objWrapperFunctions.click(closeBtn), false);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void viewCreditTranscationDetails()
	{

		objUtilities.logReporter("Click on View Button on balance Page", objWrapperFunctions.click(viewOnDetailsPage), false);		
		try {
			Thread.sleep(5000);

			System.out.println(objWrapperFunctions.getText(popUpTitle)+ " Details pop up displayed");

			objUtilities.logReporter("verify Credit Account label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_CreditAccount), false);

			objUtilities.logReporter("verify Name label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_Name), false);	
			System.out.println("Name  : "+objWrapperFunctions.getText(transcationDetails_NameValue));


			objUtilities.logReporter("verify Number label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_Number), false);	
			System.out.println("Number : "+objWrapperFunctions.getText(transcationDetails_NumberValue));

			objUtilities.logReporter("verify  transcationDetails_DateOfBirth label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_DateOfBirth), false);	
			System.out.println("Date Of Birth : "+objWrapperFunctions.getText(transcationDetails_DateOfBirthValue));


			objUtilities.logReporter("verify gaming date label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_GamingDate), false);	
			System.out.println("Gaming Date : "+objWrapperFunctions.getText(transcationDetails_GamingDateValue));

			System.out.println("Cash Desk : "+objWrapperFunctions.getText(transcationDetails_CashDeskValue));

			objUtilities.logReporter("verify Transaction Type label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_TransactionType), false);	
			System.out.println("Transaction Type: "+objWrapperFunctions.getText(transcationDetails_TransactionTypeValue));


			objUtilities.logReporter("verify _Type label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_Type), false);	
			System.out.println("TypeValue : "+objWrapperFunctions.getText(transcationDetails_TypeValue));


			objUtilities.logReporter("verify AccountNumber label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_AccountNumber), false);	
			System.out.println("Account Number: "+objWrapperFunctions.getText(transcationDetails_AccountNumberValue));

			objUtilities.logReporter("verify  ActualDateTime label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_ActualDateTime), false);	
			System.out.println("Actual DateTime : "+objWrapperFunctions.getText(transcationDetails_ActualDateTimeValue));

			objUtilities.logReporter("verify  Amount label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_Amount), false);	
			System.out.println("Amount : "+objWrapperFunctions.getText(transcationDetails_AmountValue));


			objUtilities.logReporter("verify Reference label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_Reference), false);	
			System.out.println("Reference : "+objWrapperFunctions.getText(transcationDetails_ReferenceValue));

			objUtilities.logReporter("verify Cheque Date label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_ChequeDate), false);		
			System.out.println("Cheque Date : "+objWrapperFunctions.getText(transcationDetails_ChequeDateValue));

			/*objUtilities.logReporter("verify Clearance Type presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_ClearanceType), false);	
			System.out.println("Clearance Type: "+objWrapperFunctions.getText(transcationDetails_ClearanceTypeValue));

			objUtilities.logReporter("verify  Scheduled Banking Date label presence", objWrapperFunctions.verifyIsElementPresent(transcationDetails_ScheduledBankingDate), false);	
			System.out.println("Scheduled Banking Date : "+objWrapperFunctions.getText(transcationDetails_ScheduledBankingDateValue));

*/
			objWrapperFunctions.waitForElementToBeClickable(okViewOnDetailsPage);
			objUtilities.logReporter("Click on ok Button on balance Page", objWrapperFunctions.doubleClick(okViewOnDetailsPage), false);	
			objWrapperFunctions.waitForElementToBeClickable(closeBtn);
			objUtilities.logReporter("Click on closeBtn", objWrapperFunctions.click(closeBtn), false);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public void viewAndVoidTransaction(){

		try
		{	

			System.out.println("****************** Viewing Transaction ******************");
			int r = objWrapperFunctions.randomNumberBetween(1,0);
			objUtilities.logReporter("Click on View Button on balance Page", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(viewOnBalacePage, r)), false);
			Thread.sleep(2000);	
			/*objUtilities.logReporter("Click on collpse button ", objWrapperFunctions.click(collapsedBtn), false);

		objUtilities.logReporter("Click on DateRange dropdown ", objWrapperFunctions.click(DateRangeDropDown), false);
		objUtilities.logReporter("select This Calendar Quarter option ", objWrapperFunctions.click(DateRangeDropDown_ThisCalendarQuarter), false);
			 */
			objUtilities.logReporter("Click on find button ", objWrapperFunctions.click(findBtn), false);

			Thread.sleep(8000);
			objUtilities.logReporter("Click on View Button on balance Page", objWrapperFunctions.click(viewOnDetailsPage), false);

			Thread.sleep(5000);


			objUtilities.logReporter("Click on ok Button on balance Page", objWrapperFunctions.click(okViewOnDetailsPage), false);

			//objUtilities.logReporter("Click on closeBtn", objWrapperFunctions.click(closeBtn), false);

			Thread.sleep(8000);
			//int t = objWrapperFunctions.randomNumberBetween(3,0);
			//objUtilities.logReporter("Select Page", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(pageselect, t)), false);

			//Thread.sleep(4000);

			//int s = objWrapperFunctions.randomNumberBetween(15,3);

			objUtilities.logReporter("Click on View Button on balance Page", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(selecttransaction, 0)), false);

			objUtilities.logReporter("Click on Void Button on details Page", objWrapperFunctions.click(voidOnDetailsPage), false);
			objUtilities.logReporter("Click on Void - No Button on details Page", objWrapperFunctions.click(voidNoButton), false);
			objUtilities.logReporter("Click on Void Button on details Page", objWrapperFunctions.click(voidOnDetailsPage), false);
			objUtilities.logReporter("Click on Void - Yes Button on details Page", objWrapperFunctions.click(voidYesButton), false);
			Thread.sleep(2000);
			objUtilities.logReporter("Click on Void - OK Button on details Page", objWrapperFunctions.click(voidOKButton), false);

		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void clickView_Balance()
	{
		objUtilities.logReporter("Click on view tab", objWrapperFunctions.clickByScript(viewTab), false);
		objUtilities.logReporter("Click on Balance Menu", objWrapperFunctions.clickByScript(balanceMenu), false);

	}

	public void viewBalanceCheckDetails()
	{
		try
		{	

			Thread.sleep(2000);
			System.out.println("****************** Balance Details Verification ******************");
			objUtilities.logReporter("Click on view tab", objWrapperFunctions.click(viewTab), false);
			objUtilities.logReporter("Click on Balance Menu", objWrapperFunctions.click(balanceMenu), false);
			objUtilities.logReporter("Verify View Balance text", objWrapperFunctions.checkElementDisplyed(viewBalanceText), false);
			objUtilities.logReporter("Verify Refresh button displayed", objWrapperFunctions.checkElementDisplyed(refreshBalanceButton), false);
			objUtilities.logReporter("Verify View Details text", objWrapperFunctions.checkElementDisplyed(getDetailsOnPage), false);	
			System.out.println("Balance text: "+objWrapperFunctions.getText(viewBalanceText));
			objUtilities.logReporter("Verify  Opening section is present on Balance details page", objWrapperFunctions.verifyIsElementPresent(Balance_OpeningSection), false);
			objUtilities.logReporter("Verify  opening balance amount displayed  for the cash", objWrapperFunctions.verifyIsElementPresent(Balance_OpeningSection_Cash), false);
			System.out.println("Opening Section_Cash  :"+objWrapperFunctions.getText(Balance_OpeningSection_CashBalance));


			objUtilities.logReporter("Verify  Opening section is present on Balance details page", objWrapperFunctions.verifyIsElementPresent( Balance_OpeningSection_Chips), false);
			objUtilities.logReporter("Verify  opening balance amount displayed  for the chips", objWrapperFunctions.verifyIsElementPresent(Balance_OpeningSection_ChipsBalance), false);
			System.out.println("Opening Section_Chips  :"+objWrapperFunctions.getText(Balance_OpeningSection_ChipsBalance));

			objUtilities.logReporter("Verify  Opening section is present on Balance details page", objWrapperFunctions.verifyIsElementPresent(Balance_OpeningSection_ForeignCurrency), false);
			objUtilities.logReporter("Verify  opening balance amount displayed  for the cash", objWrapperFunctions.verifyIsElementPresent(Balance_OpeningSection_ForeignCurrencyBalance), false);
			System.out.println("Opening Section_Foreign Currency  :"+objWrapperFunctions.getText(Balance_OpeningSection_ForeignCurrencyBalance));


			objUtilities.logReporter("Verify  Opening section is present on Balance details page", objWrapperFunctions.verifyIsElementPresent(Balance_OpeningSection_Credit), false);
			objUtilities.logReporter("Verify  opening balance amount displayed  for the credit", objWrapperFunctions.verifyIsElementPresent(Balance_OpeningSection_CreditBalance), false);
			System.out.println("Opening Section_credit  :"+objWrapperFunctions.getText(Balance_OpeningSection_CreditBalance));

			objUtilities.logReporter("Verify  Transcation section is present on Balance details page", objWrapperFunctions.verifyIsElementPresent(Balance_TransactionsSection), false);
			objUtilities.logReporter("Verify  Transactions cash section is present on Balance details page", objWrapperFunctions.verifyIsElementPresent(Balance_TransactionsSection_Cash), false);
			objUtilities.logReporter("Verify  Transactions balance amount displayed  for the cash", objWrapperFunctions.verifyIsElementPresent(Balance_TransactionsSection_CashBalance), false);
			System.out.println("Transactions Section_CashBalance :"+objWrapperFunctions.getText(Balance_TransactionsSection_CashBalance));

			objUtilities.logReporter("Verify  Transactions chips section is present on Balance details page", objWrapperFunctions.verifyIsElementPresent(Balance_TransactionsSection_Chips), false);
			objUtilities.logReporter("Verify  Transactions balance amount displayed  for the chips", objWrapperFunctions.verifyIsElementPresent(Balance_TransactionsSection_ChipsBalance), false);
			System.out.println("Transactions Section_ChipsBalance :"+objWrapperFunctions.getText(Balance_TransactionsSection_ChipsBalance));

			objUtilities.logReporter("Verify  Transactions Table section is present on Balance details page", objWrapperFunctions.verifyIsElementPresent(Balance_TransactionsSection_TableCount), false);
			objUtilities.logReporter("Verify  Transactions balance amount displayed  for the Table", objWrapperFunctions.verifyIsElementPresent(Balance_TransactionsSection_TableCountBalance), false);
			System.out.println("Transactions Section_Table Count :"+objWrapperFunctions.getText(Balance_TransactionsSection_TableCountBalance));


			objUtilities.logReporter("Verify  Transactions Machine section is present on Balance details page", objWrapperFunctions.verifyIsElementPresent(Balance_TransactionsSection_MachineCount), false);
			objUtilities.logReporter("Verify  Transactions balance amount displayed  for the Machine ", objWrapperFunctions.verifyIsElementPresent(Balance_TransactionsSection_MachineCountBalance), false);
			System.out.println("Transactions Section_Machine Count :"+objWrapperFunctions.getText(Balance_TransactionsSection_MachineCountBalance));

			objUtilities.logReporter("Verify  Transactions Tips section is present on Balance details page", objWrapperFunctions.verifyIsElementPresent(Balance_TransactionsSection_Tips), false);
			objUtilities.logReporter("Verify  Transactions balance amount displayed  for the Tips", objWrapperFunctions.verifyIsElementPresent(Balance_TransactionsSection_TipsBalance), false);
			System.out.println("Transactions Section_Tips Count :"+objWrapperFunctions.getText(Balance_TransactionsSection_TipsBalance));


			objUtilities.logReporter("Verify  Closing Section is present on Balance details page", objWrapperFunctions.verifyIsElementPresent(Balance_ClosingSection), false);
			objUtilities.logReporter("Verify  Closing  balance amount displayed  for the cash", objWrapperFunctions.verifyIsElementPresent(Balance_ClosingSection_Cash), false);
			System.out.println("Closing Section_Cash Balance :"+objWrapperFunctions.getText(Balance_ClosingSection_CashBalance));

			objUtilities.logReporter("Verify  Closing  balance amount displayed  for the chips", objWrapperFunctions.verifyIsElementPresent(Balance_ClosingSection_Chips), false);
			System.out.println("Closing Section_chips Balance :"+objWrapperFunctions.getText(Balance_ClosingSection_ChipsBalance));

			objUtilities.logReporter("Verify  Closing Section is present on Balance details page", objWrapperFunctions.verifyIsElementPresent(Balance_ClosingSection_ForeignCurrency), false);
			objUtilities.logReporter("Verify  Closing  balance amount displayed  for the ForeignCurrency", objWrapperFunctions.verifyIsElementPresent(Balance_ClosingSection_ForeignCurrencyBalance), false);
			System.out.println("Closing Section_Foreign Currency :"+objWrapperFunctions.getText(Balance_ClosingSection_ForeignCurrencyBalance ));

			objUtilities.logReporter("Verify  Closing Section is present on Balance details page", objWrapperFunctions.verifyIsElementPresent(Balance_ClosingSection_Credit), false);
			objUtilities.logReporter("Verify  Closing  balance amount displayed  for the Credit", objWrapperFunctions.verifyIsElementPresent(Balance_ClosingSection_CreditBalance), false);
			System.out.println("Closing Section_Credit Balance :"+objWrapperFunctions.getText(Balance_ClosingSection_CreditBalance));

			objUtilities.logReporter("Verify  Summary Section is present on Balance details page", objWrapperFunctions.verifyIsElementPresent(Balance_SummarySection), false);
			System.out.println("Summary Total Balance :"+objWrapperFunctions.getText(Balance_SummarySection_TotalBalance));
			System.out.println("Total Balance :"+objWrapperFunctions.getText(Balance_SummarySection_TotalBalance1));
			
			objUtilities.logReporter("Verify  status Section is present on Balance details page", objWrapperFunctions.verifyIsElementPresent(Balance_StatusSection), false);
			
			String status = objWrapperFunctions.getText(Balance_Status_Balance);
			System.out.println(status);
			if(status.contains("over"))
			{
				System.out.println("Balance :"+objWrapperFunctions.getText(Balance_Status_Balance));
			}
			else
			{
				System.out.println("Balance :"+objWrapperFunctions.getText(Balance_Status_Over));
			}
			

		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
