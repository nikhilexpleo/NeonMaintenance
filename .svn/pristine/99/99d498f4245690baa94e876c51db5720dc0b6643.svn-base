package com.pageFactory.CustomerProfileTC;

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

public class TopNavigation_Customers
{
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	String message="";
	String NeonUser,NeonPass;
	static int reqIndex=0;
	static int tempRandom,cardLastFourDigits,expiry_month,expiry_year ;
	static String name,lastname,nameArray[];
	static char firstChar;
	static char secondChar;
	static int creditAccNum;
	static String customerNum;
	ExcelIterator objExcel=new ExcelIterator();
	static String refId_FE="",custName="",date="",cardnum="", conDate="";
	//static int cardnum;

	public TopNavigation_Customers(Pojo pojo){
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
		NeonUser=pojo.getNeonUser();
		NeonPass=pojo.geNeonPassword();	
		customerNum=pojo.getUser();
	}

	private By userName=By.id("Username");
	private By password=By.id("Password");
	private By signBtn=By.xpath("//button[@class='btn btn-lg btn-primary btn-block ig-signin-button']");
	private By okBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'OK')]");
	private By voidYesButton = By.cssSelector("button[data-ig-type='YES']");


	private By topNavCustomers = By.cssSelector("li#CustomerManagement_Menu");
	private By topNavCustomers_Customers = By.cssSelector("a#CustomerManagement_CustomerMaintenance_Menu");

	private By topNavCustomers_Customers_inputCustNum = By.cssSelector("input#Number");
	private By topNavCustomers_Customers_buttonFind = By.cssSelector("button#buttonFind");
	private By topNavCustomers_Customers_Details_PrimarySalutations = By.cssSelector("input#Customer_PrimarySalutation");
	private By topNavCustomers_Customers_Details_SecondarySalutations = By.cssSelector("input#Customer_SecondarySalutation");
	private By topNavCustomers_Customers_Details_Name = By.cssSelector("input#textBoxName");
	private By topNavCustomers_Customers_Details_Number = By.cssSelector("input#textBoxNumber");

	private By topNavCustomers_CustomersDetails_Addresses = By.cssSelector("li#tabAddresses");
	private By topNavCustomers_CustomersDetails_Addresses_Street = By.cssSelector("td[data-grid-column-key='Street']");
	private By topNavCustomers_CustomersDetails_Addresses_City = By.cssSelector("td[data-grid-column-key='City']");
	private By topNavCustomers_CustomersDetails_Addresses_Region = By.cssSelector("td[data-grid-column-key='Region']");
	private By topNavCustomers_CustomersDetails_Addresses_PostCode = By.cssSelector("td[data-grid-column-key='PostCode']");
	private By topNavCustomers_CustomersDetails_Addresses_CountryName = By.cssSelector("td[data-grid-column-key='CountryName']");

	private By topNavCustomers_CustomersDetails_Addresses_RemoveButton = By.cssSelector("button.btn.btn-warning.ig-btn-wide.btn-secured");
	private By topNavCustomers_CustomersDetails_Addresses_DeleteButton = By.xpath("//button[@class='btn-primary btn-secured ig-column-button' and text()='Delete']");

	private By topNavCustomers_CustomersDetails_Addresses_NewAddress_Postcode = By.cssSelector("input#txtPostcodeLookup");
	private By topNavCustomers_CustomersDetails_Addresses_NewAddress_txtStreet = By.cssSelector("textarea#txtStreet");
	private By topNavCustomers_CustomersDetails_Addresses_NewAddress_txtCity = By.cssSelector("input#txtCity");
	private By topNavCustomers_CustomersDetails_Addresses_NewAddress_txtRegion = By.cssSelector("input#txtRegion");

	//private By topNavCustomers_CustomersDetails_Addresses_NewAddress_matchButton = By.cssSelector("button.btn-primary.btn-secured");


	private By topNavCustomers_CustomersDetails_Addresses_NewAddress_matchButton = By.cssSelector("td.text-center button.btn-primary.btn-secured");
	private By topNavCustomers_CustomersDetails_Addresses_NewAddress_addButton = By.cssSelector("button#buttonAddMessage");	
	private By topNavCustomers_CustomersDetails_Addresses_NewAddress_saveButton = By.cssSelector("button[accesskey='s']");
	private By topNavCustomers_CustomersDetails_Addresses_NewAddress_okButton =By.xpath("//button[text()='OK']");
	private By topNavCustomers_CustomersDetails_Identifications = By.cssSelector("li#tabIdentifications");
	private By topNavCustomers_CustomersDetails_Identifications_type = By.cssSelector("td[data-grid-column-key='TypeName']");
	private By topNavCustomers_CustomersDetails_Identifications_Reference = By.cssSelector("td[data-grid-column-key='Reference']");
	private By topNavCustomers_CustomersDetails_Identifications_IssueDate = By.cssSelector("td[data-grid-column-key='IssueDate']");
	private By topNavCustomers_CustomersDetails_Identifications_ExpiryDate = By.cssSelector("td[data-grid-column-key='ExpiryDate']");
	private By topNavCustomers_CustomersDetails_Identifications_IssueDetail = By.cssSelector("td[data-grid-column-key='IssueDetail']");

	private By topNavCustomers_CustomersDetails_Identifications_selectType = By.cssSelector("select#dropDownIdentificationType");
	private By topNavCustomers_CustomersDetails_Identifications_inputReference = By.cssSelector("input#textboxReference");
	private By topNavCustomers_CustomersDetails_Identifications_inputIssueDate = By.cssSelector("input#dateTimeIdIssueDate");
	private By topNavCustomers_CustomersDetails_Identifications_inputExpiryDate = By.cssSelector("input#dateTimeIdExpiryDate");
	private By topNavCustomers_CustomersDetails_Identifications_inputDetails = By.cssSelector("input#textboxDetail");

	private By topNavCustomers_CustomersDetails_Notes = By.cssSelector("li#tabNotes");
	private By topNavCustomers_CustomersDetails_Notes_details = By.cssSelector("textarea#textBoxNoteDetails");

	private By topNavCustomers_CustomersDetails_Notes_savedNote_GamingDate = By.cssSelector("td[data-grid-column-key='GamingDate']");
	private By topNavCustomers_CustomersDetails_Notes_savedNote_PropertyName = By.cssSelector("td[data-grid-column-key='PropertyName']");
	private By topNavCustomers_CustomersDetails_Notes_savedNote_Details = By.cssSelector("td[data-grid-column-key='Details']");
	private By topNavCustomers_CustomersDetails_Notes_savedNote_UserLoginName = By.cssSelector("td[data-grid-column-key='UserLoginName']");

	private By topNavCustomers_CustomersDetails_Messages = By.cssSelector("li#tabMessages");


	private By topNavCustomers_IntelligentDataBase = By.cssSelector("a#CustomerManagement_IntelligenceDatabase_Menu");
	private By topNavCustomers_IntelligentDataBase_inputCustNum = By.cssSelector("input#Id");
	private By topNavCustomers_IntelligentDataBase_selectStatus = By.cssSelector("select#Status");
	//private By thirdPartyAcc_FindAcc_clickDetails = By.cssSelector("td.text-center button.btn-primary.btn-secured");
	private By thirdPartyAcc_FindAcc_clickDetails = By.xpath("(//button[text()='Details'])[1]");
	private By topNavCustomers_IntelligentDataBase_Details_Name = By.cssSelector("input#SecurityEntry_Surname");
	private By topNavCustomers_CustomersDetails_Cust_Address = By.cssSelector("li#tabAddresses");
	private By topNavCustomers_CustomersDetails_Cust_Audit = By.cssSelector("li#tabAudit");
	private By topNavCustomers_CustomersDetails_Cust_Audit_dateTime = By.cssSelector("td[data-grid-column-key='DateTimeChanged']");
	private By topNavCustomers_CustomersDetails_Cust_Audit_propertyname = By.cssSelector("td[data-grid-column-key='PropertyName']");

	private By topNavCustomers_CustomersDetails_Cust_Identifications = By.cssSelector("li#tabIdentifications");	
	private By topNavCustomers_CustomersDetails_Cust_Identification1 = By.cssSelector("td[data-grid-column-key='TypeName']");
	private By topNavCustomers_CustomersDetails_Cust_Identification2 = By.cssSelector("td[data-grid-column-key='Reference']");

	private By topNavCustomers_CustomersDetails_Cust_images = By.cssSelector("li#tabImages");	
	private By topNavCustomers_CustomersDetails_Cust_images1 = By.cssSelector("li.gallery-card.ng-scope.active h4");
	private By topNavCustomers_CustomersDetails_Cust_images2 = By.cssSelector("ul.gallery ul li");

	private By topNavCustomers_CustomersDetails_Cust_incidents = By.cssSelector("li#tabIncidents");	
	private By topNavCustomers_CustomersDetails_Cust_incidents1 = By.cssSelector("td[data-grid-column-key='GamingDate']");
	private By topNavCustomers_CustomersDetails_Cust_incidents2 = By.cssSelector("td[data-grid-column-key='ActualDateTime']");

	private By topNavCustomers_CustomersDetails_Transactions = By.cssSelector("li#tabAllTransactions");
	private By topNavCustomers_CustomersDetails_Transactions_expand = By.cssSelector("button[accesskey='e']");
	private By PlayerTracking_hospitalityTransaction_selectDuration = By.cssSelector("select#ReportInterval_Id");	
	private By PlayerTracking_hospitalityTransaction_buttonFind = By.cssSelector("button#buttonFind");	
	private By PlayerTracking_hospitalityTransaction_TransactionDate = By.cssSelector("td[data-grid-column-key='TransactionDateTime']");	
	private By PlayerTracking_hospitalityTransaction_TransactionCreditValue = By.cssSelector("td[data-grid-column-key='CreditValueFormatted']");	


	private By PlayerTracking_hospitalityTransaction_TransactionType = By.cssSelector("td[data-grid-column-key='TransactionTypeName']");	
	private By PlayerTracking_hospitalityTransaction_TransactionDebitValue = By.cssSelector("td[data-grid-column-key='DebitValueFormatted']");
	private By PlayerTracking_hospitalityTransaction_TransactionValue = By.cssSelector("td[data-grid-column-key='Value']");

	By customerProfileNotes_okBtn = By.xpath("//button[@data-ig-type='OK']");

	public void viewAllTransactions()
	{
		checkCustDetails();
		objUtilities.logReporter("Click on All transactions", objWrapperFunctions.click(topNavCustomers_CustomersDetails_Transactions), false);
		objUtilities.logReporter("Click on Expand", objWrapperFunctions.click(topNavCustomers_CustomersDetails_Transactions_expand), false);
		objUtilities.logReporter("Select Duration", objWrapperFunctions.selectDropDownByIndex(PlayerTracking_hospitalityTransaction_selectDuration, 8), false);
		objUtilities.logReporter("Click on Find", objWrapperFunctions.clickByScript(PlayerTracking_hospitalityTransaction_buttonFind), false);

		String arrTransactionDate[]=objWrapperFunctions.getElementTextArray(PlayerTracking_hospitalityTransaction_TransactionDate);
		String arrTransactionValue[]=objWrapperFunctions.getElementTextArray(PlayerTracking_hospitalityTransaction_TransactionValue);

		String arrTransactionType[]=objWrapperFunctions.getElementTextArray(PlayerTracking_hospitalityTransaction_TransactionType);
		String arrTransactionCreditValue[]=objWrapperFunctions.getElementTextArray(PlayerTracking_hospitalityTransaction_TransactionCreditValue);
		String arrTransactionDebitValue[]=objWrapperFunctions.getElementTextArray(PlayerTracking_hospitalityTransaction_TransactionDebitValue);


		for (int i = 0; i < arrTransactionValue.length; i++) {
			System.out.println("Transaction : " +i+" "+arrTransactionDate[i]+ "| " + arrTransactionType[i]+ " |  "+arrTransactionDebitValue[i]+ " | " +arrTransactionCreditValue[i] + " | " +arrTransactionValue[i]);
		}

	}


	public void intelligenceDataBase(){
		objUtilities.logReporter("Click on Top Nav Customers", objWrapperFunctions.click(topNavCustomers), false);
		objUtilities.logReporter("Click on Top Intelligent database", objWrapperFunctions.click(topNavCustomers_IntelligentDataBase), false);

		objUtilities.logReporter("Select type", objWrapperFunctions.selectDropDownByIndex(topNavCustomers_IntelligentDataBase_selectStatus, 1), false);

		objUtilities.logReporter("Click on Find", objWrapperFunctions.click(topNavCustomers_Customers_buttonFind), false);
		//objUtilities.logReporter("Select Page", objWrapperFunctions.clickByScript(objWrapperFunctions.getElementOfIndex(thirdPartyAcc_FindAcc_clickDetails, 1)), false);
		objUtilities.logReporter("Select Page", objWrapperFunctions.clickByScript(thirdPartyAcc_FindAcc_clickDetails),false);
		System.out.println("Details : Surname : "+objWrapperFunctions.getAttributeValue(topNavCustomers_IntelligentDataBase_Details_Name, "value"));
		objUtilities.logReporter("Click on Address", objWrapperFunctions.clickByScript(topNavCustomers_CustomersDetails_Cust_Address), false);
		objUtilities.logReporter("Click on Audit", objWrapperFunctions.clickByScript(topNavCustomers_CustomersDetails_Cust_Audit), false);

		if(objWrapperFunctions.checkElementDisplyed(topNavCustomers_CustomersDetails_Cust_Audit_dateTime)){
			System.out.println("Audit details: "+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Cust_Audit_dateTime));
			System.out.println("Audit details: "+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Cust_Audit_propertyname));
		}


		objUtilities.logReporter("Click on identification", objWrapperFunctions.clickByScript(topNavCustomers_CustomersDetails_Cust_Identifications), false);
		if(objWrapperFunctions.checkElementDisplyed(topNavCustomers_CustomersDetails_Cust_Identification1)){
			System.out.println("Identification details: "+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Cust_Identification1));
			System.out.println("Identification details: "+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Cust_Identification2));
		}


		objUtilities.logReporter("Click on Images", objWrapperFunctions.clickByScript(topNavCustomers_CustomersDetails_Cust_images), false);
		if(objWrapperFunctions.checkElementDisplyed(topNavCustomers_CustomersDetails_Cust_images1)){

			System.out.println("Image details: "+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Cust_images1));
			System.out.println("Image details: "+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Cust_images2));
		}

		if(objWrapperFunctions.checkElementDisplyed(topNavCustomers_CustomersDetails_Cust_incidents1)){

			objUtilities.logReporter("Click on incidents", objWrapperFunctions.clickByScript(topNavCustomers_CustomersDetails_Cust_incidents), false);
			System.out.println("incidents details: "+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Cust_incidents1));
			System.out.println("incidents details: "+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Cust_incidents2));
		}
	}

	public void navigateToCustomerProfileTab(String tabOpt)
	{	
		try {
			By  custProfileTab = By.xpath("//section[@class='sidebar']//ul//li[@class='tabHeader'][@id='tab"+tabOpt+"']//a[contains(.,'"+ tabOpt +"')]");
			objUtilities.logReporter("Click on",tabOpt, objWrapperFunctions.click(custProfileTab), false);
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	By  custProfileTabNote_EditButton = By.xpath("//button[@class='btn btn-primary btn-secured'][contains(.,'Edit')]");
	
	public void verifyeditNotebutton()
	{
		objUtilities.logReporter("Click on Add Button",objWrapperFunctions.click(topNavCustomers_CustomersDetails_Addresses_NewAddress_addButton), false);	
		objUtilities.logReporter("Enter Details", objWrapperFunctions.setText(topNavCustomers_CustomersDetails_Notes_details, "Sample"), false);
		clickOnOk();
		objUtilities.logReporter("Click on edit",objWrapperFunctions.verifyIsElementPresent(custProfileTabNote_EditButton), false);	
	}
	public void editNote()
	{
	objUtilities.logReporter("Click on edit",objWrapperFunctions.click(custProfileTabNote_EditButton), false);	
	}
	
	public void clickbutton(String opt)
	{
		By  custProfileTab = By.xpath("//button[@class='btn-primary btn-secured ig-column-button'][contains(.,'"+opt +"')]");
		objUtilities.logReporter("Click on ",opt,objWrapperFunctions.doubleClick(custProfileTab), false);	
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void verifybutton(String opt)
	{
		By  custProfileTab = By.xpath("//button[@class='btn-primary btn-secured ig-column-button'][contains(.,'"+opt +"')]");
		objUtilities.logReporter("Verify ",opt,objWrapperFunctions.verifyIsElementPresent(custProfileTab), false);	
	}
	
	public void verifyCustomerProfileTab(String tabOpt)
	{	
		By  custProfileTab = By.xpath("//section[@class='sidebar']//ul//li[@class='tabHeader'][@id='tab"+tabOpt+"']//a[contains(.,'"+ tabOpt +"')]");
		objUtilities.logReporter("verify ",tabOpt, objWrapperFunctions.verifyIsElementPresent(custProfileTab), false);
	}


	public void setNoteDetails(String details)
	{
		objWrapperFunctions.click(topNavCustomers_CustomersDetails_Notes_details);
		objWrapperFunctions.clear(topNavCustomers_CustomersDetails_Notes_details);
		objUtilities.logReporter("Enter Details", 
				objWrapperFunctions.setText(topNavCustomers_CustomersDetails_Notes_details,details), false);
	}


	public void clickOnOk()
	{
		objUtilities.logReporter("Click on", objWrapperFunctions.click(customerProfileNotes_okBtn), false);	
	}
	public void addViewDeleteNote(){
		try {
			checkCustDetails();
			objUtilities.logReporter("Click on Notes", objWrapperFunctions.click(topNavCustomers_CustomersDetails_Notes), false);
			System.out.println("----Viewing Notes---");
			System.out.println("----Adding New Note---");
			objUtilities.logReporter("Click on Add ", objWrapperFunctions.click(topNavCustomers_CustomersDetails_Addresses_NewAddress_addButton), false);
			Thread.sleep(5000);
			objUtilities.logReporter("Enter Details", objWrapperFunctions.setText(topNavCustomers_CustomersDetails_Notes_details, "Sample"), false);	

			objUtilities.logReporter("Click on Save Address", objWrapperFunctions.click(topNavCustomers_CustomersDetails_Addresses_NewAddress_okButton), false);			
			Thread.sleep(5000);
		//	clickOkOrYes();

			objUtilities.logReporter("Click on Notes", objWrapperFunctions.clickByScript(topNavCustomers_CustomersDetails_Notes), false);



			System.out.println("----Viewing saved Note---");
			System.out.println("Gaming Date :"+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Notes_savedNote_GamingDate));
			System.out.println("Property :"+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Notes_savedNote_PropertyName));
			System.out.println("Details :"+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Notes_savedNote_Details));
			System.out.println("Login Name:"+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Notes_savedNote_UserLoginName));

			System.out.println("----Removing Note---");
			objUtilities.logReporter("Click on Remove Address", objWrapperFunctions.click(topNavCustomers_CustomersDetails_Addresses_DeleteButton), false);
			System.out.println("Clicked on Remove Button");
			objUtilities.logReporter("Click on Save Address", objWrapperFunctions.click(topNavCustomers_CustomersDetails_Addresses_NewAddress_saveButton), false);			
			Thread.sleep(5000);
			clickOkOrYes();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void navigateToNotesTab()
	{
		objUtilities.logReporter("Click on Notes", 
				objWrapperFunctions.click(topNavCustomers_CustomersDetails_Notes), false);
	}
	By typeDropdown = By.xpath("//select[@id='dropDownNoteType']//option[contains(.,'Customer Note')]");
	By applicationInputBox = By.xpath("//input[@id='textBoxTypeApplications']");

	public void verifyNotesTableHeaders()
	{
		By table = By.xpath("//table[@class='grid datagrid']");	
		objUtilities.logReporter("Verify applicationInputBox Displayed", 
				objWrapperFunctions.verifyTableHeaders(table,"Gaming Date","Type","Property","Details","Date Deleted","User"), false);		
	}
	public void verifyapplicationInputBoxDisplayed()
	{
		objUtilities.logReporter("Verify applicationInputBox Displayed", 
				objWrapperFunctions.verifyIsElementPresent(applicationInputBox), false);		
	}


	public void verifyTypeDropdownDisplayed()
	{
		objUtilities.logReporter("Verify Type Dropdown Displayed", 
				objWrapperFunctions.verifyIsElementPresent(typeDropdown), false);		
	}

	public String getTypeDropdownValue()
	{
		return objWrapperFunctions.getText(typeDropdown);		
	}

	public void verifyReadiButtonOnCustProfileNotesScreen(String radioOption)
	{
		//By fieldsetLabel = By.xpath("//div//label[contains(@for,'radioButtonCustomerNoteFilterType')]//span[contains(.,'"+ radioOption +"')]//following::input");
		By fieldsetLabel = By.xpath("//div[@class='form-holder']//span[text()='"+radioOption+"']");
		objUtilities.logReporter("Verify "+radioOption, 
				objWrapperFunctions.verifyIsElementPresent(fieldsetLabel), false);		
	}

	public void clickReadiButtonOnCustProfileNotesScreen(String radioOption)
	{
		By fieldsetLabel = By.xpath("//div//label[contains(@for,'radioButtonCustomerNoteFilterType')]//span[contains(.,'"+ radioOption +"')]//following::input");
		objUtilities.logReporter("Verify "+radioOption, 
				objWrapperFunctions.click(fieldsetLabel), false);		
	}

	public void verifyLabel(String lbl)
	{
		try {
			Thread.sleep(3000);		
			By fieldsetLabel = By.xpath("//fieldset//div//label[contains(.,'"+ lbl +"')]");
			objUtilities.logReporter("Verify "+lbl, 
					objWrapperFunctions.verifyIsElementPresent(fieldsetLabel), false);		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//objWrapperFunctions.verifyTableHeaders(table,"Gaming Date","Type","Property","Details","Date Deleted","User"), false);
	public void verifyEditedNoteDisplayedOnTable(String editNote)
	{
		By table = By.xpath("//table[@class='grid datagrid']");	
		
		By clubName = By.xpath("//ul[@class='list-inline']/script/following::li");
		System.out.println("club naj :" +objWrapperFunctions.getText(clubName));
		String clubNmae = objWrapperFunctions.getText(clubName);
		System.out.println("clubNmae  :" +clubNmae);
		
		objUtilities.logReporter("Verify applicationInputBox Displayed", 
				objWrapperFunctions.verifyTableContentAgainstToColumn(table,"Type","Customer Note","Property",clubNmae,"Details",editNote), false);		
	}
	
	public void viewRemoveAndAddIdentifications(){		
		try {
			checkCustDetails();
			objUtilities.logReporter("Click on Identifications", objWrapperFunctions.click(topNavCustomers_CustomersDetails_Identifications), false);
			System.out.println("----Viewing Identifications---");
			objUtilities.logReporter("Click on Add ", objWrapperFunctions.click(topNavCustomers_CustomersDetails_Addresses_NewAddress_addButton), false);
			System.out.println("Identification Type: "+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Identifications_type));
			System.out.println("Identification Reference: "+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Identifications_Reference));
			System.out.println("Identification Expiry Date: "+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Identifications_ExpiryDate));
			System.out.println("Identification Issue Date: "+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Identifications_IssueDate));	
			System.out.println("Identification Issue Details: "+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Identifications_IssueDetail));

			System.out.println("----Removing Address---");
			objUtilities.logReporter("Click on Remove Address", objWrapperFunctions.click(topNavCustomers_CustomersDetails_Addresses_RemoveButton), false);
			System.out.println("Clicked on Remove Button");
			System.out.println("----Adding New Identification---");
			objUtilities.logReporter("Click on Add ", objWrapperFunctions.click(topNavCustomers_CustomersDetails_Addresses_NewAddress_addButton), false);
			Thread.sleep(5000);

			objUtilities.logReporter("Enter Reference", objWrapperFunctions.setText(topNavCustomers_CustomersDetails_Identifications_inputReference, customerNum), false);	

			objUtilities.logReporter("Select type", objWrapperFunctions.selectDropDownByIndex(topNavCustomers_CustomersDetails_Identifications_selectType, 1), false);

			objUtilities.logReporter("Enter IssueDate", objWrapperFunctions.setText(topNavCustomers_CustomersDetails_Identifications_inputIssueDate, "30122016"), false);	

			objUtilities.logReporter("Enter Expiry Date", objWrapperFunctions.setText(topNavCustomers_CustomersDetails_Identifications_inputExpiryDate, "30122017"), false);	

			objUtilities.logReporter("Enter Details", objWrapperFunctions.setText(topNavCustomers_CustomersDetails_Identifications_inputDetails, "Sample"), false);	


			System.out.println("----Viewing New Identification---");
			System.out.println("Identification Type: "+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Identifications_type));
			System.out.println("Identification Reference: "+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Identifications_Reference));
			System.out.println("Identification Expiry Date: "+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Identifications_ExpiryDate));
			System.out.println("Identification Issue Date: "+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Identifications_IssueDate));	
			System.out.println("Identification Issue Details: "+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Identifications_IssueDetail));

			objUtilities.logReporter("Click on Save Address", objWrapperFunctions.click(topNavCustomers_CustomersDetails_Addresses_NewAddress_saveButton), false);			
			Thread.sleep(10000);
			clickOkOrYes();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	public void checkCustDetails(){


		try {
			//	customerNum =objConfig.getProperty("web.CustomerNumber");
			System.out.println("----Cutomer Profile---");
			objUtilities.logReporter("Click on Top Navigation customers", objWrapperFunctions.click(topNavCustomers), false);
			objUtilities.logReporter("Click on Top Navigation customers > Customres", objWrapperFunctions.click(topNavCustomers_Customers), false);
			//objUtilities.logReporter("Enter Customer NuMber", objWrapperFunctions.setText(topNavCustomers_Customers_inputCustNum, customerNum), false);

			objUtilities.logReporter("Click on Find", objWrapperFunctions.click(topNavCustomers_Customers_buttonFind), false);
			Thread.sleep(1000);
			System.out.println("----Cutomer Profile : Viewing Customer Details---");
			System.out.println("Primary salutation :"+objWrapperFunctions.getAttributeValue(topNavCustomers_Customers_Details_PrimarySalutations, "value") );
			System.out.println("Secondary salutation :"+objWrapperFunctions.getAttributeValue(topNavCustomers_Customers_Details_SecondarySalutations, "value") );

			System.out.println("Customer Name :"+objWrapperFunctions.getAttributeValue(topNavCustomers_Customers_Details_Name, "value") );

			System.out.println("Customer Number :"+objWrapperFunctions.getAttributeValue(topNavCustomers_Customers_Details_Number, "value") );


		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void viewRemoveAddAddress(){

		try {
			checkCustDetails();
			objUtilities.logReporter("Click on Addresses", objWrapperFunctions.click(topNavCustomers_CustomersDetails_Addresses), false);
			System.out.println("----Viewing Address---");
			System.out.println("Street :"+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Addresses_Street));
			System.out.println("City :"+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Addresses_City));
			System.out.println("Region :"+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Addresses_Region));
			System.out.println("Postcode :"+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Addresses_PostCode));
			System.out.println("Country :"+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Addresses_CountryName));

			System.out.println("----Removing Address---");
			objUtilities.logReporter("Click on Remove Address", objWrapperFunctions.click(topNavCustomers_CustomersDetails_Addresses_RemoveButton), false);
			System.out.println("Clicked on Remove Button");

			System.out.println("----Adding New Address---");
			objUtilities.logReporter("Click on Add Address", objWrapperFunctions.click(topNavCustomers_CustomersDetails_Addresses_NewAddress_addButton), false);
			Thread.sleep(5000);			
			objUtilities.logReporter("Enter Street", objWrapperFunctions.setText(topNavCustomers_CustomersDetails_Addresses_NewAddress_txtStreet, " "), false);
			objUtilities.logReporter("Enter Postcode", objWrapperFunctions.setText(topNavCustomers_CustomersDetails_Addresses_NewAddress_Postcode, "ha01sg"), false);
			objWrapperFunctions.pressTabBtn(topNavCustomers_CustomersDetails_Addresses_NewAddress_Postcode);
			//objUtilities.logReporter("Enter other details", objWrapperFunctions.setText(topNavCustomers_CustomersDetails_Addresses_NewAddress_txtStreet, ""), false);
			Thread.sleep(20000);	
			objWrapperFunctions.waitForElementPresence(topNavCustomers_CustomersDetails_Addresses_NewAddress_matchButton);
			int r = objWrapperFunctions.randomNumberBetween(12,1);

			objUtilities.logReporter("Select Page", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(topNavCustomers_CustomersDetails_Addresses_NewAddress_matchButton,r)), false);
			System.out.println("----Viewing New Address---");
			System.out.println("Street :"+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Addresses_Street));
			System.out.println("City :"+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Addresses_City));
			System.out.println("Region :"+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Addresses_Region));
			System.out.println("Postcode :"+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Addresses_PostCode));
			System.out.println("Country :"+objWrapperFunctions.getText(topNavCustomers_CustomersDetails_Addresses_CountryName));
			objUtilities.logReporter("Click on Save Address", objWrapperFunctions.click(topNavCustomers_CustomersDetails_Addresses_NewAddress_saveButton), false);			
			Thread.sleep(10000);
			clickOkOrYes();
			Thread.sleep(10000);
			objUtilities.logReporter("Click on Save Address", objWrapperFunctions.click(topNavCustomers_CustomersDetails_Addresses_NewAddress_saveButton), false);			
			Thread.sleep(10000);
			clickOkOrYes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	public void clickOkOrYes(){
		objWrapperFunctions.click(okBtn);
//		while(objWrapperFunctions.checkElementDisplyed(voidYesButton)||objWrapperFunctions.click(okBtn)){
//			//System.out.println("Closing Pop-up :"+count);
//			//	objWrapperFunctions.waitForElementPresence(voidYesButton);
//			if(objWrapperFunctions.checkElementDisplyed(voidYesButton)){
//				objWrapperFunctions.waitForElementToBeClickable(voidYesButton);
//				objWrapperFunctions.pressEnterBtn(voidYesButton);
//			}else if(objWrapperFunctions.checkElementDisplyed(okBtn)){
//				objWrapperFunctions.waitForElementToBeClickable(okBtn);
//				objWrapperFunctions.pressEnterBtn(okBtn);
//			}
//			objWrapperFunctions.waitForElementPresence(okBtn);
//		}

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
