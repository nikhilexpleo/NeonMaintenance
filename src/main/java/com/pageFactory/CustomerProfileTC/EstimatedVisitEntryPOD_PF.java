package com.pageFactory.CustomerProfileTC;

import java.util.Properties;

import org.openqa.selenium.By;

import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class EstimatedVisitEntryPOD_PF {
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	Properties objConfig=new Properties();
	static String custNumber="",user="",gamingDate,gamingDateText;

	public EstimatedVisitEntryPOD_PF(Pojo pojo)
	{
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
		pojo.getObjConfig();
		custNumber=pojo.getUser();	
	}
	private By EstimatedVisitEntry_gamingDateInput = By.xpath("//input[@id='dateTimeGamingDate']");
	private By EstimatedVisitEntry_gamingDate =By.xpath("//li[@id='cashDeskDate']");
	private By EstimatedVisitEntry_hoursLabel =By.xpath("//th[@data-grid-column-key='Hour']");
	private By EstimatedVisitEntry_VisitsLabel =By.xpath("//th[@data-grid-column-key='Visits']");
	private By EstimatedVisitEntry_LeaversLabel =By.xpath("//th[@data-grid-column-key='Leavers']");
	private By EstimatedVisitEntry_Visits = By.xpath("//input[@name='item[0].Visits']");
	private By EstimatedVisitEntry = By.xpath("//a[@id='CustomerManagement_EstimatedVisits_Menu'][contains(.,'Estimated Visits Entry')]");
	private By closeIconTab=By.xpath("//div[@class='buttonbar']//div//button[@accesskey='x']");

	public void getGamingDate()
	{
		objUtilities.logReporter("verify EstimatedVisitEntry_gamingDate label", objWrapperFunctions.verifyIsElementPresent(EstimatedVisitEntry_gamingDate), false);
		gamingDate = objWrapperFunctions.getText(EstimatedVisitEntry_gamingDate);
		System.out.println("date : = " +gamingDate);
	}

	public void getGamingDateInput()
	{
		objUtilities.logReporter("verify EstimatedVisitEntry_gamingDateInput label", objWrapperFunctions.verifyIsElementPresent(EstimatedVisitEntry_gamingDateInput), false);
		gamingDateText = objWrapperFunctions.getAttributeValue(EstimatedVisitEntry_gamingDateInput, "value");
	}

	public void setGamingDate()
	{
		getGamingDate();
		objUtilities.logReporter("set EstimatedVisitEntry_gamingDateInput label",
				objWrapperFunctions.setText(EstimatedVisitEntry_gamingDateInput,gamingDate), false);

	}

	public void setVisits()
	{
		objUtilities.logReporter("set EstimatedVisitEntry_gamingDateInput label",
				objWrapperFunctions.setText(EstimatedVisitEntry_Visits,"4"), false);

	}

	public void navigateToEstimatedVisitEntry()
	{
		objWrapperFunctions.waitForElementPresence(EstimatedVisitEntry);
		objWrapperFunctions.waitForElementToBeClickable(EstimatedVisitEntry);
		objUtilities.logReporter("click on EstimatedVisitEntry",
				objWrapperFunctions.click(EstimatedVisitEntry), false);		
	}

	public void verifyHoursLabel()
	{
		objUtilities.logReporter("verify  EstimatedVisitEntry_hours label", objWrapperFunctions.verifyIsElementPresent(EstimatedVisitEntry_hoursLabel), false);
	}

	public void verifyVisitsLabel()
	{
		objUtilities.logReporter("verify  EstimatedVisitEntry_VisitsLabel ", objWrapperFunctions.verifyIsElementPresent(EstimatedVisitEntry_VisitsLabel), false);
	}
	public void verifyLeaversLabel()
	{
		objUtilities.logReporter("verify  EstimatedVisitEntry_Leavers label", objWrapperFunctions.verifyIsElementPresent(EstimatedVisitEntry_LeaversLabel), false);
	}
	public void closeTab()
	{
		objWrapperFunctions.waitForElementPresence(closeIconTab);
		objWrapperFunctions.waitForElementToBeClickable(closeIconTab);
		objUtilities.logReporter("Click on X ", objWrapperFunctions.click(closeIconTab), false);
	}
}
