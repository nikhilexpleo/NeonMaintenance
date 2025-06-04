package com.pageFactory.desktopReception;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class chipsAddRemove_PF {
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	String custNumber="",machineName="",message="";
	//String NeonUser,NeonPass;
	double sum=0.0;
	static String refId_FE="";
	
	public chipsAddRemove_PF(Pojo pojo){
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();	
		custNumber=pojo.getUser();
	}
	
	private By transactionTab=By.xpath("//li//a//span//span[@class='ig-icon-text'][contains(.,'Transactions')]");	
	private By chipsAddedTab=By.xpath("//div[@id='Sidebar_PassTransactions_Sidebar']//li//a[contains(.,'Chips Added')]");

	private By chipsRemovedTab=By.xpath("//div[@id='Sidebar_PassTransactions_Sidebar']//li//a[contains(.,'Chips Removed')]");
	private By sterling=By.xpath("//tfoot//tr//td[1]");
	private By totalQty=By.xpath("//tfoot//tr//td[2]");
	private By totalValue=By.xpath("//tfoot//tr//td[3]");

	private By commentTextBox=By.xpath("//textarea[@id='Comment']");
	private By saveButton=By.xpath("//button[@class='btn-primary btn-secured'][contains(.,'Save')]");	
	private By accountText=By.xpath("//div//span[@class='readonlytext']");
	private By okBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'OK')]");
	private By yesBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'Yes')]");
	private By newBtn=By.xpath("//button[@class='btn-primary btn-secured'][contains(.,'New')]");
	private By closeIconTab=By.xpath("//button[@accesskey='x']");
	
	
	private By assetColumn;
	private By quantityColumn;
	private By valueColumn;


	public void navigateToChipAddedTab()
	{
		objUtilities.logReporter("Click on transaction Tab", objWrapperFunctions.click(transactionTab), false);		
		objWrapperFunctions.scrollTab(chipsAddedTab);
		objWrapperFunctions.waitForElementPresence(accountText);
		String accounttxt=objWrapperFunctions.getText(accountText);
		System.out.println("chips added for tables are accounted under " +accounttxt + "account");
		
	}
	
	public void navigateToChipsRemovedTab()
	{
		objUtilities.logReporter("Click on transaction Tab", objWrapperFunctions.click(transactionTab), false);		
		objWrapperFunctions.scrollTab(chipsRemovedTab);
		objWrapperFunctions.waitForElementPresence(accountText);
		String accounttxt=objWrapperFunctions.getText(accountText);
		System.out.println("chips removed from tables is accounted under " +accounttxt + "account");
		
	}
	public void addChipsQty()
	{
	for(int i=1;i<=3;i++)
		{
		assetColumn=By.xpath("//table[@class='grid datagrid dataentry']//tbody//tr["+i+"]//td[1]//span");
		String asset=objWrapperFunctions.getText(assetColumn);
		quantityColumn=By.xpath("//table[@class='grid datagrid dataentry']//tbody//tr["+i+"]//td[2]//column-input//input");
		objUtilities.logReporter("Enter quantity ",objWrapperFunctions.setText(quantityColumn, "1"), false);
		String quantity=objWrapperFunctions.getAttributeValue(quantityColumn,"value");
		valueColumn=By.xpath("//table[@class='grid datagrid dataentry']//tbody//tr["+i+"]//td[3]//column-input//input");
		String value=objWrapperFunctions.getAttributeValue(valueColumn,"value"); 
		
	//	String result = value.replaceAll("\\£","");
		//System.out.println(result);
		//sum=sum + Float.parseFloat(result);
		System.out.println("Asset = "+ asset +" Quantity = " + quantity +" Value = " + value);
		}	
	String sterlingtxt=objWrapperFunctions.getText(sterling);
	String qtytxt=objWrapperFunctions.getText(totalQty);
	String valuetxt=objWrapperFunctions.getText(totalValue);
	//System.out.println("Total Expected value =" +sum);
	System.out.println(sterlingtxt+ " " + qtytxt + "  " +valuetxt);
	}
	



	public void addCommentAndSave()
	{
		
		objUtilities.logReporter("Enter Comment Number", objWrapperFunctions.setText(commentTextBox,"test"), false);
		objUtilities.logReporter("Click on Save", objWrapperFunctions.click(saveButton), false);
		//objWrapperFunctions.waitForElementToBeClickable(yesBtn);
		objUtilities.logReporter("Click on yes Btn", objWrapperFunctions.click(yesBtn), false);
		objUtilities.logReporter("Click on ok button ", objWrapperFunctions.click(okBtn), false);
		objUtilities.logReporter("verify new button", objWrapperFunctions.verifyIsElementPresent(newBtn),false);
		//objUtilities.logReporter("Click on New ", objWrapperFunctions.click(newBtn), false);
		objUtilities.logReporter("Click on 'x' ", objWrapperFunctions.click(closeIconTab), false);	
	}

}