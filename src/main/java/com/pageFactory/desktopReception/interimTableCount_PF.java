package com.pageFactory.desktopReception;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class interimTableCount_PF {

	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	String custNumber="",machineName="",message="";
	static String refId_FE="";
	
	public interimTableCount_PF(Pojo pojo){
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();	
		custNumber=pojo.getUser();
	}
	
	private By transactionTab=By.xpath("//li//a//span//span[@class='ig-icon-text'][contains(.,'Transactions')]");	
	private By interimTableCountTab=By.xpath("//div[@id='Sidebar_PassTransactions_Sidebar']//li//a[contains(.,'Interim Table Count')]");
	private By closeIconTab=By.xpath("//div[@class='buttonbar']//div//button");
	
	private By sterling=By.xpath("//tfoot//tr//td[1]");
	private By totalQty=By.xpath("//tfoot//tr//td[2]");
	private By totalValue=By.xpath("//tfoot//tr//td[3]");
	private By headingText=By.xpath("//div[@class='buttonbar']//div//h2");	
	private By commentTextBox=By.xpath("//textarea[@id='Comment']");
	private By saveButton=By.xpath("//button[@class='btn-primary btn-secured'][contains(.,'Save')]");	
	private By accountText=By.xpath("//div//span[@class='readonlytext']");
	private By okBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'OK')]");
	private By yesBtn=By.xpath("//button[@class='btn btn-default'][contains(.,'Yes')]");
	private By newBtn=By.xpath("//button[@class='btn-primary btn-secured'][contains(.,'New')]");
	private By tableDropdown=By.xpath("//div//select[@id='dropDownGamingTable']");
	
	
	private By assetColumn;
	private By quantityColumn;
	private By valueColumn;
	
	public void navigateTointerimTableCountTab()
	{
		objUtilities.logReporter("Click on transaction Tab", objWrapperFunctions.click(transactionTab), false);		
		objWrapperFunctions.scrollTab(interimTableCountTab);
		String text=objWrapperFunctions.getText(headingText);
		System.out.println(text);
	//	objUtilities.logReporter("select sub account", objWrapperFunctions.selectDropDownByRandomIndex(subAccountDropDown, 11, 1), false);
		objUtilities.logReporter("select table", objWrapperFunctions.selectDropDownByIndex(tableDropdown,2), false);
		String subAccount=objWrapperFunctions.getSelectedValueFromDropDown(tableDropdown);
		System.out.println("Table : "+subAccount);
		
	}
	public void addChipsQty()
	{
	for(int i=1;i<=2;i++)
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
		//objUtilities.logReporter("Click on yes Btn", objWrapperFunctions.click(yesBtn), false);
		objUtilities.logReporter("Click on ok button ", objWrapperFunctions.click(okBtn), false);
		
	}
}
