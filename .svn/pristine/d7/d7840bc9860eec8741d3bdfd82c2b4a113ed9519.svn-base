package com.pageFactory.desktopReception;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

public class customer_RegisterAndViewDetails_PF
{
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	String message="",custNumber="";
	String NeonUser,NeonPass,env;
	ExcelIterator objExcel=new ExcelIterator();
	static String refId_FE="",custName="",forName="",date="",cardnum="", conDate="",title="",fornametxt="",cityText="",address="",countryTxt="",postcode="",emailid="",telephone="";

	public customer_RegisterAndViewDetails_PF(Pojo pojo){
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
		NeonUser=pojo.getNeonUser();
		NeonPass=pojo.geNeonPassword();	
		env=pojo.getUser2Values();
		System.out.println();
	}

	private By okBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'OK')]");
	private By customerTab=By.xpath("//li[@id='CustomerManagement_Menu']//a[contains(.,'Customers')]");

	private By cancelBtn=By.xpath("//button[@data-ig-type='Cancel']");
	private By ReportsTab=By.xpath("//li[@id='Reports_Menu']//a[contains(.,'Reports')]");
	private By repotAudit = By.xpath("//li[@id='Reports_Audit_Menu']//a");
	private By registrationTab=By.xpath("//a[@id='CustomerManagement_Registration_Menu']");
	private By customersSubTab=By.xpath("//a[@id='CustomerManagement_CustomerMaintenance_Menu']");
	private By customerName=By.xpath("//input[@name='Customer.Name']");
	private By gender=By.xpath("//input[@name='Customer.Gender']");
	private By titleDropdown=By.id("dropDownTitle");
	private By foreName=By.xpath("//input[@name='Customer.Forename']");
	private By dob=By.xpath("//div//input[@id='dateRegistrationDateOfBirth']");
	private By streetInput=By.xpath("//textarea[@name='PrimaryAddress.Street']");
	private By cityInput=By.xpath("//input[@name='PrimaryAddress.City']");
	private By countryDropdown=By.xpath("//select[@id='dropDownCountry']");
	//private By text=By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'This card has already been issued.')]");
	private By text=By.xpath("//h2[contains(text(),'Possible Match On The Intelligence Database')]");
	private By matchButton = By.cssSelector("td.text-center button.btn-primary.btn-secured");
	private By DetailsButton = By.xpath("//button[@id='buttonDetails']");
	private By custDetails=By.xpath("//div[@class='three-col']//div[2]//fieldset");
	private By postcodeInput=By.xpath("//input[@id='PrimaryAddress_PostCode']");
	private By cardNumber=By.xpath("//div//input[@id='textBoxCardNumber']");
	private By saveBtn=By.xpath("//div//button[@class='btn-primary btn-secured'][contains(.,'Save')]");	
	private By noMatchBtn=By.xpath("//div//a[@class='ersatzButton primary btn-secured'][contains(.,'No Match')]");
	private By customerNo=By.xpath("//div//input[@name='Customer.Number']");
	private By serchInput=By.xpath("//div//input[@name='Number']");	
	private By emailInput=By.xpath("//div//input[@name='Customer.EmailAddress']");
	private By telephoneInput=By.xpath("//div//input[@name='Customer.HomePhone']");
	private By telephoneInput1=By.xpath("//div//input[@name='Customer.BusinessPhone']");
	private By telephoneInput2=By.xpath("//div//input[@name='Customer.MobilePhone']");

	private By identificationType=By.xpath("//select[@name='PrimaryIdentification.TypeId']");		
	private By identificationType_Passport=By.xpath("//select[@name='PrimaryIdentification.TypeId']//option[contains(.,'Passport')]");
	private By reference=By.xpath("//input[@id='PrimaryIdentification_Reference']");
	private By details=By.xpath("//input[@id='PrimaryIdentification_IssueDetail']");
	private By IssueDate=By.xpath("//input[@id='PrimaryIdentification_IssueDate']");
	private By ExpiryDate=By.xpath("//input[@id='PrimaryIdentification_ExpiryDate']");
	private By occupation=By.xpath("//input[@id='Customer_Occupation']");
	private By findBtn=By.xpath("//div//button[@class='btn-primary buttonFind btn-secured']");
	//private By yesBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'Yes')]");
	private By yesBtn=By.xpath("//button[contains(.,'Yes')]");
	private By noBtn=By.xpath("//button[contains(.,'No')]");


	private By closeIconTab=By.xpath("//button[@accesskey='x']");
	private By cashDesKDate = By.xpath("//li[@id='cashDeskDate']");

	private By postCode_ErrorMessage = By.xpath("//div[contains(.,'Experian interface error: Lost connection to the server. Transaction timed out or server error ')]");

	private By sawIcon = By.xpath("//span[@class='ig-icon ig-icon-sm'][contains(@style,'background-image')]");
	//Registration on Neon System
	
	public void verifySAWImageDisplayOrNot()
	{
		if(objWrapperFunctions.checkElementDisplyed(sawIcon))
		{ 
			objUtilities.logReporter("SAW icon displayed on customer profile",true, false);	}
		else
		{
			objUtilities.logReporter("SAW icon does not display on customer profile",false, false);	
		}
	}
	public void registration()
	{
		try
		{	
			Thread.sleep(15000);
			System.out.println("****************** Registered User Details ******************");
			objUtilities.logReporter("Click on customer tab", objWrapperFunctions.click(customerTab), false);
			objUtilities.logReporter("Click on registartion tab", objWrapperFunctions.click(registrationTab), false);	
			custName=objWrapperFunctions.getName();
			objUtilities.logReporter("Enter username", objWrapperFunctions.setText(customerName,custName), false);
			objWrapperFunctions.pressTabBtn(customerName);
			objUtilities.logReporter("Click on customer tab", objWrapperFunctions.click(titleDropdown), false);
			objUtilities.logReporter("Click on customer tab", objWrapperFunctions.selectDropDownByRandomIndex(titleDropdown, 8,1), false);


			forName=objWrapperFunctions.getName();
			//objUtilities.logReporter("Enter forename", objWrapperFunctions.setText(foreName, "SQS"), false);
			objUtilities.logReporter("Enter forename", objWrapperFunctions.setText(foreName,forName), false);

			date=objWrapperFunctions.getRandomDate();
			conDate=objUtilities.getFormatedDate(date,"ddmmyyyy","dd/mm/yyyy");
			System.out.println("Date of Birth = " +conDate);		
//			objWrapperFunctions.waitForElementPresence(dob);
//			objWrapperFunctions.waitForElementToBeClickable(dob);
			objUtilities.logReporter("Enter DateOfBirth", objWrapperFunctions.setText(dob,conDate), false);
			Thread.sleep(300);
			objUtilities.logReporter("Enter DateOfBirth", objWrapperFunctions.setText(dob,conDate), false);
			title=objWrapperFunctions.getAttributeValue(customerName, "value");
			//System.out.println("Title ="+title);
			objUtilities.logReporter("select gender", objWrapperFunctions.click(gender), false);	
			//objUtilities.logReporter("Enter Postcode", objWrapperFunctions.setText(postcodeInput, "ha01sg"), false);
			objUtilities.logReporter("Enter Postcode", objWrapperFunctions.setText(postcodeInput, "WR53da"), false);

			postcode=objWrapperFunctions.getAttributeValue(postcodeInput,"value");
			System.out.println("postcode " +postcode);
			objWrapperFunctions.pressTabBtn(postcodeInput);
			
//			if(objWrapperFunctions.checkElementDisplyed(postCode_ErrorMessage))
//			{
//				objUtilities.logReporter(" click on ok Btn", objWrapperFunctions.click(okBtn), false);	
//				objUtilities.logReporter("Enter street", objWrapperFunctions.setText(streetInput, "Stanley Park Drive"), false);
//				objUtilities.logReporter("Enter City", objWrapperFunctions.setText( cityInput, "WEMBLEY"), false);	
//
//			}
			//objWrapperFunctions.waitForElementPresence(matchButton);
			// ha01sg
			//int r = objWrapperFunctions.randomNumberBetween(20,1);
//			else
//			{
			// WR53DA
			int r = objWrapperFunctions.randomNumberBetween(3,1);
			objUtilities.logReporter("Click on match button", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(matchButton,r)), false);	
//			}
			
			String streetAdd=objWrapperFunctions.getAttributeValue(streetInput,"value");
			cityText=objWrapperFunctions.getAttributeValue(cityInput,"value");
			countryTxt=objWrapperFunctions.getSelectedValueFromDropDown(countryDropdown);
			//System.out.println(countryTxt);		
			address= streetAdd + " " +cityText;
			System.out.println(address);


			//	objUtilities.logReporter("Click on card number", objWrapperFunctions.click(cardNumber), false);
			cardnum=objWrapperFunctions.getRandomNumber();
			System.out.println("Card Number=" +cardnum);
			objUtilities.logReporter("Enter cardNumber", objWrapperFunctions.setText(cardNumber,cardnum), false);
			//emailid=objWrapperFunctions.randomEmailAddress(custName);
			/*emailid=objWrapperFunctions.randomEmailAddress(forName,custName);
			System.out.println(emailid);
			objUtilities.logReporter("Enter emailaddress", objWrapperFunctions.setText(emailInput,emailid), false);
*/

			/*String	telephone1=objWrapperFunctions.randomTelephoneNumber();
		//String	telephone1="07700900703";
		System.out.println(telephone1);
		objUtilities.logReporter("Enter telephone", objWrapperFunctions.setText(telephoneInput,telephone1), false);*/

			/*String	telephone2=objWrapperFunctions.randomTelephoneNumber();
		//String	telephone2="07700900145";
		System.out.println(telephone2);

		objUtilities.logReporter("Enter telephone", objWrapperFunctions.setText(telephoneInput1,telephone2), false);*/

		/*	telephone=objWrapperFunctions.randomTelephoneNumber();
			//telephone="07700900768";
			System.out.println(telephone);
			objUtilities.logReporter("Enter telephone", objWrapperFunctions.setText(telephoneInput2,telephone), false);
*/
			/*	objUtilities.logReporter("Click on identificationType", objWrapperFunctions.click(identificationType), false);
		objUtilities.logReporter("Click on card number", objWrapperFunctions.click(identificationType_Passport), false);
		objUtilities.logReporter("Enter reference ", objWrapperFunctions.setText(reference,"test"), false);
		objUtilities.logReporter("Enter IssueDate", objWrapperFunctions.setText(IssueDate,"10/09/2017"), false);
		objUtilities.logReporter("Enter ExpiryDate ", objWrapperFunctions.setText(ExpiryDate,"11/10/2018"), false);*/

			//objUtilities.logReporter("Enter details", objWrapperFunctions.setText(details,"test"), false);
			objUtilities.logReporter("Enter  occupation", objWrapperFunctions.setText( occupation,"Manager"), false);

			objUtilities.logReporter("Click on Save btn", objWrapperFunctions.click(saveBtn), false);	

//			if(objWrapperFunctions.checkElementDisplyed(text))
//			{
//				System.out.println(objWrapperFunctions.getText(text));
				//objWrapperFunctions.acceptMultipleAlert(okBtn);
//				cardnum=objWrapperFunctions.getRandomNumber();
//				System.out.println("Card Number=" +cardnum);
//				objUtilities.logReporter("Enter cardNumber", objWrapperFunctions.setText(cardNumber,cardnum), false);
//				objUtilities.logReporter("Click on Save btn", objWrapperFunctions.click(saveBtn), false);	
//			}


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
				objWrapperFunctions.waitForElementPresence(yesBtn);
				objWrapperFunctions.waitForElementToBeClickable(yesBtn);
				objUtilities.logReporter(" click on yesBtn", objWrapperFunctions.click(yesBtn), false);
				//objUtilities.logReporter(" click on ok Btn", objWrapperFunctions.click(okBtn), false);
			}	

			if(objWrapperFunctions.checkElementDisplyed(cancelBtn))		
			{
				objWrapperFunctions.waitForElementPresence(cancelBtn);
				objWrapperFunctions.waitForElementToBeClickable(cancelBtn);
				objUtilities.logReporter(" click on yesBtn", objWrapperFunctions.click(cancelBtn), false);
				objUtilities.logReporter(" click on ok Btn", objWrapperFunctions.click(okBtn), false);
			}
			System.out.println("Customer registered  successfully ");
			custNumber=objWrapperFunctions.getAttributeValue(customerNo,"value");
			System.out.println("Customer Number  =" +custNumber);
			objWrapperFunctions.saveParamChanges(custNumber,custName,conDate);
			objExcel.createCustomerExcel(env,custNumber,cardnum,conDate,title,address,cityText,countryTxt,telephone,emailid,postcode);

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

	public void closeTab()
	{
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);
	}


	public void viewCustomerDetails()
	{
		objUtilities.logReporter("Click on Details Button", objWrapperFunctions.click(DetailsButton), false);
		System.out.println("*************** Customer Details **********************");
		System.out.println("Customer Name ="+title);
		System.out.println("Customer Number  =" +custNumber);
		System.out.println("Date of Birth = " +conDate);	
		System.out.println("Card Number=" +cardnum);
		System.out.println("Addres = "+ address);
		System.out.println("Country = " +countryTxt);
		objWrapperFunctions.displayAllElement(custDetails);
	}

}
