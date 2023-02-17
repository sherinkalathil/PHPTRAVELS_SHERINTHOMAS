package com.tcsion.Agent.scripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ictak.utility.Excelutility;
import com.tcsion.Agent.pages.AgentLinks;
import com.tcsion.Agent.pages.AgentLogin;
import com.tcsion.Base.BaseClass;


public class AgentLinksClass extends BaseClass {
	@BeforeTest
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
	public void verifyAgentLinks() throws IOException, InterruptedException
	{
		AgentLinks objlinks=new AgentLinks(driver);
		
objlinks.clickAgentBookings();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
		assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=' waves-effect'][text()=' My Bookings']"))).isDisplayed());
		
		objlinks.clickAgentAddFunds();
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10)); 
		assertTrue(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=' waves-effect'][text()=' Add Funds']"))).isDisplayed());
		
		
         objlinks.clickAgentProfile(); 
         WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(10)); 
         assertTrue(wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=' waves-effect'][text()=' My Profile']"))).isDisplayed());
		
		objlinks.clickAgentLogout();
		WebDriverWait wait3 = new WebDriverWait(driver,Duration.ofSeconds(10)); 
        assertTrue(wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password' and @type='password']"))).isDisplayed());
		
				
		
	}



}
