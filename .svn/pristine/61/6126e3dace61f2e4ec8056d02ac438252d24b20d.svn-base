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
import com.google.common.base.VerifyException;

public class TopNavigation_CashDesk
{
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	Properties objConfig=new Properties();
	String message="";
	String NeonUser,NeonPass,custNumber="";
	static int reqIndex=0;
	static int tempRandom,cardLastFourDigits,expiry_month,expiry_year,chequNumber ;
	static String name,lastname,nameArray[];
	static char firstChar;
	static char secondChar;
	static String creditAccNum;
	static String slipNum;
	ExcelIterator objExcel=new ExcelIterator();
	static String refId_FE="",custName="",date="",cardnum="", conDate="";
	//static int cardnum;

	public TopNavigation_CashDesk(Pojo pojo){
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
		custNumber=pojo.getUser();
		custName=pojo.getUser1Values();
	}


	private By okBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'OK')]");
	private By topNavigationCashDesk = By.cssSelector("li#Cashdesk_Menu");
	private By cashDesk_payWinners = By.cssSelector("li#Cashdesk_WinnersPayments_Menu");	
	private By cashDesk_payWinners_IssueCheque = By.cssSelector("a#WinnersPayments_IssueCheque_Menu");	

	private By cashDesk_payWinners_RedeemCheque = By.cssSelector("a#WinnersPayments_RedeemWinnersCheque_Menu");
	private By cashDesk_payWinners_IssueCheque_CutNumTextBox = By.cssSelector("input#textBoxCustomerNumber");
	private By cashDesk_payWinners_IssueCheque_ChequeNumTextBox = By.cssSelector("input#textBoxChequeNumber");

	private By cashDesk_payWinners_IssueCheque_ChequeNumTextBox1 = By.cssSelector("input#textBoxOriginalChequeNumber");

	private By cashDesk_payWinners_RedeemCheque_ChequeNumTextBox = By.cssSelector("input#textBoxChequeNumber");

	private By cashDesk_payWinners_IssueCheque_AmountTextBox = By.cssSelector("input#textBoxAmount");
	private By cashDesk_payWinners_IssueCheque_CommentTextBox = By.cssSelector("textarea#Comment");
	private By cashDesk_payWinners_IssueCheque_replacementCheckbox = By.cssSelector("input#checkBoxReplacement");
	private By cashDesk_payWinners_IssueCheque_Scrollbar = By.cssSelector("div#main-content");

	private By okButton=By.xpath("//button[@data-ig-type='OK']");
	private By voidYesButton = By.cssSelector("button[data-ig-type='YES']");
	private By cashDesk_payWinners_SaveButton = By.cssSelector("button[accesskey='s']");

	private By cashDesk_currencyRate = By.cssSelector("a#Cashdesk_CurrencyRates_Menu");	
	private By cashDesk_currencyRate_importRates = By.cssSelector("button#buttonImportRates");	

	private By cashDesk_currencyRate_applyRates = By.cssSelector("button#buttonApplyRates");	

	private By cashDesk_currencyTransactions = By.cssSelector("li#Cashdesk_CurrencyTransactions_Menu");	
	private By cashDesk_currencyTransactions_redeem = By.cssSelector("a#CurrencyTransactions_RedeemCurrency_Menu");	
	private By cashDesk_currencyTransactions_redeem_inputNumber = By.cssSelector("input#textBoxBuyTransactionNumber");	
	private By cashDesk_currencyTransactions_redeem_inputForeignToRedeem = By.cssSelector("input#textBoxForeignToRedeem");	
	private By cashDesk_currencyTransactions_redeem_inputVlauetoRedeem = By.cssSelector("input#textBoxValueToRedeem");	

	private By cashDesk_currencyTransactions_RedeemCurrency_custNumberValue = By.xpath("//label[contains(.,'Customer Number')]//following-sibling::span");
	private By cashDesk_currencyTransactions_RedeemCurrency_custNumberLabel = By.xpath("//label[contains(.,'Customer Number')]");
	private By cashDesk_currencyTransactions_RedeemCurrency_custNameLabel =By.xpath("//label[contains(.,'Name')]");
	private By cashDesk_currencyTransactions_RedeemCurrency_custNameValue =By.xpath("//label[contains(.,'Name')]//following-sibling::span");
	private By cashDesk_currencyTransactions_RedeemCurrency_StatusValue =By.xpath("//label[contains(.,'Status')]//following-sibling::span");
	private By cashDesk_currencyTransactions_RedeemCurrency_Status =By.xpath("//label[contains(.,'Status')]");
	private By cashDesk_currencyTransactions_RedeemCurrency_OriginalForeignValueLabel =By.xpath("//label[contains(.,'Original Foreign Value')]");
	private By cashDesk_currencyTransactions_RedeemCurrency_OriginalForeignValue=By.xpath("//label[contains(.,'Original Foreign Value')]//following-sibling::span");
	private By cashDesk_currencyTransactions_RedeemCurrency_CurrencyValue=By.xpath("//label[contains(.,'Currency')]//following-sibling::span");
	private By cashDesk_currencyTransactions_RedeemCurrency_CurrencyLabel=By.xpath("//label[contains(.,'Currency')]");
	private By cashDesk_currencyTransactions_RedeemCurrency_ExchangeRateValue=By.xpath("//label[contains(.,'Exchange Rate')]//following-sibling::span");
	private By cashDesk_currencyTransactions_RedeemCurrency_ExchangeRate=By.xpath("//label[contains(.,'Exchange Rate')]");
	private By cashDesk_currencyTransactions_RedeemCurrency_PaymentAmountValue=By.xpath("//label[contains(.,'Payment Amount')]//following-sibling::span");
	private By cashDesk_currencyTransactions_RedeemCurrency_PaymentAmount=By.xpath("//label[contains(.,'Payment Amount')]");
	private By cashDesk_currencyTransactions_RedeemCurrency_ForeignAlreadyRedeemedValue=By.xpath("//label[contains(.,'Foreign Already Redeemed')]//following-sibling::span");
	private By cashDesk_currencyTransactions_RedeemCurrency_ForeignAlreadyRedeemed = By.xpath("//label[contains(.,'Foreign Already Redeemed')]");
	private By cashDesk_currencyTransactions_RedeemCurrency_AlreadyRedeemedValue = By.xpath("//label[contains(.,'Already Redeemed')]//following-sibling::span");
	private By cashDesk_currencyTransactions_RedeemCurrency_AlreadyRedeemed= By.xpath("//label[contains(.,'Already Redeemed')]");

	private By cashDesk_currencyTransactions_exchange = By.cssSelector("a#CurrencyTransactions_BuyCurrency_Menu");	
	private By cashDesk_currencyTransactions_exchange_enterName = By.cssSelector("input#textBoxCustomerName");	
	private By cashDesk_currencyTransactions_exchange_enterForeignValue = By.cssSelector("input#textBoxForeignValue");	
	private By cashDesk_currencyTransactions_exchange_exchangeValue = By.xpath("//input[@id='textBoxExchangeRate']");
	private By cashDesk_currencyTransactions_exchange_paymentValue = By.xpath("//input[@id='textBoxPaymentValue']");

	private By cashDesk_currencyTransactions_exchange_selectCurrency = By.cssSelector("select#dropDownCurrency");	
	private By thirdPartyAcc_CreateNewButton = By.cssSelector("button#buttonNew");

	private By cust_DOBValue =By.xpath("//label[contains(.,'Date of Birth')]//following-sibling::span");
	//private By custDOBLabel =By.xpath("//label[contains(.,'Date of Birth')]");
	private By custDOBLabel =By.xpath("///div//label[contains(.,'Date of Birth')]");
	private By cashDesk_currencyTransactions_redeem_slipNumber = By.cssSelector("td[data-grid-column-key='TransactionNumber']");	

	//	private By cashDesk_currencyTransactions_redeem_slipNumber = By.xpath("//td[@data-grid-column-key='TransactionNumber']//span");

	private By topnav_View = By.cssSelector("li#View_Menu");	
	private By topnav_View_CurrencyTransaction = By.cssSelector("a#View_ViewCurrencyTransactions_Menu");	
	private By topnav_View_CurrencyTransaction_findButton = By.cssSelector("button#buttonFind");	
	private By topnav_View_selectButton = By.cssSelector("select#ReportInterval_Id");
	//private By topnav_View_fieldset_findButton = By.xpath("//button[@class='collapsor active']");	
	private By topnav_View_fieldset_findButton = By.xpath("//input[@id='radioButtonByCurrency']");
	private By CashDesk_CurrencyTransaction = By.cssSelector("li#Cashdesk_CurrencyTransactions_Menu a");	
	private By CashDesk_CurrencyTransaction_ExchangeTravellersCheque = By.cssSelector("a#CurrencyTransactions_ExchangeTravellersCheque_Menu");	
	private By CashDesk_ExchangeTravellersCheque_inputName = By.cssSelector("input#textBoxCustomerName");	
	private By CashDesk_ExchangeTravellersCheque_selectCurrency = By.cssSelector("select#dropDownCurrency");	
	private By CashDesk_ExchangeTravellersCheque_inputForeignValue= By.cssSelector("input#textBoxForeignValue");	
	private By closeIconTab=By.xpath("//button[@accesskey='x']");
	private By voidOKButton = By.cssSelector("button[data-ig-type='OK']");

	private By custDetails=By.xpath("//div[@id='divDetails']//fieldset//div");
	private By createnewCreditAcc_selectManager= By.xpath("//td//span[@class='ng-binding'][contains(.,'Dsilva')]");

	public void exchangeTravellersCheque() throws InterruptedException{
		clickTopNavCashDesk();
		objUtilities.logReporter("Click on Currency Transaction", objWrapperFunctions.click(CashDesk_CurrencyTransaction), false);		
		objUtilities.logReporter("Click on Exchange Travellers Cheque", objWrapperFunctions.click(CashDesk_CurrencyTransaction_ExchangeTravellersCheque), false);

		String usernm=String.valueOf(custName) + " sqs" ;
		objUtilities.logReporter("Enter Name", objWrapperFunctions.setText(CashDesk_ExchangeTravellersCheque_inputName,usernm), false);

		objUtilities.logReporter("Select currency type", objWrapperFunctions.selectDropDownByIndex(CashDesk_ExchangeTravellersCheque_selectCurrency, 1), false);
		Thread.sleep(500);
		objUtilities.logReporter("Enter Foreign Value", objWrapperFunctions.setText(CashDesk_ExchangeTravellersCheque_inputForeignValue,"5"), false);
		objUtilities.logReporter("Click on save", objWrapperFunctions.clickByScript(cashDesk_payWinners_SaveButton), false);

		if(objWrapperFunctions.checkElementDisplyed(createnewCreditAcc_selectManager))
		{
			objUtilities.logReporter("Select Page", objWrapperFunctions.click(createnewCreditAcc_selectManager), false);
			objUtilities.logReporter("Click on OK", objWrapperFunctions.click(voidOKButton), false);
		}
		clickOkOrYes();
		clickOkOrYes();
	}

	public void clickCreditAccounts_CreateNewButton(){

		objUtilities.logReporter("Click on Create New", objWrapperFunctions.click(thirdPartyAcc_CreateNewButton), false);
		System.out.println("Create New Button Clicked");

	}

	public void exchangeCurrency()
	{
	//	try {
			clickTopNavCashDesk();		
			objUtilities.logReporter("Click on currency Transactions", objWrapperFunctions.clickByScript(cashDesk_currencyTransactions), false);
			objUtilities.logReporter("Click on exchange currency Transactions", objWrapperFunctions.clickByScript(cashDesk_currencyTransactions_exchange), false);
			//clickCreditAccounts_CreateNewButton();
			String usernm=String.valueOf(custName)  ;
			System.out.println(usernm);
			objUtilities.logReporter("Enter Name", objWrapperFunctions.setText(cashDesk_currencyTransactions_exchange_enterName,usernm), false);
			objUtilities.logReporter("Select currency type", objWrapperFunctions.selectDropDownByIndex(cashDesk_currencyTransactions_exchange_selectCurrency, 1), false);
			//objWrapperFunctions.clear(cashDesk_currencyTransactions_exchange_enterForeignValue);
			objWrapperFunctions.waitForElementPresence(cashDesk_currencyTransactions_exchange_enterForeignValue);
			objWrapperFunctions.waitForElementToBeClickable(cashDesk_currencyTransactions_exchange_enterForeignValue);
			objUtilities.logReporter("Enter foreign Value", objWrapperFunctions.setText(cashDesk_currencyTransactions_exchange_enterForeignValue,"1"), false);
			objWrapperFunctions.pressTabBtn(cashDesk_currencyTransactions_exchange_enterForeignValue);
			//Thread.sleep(8000);
			//clickOkOrYes();
			objWrapperFunctions.waitForElementPresence(cashDesk_currencyTransactions_exchange_exchangeValue);
			objWrapperFunctions.waitForElementPresence(cashDesk_currencyTransactions_exchange_paymentValue);
			String exchangeRate =	objWrapperFunctions.getAttributeValue(cashDesk_currencyTransactions_exchange_exchangeValue, "value");
			String paymentValue =	objWrapperFunctions.getAttributeValue(cashDesk_currencyTransactions_exchange_paymentValue, "value");
			System.out.println("Exchange Rate =" + exchangeRate + "  paymentValue = " +paymentValue);
			objWrapperFunctions.waitForElementPresence(cashDesk_payWinners_SaveButton);
			objWrapperFunctions.waitForElementToBeClickable(cashDesk_payWinners_SaveButton);
			objUtilities.logReporter("Click on save", objWrapperFunctions.clickByScript(cashDesk_payWinners_SaveButton), false);
			//clickOkOrYes();
			//clickOkOrYes();
		/*} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	public void redeemCurrency()
	{
		objUtilities.logReporter("Click on View", objWrapperFunctions.clickByScript(topnav_View), false);
		objUtilities.logReporter("Click on currency Transactions", objWrapperFunctions.clickByScript(topnav_View_CurrencyTransaction), false);
		objUtilities.logReporter("Click on currency ", objWrapperFunctions.clickByScript(topnav_View_fieldset_findButton), false);
		//objUtilities.logReporter("Select Date Range",objWrapperFunctions.selectDropDownByIndex(topnav_View_selectButton,31), false);
		objUtilities.logReporter("Click on Find", objWrapperFunctions.clickByScript(topnav_View_CurrencyTransaction_findButton), false);

		//int s = objWrapperFunctions.getRandBet(2, 1);
		//System.out.println(s);
		slipNum=objWrapperFunctions.getText(objWrapperFunctions.getElementOfIndex(cashDesk_currencyTransactions_redeem_slipNumber,0));
		System.out.println("sfsdf sdf = " +slipNum);
		clickTopNavCashDesk();
		objUtilities.logReporter("Click on currency Transactions", objWrapperFunctions.clickByScript(cashDesk_currencyTransactions), false);
		objUtilities.logReporter("Click on redeem currency Transactions", objWrapperFunctions.clickByScript(cashDesk_currencyTransactions_redeem), false);
		verifyCustomerNameLabelDisplyed();
		verifyCustomerNumberLabelDisplyed();
		//	int t = objWrapperFunctions.getRandBet(999999, 111111);
		objUtilities.logReporter("Enter number", objWrapperFunctions.setText(cashDesk_currencyTransactions_redeem_inputNumber,slipNum), false);
		objWrapperFunctions.pressTabBtn(cashDesk_currencyTransactions_redeem_inputNumber);
		verifyCustomerNameLabelDisplyed();
		verifyAndGetCustomerNameValue();
		/*verifyCustomerNumberLabelDisplyed();
		verifyAndGetCustomerNumberValue();*/
		verifyStausLabelDisplyed();
		verifyAndGetStatusValue();
		verifyCurrencyLabelDisplyed();
		verifyAndGetCurrencyValue();
		verifyOriginalForeignValueLabelDisplyed();
		verifyAndGetOriginalForeignValueValue();
		verifyExchangeRateLabelDisplyed();
		verifyAndGetExchangeRateValue();
		verifyPaymentAmountLabelDisplyed();
		verifyAndGetPaymentAmountValue();
		verifyForeignAlreadyRedeemedLabelDisplyed();
		verifyAndGetForeignAlreadyRedeemedValue();
		verifyAlreadyRedeemedLabelDisplyed();
		verifyAndGetAlreadyRedeemedValue();
		objUtilities.logReporter("Enter foreign currency to redeem", objWrapperFunctions.setText(cashDesk_currencyTransactions_redeem_inputForeignToRedeem,"1"), false);
		//objUtilities.logReporter("Enter value to redeem", objWrapperFunctions.setText(cashDesk_currencyTransactions_redeem_inputVlauetoRedeem,"5"), false);
		String convertedAmount=objWrapperFunctions.getAttributeValue(cashDesk_currencyTransactions_redeem_inputVlauetoRedeem,"value");
		System.out.println("Converted Amount = " +convertedAmount);

		/*	objUtilities.logReporter("Click on save", objWrapperFunctions.clickByScript(cashDesk_payWinners_SaveButton), false);
		clickOkOrYes();
		clickOkOrYes();*/
	}

	public void verifyCustomerNumberLabelDisplyed()
	{
		objUtilities.logReporter("Verify Customer Number label displayed", 
				objWrapperFunctions.verifyIsElementPresent(cashDesk_currencyTransactions_RedeemCurrency_custNumberLabel), false);
	}
	public void verifyAndGetCustomerNumberValue()
	{
		objUtilities.logReporter("Verify CustomerNumber Value displayed", 
				objWrapperFunctions.verifyIsElementPresent(cashDesk_currencyTransactions_RedeemCurrency_custNumberValue), false);	
		System.out.println("custNumber :" +objWrapperFunctions.getText(cashDesk_currencyTransactions_RedeemCurrency_custNumberValue));
	}

	public void verifyCustomerNameLabelDisplyed()
	{
		objWrapperFunctions.waitForElementPresence(cashDesk_currencyTransactions_RedeemCurrency_custNameLabel);
		objUtilities.logReporter("Verify Customer Name label displayed", 
				objWrapperFunctions.verifyIsElementPresent(cashDesk_currencyTransactions_RedeemCurrency_custNameLabel), false);
	}
	public void verifyAndGetCustomerNameValue()
	{
		objWrapperFunctions.waitForElementPresence(cashDesk_currencyTransactions_RedeemCurrency_custNameValue);
		objUtilities.logReporter("Verify CustomerName Value displayed", 
				objWrapperFunctions.verifyIsElementPresent(cashDesk_currencyTransactions_RedeemCurrency_custNameValue), false);	
		//System.out.println("custName :" +objWrapperFunctions.getText(cashDesk_currencyTransactions_RedeemCurrency_custNameValue));
	}


	public void verifyDOBLabelDisplayed()
	{
		objWrapperFunctions.waitForElementPresence(custDOBLabel);
		objUtilities.logReporter("Verify Customer DOB label displayed", 
				objWrapperFunctions.verifyIsElementPresent(custDOBLabel), false);
	}
	public void verifyAndGetDOBValue()
	{
		objWrapperFunctions.waitForElementPresence(cust_DOBValue);
		objUtilities.logReporter("Verify Customer DOB Value displayed", 
				objWrapperFunctions.verifyIsElementPresent(cust_DOBValue), false);	
		System.out.println("cust DOB :" +objWrapperFunctions.getText(cust_DOBValue));
	}


	public void verifyStausLabelDisplyed()
	{
		objUtilities.logReporter("Verify Staus label displayed", 
				objWrapperFunctions.verifyIsElementPresent(cashDesk_currencyTransactions_RedeemCurrency_Status), false);
	}
	public void verifyAndGetStatusValue()
	{
		objUtilities.logReporter("Verify Staus Value displayed", 
				objWrapperFunctions.verifyIsElementPresent(cashDesk_currencyTransactions_RedeemCurrency_StatusValue), false);	
		System.out.println("Status :" +objWrapperFunctions.getText(cashDesk_currencyTransactions_RedeemCurrency_StatusValue));
	}

	public void verifyCurrencyLabelDisplyed()
	{
		objUtilities.logReporter("Verify Currency label displayed", 
				objWrapperFunctions.verifyIsElementPresent(cashDesk_currencyTransactions_RedeemCurrency_CurrencyLabel), false);
	}
	public void verifyAndGetCurrencyValue()
	{
		objUtilities.logReporter("Verify Currency Value displayed", 
				objWrapperFunctions.verifyIsElementPresent(cashDesk_currencyTransactions_RedeemCurrency_CurrencyValue), false);	
		System.out.println("Currency :" +objWrapperFunctions.getText(cashDesk_currencyTransactions_RedeemCurrency_CurrencyValue));
	}

	public void verifyOriginalForeignValueLabelDisplyed()
	{
		objUtilities.logReporter("Verify Original Foreign Value label displayed", 
				objWrapperFunctions.verifyIsElementPresent(cashDesk_currencyTransactions_RedeemCurrency_OriginalForeignValueLabel), false);
	}
	public void verifyAndGetOriginalForeignValueValue()
	{
		objUtilities.logReporter("Verify Original Foreign Value Value displayed", 
				objWrapperFunctions.verifyIsElementPresent(cashDesk_currencyTransactions_RedeemCurrency_OriginalForeignValue), false);	
		System.out.println("OriginalForeignValue :" +objWrapperFunctions.getText(cashDesk_currencyTransactions_RedeemCurrency_OriginalForeignValue));
	}

	public void verifyExchangeRateLabelDisplyed()
	{
		objUtilities.logReporter("Verify ExchangeRate label displayed", 
				objWrapperFunctions.verifyIsElementPresent(cashDesk_currencyTransactions_RedeemCurrency_ExchangeRate), false);
	}
	public void verifyAndGetExchangeRateValue()
	{
		objUtilities.logReporter("Verify Exchange Rate Value displayed", 
				objWrapperFunctions.verifyIsElementPresent(cashDesk_currencyTransactions_RedeemCurrency_ExchangeRateValue), false);	
		System.out.println("ExchangeRateValue :" +objWrapperFunctions.getText(cashDesk_currencyTransactions_RedeemCurrency_ExchangeRateValue));
	}

	public void verifyPaymentAmountLabelDisplyed()
	{
		objUtilities.logReporter("Verify Payment Amount label displayed", 
				objWrapperFunctions.verifyIsElementPresent(cashDesk_currencyTransactions_RedeemCurrency_PaymentAmount), false);
	}
	public void verifyAndGetPaymentAmountValue()
	{
		objUtilities.logReporter("Verify Payment Amount Value displayed", 
				objWrapperFunctions.verifyIsElementPresent(cashDesk_currencyTransactions_RedeemCurrency_PaymentAmountValue), false);	
		System.out.println("PaymentAmount :" +objWrapperFunctions.getText(cashDesk_currencyTransactions_RedeemCurrency_PaymentAmountValue));
	}


	public void verifyAlreadyRedeemedLabelDisplyed()
	{
		objUtilities.logReporter("Verify Already Redeemed label displayed", 
				objWrapperFunctions.verifyIsElementPresent(cashDesk_currencyTransactions_RedeemCurrency_AlreadyRedeemed), false);
	}
	public void verifyAndGetAlreadyRedeemedValue()
	{
		objUtilities.logReporter("Verify Already Redeemed Value displayed", 
				objWrapperFunctions.verifyIsElementPresent(cashDesk_currencyTransactions_RedeemCurrency_AlreadyRedeemedValue), false);	
		System.out.println("AlreadyRedeemedValue:" +objWrapperFunctions.getText(cashDesk_currencyTransactions_RedeemCurrency_AlreadyRedeemedValue));
	}
	public void verifyForeignAlreadyRedeemedLabelDisplyed()
	{
		objUtilities.logReporter("Verify Foreign Already Redeemed label displayed", 
				objWrapperFunctions.verifyIsElementPresent(cashDesk_currencyTransactions_RedeemCurrency_ForeignAlreadyRedeemed), false);
	}
	public void verifyAndGetForeignAlreadyRedeemedValue()
	{
		objUtilities.logReporter("Verify Foreign Already Redeemed Value displayed", 
				objWrapperFunctions.verifyIsElementPresent(cashDesk_currencyTransactions_RedeemCurrency_ForeignAlreadyRedeemedValue), false);	
		System.out.println("ForeignAlreadyRedeemedValue:" +objWrapperFunctions.getText(cashDesk_currencyTransactions_RedeemCurrency_ForeignAlreadyRedeemedValue));
	}



	public void importCurrencyRate(){

		try {
			clickTopNavCashDesk();
			objUtilities.logReporter("Click on cashDesk_currencyRate", objWrapperFunctions.clickByScript(cashDesk_currencyRate), false);
			Thread.sleep(8000);
		//	verifyRateChangedIcon("false");
			objUtilities.logReporter("Click on cashDesk_currencyRate_importRates", objWrapperFunctions.clickByScript(cashDesk_currencyRate_importRates), false);
			verifyConfirmationMessage("Currency rates successfully imported.");
			clickOkOrYes();	
		//	verifyRateChangedIcon("true");
			objUtilities.logReporter("Click on apply rates", objWrapperFunctions.clickByScript(cashDesk_currencyRate_applyRates), false);
			verifyConfirmationMessage("Apply rates");
			clickOkOrYes();
			verifyConfirmationMessage("New currency rates have successfully been applied.");
			clickOkOrYes();
			
			objUtilities.logReporter("Click on save", objWrapperFunctions.clickByScript(cashDesk_payWinners_SaveButton), false);
			clickOkOrYes();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void verifyRateChangedIcon(String icon)
	{
		By rateChangedXicon = By.xpath("//td[@data-grid-column-key='RateChange']//span//scan[@class='"+icon+"']");
		objUtilities.logReporter("Verify RateChangedIcon ", 
				objWrapperFunctions.verifyIsElementPresent(rateChangedXicon), false);	
	}

	public void verifyConfirmationMessage(String msg)
	{
		By message = By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'"+msg+"')]");
		objUtilities.logReporter("Verify message display as  ", 
				objWrapperFunctions.verifyIsElementPresent(message), false);	}
	
	public void issueCheque(){
		try {
			creditAccNum=custNumber;

			clickCashDesk_payWinners_IssueCheque();
			enterCustNum(cashDesk_payWinners_IssueCheque_CutNumTextBox,creditAccNum);
			objWrapperFunctions.pressTabBtn(cashDesk_payWinners_IssueCheque_CutNumTextBox);
			//clickTopNavCashDesk();
			//	objWrapperFunctions.scrollTab(cashDesk_payWinners_IssueCheque_Scrollbar);
			//	objUtilities.logReporter("Enter Amount", objWrapperFunctions.setText(cashDesk_payWinners_IssueCheque_AmountTextBox,"10"), false);
			//clickOkOrYes();
			//clickTopNavCashDesk();
			if(objWrapperFunctions.checkElementDisplyed(okButton))
			{
				objUtilities.logReporter("Click on okButton", objWrapperFunctions.click(okButton), false);
			}
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		chequNumber = objWrapperFunctions.getRandBet(99999, 11111);
		objUtilities.logReporter("Enter Cheque number", objWrapperFunctions.setText(cashDesk_payWinners_IssueCheque_ChequeNumTextBox,String.valueOf(chequNumber)), false);

		objUtilities.logReporter("Enter Amount", objWrapperFunctions.setText(cashDesk_payWinners_IssueCheque_AmountTextBox,"10"), false);


		objUtilities.logReporter("Enter Comment", objWrapperFunctions.setText(cashDesk_payWinners_IssueCheque_CommentTextBox,"Test Purpose only"), false);
		objUtilities.logReporter("Click on save", objWrapperFunctions.click(cashDesk_payWinners_SaveButton), false);
		clickOkOrYes();
		clickOkOrYes();
		objUtilities.logReporter("Click on closeIconTab", objWrapperFunctions.click(closeIconTab), false);

	}


	public void issueReplacementCheque(){
		try {

			Thread.sleep(8000);
			creditAccNum=custNumber;
			clickTopNavCashDesk();
			//clickCashDesk_payWinners();
			clickCashDesk_payWinners_IssueCheque();
			enterCustNum(cashDesk_payWinners_IssueCheque_CutNumTextBox,creditAccNum);
			objWrapperFunctions.pressTabBtn(cashDesk_payWinners_IssueCheque_CutNumTextBox);
			Thread.sleep(6000);
			//objUtilities.logReporter("Enter Amount", objWrapperFunctions.setText(cashDesk_payWinners_IssueCheque_AmountTextBox,"10"), false);
			if(objWrapperFunctions.checkElementDisplyed(okButton))
			{
				objUtilities.logReporter("Click on okButton", objWrapperFunctions.click(okButton), false);
			}
			//clickOkOrYes();
			int t = objWrapperFunctions.getRandBet(99999, 11111);
			objUtilities.logReporter("Enter Cheque number", objWrapperFunctions.setText(cashDesk_payWinners_IssueCheque_ChequeNumTextBox,String.valueOf(t)), false);

			objUtilities.logReporter("Enter Amount", objWrapperFunctions.setText(cashDesk_payWinners_IssueCheque_AmountTextBox,"10"), false);

			objUtilities.logReporter("Click on Replacement chequebox", objWrapperFunctions.click(cashDesk_payWinners_IssueCheque_replacementCheckbox), false);

			objUtilities.logReporter("Enter Cheque number", objWrapperFunctions.setText(cashDesk_payWinners_IssueCheque_ChequeNumTextBox1,String.valueOf(chequNumber)), false);

			objUtilities.logReporter("Enter Comment", objWrapperFunctions.setText(cashDesk_payWinners_IssueCheque_CommentTextBox,"Test Purpose only"), false);

			objUtilities.logReporter("Click on save", objWrapperFunctions.click(cashDesk_payWinners_SaveButton), false);
			clickOkOrYes();
			clickOkOrYes();
			objUtilities.logReporter("Click on closeIconTab", objWrapperFunctions.click(closeIconTab), false);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void redeemCheque()
	{	try
	{
		issueCheque();
		clickTopNavCashDesk();
		clickCashDesk_payWinners_RedeemCheque();
		objUtilities.logReporter("Enter Cheque number", objWrapperFunctions.setText(cashDesk_payWinners_RedeemCheque_ChequeNumTextBox,String.valueOf(chequNumber)), false);
		//objUtilities.logReporter("Enter Cheque number", objWrapperFunctions.setText(cashDesk_payWinners_RedeemCheque_ChequeNumTextBox,"90717"), false);
		objWrapperFunctions.pressTabBtn(cashDesk_payWinners_RedeemCheque_ChequeNumTextBox);
		if(objWrapperFunctions.checkElementDisplyed(okButton))
		{
			objUtilities.logReporter("Click on okButton", objWrapperFunctions.click(okButton), false);
		}
		Thread.sleep(6000);	
		objWrapperFunctions.displayAllElement(custDetails);
		objUtilities.logReporter("Enter Comment", objWrapperFunctions.setText(cashDesk_payWinners_IssueCheque_CommentTextBox,"Test Purpose only"), false);	
		objUtilities.logReporter("Click on save", objWrapperFunctions.click(cashDesk_payWinners_SaveButton), false);
		clickOkOrYes();
		clickOkOrYes();

	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public void clickOkOrYes(){
		//System.out.println("Closing Pop-up :"+count);
		//	objWrapperFunctions.waitForElementPresence(voidYesButton);
		if(objWrapperFunctions.checkElementDisplyed(voidYesButton)){
			objWrapperFunctions.acceptMultipleAlert(voidYesButton);
		}else
		if(objWrapperFunctions.checkElementDisplyed(okBtn)){
			objWrapperFunctions.acceptMultipleAlert(okBtn);
		}		
	}


	public void enterCustNum(By locator,String num)
	{
		objUtilities.logReporter("Enter Customer Number", objWrapperFunctions.setText(locator, String.valueOf(num)), false);

	}

	public void clickCashDesk_payWinners_RedeemCheque(){
		objUtilities.logReporter("Click on cashDesk_payWinners Redeem Chque", objWrapperFunctions.click(cashDesk_payWinners_RedeemCheque), false);
		System.out.println("Click on cashDesk_payWinners Redeem Cheque");

	}


	public void clickCashDesk_payWinners_IssueCheque(){
		objUtilities.logReporter("Click on cashDesk_payWinners Issue Cheque", objWrapperFunctions.click(cashDesk_payWinners_IssueCheque), false);
		System.out.println("Click on cashDesk_payWinners Issue Cheque");

	}

	public void clickCashDesk_payWinners(){

		objUtilities.logReporter("Click on cashDesk_payWinners", objWrapperFunctions.click(cashDesk_payWinners), false);
		System.out.println("Click on cashDesk_payWinners");
	}

	public void clickTopNavCashDesk(){
		objWrapperFunctions.waitForElementToBeClickable(topNavigationCashDesk);
		objUtilities.logReporter("Click on Top Navigation Cash Desk", objWrapperFunctions.click(topNavigationCashDesk), false);
		System.out.println("Click on Top Navigation Cash Desk");

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
