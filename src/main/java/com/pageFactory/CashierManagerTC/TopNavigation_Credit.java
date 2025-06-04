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

public class TopNavigation_Credit extends TopNavigation_CashDesk
{
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	String message="";
	String NeonUser,NeonPass;
	static int reqIndex;
	static int tempRandom,cardLastFourDigits,expiry_month,expiry_year ;
	static String name,lastname,nameArray[],ref;
	static char firstChar;
	static char secondChar;
	static int creditAccNum,transcationCode;
	static int selectMatch;
	//ExcelIterator objExcel=new ExcelIterator();
	static String refId_FE="",custName="",date="",cardnum="", conDate="",custDOB,customerNumer,custDebitNum;
	//static int cardnum;
	static String customerNum,temp,accNumber,custNum,customerDOB;

	public TopNavigation_Credit(Pojo pojo){
		super(pojo);
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
		customerNum=pojo.getUser();
		creditAccNum=Integer.parseInt(customerNum);
		custName =pojo.getUser1Values();
		custDOB = pojo.getUserDOB();
		custDebitNum = pojo.getDebitCardNum();
	}

	private By userName=By.id("Username");
	private By password=By.id("Password");
	private By signBtn=By.xpath("//button[@class='btn btn-lg btn-primary btn-block ig-signin-button']");
	private By okBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'OK')]");
	private By okButton=By.xpath("//button[@data-ig-type='OK']");

	private By topNavigationCredit = By.cssSelector("li#Credit_Menu");
	private By credit_thirdPartyAccount = By.cssSelector("a#Credit_ThirdPartyAccounts_Menu");
	private By thirdPartyAcc_FindButton = By.cssSelector("button#buttonFind");
	private By thirdPartyAcc_CreateNewButton = By.cssSelector("button#buttonNew");
	private By inputBankAccNum = By.cssSelector("input#BankAccount_Number");
	private By inputBankAccName = By.cssSelector("input#BankAccount_Name");
	private By inputBankCode = By.cssSelector("input#textBoxBranchCode");
	private By inputBankName = By.cssSelector("input#textBoxBankName");
	private By inputBankBranchAddress = By.cssSelector("textarea#textBoxBranchAddress");
	private By inputComment = By.cssSelector("textarea#textBoxComment");
	private By thirdPartyAcc_SaveButton = By.cssSelector("button[accesskey='s']");

	private By thirdPartyAcc_FindAcc_EnterAccNum = By.cssSelector("input#AccountNumber");
	private By thirdPartyAcc_FindAcc_clickDetails = By.cssSelector("td.text-center button.btn-primary.btn-secured");

	private By thirdPartyAcc_FindAcc_ButtonDeleteAcc = By.cssSelector("button#buttonDelete");
	private By thirdPartyAcc_FindAcc_Delete_Message = By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'Access Denied.')]");


	private By credit_CreditAccounts=By.cssSelector("a#Credit_CreditAccounts_Menu");
	private By createNeCreditAcc_EnterAccNum = By.cssSelector("input#textBoxSearch");
	private By createnewCreditAcc_LowerLimit= By.cssSelector("input#CreditAccount_Limit");
	private By createnewCreditAcc_UpperLimit= By.cssSelector("input#CreditAccount_SecondaryLimit");
	//private By createnewCreditAcc_selectManager= By.cssSelector("td[data-grid-column-key='Surname']");
	private By createnewCreditAcc_selectManager= By.xpath("(//td[@class='ng-scope']//span)[1]");
	private By clickImage=By.cssSelector("div#857fd87d-bb38-4676-888b-3a1fa7bd633c");
	private By voidOKButton = By.cssSelector("button[data-ig-type='OK']");
	private By credit_CreditAccounts_CustName=By.xpath("//label[contains(.,'Name')]//following-sibling::span");

	private By credit_CreditAccounts_CustDOB=By.xpath("//label[contains(.,'Date Of Birth')]/following-sibling::span");

	private By creditAccount_findByAccNumber = By.cssSelector("input#Number");
	private By creditAccount_findButton = By.cssSelector("button#buttonFind");
	private By creditAccount_findAcc_Deatils = By.cssSelector("td.text-center button.btn-primary.btn-secured");
	private By creditAccount_findAcc_Deatils_Details=By.cssSelector("li#tabDetails a");
	private By creditAccount_findAcc_Deatils_Audit=By.cssSelector("li#tabAudit a");
	private By creditAccount_findAcc_Deatils_Authorisations=By.cssSelector("li#tabAuthorisations a");
	private By creditAccount_findAcc_Deatils_BankAccounts=By.cssSelector("li#tabBankAccounts a");
	private By creditAccount_findAcc_Deatils_BankReferences=By.cssSelector("li#tabBankReferences a");
	private By creditAccount_findAcc_Deatils_CasinoReferences=By.cssSelector("li#tabCasinoReferences a");
	private By creditAccount_findAcc_Deatils_Deposits=By.cssSelector("li#tabDeposits a");
	private By creditAccount_findAcc_Deatils_Identification=By.cssSelector("li#tabIdentification a");
	private By creditAccount_findAcc_Deatils_Messages=By.cssSelector("li#tabMessages a");
	private By creditAccount_findAcc_Deatils_Notes=By.cssSelector("li#tabNotes a");
	private By creditAccount_findAcc_Deatils_Summary=By.cssSelector("li#tabSummary a");
	private By creditAccount_findAcc_Deatils_Transactions=By.cssSelector("li#tabTransactions a");

	private By creditAccount_findAcc_addBankAcc_AddButton=By.cssSelector("button#buttonAdd");
	private By creditAccount_findAcc_addBankAcc_CheckBoxDebitCard=By.cssSelector("input#checkBoxDebitCard");
	private By creditAccount_findAcc_addBankAcc_debitCardDigits=By.cssSelector("input#textBoxDebitCardNumber");
	private By creditAccount_findAcc_addBankAcc_debitCardtextBoxExpiryMonth=By.cssSelector("input#textBoxExpiryMonth");
	private By creditAccount_findAcc_addBankAcc_debitCardtextBoxExpiryYear=By.cssSelector("input#textBoxExpiryYear");
	private By creditAccount_findAcc_addBankAcc_CommitButton=By.cssSelector("button[data-ig-type='Commit']");

	private By creditAccount_findAcc_getName=By.cssSelector("td[data-grid-column-key='Name'] span");
	private By creditAccount_debitCardMenu=By.cssSelector("li#Credit_DebitCards_Menu");
	private By creditAccount_debitCardMenu_AddDebitCard=By.cssSelector("a#DebitCards_AddDebitCard_Menu");
	private By creditAccount_debitCardMenu_inputSurnameAndCard=By.cssSelector("input#textBoxDebitCardNumber");
	private By creditAccount_debitCardMenu_matchButtons=By.cssSelector("button.btn-primary.btn-secured");
	private By creditAccount_debitCardMenu_sameCard=By.xpath("//button[@id='buttonSameCard'][contains(.,'Same Card')]");
	private By creditAccount_debitCardMenu_custDetails=By.xpath("//div[@class='col1']//fieldset//div");
	private By creditAccount_debitCardMenu_customerNumber=By.xpath("//input[@id='CustomerNumber']");

	private By  creditAccount_debitCardMenu_AccountNumberLabel =By.xpath("//label[contains(.,'Account Number')]");
	private By  creditAccount_debitCardMenu_AccountNumberValue =By.xpath("//label[contains(.,'Account Number')]//following-sibling::span");
	private By  creditAccount_debitCardMenu_AccountNameLabel =By.xpath("//label[contains(.,'Account Name')]");
	private By  creditAccount_debitCardMenu_AccountNameValue =By.xpath("//label[contains(.,'Account Name')]//following-sibling::span");
	private By  creditAccount_debitCardMenu_BankLabel =By.xpath("//label[contains(.,'Bank')]");
	private By  creditAccount_debitCardMenu_BankValue =By.xpath("//label[contains(.,'Bank')]//following-sibling::span");
	private By  creditAccount_debitCardMenu_CustomerNumberLabel =By.xpath("//div[@id='customerNumber']//following::label[contains(.,'Number')]");
	private By  creditAccount_debitCardMenu_CustomerNumberValue =By.xpath("//div[@id='customerNumber']//following-sibling::span");
	private By  creditAccount_debitCardMenu_CardTypeLabel =By.xpath("//label[contains(.,'Card Type')]");
	private By  creditAccount_debitCardMenu_CardTypeValue =By.xpath("//label[contains(.,'Card Type')]//following-sibling::span");
	private By  creditAccount_debitCardMenu_ExpiryDateLabel =By.xpath("//label[contains(.,'Expiry Date')]");
	private By  creditAccount_debitCardMenu_ExpiryDateValue =By.xpath("//label[contains(.,'Expiry Date')]//following-sibling::span");
	private By  creditAccount_debitCardMenu_AmountAvailableLabel =By.xpath("//label[contains(.,'Amount Available')]");
	private By  creditAccount_debitCardMenu_AmountAvailableValue =By.xpath("//label[contains(.,'Amount Available')]//following-sibling::span");

	private By creditAccount_debitCardMenu_DOBLabel = By.xpath("//label[contains(.,'Date of Birth')]");
	private By creditAccount_debitCardMenu_DOBValue = By.xpath("//label[contains(.,'Date of Birth')]//following-sibling::span");

	private By creditAccount_debitCardMenu_viewDebitCard=By.cssSelector("a#DebitCards_ViewDebitCard_Menu");
	private By creditAccount_debitCardMenu_viewDebitCard_transcationCode=By.xpath("//input[@id='textBoxReferenceNumber']");

	private By creditAccount_debitCardMenu_viewDebitCard_cardNum = By.xpath("//input[@id='textBoxCardNumber']");
	private By creditAccount_debitCardMenu_viewDebitCard_accountNum = By.xpath("//input[@id='textBoxAccountNumber']");
	private By creditAccount_debitCardMenu_viewDebitCard_amount= By.xpath("//input[@id='textBoxAmount']");


	//	private By voidConfirmationMsg = By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'Void debit card transaction - are you sure?')]");
	private By voidConfirmationMsg = By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'transaction - are you sure?')]");
	private By voidSuccessMsg = By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'transaction has been successfully voided.')]");

	private By creditAccount_debitCardMenu_viewDebitCradTransactions=By.cssSelector("td[data-grid-column-key='Reference']");
	private By creditAccount_debitCardMenu_viewDebitCradTransactions_statusVoid=By.xpath("//td[@data-grid-column-key='Status']//span[contains(.,'Void')]");
	private By creditAccount_debitCardMenu_viewDebitCradTransactions_statusHeld=By.xpath("//td[@data-grid-column-key='Status']//span[contains(.,'Held')]");

	private By creditAccount_debitCardMenu_viewDebitCradTransactions_status=By.xpath("//input[@id='textBoxStatus']");

	private By creditAccount_debitCardMenu_viewDebitCard_header=By.xpath("//h2[@id='layoutCaption'][contains(.,'View Debit Card Transaction')]");
	private By creditAccount_debitCardMenu_transactionType_Manual=By.xpath("//input[@id='radioButtonManual']");
	private By creditAccount_debitCardMenu_enterTransactionCode = By.cssSelector("input#textBoxTransactionCode");
	private By creditAccount_debitCardMenu_saveButton = By.cssSelector("button[accesskey='s']");
	private By creditAccount_debitCardMenu_inputAmount = By.cssSelector("input#textBoxAmount");

	private By creditAccount_GlobalCashMenu = By.cssSelector("li#Credit_GlobalCashItems_Menu");
	private By creditAccount_GlobalCashMenu_AddGlobalCash = By.cssSelector("a#GlobalCashItems_AddGlobalCash_Menu");
	private By creditAccount_addGlobalCash_customerNumber = By.cssSelector("input#textBoxCustomerNumber");
	private By creditAccount_addGlobalCash_enterAmount = By.cssSelector("input#textBoxAmount");
	private By creditAccount_GlobalCashMenu_ViewGlobalCash = By.cssSelector("a#GlobalCashItems_ViewGlobalCash_Menu");
	private By creditAccount_GlobalCashMenu_ViewGlobalCash_accNum = By.cssSelector("input#CustomerNumber");	
	private By creditAccount_GlobalCashMenu_ViewGlobalCash_accNumber = By.cssSelector("input#textBoxCustomerNumber");

	private By creditAccount_GlobalCashMenu_ViewGlobalCash_voidButton= By.cssSelector("button#buttonVoid");

	private By global_StatusDropDown = By.xpath("//select[@id='Status']");
	private By global_StatusDropDown_All = By.xpath("//option[@value='All']");

	private By voidYesButton = By.cssSelector("button[data-ig-type='YES']");

	private By creditAccount_chequeMenu=By.cssSelector("li#Credit_Cheques_Menu");
	private By creditAccount_debitCardMenu_AddCheque=By.cssSelector("a#Cheques_AddCheque_Menu");
	private By creditAccount_debitCardMenu_AddCheque_bankAccNum=By.cssSelector("input#textBoxBankAccountNumber");
	private By creditAccount_debitCardMenu_AddCheque_selectChequeType=By.cssSelector("select#dropDownType");
	//private By creditAccount_debitCardMenu_AddCheque_chequeNum=By.cssSelector("input#textBoxTransactionCode");// textBoxChequeNumber
	private By creditAccount_debitCardMenu_AddCheque_chequeNum=By.xpath("//input[@id='textBoxTransactionCode']");
	private By creditAccount_debitCardMenu_AddCheque_selectClearance=By.cssSelector("select#dropDownClearanceTypeWithoutForeign");
	private By creditAccount_debitCardMenu_AddCheque_enterAmount=By.cssSelector("input#textBoxAmountWithoutForeign");
	private By creditAccount_debitCardMenu_AddCheque_enterChequeDate=By.cssSelector("input#dateTimeChequeDate");
	private By creditAccount_debitCardMenu_AddCheque_custNumber=By.cssSelector("input#textBoxCustomerNumber");
	private By creditAccount_debitCardMenu_AddCheque_enterBankDate=By.cssSelector("input#dateTimeScheduledBankDate");

	private By creditAccount_debitCardMenu_voidDebitCard_succesMessage=By.xpath("//div[@class='modal-body ig-modal-scroll']");

	private By creditAccount_viewCheque=By.cssSelector("a#Cheques_ViewCheques_Menu");
	private By creditAccount_viewCheque_TodaysTransactions=By.cssSelector("td[data-grid-column-key='BankAccount'] span");

	//	private By creditAccount_viewCheque_TodaysTransactions_status=By.cssSelector("td[data-grid-column-key='Status'] span");

	private By creditAccount_viewCheque_TodaysTransactions_status=By.xpath("//td[@data-grid-column-key='Status']//span[contains(.,'Held')]");
	private By creditAccount_redeemCheque=By.cssSelector("a#Credit_RedeemCheque_Menu");
	private By creditAccount_redeemCheque_moveUpButton=By.cssSelector("button#buttonMoveUp");

	private By creditAccount_chequeClearance=By.cssSelector("a#Credit_ChequeClearance_Menu");
	private By creditAccount_chequeClearance_statusDropDown=By.cssSelector("select#dropDownClearanceStatus");
	private By creditAccount_chequeClearance_clearButton=By.cssSelector("button#buttonClear");
	private By creditAccount_chequeClearance_undoclearButton=By.cssSelector("button#buttonUndoClear");
	private By creditAccount_chequeClearance_TodaysTransactions=By.cssSelector("td[data-grid-column-key='CustomerNumber']");
	private By  PlayerTracking_hospitalityTransaction_successfullMsg = By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'This record has been saved successfully.')]");
	private By creditAccount_addDebitCard_chooseMatch=By.cssSelector("td[data-grid-column-key='BankAccountNumber']");
	private By visitMessage=By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'This person has no visit record for today. Generate a visit for this customer?')]");	
	private By processTransactionMsg=By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'Process Transaction:')]");
	private By transactionCompletedMsg=By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'Transaction completed')]");

	private By transactionCodeErrMsg = By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'This transaction code has already been used.')]");
	private By closeIconTab=By.xpath("//div[@class='buttonbar']//div//button[@accesskey='x']");
	private By findButton=By.xpath("//button[@id='buttonFind']");
	private By headingTxt=By.xpath("//h2[@id='layoutCaption']");
	private By customerfind_Deatils;
	private By table=By.xpath("//table[@class='grid datagrid']//tbody//tr");
	private By custStatus;	
	/*Cashier - 36

	Input#textBoxChequeNumber
	Select#dropDownRejectionReason
	Save
	Okyes*/

	private By creditAccount_returnedCheque=By.cssSelector("a#Credit_ReturningCheque_Menu");
	private By creditAccount_returnedCheque_CustNum=By.cssSelector("Input#textBoxAccountNumber");

	private By creditAccount_returnedCheque_ChequeNum=By.cssSelector("Input#textBoxChequeNumber");
	private By creditAccount_returnedCheque_SelectReason=By.cssSelector("Select#dropDownRejectionReason");

	private By PlayerTracking_hospitalityTransaction_selectDuration = By.cssSelector("select#ReportInterval_Id");	
	private By PlayerTracking_hospitalityTransaction_buttonFind = By.cssSelector("button#buttonFind");	
	private By PlayerTracking_hospitalityTransaction_buttonsDetails = By.cssSelector("td.text-center button.btn-primary.btn-secured");	

	public void returnedUnpaidChequeFromBank(){

		clicktopNavigationCredit();
		clickCheque();
		objUtilities.logReporter("Click on View Cheque ", objWrapperFunctions.click(creditAccount_viewCheque), false);

		objUtilities.logReporter("Select Authority", objWrapperFunctions.selectDropDownByIndex(PlayerTracking_hospitalityTransaction_selectDuration, 8), false);
		objUtilities.logReporter("Click on Find", objWrapperFunctions.clickByScript(PlayerTracking_hospitalityTransaction_buttonFind), false);


		String arrBankAcc[]=objWrapperFunctions.getElementTextArray(creditAccount_chequeClearance_TodaysTransactions);
		int index=0;
		String accNUM=String.valueOf(creditAccNum);

		for (String temp : arrBankAcc) {
			System.out.println(temp);
			if(temp.equalsIgnoreCase(accNUM)){

				reqIndex=index;
				System.out.println("Required  index"+reqIndex);
				break;
			}
			index++;
		}
		objUtilities.logReporter("Select Page", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(PlayerTracking_hospitalityTransaction_buttonsDetails, reqIndex)), false);
		System.out.println("Clicking on Details of Required");		
		String req_ChequeNum = objWrapperFunctions.getAttributeValue(creditAccount_debitCardMenu_AddCheque_chequeNum, "value");


		clicktopNavigationCredit();
		objUtilities.logReporter("Click on Returned Cheque", objWrapperFunctions.click(creditAccount_returnedCheque), false);
		objUtilities.logReporter("Enter Customer Number", objWrapperFunctions.setText(creditAccount_returnedCheque_CustNum,String.valueOf(creditAccNum)), false);
		objUtilities.logReporter("Enter Cheque Number", objWrapperFunctions.setText(creditAccount_returnedCheque_ChequeNum,req_ChequeNum), false);
		objUtilities.logReporter("Click on save ", objWrapperFunctions.click(thirdPartyAcc_SaveButton), false);
		//	clickOkOrYes();

		objUtilities.logReporter("Select clearance type", objWrapperFunctions.selectDropDownByIndex(creditAccount_returnedCheque_SelectReason, 1), false);

		objUtilities.logReporter("Click on save ", objWrapperFunctions.click(thirdPartyAcc_SaveButton), false);
		clickOkOrYes();
	}

	public void chequeClearance(){
		//	creditAccNum=1530236670;
		clicktopNavigationCredit();
		objUtilities.logReporter("Click on Cheque clearance ", objWrapperFunctions.click(creditAccount_chequeClearance), false);
		String arrBankAcc[]=objWrapperFunctions.getElementTextArray(creditAccount_chequeClearance_TodaysTransactions);
		int index=0;
		String accNUM=String.valueOf(creditAccNum);

		for (String temp : arrBankAcc) {
			System.out.println(temp);
			if(temp.equalsIgnoreCase(accNUM)){

				reqIndex=index;
				System.out.println("Required  index"+reqIndex);
				break;
			}
			index++;
		}
		objUtilities.logReporter("Select Page", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(creditAccount_chequeClearance_TodaysTransactions, reqIndex)), false);
		System.out.println("Clicking on Details of Required");
		objUtilities.logReporter("Click on Clear", objWrapperFunctions.click(creditAccount_chequeClearance_clearButton), false);
		if(this.getConfirmationMessage("Clear Cheque - Are you sure?"))
		{
			clickOnYes();
		}
		if(this.getConfirmationMessage("Cheque now cleared."))
		{
			clickOnOk();
		}
		
		
		objUtilities.logReporter("Select clearance type", objWrapperFunctions.selectDropDownByIndex(creditAccount_chequeClearance_statusDropDown, 1), false);
		//sobjUtilities.logReporter("Select Page", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(creditAccount_chequeClearance_TodaysTransactions, 0)), false);
		objUtilities.logReporter("Click on Undo Clear", objWrapperFunctions.click(creditAccount_chequeClearance_undoclearButton), false);

		if(this.getConfirmationMessage("Undo Cheque Clearance - Are you sure?"))
		{
			clickOnYes();
		}
		if(this.getConfirmationMessage("Cheque no longer cleared."))
		{
			clickOnOk();
		}
	}

	public void close()
	{
		objWrapperFunctions.waitForElementToBeClickable(closeIconTab);
		objUtilities.logReporter("Click on closeIconTab", objWrapperFunctions.clickByScript(closeIconTab), false);

	}

	public void clickOkOrYes(){
		//System.out.println("Closing Pop-up :"+count);
		//	objWrapperFunctions.waitForElementPresence(voidYesButton);
		if(objWrapperFunctions.checkElementDisplyed(voidYesButton)){
			objWrapperFunctions.pressEnterBtn(voidYesButton);
		}else if(objWrapperFunctions.checkElementDisplyed(okBtn)){
			objWrapperFunctions.pressEnterBtn(okBtn);
		}



	}

	public void redeemCheque(){

		//	creditAccNum= 1955147065;
		clicktopNavigationCredit();
		clickRedeemCheque();
		System.out.println(creditAccNum+" redeem");
		objUtilities.logReporter("Enter Customer Number", objWrapperFunctions.setText(creditAccount_addGlobalCash_customerNumber,String.valueOf(creditAccNum)), false);
		objWrapperFunctions.pressTabBtn(creditAccount_addGlobalCash_customerNumber);

//		if(objWrapperFunctions.verifyIsElementPresent(okButton))
//		{
//			objWrapperFunctions.waitForElementToBeClickable(okButton);
//			objUtilities.logReporter("Click on okButton ", objWrapperFunctions.clickByScript(okButton), false);
//		}	
		objWrapperFunctions.waitForElementToBeClickable(creditAccount_redeemCheque_moveUpButton);
		objUtilities.logReporter("Click on Move up ", objWrapperFunctions.click(creditAccount_redeemCheque_moveUpButton), false);
		//Thread.sleep(1000);
		objWrapperFunctions.waitForElementPresence(thirdPartyAcc_SaveButton);
		objWrapperFunctions.waitForElementToBeClickable(thirdPartyAcc_SaveButton);
		//objUtilities.logReporter("Click on Move up ", objWrapperFunctions.click(creditAccount_redeemCheque_moveUpButton), false);
		objWrapperFunctions.waitForElementToBeClickable(thirdPartyAcc_SaveButton);
		objUtilities.logReporter("Click on save ", objWrapperFunctions.click(thirdPartyAcc_SaveButton), false);
		
		if(this.getConfirmationMessage("Process Transaction: Redeem Cheque"))
		{
			clickOnYes();
		}
		if(this.getConfirmationMessage("Transaction completed"))
		{
			clickOnOk();
		}	
		close();
	}

	public void clickRedeemCheque(){
		objUtilities.logReporter("Click on Redeem Cheque ", objWrapperFunctions.click(creditAccount_redeemCheque), false);
	}

	public void selectStatus(String status)
	{
		By statusDropdown = By.xpath("//select[@id='Status']");
		
		objUtilities.logReporter("select status as ",status,objWrapperFunctions.selectDropDownByVisibleText(statusDropdown, status), false);
	}
	public void viewAndVoidCheque(){
		//	creditAccNum= 1955147067;
		clicktopNavigationCredit();
		//	clickCheque();
		objUtilities.logReporter("Click on View Cheque ", objWrapperFunctions.click(creditAccount_viewCheque), false);
		
		searchChequeByCustomerNumber(customerNum);
		selectStatus("Held");
		objUtilities.logReporter("Click on Find", objWrapperFunctions.click(thirdPartyAcc_FindButton), false);

		String arrBankAcc[]=objWrapperFunctions.getElementTextArray(creditAccount_viewCheque_TodaysTransactions);

		//		String arrStatus[]=objWrapperFunctions.getElementTextArray(creditAccount_viewCheque_TodaysTransactions_status);
		//	String str=objWrapperFunctions.getText(creditAccount_viewCheque_TodaysTransactions_status);
		int index=0;
		String accNUM=String.valueOf(creditAccNum);

		for (String temp : arrBankAcc) {
			System.out.println(temp);
			if(temp.equalsIgnoreCase(accNUM)){

				reqIndex=index;
				System.out.println("Required  index"+reqIndex);
				break;
			}
			index++;
		}

		objUtilities.logReporter("Select Page", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(thirdPartyAcc_FindAcc_clickDetails, reqIndex)), false);
		System.out.println("Clicking on Details of Required");
		System.out.println("Click on void Check");
		objUtilities.logReporter("Click on Void", objWrapperFunctions.click(creditAccount_GlobalCashMenu_ViewGlobalCash_voidButton), false);
		
		if(this.getConfirmationMessage("Void cheque - are you sure?"))
		{
			clickOnYes();
		}
		if(this.getConfirmationMessage("Cheque has been successfully voided."))
		{
			clickOnOk();
		}
		close();
	}

	public void clickCheque()
	{
		objUtilities.logReporter("Click on Cheque Menu", objWrapperFunctions.click(creditAccount_chequeMenu), false);

	}

	public void ClickOnAddCheque()
	{
		objUtilities.logReporter("Click on Add Cheque ", objWrapperFunctions.click(creditAccount_debitCardMenu_AddCheque), false);
	}
	
	public boolean getConfirmationMessage(String msg)
	{
		By confirmMessage = By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(text(),'"+ msg +"')]");
		/*objUtilities.logReporter("verify New Button ", 
				objWrapperFunctions.verifyIsElementPresent(confirmMessage),false);*/
		return objWrapperFunctions.verifyIsElementPresent(confirmMessage);
	}

	
	public void searchChequeByCustomerNumber(String custNum)
	{
		By customerNumberInput = By.xpath("//input[@id='CustomerNumber']");
		objUtilities.logReporter("Enter Bank Acc Number", objWrapperFunctions.setText(customerNumberInput,custNum), false);
	}
	public void addCheque(){
		//	creditAccNum= 1955147068;


		try {
			//clickCheque();
			//	objUtilities.logReporter("Click on Add Cheque ", objWrapperFunctions.click(creditAccount_debitCardMenu_AddCheque), false);
			objUtilities.logReporter("Enter Bank Acc Number", objWrapperFunctions.setText(creditAccount_debitCardMenu_AddCheque_bankAccNum,String.valueOf(creditAccNum)), false);
			objWrapperFunctions.pressTabBtn(creditAccount_debitCardMenu_AddCheque_bankAccNum);
			Thread.sleep(5000);
			
			//if(this.getConfirmationMessage("Warning - This is a debit card only account so only certain types of cheque will be allowed."))
			{
				clickOnOk();
				if(objWrapperFunctions.verifyIsElementPresent(okButton))
				{	
					//clickOnOk();
				}	
			}					
			Thread.sleep(5000);		
			//	objUtilities.logReporter("Click on OK", objWrapperFunctions.clickByScript(okButton), false);

			//	objUtilities.logReporter("Click on Cheque Menu", objWrapperFunctions.click(creditAccount_debitCardMenu_AddCheque_custNumber), false);
			objUtilities.logReporter("Select cheque type", objWrapperFunctions.selectDropDownByIndex(creditAccount_debitCardMenu_AddCheque_selectChequeType, 6), false);

			int t = objWrapperFunctions.getRandBet(99999, 11111);
			System.out.println("transaction code="+String.valueOf(t));
			Thread.sleep(500);
			//objUtilities.logReporter("Enter Transaction code", objWrapperFunctions.setText(creditAccount_debitCardMenu_AddCheque_chequeNum,String.valueOf(t)), false);
			String req_ChequeNum = objWrapperFunctions.getAttributeValue(creditAccount_debitCardMenu_AddCheque_chequeNum, "value");
			objUtilities.logReporter("Enter Cheque Number", objWrapperFunctions.setText(creditAccount_returnedCheque_ChequeNum,req_ChequeNum), false);
			objUtilities.logReporter("Enter Amount", objWrapperFunctions.setText(creditAccount_debitCardMenu_AddCheque_enterAmount,"10"), false);
			objWrapperFunctions.waitForElementToBeClickable(creditAccount_debitCardMenu_AddCheque_selectClearance);
			objUtilities.logReporter("Select clearance type", objWrapperFunctions.selectDropDownByIndex(creditAccount_debitCardMenu_AddCheque_selectClearance, 1), false);
			//objUtilities.logReporter("Enter Cheque date", objWrapperFunctions.setText(creditAccount_debitCardMenu_AddCheque_enterChequeDate,"30122016"), false);
			//objUtilities.logReporter("Enter bank date", objWrapperFunctions.setText(creditAccount_debitCardMenu_AddCheque_enterBankDate,"31122016"), false);
			objUtilities.logReporter("Click on Save", objWrapperFunctions.clickByScript(thirdPartyAcc_SaveButton), false);

			int t1 = objWrapperFunctions.randomNumberBetween(25,0);
			//	objUtilities.logReporter("Select Page", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(createnewCreditAcc_selectManager, t1)), false);

			//objUtilities.logReporter("Select Page", objWrapperFunctions.click(createnewCreditAcc_selectManager), false);
			//objWrapperFunctions.click(okButton);
			//objWrapperFunctions.acceptMultipleAlert(okBtn);
			
			if(this.getConfirmationMessage("Process Transaction: Cheque"))
			{clickOkOrYes();}
			if(this.getConfirmationMessage("Transaction completed"))
			{clickOnOk();}
			
		//	objWrapperFunctions.acceptMultipleAlert(okBtn);

			close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}




	public void findCustomer()
	{
		//objUtilities.logReporter("Enter Customer Number", objWrapperFunctions.setText(findInputBox,"Auto"), false);
		//objUtilities.logReporter("Click on Find button", objWrapperFunctions.click(findButton), false);
		int size1=objWrapperFunctions.getElementSize(table);			
		for(int i=1;i<=size1;i++)
		{
			custStatus=By.xpath("//table[@class='grid datagrid']//tbody//tr["+i+"]//td[7]");
			temp=objWrapperFunctions.getText(custStatus);
			//System.out.println(temp);
			if(temp.contains("Held")) 
				//if(temp.contains("Suspended"))
			{	
				customerfind_Deatils=By.xpath("//table[@class='grid datagrid']//tbody//tr["+i+"]//td[9]");
				objUtilities.logReporter("Click on Customer tab", objWrapperFunctions.click(customerfind_Deatils), false);
				break;
			}

		}
	}	








	public void addGlobalCash(){
		//	creditAccNum= 1955147090;
		clicktopNavigationCredit();
		objUtilities.logReporter("Click on Global Cash ", objWrapperFunctions.click(creditAccount_GlobalCashMenu), false);
		objUtilities.logReporter("Click on Add Global Cash ", objWrapperFunctions.click(creditAccount_GlobalCashMenu_AddGlobalCash), false);
		verifyCustomerNameLabelDisplyed();
		verifyDOBLabelDisplyed();
		verifyAccountNameLabelDisplyed();
		verifyAndGetAccountNameValue();
		verifyAccountNumberLabelDisplyed();
		verifyAndGetAccountNumbeValue();
		verifyBankLabelDisplyed();
		verifyAndGetBankValue();
		objUtilities.logReporter("Enter Customer Number", objWrapperFunctions.setText(creditAccount_addGlobalCash_customerNumber,String.valueOf(creditAccNum)), false);
		objWrapperFunctions.pressTabBtn(creditAccount_addGlobalCash_customerNumber);
		if (objWrapperFunctions.checkElementDisplyed(okButton))
		{
			objUtilities.logReporter("Click on ok ", objWrapperFunctions.click(okButton), false);
		}
		verifyCustomerNameLabelDisplyed();
		verifyAndGetCustomerNameValue();
		verifyDOBLabelDisplyed();
		verifyAndGetDOBValue();
		verifyAccountNameLabelDisplyed();
		verifyAndGetAccountNameValue();
		verifyAccountNumberLabelDisplyed();
		verifyAndGetAccountNumbeValue();
		verifyBankLabelDisplyed();
		verifyAndGetBankValue();
		if(customerDOB.contentEquals(custDOB))
		{
			System.out.println("customer details displayed correctly");
		}

		objUtilities.logReporter("Enter Amount", objWrapperFunctions.setText(creditAccount_addGlobalCash_enterAmount,"5"), false);
		transcationCode = objWrapperFunctions.getRandBet(9999, 1111);
		System.out.println("transcationCode" +transcationCode);
		objUtilities.logReporter("Enter Transaction code", objWrapperFunctions.setText(creditAccount_debitCardMenu_enterTransactionCode,String.valueOf(transcationCode)), false);

		objUtilities.logReporter("Click on Save ", objWrapperFunctions.click(thirdPartyAcc_SaveButton), false);
//		if(objWrapperFunctions.checkElementDisplyed(transactionCodeErrMsg))
//		{
//			transcationCode = objWrapperFunctions.getRandBet(9999, 1111);
//			objUtilities.logReporter("Enter Transaction code", objWrapperFunctions.setText(creditAccount_debitCardMenu_enterTransactionCode,String.valueOf(transcationCode)), false);
//			objUtilities.logReporter("Click on Save ", objWrapperFunctions.click(thirdPartyAcc_SaveButton), false);
//		}

		verifyProcessTransactionMsgDisplyed();		
		objUtilities.logReporter("Click on Yes button", objWrapperFunctions.clickByScript(voidYesButton), false);
		verifyTransactionCompletedMsgDisplyed();
		objUtilities.logReporter("Click on ok  button", objWrapperFunctions.clickByScript(okBtn), false);
		close();
	}

	public void navigateToViewGlobalCash()
	{
		objUtilities.logReporter("Click on view Global Cash ", objWrapperFunctions.click(creditAccount_GlobalCashMenu_ViewGlobalCash), false);
	}
	public void viewAndVoidGlobalCash()
	{
		clicktopNavigationCredit();
		//objUtilities.logReporter("Click on Global Cash ", objWrapperFunctions.click(creditAccount_GlobalCashMenu), false);
		navigateToViewGlobalCash();
		objUtilities.logReporter("Enter Customer Number", objWrapperFunctions.setText(creditAccount_GlobalCashMenu_ViewGlobalCash_accNum,String.valueOf(creditAccNum)), false);
		objUtilities.logReporter("Click on Find ", objWrapperFunctions.click(creditAccount_findButton), false);
		selectProfile(creditAccount_debitCardMenu_viewDebitCradTransactions,thirdPartyAcc_FindAcc_clickDetails,transcationCode);

		//	objUtilities.logReporter("Select Page", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(thirdPartyAcc_FindAcc_clickDetails, 0)), false);
		System.out.println("Viewing Global Cash details for :"+objWrapperFunctions.getAttributeValue(creditAccount_GlobalCashMenu_ViewGlobalCash_accNumber, "value"));





		objWrapperFunctions.waitForElementPresence(creditAccount_GlobalCashMenu_ViewGlobalCash_voidButton);
		objWrapperFunctions.waitForElementToBeClickable(creditAccount_GlobalCashMenu_ViewGlobalCash_voidButton);
		objUtilities.logReporter("Click on Void ", objWrapperFunctions.click(creditAccount_GlobalCashMenu_ViewGlobalCash_voidButton), false);
		verifyvoidConfirmationMsgDisplyed();
		objUtilities.logReporter("Click on yes ", objWrapperFunctions.click(voidYesButton), false);
		verifyvoidSuccessMsgDisplyed();
		//String message=objWrapperFunctions.getText(creditAccount_debitCardMenu_voidDebitCard_succesMessage);
		objUtilities.logReporter("Click on ok ", objWrapperFunctions.click(okBtn), false);
		close();
		close();
		clicktopNavigationCredit();
		navigateToViewGlobalCash();
		verifyDebitCardIsVoid();


		/*


		objUtilities.logReporter("Click on yes ", objWrapperFunctions.click(voidYesButton), false);

		objWrapperFunctions.acceptMultipleAlert(okBtn);
		close();*/
	}

	public void ClickOnDebitCardMenu()
	{
		objWrapperFunctions.waitForElementToBeClickable(creditAccount_debitCardMenu);
		objUtilities.logReporter("Click on Debit Card Menu ", objWrapperFunctions.click(creditAccount_debitCardMenu), false);
	}

	public void clickOnAddDebitCard()
	{
		objWrapperFunctions.waitForElementToBeClickable(creditAccount_debitCardMenu_AddDebitCard);
		objUtilities.logReporter("Click on Add Debit Card ", objWrapperFunctions.click(creditAccount_debitCardMenu_AddDebitCard), false);
	}
	public void addDebitCard(String type)
	{
		//	String temp = String.valueOf(firstChar)+String.valueOf(secondChar)+String.valueOf(cardLastFourDigits);
		objUtilities.logReporter("Enter First two letters of Surname and Last 4 digit of Debit card", objWrapperFunctions.setText(creditAccount_debitCardMenu_inputSurnameAndCard,custDebitNum), false);
		//System.out.println("Entered Surname and Debit Number :"+temp);
		objWrapperFunctions.pressTabBtn(creditAccount_debitCardMenu_inputSurnameAndCard);
//		if(objWrapperFunctions.checkElementDisplyed(okButton))
//		{
//			objWrapperFunctions.waitForElementToBeClickable(okButton);
//			objUtilities.logReporter("Click on okButton", objWrapperFunctions.click(okButton), false);
//			if(objWrapperFunctions.checkElementDisplyed(okButton))
//			{
//				objWrapperFunctions.waitForElementToBeClickable(okButton);
//				objUtilities.logReporter("Click on okButton", objWrapperFunctions.click(okButton), false);
//
//			}
//		}
		try {
			Thread.sleep(10000);
			verifyAccountNameLabelDisplyed();
			verifyAndGetAccountNameValue();

			verifyAccountNumberLabelDisplyed();
			verifyAndGetAccountNumbeValue();

			verifyBankLabelDisplyed();
			verifyAndGetBankValue();

			verifyCustomerNameLabelDisplyed();
			verifyAndGetCustomerNameValue();

			verifyCustomerNumberLabelDisplyed();
			verifyAndGetCustomerNumberValue();
			verifyDOBLabelDisplyed();
			verifyAndGetDOBValue();
//			if(custNum.contentEquals(customerNum) && customerDOB.contentEquals(custDOB))
//			{
//				System.out.println("customer details displayed correctly");
//			}
			int transcation = objWrapperFunctions.getRandBet(9999, 1111);
			System.out.println("Transaction code ="+String.valueOf(transcation));
			
			objUtilities.logReporter("Enter Transaction code", objWrapperFunctions.setText(creditAccount_debitCardMenu_enterTransactionCode,String.valueOf(transcation)), false);	
			//objWrapperFunctions.pressTabBtn();
			int s = objWrapperFunctions.getRandBet(5,1);
			objUtilities.logReporter("Enter Amount", objWrapperFunctions.setText(creditAccount_debitCardMenu_inputAmount,String.valueOf(s)), false);		
			
			//	objWrapperFunctions.verifyIsElementPresent(createnewCreditAcc_selectManager);
//			if(objWrapperFunctions.checkElementDisplyed(createnewCreditAcc_selectManager))
//			{
//				objWrapperFunctions.waitForElementToBeClickable(createnewCreditAcc_selectManager);
//				objUtilities.logReporter("selemanager ", objWrapperFunctions.click(createnewCreditAcc_selectManager), false);	
				
//			}
			
			//objWrapperFunctions.waitForElementPresence(creditAccount_debitCardMenu_enterTransactionCode);
			
			if(type.contains("Manual"))
			{
				objUtilities.logReporter("Click on Manual radioButton", objWrapperFunctions.click(creditAccount_debitCardMenu_transactionType_Manual), false);
			}
			//objWrapperFunctions.click(okButton);
			objUtilities.logReporter("Click on OK", objWrapperFunctions.click(voidOKButton), false);
			objUtilities.logReporter("Click on Save ", objWrapperFunctions.click(creditAccount_debitCardMenu_saveButton), false);		
			//objWrapperFunctions.pressTabBtn(creditAccount_debitCardMenu_inputAmount);
			Thread.sleep(500);
			//clickOnOk();
			clickOnYes();
			Thread.sleep(300);
			clickOnYes();
//			objUtilities.logReporter("Click on OK", objWrapperFunctions.click(voidOKButton), false);
//			
//			objUtilities.logReporter("Click on Save ", objWrapperFunctions.click(creditAccount_debitCardMenu_saveButton), false);		
//			clickOnYes();
			
//			clickOnYes();
//			Thread.sleep(100);
//			if(objWrapperFunctions.checkElementDisplyed(visitMessage))
//			{
//				clickOkOrYes();
//			}
	//		verifyProcessTransactionMsgDisplyed();		
		//	objUtilities.logReporter("Click on Yes button", objWrapperFunctions.clickByScript(voidYesButton), false);
		//	clickOnYes();
			//verifyTransactionCompletedMsgDisplyed();
			clickOnOk();
			System.out.println("Debit Card added successfully using " +type+ " Transcation Type");
			//close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addDebitCardForSameCard()
	{
		objUtilities.logReporter("verify same card button ", objWrapperFunctions.verifyIsElementPresent(creditAccount_debitCardMenu_sameCard), false);
		objWrapperFunctions.waitForElementToBeClickable(creditAccount_debitCardMenu_sameCard);
		objUtilities.logReporter("click on same card button ", objWrapperFunctions.click(creditAccount_debitCardMenu_sameCard), false);
		
		String custNumber=objWrapperFunctions.getText(creditAccount_debitCardMenu_customerNumber);
		System.out.println("cust : " +custNumber);
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(customerNum.contentEquals(custNumber))
		{
			int s = objWrapperFunctions.getRandBet(5,1);
			objUtilities.logReporter("Enter Amount", objWrapperFunctions.setText(creditAccount_debitCardMenu_inputAmount,String.valueOf(s)), false);		

			objWrapperFunctions.pressTabBtn(creditAccount_debitCardMenu_inputAmount);
			//	objWrapperFunctions.verifyIsElementPresent(createnewCreditAcc_selectManager);
			if(objWrapperFunctions.checkElementDisplyed(createnewCreditAcc_selectManager))
			{
				objWrapperFunctions.waitForElementToBeClickable(createnewCreditAcc_selectManager);
				objUtilities.logReporter("selemanager ", objWrapperFunctions.click(createnewCreditAcc_selectManager), false);	
				objWrapperFunctions.click(okButton);
			}

			transcationCode = objWrapperFunctions.getRandBet(9999, 1111);
			objUtilities.logReporter("Enter Transaction code", objWrapperFunctions.setText(creditAccount_debitCardMenu_enterTransactionCode,String.valueOf(transcationCode)), false);	
			objUtilities.logReporter("Click on Save ", objWrapperFunctions.click(creditAccount_debitCardMenu_saveButton), false);		
			verifyProcessTransactionMsgDisplyed();		
			clickOnYes();
			verifyTransactionCompletedMsgDisplyed();
			clickOnOk();
			//objUtilities.logReporter("Click on OK", objWrapperFunctions.click(voidOKButton), false);
		}

		System.out.println("Debit Card added successfully using Same Card");
		close();
	}


	public void clickOnOk()
	{
		//objUtilities.logReporter("Click on ok  button", objWrapperFunctions.clickByScript(okBtn), false);
		objUtilities.logReporter("Click on ok  button", objWrapperFunctions.click(okBtn), false);
	}

	public void clickOnYes()
	{
		//objUtilities.logReporter("Click on Yes button", objWrapperFunctions.clickByScript(voidYesButton), false);
		objUtilities.logReporter("Click on Yes button", objWrapperFunctions.click(voidYesButton), false);
	}

	
	public void NavigteToViewDebitCards()
	{
		//objUtilities.logReporter("Click on Debit Card Menu ", objWrapperFunctions.click(creditAccount_debitCardMenu), false);
		objUtilities.logReporter("Click on view Debit card menu ", objWrapperFunctions.click(creditAccount_debitCardMenu_viewDebitCard), false);
	}

	public void viewAndVoidDebitCard()
	{
		objUtilities.logReporter("Enter Customer Number", objWrapperFunctions.setText(creditAccount_GlobalCashMenu_ViewGlobalCash_accNum,String.valueOf(creditAccNum)), false);
		objUtilities.logReporter("Click on Find ", objWrapperFunctions.click(creditAccount_findButton), false);			
		selectProfile(creditAccount_debitCardMenu_viewDebitCradTransactions,thirdPartyAcc_FindAcc_clickDetails,transcationCode);	
		//objUtilities.logReporter("Select Page", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(thirdPartyAcc_FindAcc_clickDetails,2)), false);
		objUtilities.logReporter("verify view debit card screen displayed ", objWrapperFunctions.checkElementDisplyed(creditAccount_debitCardMenu_viewDebitCard_header), false);
		objWrapperFunctions.waitForElementPresence(creditAccount_addGlobalCash_customerNumber);
		System.out.println("Viewing Debit Cash details for :"+objWrapperFunctions.getAttributeValue(creditAccount_addGlobalCash_customerNumber, "value"));
		ref=objWrapperFunctions.getAttributeValue(creditAccount_debitCardMenu_viewDebitCard_transcationCode,"value");
		verifyCardTypeLabelDisplyed();
		verifyExpiryDateLabelDisplyed();
		verifyAccountNameLabelDisplyed();
		verifyAccountNumberLabelDisplyed();
		verifyBankLabelDisplyed();
		verifyDOBLabelDisplyed();
		if(ref.contentEquals(String.valueOf(transcationCode)))
		{
			System.out.println("transcationCode display correctly");
		}
		objWrapperFunctions.waitForElementPresence(creditAccount_GlobalCashMenu_ViewGlobalCash_voidButton);
		objWrapperFunctions.waitForElementToBeClickable(creditAccount_GlobalCashMenu_ViewGlobalCash_voidButton);
		objUtilities.logReporter("Click on Void ", objWrapperFunctions.click(creditAccount_GlobalCashMenu_ViewGlobalCash_voidButton), false);
		verifyvoidConfirmationMsgDisplyed();
		objUtilities.logReporter("Click on yes ", objWrapperFunctions.click(voidYesButton), false);
		verifyvoidSuccessMsgDisplyed();
		//String message=objWrapperFunctions.getText(creditAccount_debitCardMenu_voidDebitCard_succesMessage);
		objUtilities.logReporter("Click on ok ", objWrapperFunctions.click(okBtn), false);
		close();
		close();
		clicktopNavigationCredit();
		NavigteToViewDebitCards();
		verifyDebitCardIsVoid();

	}


	public void verifyDebitCardIsVoid( )
	{

		objUtilities.logReporter("Enter Customer Number", objWrapperFunctions.setText(creditAccount_GlobalCashMenu_ViewGlobalCash_accNum,String.valueOf(creditAccNum)), false);
		//objWrapperFunctions.click(global_StatusDropDown);
		objWrapperFunctions.selectDropDownByIndex(global_StatusDropDown, 0);
		objUtilities.logReporter("Click on Find ", objWrapperFunctions.click(creditAccount_findButton), false);	
		selectProfile(creditAccount_debitCardMenu_viewDebitCradTransactions,thirdPartyAcc_FindAcc_clickDetails,transcationCode);	
		String statusText =objWrapperFunctions.getAttributeValue(creditAccount_debitCardMenu_viewDebitCradTransactions_status,"value");
		if(statusText.contains("void"))
		{
			System.out.println("Status displayed as void");
		}
	}


	public void selectProfile(By locator,By locator1,int tcode)
	{

		String arrBankAcc[]=objWrapperFunctions.getElementTextArray(locator);
		int index=0;
		String accNUM=String.valueOf(tcode);
		//String statusHeld = objWrapperFunctions.getText(locator1);
		System.out.println(" test = " +accNUM);
		for (String temp : arrBankAcc) 
		{
			System.out.println("temp gg=" +temp);

			if(temp.equalsIgnoreCase(accNUM))
			{
				reqIndex=index;
				objUtilities.logReporter("verify details ",objWrapperFunctions.checkElementDisplyed(locator1), false);		
				objUtilities.logReporter("Select Page", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(locator1,reqIndex)), false);
				break;
			}
			index++;
		}
	}



	public void creditAccounts_AddBankAccount(){
		try {
			//creditAccNum= 1955147068;
			objUtilities.logReporter("Enter Acc Number", objWrapperFunctions.setText(creditAccount_findByAccNumber,String.valueOf(creditAccNum)), false);
			objUtilities.logReporter("Click on Find", objWrapperFunctions.click(creditAccount_findButton), false);
			name=objWrapperFunctions.getText(objWrapperFunctions.getElementOfIndex(creditAccount_findAcc_getName, 0));
			System.out.println("Account details Viewing for :"+name);
			nameArray=name.split(" ");

			System.out.println("Last Name :"+nameArray[1]);
			lastname = nameArray[nameArray.length-1];
			firstChar=lastname.charAt(0);
			secondChar=lastname.charAt(1);

			System.out.println("firstChar :"+firstChar);
			System.out.println("firstChar :"+secondChar);

			objUtilities.logReporter("Select Page", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(creditAccount_findAcc_Deatils, 0)), false);
			Thread.sleep(2000);
			creditAccounts_ViewCreatedAccount();
			objUtilities.logReporter("Click on Bank Account", objWrapperFunctions.clickByScript(creditAccount_findAcc_Deatils_BankAccounts), false);
			System.out.println("Clicked ON Bank Account");
			objUtilities.logReporter("Click on Add Bank Account", objWrapperFunctions.click(creditAccount_findAcc_addBankAcc_AddButton), false);
			System.out.println("Clicked ON Add Bank Account");

			objUtilities.logReporter("Enter Acc Number", objWrapperFunctions.setText(inputBankAccNum, String.valueOf(creditAccNum)), false);
			objUtilities.logReporter("Enter Bank Number", objWrapperFunctions.setText(inputBankCode,"251667"), false);
			objWrapperFunctions.pressTabBtn(inputBankCode);
			Thread.sleep(10000);
			objUtilities.logReporter("CheckBOX check For Debit card", objWrapperFunctions.clickElement(creditAccount_findAcc_addBankAcc_CheckBoxDebitCard), false);

			cardLastFourDigits = objWrapperFunctions.randomNumberBetween(9999,1111);

			customerNumer = String.valueOf(firstChar)+String.valueOf(secondChar)+String.valueOf(cardLastFourDigits);
			objWrapperFunctions.updateDebitNum(customerNumer);
			System.out.println("dFGDfg dg= "+customerNumer);
			System.out.println("Debit card number last 4 digit :"+cardLastFourDigits);
			objUtilities.logReporter("click on Last 4 digit textbox", objWrapperFunctions.click(creditAccount_findAcc_addBankAcc_debitCardDigits), false);
			objUtilities.logReporter("Enter cardLastFourDigits", objWrapperFunctions.setText(creditAccount_findAcc_addBankAcc_debitCardDigits, String.valueOf(cardLastFourDigits)), false);

			expiry_month=objWrapperFunctions.randomNumberBetween(12,1);
			objUtilities.logReporter("Enter expiry month", objWrapperFunctions.setText(creditAccount_findAcc_addBankAcc_debitCardtextBoxExpiryMonth, String.valueOf(expiry_month)), false);

			expiry_year=objWrapperFunctions.randomNumberBetween(2030,2018);
			objUtilities.logReporter("Enter expiry year", objWrapperFunctions.setText(creditAccount_findAcc_addBankAcc_debitCardtextBoxExpiryYear, String.valueOf(expiry_year)), false);
			objUtilities.logReporter("Click on Commit", objWrapperFunctions.click(creditAccount_findAcc_addBankAcc_CommitButton), false);
			close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void creditAccounts_ViewCreatedAccount(){

		try {
			//	creditAccNum= "1955147066";
			/*objUtilities.logReporter("Enter Acc Number", objWrapperFunctions.setText(creditAccount_findByAccNumber,String.valueOf(creditAccNum)), false);
			objUtilities.logReporter("Click on Find", objWrapperFunctions.click(creditAccount_findButton), false);


			objUtilities.logReporter("Select Page", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(creditAccount_findAcc_Deatils, 0)), false);
			Thread.sleep(2000);*/
			Thread.sleep(5000);
			objUtilities.logReporter("Check Presence :creditAccount_findAcc_Deatils_Details", objWrapperFunctions.checkElementDisplyed(creditAccount_findAcc_Deatils_Details), false);
			System.out.println("Element Present : "+objWrapperFunctions.getText(creditAccount_findAcc_Deatils_Details));

			objUtilities.logReporter("Check Presence :creditAccount_findAcc_Deatils_Audit", objWrapperFunctions.checkElementDisplyed(creditAccount_findAcc_Deatils_Audit), false);
			System.out.println("Element Present : "+objWrapperFunctions.getText(creditAccount_findAcc_Deatils_Audit));

			objUtilities.logReporter("Check Presence :creditAccount_findAcc_Deatils_Authorisations", objWrapperFunctions.checkElementDisplyed(creditAccount_findAcc_Deatils_Authorisations), false);
			System.out.println("Element Present : "+objWrapperFunctions.getText(creditAccount_findAcc_Deatils_Authorisations));

			objUtilities.logReporter("Check Presence :creditAccount_findAcc_Deatils_BankAccounts", objWrapperFunctions.checkElementDisplyed(creditAccount_findAcc_Deatils_BankAccounts), false);
			System.out.println("Element Present : "+objWrapperFunctions.getText(creditAccount_findAcc_Deatils_BankAccounts));

			objUtilities.logReporter("Check Presence :creditAccount_findAcc_Deatils_BankReferences", objWrapperFunctions.checkElementDisplyed(creditAccount_findAcc_Deatils_BankReferences), false);
			System.out.println("Element Present : "+objWrapperFunctions.getText(creditAccount_findAcc_Deatils_BankReferences));

			objUtilities.logReporter("Check Presence :creditAccount_findAcc_Deatils_CasinoReferences", objWrapperFunctions.checkElementDisplyed(creditAccount_findAcc_Deatils_CasinoReferences), false);
			System.out.println("Element Present : "+objWrapperFunctions.getText(creditAccount_findAcc_Deatils_CasinoReferences));

			objUtilities.logReporter("Check Presence :creditAccount_findAcc_Deatils_Identification", objWrapperFunctions.checkElementDisplyed(creditAccount_findAcc_Deatils_Identification), false);
			System.out.println("Element Present : "+objWrapperFunctions.getText(creditAccount_findAcc_Deatils_Identification));

			objUtilities.logReporter("Check Presence :creditAccount_findAcc_Deatils_Messages", objWrapperFunctions.checkElementDisplyed(creditAccount_findAcc_Deatils_Messages), false);
			System.out.println("Element Present : "+objWrapperFunctions.getText(creditAccount_findAcc_Deatils_Messages));

			objUtilities.logReporter("Check Presence :creditAccount_findAcc_Deatils_Notes", objWrapperFunctions.checkElementDisplyed(creditAccount_findAcc_Deatils_Notes), false);
			System.out.println("Element Present : "+objWrapperFunctions.getText(creditAccount_findAcc_Deatils_Notes));

			objUtilities.logReporter("Check Presence :creditAccount_findAcc_Deatils_Transactions", objWrapperFunctions.checkElementDisplyed(creditAccount_findAcc_Deatils_Transactions), false);
			System.out.println("Element Present : "+objWrapperFunctions.getText(creditAccount_findAcc_Deatils_Transactions));

			objUtilities.logReporter("Check Presence :creditAccount_findAcc_Deatils_Deposits", objWrapperFunctions.checkElementDisplyed(creditAccount_findAcc_Deatils_Deposits), false);
			System.out.println("Element Present : "+objWrapperFunctions.getText(creditAccount_findAcc_Deatils_Deposits));

			objUtilities.logReporter("Check Presence :creditAccount_findAcc_Deatils_Summary", objWrapperFunctions.checkElementDisplyed(creditAccount_findAcc_Deatils_Summary), false);
			System.out.println("Element Present : "+objWrapperFunctions.getText(creditAccount_findAcc_Deatils_Summary));
			//close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickcredit_CreditAccounts(){
		objUtilities.logReporter("Click on Credit Accounts form Credit", objWrapperFunctions.click(credit_CreditAccounts), false);
		System.out.println("Credit Accounts clicked");
	}

	public void clickCreditAccounts_CreateNewButton(){

		objUtilities.logReporter("Click on Create New", objWrapperFunctions.click(thirdPartyAcc_CreateNewButton), false);
		System.out.println("Create New Button Clicked");
	}


	public void creditAccounts_CreateNewAccount(){
		try {


			//creditAccNum= 1955147090;
			objUtilities.logReporter("Enter Acc Number", objWrapperFunctions.setText(createNeCreditAcc_EnterAccNum,String.valueOf(creditAccNum)), false);
			System.out.println("Entered Acc num");
			objWrapperFunctions.pressTabBtn(createNeCreditAcc_EnterAccNum);
			Thread.sleep(7000);
			objWrapperFunctions.waitForElementPresence(credit_CreditAccounts_CustName);
			objWrapperFunctions.waitForElementPresence(credit_CreditAccounts_CustDOB);
			String custNm = objWrapperFunctions.getText(credit_CreditAccounts_CustName);
			String custbirthdate = objWrapperFunctions.getText(credit_CreditAccounts_CustDOB);
			System.out.println("custname = " +custNm+ "" +custbirthdate);
			if(custNm.contains(custName) && custbirthdate.equalsIgnoreCase(custDOB))
			{
				System.out.println("Customer name and date of birth display correctly");
			}
			objUtilities.logReporter("Click on LowerLimit ", objWrapperFunctions.click(createnewCreditAcc_LowerLimit), false);
			objUtilities.logReporter("Verify Date of birth display", objWrapperFunctions.click(createnewCreditAcc_LowerLimit), false);

			objUtilities.logReporter("Click on LowerLimit", objWrapperFunctions.click(createnewCreditAcc_LowerLimit), false);
			Thread.sleep(10000);
			//objUtilities.logReporter("Enter Lower Limit", objWrapperFunctions.setText(createnewCreditAcc_LowerLimit,"20"), false);
			//System.out.println("Lower Limit set");


			objUtilities.logReporter("Enter Lower Limit", objWrapperFunctions.setText(createnewCreditAcc_LowerLimit,"10"), false);
			System.out.println("Lower Limit set");

			objUtilities.logReporter("Enter Upper Limit", objWrapperFunctions.setText(createnewCreditAcc_UpperLimit,"100"), false);
			System.out.println("upper Limit set");

			objUtilities.logReporter("Click on  save", objWrapperFunctions.click(thirdPartyAcc_SaveButton), false);
			//	
			//int t = objWrapperFunctions.randomNumberBetween(25,0);
			//objUtilities.logReporter("Select Page", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(createnewCreditAcc_selectManager, t)), false);
			objUtilities.logReporter("Select manager from the list ", objWrapperFunctions.click(createnewCreditAcc_selectManager), false);//
			objUtilities.logReporter("Enter Comment", objWrapperFunctions.setText(inputComment,"Account Sample"), false);
			objUtilities.logReporter("Click on OK", objWrapperFunctions.click(voidOKButton), false);
			Thread.sleep(2000);
			//objUtilities.logReporter("Verify successfull message display", objWrapperFunctions.verifyIsElementPresent(PlayerTracking_hospitalityTransaction_successfullMsg), false);
			//objWrapperFunctions.acceptMultipleAlert(okBtn);
			objWrapperFunctions.acceptMultipleAlert(okButton);
			System.out.println("Credit Account Created Successfully..");			
			close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	public void createthirdPartyAcc() throws InterruptedException 
	{
		System.out.println("Creating Third Party Account");
		tempRandom = objWrapperFunctions.randomNumberBetween(999999999, 111111111);
		String acc_num= String.valueOf(tempRandom);
		System.out.println("Account Number:"+tempRandom);
		String acc_name= "Account"+String.valueOf(tempRandom);
		objUtilities.logReporter("Enter Acc Number", objWrapperFunctions.setText(inputBankAccNum,acc_num), false);
		objUtilities.logReporter("Enter Acc Name", objWrapperFunctions.setText(inputBankAccName,acc_name), false);
		//int tempBankCode = objWrapperFunctions.randomNumberBetween(999999, 111111);
		//	String bankcode= String.valueOf(tempBankCode);
		objUtilities.logReporter("Enter Comment", objWrapperFunctions.setText(inputComment,"Account Sample"), false);
		objUtilities.logReporter("Enter Bank Number", objWrapperFunctions.setText(inputBankCode,"251667"), false);
		//objUtilities.logReporter("Enter Bank Name", objWrapperFunctions.setText(inputBankName,"Barclays"), false);
		//String address = "GRACECHURCH STREET, EC3: 37 Gracechurch St,London,EC3V 0BX";
		//objUtilities.logReporter("Enter Bank Branch Address", objWrapperFunctions.setText(inputBankBranchAddress,address), false);
	  
		
		objUtilities.logReporter("Click on save", objWrapperFunctions.click(thirdPartyAcc_SaveButton), false);
		objWrapperFunctions.acceptMultipleAlert(okBtn);
		System.out.println(" Third Party Account Created Successfully..");
		close();
		close();
	}


	public void clickthirdPartyAcc_CreateNewButton(){

		objUtilities.logReporter("Click on Create New", objWrapperFunctions.click(thirdPartyAcc_CreateNewButton), false);
	}

	public void viewThirdPartyAccountDetails(){

		//need to add steps
		findThirdPartyCustomer();
		verifyAccountDetails();

	}

	public void findThirdPartyCustomer()
	{
		System.out.println("Viewing Created Third Party Account with Acc NUmber: "+tempRandom);
		objUtilities.logReporter("Enter Acc number to find", objWrapperFunctions.setText(thirdPartyAcc_FindAcc_EnterAccNum, String.valueOf(tempRandom)), false);
		objUtilities.logReporter("Click on Find Details", objWrapperFunctions.click(thirdPartyAcc_FindButton), false);
		objUtilities.logReporter("Click on Details button", objWrapperFunctions.click(thirdPartyAcc_FindAcc_clickDetails), false);
	}

	public void verifyAccountDetails()
	{
		String tempAcc=objWrapperFunctions.getAttributeValue(inputBankAccNum, "value");
		if(tempAcc.equalsIgnoreCase(String.valueOf(tempRandom))){
			System.out.println("Viewd Details Are correct");
			System.out.println("Displayed Account Number:"+tempAcc);
			System.out.println("Entered Account Number:"+tempRandom);
		}
	}
	public void deleteCreatedThirdPartyAccount(){
		//defect raised for this functionality
		verifyDeleteButtonDisplayed();
		clickOnDeleteButton();
		verifyMessage("Access Denied.");
		objWrapperFunctions.verifyIsElementPresent(okButton);
		objUtilities.logReporter("Click on okButton ", objWrapperFunctions.clickByScript(okButton), false);
		close();
		close();
	}

	public void verifyDeleteButtonDisplayed()
	{
		objWrapperFunctions.waitForElementPresence(thirdPartyAcc_FindAcc_ButtonDeleteAcc);
		objUtilities.logReporter("Verify Delete Button", objWrapperFunctions.verifyIsElementPresent(thirdPartyAcc_FindAcc_ButtonDeleteAcc), false);
	}
	public void clickOnDeleteButton()
	{
		objWrapperFunctions.waitForElementPresence(thirdPartyAcc_FindAcc_ButtonDeleteAcc);
		objWrapperFunctions.waitForElementToBeClickable(thirdPartyAcc_FindAcc_ButtonDeleteAcc);
		objUtilities.logReporter(" Click on Delete Button", objWrapperFunctions.click(thirdPartyAcc_FindAcc_ButtonDeleteAcc), false);
	}
	public void verifyMessage(String msg)
	{
		By thirdPartyAcc_FindAcc_Delete_Message = By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'"+msg+"')]");
		objWrapperFunctions.waitForElementPresence(thirdPartyAcc_FindAcc_Delete_Message);
		objUtilities.logReporter("Verify "+msg+"  display", objWrapperFunctions.verifyIsElementPresent(thirdPartyAcc_FindAcc_Delete_Message), false);
		System.out.println(objWrapperFunctions.getText(thirdPartyAcc_FindAcc_Delete_Message)+ "Message displayed" );
	}

	public void clickcredit_thirdPartyAccount(){
		objUtilities.logReporter("Click on top Third Party Account form Credit", objWrapperFunctions.click(credit_thirdPartyAccount), false);
		System.out.println("Third Party Acc clicked");
	}


	public void clicktopNavigationCredit(){
		objWrapperFunctions.waitForElementToBeClickable(topNavigationCredit);
		objUtilities.logReporter("Click on top Navigation Credit", objWrapperFunctions.click(topNavigationCredit), false);		
		System.out.println("Top Navigation Credit clicked");
	}

	public void verifyAccountNumberLabelDisplyed()
	{
		objUtilities.logReporter("Verify Account Number Label displayed", 
				objWrapperFunctions.verifyIsElementPresent(creditAccount_debitCardMenu_AccountNumberLabel), false);
	}
	public void verifyAndGetAccountNumbeValue()
	{
		objUtilities.logReporter("Verify AccountNumber Value displayed", 
				objWrapperFunctions.verifyIsElementPresent(creditAccount_debitCardMenu_AccountNumberValue), false);	
		accNumber = objWrapperFunctions.getText(creditAccount_debitCardMenu_AccountNumberValue);
		System.out.println("AccountNumber :" +accNumber);
	}

	public void verifyAccountNameLabelDisplyed()
	{
		objWrapperFunctions.waitForElementPresence(creditAccount_debitCardMenu_AccountNameLabel);
		objUtilities.logReporter("Verify Account NameLabel displayed", 
				objWrapperFunctions.verifyIsElementPresent(creditAccount_debitCardMenu_AccountNameLabel), false);
	}
	public void verifyAndGetAccountNameValue()
	{
		objWrapperFunctions.waitForElementPresence(creditAccount_debitCardMenu_AccountNameValue);
		//objUtilities.logReporter("Verify Account Name Value displayed", 
		//		objWrapperFunctions.verifyIsElementPresent(creditAccount_debitCardMenu_AccountNameValue), false);	
		System.out.println("AccountName :" +objWrapperFunctions.getText(creditAccount_debitCardMenu_AccountNameValue));
	}


	public void verifyBankLabelDisplyed()
	{
		objUtilities.logReporter("Verify Bank Label displayed", 
				objWrapperFunctions.verifyIsElementPresent(creditAccount_debitCardMenu_BankLabel), false);
	}
	public void verifyAndGetBankValue()
	{
		objUtilities.logReporter("Verify Bank Value displayed", 
				objWrapperFunctions.verifyIsElementPresent(creditAccount_debitCardMenu_BankValue), false);	
		System.out.println("Bank :" +objWrapperFunctions.getText(creditAccount_debitCardMenu_BankValue));
	}

	public void verifyCustomerNumberLabelDisplyed()
	{
		objUtilities.logReporter("Verify Customer Number Label displayed", 
				objWrapperFunctions.verifyIsElementPresent(creditAccount_debitCardMenu_CustomerNumberLabel), false);
	}
	public void verifyAndGetCustomerNumberValue()
	{
		objUtilities.logReporter("Verify Customer Number Value displayed", 
				objWrapperFunctions.verifyIsElementPresent(creditAccount_debitCardMenu_CustomerNumberValue), false);
		custNum = objWrapperFunctions.getText(creditAccount_debitCardMenu_CustomerNumberValue);
		System.out.println("CustomerNumber :" +custNum);
	}

	public void verifyCardTypeLabelDisplyed()
	{
		objUtilities.logReporter("Verify CardType Label displayed", 
				objWrapperFunctions.verifyIsElementPresent(creditAccount_debitCardMenu_CardTypeLabel), false);
	}
	public void verifyAndGetCardTypeValue()
	{
		objUtilities.logReporter("Verify CardType Value displayed", 
				objWrapperFunctions.verifyIsElementPresent(creditAccount_debitCardMenu_CardTypeValue), false);	
		System.out.println("CardType  :" +objWrapperFunctions.getText(creditAccount_debitCardMenu_CardTypeValue));
	}

	public void verifyExpiryDateLabelDisplyed()
	{
		objUtilities.logReporter("Verify ExpiryDate Label displayed", 
				objWrapperFunctions.verifyIsElementPresent(creditAccount_debitCardMenu_ExpiryDateLabel), false);
	}
	public void verifyAndGetExpiryDateValue()
	{
		objUtilities.logReporter("Verify ExpiryDateValue displayed", 
				objWrapperFunctions.verifyIsElementPresent(creditAccount_debitCardMenu_ExpiryDateValue), false);	
		System.out.println("ExpiryDate  :" +objWrapperFunctions.getText(creditAccount_debitCardMenu_ExpiryDateValue));
	}

	public void verifyAmountAvailableLabelDisplyed()
	{
		objUtilities.logReporter("Verify AmountAvailable Label displayed", 
				objWrapperFunctions.verifyIsElementPresent(creditAccount_debitCardMenu_AmountAvailableLabel), false);
	}
	public void verifyAndGetAmountAvailableValue()
	{
		objUtilities.logReporter("Verify AmountAvailable Value displayed", 
				objWrapperFunctions.verifyIsElementPresent(creditAccount_debitCardMenu_AmountAvailableValue), false);	
		System.out.println("AmountAvailable :" +objWrapperFunctions.getText(creditAccount_debitCardMenu_AmountAvailableValue));
	}

	public void verifyDOBLabelDisplyed()
	{
		objUtilities.logReporter("Verify AmountAvailable Label displayed", 
				objWrapperFunctions.verifyIsElementPresent(creditAccount_debitCardMenu_DOBLabel), false);
	}
	public void verifyAndGetDOBValue()
	{
		objUtilities.logReporter("Verify AmountAvailable Value displayed", 
				objWrapperFunctions.verifyIsElementPresent(creditAccount_debitCardMenu_DOBValue), false);
		customerDOB = objWrapperFunctions.getText(creditAccount_debitCardMenu_DOBValue);
		System.out.println("DOB :" +customerDOB);
	}

	public void verifyVisitMessageDisplyed()
	{
		objUtilities.logReporter("Verify visitMessage Label displayed", 
				objWrapperFunctions.verifyIsElementPresent(visitMessage), false);
	}


	public void verifyProcessTransactionMsgDisplyed()
	{
		objUtilities.logReporter("Verify processTransactionMsg displayed", 
				objWrapperFunctions.verifyIsElementPresent(processTransactionMsg), false);
	}

	public void verifyTransactionCompletedMsgDisplyed()
	{
		objUtilities.logReporter("Verify transactionCompletedMsg displayed", 
				objWrapperFunctions.verifyIsElementPresent(transactionCompletedMsg), false);
	}


	public void verifyvoidConfirmationMsgDisplyed()
	{
		objUtilities.logReporter("Verify voidConfirmationMsg displayed", 
				objWrapperFunctions.verifyIsElementPresent(voidConfirmationMsg), false);
	}

	public void verifyvoidSuccessMsgDisplyed()
	{
		objUtilities.logReporter("Verify voidSuccessMsg displayed", 
				objWrapperFunctions.verifyIsElementPresent(voidSuccessMsg), false);
	}


	void checkPresenceOfText(By locator){
		List<WebElement> list= objWrapperFunctions.getElements(locator);
		Iterator<WebElement> iterator = list.iterator();
		String arrTemp[]=new String[list.size()];
		int i=0;
		while(iterator.hasNext()){
			arrTemp[i]=objWrapperFunctions.getTextOfElement(list.get(i));
			i++;
			System.out.println(arrTemp[i]);
		}

	}





}
