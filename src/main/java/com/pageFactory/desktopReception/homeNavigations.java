package com.pageFactory.desktopReception;

import org.openqa.selenium.By;
import com.generic.Pojo;
import com.generic.Utilities;
import com.generic.WrapperFunctions;

public class homeNavigations
{
	private Utilities objUtilities;
	private WrapperFunctions objWrapperFunctions;
	
	public homeNavigations(Pojo pojo){
		objUtilities = pojo.getObjUtilities();
		objWrapperFunctions = pojo.getObjWrapperFunctions();
	}
	
	By transactionTab=By.xpath("//a[@href='#Sidebar_PassTransactions_Sidebar']///span//span[@class='ig-icon-text'][contains(.,'Transactions')]");	
	
	/**
	 * Select option from task side bar
	 * @param option - Option from task sidebar
	 */
	public void navigateToTaskSideBar(String option)
	{
		By lnkTask = By.xpath("//a[@aria-controls='Sidebar_Tasks_Sidebar']/span/span[contains(text(),'Tasks')]");
		objUtilities.logReporter("Select tasks sidebar", option ,
				objWrapperFunctions.click(lnkTask), false);

		By lnkTaskSideber = By.xpath("//div[@id='Sidebar_Tasks_Sidebar']"
				+ "/ul[@class='list-unstyled']/li/a[contains(text(),'" + option +"')]");
		objUtilities.logReporter("Select option from task sidebar", option ,
				objWrapperFunctions.click(lnkTaskSideber), false);
	}

	/**
	 * Select option from Views sidebar
	 * @param option - Option from Views sidebar
	 */
	public void navigateToViewsSideBar(String option)
	{
		By lnkViews = By.xpath("//a[@aria-controls='Sidebar_Views_Sidebar']/span/span[contains(text(),'Views')]");
		objUtilities.logReporter("Select Views sidebar", option ,
				objWrapperFunctions.click(lnkViews), false);

		By lnkViewsSideber = By.xpath("//div[@id='Sidebar_Views_Sidebar']"
				+ "/ul[@class='list-unstyled']/li/a[contains(text(),'" + option +"')]");
		objUtilities.logReporter("Select option from views sidebar", option ,
				objWrapperFunctions.click(lnkViewsSideber), false);
	}

	/**
	 * Select option from Transactions sidebar
	 * @param option - Option from Transactions sidebar
	 */
	public void navigateToTransactionsSideBar(String option)
	{
		By lnkTransactions = By.xpath("//a[@aria-controls='Sidebar_PassTransactions_Sidebar']/span/span[contains(text(),'Transactions')]");
		objUtilities.logReporter("Select Transactions sidebar", option ,
				objWrapperFunctions.click(lnkTransactions), false);

		By lnkTransactionsSideber = By.xpath("//div[@id='Sidebar_PassTransactions_Sidebar']"
				+ "/ul[@class='list-unstyled']/li/a[contains(text(),'" + option +"')]");
		objUtilities.logReporter("Select option from Transactions sidebar", option ,
				objWrapperFunctions.click(lnkTransactionsSideber), false);
	}
}
