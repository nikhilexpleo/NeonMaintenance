package com.pageFactory.desktopReception;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class DepositOnOff_PF
{

	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	String custNumber="",message="";

	public DepositOnOff_PF(Pojo pojo)
	{
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		custNumber=pojo.getUser();
		System.out.println("customerNumber->>"+custNumber);
	}

	private By okBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'OK')]");	
	private By okButton=By.xpath("//button[@data-ig-type='OK']");	
	private By saveBtn=By.xpath("//div//button[@class='btn-primary btn-secured'][contains(.,'Save')]");	
	private By cashDeskTab=By.xpath("//li[@id='Cashdesk_Menu']//a[contains(.,'Cash Desk')]");
	private By depositTab=By.xpath("//li[@id='Cashdesk_Deposits_Menu']//a[contains(.,'Deposits')]");
	private By depositOnTab=By.xpath("//li//a[contains(.,'Deposit On')]");
	private By customerNoDeposit=By.xpath("//div//input[@name='CustomerNumber']");
	private By amountInput=By.xpath("//div//input[@name='Amount']");
	private By cashCheckbox=By.xpath("//div//input[@name='CashExchange']");
	private By yesBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'Yes')]");
	private By balance=By.xpath("//div//span[@id='labelCurrentBalance']");
	private By depositOffTab=By.xpath("//ul//li//a[contains(.,'Deposit Off')]");	
	private By commentTextArea=By.xpath("//div//textarea[@name='Comment']");
	private By closeIconTab=By.xpath("//button[@accesskey='x']");

	public void navigateToCashDesk()
	{
		objUtilities.logReporter("Click on Cash Desk  tab", objWrapperFunctions.click(cashDeskTab), false);	
	}

	public void clickOnDeposits()
	{
		objUtilities.logReporter("Click on Deposit tab", objWrapperFunctions.click(depositTab), false);	
	}
	public void clickOnDepositOn()
	{
		objUtilities.logReporter("Click on Deposit On tab", objWrapperFunctions.click(depositOnTab), false);	
	}
	public void clickOnDepositOff()
	{
		objUtilities.logReporter("Click on Deposit tab", objWrapperFunctions.click(depositOffTab), false);	
	}

	public void setCustomerNumber(String custNum)
	{
		objUtilities.logReporter("Enter Customer Number", objWrapperFunctions.setText(customerNoDeposit,custNum), false);
		objWrapperFunctions.pressTabBtn(customerNoDeposit);
	}

	public void clickOnOk()
	{
		objUtilities.logReporter("Click on ok btn", objWrapperFunctions.click(okButton), false);	
	}

	public void setAmount(String amt)
	{
		objUtilities.logReporter("Click on amount textbox", objWrapperFunctions.click(amountInput), false);
		objUtilities.logReporter("Click on amount textbox", objWrapperFunctions.clear(amountInput), false);
		objUtilities.logReporter("Enter amount", objWrapperFunctions.setText(amountInput,amt), false);
	}

	public void setComment(String comment)
	{
		objUtilities.logReporter("Enter comment", objWrapperFunctions.setText(commentTextArea,comment), false);
	}

	public void selectCashCheckbox()
	{
		objUtilities.logReporter("Click on cashCheckbox", objWrapperFunctions.click(cashCheckbox), false);	
	}

	public void clickSave()
	{
		objUtilities.logReporter("Click on Save btn", objWrapperFunctions.click(saveBtn), false);	
	}
	public void clickYes()
	{
		objUtilities.logReporter(" click on yesBtn", objWrapperFunctions.click(yesBtn), false);
	}
	public boolean getConfirmationMessage(String msg)
	{
		By confirmMessage = By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(text(),'"+ msg +"')]");
		return objWrapperFunctions.verifyIsElementPresent(confirmMessage);
	}

	public void closeOpenTab()
	{
		objUtilities.logReporter("Click on 'x' ", objWrapperFunctions.click(closeIconTab), false);		
	}

	public void depositOn()
	{	
		try{
			Thread.sleep(10000);
			System.out.println("***************Performing Deposit On Functionality ***************");
			System.out.println("Customer Number=" +custNumber);
			navigateToCashDesk();
			clickOnDeposits();
			clickOnDepositOn();
			setCustomerNumber(custNumber);
			Thread.sleep(3000);
			if(objWrapperFunctions.checkElementDisplyed(okButton))
			{clickOnOk();}
			message=objWrapperFunctions.getText(balance);
			System.out.println("Account balance before deposit = "+message);		
			setAmount("1");
			System.out.println("Deposit 10 amount as cash value ");
			setComment("Test purpose only");
			selectCashCheckbox();
			clickSave();
			Thread.sleep(3000);
			if(objWrapperFunctions.checkElementDisplyed(yesBtn))
			{
				clickYes();
				Thread.sleep(3000);
				if(objWrapperFunctions.checkElementDisplyed(yesBtn))
				{
					clickYes();
				}
			}		

			if(this.getConfirmationMessage("Transaction completed"))
			{
				clickOnOk();
			}

			message=objWrapperFunctions.getText(balance);
			System.out.println("Account balance after deposit = "+message);
			System.out.println("Transaction Completed successfully");
			objUtilities.logReporter("Click on 'x' ", objWrapperFunctions.click(closeIconTab), false);		
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Perform deposit off
	public void depositOff()
	{	
		try{
			Thread.sleep(4000);
			System.out.println("***************Performing Deposit Off Functionality ***************");
			System.out.println("Customer Number=" +custNumber);

			navigateToCashDesk();
			clickOnDeposits();
			clickOnDepositOff();
			setCustomerNumber(custNumber);
			Thread.sleep(3000);
			if(objWrapperFunctions.checkElementDisplyed(okButton))
			{clickOnOk();}
			verifyDepositHistory();
			//verifyLables("Name");
			//verifyLables("Date Of Birth");
			
			message=objWrapperFunctions.getText(balance);
			System.out.println("Account balance before deposit = "+message);		
			setAmount("5");
			System.out.println("Deposit 10 amount as cash value ");
			setComment("Test purpose only");
			selectCashCheckbox();
			clickSave();

			if(objWrapperFunctions.checkElementDisplyed(yesBtn))
			{
				clickYes();
				Thread.sleep(3000);
				if(objWrapperFunctions.checkElementDisplyed(yesBtn))
				{
					clickYes();
				}
			}		

			if(this.getConfirmationMessage("Transaction completed"))
			{
				clickOnOk();
			}


			/*objUtilities.logReporter("Click on Cash Desk  tab", objWrapperFunctions.click(cashDeskTab), false);	
			//objUtilities.logReporter("Click on Deposit tab", objWrapperFunctions.click(depositTab), false);	
			objUtilities.logReporter("Click on Deposit Off tab", objWrapperFunctions.click(depositOffTab), false);	
			objUtilities.logReporter("Enter Customer Number", objWrapperFunctions.setText(customerNoDeposit,custNumber), false);		
			objWrapperFunctions.pressTabBtn(customerNoDeposit);
			Thread.sleep(3000);
			if(objWrapperFunctions.checkElementDisplyed(okButton))
			{
				objUtilities.logReporter("Click on ok btn", objWrapperFunctions.click(okButton), false);	
			}
			message=objWrapperFunctions.getText(balance);
			System.out.println("Account balance before deposit = "+message);		
			objUtilities.logReporter("Click on amount textbox", objWrapperFunctions.click(amountInput), false);
			objUtilities.logReporter("Click on amount textbox", objWrapperFunctions.clear(amountInput), false);
			objUtilities.logReporter("Enter amount", objWrapperFunctions.setText(amountInput,"5"), false);
			System.out.println("Deposit off 5 amount as cash value ");
			objUtilities.logReporter("Enter comment", objWrapperFunctions.setText(commentTextArea,"test"), false);
			objUtilities.logReporter("Click on Save btn", objWrapperFunctions.click(cashCheckbox), false);
			objUtilities.logReporter("Click on Save btn", objWrapperFunctions.click(saveBtn), false);	
			if(objWrapperFunctions.checkElementDisplyed(yesBtn))
			{
				objUtilities.logReporter(" click on yesBtn", objWrapperFunctions.click(yesBtn), false);
				if(objWrapperFunctions.checkElementDisplyed(yesBtn))
				{
					objUtilities.logReporter(" click on yes Btn", objWrapperFunctions.click(yesBtn), false);
				}
			}		
			objWrapperFunctions.pressEnterBtn(okBtn);
			message=objWrapperFunctions.getText(balance);
			System.out.println("Account balance after deposit off = "+message);
			System.out.println("Transaction Completed successfully");*/
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void verifyDepositHistory()
	{
		By labelDepositHistory = By.xpath("//fieldset//legend[contains(.,'Deposit History')]");
		objUtilities.logReporter("verify labelDepositHistory ", objWrapperFunctions.checkElementDisplyed(labelDepositHistory), false);
	}
	public void verifyLables(String temp)
	{
		By Application_Checkbox = By.xpath("//fieldset//following::div//label[contains(.,'"+temp+"')]");
		
		objUtilities.logReporter("verify page header displayed as '"+temp+"'", objWrapperFunctions.checkElementDisplyed(Application_Checkbox), false);
	}

	public void getFieldValue(String temp)
	{
		By Application_Checkbox = By.xpath("//fieldset//following::div//label[contains(text(),'"+temp+"')]//following::span");
		
		objUtilities.logReporter("verify page header displayed as '"+temp+"'", objWrapperFunctions.checkElementDisplyed(Application_Checkbox), false);
	}
}
