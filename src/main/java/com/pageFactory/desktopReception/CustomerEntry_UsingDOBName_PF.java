package com.pageFactory.desktopReception;

import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class CustomerEntry_UsingDOBName_PF {

	private Utilities objUtilities;
	private Pojo objPojo;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	String custNumber="",user="",message="",temp="",customerName;
	String NeonUser,NeonPass;
	static String refId_FE="",dateofbirth,vistorCnt;

	private int MIN_DEFAULT_SLEEP_TIMEOUT = 1;

	public CustomerEntry_UsingDOBName_PF(Pojo pojo){
		objUtilities = pojo.getObjUtilities();
		webdriver = pojo.getDriver();
		this.objPojo = pojo;
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
		custNumber=pojo.getUser();	
		customerName = pojo.getUser1Values();
		dateofbirth = pojo.getUserDOB();

	}

	private By customerTab=By.xpath("//li[@id='CustomerManagement_Menu']//a[contains(.,'Customers')]");
	private By receptionTab=By.xpath("//a[@id='CustomerManagement_Reception_Menu']");
	private By visitorCount=By.xpath("//div[@id='divCustomersCount']");
	private By findInputBox=By.xpath("//input[@name='SearchCriteria']");
	private By okButton=By.xpath("//footer//button[contains(.,'OK')]");
	private By text=By.xpath("//div[@class='modal-body ig-modal-scroll']");
	private By infoMsg=By.xpath("//div[@id='receptionInfo']");
	private By yesBtn=By.xpath("//button[contains(.,'Yes')]");
	private By noBtn=By.xpath("//button[contains(.,'No')]");
	private By customerNumber=By.xpath("//input[@name='Number']");
	private By custName=By.xpath("//input[@name='Name']");
	private By dob=By.xpath("//input[@name='DateOfBirth']");
	private By cancelButton=By.xpath("//div//footer//button[contains(.,'Cancel')]");
	private By referenceInput=By.xpath("//div//input[@id='Reference']");
	private By detailsInput=By.xpath("//div//input[@id='IssueDetail']");
	private By commit=By.xpath("//div//footer//button[contains(.,'Commit')]");	
	private By table=By.xpath("//table[@class='grid datagrid']//tbody//tr");
	private By matchBtn;
	private By tablerow;

	public void clickOnCustomerTab()
	{
		objWrapperFunctions.waitForElementToBeClickable(customerTab);
		objUtilities.logReporter("Click on Customer tab", objWrapperFunctions.click(customerTab), false);	
	}

	public void clickOnreceptionTab()
	{
		objWrapperFunctions.waitForElementToBeClickable(receptionTab);
		objUtilities.logReporter("Click on Reception tab", objWrapperFunctions.click(receptionTab), false);		
	}
	public void searchCustomerInReception(String searchCust)
	{
		objUtilities.logReporter("Serch customer by '"+searchCust+"' ", objWrapperFunctions.setText(findInputBox,searchCust), false);
		objWrapperFunctions.pressTabBtn(findInputBox);
	}

	public void clickOnYes()
	{
		objUtilities.logReporter("Click on 'Yes' button", objWrapperFunctions.click(yesBtn), false);	
	}
	public void clikOnOk()
	{
		objUtilities.logReporter("Click on 'Ok' button", objWrapperFunctions.click(okButton), false);	
	}
	
	public void verifyEDDMessageDisplayWhileLogVisit(String veriFyEDDMessage)
	{
		//String veriFyEDDMessage = "Allow entry. Inform the duty manager - Open EDD file, 1st visit.";
		 By table=By.xpath("//table[@class='grid datagrid']");
		objUtilities.logReporter("verify EDD Message  ", this.verifyTableContentAgainstToColumn(table,"Message",veriFyEDDMessage), false);
	}

	public void verifyMessageWindowDoesNotDisplay()
	{
		//Customer Suspension
		By pageTitle = By.xpath("//*[@class='modal-title'][contains(text(),'Message')]");
		objPojo.getObjUtilities().logReporter("Verify Message window does not display", 
				objPojo.getObjWrapperFunctions().checkElementNotDisplayed(pageTitle), false);	
	}
	
	public boolean verifyConfirmationMessage(String message)
	{
		objPojo.getWaitMethods().sleep(5);//div[@class='modal-body ig-modal-scroll'][contains(text(),'This record has been saved successfully.')]
		By incident_ConfirmationMessage = By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(text(),'"+ message +"')]");			
		return objPojo.getObjWrapperFunctions().checkElementDisplyed(incident_ConfirmationMessage);	
	}
	public void customerEntryUsingDOB()
	{
		try
		{	
			Thread.sleep(2000);	

			objUtilities.logReporter("Click on Customer tab", objWrapperFunctions.click(customerTab), false);
			objUtilities.logReporter("Click on Reception tab", objWrapperFunctions.click(receptionTab), false);		
			objUtilities.logReporter("Enter dateofbirth ", objWrapperFunctions.setText(findInputBox,dateofbirth), false);
			objWrapperFunctions.pressTabBtn(findInputBox);

			if(objWrapperFunctions.checkElementDisplyed(table))
			{
				int size1=objWrapperFunctions.getElementSize(table);			
				for(int i=1;i<=size1;i++)
				{
					tablerow=By.xpath("//table[@class='grid datagrid']//tbody//tr["+i+"]//td[1]");
					temp=objWrapperFunctions.getText(tablerow);
					System.out.println(temp);
					//matchBtn=By.xpath("//table[@class='grid datagrid']//tbody//tr["+i+"]//td[9]//button[@class='btn-primary btn-secured'][contains(.,'Match')]");			
					matchBtn=By.xpath("(//button[@class='btn-primary btn-secured'][contains(.,'Match')])");
					//objUtilities.logReporter("Click on 'Yes' button", objWrapperFunctions.click(yesBtn), false);
					if(temp.equals(custNumber))
					{
						Thread.sleep(200);
						objUtilities.logReporter("Click on Customer tab", objWrapperFunctions.clickByScript(matchBtn), false);
						//objUtilities.logReporter("Click on Customer tab", objWrapperFunctions.click(matchBtn), false);
						System.out.println("match");
						break;
					}
				}
			}	
			if(objWrapperFunctions.checkElementDisplyed(okButton))
			{
				objWrapperFunctions.acceptMultipleAlert(okButton);
			}
			objUtilities.logReporter("Click on 'Yes' button", objWrapperFunctions.click(yesBtn), false);
			if(objWrapperFunctions.checkElementDisplyed(cancelButton))
			{
				objUtilities.logReporter("Click on 'Cancel' button", objWrapperFunctions.click(cancelButton), false);
			
			}
			System.out.println("Search user by using DOB =" +dateofbirth);

			System.out.println("****************Customer Details**********************");
			//objWrapperFunctions.displayAllElement(custDetails);
			message=objWrapperFunctions.getAttributeValue(customerNumber, "value");
			System.out.println("Number :" +message);
			message=objWrapperFunctions.getAttributeValue(custName,"value");
			System.out.println("Customer Name :" +message);
			message=objWrapperFunctions.getAttributeValue(dob,"value");
			System.out.println("Date of Birth :" +message);
			user=objWrapperFunctions.getText(infoMsg);
			System.out.println("Receptionist received Message  :"+user);	
			String vistCnt=objWrapperFunctions.getText(visitorCount);
			System.out.println(" No. of visitors is "+vistCnt);
			System.out.println("Customer Entry by Using DOB is succssfully added");
		}catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void customerEntryUsingName()
	{
		try
		{	
			Thread.sleep(2000);	
			/*objUtilities.logReporter("Click on Customer tab", objWrapperFunctions.click(customerTab), false);
			objUtilities.logReporter("Click on Reception tab", objWrapperFunctions.click(receptionTab), false);		*/
			objUtilities.logReporter("Enter CustomerName", objWrapperFunctions.setText(findInputBox,customerName), false);
			objWrapperFunctions.pressTabBtn(findInputBox);

			if(objWrapperFunctions.checkElementDisplyed(table))
			{
				int size1=objWrapperFunctions.getElementSize(table);			
				for(int i=1;i<=size1;i++)
				{
					tablerow=By.xpath("//table[@class='grid datagrid']//tbody//tr["+i+"]//td[1]");
					temp=objWrapperFunctions.getText(tablerow);
					System.out.println(temp);
					matchBtn=By.xpath("//table[@class='grid datagrid']//tbody//tr["+i+"]//td[9]//button[@class='btn-primary btn-secured'][contains(.,'Match')]");			
					if(temp.equals(custNumber))
					{
						Thread.sleep(2000);	
						//objUtilities.logReporter("Click on Customer tab", objWrapperFunctions.click(matchBtn), false);
						System.out.println("match");
						break;
					}
				}
			}


			if(objWrapperFunctions.checkElementDisplyed(okButton))
			{
				objWrapperFunctions.waitForElementToBeClickable(okButton);
				objUtilities.logReporter("Click on ok btn", objWrapperFunctions.click(okButton), false);	
			}

			if(objWrapperFunctions.checkElementDisplyed(cancelButton))
			{
				objWrapperFunctions.waitForElementToBeClickable(cancelButton);
				objUtilities.logReporter("Click on Cancel button", objWrapperFunctions.click(cancelButton), false);
			}

			//objUtilities.logReporter("Click on 'Cancel' button", objWrapperFunctions.click(cancelButton), false);
			objUtilities.logReporter("Click on 'Yes' button", objWrapperFunctions.click(yesBtn), false);


			System.out.println("****************Customer Details**********************");
			//objWrapperFunctions.displayAllElement(custDetails);
			message=objWrapperFunctions.getAttributeValue(customerNumber, "value");
			System.out.println("Number :" +message);
			message=objWrapperFunctions.getAttributeValue(custName,"value");
			System.out.println("Customer Name :" +message);
			message=objWrapperFunctions.getAttributeValue(dob,"value");
			System.out.println("Date of Birth :" +message);
			user=objWrapperFunctions.getText(infoMsg);
			System.out.println("Receptionist received Message  :"+user);	
			String vistCnt=objWrapperFunctions.getText(visitorCount);
			System.out.println(" No. of visitors is "+vistCnt);	
			System.out.println("Customer Entry by Using Name is succssfully added");
		}catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getvisitorsCount()
	{
		vistorCnt=objWrapperFunctions.getText(visitorCount);
		System.out.println(" No. of visitors is "+vistorCnt);	
	}
	public boolean verifyTableContentAgainstToColumn(By locator, String columnHeaderFirst, String contentToVerifyFirst)
	{
		Hashtable<String, String> dataColumnHeader = new Hashtable<String, String>();
		int intColumnNumber = 1;
		boolean blnverify = false;
		try {
			WebElement weResultTable = objPojo.getObjWrapperFunctions().processElement(locator);
			List<WebElement> weColumnsHeaders = weResultTable.findElements(By.xpath(".//thead/tr/th"));
			for (WebElement weColumnHeader : weColumnsHeaders)
			{
				((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView(true);", weColumnHeader);
				objPojo.getWaitMethods().sleep(MIN_DEFAULT_SLEEP_TIMEOUT);
				String strHeader = weColumnHeader.getText().trim();
				if (!strHeader.equals(""))
					dataColumnHeader.put(strHeader, String.valueOf(intColumnNumber));
				intColumnNumber++;
			}

			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) 
			{
				WebElement weExceptedClm = weRow.findElement(By.xpath(".//td[" + dataColumnHeader.get(columnHeaderFirst)
						+ "]"));
				System.out.println(" weExceptedClm : " + weExceptedClm);
				//((JavascriptExecutor) objPojo.getWebDriverProvider().getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", weExceptedClm);
				System.out.println(" weExceptedClm : " + weExceptedClm.getText());
				System.out.println(" contentToVerifyFirst : " + contentToVerifyFirst);
				if (weExceptedClm.getText().trim().contains(contentToVerifyFirst))
				{
					blnverify = true;
					System.out.println("blnverify" +blnverify);
					return blnverify;
				}

			}
			return blnverify;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
}
