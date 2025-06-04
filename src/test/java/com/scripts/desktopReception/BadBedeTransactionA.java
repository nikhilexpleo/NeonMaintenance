package com.scripts.desktopReception;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import views.CommonView;

import com.generic.BaseTest;
import com.pageFactory.desktopReception.accountTransactions_PF;
import com.pageFactory.desktopReception.login_PF;

public class BadBedeTransactionA extends BaseTest {
	
	private accountTransactions_PF objaccountTransactions_PF;
	private login_PF objlogin_PF;
	CommonView objCommonView;
	
	@Test
	public void verifyBadBeatJackpotA()
	{
		initializeWebEnvironment("Neon");
		objaccountTransactions_PF= new accountTransactions_PF(this);
		objlogin_PF = new login_PF(this);
		objlogin_PF.login();
		objCommonView = new CommonView(this);
		
		objaccountTransactions_PF.navigateToTranscationATab();
		objCommonView.verifyAccountTypeAndSetAmmount("BAD BEAT JACKPOT B","1","Process Transaction: Bad Beat Jackpot B");
		
		objaccountTransactions_PF.navigateTransationAReversalTab();
		objCommonView.verifyAccountTypeAndSetAmmount("BAD BEAT JACKPOT B","1","Process Transaction: Bad Beat Jackpot B Reversal");
		
		/*objaccountTransactions_PF.navigateToTranscationBTab();
		objaccountTransactions_PF.addAmountAndSave();
		
		objaccountTransactions_PF.navigateTransationBReversalTab();
		objaccountTransactions_PF.addAmountAndSave();
		
		objaccountTransactions_PF.navigateToTranscationCTab();
		objaccountTransactions_PF.addAmountAndSave();
		
		objaccountTransactions_PF.navigateTransationCReversalTab();
		objaccountTransactions_PF.addAmountAndSave();
		*/
		objlogin_PF.logout();	
		//tearDown();
	}
	
		// Closing the browser
	@AfterClass
	private void tearDown() 
	{
		tearDownWebEnvironment();
	
	}
	
}
