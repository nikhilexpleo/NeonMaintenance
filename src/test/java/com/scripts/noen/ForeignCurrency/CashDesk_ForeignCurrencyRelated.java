package com.scripts.noen.ForeignCurrency;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import com.generic.BaseTest;
import com.pageFactory.CashierManagerTC.TopNavigation_CashDesk;
import com.pageFactory.desktopReception.login_PF;


public class CashDesk_ForeignCurrencyRelated extends BaseTest
{
	private TopNavigation_CashDesk objTopNavCashDesk;
	private login_PF objlogin_PF;
	
	
	@BeforeClass
	private void setUp(){
		
		initializeWebEnvironment("Neon");
	}
	
	@Test
	public void exchangeAndRedeemForegienCurrency()
	{
		objTopNavCashDesk = new TopNavigation_CashDesk(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();		
		objTopNavCashDesk.exchangeCurrency();
		objTopNavCashDesk.redeemCurrency();
		objlogin_PF.logout();	
	}
// Closing the browser
	@AfterClass
	private void tearDown() 
	{
	tearDownWebEnvironment();
	objlogin_PF = null;
	objTopNavCashDesk = null;
	}
}
