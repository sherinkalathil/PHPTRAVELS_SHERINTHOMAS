package com.tcsion.Agent.scripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ictak.utility.Excelutility;
import com.ictak.utility.Logoututility;
import com.tcsion.Agent.pages.AgentCurrency;
import com.tcsion.Agent.pages.AgentLogin;
import com.tcsion.Base.BaseClass;

public class AgentCurrencyClass extends BaseClass{
	@BeforeMethod
	public void verifyAgentLogin() throws IOException, InterruptedException
	{
		AgentLogin objAgent=new AgentLogin(driver);
		
		String username=Excelutility.getCellData("agentlogin",0, 0);
		String password=Excelutility.getCellData("agentlogin",0, 1);
		
		objAgent.setAgentUsername(username);
		objAgent.setAgentPassword(password);
		objAgent.clickAgentLogin();
	   		
	} 
	@Test
	public void changeCurrency() throws InterruptedException
	{
		AgentCurrency obCurrency=new AgentCurrency(driver);
		
		obCurrency.clickUSD();
		String actual=obCurrency.clickINR();
		assertTrue(actual.contains("INR"));
		obCurrency.logout();
		//driver.close();
		
	}
	@AfterMethod
	public void logout()
	{
		Logoututility.caLogout();
	}

}
