package com.pageFactory.desktopReception;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class customerProfile_AddEditViewBarredSuspension_PF {
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	String custNumber="",user="",message="",temp="";
	static int tempRandom,expiry_days,expiry_month,expiry_year ;
	static String refId_FE="";
	
	public customerProfile_AddEditViewBarredSuspension_PF(Pojo pojo)
	{
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
		custNumber=pojo.getUser();	
	}
	
	private By customersMainTab=By.xpath("//li[@id='CustomerManagement_Menu']//a[contains(.,'Customers')]");
	private By customersTab=By.xpath("//a[@id='CustomerManagement_CustomerMaintenance_Menu']");
	private By findInputBox=By.xpath("//input[@id='Surname']");
	private By findCustomerInput = By.xpath("//input[@id='Number']");
	private By findButton=By.xpath("//button[@id='buttonFind']");
	private By headingTxt=By.xpath("//h2[@id='layoutCaption']");
	private By customerfind_Deatils;
	private By customerProfile_SuspensionsTab=By.xpath("//section[@class='sidebar']//li[@id='tabSuspensions']//a[contains(.,'Suspensions')]");
	private By table=By.xpath("//table[@class='grid datagrid']//tbody//tr");
	private By custStatus;	
	private By customerProfile_Suspensions_DetailsSection1=By.xpath("//div[@class='three-col']//div//fieldset//div");
	private By customerProfile_Suspensions_DetailsSection2=By.xpath("//div[@class='three-col']//div//fieldset[2]//div");
	private By customerProfile_Suspensions_DetailsSection3=By.xpath("//div[@class='three-col']//div//fieldset[3]//div");	
	private By customerProfile_Suspensions_AddButton=By.xpath("//button[@id='buttonAddSuspension'][contains(.,'Add')]");
	private By customerProfile_Suspensions_EditButton=By.xpath("//button[@class='btn-primary btn-secured'][contains(.,'Edit')]");
	private By customerProfile_Suspensions_Add_SuspensionType=By.xpath("//select[@id='dropDownSuspensionType']");
	private By customerProfile_Suspensions_Add_ExpiryDate=By.xpath("//input[@id='CustomerSuspension_ExpiryGamingDate']");
	private By customerProfile_Suspensions_Add_Notes=By.xpath("//textarea[@id='CustomerSuspension_Notes']");
	private By customerProfile_Suspensions_Add_Message=By.xpath("//textarea[@id='CustomerSuspension_Messages']");	
	private By customerProfile_Suspensions_Add_commit=By.xpath("//footer//button[contains(.,'Commit')]");	
	private By closeIconTab=By.xpath("//button[@accesskey='x']");
	private By okBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'OK')]");
	private By cancelBtn=By.xpath("//button[@data-ig-type='Cancel'][contains(.,'Cancel')]");
	public void navigateToCustomerTab()
	{
	
		objUtilities.logReporter("Click on Customers Menu tab", objWrapperFunctions.click(customersMainTab), false);
		objUtilities.logReporter("Click on Customers tab", objWrapperFunctions.click(customersTab), false);
	}	
		
	public void findCustomer()
	{
		objUtilities.logReporter("Enter Customer Number", objWrapperFunctions.setText(findCustomerInput,"1955155545"), false);
		objUtilities.logReporter("Click on Find button", objWrapperFunctions.click(findButton), false);
		/*int size1=objWrapperFunctions.getElementSize(table);			
			for(int i=1;i<=size1;i++)
			{
				custStatus=By.xpath("//table[@class='grid datagrid']//tbody//tr["+i+"]//td[9]");
				temp=objWrapperFunctions.getText(custStatus);
				//System.out.println(temp);
				if(temp.contains("Active")) 
			//	if(temp.contains("Suspended"))
				{	
					customerfind_Deatils=By.xpath("//table[@class='grid datagrid']//tbody//tr["+i+"]//td[10]");
					objUtilities.logReporter("Click on Customer tab", objWrapperFunctions.click(customerfind_Deatils), false);
					break;
				}		
			}*/
	}	
		
	
	
	
	public void clickSuspensionsTab()
	{
		try
		{
		Thread.sleep(3000);			
		//refId_FE=objWrapperFunctions.getText(headingTxt);
		objWrapperFunctions.scrollTab(customerProfile_SuspensionsTab);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void add_barredSuspensionToCustAccount()
	{	
		objUtilities.logReporter("Click on Add tab", objWrapperFunctions.click(customerProfile_Suspensions_AddButton), false);
		objWrapperFunctions.click(customerProfile_Suspensions_Add_SuspensionType);
		objUtilities.logReporter("Select suspension type as Suspended", objWrapperFunctions.selectDropDownByVisibleText(customerProfile_Suspensions_Add_SuspensionType,"Locally Resigned"), false);
		//objUtilities.logReporter("Select suspension type as barred", objWrapperFunctions.selectDropDownByIndex(customerProfile_Suspensions_Add_SuspensionType,1), false);			
		String date=objUtilities.getCurrentDate("ddMMyyyy");
		String convertedDate=objUtilities.modifyDaysFromDate(date,1,"ddMMyyyy");
		objUtilities.logReporter("Set Expiry date", objWrapperFunctions.setText(customerProfile_Suspensions_Add_ExpiryDate,convertedDate), false);	
		//objUtilities.logReporter("Set Expiry date", objWrapperFunctions.setText(customerProfile_Suspensions_Add_ExpiryDate,"10022018"), false);
		objUtilities.logReporter("Enter Notes", objWrapperFunctions.setText(customerProfile_Suspensions_Add_Notes,"test"), false);
		objUtilities.logReporter("Enter Message", objWrapperFunctions.setText(customerProfile_Suspensions_Add_Message,"test message"), false);		
		objUtilities.logReporter("Click on commit ", objWrapperFunctions.click(customerProfile_Suspensions_Add_commit), false);	
	}
	
	public void viewSuspensioDetails()
	{
		System.out.println("****************** Customer Details ************************");
		System.out.println(refId_FE);
		objWrapperFunctions.displayAllElement(customerProfile_Suspensions_DetailsSection1);
		//objWrapperFunctions.displayAllElement(customerProfile_Suspensions_DetailsSection2);
		//objWrapperFunctions.displayAllElement(customerProfile_Suspensions_DetailsSection3);
	}
	
	public void closeTab()
	{
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);
	}
	public void add_SuspendedSuspensionToCustAccount()
	{	
		objUtilities.logReporter("Click on Add tab", objWrapperFunctions.click(customerProfile_Suspensions_AddButton), false);
		objUtilities.logReporter("Select suspension type as barred", objWrapperFunctions.selectDropDownByIndex(customerProfile_Suspensions_Add_SuspensionType,7), false);
		String date=objUtilities.getCurrentDate("ddMMyyyy");
		String convertedDate=objUtilities.modifyDaysFromDate(date,1,"ddMMyyyy");
		System.out.println(convertedDate);
		objUtilities.logReporter("Set Expiry date", objWrapperFunctions.setText(customerProfile_Suspensions_Add_ExpiryDate,convertedDate), false);
		objUtilities.logReporter("Enter Notes", objWrapperFunctions.setText(customerProfile_Suspensions_Add_Notes,"test"), false);
		objUtilities.logReporter("Enter Message", objWrapperFunctions.setText(customerProfile_Suspensions_Add_Message,"test message"), false);		
		objUtilities.logReporter("Click on commit ", objWrapperFunctions.click(customerProfile_Suspensions_Add_commit), false);
		//System.out.println("Added Suspension type - Barred on a customer account");
	}
	
	public void editSuspension()
	{
		clickOnEdit();
		//objUtilities.logReporter("Select suspension type as barred", objWrapperFunctions.selectDropDownByIndex(customerProfile_Suspensions_Add_SuspensionType,7), false);
		//String date=objUtilities.getCurrentDate();
		//String convertedDate=objUtilities.modifyDaysFromDate(date,1,"ddMMyyyy");
		//System.out.println(convertedDate);
		//objUtilities.logReporter("Set Expiry date", objWrapperFunctions.setText(customerProfile_Suspensions_Add_ExpiryDate,convertedDate), false);
		objWrapperFunctions.clear(customerProfile_Suspensions_Add_Notes);
		objUtilities.logReporter("Enter Notes", objWrapperFunctions.setText(customerProfile_Suspensions_Add_Notes,"Test Notes"), false);
		objWrapperFunctions.clear(customerProfile_Suspensions_Add_Message);
		objUtilities.logReporter("Enter Message", objWrapperFunctions.setText(customerProfile_Suspensions_Add_Message,"TestMessage"), false);		
		objUtilities.logReporter("Click on commit ", objWrapperFunctions.click(customerProfile_Suspensions_Add_commit), false);
	}
	
	public void clickOnEdit()
	{
		objWrapperFunctions.waitForElementPresence(customerProfile_Suspensions_EditButton);
		objUtilities.logReporter("Click on Edit tab", objWrapperFunctions.click(customerProfile_Suspensions_EditButton), false);
	}
	public void clickOnOk()
	{
		
		try 
		{
			Thread.sleep(100);
			objUtilities.logReporter("Click on Ok",
					objWrapperFunctions.click(okBtn), false);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void clickOnCancel()
	{
		
		try 
		{
			Thread.sleep(100);
			objUtilities.logReporter("Click on Ok",
					objWrapperFunctions.click(cancelBtn), false);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
