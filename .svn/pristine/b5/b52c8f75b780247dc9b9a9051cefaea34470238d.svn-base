package com.pageFactory.LEOTables;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class TableDevice_PF {

	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	Properties objConfig=new Properties();
	String message="";
	String devicesName ="SQSiPad4G2";
	//devicesName ="SQSiPad4G2"
	//String devicesName ="SQS iPad Air" ;
	static int reqIndex=0;
	static String refId_FE="",custName="",date="",cardnum="", conDate="",gamingTableValue,DefaultSelectedDevicesName ;

	public TableDevice_PF(Pojo pojo)
	{
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
	}

	private By topNavigationTableAccounting = By.cssSelector("li#TableAccounting_Menu");
	private By TableAccounting_tableDevices = By.xpath("//a[@data-ig-key='TableAccounting_TableDevices_Menu']");
	private By TableAccounting_tableDevices_findBtn = By.xpath("//button[@id='buttonFind']");
	private By TableAccounting_tableDevices_FindDevicesByName =By.cssSelector("td[data-grid-column-key='Name']");
	//private By TableAccounting_tableDevices_FindDevices_clickDetails = By.cssSelector("td.text-center button.btn-primary.btn-secured");
	private By TableAccounting_tableDevices_FindDevices_clickDetails = By.xpath("//button[@class='btn btn-primary btn-secured'])[1]");
	private By TableAccounting_tableDevices_tableName =By.cssSelector("td[data-grid-column-key='GamingTableName']");
	private By TableAccounting_tableDevices_actionBtn =By.xpath("//button[@class='dropdown-toggle']");
	private By TableAccounting_tableDevices_action_Addtable = By.xpath("//a[@data-ig-securedid='buttonAddTable']");
	private By TableAccounting_tableDevices_action_removetable = By.xpath("//a[@data-ig-securedid='buttonRemoveTable']");
	private By TableAccounting_tableDevices_SelectGamingTable = By.xpath("//select[@id='SelectedGamingTableId']");
	private By okButton=By.xpath("//button[@data-ig-type='OK']");
	private By TableAccounting_tableDevices_Name=By.xpath("//label[contains(.,'Name')]//following-sibling::span");
	//private By TableAccounting_tableDevices_devices=By.xpath("//label[contains(.,'Device')]//following-sibling::span");
	private By TableAccounting_tableDevices_devices=By.xpath("//span[text()='TestPad1']");
	private By pageTitle = By.xpath("//h2[@id='layoutCaption']");
	private  By confirmMessage = By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'This record has been saved successfully.')]");
	private By tableAccounting_CreateTable_SaveButton = By.cssSelector("button[accesskey='s']");
	private By tableDeviceDetail = By.xpath("//tr[1]//td[@data-grid-column-key='GamingTableName']//span");

	public void NavigateToTableAccountingTab()
	{
		objUtilities.logReporter("Click on Top navigation Table Accounting", objWrapperFunctions.click(topNavigationTableAccounting), false);
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

	 
	public void selectDevice()
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

	public void addTable()
	{
		clickOnActionButton();
		verifyAddTableButton();
		ClickAddTableButton();
		selectTableFromList();
		clickONOkButton();
		clickOnSaveBtn();
		verifyConfirmMessage();
		clickONOkButton();
		verifySelectedElementDisplayed(TableAccounting_tableDevices_tableName,gamingTableValue);
	}

	public void removeTable()
	{
		
		getDefaultSelectedDevicesName();	
		clickOnActionButton();
		verifyRemoveTableButton();
		clickOnRemoveTableButton();	
		verifyDeletedTableNotDisplayed(TableAccounting_tableDevices_tableName,DefaultSelectedDevicesName);
	}
	
	public void getDefaultSelectedDevicesName()
	{
		DefaultSelectedDevicesName = objWrapperFunctions.getText(tableDeviceDetail);
		System.out.println(" DefaultSelectedDevicesName =" + DefaultSelectedDevicesName);
	}
	
	public void verifyDeletedTableNotDisplayed(By locator,String devicesName)
	{
		String arrDevices[]=objWrapperFunctions.getElementTextArray(locator);
		int index=0;
		for (String temp : arrDevices) 
		{
			System.out.println("Default Selected Devices Name = " +temp);

			if(temp.equalsIgnoreCase(DefaultSelectedDevicesName)==false)
			{
				System.out.println("Deleted table does not display in List");
				break;
			}
			index++;
		}
	}
	public void verifySelectedElementDisplayed(By locator,String devicesName)
	{
		objWrapperFunctions.waitForElementPresence(locator);
		String arrDevices[]=objWrapperFunctions.getElementTextArray(locator);
		int index=0;
		for (String temp : arrDevices) 
		{
			System.out.println("Table Name = " +temp);

			if(temp.equalsIgnoreCase(gamingTableValue))
			{
				System.out.println("Selected Table display in List");
				break;
			}
			index++;
		}
	}

	public void selectDevice(By locator,By locator1,String DeviceName)
	{
		objWrapperFunctions.waitForElementPresence(locator);
		String arrDevices[]=objWrapperFunctions.getElementTextArray(locator);
		int index=0;
		for (String temp : arrDevices) 
		{
			System.out.println("Device Name : " +temp);

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
		//objUtilities.logReporter("verify Add table button", objWrapperFunctions.verifyIsElementPresent(confirmMessage), false);
	
	}
	public void clickOnSaveBtn()
	{
		objWrapperFunctions.waitForElementToBeClickable(tableAccounting_CreateTable_SaveButton);
		objUtilities.logReporter("Click on Save button", objWrapperFunctions.click(tableAccounting_CreateTable_SaveButton), false);
	}

}
