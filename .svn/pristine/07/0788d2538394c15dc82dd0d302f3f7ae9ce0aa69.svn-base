package com.pageFactory.desktopReception;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class cashier_AssetEntry_PF {
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	WebDriver webdriver;
	Properties objConfig=new Properties();
	static String custNumber="",user="",message="",temp="",refId_FE="",qtytxt,valuetxt;
	static int tempRandom,expiry_days,expiry_month,expiry_year ;


	public cashier_AssetEntry_PF(Pojo pojo)
	{
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
		custNumber=pojo.getUser();	
	}


	private By viewTab=By.xpath("//li[@id='View_Menu']//a[contains(.,'View')]");
	private By balanceTab=By.xpath("//a[@id='View_Balance_Menu'][contains(.,'Balance')]");

	private By closing_cash_viewButton=By.xpath("//table[@class='datagrid']//tbody//tr[11]//td[4]//button");

	private By closing_chips_viewButton=By.xpath("//table[@class='datagrid']//tbody//tr[12]//td[4]//button");

	private By balance_closing_chips_floatType=By.xpath("//select[@id='dropDownFloatType']");
	private By balance_closing_chips_floatType_freeBet=By.xpath("//select[@id='dropDownFloatType']//option[contains(.,'8.FREE BET CHIPS')]");

	private By viewOnBalacePage=By.cssSelector("div#tblBalancing table tbody tr td button.btn-primary.btn-secured");
	private By saveButton=By.xpath("//button[@class='btn-primary btn-secured'][contains(.,'Save')]");

	private By refreshBalanceButton=By.xpath("//button[@class='btn-primary btn-secured'][contains(.,'Refresh Balance')]");

	private By sterling=By.xpath("//tfoot//tr//td[1]");
	private By totalQty=By.xpath("//tfoot//tr//td[2]//column-conditional-summary//span");
	private By totalValue=By.xpath("//tfoot//tr//td[3]//column-conditional-summary//span");

	private By assetColumn=By.xpath("//table[@class='grid datagrid dataentry']//tbody//tr[3]//td[1]//span");;
	private By quantityColumn=By.xpath("//table[@class='grid datagrid dataentry']//tbody//tr[3]//td[2]//column-input//input");;
	private By valueColumn=By.xpath("//table[@class='grid datagrid dataentry']//tbody//tr[3]//td[3]//column-input//input");

	private By closeIconTab=By.xpath("//button[@accesskey='x']");

	private By save = By.xpath("//button[@accesskey='s']");
	public void addChipsQty()
	{

		//	assetColumn=By.xpath("//table[@class='grid datagrid dataentry']//tbody//tr[3]//td[1]//span");
		String asset=objWrapperFunctions.getText(assetColumn);
		//quantityColumn=By.xpath("//table[@class='grid datagrid dataentry']//tbody//tr[3]//td[2]//column-input//input");


		//	String sterlingtxt=objWrapperFunctions.getText(sterling);
		qtytxt=objWrapperFunctions.getText(totalQty);
		valuetxt=objWrapperFunctions.getText(totalValue);

		System.out.println( qtytxt + " " +valuetxt);
		String prevQuantity = objWrapperFunctions.getAttributeValue(quantityColumn, "value");
		String preValue=objWrapperFunctions.getAttributeValue(valueColumn,"value"); 	
		String sterlingtxt=objWrapperFunctions.getText(sterling);
		System.out.println("Before Quantity of " +sterlingtxt + " Asset = " + prevQuantity );

		System.out.println(" Before Value of " +sterlingtxt+ " Asset = " + preValue );

		objUtilities.logReporter("Enter quantity ",objWrapperFunctions.setText(quantityColumn, "20"), false);
		String quantity=objWrapperFunctions.getAttributeValue(quantityColumn,"value");

		//valueColumn=By.xpath("//table[@class='grid datagrid dataentry']//tbody//tr[3]//td[3]//column-input//input");
		String value=objWrapperFunctions.getAttributeValue(valueColumn,"value"); 	
		System.out.println("Asset = "+ asset +" Quantity = " + quantity +" Value = " + value);

		//float beforeTotalQuanty = Float.parseFloat(qtytxt)- Float.parseFloat(prevQuantity);
		//float beforeTotalValue =  Float.parseFloat(valuetxt) -Float.parseFloat(prevQuantity);


		//	float TotalQuanty =beforeTotalQuanty + Integer.parseInt(quantity);

		//	float TotalValue =  beforeTotalValue + Integer.parseInt(value);

		sterlingtxt=objWrapperFunctions.getText(sterling);
		String qtytxt=objWrapperFunctions.getText(totalQty);
		String valuetxt=objWrapperFunctions.getText(totalValue);		
		System.out.println(sterlingtxt);
		System.out.println( qtytxt + " " +valuetxt);
		/*	if(qtytxt.contentEquals(String.valueOf(TotalQuanty)))
		{
			System.out.println(" Total Quantity = " + qtytxt );
		}

		if(valuetxt.contentEquals(String.valueOf(TotalValue)))
		{
			System.out.println(" Total Value = " + valuetxt );
		}*/

	}

	public void navigateToBalanceTab()
	{
		objWrapperFunctions.waitForElementPresence(viewTab);
		objWrapperFunctions.waitForElementToBeClickable(viewTab);
		objUtilities.logReporter("Click on view Tab", objWrapperFunctions.click(viewTab), false);	
		objWrapperFunctions.waitForElementPresence(balanceTab);
		objWrapperFunctions.waitForElementToBeClickable(balanceTab);
		objUtilities.logReporter("Click on Balance Tab", objWrapperFunctions.click(balanceTab), false);		

	}
	public void closeTab()
	{
		objWrapperFunctions.waitForElementToBeClickable(closeIconTab);
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);
	}
	
	public void close()
	{
		objWrapperFunctions.waitForElementToBeClickable(closeIconTab);
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);
		
	}
	public void setAssentEntryForClosingCash()
	{
		objUtilities.logReporter("Click on view button", objWrapperFunctions.click(closing_cash_viewButton), false);
		objUtilities.logReporter("select float type ", objWrapperFunctions.click(balance_closing_chips_floatType), false);
		objUtilities.logReporter("Click on view button", objWrapperFunctions.click(balance_closing_chips_floatType_freeBet), false);
		//objUtilities.logReporter("select float type ", objWrapperFunctions.selectDropDownByIndex(balance_closing_chips_floatType,8), false);
		try {
			Thread.sleep(10000);
			addChipsQty();
			objUtilities.logReporter("Click on save button", objWrapperFunctions.click(saveButton), false);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void verifyBalance()
	{
		navigateToBalanceTab();
		objUtilities.logReporter("Click on RefreshBalance Button ", objWrapperFunctions.click(refreshBalanceButton), false);


	}
}
