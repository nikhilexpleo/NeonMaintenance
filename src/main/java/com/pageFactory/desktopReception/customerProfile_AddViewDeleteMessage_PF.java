package com.pageFactory.desktopReception;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class customerProfile_AddViewDeleteMessage_PF {
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	static String custNumber="",user="",message="",temp="",refId_FE="";
	static int tempRandom,expiry_days,expiry_month,expiry_year ;


	public customerProfile_AddViewDeleteMessage_PF(Pojo pojo)
	{
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
		custNumber=pojo.getUser();	
	}
	private By customersMainTab=By.xpath("//li[@id='CustomerManagement_Menu']//a[contains(.,'Customers')]");
	private By customersTab=By.xpath("//a[@id='CustomerManagement_CustomerMaintenance_Menu']");

	private By findInputBox=By.xpath("//input[@id='Number']");
	private By receptionTab=By.xpath("//a[@id='CustomerManagement_Reception_Menu']");

	private By receptionEntry_findInputBox=By.xpath("//input[@name='SearchCriteria']");
	private By receptionEntry_deleteButton=By.xpath("//button[@class='btn btn-warning ig-btn-wide btn-secured'][contains(.,'Delete')]");	

	private By findButton=By.xpath("//button[@id='buttonFind']");
	private By headingTxt=By.xpath("//h2[@id='layoutCaption']");

	private By customerProfile_MessagesTab=By.xpath("//section[@class='sidebar']//li[@id='tabMessages']//a[contains(.,'Messages')]");	
	private By customerProfile_Messages_AddButton=By.xpath("//button[@id='buttonAddMessage'][contains(.,'Add')]");		
	private By customerProfile_Messages_Details=By.xpath("//textarea[@id='Details']");


	private By customerProfile_Messages_GroupWideScope=By.xpath("//input[@id='radioButtonGroupwide']");
	private By customerProfile_Messages_Remove=By.xpath("//button[@class='btn btn-warning ig-btn-wide btn-secured'][contains(.,'Remove')]");
	private By customerProfile_DueDiligenceTab=By.xpath("//section[@class='sidebar']//li[@id='tabDueDiligence']//a[contains(.,'Due Diligence')]");
	private By customerProfile_Messages_selectCasinoDropdown=By.xpath("//select[@id='dropDownCustomerMessageCasino']");	
	private By customerProfile_GamingTab=By.xpath("//section[@class='sidebar']//li[@id='tabGaming']//a[contains(.,'Gaming')]");	
	private By cancelButton=By.xpath("//div//footer//button[contains(.,'Cancel')]");
	private By customerProfile_Associates_SaveButton=By.xpath("//button[@class='btn-primary btn-secured'][contains(.,'Save')]");
	private By closeIconTab=By.xpath("//button[@accesskey='x']");
	private By okButton=By.xpath("//button[contains(.,'OK')]");
	private By okAlert=By.xpath("//button[@class='btn btn-default'][contains(.,'OK')]");
	private By text=By.xpath("//div[@class='modal-body ig-modal-scroll']");
	private By table=By.xpath("//table[@class='grid datagrid']//tbody//tr");	
	private By tableHeader=By.xpath("//table[@class='grid datagrid']//thead//tr//th");	
	private By yesBtn=By.xpath("//button[contains(.,'Yes')]");
	private By noBtn=By.xpath("//button[contains(.,'No')]");
	private By tablecolumn;
	private By tableFooter;
	private By pageHeader ;
	private By scopeRadioButton_Local = By.xpath("//input[@id='radioButtonScopeLocal']");
	private By scopeRadioButton_Groupwide = By.xpath("//input[@id='radioButtonScopeGroupWide']");
	private By Application_Checkbox = By.xpath("//label[contains(@for,'checkBoxListApplicationTypes')][contains(text(),'')]");
	private By message_textArea = By.xpath("//textarea[@id='textBoxMessageDeails']");

	public void enterMessageDetailsInInputr(String msg)
	{
		objUtilities.logReporter("Enter details'", 
				objWrapperFunctions.setText(message_textArea,msg), false);
	}

	public void verifyPageHeader(String temp)
	{
		pageHeader = By.xpath("//*[@class='modal-title'][contains(text(),'"+temp+"')] ");
		objUtilities.logReporter("verify page header displayed as '"+temp+"'", objWrapperFunctions.checkElementDisplyed(pageHeader), false);
	}

	public void verifyApplicationCheckbox(String temp)
	{
		Application_Checkbox = By.xpath("//div[@id='checkBoxListApplicationTypes']//label[contains(.,'"+temp+"')] ");
		objUtilities.logReporter("verify page header displayed as '"+temp+"'", objWrapperFunctions.checkElementDisplyed(Application_Checkbox), false);
	}

	public void checkReceptionApplicationCheckBox()
	{
		By Application_Checkbox_Reception = By.xpath("//div[@id='checkBoxListApplicationTypes']/label[4]/input ");
		objUtilities.logReporter("verify Reception ApplicationCheckBox ", objWrapperFunctions.checkElementDisplyed(Application_Checkbox_Reception),false);	
		objUtilities.logReporter("Click Reception ApplicationCheckBox ", objWrapperFunctions.click(Application_Checkbox_Reception),false);

	}
	public void verifyLocalRadioButtonDisplayed()
	{
		objUtilities.logReporter("verify Local radiobutton ", 
				objWrapperFunctions.checkElementDisplyed(scopeRadioButton_Local), false);
	}

	public void clickyLocalRadioButtonDisplayed()
	{
		objUtilities.logReporter("Click Local radiobutton ",
				objWrapperFunctions.click(scopeRadioButton_Local), false);
	}
	public void verifyGroupwideRadioButtonDisplayed()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objUtilities.logReporter("verify Groupwide radiobutton ", 
				objWrapperFunctions.checkElementDisplyed(scopeRadioButton_Groupwide), false);
	}

	public void clickyGroupwideRadioButtonDisplayed()
	{
		objUtilities.logReporter("Click Groupwide radiobutton ", 
				objWrapperFunctions.click(scopeRadioButton_Groupwide), false);
	}

	public void navigateToCustomerTab()
	{
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objUtilities.logReporter("Click on Customers Menu tab", objWrapperFunctions.click(customersMainTab), false);
		objUtilities.logReporter("Click on Customers tab", objWrapperFunctions.click(customersTab), false);
	}	

	public void findCustomer()
	{
		objUtilities.logReporter("Enter Customer Number", objWrapperFunctions.setText(findInputBox,custNumber), false);
		objUtilities.logReporter("Click on Find button", objWrapperFunctions.click(findButton), false);
		System.out.println("customer number is :"+custNumber);

	}		

	public void clickMessageTab()
	{
		objWrapperFunctions.scrollTab(customerProfile_MessagesTab);
	}
	public void clickDueDiligenceTab()
	{
		objWrapperFunctions.scrollTab(customerProfile_DueDiligenceTab);
	}

	public void clickOk()
	{

		try {
			objUtilities.logReporter("Click OK", objWrapperFunctions.click(okButton), false);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addLocalMessageToCustAccount()
	{	
		try 
		{
			Thread.sleep(5000);
			verifyPageHeader("Customer Message");
			verifyLocalRadioButtonDisplayed();
			verifyGroupwideRadioButtonDisplayed();

			verifyApplicationCheckbox("Reception");
			verifyApplicationCheckbox("Table Manager");
			verifyApplicationCheckbox("Neon Touch (Inbox)");
			verifyApplicationCheckbox("Managers App");
			verifyApplicationCheckbox("Cash Desk");
			checkReceptionApplicationCheckBox();
			enterMessageDetailsInInputr("Test Message");

			clickOk();
			//Thread.sleep(5000);
			clickOnSave();
			String msg=objWrapperFunctions.getText(text);		
			objWrapperFunctions.acceptMultipleAlert(okButton);
			System.out.println("Message "+msg);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void messageNotAllowedToDelete()
	{
		try
		{
			Thread.sleep(2000);
			objUtilities.logReporter("Click on Customer tab", objWrapperFunctions.clickByScript(customersMainTab), false);
			objUtilities.logReporter("Click on Reception tab", objWrapperFunctions.click(receptionTab), false);
			objUtilities.logReporter("Enter CustomerNumber", objWrapperFunctions.setText(receptionEntry_findInputBox,custNumber), false);
			objWrapperFunctions.pressTabBtn(receptionEntry_findInputBox);
			Thread.sleep(2000);
			objUtilities.logReporter("Click on Delete", objWrapperFunctions.click(receptionEntry_deleteButton), false);
			Thread.sleep(2000);
			String msg=objWrapperFunctions.getText(text);	
			System.out.println("Message "+msg);
			if(msg.contentEquals("Message Message is not allowed to be deleted."))
			{
				objUtilities.logReporter("'"+msg +"' display",
						true, false);	
			}

			objWrapperFunctions.acceptMultipleAlert(okAlert);
			Thread.sleep(5000);

			if(objWrapperFunctions.checkElementDisplyed(cancelButton))
			{
				objUtilities.logReporter("Click on cancel", objWrapperFunctions.click(cancelButton), false);	
			}
			objUtilities.logReporter("Click on No", objWrapperFunctions.click(noBtn), false);	
			//objWrapperFunctions.acceptMultipleAlert(okAlert);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void clickOnCancel()
	{
		objUtilities.logReporter("Click on cancel", objWrapperFunctions.click(cancelButton), false);
	}

	public void addGroupWideMessageToCustAccount()
	{
		try {
			Thread.sleep(5000);		
			//	navigateToCustomerTab();
			//	findCustomer();
			//	clickMessageTab();
			clickOnAddMessage();		
			clickyGroupwideRadioButtonDisplayed();

			if((!(objWrapperFunctions.isEnabled(customerProfile_Messages_selectCasinoDropdown)))==true)
			{
				System.out.println("Casino field is disabled ");
			}
			checkReceptionApplicationCheckBox();
			enterMessageDetailsInInputr("Test Message");
			objWrapperFunctions.click(okButton);
			clickOnSave();
			String msg=objWrapperFunctions.getText(text);		
			objWrapperFunctions.acceptMultipleAlert(okButton);
			System.out.println("Message "+msg);
			navigateToMessageTab();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void navigateToMessageTab()
	{
		objUtilities.logReporter("Click on customer Profile_MessageTab", 
				objWrapperFunctions.doubleClick(customerProfile_MessagesTab), false);
	}
	public void clickOnSave()
	{
		objUtilities.logReporter("Click on Save ",
				objWrapperFunctions.click(customerProfile_Associates_SaveButton), false);
	}
	public void clickOnAddMessage()
	{
		try {
			Thread.sleep(5000);
			objUtilities.logReporter("Click on Add tab", 
					objWrapperFunctions.click(customerProfile_Messages_AddButton), false);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void viewMessageDetails()
	{
		//clickMessageTab();
		System.out.println("************Customer Message Details **************");

		int tablesize=objWrapperFunctions.getElementSize(table);
		int columnSize=objWrapperFunctions.getElementSize(tableHeader);
		System.out.println(tablesize);
		for(int i=1;i<=tablesize;i++)
		{
			for(int j=1;j<=5;j++)
			{
				tableHeader=By.xpath("//table[@class='grid datagrid']//thead//tr[1]//th["+j+"]");			
				tablecolumn=By.xpath("//table[@class='grid datagrid']//tbody//tr["+i+"]//td["+j+"]");
				System.out.println(objWrapperFunctions.getText(tableHeader)+ "= " +objWrapperFunctions.getText(tablecolumn) );

			}
		}
	}


	public void deleteMessage()
	{
		objUtilities.logReporter("Click on Remove", objWrapperFunctions.click(objWrapperFunctions.getElementOfIndex(customerProfile_Messages_Remove, 0)), false);

		//objUtilities.logReporter("Click on Remove ", objWrapperFunctions.click(customerProfile_Messages_Remove), false);
		objWrapperFunctions.verifyElementAbsent(customerProfile_Messages_Remove);

	}





	public void closeTab()
	{
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(cancelButton), false);
	}
}
