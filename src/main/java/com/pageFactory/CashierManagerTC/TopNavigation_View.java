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

public class TopNavigation_View
{
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	String message="";
	String NeonUser,NeonPass;
	static int reqIndex=0;
	static int tempRandom,cardLastFourDigits,expiry_month,expiry_year,chequNumber ;
	static String name,lastname,nameArray[];
	static char firstChar;
	static char secondChar;
	static int creditAccNum;
	ExcelIterator objExcel=new ExcelIterator();
	static String refId_FE="",custName="",date="",cardnum="", conDate="";
	//static int cardnum;
	
	public TopNavigation_View(Pojo pojo){
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
	private By voidYesButton = By.cssSelector("button[data-ig-type='YES']");
	
	private By topNavigationView = By.cssSelector("li#View_Menu");
	private By view_Authorizations = By.cssSelector("a#View_ViewAuthorisations_Menu");	
	private By view_Authorizations_RecordsName = By.cssSelector("td[data-grid-column-key='Name']");	
	private By view_Authorizations_RecordsDescription= By.cssSelector("td[data-grid-column-key='Description']");	
	private By view_Authorizations_RecordsCheckBoxes= By.cssSelector("column-input[binding='item.Confirmed'] input");	
	private By view_Authorizations_RecordConfirmButton= By.cssSelector("button#buttonConfirm");	
	
	private By view_Alarms = By.cssSelector("a#View_Alarms_Menu");	
	private By view_Alarms_CategoriesDropDown = By.cssSelector("select#dropDownCategories");	
	private By view_Alarms_buttonFindAlarms = By.cssSelector("button#buttonFindAlarms");	
	private By view_Alarms_buttonReset = By.cssSelector("button#buttonReset");	
	
	private By view_Alerts = By.cssSelector("a#View_Alerts_Menu");	
	private By view_Alerts_selectDateRange = By.cssSelector("select#ReportInterval_Id");	
	
	private By view_Balance = By.cssSelector("a#View_Balance_Menu");	
	
	public void openCashDesk(){
		clickTopNavView();
		objUtilities.logReporter("Click on Balance", objWrapperFunctions.click(view_Balance), false);	
	}
	
	
	
	
	public void viewAlerts(){
		clickTopNavView();
		objUtilities.logReporter("Click on Alerts", objWrapperFunctions.click(view_Alerts), false);
		objUtilities.logReporter("Select clearance type", objWrapperFunctions.selectDropDownByIndex(view_Alerts_selectDateRange, 5), false);
		objUtilities.logReporter("Click on Find", objWrapperFunctions.click(view_Alarms_buttonFindAlarms), false);
		
	}
	public void viewAlarms(){
		
		clickTopNavView();
		objUtilities.logReporter("Click on Alarms", objWrapperFunctions.click(view_Alarms), false);
		objUtilities.logReporter("Select clearance type", objWrapperFunctions.selectDropDownByIndex(view_Alarms_CategoriesDropDown, 1), false);
		objUtilities.logReporter("Click on Find", objWrapperFunctions.click(view_Alarms_buttonFindAlarms), false);
		objUtilities.logReporter("Click on Reset", objWrapperFunctions.click(view_Alarms_buttonReset), false);
		objUtilities.logReporter("Select clearance type", objWrapperFunctions.selectDropDownByIndex(view_Alarms_CategoriesDropDown, 2), false);
		objUtilities.logReporter("Click on Find", objWrapperFunctions.click(view_Alarms_buttonFindAlarms), false);
		objUtilities.logReporter("Click on Reset", objWrapperFunctions.click(view_Alarms_buttonReset), false);
		
	}
	
	
	public void viewAndConfirmAuthorizations(){
		clickTopNavView();
		click_View_Authorizations();
		String arrNames[]=objWrapperFunctions.getElementTextArray(view_Authorizations_RecordsName);
		System.out.println("Viewing records for Names");
		for (String string : arrNames) {
			System.out.println(string);
		}
		
		
		System.out.println("Viewing records for Descriptions ");
		String arrDesc[]=objWrapperFunctions.getElementTextArray(view_Authorizations_RecordsDescription);
		System.out.println("Viewing records for ");
		for (String string : arrDesc) {
			System.out.println(string);
		}
		
		objUtilities.logReporter("Select record to confirm", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(view_Authorizations_RecordsCheckBoxes, 0)), false);
		objUtilities.logReporter("Click on Confirm", objWrapperFunctions.click(view_Authorizations_RecordConfirmButton), false);
		clickOkOrYes();
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
	
	public void click_View_Authorizations(){
		
		objUtilities.logReporter("Click on Authorization", objWrapperFunctions.click(view_Authorizations), false);
		System.out.println("Click on Authorization");
		
	}
	
	
	
	public void clickTopNavView(){
		
		objUtilities.logReporter("Click on Top Navigation Cash Desk", objWrapperFunctions.click(topNavigationView), false);
		System.out.println("Click on Top Navigation View");
		
	}

	public void login()
	{
		try
		{	
		objUtilities.logReporter("Enter username", objWrapperFunctions.setText(userName, NeonUser), false);
		objUtilities.logReporter("Enter password", objWrapperFunctions.setText(password,NeonPass), false);
		objUtilities.logReporter("Click on signBtn", objWrapperFunctions.click(signBtn), false);
		System.out.println("Logged In Successfully");
		Thread.sleep(20000);
		objWrapperFunctions.waitForElementPresence(okBtn);
		objWrapperFunctions.acceptMultipleAlert(okBtn);
		
		//objWrapperFunctions.pressEnterBtn(okBtn);
		//objWrapperFunctions.pressEnterBtn(okBtn);
		Thread.sleep(2000);
		
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//objExcel.createCustomerExcel(refId_FE, cardnum, date);
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
