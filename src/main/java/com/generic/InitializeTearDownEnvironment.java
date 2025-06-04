package com.generic;


import io.appium.java_client.ios.IOSDriver;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class InitializeTearDownEnvironment 
{
	private WebDriver webDriver;
	private IOSDriver<?> iOSDriver;

	/**
	 * @Method		: 	setUpDesktopEnvironment
	 * @Description	:	This method initialize web driver for web application 
	 * 					by opening the browser and URL specified in config.properties file
	 * @Author	    :   Automation Tester (SQS)
	 */
	public WebDriver initializeWebEnvironment(Properties objConfig)
	{
		try 
		{
			String browser = objConfig.getProperty("web.browser").trim().toLowerCase();
			switch (browser)
			{
			case "ie": // If specified browser is Internet Explorer
				System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + objConfig.getProperty("webdriver.ie.driver").trim());
				DesiredCapabilities capabilities = (DesiredCapabilities) DesiredCapabilities.class.getMethod("internetExplorer").invoke(null);
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capabilities.setJavascriptEnabled(true); 
				webDriver = new InternetExplorerDriver(capabilities);
				break;
			case "chrome": // If specified browser is Chrome 
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + objConfig.getProperty("webdriver.chrome.driver").trim());
				webDriver = new ChromeDriver();
				
				break;    
			case "safari": // If specified browser is Safari
				webDriver = new SafariDriver();
				break;

			}

			// Maximize browser
			webDriver.manage().window().maximize();
			webDriver.manage().timeouts().implicitlyWait(Integer.parseInt(objConfig.getProperty("driver.implicitlyWait")), TimeUnit.SECONDS);
			webDriver.manage().timeouts().pageLoadTimeout(Integer.parseInt(objConfig.getProperty("driver.pageLoadTimeout")), TimeUnit.SECONDS);

			return webDriver;
		}
		catch (Exception exception) 
		{
			exception.printStackTrace();
			return null;
		}
	}

	/**
	 * @Method		: tearDownWebEnvironment
	 * @Description	: quit webdriver  
	 * @author	    : Automation Tester (SQS) 
	 */
	public void tearDownWebEnvironment(Properties objConfig)
	{
		try 
		{
			//webDriver.manage().deleteAllCookies();
			webDriver.quit();
			System.out.println("Closing browser ");
			/*for (String handle : webDriver.getWindowHandles())
			{
				webDriver.switchTo().window(handle);
				webDriver.manage().deleteAllCookies();
				webDriver.quit();
				System.out.println("Closing browser again");
			}*/
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			if(objConfig.getProperty("web.browser").equalsIgnoreCase("IE") 
					|| objConfig.getProperty("web.browser").equalsIgnoreCase("Chrome"))
				killBrowserAndDriver(objConfig);
		}		
	}

	/**
	 * @Method		: killBrowserAndDriver
	 * @Description	: this method close the web browser    
	 * @author	    : Automation Tester (SQS)  
	 */
	protected void killBrowserAndDriver(Properties objConfig) 
	{
		String browser = objConfig.getProperty("web.browser").trim();
		String browserProcess = "";
		String driverProcess = ""; 

		if (!browser.equals("") && browser.equalsIgnoreCase("IE")) 
		{
			browserProcess = "iexplore";
			driverProcess = "IEDriverServer.exe";
		}
		else if (!browser.equals("") && browser.equalsIgnoreCase("Chrome")) 
		{
			browserProcess = browser;
			driverProcess = "chromedriver.exe";
		}
		try 
		{
			Process procDriver = Runtime.getRuntime().exec("taskkill /F /T /IM "+ driverProcess);
			Process procIE = Runtime.getRuntime().exec("taskkill /F /T /IM "+ browserProcess + ".exe");
			procDriver.waitFor();
			procIE.waitFor();
		}
		catch (Exception exception) 
		{
			exception.printStackTrace();
		}
	}



	/**
	 * @Method: initializeAndroidEnvironment
	 * @Description:
	 * @author : Automation Tester (SQS)
	 * @CreationDate: @ModifiedDate:
	 */
	public IOSDriver<?> initializeIOSEnvironment(Properties objConfig) {
		try {

			Properties objAppConfig = new Properties();
			objAppConfig.load(new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/resources/mobileResources/" + objConfig.getProperty("test.app.name")
					+ "_config.properties"));

			Properties objMobileConfig = new Properties();
			objMobileConfig.load(new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/resources/mobileResources/" + objConfig.getProperty("test.device") + ".properties"));

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", objMobileConfig.getProperty("device.name"));
			capabilities.setCapability("platformName", objMobileConfig.getProperty("device.platformName"));
			capabilities.setCapability("platformVersion", objMobileConfig.getProperty("device.platformVersion"));
			capabilities.setCapability("udid", objMobileConfig.getProperty("device.udid"));

			capabilities.setCapability("newCommandTimeout", objConfig.getProperty("appium.NewCommandTimeout"));
			iOSDriver = new IOSDriver<>(new URL("http://" + objMobileConfig.getProperty("device.appium.ip").trim()
					+ ":" + objMobileConfig.getProperty("device.appium.port").trim() + "/wd/hub"), capabilities);
			iOSDriver.manage().timeouts()
			.implicitlyWait(Integer.parseInt(objConfig.getProperty("driver.implicitlyWait")), TimeUnit.SECONDS);
			return iOSDriver;
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	/**
	 * @Method : tearDownIOSEnvironment
	 * @Description : quit AndroidDriver
	 * @author : Automation Tester (SQS)
	 */
	public void tearDownIOSEnvironment(Properties objConfig) {
		try {
			iOSDriver.quit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
