package com.pageFactory.CustomerProfileTC;

import java.util.Properties;

import org.openqa.selenium.By;

import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class custProfile_SettingPin_PF 
{
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	Properties objConfig=new Properties();
	static String custNumber="",user="",message="",temp="",refId_FE="";
	
	public custProfile_SettingPin_PF(Pojo pojo)
	{
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
		custNumber=pojo.getUser();	
	}
	
	private By custProfile_Action_setPin = By.xpath("//a[@id='buttonSetPinNumber']");
	private By custProfile_setpin_inputPinNumber =By.xpath("//input[@id='PinNumber']");
	private By custProfile_setpin_inputConfirmPinNumber =By.xpath("//input[@id='RepeatPinNumber']");
	private By custProfile_Save = By.xpath("//button[@accesskey='s'][@type='submit']");
	
	private By custProfile_labelPinNumber = By.xpath("//label[contains(.,'Pin Number')]");
	private By custProfile_labelConfirmPinNumber =By.xpath("//label[contains(.,'Confirm Pin')]");
	
	private By custProfile_errMessage = By.xpath("//div[@class='modal-body ig-modal-scroll'][contains(.,'The entered pin numbers do not match.')]");	
	private By custProfile_ok = By.xpath("//button[@data-ig-type='OK']");
	
	private By cashDesk_currencyTransactions_RedeemCurrency_custNumberValue = By.xpath("//label[contains(.,'Number')]//following-sibling::span");
	private By cashDesk_currencyTransactions_RedeemCurrency_custNumberLabel = By.xpath("//label[contains(.,'Number')]");
	
	public void verifySetPin()
	{
		objWrapperFunctions.waitForElementPresence(custProfile_Action_setPin);
		objUtilities.logReporter("verify setPin button display", objWrapperFunctions.verifyIsElementPresent(custProfile_Action_setPin), false);
	}

	public void ClickSetPin()
	{
		objWrapperFunctions.waitForElementToBeClickable(custProfile_Action_setPin);
		objUtilities.logReporter("Click on SetPin button", objWrapperFunctions.click(custProfile_Action_setPin), false);
	}
	
	public void verifyPinLabel()
	{
		objWrapperFunctions.waitForElementPresence(custProfile_labelPinNumber);
		objUtilities.logReporter("verify PinNumber label", objWrapperFunctions.verifyIsElementPresent(custProfile_labelPinNumber), false);
	}
	
	public void setPinLabel(String pinNum)
	{
		objWrapperFunctions.waitForElementPresence(custProfile_setpin_inputPinNumber);
		objUtilities.logReporter("Set PinNumber ", objWrapperFunctions.setText(custProfile_setpin_inputPinNumber,pinNum), false);
	}
	
	public void setConfirmPinLabel(String confirmPinNum)
	{
		objWrapperFunctions.waitForElementPresence(custProfile_setpin_inputConfirmPinNumber);
		objUtilities.logReporter("Set ConfirmPinNumber ", objWrapperFunctions.setText(custProfile_setpin_inputConfirmPinNumber,confirmPinNum), false);
	}
	public void verifyConfirmPinLabel()
	{
		objWrapperFunctions.waitForElementPresence(custProfile_labelConfirmPinNumber);
		objUtilities.logReporter("verify confirm PinNumber label", objWrapperFunctions.verifyIsElementPresent(custProfile_labelConfirmPinNumber), false);
	}
	
	public void clickOnSave()
	{
		objWrapperFunctions.waitForElementPresence(custProfile_Save);
		objWrapperFunctions.waitForElementToBeClickable(custProfile_Save);
		objWrapperFunctions.verifyIsElementPresent(custProfile_Save);
		objUtilities.logReporter("Click on save button", objWrapperFunctions.click(custProfile_Save), false);
	}
	
	public void verifyErrormessage()
	{
		objWrapperFunctions.waitForElementPresence(custProfile_errMessage);
		objWrapperFunctions.waitForElementToBeClickable(custProfile_errMessage);
		objUtilities.logReporter("verify error message displayed", objWrapperFunctions.verifyIsElementPresent(custProfile_errMessage), false);
	}
	
	
	public void clickOnOk()
	{
		objWrapperFunctions.waitForElementPresence(custProfile_ok);
		objWrapperFunctions.waitForElementToBeClickable(custProfile_ok);
		objWrapperFunctions.verifyIsElementPresent(custProfile_ok);
		objUtilities.logReporter("Click on OK button", objWrapperFunctions.click(custProfile_ok), false);
	}
	
	public void verifyCustomerNumberLabelDisplyed()
	{
		objUtilities.logReporter("Verify Customer Number label displayed", 
				objWrapperFunctions.verifyIsElementPresent(cashDesk_currencyTransactions_RedeemCurrency_custNumberLabel), false);
	}
	public void verifyAndGetCustomerNumberValue()
	{
		objUtilities.logReporter("Verify CustomerNumber Value displayed", 
				objWrapperFunctions.verifyIsElementPresent(cashDesk_currencyTransactions_RedeemCurrency_custNumberValue), false);	
		System.out.println("custNumber :" +objWrapperFunctions.getText(cashDesk_currencyTransactions_RedeemCurrency_custNumberValue));
	}
}
