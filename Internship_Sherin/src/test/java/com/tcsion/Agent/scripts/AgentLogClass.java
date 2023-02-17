package com.tcsion.Agent.scripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ictak.utility.Excelutility;
import com.ictak.utility.Logoututility;
import com.tcsion.Agent.pages.AgentLogin;
import com.tcsion.Base.BaseClass;
import com.tcsion.Customer.pages.CustomerLogin;



public class AgentLogClass extends BaseClass {
	
	AgentLogin objAgent;
	
	 @BeforeMethod
	 public void login() {
		 objAgent=new AgentLogin(driver); 
	 }
	
	@Test(priority=1)
	public void verifyinvalid1AgentLogin() throws IOException, InterruptedException
	{
		
		
		String username=Excelutility.getCellData("agentlogin",1, 0);
		String password=Excelutility.getCellData("agentlogin",1, 1);
		
		
		objAgent.setAgentUsername(username);
		objAgent.setAgentPassword(password);
		objAgent.clickAgentLogin();
		
				
	}
	@Test(priority=2)
	public void verifyinvalid2AgentLogin() throws IOException, InterruptedException
	{
		
		
		String username=Excelutility.getCellData("agentlogin",2, 0);
		String password=Excelutility.getCellData("agentlogin",2, 1);
		
		
		objAgent.setAgentUsername(username);
		objAgent.setAgentPassword(password);
		objAgent.clickAgentLogin();
			
				
	}
	//@Test(priority=3)
//	public void verifyinvalid3AgentLogin() throws IOException, InterruptedException
//	{
//		//CustomerLogin objCustomer=new CustomerLogin(driver);
//		
//		String username=Excelutility.getCellData("agentlogin",3, 0);
//		String password=Excelutility.getCellData("agentlogin",3, 1);
//		
//		
//		objAgent.setAgentUsername(username);
//		objAgent.setAgentPassword(password);
//		objAgent.clickAgentLogin();
//			
//				
//	}
	@Test(priority=4)
	public void verifyAgentLogin() throws IOException, InterruptedException
	{
		//CustomerLogin objCustomer=new CustomerLogin(driver);
		
		String username=Excelutility.getCellData("agentlogin",0, 0);
		String password=Excelutility.getCellData("agentlogin",0, 1);
		
		
		objAgent.setAgentUsername(username);
		objAgent.setAgentPassword(password);
		objAgent.clickAgentLogin();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(80));   
		assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=' waves-effect'][text()=' My Bookings']"))).isDisplayed());
		
		Logoututility.caLogout();
				
	}
	
		 
		


}
 


