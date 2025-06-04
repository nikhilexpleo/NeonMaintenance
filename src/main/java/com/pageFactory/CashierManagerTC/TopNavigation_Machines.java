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

public class TopNavigation_Machines
{
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	Properties objConfig=new Properties();
	String message="",NeonUser,NeonPass;
	static int reqIndex=0;
	static int tempRandom,cardLastFourDigits,expiry_month,expiry_year,chequNumber ;
	static String name,lastname,nameArray[];
	static char firstChar;
	static char secondChar;
	static int creditAccNum;
	static String customerNum;
	static int selectMatch = 0;
	ExcelIterator objExcel=new ExcelIterator();
	static String refId_FE="",custName="",date="",cardnum="", conDate="";
	//static int cardnum;

	public TopNavigation_Machines(Pojo pojo){
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
		NeonUser=pojo.getNeonUser();
		NeonPass=pojo.geNeonPassword();	
		customerNum=pojo.getUser();
	}

	private By okBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'OK')]");
	private By voidYesButton = By.cssSelector("button[data-ig-type='YES']");

	private By topNavigation_PlayerTracking = By.cssSelector("li#PlayerTracking_Menu");
	private By PlayerTracking_hospitalityTransactionEntry = By.cssSelector("a#PlayerTracking_HospitalityTransactionEntry_Menu");	
	private By PlayerTracking_hospitalityTransactionEntry_newButton = By.cssSelector("button#buttonNew");	
	private By PlayerTracking_hospitalityTransactionEntry_enterCustNum = By.cssSelector("input#textBoxCustomerNumber");	
	private By PlayerTracking_hospitalityTransactionEntry_enterGamingDate = By.cssSelector("input#textBoxGamingDate");	
	private By PlayerTracking_hospitalityTransactionEntry_selectItem = By.cssSelector("select#dropDownHospitalityItem");	
	private By PlayerTracking_hospitalityTransactionEntry_casinoPayment = By.cssSelector("input#textBoxCasinoPayment");	
	private By PlayerTracking_hospitalityTransactionEntry_selectAuthority = By.cssSelector("select#dropDownAuthorisedBy");	
	private By PlayerTracking_hospitalityTransactionEntry_saveButton = By.cssSelector("button[accesskey='s']");	

	private By PlayerTracking_hospitalityTransaction_selectDuration = By.cssSelector("select#ReportInterval_Id");	
	private By PlayerTracking_hospitalityTransaction_buttonFind = By.cssSelector("button#buttonFind");	
	private By PlayerTracking_hospitalityTransaction_buttonsDetails = By.cssSelector("td.text-center button.btn-primary.btn-secured");	
	private By PlayerTracking_hospitalityTransaction_custNumList = By.cssSelector("td[data-grid-column-key='CustomerNumber']");	



	public void viewHospitalityTransaction(){
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

	public void hospitalityTransaction(){

		objUtilities.logReporter("Click on top nav player tracking", objWrapperFunctions.click(topNavigation_PlayerTracking), false);
		objUtilities.logReporter("Click on Hospitality transaction entry", objWrapperFunctions.click(PlayerTracking_hospitalityTransactionEntry), false);
		objUtilities.logReporter("Click on New Button", objWrapperFunctions.click(PlayerTracking_hospitalityTransactionEntry_newButton), false);

		objUtilities.logReporter("Enter Customer Number", objWrapperFunctions.setText(PlayerTracking_hospitalityTransactionEntry_enterCustNum, customerNum), false);
		objUtilities.logReporter("Enter gaming date", objWrapperFunctions.setText(PlayerTracking_hospitalityTransactionEntry_enterGamingDate, " "), false);

		objUtilities.logReporter("Enter gaming date", objWrapperFunctions.setText(PlayerTracking_hospitalityTransactionEntry_enterGamingDate, "30052017"), false);

		int t= objWrapperFunctions.getRandBet(10, 1);
		objUtilities.logReporter("Select clearance type", objWrapperFunctions.selectDropDownByIndex(PlayerTracking_hospitalityTransactionEntry_selectItem, t), false);
		objUtilities.logReporter("Enter casino payment", objWrapperFunctions.setText(PlayerTracking_hospitalityTransactionEntry_casinoPayment, "10"), false);
		objUtilities.logReporter("Select Authority", objWrapperFunctions.selectDropDownByIndex(PlayerTracking_hospitalityTransactionEntry_selectAuthority, 6), false);

		objUtilities.logReporter("Click on save", objWrapperFunctions.click(PlayerTracking_hospitalityTransactionEntry_saveButton), false);
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
