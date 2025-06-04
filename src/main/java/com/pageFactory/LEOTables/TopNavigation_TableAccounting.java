package com.pageFactory.LEOTables;

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

public class TopNavigation_TableAccounting
{
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	String message="",devicesName ="SQS iPad Air";
	String NeonUser,NeonPass;
	static int reqIndex=0;
	static int tempRandom,cardLastFourDigits,expiry_month,expiry_year ;
	static String name,lastname,nameArray[];
	static char firstChar;
	static char secondChar;
	static int creditAccNum;
	static String customerNum;
	static String refId_FE="",custName="",date="",cardnum="", conDate="",gamingTableValue ;
	//static int cardnum;



	public TopNavigation_TableAccounting(Pojo pojo){
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


	private By topNavigationTableAccounting = By.cssSelector("li#TableAccounting_Menu");
	private By tableAccounting_Tables = By.cssSelector("a#TableAccounting_Tables_Menu");	
	private By tableAccounting_Tables_CreateNewButton = By.cssSelector("button#buttonNew");

	private By tableAccounting_CreateTable_InputName = By.cssSelector("input#textBoxName");
	private By tableAccounting_CreateTable_selectTableType = By.cssSelector("select#dropDownTableType");
	private By tableAccounting_CreateTable_selectGamingPITId = By.cssSelector("select#GamingTable_PitId");
	private By tableAccounting_CreateTable_selectCashDesk = By.cssSelector("select#GamingTable_CashDeskId");
	private By tableAccounting_CreateTable_selectProgressiveId = By.cssSelector("select#GamingTable_CashDeskId");
	private By tableAccounting_CreateTable_inputDate = By.cssSelector("input#GamingTable_GamingDateInstalled");
	private By tableAccounting_CreateTable_SaveButton = By.cssSelector("button[accesskey='s']");


	private By tableAccounting_AssignEmployeeToTable = By.cssSelector("a#TableAccounting_AddEmployeeOnTable_Menu");	
	private By AssignEmployeeToTable_selectTable = By.cssSelector("select#dropDownGamingTable");	
	private By AssignEmployeeToTable_selectEmployee = By.cssSelector("select#dropDownEmployees");	
	private By AssignEmployeeToTable_selectRole = By.cssSelector("select#dropDownRoles");	

	private By tableAccounting_addPlayerToTable = By.cssSelector("a#TableAccounting_AddPlayerOnTable_Menu");	
	private By tableAccounting_inputCustomerNum = By.cssSelector("input#textBoxCustomerNumber");	
	private By addPlayerToTable_selectTable = By.cssSelector("select#dropDownGamingTable");	
	private By addPlayerToTable_inputPosition = By.cssSelector("input#textBoxTablePosition");	


	private By topNav_Customers = By.cssSelector("li#CustomerManagement_Menu");	
	private By topNav_Customers_Reception = By.cssSelector("a#CustomerManagement_Reception_Menu");	
	private By topNav_Customers_Reception_inputCustNum = By.cssSelector("input#textBoxSearch");	

	private By tableAccounting_tableCredit = By.cssSelector("a#TableAccounting_TableCredit_Menu");

	private By tableAccounting_tablefill = By.cssSelector("a#TableAccounting_TableFill_Menu");	

	private By tableAccounting_tablefill_selectTable = By.cssSelector("select#dropDownGamingTable");	
	private By tableAccounting_tablefill_selectAsset = By.cssSelector("input[name='item[10].Quantity']");	
	private By tableAccounting_tablefill_selectAsset1 = By.cssSelector("input[name='item[4].Quantity']");	
	private By tableAccounting_tablefill_comment = By.cssSelector("textarea#Comment");	
	private By closeIconTab=By.xpath("//button[@accesskey='x']");

	private By processCompleteMsg=By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'Process Transaction: ')]");

	private By totalQuantity=By.xpath("//span[@data-ig-format='Currency']");
	private By totalValue=By.xpath("//span[@data-ig-format='Decimal']");

	private By TableAccounting_tableDevices = By.xpath("//a[@data-ig-key='TableAccounting_TableDevices_Menu']");
	private By TableAccounting_tableDevices_findBtn = By.xpath("//button[@id='buttonFind']");
	private By TableAccounting_tableDevices_FindDevicesByName =By.cssSelector("td[data-grid-column-key='Name']");
	private By TableAccounting_tableDevices_FindDevices_clickDetails = By.cssSelector("td.text-center button.btn-primary.btn-secured");
	private By TableAccounting_tableDevices_tableName =By.cssSelector("td[data-grid-column-key='GamingTableName']");
	private By TableAccounting_tableDevices_actionBtn =By.xpath("//button[@class='dropdown-toggle']");
	private By TableAccounting_tableDevices_action_Addtable = By.xpath("//a[@data-ig-securedid='buttonAddTable']");
	private By TableAccounting_tableDevices_action_removetable = By.xpath("//a[@data-ig-securedid='buttonRemoveTable']");
	private By TableAccounting_tableDevices_SelectGamingTable = By.xpath("//select[@id='SelectedGamingTableId']");
	private By okButton=By.xpath("//button[@data-ig-type='OK']");
	private By TableAccounting_tableDevices_Name=By.xpath("//label[contains(.,'Name')]//following-sibling::span");
	private By TableAccounting_tableDevices_devices=By.xpath("//label[contains(.,'Device')]//following-sibling::span");
	private By pageTitle = By.xpath("//h2[@id='layoutCaption']");
	private  By confirmMessage = By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'This record has been saved successfully.')]");




	public void NavigateToTableAccountingTab()
	{
		objUtilities.logReporter("Click on Top navigation Table Accounting", objWrapperFunctions.click(topNavigationTableAccounting), false);
	}

	public void clickOnTabeleCreadit()
	{
		objUtilities.logReporter("Click on Top navigation Table Credit", objWrapperFunctions.click(tableAccounting_tableCredit), false);
	}

	public void clickOnTableFill()
	{
		objUtilities.logReporter("Click on Top navigation Table fill", objWrapperFunctions.click(tableAccounting_tablefill), false);	
	}

	public void tableAddAndRemoveAsset()
	{
		objUtilities.logReporter("Select  table", objWrapperFunctions.selectDropDownByIndex(tableAccounting_tablefill_selectTable, 1), false);
		
		String g = objWrapperFunctions.getText(tableAccounting_tablefill_selectTable);
		System.out.println("SDFsdf sd =" +g);
		if(objWrapperFunctions.checkElementDisplyed(tableAccounting_tablefill_selectAsset))
		{
			objUtilities.logReporter("Select Asset", objWrapperFunctions.setText(tableAccounting_tablefill_selectAsset,"1"), false);
		}
		else
		{
			objUtilities.logReporter("Select Asset", objWrapperFunctions.setText(tableAccounting_tablefill_selectAsset1,"1"), false);
		}
		objUtilities.logReporter("Enter Comment", objWrapperFunctions.setText(tableAccounting_tablefill_comment, "Test Purpose"), false);

		String qty = objWrapperFunctions.getText(totalQuantity);
		String value = objWrapperFunctions.getText(totalValue);
		System.out.println("Total Value  = " +qty);
		System.out.println("Total Quantity = "+value);
		objUtilities.logReporter("Click on save", objWrapperFunctions.click(tableAccounting_CreateTable_SaveButton), false);
		String msg = objWrapperFunctions.getText(processCompleteMsg);
		if(objWrapperFunctions.checkElementDisplyed(processCompleteMsg))
		{
			System.out.println(msg);
		}
		clickOkOrYes();
		clickOkOrYes();
	}

	public void CloseTab()
	{
		objWrapperFunctions.waitForElementToBeClickable(closeIconTab);
		objUtilities.logReporter("Click on 'x' ", objWrapperFunctions.click(closeIconTab), false);		
	}
	public void registerVisitInPIT(){
		objUtilities.logReporter("Click on Top navigation Customers", objWrapperFunctions.click(topNav_Customers), false);
		objUtilities.logReporter("Click on Receptions", objWrapperFunctions.click(topNav_Customers_Reception), false);	

		objUtilities.logReporter("Enter customer number", objWrapperFunctions.setText(topNav_Customers_Reception_inputCustNum, customerNum), false);
		objUtilities.logReporter("Click on save", objWrapperFunctions.click(tableAccounting_CreateTable_SaveButton), false);
		clickOkOrYes();

	}

	public void addPlayerToTable(){
		objUtilities.logReporter("Click on Top navigation Table Accounting", objWrapperFunctions.click(topNavigationTableAccounting), false);
		objUtilities.logReporter("Click on Add player to table", objWrapperFunctions.click(tableAccounting_addPlayerToTable), false);	
		objUtilities.logReporter("Enter customer number", objWrapperFunctions.setText(tableAccounting_inputCustomerNum, customerNum), false);
		objUtilities.logReporter("Select  table", objWrapperFunctions.selectDropDownByIndex(addPlayerToTable_selectTable, 1), false);

		objUtilities.logReporter("Enter Position", objWrapperFunctions.setText(addPlayerToTable_inputPosition, "2"), false);

		objUtilities.logReporter("Click on save", objWrapperFunctions.click(tableAccounting_CreateTable_SaveButton), false);
		clickOkOrYes();

	}

	public void assignEmployeeToTable(){
		objUtilities.logReporter("Click on Top navigation Table Accounting", objWrapperFunctions.click(topNavigationTableAccounting), false);
		objUtilities.logReporter("Click on assign employee to table", objWrapperFunctions.click(tableAccounting_AssignEmployeeToTable), false);
		int t= objWrapperFunctions.getRandBet(10, 1);

		objUtilities.logReporter("Select  table", objWrapperFunctions.selectDropDownByIndex(AssignEmployeeToTable_selectTable, t), false);
		objUtilities.logReporter("Select  employee", objWrapperFunctions.selectDropDownByIndex(AssignEmployeeToTable_selectEmployee, 7), false);

		objUtilities.logReporter("Select  role", objWrapperFunctions.selectDropDownByIndex(AssignEmployeeToTable_selectRole, 1), false);
		objUtilities.logReporter("Click on save", objWrapperFunctions.click(tableAccounting_CreateTable_SaveButton), false);
		clickOkOrYes();
		clickOkOrYes();

	}

	public void createTable(){
		objUtilities.logReporter("Click on Top navigation Table Accounting", objWrapperFunctions.click(topNavigationTableAccounting), false);
		objUtilities.logReporter("Click on Top navigation Tables", objWrapperFunctions.click(tableAccounting_Tables), false);
		objUtilities.logReporter("Click on New", objWrapperFunctions.click(tableAccounting_Tables_CreateNewButton), false);

		int t= objWrapperFunctions.getRandBet(100, 10);
		objUtilities.logReporter("Enter Table name", objWrapperFunctions.setText(tableAccounting_CreateTable_InputName, "TestTable"+t), false);

		objUtilities.logReporter("Select  type", objWrapperFunctions.selectDropDownByIndex(tableAccounting_CreateTable_selectTableType, 2), false);

		objUtilities.logReporter("Select  type", objWrapperFunctions.selectDropDownByIndex(tableAccounting_CreateTable_selectGamingPITId, 2), false);
		objUtilities.logReporter("Select  type", objWrapperFunctions.selectDropDownByIndex(tableAccounting_CreateTable_selectCashDesk, 2), false);
		objUtilities.logReporter("Select  type", objWrapperFunctions.selectDropDownByIndex(tableAccounting_CreateTable_selectProgressiveId, 2), false);
		objUtilities.logReporter("Enter Date", objWrapperFunctions.setText(tableAccounting_CreateTable_inputDate, "05062016"), false);
		objUtilities.logReporter("Click on save", objWrapperFunctions.click(tableAccounting_CreateTable_SaveButton), false);
		clickOkOrYes();
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


	public void navigateToTableDevice()
	{
		objWrapperFunctions.waitForElementPresence(TableAccounting_tableDevices);
		objWrapperFunctions.waitForElementToBeClickable(TableAccounting_tableDevices);
		objUtilities.logReporter("Click on tableDevices", objWrapperFunctions.click(TableAccounting_tableDevices), false);
	}

	public void pageTitle()
	{

		objWrapperFunctions.waitForElementPresence(pageTitle);
		objUtilities.logReporter("verify page title details", objWrapperFunctions.verifyIsElementPresent(pageTitle), false);
		System.out.println("Page title =" +objWrapperFunctions.getText(pageTitle));
	}

	public void clickOnFind()
	{
		objWrapperFunctions.waitForElementToBeClickable(TableAccounting_tableDevices_findBtn);
		objUtilities.logReporter("Click on findBtn ", objWrapperFunctions.click(TableAccounting_tableDevices_findBtn), false);
	}

	public void SelectDeviceNVerifyDetials()
	{
		selectDevice(TableAccounting_tableDevices_FindDevicesByName,TableAccounting_tableDevices_FindDevices_clickDetails,devicesName);
		verifyNGetDeviceDetails();
		verifyNGetDeviceNameDetails();
	}

	
	
	public void verifyNGetDeviceDetails()
	{
		objWrapperFunctions.waitForElementPresence(TableAccounting_tableDevices_devices);
		objUtilities.logReporter("verify device details", objWrapperFunctions.verifyIsElementPresent(TableAccounting_tableDevices_devices), false);

		String deviceNm = objWrapperFunctions.getText(TableAccounting_tableDevices_devices);

		if(deviceNm.contentEquals(devicesName))
		{
			System.out.println("Device Name display correctly");
		}
	}

	public void verifyNGetDeviceNameDetails()
	{
		objWrapperFunctions.waitForElementPresence(TableAccounting_tableDevices_Name);
		objUtilities.logReporter("verify device name details", objWrapperFunctions.verifyIsElementPresent(TableAccounting_tableDevices_Name), false);

		String deviceFriendlyName = objWrapperFunctions.getText(TableAccounting_tableDevices_Name);

		if(deviceFriendlyName.contentEquals(devicesName))
		{
			System.out.println("Device Friendly Name display correctly");
		}
	}


	public void clickOnActionButton()
	{
		objWrapperFunctions.waitForElementPresence(TableAccounting_tableDevices_Name);
		objUtilities.logReporter("verify action Btn", objWrapperFunctions.verifyIsElementPresent(TableAccounting_tableDevices_actionBtn), false);
		objUtilities.logReporter("verify action Btn", objWrapperFunctions.click(TableAccounting_tableDevices_actionBtn), false);
	}


	public void verifyAddTableButton()
	{
		objWrapperFunctions.waitForElementPresence(TableAccounting_tableDevices_action_Addtable);
		objUtilities.logReporter("verify Add table button", objWrapperFunctions.verifyIsElementPresent(TableAccounting_tableDevices_action_Addtable), false);
	}

	public void ClickAddTableButton()
	{
		objWrapperFunctions.waitForElementToBeClickable(TableAccounting_tableDevices_action_Addtable);
		objUtilities.logReporter("Click on Add table button", objWrapperFunctions.click(TableAccounting_tableDevices_action_Addtable), false);
	}

	public void verifyRemoveTableButton()
	{
		objWrapperFunctions.waitForElementPresence(TableAccounting_tableDevices_action_removetable);
		objUtilities.logReporter("verify Add table button", objWrapperFunctions.verifyIsElementPresent(TableAccounting_tableDevices_action_removetable), false);
	}

	public void clickOnRemoveTableButton()
	{
		objWrapperFunctions.waitForElementToBeClickable(TableAccounting_tableDevices_action_removetable);
		objUtilities.logReporter("Click on Remove table button", objWrapperFunctions.click(TableAccounting_tableDevices_action_removetable), false);
	}
	public void selectTableFromList()
	{
		objWrapperFunctions.waitForElementPresence(TableAccounting_tableDevices_SelectGamingTable);
		gamingTableValue = objWrapperFunctions.getSelectedValueFromDropDown(TableAccounting_tableDevices_SelectGamingTable);
		System.out.println("Selected table : " +gamingTableValue);
	}


	public void clickONOkButton()
	{
		objWrapperFunctions.waitForElementToBeClickable(okButton);
		objUtilities.logReporter("Click on Ok button", objWrapperFunctions.click(okButton), false);
	}


	public void verifySelectedElementDisplayed(By locator,String devicesName)
	{

		String arrDevices[]=objWrapperFunctions.getElementTextArray(locator);
		int index=0;
		for (String temp : arrDevices) 
		{
			System.out.println("temp gg=" +temp);

			if(temp.equalsIgnoreCase(devicesName))
			{
				System.out.println("Selected Table display in List");
				break;
			}
			index++;
		}
	}
	public void selectDevice(By locator,By locator1,String DeviceName)
	{
		String arrDevices[]=objWrapperFunctions.getElementTextArray(locator);
		int index=0;
		for (String temp : arrDevices) 
		{
			System.out.println("temp gg=" +temp);

			if(temp.equalsIgnoreCase(DeviceName))
			{
				reqIndex=index;
				objUtilities.logReporter("verify details ",objWrapperFunctions.checkElementDisplyed(locator1), false);		
				objUtilities.logReporter("Select Page", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(locator1,reqIndex)), false);
				break;
			}
			index++;
		}
	}


	public void verifyConfirmMessage()
	{
		objWrapperFunctions.waitForElementPresence(confirmMessage);
		objUtilities.logReporter("verify Add table button", objWrapperFunctions.verifyIsElementPresent(confirmMessage), false);
	}
	public void clickOnSaveBtn()
	{
		objWrapperFunctions.waitForElementToBeClickable(tableAccounting_CreateTable_SaveButton);
		objUtilities.logReporter("Click on Save button", objWrapperFunctions.click(tableAccounting_CreateTable_SaveButton), false);
	}
}
