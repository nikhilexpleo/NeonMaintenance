package com.pageFactory.desktopReception;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class Reception_Entry_PF {

	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	String custNumber="",user="",message="",temp="";
	String NeonUser,NeonPass;
	static String refId_FE="";

	public Reception_Entry_PF(Pojo pojo){
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
		custNumber=pojo.getUser();

	}

	private By customerTab=By.xpath("//li[@id='CustomerManagement_Menu']//a[contains(.,'Customers')]");
	private By receptionTab=By.xpath("//a[@id='CustomerManagement_Reception_Menu']");
	private By visitorCount=By.xpath("//div[@id='divCustomersCount']");
	private By findInputBox=By.xpath("//input[@name='SearchCriteria']");
	private By okButton=By.xpath("//button[@data-ig-type='OK']");
	private By text=By.xpath("//div[@class='modal-body ig-modal-scroll']");
	private By infoMsg=By.xpath("//div[@id='receptionInfo']");
	//private By okBtn=By.xpath("//button[contains(.,'OK')]");	
	private By yesBtn=By.xpath("//button[contains(.,'Yes')]");
	private By noBtn=By.xpath("//button[contains(.,'No')]");
	private By customerNumber=By.xpath("//input[@name='Number']");
	private By custName=By.xpath("//input[@name='Name']");
	private By dob=By.xpath("//input[@name='DateOfBirth']");
	private By cancelButton=By.xpath("//div//footer//button[contains(.,'Cancel')]");
	private By referenceInput=By.xpath("//div//input[@id='Reference']");
	private By detailsInput=By.xpath("//div//input[@id='IssueDetail']");
	private By commit=By.xpath("//div//footer//button[contains(.,'Commit')]");	
	private By globalSearchCheckBox=By.xpath("//input[@id='GlobalSearch']");	
	private By recordCountText=By.xpath("//div[@class='recordcount']//span[@class='ng-binding']");
	private By surNameTextBox=By.xpath("//input[@id='textBoxFindCustomerSurname']");
	private By findButton=By.xpath("//button[@id='buttonFind']");
	private By table=By.xpath("//table[@class='grid datagrid']//tbody//tr");
	private By matchButton;
	private By custStatus;
	private By closeIconTab=By.xpath("//button[@accesskey='x']");
	private By pagination=By.xpath("//div//ul[@class='pagination']//li");

	public void navigateToReceptionTab()
	{
		try
		{
			Thread.sleep(2000);
			objUtilities.logReporter("Click on Customer tab", objWrapperFunctions.click(customerTab), false);
			objUtilities.logReporter("Click on Reception tab", objWrapperFunctions.click(receptionTab), false);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void findCustomer(String custNo)
	{
		objUtilities.logReporter("Enter CustomerNumber", 
				objWrapperFunctions.setText(findInputBox,custNo), false);
		objWrapperFunctions.pressTabBtn(findInputBox);
	}
	public void findCustomerBySurname(String custsurName)
	{
		objUtilities.logReporter("Enter surName",
				objWrapperFunctions.setText(surNameTextBox,custsurName), false);
	}
	public void clickOnCancel()
	{
		objUtilities.logReporter("Click on Cancel button", 
				objWrapperFunctions.click(cancelButton), false);
	}

	public boolean getOkButtonDisplayedOrNot()
	{
		return objWrapperFunctions.checkElementDisplyed(okButton);
		
	}

	public boolean getCancelButtonDisplayedOrNot()
	{
		return objWrapperFunctions.checkElementDisplyed(cancelButton);	
	}
	
	public boolean getReferenceInput()
	{
		return objWrapperFunctions.checkElementDisplyed(referenceInput);		
	}
	
	public void customerEntry()
	{
		String visitor=objWrapperFunctions.getText(visitorCount);
		System.out.println("No of visitors in the Casino =" +visitor);

		findCustomer(custNumber);
		if(objWrapperFunctions.checkElementDisplyed(okButton))
		{
			clickOnOK();	
		}

		if(objWrapperFunctions.checkElementDisplyed(cancelButton))
		{
			clickOnCancel();
		}
		objWrapperFunctions.waitForElementToBeClickable(yesBtn);
//		if(objWrapperFunctions.checkElementDisplyed(okButton))
//		{
//			clickOnOK();	
//		}
		if(objWrapperFunctions.checkElementDisplyed(okButton))
		{
			clickOnOK();	
		}
		//objUtilities.logReporter("Click on 'Cancel' button", objWrapperFunctions.click(cancelButton), false);
		objWrapperFunctions.waitForElementToBeClickable(noBtn);
		//objUtilities.logReporter("Click on 'No' button", objWrapperFunctions.click(noBtn), false);

		clickOnYesNoBtn("No");
		String vistCnt=objWrapperFunctions.getText(visitorCount);
		if(visitor.equals(vistCnt)==true)
		{ 
			System.out.println("After rejecting log visit ,count of visitors is " +vistCnt+ "same as before ");
		}	

		findCustomer(custNumber);
		if(objWrapperFunctions.checkElementDisplyed(okButton))
		{
			clickOnOK();
		}
		if(objWrapperFunctions.checkElementDisplyed(okButton))
		{
			clickOnOK();	
		}
		if(objWrapperFunctions.checkElementDisplyed(referenceInput))
		{	
			setReferenceOnIDEntry("Test");
			setDetailsOnIDEntry("Test");
			clickOnCommit();
		}

		objWrapperFunctions.waitForElementToBeClickable(yesBtn);
		clickOnYesNoBtn("Yes");

		System.out.println("****************Customer Details**********************");
		message=objWrapperFunctions.getAttributeValue(customerNumber, "value");
		System.out.println("Number :" +message);
		message=objWrapperFunctions.getAttributeValue(custName,"value");
		System.out.println("Customer Name :" +message);
		message=objWrapperFunctions.getAttributeValue(dob,"value");
		System.out.println("Date of Birth :" +message);
		user=objWrapperFunctions.getText(infoMsg);
		System.out.println("Receptionist received Message  :"+user);		
		String visitor1=objWrapperFunctions.getText(visitorCount);
		System.out.println("After logged the visit,No of visitors in the Casino =" +visitor1);
		//System.out.println(" Verify No of visitors in the Casino remains as before =" +visitor);
	}

	public void verifyPageTitle(String title)
	{
		//Customer Suspension
		By pageTitle = By.xpath("//*[@class='modal-title'][contains(text(),'"+ title +"')]");
		objUtilities.logReporter("Verify '"+pageTitle+"' display", 
				objWrapperFunctions.checkElementDisplyed(pageTitle), false);	
	}

	public void setReferenceOnIDEntry(String ReferenceDetails)
	{
		objUtilities.logReporter("Enter Reference ", 
				objWrapperFunctions.setText(referenceInput,ReferenceDetails), false);
	}

	public void setDetailsOnIDEntry(String Details)
	{
		objUtilities.logReporter("Enter details",
				objWrapperFunctions.setText(detailsInput,Details), false);
		//objUtilities.logReporter("Click on 'Commit' button", objWrapperFunctions.click(commit), false);
	}

	public void clickOnCommit()
	{
		objUtilities.logReporter("Click on 'Commit' button",
				objWrapperFunctions.click(commit), false);
	}
	public void clickOnYesNoBtn(String strOpt)
	{
		By yesBtn = By.xpath("//button[contains(.,'"+ strOpt +"')]");
		objUtilities.logReporter("Click on"+strOpt, objWrapperFunctions.click(yesBtn), false);	
	}


	public void clickOnOK()
	{
		objUtilities.logReporter("Click on ok btn", objWrapperFunctions.click(okButton), false);	
	}

	public void suspendedCustomer()
	{
		try
		{	
			Thread.sleep(2000);	
			String totalvisitorCount = objWrapperFunctions.getText(visitorCount);
			System.out.println("No of visitors in the Casino =" +totalvisitorCount);
			findCustomer("Auto");
//			if(objWrapperFunctions.checkElementDisplyed(okButton))
//			{
//				clickOnOK();
//			}

			int size1=objWrapperFunctions.getElementSize(table);	
			int pag=objWrapperFunctions.getElementSize(pagination);
			System.out.println(pag);
			for(int i=1;i<=size1;i++)
			{
				custStatus=By.xpath("//table[@class='grid datagrid']//tbody//tr["+i+"]//td[8]");
				temp=objWrapperFunctions.getText(custStatus);
				//System.out.println(temp);

				if(temp.contains("Suspended"))
				{	
					matchButton=By.xpath("(//table[@class='grid datagrid']//tbody//tr["+i+"]//td[9])[1]");
					objUtilities.logReporter("Click on Customer tab", objWrapperFunctions.clickByScript(matchButton), false);
					break;
				}

			}
//			if(objWrapperFunctions.checkElementDisplyed(okButton))
//			{
				//	objUtilities.logReporter("Click on ok btn", objWrapperFunctions.click(okBtn), false);	
				//clickOnOK();
				/*if(objWrapperFunctions.checkElementDisplyed(okBtn))
				{
					message=objWrapperFunctions.getText(text);
					objUtilities.logReporter("Click on ok btn", objWrapperFunctions.click(okBtn), false);	
				}*/
	//		}
			message=objWrapperFunctions.getText(text);
			System.out.println("Warning message is displayed as :" +message);
			
			if(message.equalsIgnoreCase("Customer is Suspended."))
			{
				objUtilities.logReporter("'Customer is Suspended.' message displayed ",true, false);	
			}
			else
			{
				objUtilities.logReporter("'Customer is Suspended.' message not displayed ",false, false);	
			}
			clickOnOK();
			
			
			String reception_recievedMessage =objWrapperFunctions.getText(infoMsg);
			System.out.println("Receptionist received Message  :"+reception_recievedMessage);	
			
			if(reception_recievedMessage.equalsIgnoreCase("No Entry - Suspended"))
			{
				objUtilities.logReporter("'No Entry - Suspended' message displayed in Reception ",true, false);	
			}
			else
			{
				objUtilities.logReporter("'No Entry - Suspended' message not displayed ",false, false);	
			}
			
			String visitor1=objWrapperFunctions.getText(visitorCount);
			if(totalvisitorCount.equalsIgnoreCase(visitor1))
			{
				objUtilities.logReporter("'After logged the visit ,No of visitors in the Casino remain same ",true, false);	
			}
			else
			{
				objUtilities.logReporter("'After logged the visit ,No of visitors in the Casino  are different  ",false, false);	
			}
			System.out.println("****************Suspended Customer Details**********************");
			message=objWrapperFunctions.getAttributeValue(customerNumber, "value");
			System.out.println("Number :" +message);
			message=objWrapperFunctions.getAttributeValue(custName,"value");
			System.out.println("Customer Name :" +message);
			message=objWrapperFunctions.getAttributeValue(dob,"value");
			System.out.println("Date of Birth :" +message);
			user=objWrapperFunctions.getText(infoMsg);
			System.out.println("Receptionist received Message  :"+user);		
			
		}catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickOnFind()
	{
		objUtilities.logReporter("Click on Find button", 
				objWrapperFunctions.click(findButton), false);
	}

	public void checkGolbalSearchBox()
	{
		objUtilities.logReporter("Check GlobalSearch checkbox", 
				objWrapperFunctions.click(globalSearchCheckBox), false);
	}
	public void lapsedCustomer()
	{
		try
		{	
			Thread.sleep(2000);		
			String visitor=objWrapperFunctions.getText(visitorCount);
			System.out.println("No of visitors in the Casino =" +visitor);
			objUtilities.logReporter("Click on findInputBox", objWrapperFunctions.click(findInputBox), false);
			objWrapperFunctions.pressALTF();
			objUtilities.logReporter("Enter surName", objWrapperFunctions.setText(surNameTextBox, "Auto"), false);
			checkGolbalSearchBox();
			clickOnFind();
			String records=objWrapperFunctions.getText(recordCountText);	

			int size1=objWrapperFunctions.getElementSize(table);			
			for(int i=1;i<=size1;i++)
			{
				custStatus=By.xpath("//table[@class='grid datagrid']//tbody//tr["+i+"]//td[8]");
				temp=objWrapperFunctions.getText(custStatus);
				//System.out.println(temp);

				if(temp.contains("Lapsed")) 
				{	
					matchButton=By.xpath("//table[@class='grid datagrid']//tbody//tr["+i+"]//td[9]");
					objUtilities.logReporter("Click on Customer tab", objWrapperFunctions.click(matchButton), false);
					break;
				}

			}
//			if(objWrapperFunctions.checkElementDisplyed(okButton))
//			{
//				objWrapperFunctions.acceptMultipleAlert(okButton);
//			}
			if(objWrapperFunctions.checkElementDisplyed(cancelButton))
			{
				clickOnCancel();
			}
			//objUtilities.logReporter("Click on 'Yes' button", objWrapperFunctions.click(yesBtn), false);
			//objWrapperFunctions.acceptMultipleAlert(yesBtn);

			//objWrapperFunctions.waitForElementPresence(text);
			//message=objWrapperFunctions.getText(text);
			//System.out.println("Warning message is displayed as :" +message);
			//objUtilities.logReporter("Click on ok tab", objWrapperFunctions.click(okButton), false);

			//objWrapperFunctions.pressEnterBtn(okBtn);
			//user=objWrapperFunctions.getText(infoMsg);
			//System.out.println("Receptionist received Message  :"+user);	

			System.out.println("****************Lapsed Customer Details**********************");
			message=objWrapperFunctions.getAttributeValue(customerNumber, "value");
			System.out.println("Number :" +message);
			message=objWrapperFunctions.getAttributeValue(custName,"value");
			System.out.println("Customer Name :" +message);
			message=objWrapperFunctions.getAttributeValue(dob,"value");
			System.out.println("Date of Birth :" +message);
			user=objWrapperFunctions.getText(infoMsg);
			System.out.println("Receptionist received Message  :"+user);		
			String visitor1=objWrapperFunctions.getText(visitorCount);
			System.out.println("After logged the visit,No of visitors in the Casino =" +visitor1);

		}catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void barredCustomersEntry()
	{
		try
		{	
			Thread.sleep(3000);	
			//objUtilities.logReporter("Click on Customer tab", objWrapperFunctions.click(customerTab), false);
			//objUtilities.logReporter("Click on Reception tab", objWrapperFunctions.click(receptionTab), false);	
			//	objWrapperFunctions.wait();
			String visitor=objWrapperFunctions.getText(visitorCount);
			System.out.println("No of visitors in the Casino before log the visit =" +visitor);
			/*	objUtilities.logReporter("Enter CustomerNumber", objWrapperFunctions.setText(findInputBox, "1955147094"), false);
			objWrapperFunctions.pressTabBtn(findInputBox);*/

			findCustomer("1955147094");
			message=objWrapperFunctions.getText(text);
			System.out.println("Warning message is displayed as :" +message);
			clickOnOK();

			System.out.println("****************Barred Customer Details**********************");
			message=objWrapperFunctions.getAttributeValue(customerNumber, "value");
			System.out.println("Number :" +message);
			message=objWrapperFunctions.getAttributeValue(custName,"value");
			System.out.println("Customer Name :" +message);
			message=objWrapperFunctions.getAttributeValue(dob,"value");
			System.out.println("Date of Birth :" +message);
			user=objWrapperFunctions.getText(infoMsg);
			System.out.println("Receptionist received Message  :"+user);		
			String visitor1=objWrapperFunctions.getText(visitorCount);
			System.out.println("After logged the visit,No of visitors in the Casino =" +visitor1);

		}catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void customerEntry_CustomersFromOtherCasino()
	{

		objUtilities.logReporter("Click on findInputBox", objWrapperFunctions.click(findInputBox), false);
		objWrapperFunctions.pressALTF();
		//objUtilities.logReporter("Enter surName", objWrapperFunctions.setText(surNameTextBox, "Auto"), false);
		
		objUtilities.logReporter("Check GlobalSearch checkbox", objWrapperFunctions.click(globalSearchCheckBox), false);
		objUtilities.logReporter("Click on Find button", objWrapperFunctions.click(findButton), false);
		String records=objWrapperFunctions.getText(recordCountText);	
		//System.out.println(records+ " Record(s) Found");

		int size1=objWrapperFunctions.getElementSize(table);			
		for(int i=1;i<=size1;i++)
		{
			custStatus=By.xpath("//table[@class='grid datagrid']//tbody//tr["+i+"]//td[8]");
			temp=objWrapperFunctions.getText(custStatus);
			//System.out.println(temp);
			if(temp.contains("Active")) 
				//	if(temp.contains("Suspended"))
			{	
				matchButton=By.xpath("//table[@class='grid datagrid']//tbody//tr["+i+"]//td[9]");
				objUtilities.logReporter("Click on Customer tab", objWrapperFunctions.click(matchButton), false);
				break;
			}

		}

		//objUtilities.logReporter("Click on 'Yes' button", objWrapperFunctions.click(yesBtn), false);
		if(objWrapperFunctions.checkElementDisplyed(okButton))
		{
			objWrapperFunctions.acceptMultipleAlert(okButton);
		}
		if(objWrapperFunctions.checkElementDisplyed(cancelButton))
		{
			objUtilities.logReporter("Click on Cancel button", 
					objWrapperFunctions.click(cancelButton), false);
		}
		objWrapperFunctions.acceptMultipleAlert(yesBtn);

		System.out.println("****************Customer Details**********************");
		message=objWrapperFunctions.getAttributeValue(customerNumber, "value");
		System.out.println("Number :" +message);
		message=objWrapperFunctions.getAttributeValue(custName,"value");
		System.out.println("Customer Name :" +message);
		message=objWrapperFunctions.getAttributeValue(dob,"value");
		System.out.println("Date of Birth :" +message);
		user=objWrapperFunctions.getText(infoMsg);
		System.out.println("Receptionist received Message  :"+user);		
		String visitor1=objWrapperFunctions.getText(visitorCount);
		System.out.println("After logged the visit,No of visitors in the Casino =" +visitor1);

	}


	public void closeTab()
	{
		objUtilities.logReporter("Click on 'x' ", objWrapperFunctions.click(closeIconTab), false);	
	}


}
