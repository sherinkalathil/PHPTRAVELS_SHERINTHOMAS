package com.tcsion.Agent.scripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ictak.utility.Excelutility;
import com.ictak.utility.Logoututility;
import com.tcsion.Agent.pages.AgentLogin;
import com.tcsion.Agent.pages.AgentTopLinks;
import com.tcsion.Base.BaseClass;


public class AgentTopLinkClass extends BaseClass {
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
	public void verifyAgentTopLinks() throws IOException, InterruptedException
	{
		AgentTopLinks objlinks=new AgentTopLinks(driver);
		objlinks.clickAgentBlog();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
		assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='PHPTRAVELS Blog']"))).isDisplayed());
		objlinks.clickAgentHotel();
		assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='SEARCH FOR BEST HOTELS']"))).isDisplayed());
		objlinks.clickAgentOffer();
		assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='PHPTRAVELS Offers']"))).isDisplayed());
		objlinks.clickAgentTour();
		assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Find the best tours packages']"))).isDisplayed());
		objlinks.clickAgentFlight();
		assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='SEARCH FOR BEST FLIGHTS']"))).isDisplayed());
		objlinks.clickAgentVisa();
		assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Submit Your Visa Today!']"))).isDisplayed());
		objlinks.logout();
		
		
	
		
	}


}
