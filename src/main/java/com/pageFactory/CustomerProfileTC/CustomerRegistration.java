package com.pageFactory.CustomerProfileTC;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.generic.ExcelIterator;
import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class CustomerRegistration 
{
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	Properties objConfig=new Properties();
	String message="",custNumber="";
	static String cardnum="";
	static int reqIndex=0;

	public CustomerRegistration(Pojo pojo)
	{
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
	}

	private By okBtn=By.xpath("//button[@data-ig-type='OK']");
	private By customerTab=By.xpath("//li[@id='CustomerManagement_Menu']//a[contains(.,'Customers')]");

	private By ReportsTab=By.xpath("//li[@id='Reports_Menu']//a[contains(.,'Reports')]");
	private By repotAudit = By.xpath("//li[@id='Reports_Audit_Menu']//a");
	private By registrationTab=By.xpath("//a[@id='CustomerManagement_Registration_Menu']");
	private By customersSubTab=By.xpath("//a[@id='CustomerManagement_CustomerMaintenance_Menu']");
	private By customerName=By.xpath("//input[@name='Customer.Name']");
	private By gender=By.xpath("//input[@name='Customer.Gender']");
	private By titleDropdown=By.id("dropDownTitle");
	private By foreName=By.xpath("//input[@name='Customer.Forename']");
	private By dob=By.xpath("//div[@class='bootstrap-calendar calendar-container']//div//input");
	private By streetInput=By.xpath("//textarea[@name='PrimaryAddress.Street']");
	private By cityInput=By.xpath("//input[@name='PrimaryAddress.City']");
	private By countryDropdown=By.xpath("//select[@id='dropDownCountry']");
	private By text=By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'This card has already been issued.')]");

	private By matchBttn = By.cssSelector("td.text-center button.btn-primary.btn-secured");
	private By matchButton = By.xpath(".//td[8]/button[@class='btn-primary btn-secured']");
	private By DetailsButton = By.xpath("//button[@id='buttonDetails']");
	private By custDetails=By.xpath("//div[@class='three-col']//div[2]//fieldset");
	private By postcodeInput=By.xpath("//input[@id='PrimaryAddress_PostCode']");
	private By cardNumber=By.xpath("//div//input[@id='textBoxCardNumber']");
	private By saveBtn=By.xpath("//div//button[@class='btn-primary btn-secured'][contains(.,'Save')]");	
	private By noMatchBtn=By.xpath("//div//a[@class='ersatzButton primary btn-secured'][contains(.,'No Match')]");

	private By emailInput=By.xpath("//div//input[@name='Customer.EmailAddress']");

	private By telephoneInput2=By.xpath("//div//input[@name='Customer.MobilePhone']");

	private By postCode_ErrorMessage = By.xpath("//div[contains(.,'Experian interface error: Lost connection to the server. Transaction timed out or server error ')]");
	//private By yesBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'Yes')]");
	//private By yesBtn=By.xpath("//button[contains(.,'Yes')]");
	private By yesBtn=By.xpath("//button[contains(.,'No')]");
	private By cancelBtn = By.xpath("//button[@data-ig-type='Cancel']");

	private By toggleButton = By.xpath("//span[@class='toggleView TableView']");
	private By custNumberDetails =By.cssSelector("td[data-grid-column-key='Number']");
	private By TableAccounting_tableDevices_tableName =By.cssSelector("td[data-grid-column-key='GamingTableName']");
	private By custNumberHeader =By.xpath("//th[@data-grid-column-key='Number']");

	private By paginationForwardArrow =By.xpath("//a[@ng-click='nextPage($event)']//span[@class='glyphicon glyphicon-forward']");

	private By pagination = By.xpath("//ul[@class='pagination']//li[@class='ng-scope']");
	private By table=By.xpath("//table[@class='grid datagrid']");
	private By confirmMsg = By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'This person is not allowed to become a customer.')]");

	public void clickOnRegistration()
	{
		objUtilities.logReporter("Click on registartion tab", objWrapperFunctions.click(registrationTab), false);	
	}

	public void setFirstNLastName(String custName)
	{
		objUtilities.logReporter("Enter username", objWrapperFunctions.setText(customerName,custName), false);
		objWrapperFunctions.pressTabBtn(customerName);
	}

	public void getDOB(String bdate)
	{
		objUtilities.logReporter("Enter DateOfBirth", objWrapperFunctions.setText(dob,bdate), false);
	}


	public void setGender()
	{
		objUtilities.logReporter("select gender", objWrapperFunctions.click(gender), false);	
	}

	public void clickONCancelBtn()
	{
		objWrapperFunctions.waitForElementPresence(cancelBtn);
		objWrapperFunctions.waitForElementToBeClickable(cancelBtn);
		objUtilities.logReporter("Click on Cancel ", objWrapperFunctions.click(cancelBtn), false);	
	}
	public void enterPostCode(String postcode)
	{
		objUtilities.logReporter("Enter Postcode", objWrapperFunctions.setText(postcodeInput, postcode), false);
		objWrapperFunctions.pressTabBtn(postcodeInput);
		if(objWrapperFunctions.checkElementDisplyed(postCode_ErrorMessage))
		{
			objUtilities.logReporter(" click on ok Btn", objWrapperFunctions.click(okBtn), false);	
		}else{clickONCancelBtn();}
	}


	public void enterAddress(String address)
	{
		objUtilities.logReporter("Enter street", objWrapperFunctions.setText(streetInput,address), false);
	}

	public void enterCity(String city)
	{
		objUtilities.logReporter("Enter City", objWrapperFunctions.setText(cityInput,city), false);
	}

	public void enterTelephoneNo(String num)
	{
		objUtilities.logReporter("Enter telephone", objWrapperFunctions.setText(telephoneInput2,num), false);
	}

	public void enterEmailId(String mailId)
	{
		objUtilities.logReporter("Enter emailaddress", objWrapperFunctions.setText(emailInput,mailId), false);
	}

	public void clickOnSaveBtn()
	{
		objUtilities.logReporter("Click on Save btn", objWrapperFunctions.click(saveBtn), false);	
	}

	public void verifyCardNumberExistMessageDisplay()
	{
		if(objWrapperFunctions.checkElementDisplyed(text))
		{
			System.out.println(objWrapperFunctions.getText(text));
			objWrapperFunctions.acceptMultipleAlert(okBtn);
			setCardNumber();
			objUtilities.logReporter("Click on Save btn", objWrapperFunctions.click(saveBtn), false);	
		}
	}

	public void setCardNumber()
	{
		cardnum=objWrapperFunctions.getRandomNumber();
		System.out.println("Card Number=" +cardnum);
		objUtilities.logReporter("Enter cardNumber", objWrapperFunctions.setText(cardNumber,cardnum), false);
	}

	public void getCustomerNumber(String custNm)
	{
		custNumber = custNm;
		System.out.println("CustNumber = " +custNumber);
	}
	public void verifyRecordDisplayInGridView()
	{
		if(objWrapperFunctions.checkElementDisplyed(custNumberHeader)==false)
		{
			objWrapperFunctions.waitForElementToBeClickable(toggleButton);
			objUtilities.logReporter("Click on toggleButton", objWrapperFunctions.clickByScript(toggleButton), false);	
		}

	}
	public void registration(String bdate,String custName,String postcode, String address, String city,
			String num, String mailId,String custNm)
	{

		getCustomerNumber(custNm);
		setFirstNLastName(custName);
		getDOB(bdate);
		enterPostCode(postcode);
		//clickONCancelBtn();
		enterAddress(address);
		enterCity(city);
		//enterEmailId(mailId);
		//enterTelephoneNo(num);
		setCardNumber();
		clickOnSaveBtn();
		verifyCardNumberExistMessageDisplay();
		verifyRecordDisplayInGridView();

	}



	public void selectMatchProfileFromList()
	{
		objWrapperFunctions.verifySpecificElementInInInteligenceDBDuplicateDataTable(pagination, table, matchButton, custNumber);
	//	objWrapperFunctions.searchRecordInInteligenceDBAndDuplicateData(pagination, table, matchButton, noMatchBtn, custNumber);
		//	Thread.sleep(15000);

	}

	public void verifyElementDisplayInDisableMode()
	{
		try {
			Thread.sleep(15000);
			checkFieldsDisplayInDisableMode(customerName,"ng-readonly");
			checkFieldsDisplayInDisableMode(streetInput,"ng-readonly");
			checkFieldsDisplayInDisableMode(cityInput,"ng-readonly");
			checkFieldsDisplayInDisableMode(countryDropdown,"ng-disabled");
			checkFieldsDisplayInDisableMode(cardNumber,"ng-readonly");
			checkFieldsDisplayInDisableMode(emailInput,"ng-readonly");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void verifyMatchProfile(By locator,By locator1,By locator2)
	{
		int pag = objWrapperFunctions.getElementSize(locator);

		for(int i=0;i<pag;i++)
		{
			String arrDevices[]=objWrapperFunctions.getElementTextArray(locator1);
			int index=0;
			for (String temp : arrDevices) 
			{
				System.out.println("Default Selected Devices Name = " +temp);

				if(temp.equalsIgnoreCase(custNumber))
				{
					reqIndex=index;
					objUtilities.logReporter("verify details ",objWrapperFunctions.checkElementDisplyed(locator2), false);		
					objUtilities.logReporter("Select Page", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(locator2,reqIndex)), false);
					break;
				}

				index++;
			}
			objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(locator1,i));
		}
	}	


	public void	checkFieldsDisplayInDisableMode(By locator,String attValue)
	{

		String elementValue = objWrapperFunctions.getAttributeValue(locator, attValue);

		objWrapperFunctions.waitForElementPresence(locator);

		if(elementValue.contains("true"))
		{
			System.out.println(" elementValue : " +elementValue);
		}
	}

	public void clickOnMatchButton()
	{
		objUtilities.logReporter("Click on View match", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(matchBttn, 2)), false);
	}

	public void verifyMessageDisplay()
	{
		objWrapperFunctions.waitForElementPresence(confirmMsg);
		if(objWrapperFunctions.checkElementDisplyed(confirmMsg))
		{
			objUtilities.logReporter("verify Message displayed", objWrapperFunctions.verifyIsElementPresent(confirmMsg), false);
			clickOnOk();
		}
		else
		{System.out.println("This person is not allowed to become a customer.  message not display");
		}
	}
	public void clickOnOk()
	{
		objWrapperFunctions.waitForElementPresence(okBtn);
		objWrapperFunctions.waitForElementToBeClickable(okBtn);
		objUtilities.logReporter("Click on ok", objWrapperFunctions.click(okBtn), false);
	}
}