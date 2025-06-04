package com.pageFactory.CashierManagerTC;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import javax.swing.text.DefaultEditorKit.CutAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.generic.ExcelIterator;
import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class TopNavigation_PlayerTracking
{
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	String message="";
	String NeonUser,NeonPass;
	static int reqIndex=0;
	static int tempRandom,cardLastFourDigits,expiry_month,expiry_year,chequNumber ;
	static String name,lastname,nameArray[];
	static char firstChar;
	static char secondChar;
	static int creditAccNum;
	static String customerNum;
	static int selectMatch = 0;
	ExcelIterator objExcel=new ExcelIterator();
	static String refId_FE="",custName="",date="",cardnum="", conDate="",custDOB;
	//static int cardnum;

	public TopNavigation_PlayerTracking(Pojo pojo){
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
		NeonUser=pojo.getNeonUser();
		NeonPass=pojo.geNeonPassword();	
		customerNum=pojo.getUser();
		custName =pojo.getUser1Values();
		custDOB = pojo.getUserDOB();
	}

	private By userName=By.id("Username");
	private By password=By.id("Password");
	private By signBtn=By.xpath("//button[@class='btn btn-lg btn-primary btn-block ig-signin-button']");
	private By okBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'OK')]");
	private By voidYesButton = By.cssSelector("button[data-ig-type='YES']");

	private By topNavigation_PlayerTracking = By.cssSelector("li#PlayerTracking_Menu");
	private By PlayerTracking_hospitalityTransactionEntry = By.cssSelector("a#PlayerTracking_HospitalityTransactionEntry_Menu");	
	private By PlayerTracking_hospitalityTransactionEntry_newButton = By.cssSelector("button#buttonNew");	
	private By PlayerTracking_hospitalityTransactionEntry_enterCustNum = By.cssSelector("input#textBoxCustomerNumber");	
	private By PlayerTracking_hospitalityTransactionEntry_enterGamingDate = By.cssSelector("input#textBoxGamingDate");	
	//private By PlayerTracking_hospitalityTransactionEntry_selectItem = By.cssSelector("select#dropDownHospitalityItem");	
	private By PlayerTracking_hospitalityTransactionEntry_selectItem = By.cssSelector("select#dropDownHospitalityItem");
	private By PlayerTracking_hospitalityTransactionEntry_casinoPayment = By.cssSelector("input#textBoxCasinoPayment");	
	private By PlayerTracking_hospitalityTransactionEntry_selectAuthority = By.cssSelector("select#dropDownAuthorisedBy");	
	private By PlayerTracking_hospitalityTransactionEntry_saveButton = By.cssSelector("button[accesskey='s']");	

	private By PlayerTracking_hospitalityTransaction_selectDuration = By.cssSelector("select#ReportInterval_Id");	
	private By PlayerTracking_hospitalityTransaction_buttonFind = By.cssSelector("button#buttonFind");	
	private By PlayerTracking_hospitalityTransaction_buttonsDetails = By.cssSelector("td.text-center button.btn-primary.btn-secured");	
	private By PlayerTracking_hospitalityTransaction_custNumList = By.cssSelector("td[data-grid-column-key='CustomerNumber']");	

	private By PlayerTracking_hospitalityTransaction_CustName = By.xpath("//span[@id='labelFullName']");
	private By PlayerTracking_hospitalityTransaction_custDOB = By.xpath("//span[@id='labelDateOfBirth']");

	private By  PlayerTracking_hospitalityTransaction_successfullMsg = By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'This record has been saved successfully.')]");

//	private By topNavigation_Machines = By.cssSelector("li#Machines_Menu");
	private By topNavigation_Machines = By.xpath("//li[@id='Machines_Menu']//a");
	private By topNavigation_Machines_Machines = By.cssSelector("a#Machines_MachineMaintenance_Menu");
	private By Machines_Machines_buttonsDetails = By.cssSelector("td.text-center button.btn-primary.btn-secured");	
	private By Machines_Machines_Details_MachineNumber = By.cssSelector("p#labelMachineNumber");	
	private By Machines_Machines_Details_MachineDownTime = By.cssSelector("li#tabDowntimes");	
	private By Machines_Machines_Details_MachineLocation = By.cssSelector("li#tabLocations");	
	private By Machines_Machines_Details_MachineMeters = By.cssSelector("li#tabMeters");	
	private By Machines_Machines_Details_MachineReadings = By.cssSelector("li#tabReadings");	
	private By Machines_Machines_Details_MachineTransactions = By.cssSelector("li#tabTransactions");	
	private By Machines_Machines_buttonFind = By.cssSelector("button#buttonFind");
	//button[@class='btn btn-default'][contains(.,'OK')]");
	private By Machines_Machines_Details_Machine = By.xpath("//h3//*[@id='expanderMachineDetailsMachine_caret']");
	private By Machines_Machines_Details_Location = By.xpath("//h3//*[@id='expanderMachineDetailsLocation_caret']");
	private By Machines_Machines_Details_Game = By.xpath("(//h3//*[@id='expanderMachineDetailsGame_caret'])[2]");
	private By Machines_Machines_Details_Status = By.xpath("//h3//*[@id='expanderMachineDetailsStatus_caret']");
	private By Machines_Machines_Details_MoneyAcceptors = By.xpath("//h3//*[@id='expanderMachineDetailsMoneyAcceptors_caret']");
	private By Machines_Machines_Details_OtherDetails = By.xpath("//h3//*[@id='expanderMachineDetailsOther_caret']");
	private By Machines_Machines_Details_CustomFields = By.xpath("//h3[contains(.,'Custom Fields')]");
	private By cashDesKDate = By.xpath("//li[@id='cashDeskDate']");


	public void navigateToMachines()
	{
		//objWrapperFunctions.waitForElementPresence(topNavigation_Machines);
		//objWrapperFunctions.waitForElementToBeClickable(topNavigation_Machines);
		objUtilities.logReporter("Click on top nav Machines", objWrapperFunctions.clickByScript(topNavigation_Machines), false);	
	}

	public void clickOnMachines()
	{
		objWrapperFunctions.waitForElementPresence(topNavigation_Machines_Machines);
		objWrapperFunctions.waitForElementToBeClickable(topNavigation_Machines_Machines);
		objUtilities.logReporter("Click on Machines", objWrapperFunctions.clickByScript(topNavigation_Machines_Machines), false);	
	}

	public void ClickOnFind()
	{
		objWrapperFunctions.waitForElementPresence(Machines_Machines_buttonFind);
		objWrapperFunctions.waitForElementToBeClickable(Machines_Machines_buttonFind);
		objUtilities.logReporter("Click on Find", objWrapperFunctions.clickByScript(Machines_Machines_buttonFind), false);
	}
	public void viewMachineDetails()
	{

		navigateToMachines();
		clickOnMachines();	
		ClickOnFind();
		objUtilities.logReporter("Select Page", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(Machines_Machines_buttonsDetails, 0)), false);
		objUtilities.logReporter("Verify Machine label displayed",objWrapperFunctions.verifyIsElementPresent(Machines_Machines_Details_Machine), false);	
		objUtilities.logReporter("Verify Location label displayed", objWrapperFunctions.verifyIsElementPresent(Machines_Machines_Details_Location), false);		
		objUtilities.logReporter("Verify Game label displayed", objWrapperFunctions.verifyIsElementPresent(Machines_Machines_Details_Game), false);	
		objUtilities.logReporter("Verify status label displayed", objWrapperFunctions.verifyIsElementPresent(Machines_Machines_Details_Status), false);	
		objUtilities.logReporter("Verify MoneyAcceptors label displayed", objWrapperFunctions.verifyIsElementPresent(Machines_Machines_Details_MoneyAcceptors), false);	
		objUtilities.logReporter("Verify OtherDetails displayed", objWrapperFunctions.verifyIsElementPresent(Machines_Machines_Details_OtherDetails), false);	
		objUtilities.logReporter("Verify CustomFields label displayed",objWrapperFunctions.verifyIsElementPresent(Machines_Machines_Details_CustomFields), false);	
		System.out.println("Machine Number "+objWrapperFunctions.getText(Machines_Machines_Details_MachineNumber));
		System.out.println("ELement present : Down Time "+objWrapperFunctions.checkElementDisplyed(Machines_Machines_Details_MachineDownTime));
		System.out.println("ELement present : Location "+objWrapperFunctions.checkElementDisplyed(Machines_Machines_Details_MachineLocation));
		System.out.println("ELement present : Meter "+objWrapperFunctions.checkElementDisplyed(Machines_Machines_Details_MachineMeters));
		System.out.println("ELement present : Reading "+objWrapperFunctions.checkElementDisplyed(Machines_Machines_Details_MachineReadings));
		System.out.println("ELement present : Transaction "+objWrapperFunctions.checkElementDisplyed(Machines_Machines_Details_MachineTransactions));

	}



	public void viewHospitalityTransaction()
	{
		objUtilities.logReporter("Click on top nav player tracking", objWrapperFunctions.clickByScript(topNavigation_PlayerTracking), false);
		objUtilities.logReporter("Click on Hospitality transaction entry", objWrapperFunctions.clickByScript(PlayerTracking_hospitalityTransactionEntry), false);

		objUtilities.logReporter("Select Authority", objWrapperFunctions.selectDropDownByIndex(PlayerTracking_hospitalityTransaction_selectDuration, 6), false);
		objUtilities.logReporter("Click on Find", objWrapperFunctions.clickByScript(PlayerTracking_hospitalityTransaction_buttonFind), false);

		String arrBankAcc[]=objWrapperFunctions.getElementTextArray(PlayerTracking_hospitalityTransaction_custNumList);
		int index=0;

		String accNUM=customerNum;

		for (String temp2 : arrBankAcc) {
			System.out.println(temp2);

			if(temp2.equalsIgnoreCase(accNUM)){

				selectMatch=index;
				System.out.println("Required  index"+selectMatch);
				break;
			}
			index++;
		}
		System.out.println("Required "+selectMatch);
		objUtilities.logReporter("Select Page", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(PlayerTracking_hospitalityTransaction_buttonsDetails, selectMatch)), false);
		System.out.println("Viewing details for :"+accNUM);
	}

	public void hospitalityTransaction()
	{

		objUtilities.logReporter("Click on top nav player tracking", objWrapperFunctions.click(topNavigation_PlayerTracking), false);
		objUtilities.logReporter("Click on Hospitality transaction entry", objWrapperFunctions.click(PlayerTracking_hospitalityTransactionEntry), false);
		objUtilities.logReporter("Click on New Button", objWrapperFunctions.click(PlayerTracking_hospitalityTransactionEntry_newButton), false);

		objUtilities.logReporter("Enter Customer Number", objWrapperFunctions.setText(PlayerTracking_hospitalityTransactionEntry_enterCustNum, customerNum), false);
		objWrapperFunctions.pressTabBtn(PlayerTracking_hospitalityTransactionEntry_enterCustNum);

		String customerName =objWrapperFunctions.getText(PlayerTracking_hospitalityTransaction_CustName);
		String customerDOB =objWrapperFunctions.getText(PlayerTracking_hospitalityTransaction_custDOB);
		System.out.println(customerName+ "" +customerDOB);
		if(customerName.contains(custName) && customerDOB.equalsIgnoreCase(custDOB))
		{
			System.out.println("Customer Name and date of birth displayed correctly");
		}

		//	objUtilities.logReporter("Enter gaming date", objWrapperFunctions.setText(PlayerTracking_hospitalityTransactionEntry_enterGamingDate, ""), false);
		//String d = objUtilities.getCurrentDate("dd/mm/yyyy");	
		String d =objWrapperFunctions.getText(cashDesKDate);
		System.out.println("Get date from Neon Taskbar"+d);		
		objUtilities.logReporter("Enter gaming date", objWrapperFunctions.setText(PlayerTracking_hospitalityTransactionEntry_enterGamingDate,d), false);	
		//objUtilities.logReporter("Click on Item Option", objWrapperFunctions.click(PlayerTracking_hospitalityTransactionEntry_selectItem), false);
		
		int t= objWrapperFunctions.getRandBet(10, 1);
		//objWrapperFunctions.waitForElementPresence(PlayerTracking_hospitalityTransactionEntry_selectItem);
		
		objUtilities.logReporter("Enter casino payment", objWrapperFunctions.setText(PlayerTracking_hospitalityTransactionEntry_casinoPayment, "10"), false);
		objUtilities.logReporter("Select clearance type", objWrapperFunctions.selectDropDownByIndex(PlayerTracking_hospitalityTransactionEntry_selectItem, t), false);
		objUtilities.logReporter("Select Authority", objWrapperFunctions.selectDropDownByIndex(PlayerTracking_hospitalityTransactionEntry_selectAuthority, 6), false);		
		objUtilities.logReporter("Click on save", objWrapperFunctions.click(PlayerTracking_hospitalityTransactionEntry_saveButton), false);
		objWrapperFunctions.pressEnterBtn(okBtn);
		objUtilities.logReporter("Enter casino payment", objWrapperFunctions.setText(PlayerTracking_hospitalityTransactionEntry_casinoPayment, "10"), false);
		objUtilities.logReporter("Verify successfull message display", objWrapperFunctions.verifyIsElementPresent(PlayerTracking_hospitalityTransaction_successfullMsg), false);			
		clickOkOrYes();
	}



	public void clickOkOrYes(){
		while(objWrapperFunctions.checkElementDisplyed(voidYesButton)||objWrapperFunctions.checkElementDisplyed(okBtn)){
			//System.out.println("Closing Pop-up :"+count);
			//	objWrapperFunctions.waitForElementPresence(voidYesButton);
			if(objWrapperFunctions.checkElementDisplyed(voidYesButton)){
				objWrapperFunctions.pressEnterBtn(voidYesButton);
			}else if(objWrapperFunctions.checkElementDisplyed(okBtn)){
				objWrapperFunctions.pressEnterBtn(okBtn);
			}

		}

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
