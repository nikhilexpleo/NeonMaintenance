package com.pageFactory.desktopReception;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.generic.ExcelIterator;
import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class registerSuspendedCustomer_PF {

	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	String message="",custNumber="";
	String NeonUser,NeonPass;
	ExcelIterator objExcel=new ExcelIterator();
	static String refId_FE="",custName="",date="",cardnum="", conDate="" ;
	
	public registerSuspendedCustomer_PF(Pojo pojo){
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
	//	custNumber=pojo.getUser();
		NeonUser=pojo.getNeonUser();
		NeonPass=pojo.geNeonPassword();	
	}
	
	private By okBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'OK')]");
	private By customerTab=By.xpath("//li[@id='CustomerManagement_Menu']//a[contains(.,'Customers')]");
	private By registrationTab=By.xpath("//a[@id='CustomerManagement_Registration_Menu']");
	private By customersSubTab=By.xpath("//a[@id='CustomerManagement_CustomerMaintenance_Menu']");
	private By customerName=By.xpath("//input[@name='Customer.Name']");
	private By gender=By.xpath("//input[@name='Customer.Gender']");
	private By titleDropdown=By.id("dropDownTitle");
	private By foreName=By.xpath("//input[@name='Customer.Forename']");
	private By dob=By.xpath("//div[@class='bootstrap-calendar calendar-container']//div//input");
	private By streetInput=By.xpath("//textarea[@name='PrimaryAddress.Street']");
	private By cityInput=By.xpath("//input[@name='PrimaryAddress.City']");
	private By cardNumber=By.xpath("//div//input[@id='textBoxCardNumber']");
	private By saveBtn=By.xpath("//div//button[@class='btn-primary btn-secured'][contains(.,'Save')]");	
	private By noMatchBtn=By.xpath("//div//a[@class='ersatzButton primary btn-secured'][contains(.,'No Match')]");
	private By customerNo=By.xpath("//div//input[@name='Customer.Number']");
	
	private By yesBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'Yes')]");
	
	
	public void registerSuspendedCust()
	{
		try
		{	
		Thread.sleep(2000);
		System.out.println("****************** Registered User Details ******************");
		objUtilities.logReporter("Click on customer tab", objWrapperFunctions.click(customerTab), false);
		objUtilities.logReporter("Click on registartion tab", objWrapperFunctions.click(registrationTab), false);	
		
		objUtilities.logReporter("Enter username", objWrapperFunctions.setText(customerName,"Auto1eg"), false);
		objWrapperFunctions.pressTabBtn(customerName);
		
		objUtilities.logReporter("Click on customer tab", objWrapperFunctions.click(titleDropdown), false);	
		objUtilities.logReporter("Click on customer tab", objWrapperFunctions.selectDropDownByIndex(titleDropdown,6), false);	
		objUtilities.logReporter("Enter forename", objWrapperFunctions.setText(foreName, "SQS"), false);
		
		custName=objWrapperFunctions.getText(customerName);
		System.out.println("Customer Name : " +custName);
		//date=objWrapperFunctions.getRandomDate();
		//conDate=objUtilities.getFormatedDate(date,"ddmmyyyy","dd/mm/yyyy");
	//	System.out.println("Date of Birth = " +conDate);
		objUtilities.logReporter("Enter DateOfBirth", objWrapperFunctions.setText(dob,"16091971"), false);
		objUtilities.logReporter("select gender", objWrapperFunctions.click(gender), false);	
		objUtilities.logReporter("Enter street", objWrapperFunctions.setText(streetInput, "Stanley Park Drive"), false);
		objUtilities.logReporter("Enter City", objWrapperFunctions.setText( cityInput, "WEMBLEY"), false);	
		objUtilities.logReporter("Click on card number", objWrapperFunctions.click(cardNumber), false);
	//	cardnum=objWrapperFunctions.getRandomNumber();
	//	System.out.println("Card Number=" +cardnum);
		objUtilities.logReporter("Enter street", objWrapperFunctions.setText(cardNumber,"2864424"), false);
		objUtilities.logReporter("Click on Save btn", objWrapperFunctions.click(saveBtn), false);	
		if(objWrapperFunctions.checkElementDisplyed(noMatchBtn))
		{
			objUtilities.logReporter(" click on No Match Btn", objWrapperFunctions.click(noMatchBtn), false);
			Thread.sleep(10000);
			if(objWrapperFunctions.checkElementDisplyed(noMatchBtn))
			{
			objUtilities.logReporter(" click on No Match Btn", objWrapperFunctions.doubleClick(noMatchBtn), false);
			}
		}
		
		if(objWrapperFunctions.checkElementDisplyed(yesBtn))
		{
			objUtilities.logReporter(" click on yesBtn", objWrapperFunctions.click(yesBtn), false);
			objUtilities.logReporter(" click on ok Btn", objWrapperFunctions.click(okBtn), false);
		}	
		
		 System.out.println("Customer registered  successfully ");
		 custNumber=objWrapperFunctions.getAttributeValue(customerNo,"value");
		 System.out.println("Customer Number  =" +custNumber);
		// objWrapperFunctions.saveParamChanges(custNumber,custName);
		// objExcel.createCustomerExcel(custNumber,cardnum,conDate);
		 
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
