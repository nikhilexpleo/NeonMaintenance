package com.pageFactory.CashierManagerTC;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
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

public class SideNavigation_Transaction
{
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	String message="";
	String NeonUser,NeonPass;
	static String refId_FE="",custName="",date="",cardnum="", conDate="",userNm;
	//static int cardnum;
	
	public SideNavigation_Transaction(Pojo pojo){
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
		NeonUser=pojo.getNeonUser();
		NeonPass=pojo.geNeonPassword();	
		userNm =pojo.getUser1Values();
	}
	
	private By userName=By.id("Username");
	private By password=By.id("Password");
	private By signBtn=By.xpath("//button[@class='btn btn-lg btn-primary btn-block ig-signin-button']");
	private By okBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'OK')]");

	//private By exportToCSV=By.xpath("//ul[@class='dropdown-menu']//li//a[@id='exportToCSV']");

	private By sideBarTransaction = By.cssSelector("a[aria-controls='Sidebar_PassTransactions_Sidebar']");

	private By functionDepON=By.xpath("//div[@id='Sidebar_PassTransactions_Sidebar']//li//a[contains(.,'Function Deposit On')]");
	private By functionDepOFF=By.xpath("//div[@id='Sidebar_PassTransactions_Sidebar']//li//a[contains(.,'Function Deposit Off')]");
	
	//private By functionDepON = By.cssSelector("div#Sidebar_PassTransactions_Sidebar ul a#TransactionsSidebar_Standard_98030");
	//private By functionDepOFF = By.cssSelector("div#Sidebar_PassTransactions_Sidebar ul a#TransactionsSidebar_Standard_98029");
	
	
	private By inputName = By.cssSelector("input#textBoxCustomerName");
	private By selectSubAcc = By.cssSelector("select#SubAccountId");
	private By enterAmount = By.cssSelector("input#textBoxAmount");
	private By submit = By.cssSelector("button[type='submit']");
	private By yesButton = By.cssSelector("button[data-ig-type='YES']");
	
	private By pokerON=By.xpath("//div[@id='Sidebar_PassTransactions_Sidebar']//li//a[contains(.,'Poker Voucher On')]");
	private By pokerOFF=By.xpath("//div[@id='Sidebar_PassTransactions_Sidebar']//li//a[contains(.,'Poker Voucher Off')]");
	
	//private By pokerON=By.cssSelector("a#TransactionsSidebar_Standard_98046");
	//private By pokerOFF=By.cssSelector("a#TransactionsSidebar_Standard_98045");
	private By pokerOnOffNewButton=By.cssSelector("button.btn-primary.btn-secured");
	private By pokerAmountTextBox= By.cssSelector("input#textBoxAmount");
	private By pokerOnOffComment= By.cssSelector("textarea#Comment");
	private By pokerOnOffSave = By.cssSelector("button[accesskey='s']");
	private By closeIconTab=By.xpath("//button[@accesskey='x']");
	
	public void functionDeposit(){
		try {
			Thread.sleep(6000);
			
			objUtilities.logReporter("Enter username", objWrapperFunctions.setText(inputName, userNm), false);
			
			objUtilities.logReporter("Select sub-Account", objWrapperFunctions.selectDropDownByIndex(selectSubAcc,2), false);	
			//objWrapperFunctions.acceptMultipleAlert(okBtn);
			objUtilities.logReporter("Enter amount", objWrapperFunctions.setText(enterAmount, "10"), false);
			objUtilities.logReporter("Click on save", objWrapperFunctions.click(submit), false);
			Thread.sleep(400);
			//objUtilities.logReporter("Click on yesButton", objWrapperFunctions.click(yesButton), false);
			objWrapperFunctions.acceptMultipleAlert(yesButton);
			objWrapperFunctions.acceptMultipleAlert(okBtn);
			Thread.sleep(400);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void functionPoker(){
		try {
			Thread.sleep(5000);
			
			//objUtilities.logReporter("Click on New Button", objWrapperFunctions.click(pokerOnOffNewButton), false);
			objUtilities.logReporter("Enter username", objWrapperFunctions.setText(pokerAmountTextBox, "10"), false);
			
			objUtilities.logReporter("Add comment", objWrapperFunctions.setText(pokerOnOffComment, "Sample Poker Account ON"), false);	
	
		
			objUtilities.logReporter("Click on Save", objWrapperFunctions.click(pokerOnOffSave), false);
			Thread.sleep(3000);
			objUtilities.logReporter("Click on yesButton", objWrapperFunctions.click(yesButton), false);
			objWrapperFunctions.acceptMultipleAlert(okBtn);
			closeTab();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void clickSideTransaction(){
		objUtilities.logReporter("Click on sidebar transaction", objWrapperFunctions.clickByScript(sideBarTransaction), false);
		
	}
	
	
	public void pokervoucherON(){
		//objWrapperFunctions.pressEnterBtn(pokerON);
	objUtilities.logReporter("Click on Poker Voucher ON", objWrapperFunctions.clickByScript(pokerON), false);
	}
	public void pokervoucherOFF(){
		//objWrapperFunctions.pressEnterBtn(pokerOFF);
		objUtilities.logReporter("Click on Poker Voucher OFF", objWrapperFunctions.clickByScript(pokerOFF), false);
	}
	
	public void functionDepositON(){
	
		objWrapperFunctions.pressEnterBtn(functionDepON);
	
	}
	
	public void functionDepositOFF(){
		//objUtilities.logReporter("Click on sidebar transaction", objWrapperFunctions.click(sideBarTransaction), false);
	objWrapperFunctions.pressEnterBtn(functionDepOFF);
	
	}
	
	public void closeTab()
	{
		objUtilities.logReporter("Click on 'x' ", objWrapperFunctions.click(closeIconTab), false);
	}
	
	void checkPresenceOfText(By locator){
		List<WebElement> list= objWrapperFunctions.getElements(locator);
		Iterator<WebElement> iterator = list.iterator();
		String arrTemp[]=new String[list.size()];
		int i=0;
		while(iterator.hasNext()){
			arrTemp[i]=objWrapperFunctions.getTextOfElement(list.get(i));
					i++;
					System.out.println(arrTemp[i]);
		}
		
		
		
	}

}
