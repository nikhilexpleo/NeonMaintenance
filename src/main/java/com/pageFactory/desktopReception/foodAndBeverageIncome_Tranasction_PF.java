package com.pageFactory.desktopReception;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class foodAndBeverageIncome_Tranasction_PF {
	
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	String custNumber="",machineName="",message="";
	static String refId_FE="";
	
	public foodAndBeverageIncome_Tranasction_PF(Pojo pojo){
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();	
		custNumber=pojo.getUser();
	}
	
	private By transactionTab=By.xpath("//li//a//span//span[@class='ig-icon-text'][contains(.,'Transactions')]");	
	private By FnBIncomeTab=By.xpath("//div[@id='Sidebar_PassTransactions_Sidebar']//li//a[contains(.,'F&B Income')]");
	
	private By FnBIncomeReversalTab=By.xpath("//div[@id='Sidebar_PassTransactions_Sidebar']//li//a[contains(.,'F&B Income Reversal')]");
	
	private By subAccountDropDown=By.xpath("//select[@id='SubAccountId']");	
	private By headingText=By.xpath("//div[@class='buttonbar']//div//h2");	
	private By closeIconTab=By.xpath("//button[@accesskey='x']");
	
	private By amountTextbox=By.xpath("//div//input[@id='textBoxAmount']");
	private By commentTextBox=By.xpath("//textarea[@id='Comment']");
	private By saveButton=By.xpath("//button[@class='btn-primary btn-secured'][contains(.,'Save')]");	
	private By accountText=By.xpath("//div//span[@class='readonlytext']");
	private By okBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'OK')]");
	private By yesBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'Yes')]");
	private By newBtn=By.xpath("//button[@class='btn-primary btn-secured'][contains(.,'New')]");
	
	private By scrollTab=By.xpath("//div[@id='Sidebar_PassTransactions_Sidebar']");
	
	
	public void navigateToFnBIncomeTab()
	{
		objUtilities.logReporter("Click on transaction Tab", objWrapperFunctions.click(transactionTab), false);
		objWrapperFunctions.scrollTab(FnBIncomeTab);
		String text=objWrapperFunctions.getText(headingText);
		System.out.println(text);
	//	objUtilities.logReporter("select sub account", objWrapperFunctions.selectDropDownByRandomIndex(subAccountDropDown, 11, 1), false);
		objUtilities.logReporter("select sub account", objWrapperFunctions.selectDropDownByIndex(subAccountDropDown,1), false);
		String subAccount=objWrapperFunctions.getSelectedValueFromDropDown(subAccountDropDown);
		System.out.println("Sub Account : "+subAccount);
	}
	
	public void navigateToFnBIncomeReversalTab()
	{
		objUtilities.logReporter("Click on transaction Tab", objWrapperFunctions.click(transactionTab), false);
		objWrapperFunctions.scrollTab(FnBIncomeReversalTab);
		String text=objWrapperFunctions.getText(headingText);
		System.out.println(text);
	//	objUtilities.logReporter("select sub account", objWrapperFunctions.selectDropDownByRandomIndex(subAccountDropDown, 11, 1), false);
		objUtilities.logReporter("select sub account", objWrapperFunctions.selectDropDownByIndex(subAccountDropDown,1), false);
		String subAccount=objWrapperFunctions.getSelectedValueFromDropDown(subAccountDropDown);
		System.out.println("Sub Account : "+subAccount);
	}
	
	public void addAmountDetailsAndSave()
	{
		objWrapperFunctions.waitForElementPresence(accountText);
		String accounttxt=objWrapperFunctions.getText(accountText);
		System.out.println("Account : " +accounttxt);
		objWrapperFunctions.clear(amountTextbox);
		objUtilities.logReporter("Enter Amount Number", objWrapperFunctions.setText(amountTextbox,"5"), false);	
		String amt=objWrapperFunctions.getAttributeValue(amountTextbox, "value");
		System.out.println("Amount Entered : " +amt);
		objUtilities.logReporter("Enter Comment Number", objWrapperFunctions.setText(commentTextBox,"test"), false);
		objUtilities.logReporter("Click on Save", objWrapperFunctions.click(saveButton), false);	
		objUtilities.logReporter("Click on Yes button", objWrapperFunctions.click(yesBtn), false);
		objUtilities.logReporter("Click on Ok", objWrapperFunctions.click(okBtn), false);
		objUtilities.logReporter("Verify New button present", objWrapperFunctions.verifyIsElementPresent(newBtn),false);
		objUtilities.logReporter("Click on New", objWrapperFunctions.click(newBtn), false);
		objUtilities.logReporter("Click on 'x' ", objWrapperFunctions.click(closeIconTab), false);		
	}
}
