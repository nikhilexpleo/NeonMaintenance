package com.generic;

import io.appium.java_client.AppiumDriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Driver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.RandomStringUtils;

import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;





/**
 * @ScriptName : WrapperFunctions
 * @Description :
 * @Author : Automation Tester (SQS)
 */
public class WrapperFunctions
{
	private WebDriver webDriver;
	private WebDriverWait webDriverWait;
	private WebDriverWait appiumDriverWait;
	private String parentWindow;
	private Properties objConfig;
	String popupHandle;
	String parentHandle;
	Set<String> windowNames;
	private AppiumDriver<?> appiumDriver;
	Pojo objPojo ;
	Logging objlog= new Logging();
	static int reqIndex=0;

	private int DEFAULT_SLEEP_TIMEOUT = 6;
	private int FLUENTWAIT_WAIT_TIMEOUT = 20;
	private int FLUENTWAIT_WAIT_PULLING_TIMEOUT = 5;
	private int MIN_DEFAULT_SLEEP_TIMEOUT = 1;

	public WrapperFunctions(Pojo pojo)
	{
		webDriver = pojo.getDriver();
		appiumDriver = pojo.getAppiumDriver();
		webDriverWait = pojo.getWebDriverWait();
		appiumDriverWait = pojo.getAppiumDriverWait();
		objConfig = pojo.getObjConfig();
		this.objPojo = pojo;
	}

	/**
	 * @throws Exception 
	 * @Method : navigate to url
	 * @Description : navigate to url
	 * @Author : Automation Tester (SQS)
	 */
	public boolean navigateToURL(String URL) 
	{
		try
		{
			webDriver.get(URL);
			return true;
		} catch (Exception exception)
		{
			//Logging.logEntry("Fail- to Navigate");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : switchToAdditionalTab
	 * @Description : switch to new tab
	 * @param : inputData to veify in URL
	 * @throws Exception 
	 * @Author : Automation Tester (SQS)
	 */
	public boolean switchToAdditionalTab()
	{
		try
		{
			parentWindow = webDriver.getWindowHandle();
			//	Set<String> handles = webDriver.getWindowHandles();
			ArrayList<String> newTab = new ArrayList<String>(webDriver.getWindowHandles());
			webDriver.switchTo().window(newTab.get(0));
			/*for (String windowHandle : handles)
			{
				if (!windowHandle.equals(parentWindow))
				{
					webDriver.switchTo().window(windowHandle;
				}
			}
			 */
			return true;

		} catch (Exception exception)
		{
			//	Logging.logEntry("Fail- to switch additional Tab");
			exception.printStackTrace();
			return false;
		}

	}

	public boolean acceptMultipleAlert(By locator)
	{
		try
		{		
			int count=0;			
			while(checkElementDisplyed(locator))
			{
				pressEnterBtn(locator);
				count++;
			}
			return true;

		} catch (Exception exception)
		{

			//	Logging.logEntry("Fail- to switch additional Tab");
			//exception.printStackTrace();
			return false;
		}



	}


	public boolean switchToAlert()
	{
		try
		{
			Alert simpleAlert = webDriver.switchTo().alert();
			String alertText = simpleAlert.getText();
			System.out.println("Alert text is " + alertText);
			simpleAlert.accept();
			return true;

		} catch (Exception exception)
		{
			//	Logging.logEntry("Fail- to switch additional Tab");
			exception.printStackTrace();
			return false;
		}

	}
	/**
	 * @Method : switchToMainTab
	 * @Description : switch to main tab
	 * @Author : Automation Tester (SQS)
	 */
	public boolean switchToMainTab()
	{
		try
		{
			webDriver.switchTo().window(parentWindow);
			return true;

		} catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}

	}

	/**
	 * @Method : verifyURLContainsText
	 * @Description : go to the previous web page
	 * @param : inputData to veify in URL
	 * @Author : Automation Tester (SQS)
	 */
	public boolean verifyURLContainsText(String inputData)
	{
		try
		{
			if (webDriver.getCurrentUrl().toLowerCase().contains(inputData.toLowerCase()))
			{

				return true;
			} else
			{
				Exception e = new Exception();
				throw e;
			}

		} catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}

	}

	/**
	 * @Method : verifyURLContainsText
	 * @Description : go to the previous web page
	 * @param : inputData to veify in URL
	 * @Author : Automation Tester (SQS)
	 */
	public boolean verifyMobileURLContainsText(String inputData)
	{
		try
		{
			if (appiumDriver.getCurrentUrl().toLowerCase().contains(inputData.toLowerCase()))
			{

				return true;
			} else
			{
				Exception e = new Exception();
				throw e;
			}

		} catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}

	}

	/**
	 * @Method : getPreviouswebpage
	 * @Description : go to the home web page
	 * @Author : Automation Tester (SQS)
	 */
	public void getHomewebpage()
	{
		try
		{
			webDriver.get(objConfig.getProperty("web.Url"));
		} catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}

	/**
	 * @Method : waitForElementPresence
	 * @Description : This is wrapper method wait for element presence
	 * @param : locator - By identification of element
	 * @param : waitInSeconds - wait time
	 * @Author : Automation Tester (SQS)
	 */
	public void waitForElementPresence(By locator)
	{
		try
		{
			webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}

	/**
	 * @Method : waitForMobileElementPresence
	 * @Description : This is wrapper method wait for mobile element presence
	 * @param : locator - By identification of element
	 * @param : waitInSeconds - wait time
	 * @Author : Automation Tester (SQS)
	 */
	public void waitForMobileElementPresence(By locator)
	{
		try
		{
			appiumDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}

	/**
	 * @Method : checkElementExistence
	 * @Description : This is wrapper method to check the existence of any web
	 *              element on the page
	 * @param : locator - By identification of element
	 * @param : waitInSeconds - wait time
	 * @return : - true if element present
	 * @Author : Automation Tester (SQS)
	 */
	public void waitForElementToBeClickable(By locator)
	{
		try
		{
			Thread.sleep(3000);
			webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}

	/**
	 * @Method : waitFormobileElementToBeClickable
	 * @Description : This is wrapper method to check the existence of any
	 *              mobile element on the page
	 * @param : locator - By identification of element
	 * @param : waitInSeconds - wait time
	 * @return : - true if element present
	 * @Author : Automation Tester (SQS)
	 */
	public void waitFormobileElementToBeClickable(By locator)
	{
		try
		{
			appiumDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}

	/**
	 * @Method : checkElementDisplyed
	 * @Description : This is wrapper method to check the existence of any web
	 *              element on the page
	 * @param : locator - By identification of element
	 * @param : waitInSeconds - wait time
	 * @return : - true if element present
	 * @Author : Automation Tester (SQS)
	 */
	public boolean checkElementDisplyed(By locator)
	{
		try
		{	
			webDriver.findElement(locator).isDisplayed();
			System.out.println("locator displayed " +locator);
			return true;

		} catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}
	public boolean checkElementNotDisplyed(By locator)
	{
		try
		{	
			//WebElement webEle = webDriver.findElement(locator);
			if((webDriver.findElement(locator)).isDisplayed()==false)	
				System.out.println("locator does not displayed " +locator);
			return true;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	
	}

	/**
	 * @Method : checkMobileElementDisplyed
	 * @Description : This is wrapper method to check the existence of any
	 *              mobile element on the page
	 * @param : locator - By identification of element
	 * @param : waitInSeconds - wait time
	 * @return : - true if element present
	 * @Author : Automation Tester (SQS)
	 */
	public boolean checkMobileElementDisplyed(By locator)
	{
		try
		{
			return appiumDriver.findElement(locator).isDisplayed();
		} catch (Exception exception)
		{
			return false;
		}
	}

	/**
	 * @Method : verifyNumberOfElementPresent
	 * @Description : This is wrapper method to check number of elemnts by same
	 *              locator
	 * @param : locator - By identification of element
	 * @param : num - number of elements
	 * @return : - true if click successful
	 * @Author : Automation Tester (SQS)
	 */
	public boolean verifyNumberOfElementPresent(By locator, int num)
	{

		try
		{
			List<WebElement> webElement = webDriver.findElements(locator);
			// WebElement webElement = (new WebDriverWait(webDriver, 20))
			// .until(ExpectedConditions.visibilityOfElementLocated(locator));

			if (webElement.size() == num)
			{
				return true;
			} else
			{
				Exception e = new Exception();
				throw e;
			}
			// System.out.println("Clicked "+locator);

		} catch (Exception exception)
		{
			// exception.printStackTrace();
			System.out.println("Not find element:" + " " + locator.toString());
			return false;
		}
	}

	/**
	 * @Method : verifyNumberOfElementPresent
	 * @Description : This is wrapper method to check number of elemnts by same
	 *              locator
	 * @param : locator - By identification of element
	 * @param : num - number of elements
	 * @return : - true if click successful
	 * @Author : Automation Tester (SQS)
	 */
	public boolean verifyNumberOfElementPresent(By locator)
	{

		try
		{
			List<WebElement> webElement = webDriver.findElements(locator);
			// WebElement webElement = (new WebDriverWait(webDriver, 20))
			// .until(ExpectedConditions.visibilityOfElementLocated(locator));

			if (webElement.size() != 0)
			{
				return true;
			} else
			{
				Exception e = new Exception();
				throw e;
			}
			// System.out.println("Clicked "+locator);

		} catch (Exception exception)
		{
			// exception.printStackTrace();
			System.out.println("Not find elements:" + " " + locator.toString());
			return false;
		}
	}

	/**
	 * @Method : verifyNumberOfElementPresent
	 * @Description : This is wrapper method to check number of elemnts by same
	 *              locator
	 * @param : locator - By identification of element
	 * @param : num - number of elements
	 * @return : - true if click successful
	 * @Author : Automation Tester (SQS)
	 */
	public boolean checkMsgInInbox(By locator, String msg)
	{

		try
		{
			String msgtrim = msg.trim();
			List<WebElement> webElement = webDriver.findElements(locator);

			String msg_array[] = new String[10];
			int i = 0;

			for (WebElement webElement2 : webElement)
			{
				msg_array[i] = webElement2.getText();
				System.out.println(msg_array[i].trim() + "#######");
				i++;
			}
			boolean gotmsg = false;
			for (String string : msg_array)
			{
				String msgarr = string.trim();

				if (msgtrim.equalsIgnoreCase(msgarr))
				{
					gotmsg = true;
					break;
				}
			}

			if (gotmsg)
			{
				return true;
			} else
			{
				Exception e = new Exception();
				throw e;
			}

			// System.out.println("Clicked "+locator);
			// return true;
		} catch (Exception exception)
		{
			// exception.printStackTrace();
			System.out.println("Not msg found" + " " + locator.toString());
			return false;
		}
	}

	/**
	 * @Method : verifyNumberOfElementPresent
	 * @Description : This is wrapper method to check number of elemnts by same
	 *              locator
	 * @param : locator - By identification of element
	 * @param : num - number of elements
	 * @return : - true if click successful
	 * @Author : Automation Tester (SQS)
	 */
	public void clickOnMsgElementInInbox(By locator, String msg)
	{

		try
		{
			String msgtrim = msg.trim();
			List<WebElement> webElement = webDriver.findElements(locator);
			// WebElement resultelement=null;

			for (WebElement webElement2 : webElement)
			{
				String temp_msg = webElement2.getText().trim();
				if (temp_msg.equals(msgtrim))
				{

					webElement2.click();
					break;
				}
			}

			// return resultelement;
			// System.out.println("Clicked "+locator);
			// return true;
		} catch (Exception exception)
		{
			// exception.printStackTrace();
			System.out.println("Not msg found" + " " + locator.toString());
		}

	}

	/**
	 * @Method : verifyIsElementPresent
	 * @Description : This is wrapper method to click on web element
	 * @param : locator - By identification of element
	 * @return : - true if click successful
	 * @Author : Automation Tester (SQS)
	 */
	public boolean verifymobileIsElementPresent(By locator)
	{
		waitForMobileElementPresence(locator);

		try
		{
			Thread.sleep(4000);
			WebElement webElement = appiumDriver.findElement(locator);

			if (webElement.isDisplayed())
			{
				return true;
			} else
			{
				Exception e = new Exception();
				throw e;
			}
			// System.out.println("Clicked "+locator);

		} catch (Exception exception)
		{
			// exception.printStackTrace();
			System.out.println("Not find:" + " " + locator.toString());
			return false;
		}
	}

	/**
	 * @Method : verifyIsElementPresent
	 * @Description : This is wrapper method to click on web element
	 * @param : locator - By identification of element
	 * @return : - true if click successful
	 * @Author : Automation Tester (SQS)
	 */
	public boolean verifyIsElementPresent(By locator)
	{
		waitForElementPresence(locator);

		try
		{
			WebElement webElement = webDriver.findElement(locator);
			if (webElement.isDisplayed())
			{
				System.out.println("find :" + locator);
				return true;
			} else
			{
				Exception e = new Exception();
				throw e;
			}

		} catch (Exception exception)
		{
			//System.out.println("Not find :" + locator);
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : verifyElementAbsent
	 * @Description : This is wrapper method verify element is absent
	 * @param : locator - By identification of element
	 * @return : -
	 * @Author : Automation Tester (SQS)
	 */
	public boolean verifyMobileElementAbsent(By locator)
	{

		WebElement webElement =  appiumDriver.findElement(locator);
		if(!(webElement.isDisplayed()))
		{
			System.out.println("Element absent");
			return true;
		}	
		else
		{
			System.out.println("Element present");
			return false;
		}	
	}



	/**
	 * @Method : verifyElementAbsent
	 * @Description : This is wrapper method verify element is absent
	 * @param : locator - By identification of element
	 * @return : -
	 * @Author : Automation Tester (SQS)
	 */
	public boolean verifyElementAbsent(By locator)
	{

		WebElement webElement = webDriver.findElement(locator);
		if(!(webElement.isDisplayed()))
		{
			System.out.println("Element absent");
			return true;
		}	
		else
		{
			System.out.println("Element present");
			return false;
		}	
	}



	/**
	 * @Method : click
	 * @Description : This is wrapper method to click on web element
	 * @param : locator - By identification of element
	 * @return : - true if click successful
	 * @throws Exception 
	 * @Author : Automation Tester (SQS)
	 */
	public boolean click(WebElement webElement) 
	{
		try
		{
			webElement.click();
			return true;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}



	/**
	 * @Method : click
	 * @Description : This is wrapper method to click on web element
	 * @param : locator - By identification of element
	 * @return : - true if click successful
	 * @throws Exception 
	 * @Author : Automation Tester (SQS)
	 */
	public boolean click(By locator) 
	{
		waitForElementPresence(locator);
		WebElement webElement = (new WebDriverWait(webDriver, 30)).until(ExpectedConditions.visibilityOfElementLocated(locator));
		try
		{
			// WebElement webElement = webDriver.findElement(locator);
			webElement.click();
			//System.out.println("Clicked "+locator);
			return true;
		} catch (Exception exception)
		{
			//String aa=exception.printStackTrace();
			//Logging.logEntry("Fail- unable to click"+ System.err);
			exception.printStackTrace();
			return false;
		}
	}


	/**
	 * @Method : click
	 * @Description : This is wrapper method to click on web element
	 * @param : locator - By identification of element
	 * @return : - true if click successful
	 * @throws Exception 
	 * @Author : Automation Tester (SQS)
	 */
	public boolean clear(By locator) 
	{
		waitForElementPresence(locator);
		WebElement webElement = (new WebDriverWait(webDriver, 20)).until(ExpectedConditions.visibilityOfElementLocated(locator));
		try
		{
			// WebElement webElement = webDriver.findElement(locator);
			webElement.clear();

			return true;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}


	/**
	 * @Method : mobileClick
	 * @Description : This is wrapper method to click on mobile element
	 * @param : locator - By identification of element
	 * @return : - true if click successful
	 * @Author : Automation Tester (SQS)
	 */
	public boolean mobileClick(By locator)
	{
		waitForMobileElementPresence(locator);
		try
		{
			WebElement webElement = appiumDriver.findElement(locator);
			webElement.click();
			return true;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : doubleClick
	 * @Description : This is wrapper method used for doubleClick on element
	 * @param : locator - By identification of element
	 * @return : - true if double click successful
	 * @Author : Automation Tester (SQS)
	 */
	public boolean doubleClick(By locator)
	{
		waitForElementPresence(locator);
		try
		{
			WebElement webElement = webDriver.findElement(locator);
			Actions actionBuilder = new Actions(webDriver);
			actionBuilder.doubleClick(webElement).build().perform();
			return true;
		} catch (Exception exception)

		{
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : setText
	 * @Description : This is wrapper method to set text for input element
	 * @param : locator - By identification of element
	 * @param : fieldValue - field value as string
	 * @return : - true if text entered successfully
	 * @Author : Automation Tester (SQS)
	 */
	public boolean setText(By locator, String fieldValue)
	{
		waitForElementPresence(locator);
		try
		{
			WebElement webElement = webDriver.findElement(locator);
			// replace the text
			//webElement.clear();

			webElement.sendKeys("");
			webElement.sendKeys(fieldValue);
			return true;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : mobileSetText
	 * @Description : This is wrapper method to set text for input element
	 * @param : locator - By identification of element
	 * @param : fieldValue - field value as string
	 * @return : - true if text entered successfully
	 * @Author : Automation Tester (SQS)
	 */
	public boolean mobileSetText(By locator, String fieldValue)
	{
		// waitForElementPresence(locator);
		try
		{
			WebElement webElement = appiumDriver.findElement(locator);
			// replace the text
			webElement.clear();
			webElement.sendKeys(fieldValue);
			return true;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : getText
	 * @Description : This is wrapper method to get text form input elements
	 * @param : locator - By identification of element
	 * @param : textBy - get text by value attribute (set textBy as value)/ by
	 *        visible text (set textBy as text)
	 * @return : - text as string
	 * @Author : Automation Tester (SQS)
	 */
	public String getText(By locator, String textBy)
	{
		waitForElementPresence(locator);
		try
		{
			WebElement webElement = webDriver.findElement(locator);
			String strText = "";
			if (textBy.equalsIgnoreCase("value"))
				strText = webElement.getAttribute("value");
			else if (textBy.equalsIgnoreCase("text"))
				strText = webElement.getText();
			return strText;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return null;
		}
	}

	/**
	 * @Method : getText
	 * @Description : This is wrapper method to get text form input elements
	 * @param : locator - By identification of element
	 * @param : textBy - get text by value attribute (set textBy as value)/ by
	 *        visible text (set textBy as text)
	 * @return : - text as string
	 * @Author : Swapnil Mane (SQS)
	 */
	public String getText(By locator)
	{
		waitForElementPresence(locator);
		try
		{
			WebElement webElement = webDriver.findElement(locator);
			String strText = webElement.getText();
			strText.trim();
			return strText;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return null;
		}
	}

	/**
	 * @Method : getText
	 * @Description : This is wrapper method to get text form input elements
	 * @param : locator - By identification of element
	 * @param : textBy - get text by value attribute (set textBy as value)/ by
	 *        visible text (set textBy as text)
	 * @return : - text as string
	 * @Author : Shivani Mahindre (SQS)
	 */
	public String getTextOfElement(WebElement webElement)
	{

		try
		{

			String strText = webElement.getText();
			strText.trim();
			return strText;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return null;
		}
	}


	/**
	 * @Method : getElements
	 * @Description : This is wrapper method to get text form input elements
	 * @param : locator - By identification of element
	 * @param : textBy - get text by value attribute (set textBy as value)/ by
	 *        visible text (set textBy as text)
	 * @return : - text as string
	 * @Author : Shivani Mahindre (SQS)
	 */
	public List<WebElement> getElements(By locator)
	{
		waitForElementPresence(locator);
		try
		{


			List<WebElement> webElement = webDriver.findElements(locator);


			return webElement;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return null;
		}
	}





	/**
	 * @Method : getText
	 * @Description : This is wrapper method to get text form input elements
	 * @param : locator - By identification of element
	 * @param : textBy - get text by value attribute (set textBy as value)/ by
	 *        visible text (set textBy as text)
	 * @return : - text as string
	 * @Author : Swapnil Mane (SQS)
	 */
	public String getmobileText(By locator)
	{
		waitForMobileElementPresence(locator);
		try
		{
			WebElement webElement = appiumDriver.findElement(locator);
			String strText = webElement.getText();
			return strText;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return null;
		}
	}

	public String getPageSource()
	{

		try
		{
			String strText = webDriver.getPageSource();

			return strText;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return null;
		}
	}

	public String getMobilePageSource()
	{

		try
		{
			String strText = appiumDriver.getPageSource();

			return strText;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return null;
		}
	}

	/**
	 * @Method : getBalance value
	 * @Description : This is wrapper method to get text form input elements
	 * @param : locator - By identification of element
	 * @param : textBy - get text by value attribute (set textBy as value)/ by
	 *        visible text (set textBy as text)
	 * @return : - text as string
	 * @Author : Swapnil Mane (SQS)
	 */
	public String getBalance(By locator)
	{
		waitForElementPresence(locator);
		try
		{
			WebElement webElement = webDriver.findElement(locator);
			String strText = webElement.getText();
			strText = strText.replaceAll("[^\\d.]", "");
			System.out.println("Intial balance " + strText);
			return strText;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return null;
		}
	}

	/**
	 * @Method : mobileGetText
	 * @Description : This is wrapper method to get text form input elements
	 * @param : locator - By identification of element
	 * @param : textBy - get text by value attribute (set textBy as value)/ by
	 *        visible text (set textBy as text)
	 * @return : - text as string
	 * @Author : Automation Tester (SQS)
	 */
	public String mobileGetText(By locator, String textBy)
	{
		waitForElementPresence(locator);
		try
		{
			WebElement webElement = appiumDriver.findElement(locator);
			String strText = "";
			if (textBy.equalsIgnoreCase("value"))
				strText = webElement.getAttribute("value");
			else if (textBy.equalsIgnoreCase("text"))
				strText = webElement.getText();
			return strText;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return null;
		}
	}

	/**
	 * @Method : selectCheckBox
	 * @Description : This is wrapper method select/deselect checkbox
	 * @param : locator - By identification of element
	 * @param : status - select/deselect
	 * @Author : Automation Tester (SQS)
	 */
	public boolean selectCheckBox(By locator, boolean status)
	{
		waitForElementPresence(locator);
		try
		{
			WebElement webElement = webDriver.findElement(locator);
			if (webElement.getAttribute("type").equals("checkbox"))
			{
				if ((webElement.isSelected() && !status) || (!webElement.isSelected() && status))
					webElement.click();
				return true;
			} else
				return false;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : isCheckBoxSelected
	 * @Description : This is wrapper checkbox is selected or not
	 * @param : locator - By identification of element
	 * @Author : Automation Tester (SQS)
	 */
	public boolean isCheckBoxSelected(By locator, boolean status)
	{
		waitForElementPresence(locator);
		boolean state = false;
		try
		{
			WebElement webElement = webDriver.findElement(locator);
			if (webElement.getAttribute("type").equals("checkbox"))
				state = webElement.isSelected();

			return state;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : selectRadioButton
	 * @Description : This is wrapper method select/deselect radio button
	 * @param : locator - By identification of element
	 * @param : status - select/deselect
	 * @Author : Automation Tester (SQS)
	 */
	public boolean selectRadioButton(By locator, boolean status)
	{
		waitForElementPresence(locator);
		try
		{
			WebElement webElement = webDriver.findElement(locator);
			if (webElement.getAttribute("type").equals("radio"))
			{
				if ((webElement.isSelected() && !status) || (!webElement.isSelected() && status))
					webElement.click();
				return true;
			} else
				return false;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : isRadioButtonSelected
	 * @Description : This is wrapper RadioButton is selected or not
	 * @param : locator - By identification of element
	 * @Author : Automation Tester (SQS)
	 */
	public boolean isRadioButtonSelected(By locator, boolean status)
	{
		waitForElementPresence(locator);
		boolean state = false;
		try
		{
			WebElement webElement = webDriver.findElement(locator);
			if (webElement.getAttribute("type").equals("radio"))
				state = webElement.isSelected();

			return state;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : mouseHover
	 * @Description : This is wrapper method used for Mouse Hovering to the
	 *              element
	 * @param : locator - By identification of element
	 * @Author : Automation Tester (SQS)
	 */
	public boolean mouseHover(By locator)
	{
		waitForElementPresence(locator);
		try
		{
			WebElement webElement = webDriver.findElement(locator);
			Actions actionBuilder = new Actions(webDriver);
			actionBuilder.moveToElement(webElement).build().perform();
			return true;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : switchToWindowUsingTitle
	 * @Description : This is wrapper method used switch to window using the
	 *              given title
	 * @param : locator - Window title
	 * @Author : Automation Tester (SQS)
	 */
	public boolean switchToWindowUsingTitle(String windowTitle)
	{
		try
		{
			String mainWindowHandle = webDriver.getWindowHandle();
			Set<String> openWindows = webDriver.getWindowHandles();

			if (!openWindows.isEmpty())
			{
				for (String windows : openWindows)
				{
					String window = webDriver.switchTo().window(windows).getTitle();
					if (windowTitle.equals(window))
						return true;
					else
						webDriver.switchTo().window(mainWindowHandle);
				}
			}
			return false;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : switchToFrameUsingIframe_Element
	 * @Description : This method will switch you to the Frame by Frame name
	 * @param : locator - The most common one. You locate your iframe like other
	 *        elements, then pass it into the method
	 *        eg.driver.switchTo().frame(driver
	 *        .findElement(By.xpath(".//iframe[@title='Fill Quote']")))
	 * @Author : Automation Tester (SQS)
	 */
	public void switchToFrameUsingIframe_Element(By locator)
	{
		try
		{
			webDriver.switchTo().defaultContent();
			webDriver.switchTo().frame(webDriver.findElement(locator));
		} catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}

	/**
	 * @Method : switchToMobileFrameUsingIframe_Element
	 * @Description : This method will switch you to the mobile Frame by Frame
	 *              name
	 * @param : locator - The most common one. You locate your iframe like other
	 *        elements, then pass it into the method
	 *        eg.driver.switchTo().frame(driver
	 *        .findElement(By.xpath(".//iframe[@title='Fill Quote']")))
	 * @Author : Automation Tester (SQS)
	 */
	public void switchToMobileFrameUsingIframe_Element(By locator)
	{
		try
		{
			appiumDriver.switchTo().defaultContent();
			appiumDriver.switchTo().frame(appiumDriver.findElement(locator));
		} catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}

	/**
	 * @Method : switchToFrameUsingNameOrId
	 * @Description : This method will switch you to the Frame by Frame name
	 * @param : frameName - Name/Id of frame you want to switch
	 * @Author : Automation Tester (SQS)
	 */
	public void switchToFrameUsingNameOrId(String frameName)
	{
		try
		{
			webDriver.switchTo().defaultContent();
			webDriver.switchTo().frame(frameName);
		} catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}

	/**
	 * @Method : switchToFrameUsingIndex
	 * @Description : This method will switch you to the Frame by Frame name
	 * @param : index - Index on page
	 * @Author : Automation Tester (SQS)
	 */
	public void switchToFrameUsingIndex(int index)
	{
		try
		{
			webDriver.switchTo().defaultContent();
			webDriver.switchTo().frame(index);
		} catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}

	/**
	 * @Method : switchToDefaultContent
	 * @Description : This method will switch you to the default Window
	 * @Author : Automation Tester (SQS)
	 */
	public void switchToDefaultContent()
	{
		webDriver.switchTo().defaultContent();
	}

	/**
	 * @Method : click
	 * @Description : This is wrapper method to click on web element
	 * @param : locator - By identification of element
	 * @return : - true if click successful
	 * @throws Exception 
	 * @Author : Automation Tester (SQS)
	 */
	public int randomNumberBetween(int high,int low) 
	{
		//waitForElementPresence(locator);
		//	WebElement webElement = (new WebDriverWait(webDriver, 20)).until(ExpectedConditions.visibilityOfElementLocated(locator));
		try
		{
			Random r = new Random();
			//	int Low = 10;
			//	int High = 100;
			int Result = r.nextInt(high-low) + low;
			return Result;
		} catch (Exception exception)
		{
			//String aa=exception.printStackTrace();
			//Logging.logEntry("Fail- unable to click"+ System.err);
			exception.printStackTrace();
			return 0;
		}
	}
	/**
	 * @Method : getRandBet
	 * @Description : This method will give you random number between provided
	 *              range
	 * @param : high - higher number
	 * @param : low - lower number
	 * @Author : Automation Tester (SQS)
	 */

	public int getRandBet(int high, int low)
	{
		Random r = new Random();
		int Low = low;
		int High = high;
		int Result = r.nextInt(High - Low) + Low;
		return Result;
	}

	/**
	 * @Method : selectDropDownByIndex
	 * @Description : This is wrapper method select drop down element
	 * @param : locator - By identification of element
	 * @param : index - drop down element (user may specify index)
	 * @Author : Automation Tester (SQS)
	 */
	public boolean selectDropDownByRandomIndex(By locator, int high, int low)
	{
		try
		{
			int index;

			index = getRandBet(high, low);
			boolean blnOptionAvailable = false;
			waitForElementPresence(locator);
			WebElement webElement = webDriver.findElement(locator);
			Select sltDropDown = new Select(webElement);
			sltDropDown.selectByIndex(index);

			// System.out.println(sltDropDown.getFirstSelectedOption()+"####");
			blnOptionAvailable = true;

			// Web elements from dropdown list

			return blnOptionAvailable;

		} catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}



	public boolean selectDropDownByIndex(By locator, int index)
	{
		try
		{

			// index=getRandBet(high, low);
			boolean blnOptionAvailable = false;
			waitForElementPresence(locator);
			WebElement webElement = webDriver.findElement(locator);
			Select sltDropDown = new Select(webElement);
			sltDropDown.selectByIndex(index);

			// System.out.println(sltDropDown.getFirstSelectedOption()+"####");
			blnOptionAvailable = true;

			// Web elements from dropdown list

			return blnOptionAvailable;

		} catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : selectDropDownOption
	 * @Description : This is wrapper method select drop down element
	 * @param : locator - By identification of element
	 * @param : option - drop down element (user may specify text/value/index)
	 * @param : selectType - select dorp down element by Text/Value/Index
	 * @Author : Automation Tester (SQS)
	 */
	public boolean selectDropDownOption(By locator, String option, String... selectType)
	{
		try
		{
			waitForElementPresence(locator);
			WebElement webElement = webDriver.findElement(locator);
			Select sltDropDown = new Select(webElement);

			if (selectType.length > 0 && !selectType[0].equals(""))
			{
				if (selectType[0].equals("Value"))
					sltDropDown.selectByValue(option);
				else if (selectType[0].equals("Text"))
					sltDropDown.selectByVisibleText(option);
				else if (selectType[0].equals("Index"))
					sltDropDown.selectByIndex(Integer.parseInt(option));

				return true;
			} else
			{
				// Web elements from dropdown list
				List<WebElement> options = sltDropDown.getOptions();
				boolean blnOptionAvailable = false;
				int iIndex = 0;
				for (WebElement weOptions : options)
				{
					if (weOptions.getText().trim().equals(option))
					{
						sltDropDown.selectByIndex(iIndex);
						blnOptionAvailable = true;
						break;
					} else
						iIndex++;
				}
				return blnOptionAvailable;
			}
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : verifyDropDownOptionValues
	 * @Description : This is wrapper method select drop down element
	 * @param : locator - By identification of element
	 * @param : option - if want to verify more then one option pass values
	 *        seprated by ';'
	 * @Author : Automation Tester (SQS)
	 */
	public boolean verifyDropDownOptionValues(By locator, String option)
	{
		try
		{
			waitForElementPresence(locator);
			WebElement webElement = webDriver.findElement(locator);
			Select sltDropDown = new Select(webElement);

			// Web elements from dropdown list
			List<WebElement> options = sltDropDown.getOptions();
			boolean blnOptionAvailable = false;
			ArrayList<String> optionsList;

			if (option.contains(";"))
				optionsList = new ArrayList<String>(Arrays.asList(option.trim().split(";")));
			else
			{
				optionsList = new ArrayList<String>();
				optionsList.add(option);
			}

			for (WebElement weOptions : options)
			{
				String optionValue = weOptions.getText().trim();
				if (optionsList.contains(optionValue))
				{
					blnOptionAvailable = true;
					optionsList.remove(optionValue);
					if (optionsList.isEmpty())
						break;
				}
			}
			return blnOptionAvailable;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : getSelectedValueFromDropDown
	 * @Description : This is wrapper method select drop down element
	 * @param : locator - By identification of element
	 * @Author : Automation Tester (SQS)
	 */
	public String getSelectedValueFromDropDown(By locator)
	{
		waitForElementPresence(locator);
		try
		{
			Select selectDorpDown = new Select(webDriver.findElement(locator));
			String selectedDorpDownValue = selectDorpDown.getFirstSelectedOption().getText();
			return selectedDorpDownValue;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return null;
		}
	}

	/**
	 * @Method : selectCheckBoxForSpecificColumn
	 * @Description : This is wrapper method to select chechbox from table with
	 *              respect to particular column content
	 * @param : locator - By identification of element (table with all rows)
	 * @param : columnContent - String column content
	 * @param : Status true - to check the checkbox false - to uncheck the
	 *        checkbox
	 * @columnNumberForRadio : integer column number for radio button
	 * @Author : Automation Tester (SQS)
	 */
	public boolean selectCheckBoxForSpecificColumn(By locator, String columnContent, int columnNumberForCheckBox, boolean Status)
	{
		try
		{
			WebElement weResultTable = webDriver.findElement(locator);
			List<WebElement> weResultRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weResultRows)
			{
				List<WebElement> weColumns = weRow.findElements(By.xpath(".//td"));
				for (WebElement weColumn : weColumns)
				{
					if (weColumn.getText().trim().equals(columnContent))
					{
						By tempLocator = By.xpath(".//td['" + columnNumberForCheckBox + "']/span/input[@type='checkbox']");
						WebElement weCheckbox = weRow.findElement(tempLocator);
						if ((weCheckbox.isSelected() && !Status) || (!weCheckbox.isSelected() && Status))
						{
							weCheckbox.click();
							return true;
						}
					}
				}
			}
			return false;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : verifyTableContent
	 * @Description : it will check given data in whole table
	 * @param : locator - By identification of element (table with all rows)
	 * @param : columnHeader - String column header
	 * @param : ContentToVerify - String Content to be verifyed from excel
	 * @Author : Automation Tester (SQS)
	 */
	public boolean verifyTableContent(By locator, String columnHeader, String ContentToVerify)
	{
		Hashtable<String, String> dataColumnHeader = new Hashtable<String, String>();
		int intColumnNumber = 1;
		boolean blnverify = false;
		try
		{
			waitForElementPresence(locator);
			WebElement weResultTable = webDriver.findElement(locator);

			List<WebElement> weColumnsHeaders = weResultTable.findElements(By.xpath(".//thead/tr/th"));
			for (WebElement weColumnHeader : weColumnsHeaders)
			{
				String strHeader = weColumnHeader.getText().trim();
				if (!strHeader.equals(""))
					dataColumnHeader.put(strHeader, String.valueOf(intColumnNumber));
				intColumnNumber++;
			}

			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows)
			{
				WebElement weExceptedClm = weRow.findElement(By.xpath(".//td[" + dataColumnHeader.get(columnHeader) + "]"));
				if (weExceptedClm.getText().trim().equals(ContentToVerify))
				{
					blnverify = true;
					return blnverify;
				}
			}
			return blnverify;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	public void displayTableContent(By Locator)
	{
		WebElement table =webDriver.findElement(Locator);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		Iterator<WebElement> i = rows.iterator();
		//Print the table. 
		while(i.hasNext()) {
			WebElement row = i.next();
			List<WebElement> columns = row.findElements(By.tagName("td"));
			// System.out.println(columns.size());
			Iterator<WebElement> j = columns.iterator();
			while(j.hasNext()) {
				WebElement column = j.next();
				//Removing blank columns data and add a separator while displaying data.
				if (!column.getText().trim().equals("")){
					System.out.print(column.getText());
					System.out.print(" | ");
				}
			}
			System.out.println("");
			System.out.println("-----------------------------------------------");
		}
	}
	/**
	 * @method : getAttributeValue
	 * @param : locator : By identification of element
	 * @param : AttributeName : Name of attribute Whose value we want
	 * @Author : Automation Tester (SQS)
	 */
	public String getAttributeValue(By locator, String attributeName)
	{
		try
		{
			WebElement webElement = webDriver.findElement(locator);
			return webElement.getAttribute(attributeName);
		} catch (Exception exception)
		{
			return null;
		}
	}

	/**
	 * @method : getTagName
	 * @param : locator
	 * @return : TageName for given locator
	 * @Author : Automation Tester (SQS)
	 * 
	 */
	public String getTagName(By locator)
	{
		WebElement webElement = webDriver.findElement(locator);
		return webElement.getTagName();
	}

	/**
	 * @Method : elementHighlight
	 * @Description : Highlight element
	 * @param : locator - By identification of element
	 * @Author : Automation Tester (SQS)
	 */
	public void elementHighlight(By locator)
	{
		WebElement element = webDriver.findElement(locator);
		for (int i = 0; i < 2; i++)
		{
			JavascriptExecutor js = (JavascriptExecutor) webDriver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: red; border: 3px solid red;");
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		}
	}

	public boolean getBgColor(By locator, String expectedValue)
	{
		try
		{
			waitForElementPresence(locator);
			// color
			String color = webDriver.findElement(locator).getCssValue("background-Color");
			System.out.println("Color " + color);

			String[] numbers = color.replace("rgba(", "").replace(")", "").split(",");
			int r = Integer.parseInt(numbers[0].trim());
			int g = Integer.parseInt(numbers[1].trim());
			int b = Integer.parseInt(numbers[2].trim());
			System.out.println("r: " + r + "g: " + g + "b: " + b);
			String hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
			System.out.println("hex to String format" + hex);

			String actualValue = hex;
			if (actualValue.equals(expectedValue))
			{
				return true;
			}

			else

				return false;
		} catch (Exception ex)
		{
			ex.printStackTrace();
			return false;
		}

	}

	public boolean getFont(By locator, String expectedvalue)
	{
		try
		{
			waitForElementPresence(locator);
			WebElement webElement = webDriver.findElement(locator);

			// color
			String actualValue = webElement.getCssValue("font-family");

			System.out.println("fontFamily" + actualValue);
			if (actualValue.contains(expectedvalue))
			{
				return true;

			} else
				return false;
		} catch (Exception ex)
		{
			ex.printStackTrace();
			return false;
		}

	}

	public boolean getMobileFont(By locator, String expectedvalue)
	{
		try
		{
			waitForMobileElementPresence(locator);
			WebElement webElement = appiumDriver.findElement(locator);

			// color
			String actualValue = webElement.getCssValue("font-family");

			System.out.println("fontFamily" + actualValue);
			if (actualValue.equals(expectedvalue))
			{
				return true;

			} else
				return false;
		} catch (Exception ex)
		{
			ex.printStackTrace();
			return false;
		}

	}

	public boolean getFontColor(By locator, String expectedvalue)
	{
		try
		{
			waitForElementPresence(locator);
			WebElement webElement = webDriver.findElement(locator);

			// color
			String color = webElement.getCssValue("color");

			String[] numbers = color.replace("rgba(", "").replace(")", "").split(",");
			int r = Integer.parseInt(numbers[0].trim());
			int g = Integer.parseInt(numbers[0].trim());
			int b = Integer.parseInt(numbers[0].trim());
			System.out.println("r: " + r + "g: " + g + "b: " + b);
			String hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
			hex = hex.toUpperCase();
			String actualValue = hex;
			if (actualValue.equals(expectedvalue))
			{
				return true;

			} else
				return false;
		} catch (Exception ex)
		{
			ex.printStackTrace();
			return false;
		}

	}

	public boolean footerbgColor(By locator, String expectedValue)
	{
		try
		{
			waitForElementPresence(locator);
			// color
			String color = webDriver.findElement(locator).getCssValue("background-color");
			System.out.println("footer Color " + color);

			String[] numbers = color.replace("rgba(", "").replace(")", "").split(",");
			int r = Integer.parseInt(numbers[0].trim());
			int g = Integer.parseInt(numbers[1].trim());
			int b = Integer.parseInt(numbers[2].trim());
			System.out.println("r: " + r + "g: " + g + "b: " + b);
			String hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
			System.out.println("hex to String format" + hex);

			String actualValue = hex;
			if (actualValue.equals(expectedValue))
			{
				System.out.println("Pass");
				return true;
			} else
				return false;
		} catch (Exception ex)
		{
			ex.printStackTrace();
			return false;
		}

	}

	public boolean footertextColor(By locator, String expectedValue)
	{
		try
		{
			waitForElementPresence(locator);
			// color
			String color = webDriver.findElement(locator).getCssValue("color");
			System.out.println("footer text Color " + color);
			String[] numbers = color.replace("rgba(", "").replace(")", "").split(",");
			int r = Integer.parseInt(numbers[0].trim());
			int g = Integer.parseInt(numbers[0].trim());
			int b = Integer.parseInt(numbers[0].trim());
			System.out.println("r: " + r + "g: " + g + "b: " + b);
			String hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
			hex = hex.toUpperCase();
			System.out.println("String format :" + hex);

			String actualValue = hex;
			if (actualValue.equals(expectedValue))
			{
				System.out.println("Pass");
				return true;
			} else
				return false;
		} catch (Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	public boolean getProperty(By locator)
	{
		try
		{
			waitForElementPresence(locator);
			WebElement webElement = webDriver.findElement(locator);
			// String fontSize = homeButton.getCssValue("font-size");
			// WebElement text = webDriver.findElement((By) webElement);
			String fontSize = webElement.getCssValue("font-size");
			System.out.println("Font Size -> " + fontSize);

			// color
			String color = webDriver.findElement(locator).getCssValue("Color");
			System.out.println("Color" + color);

			System.out.println("-------------" + locator + "----------");
			String fontColor = webElement.getCssValue("color");
			System.out.println("Font Color -> " + fontColor);
			String fontFamily = webElement.getCssValue("font-family");
			System.out.println("Font Family -> " + fontFamily);
			String fonttxtAlign = webElement.getCssValue("text-align");
			System.out.println("Font Text Alignment -> " + fonttxtAlign);
			String position = webElement.getCssValue("Position");
			System.out.println("position -> " + position);
			String bgcolor = webDriver.findElement(locator).getCssValue("background-color");
			System.out.println("bgcolor -> " + bgcolor.toString());

			return true;
		} catch (Exception ex)
		{
			ex.printStackTrace();
			return false;
		}

	}

	public boolean success(By locator)
	{

		waitForElementPresence(locator);
		WebElement webElement = webDriver.findElement(locator);
		String sucessValue = webElement.getText().toString();
		System.out.println("sucessValue " + sucessValue);
		return true;

	}

	public boolean mobileSuccessMessage(By locator)
	{

		waitForElementPresence(locator);
		WebElement webElement = appiumDriver.findElement(locator);
		String sucessValue = webElement.getText().toString();
		System.out.println("sucessValue " + sucessValue);
		return true;

	}

	/**
	 * @Method : getText
	 * @Description : This is wrapper method to get text form input elements
	 * @param : locator - By identification of element
	 * @param : textBy - get text by value attribute (set textBy as value)/ by
	 *        visible text (set textBy as text)
	 * @return : - text as string
	 * @Author : Automation Tester (SQS)
	 */
	public String getText_textBy(By locator, String textBy)
	{
		waitForElementPresence(locator);
		try
		{
			WebElement webElement = webDriver.findElement(locator);
			String strText = "";
			if (textBy.equalsIgnoreCase("value"))
				strText = webElement.getAttribute("value");

			else if (textBy.equalsIgnoreCase("text"))
				strText = webElement.getText();
			return strText;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return null;
		}
	}

	/**
	 * @Method : getElement by Index from List of elements
	 * @Description : This is wrapper method to get text form input elements
	 * @param : locator - By identification of element
	 * @param : textBy - get text by value attribute (set textBy as value)/ by
	 *        visible text (set textBy as text)
	 * @return : - text as string
	 * @Author : Shivani Mahindre (SQS)
	 */
	public WebElement getElementOfIndex(By locator,int index)
	{
		waitForElementPresence(locator);
		try
		{
			List<WebElement> webElement = webDriver.findElements(locator);

			WebElement webEle = webElement.get(index);
			return webEle ;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return null;
		}
	}

	/**
	 * @Method : switchTo child Window
	 * @Description : This is wrapper method used switch to child window
	 * @Author : Swapnil Mane
	 */

	public void switchToChildWindow()
	{
		try
		{
			Thread.sleep(10000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		parentHandle = webDriver.getWindowHandle();
		windowNames = webDriver.getWindowHandles();
		@SuppressWarnings("rawtypes")
		Iterator ite = windowNames.iterator();
		while (ite.hasNext())
		{
			popupHandle = ite.next().toString();
			if (!popupHandle.contains(webDriver.getWindowHandle()))
			{
				webDriver.switchTo().window(popupHandle);
				//	System.out.println("Window :" + webDriver.getTitle().toString());
				break;
			}

		}
	}

	/**
	 * @Method : switchTo mobile child Window
	 * @Description : This is wrapper method used switch to child window
	 * @Author : Swapnil Mane
	 */

	public void switchMobileToChildWindow()
	{
		try
		{
			Thread.sleep(25000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parentHandle = appiumDriver.getWindowHandle();
		windowNames = appiumDriver.getWindowHandles();
		@SuppressWarnings("rawtypes")
		Iterator ite = windowNames.iterator();
		while (ite.hasNext())
		{
			popupHandle = ite.next().toString();
			if (!popupHandle.contains(appiumDriver.getWindowHandle()))
			{
				appiumDriver.switchTo().window(popupHandle);
				System.out.println("window :" + appiumDriver.getTitle().toString());
				break;
			}

		}
	}

	/**
	 * @Method : switchTo parent Window
	 * @Description : This is wrapper method used switch to child window
	 * @Author : Swapnil Mane
	 */
	public void switchMainWindow()
	{
		webDriver.switchTo().window(parentHandle);
		System.out.println("window :" + webDriver.getTitle().toString());
	}

	/**
	 * @Method : switchTo parent Window
	 * @Description : This is wrapper method used switch to child window
	 * @Author : Swapnil Mane
	 */

	public void switchMobileMainWindow()
	{
		appiumDriver.switchTo().window(parentHandle);
		System.out.println("window :" + appiumDriver.getTitle().toString());
	}

	/**
	 * @Method : generateRandomChars
	 * @Description : This is wrapper method used switch to child window
	 * @Author : Swapnil Mane
	 */
	public String generateRandomChars(String candidateChars, int length)
	{
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++)
		{
			sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
		}
		// sb = sb.append("Automation");
		return sb.toString();

	}

	/**
	 * @Method : switchTo parent Window
	 * @Description : This is wrapper method used switch to child window
	 * @Author : Swapnil Mane
	 */
	public String addMonthToCurrentDate(int monthToAdd)
	{
		Calendar now = Calendar.getInstance();
		int date = (now.get(Calendar.DATE));
		String dd = Integer.toString(date);
		int month = (now.get(Calendar.MONTH) + monthToAdd);
		String mm = Integer.toString(month + 1);
		int year = (now.get(Calendar.YEAR));
		String yyyy = Integer.toString(year);
		String dateToSet = dd + "/" + mm + "/" + yyyy;
		return dateToSet;
	}

	/**
	 * @Method : Go to previous page
	 * @Description : This is wrapper method used navigate back
	 * @Author : Swapnil Mane
	 */
	public void navigateToBackPage()
	{
		webDriver.navigate().back();
	}

	/**
	 * @Method : Refresh page
	 * @Description : This is wrapper method used refresh web page
	 * @Author : Swapnil Mane
	 */
	public void refreshPage()
	{
		webDriver.navigate().refresh();
	}

	/**
	 * @Method : Close browsers
	 * @Description : This is wrapper method used refresh web page
	 * @Author : Swapnil Mane
	 */
	public void closeBrowsers()
	{
		webDriver.close();
	}

	/**
	 * @Method : Clcik enter keyboard button
	 * @Description : This is wrapper method used navigate back
	 * @Author : Swapnil Mane
	 */
	public void pressEnterBtn()
	{
		webDriver.findElement(By.id("Value")).sendKeys(Keys.ENTER);
	}

	public void pressEnterBtn(By Locator)
	{
		webDriver.findElement(Locator).sendKeys(Keys.ENTER);


	}

	/**
	 * @Method : Click to TAB keyboard button
	 * @Description : This is wrapper method used navigate back
	 * @Author : Swapnil Mane
	 */
	public void pressTabBtn()
	{
		webDriver.findElement(By.id("Value")).sendKeys(Keys.TAB);
	}


	/**
	 * @Method : Click to TAB keyboard button
	 * @Description : This is wrapper method used navigate back
	 * @Author : Swapnil Mane
	 */
	public void pressTabBtn(By Locator)
	{
		webDriver.findElement(Locator).sendKeys(Keys.TAB);
	}

	/**
	 * @Method : Click to TAB keyboard button
	 * @Description : This is wrapper method used navigate back
	 * @Author : Swapnil Mane
	 */
	public void pressSpaceBtn()
	{
		webDriver.findElement(By.id("Value")).sendKeys(Keys.SPACE);
	}
	public void pressSpaceBtn(By Locator)
	{
		webDriver.findElement(Locator).sendKeys(Keys.SPACE);
	}

	public void pressALTF()
	{

		try{
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_F);
			robot.keyRelease(KeyEvent.VK_ALT);
			robot.keyRelease(KeyEvent.VK_F);        
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}	

	public void pressSpace()
	{
		try
		{
			Thread.sleep(2000);
			webDriver.findElement(By.id("Value")).sendKeys(Keys.ENTER);

		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean emailValidation(String email)
	{
		String emailregex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		if (email.matches(emailregex))
		{
			return true;
		} else
		{
			return false;
		}
	}

	public boolean phoneNoValidation(String phoneNo)
	{
		String phoneRegEx = "^((0|44)\\d{10})$";
		if (phoneNo.matches(phoneRegEx))
		{
			return true;
		} else
		{
			return false;
		}
	}



	public String getName()
	{
		//String name = "AUTO" + generateRandomChars("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 3);
		String name = generateRandomChars("ABCDEFGHIJKLMNOPQRSTUVWXYZ",5);
		return name;
	}

	/**
	 * @method : getMobileAttributeValue
	 * @param : locator : By identification of element
	 * @param : AttributeName : Name of attribute Whose value we want
	 * @Author : Automation Tester (SQS)
	 */
	public String getMobileAttributeValue(By locator, String attributeName)
	{
		try
		{
			waitForMobileElementPresence(locator);
			WebElement webElement = appiumDriver.findElement(locator);
			return webElement.getAttribute(attributeName);
		} catch (Exception exception)
		{
			return null;
		}
	}

	public void selectElementDropDownLocatorSearch(By locator)
	{
		// Get all of the options
		List<WebElement> options = webDriver.findElements(locator);
		// Loop through the options and select the one that matches
		for (WebElement opt : options) {
			if (opt.getText().equals(options)) {
				opt.click();
				System.out.println("options available\n"+options.toString());
				return;
			}
		}
		throw new NoSuchElementException("Can't find " + options + " in dropdown");	
	}

	public boolean  isEnabled (By locator)
	{
		try
		{waitForElementPresence(locator);
		boolean webElement = webDriver.findElement(locator).isEnabled();

		if(webElement==true)
		{
			System.out.println("Pass");
			return true;
		}
		else if(webElement==false)
		{
			System.out.println("Element not clickable");

		}
		return false;
		}catch (Exception exception)
		{
			return false;
		}
	}

	public boolean clickElement(By locator) 
	{
		waitForElementPresence(locator);
		WebElement webElement = (new WebDriverWait(webDriver, 20)).until(ExpectedConditions.visibilityOfElementLocated(locator));

		try
		{
			JavascriptExecutor js = (JavascriptExecutor)webDriver; 
			js.executeScript("arguments[0].click();",webElement);  	
			return true;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}


	public String getRandomDate()
	{
		Long max =0L;
		Long min =300000000000L;
		//Use the date format that best suites you
		SimpleDateFormat spf = new SimpleDateFormat("ddMMyyyy");
		Random r = new Random();
		Long randomLong=(r.nextLong() % (max - min)) + min;
		Date dt =new Date(randomLong);
		return spf.format(dt);
	}

	public String getFormatedDate(String date, String originalDateFormat, String expectedDateFormat)
	{
		try
		{
			DateFormat inputFormatter = new SimpleDateFormat(originalDateFormat);
			Date originalDate = inputFormatter.parse(date);
			DateFormat outputFormatter = new SimpleDateFormat(expectedDateFormat);
			String expectedDate = outputFormatter.format(originalDate);
			return expectedDate;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return null;
		}
	}


	public String getRandomNumber()
	{
		int aNumber = 0; 
		aNumber = (int)((Math.random() * 90000000)+1000000); 
		String number=String.valueOf(aNumber);
		return number;
	}
	public void displayAllElement(By locator)
	{
		waitForElementPresence(locator);		
		List<WebElement>allElements=webDriver.findElements(locator);
		for (WebElement element:allElements) 
		{
			String temp=element.getText().trim();
			//String temp=element.getAttribute("value");
			//	temp=temp.replaceAll("\\s+","");
			System.out.println(temp);	
		}
	}	

	public void displayAllElement(By locator,By locator1)
	{

		waitForElementPresence(locator);		
		List<WebElement>allElements1=webDriver.findElements(locator);
		List<WebElement>allElements2=webDriver.findElements(locator1);
		//int size=allElements1.size();
		for (WebElement element:allElements2) 
		{
			//String temp=element.getText().trim();
			String temp=element.getAttribute("value");
			//	temp=temp.replaceAll("\\s+","");
			System.out.println(temp);	
		}
	}		

	public void saveParamChanges(String temp,String temp1,String bdate) {
		try {
			PropertiesConfiguration config = new PropertiesConfiguration(System.getProperty("user.dir") + "/src/test/resources/config.properties");
			config.setProperty("web.CustomerNumber",temp);
			config.setProperty("web.CustomerName",temp1);
			config.setProperty("web.CustomerDOB",bdate);
			config.save();
			//	System.out.println("Config Property Successfully Updated..");
		}
		catch (Exception e ) {
			e.printStackTrace();
		}
	}

	public void updateDebitNum(String temp) {
		try {
			PropertiesConfiguration config = new PropertiesConfiguration(System.getProperty("user.dir") + "/src/test/resources/config.properties");
			config.setProperty("web.debitCardNumber",temp);
			config.save();
			//	System.out.println("Config Property Successfully Updated..");
		}
		catch (Exception e ) {
			e.printStackTrace();
		}
	}
	public void updateInConfig(String temp,String Key)
	{
		try {
			PropertiesConfiguration config = new PropertiesConfiguration(System.getProperty("user.dir") + "/src/test/resources/config.properties");
			config.setProperty(Key,temp);
			config.save();
			//	System.out.println("Config Property Successfully Updated..");
		}
		catch (Exception e ) {
			e.printStackTrace();
		}
	}
	public void scrollTab(By locator)
	{
		WebElement element = webDriver.findElement(locator);
		JavascriptExecutor je = (JavascriptExecutor) webDriver;
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		element.click();
	}

	public void scrollPage()
	{
		// ((JavascriptExecutor)webDriver).executeScript("scroll(0,800)");
		JavascriptExecutor jse = ((JavascriptExecutor) webDriver);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public int getElementSize(By locator)
	{
		waitForElementPresence(locator);	
		List<WebElement>allElements=webDriver.findElements(locator);
		int rowCount=allElements.size();
		//System.out.println(rowCount);
		return rowCount;

	}


	public boolean clickByScript(By locator){
		try
		{
			WebElement element = webDriver.findElement(locator);

			waitForElementPresence(locator);
			JavascriptExecutor executor = (JavascriptExecutor)webDriver;
			executor.executeScript("arguments[0].click();", element);
			return true;
		} catch (Exception exception)

		{
			exception.printStackTrace();
			return false;
		}
	}

	public boolean clickByScript(WebElement webElement) 
	{
		try
		{
			JavascriptExecutor executor = (JavascriptExecutor)webDriver;
			executor.executeScript("arguments[0].click();", webElement);
			return true;

		} catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	public String randomEmailAddress(String temp,String temp1)
	{
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);  
		//	return temp+randomInt +"@test.com";
		return temp+"."+temp1 +"@gmail.com";

	}
	public String randomTelephoneNumber()
	{
		//	RandomStringUtils r=new RandomStringUtils();
		String randomNumbers = RandomStringUtils.randomNumeric(8);
		/*	String phNo = 0+randomNumbers;*/
		String phNo = "077"+randomNumbers;
		return phNo;
	}
	/**
	 * @Method : getElement text array from List of elements
	 * @Description : This is wrapper method to get text form input elements
	 * @param : locator - By identification of element
	 * @param : textBy - get text by value attribute (set textBy as value)/ by
	 *        visible text (set textBy as text)
	 * @return : - text as string
	 * @Author : Shivani Mahindre (SQS)
	 */
	public String[] getElementTextArray(By locator)
	{
		waitForElementPresence(locator);
		try
		{		
			List<WebElement> webElement = webDriver.findElements(locator);
			String strTextArr[] = new String[webElement.size()];
			int i=0;
			for (WebElement webElement2 : webElement) {
				String temp = webElement2.getText();
				strTextArr[i]=temp;
				i++;
			}


			return strTextArr ;
		} catch (Exception exception)
		{
			exception.printStackTrace();
			return null;
		}
	}


	public String getText(WebElement elementOfIndex) {
		String strText = elementOfIndex.getText();
		strText.trim();
		return strText;

	}


	public void setZoomLevel()
	{
		//	((JavascriptExecutor)webDriver).executeScript("document.body.style.zoom='75%';");
		Robot robot;
		try {
			robot = new Robot();

			//This code causes the zoom level to decrease:
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_MINUS);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setDefaultZoomLevel()
	{
		//switchToDefaultContent();
		//((JavascriptExecutor)webDriver).executeScript("document.body.style.zoom='100%';");
		webDriver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));

		/*Robot robot;
		try {
			robot = new Robot();
			//This code causes the zoom level to decrease:
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_PLUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_PLUS);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	public void searchRecordInInteligenceDBAndDuplicateData(By Locator,By Locator1,By Locator2,By Locator3,String ContentToVerify)
	{
		boolean result = false;
		result = this.verifySpecificElementInInInteligenceDBDuplicateDataTable(Locator, Locator1, Locator2, ContentToVerify);
		if(!result){
			webDriver.findElement(Locator3).click();
			System.out.println("*****NO MATCH");
			this.verifySpecificElementInInInteligenceDBDuplicateDataTable(Locator, Locator1, Locator2, ContentToVerify);
		}


	}


	public boolean verifySpecificElementInInInteligenceDBDuplicateDataTable(By Locator,By Locator1,By Locator2,String ContentToVerify)
	{	
		List<WebElement> elements = webDriver.findElements(Locator);
		System.out.println("size pag = "+elements.size());

		int currentPage = 0; 

		boolean result = false; 

		do{
			result = this.verifyTableContent(Locator1, Locator2, ContentToVerify);
			currentPage++;

			if(!result)
			{
				System.out.println("current page clicked ="+currentPage);	
				elements.get(currentPage).click();
				System.out.println("clicked paginatation");
			}
		}while(!result && currentPage >= elements.size());

		return result;

	}

	public boolean verifyTableContent(By Locator1,By Locator2, String ContentToVerify)
	{
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement weResultTable = webDriver.findElement(Locator1);
		List<WebElement> weResultRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
		int index=0;
		for (WebElement weRow : weResultRows)
		{
			List<WebElement> weColumns = weRow.findElements(By.xpath(".//td"));
			for (WebElement weColumn : weColumns)
			{
				if (weColumn.getText().trim().equals(ContentToVerify))
				{
					System.out.println(index);
					WebElement weMatchBtn = weRow.findElement(Locator2);

					weMatchBtn.click();
					/*JavascriptExecutor executor = (JavascriptExecutor)webDriver;
					executor.executeScript("arguments[0].click();", weMatchBtn);**/
					return true;
				}
				index++;
			}
		}   
		return false;
	}

	public boolean verifyTableHeaders(By locator, String columnHeader){
		//Hashtable<String, String> dataColumnHeader = new Hashtable<String, String>();
		//int intColumnNumber = 1;
		boolean blnverify = false;
		try {

			WebElement weResultTable = webDriver.findElement(locator);
			List<WebElement> weColumnsHeaders = weResultTable.findElements(By.xpath(".//thead/tr"));
			for (WebElement weColumnHeader : weColumnsHeaders) 
			{
				System.out.println(weColumnHeader.toString());
				WebElement weExceptedClm = weColumnHeader.findElement(By.xpath(".//th[contains(text(),'"+columnHeader+"')]"));
				if (this.checkElementDisplayed(weExceptedClm)) {
					blnverify = true;
					return blnverify;
				}
			}

			return blnverify;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	public boolean verifyTableHeaders(By locator,String...headerVerify)
	{
		try{
			boolean blnverify = false;
			WebElement weResultTable = webDriver.findElement(locator);
			List<WebElement> weColumnsHeaders = weResultTable.findElements(By.xpath(".//thead/tr"));
			for (WebElement weColumnHeader : weColumnsHeaders) 
			{

				if(headerVerify != null && headerVerify.length > 0)
				{
					boolean returnVal = false;
					System.out.println(headerVerify.length);
					for(int intHeader = 0 ; intHeader <headerVerify.length ; intHeader++)
					{
						System.out.println(headerVerify +  " " +intHeader);
						System.out.println(weColumnHeader.toString());
						WebElement weExceptedClm = weColumnHeader.findElement(By.xpath(".//th[contains(text(),'"+headerVerify[intHeader]+"')]"));

						System.out.println(" weExceptedClm : " + weExceptedClm);
						System.out.println(" weExceptedClm : " + weExceptedClm.getText());
						//intHeader ++;

						System.out.println(" contentToVerifyFirst : " + headerVerify[intHeader]);

						if(this.checkElementDisplayed(weExceptedClm)) 
						{
							returnVal = true;
							System.out.println("blnverify " +blnverify);
						}
						else
						{
							returnVal = false;
							break;
						}
					}
					return returnVal;
				}
			}
			return blnverify;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}


	public boolean verifyTableContentAgainstToColumn(By locator, String... headerVerify)
	{
		Hashtable<String, String> dataColumnHeader = new Hashtable<String, String>();
		int intColumnNumber = 1;
		boolean blnverify = false;
		try {
			WebElement weResultTable = this.processElement(locator);
			List<WebElement> weColumnsHeaders = weResultTable.findElements(By.xpath(".//thead/tr/th"));
			for (WebElement weColumnHeader : weColumnsHeaders)
			{
				((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", weColumnHeader);
				objPojo.getWaitMethods().sleep(MIN_DEFAULT_SLEEP_TIMEOUT);
				String strHeader = weColumnHeader.getText().trim();
				if (!strHeader.equals(""))
					dataColumnHeader.put(strHeader, String.valueOf(intColumnNumber));
				intColumnNumber++;
			}

			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) 
			{

				if(headerVerify != null && headerVerify.length > 0)
				{
					boolean returnVal = false;
					System.out.println(headerVerify.length);
					for(int intHeader = 0 ; intHeader <headerVerify.length ; intHeader++)
					{
						System.out.println(headerVerify +  " " +intHeader);
						WebElement weExceptedClm = weRow.findElement(By.xpath(".//td[" + dataColumnHeader.get(headerVerify[intHeader])
								+ "]"));

						System.out.println(" weExceptedClm : " + weExceptedClm);
						System.out.println(" weExceptedClm : " + weExceptedClm.getText());
						intHeader ++;

						System.out.println(" contentToVerifyFirst : " + headerVerify[intHeader]);

						if (weExceptedClm.getText().trim().equalsIgnoreCase(headerVerify[intHeader]))
						{
							returnVal = true;
							System.out.println("blnverify " +blnverify);
						}
						else
						{
							returnVal = false;
							break;
						}
					}
					return returnVal;
					//}

				}

			}
			return blnverify;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}

	}

	public WebElement processElement(final By locator)
	{
		System.out.println("Attempt to process selenium web element");
		try{
			Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
					.withTimeout(FLUENTWAIT_WAIT_TIMEOUT, TimeUnit.SECONDS)
					.pollingEvery(FLUENTWAIT_WAIT_PULLING_TIMEOUT, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class)
					.ignoring(InvalidElementStateException.class);

			WebElement webElement = wait.until(new Function<WebDriver, WebElement>(){
				public WebElement apply(WebDriver driver){
					return webDriver.findElement(locator);
				}
			}); 

			return webElement;
		}catch(Exception exception){
			System.out.println("---> Process Elelement --->>Exception");
			//exception.printStackTrace();
			return null;
		} 
	}
	public boolean checkElementDisplayed(WebElement webEle)
	{
		if ((webEle.isDisplayed())) {
			System.out.println("Element displayed");
			return true;
		} else {
			System.out.println("Element not displayed");
			return false;
		}
	}
	public boolean selectDropDownByValue(By locator, String index) {
		try {

			boolean blnOptionAvailable = false;
			waitForElementPresence(locator);
			WebElement webElement = webDriver.findElement(locator);
			Select sltDropDown = new Select(webElement);
			sltDropDown.selectByValue(index);
			blnOptionAvailable = true;
			return blnOptionAvailable;

		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
	public boolean selectDropDownByVisibleText(By locator, String index) {
		try {
			boolean blnOptionAvailable = false;
			waitForElementPresence(locator);
			WebElement webElement = webDriver.findElement(locator);
			Select sltDropDown = new Select(webElement);
			sltDropDown.selectByVisibleText(index);
			blnOptionAvailable = true;
			return blnOptionAvailable;

		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	public boolean deSelectDropDown(By locator) {
		try {
			boolean blnOptionAvailable = false;
			waitForElementPresence(locator);
			WebElement webElement = webDriver.findElement(locator);
			Select sltDropDown = new Select(webElement);
			sltDropDown.deselectAll();
			blnOptionAvailable = true;
			return blnOptionAvailable;

		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}	
}






