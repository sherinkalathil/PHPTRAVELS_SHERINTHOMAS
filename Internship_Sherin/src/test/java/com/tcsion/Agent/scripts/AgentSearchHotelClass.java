package com.tcsion.Agent.scripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ictak.utility.Excelutility;
import com.ictak.utility.Logoututility;
import com.tcsion.Agent.pages.AgentLogin;
import com.tcsion.Agent.pages.AgentSearchHotel;
import com.tcsion.Base.BaseClass;

public class AgentSearchHotelClass extends BaseClass{
	
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
	public void VerifySearch() throws IOException, InterruptedException
	{
		AgentSearchHotel obAgentSrch=new AgentSearchHotel(driver);
		String cityName=Excelutility.getCellData("cityname",0, 0);
		System.out.println(cityName);
		obAgentSrch.clickHotel();
		obAgentSrch.clickName();
		obAgentSrch.setName(cityName);
		boolean actual=obAgentSrch.clickSearch();
		System.out.println(actual);
     	assertTrue(actual);
     	obAgentSrch.logout();
     	
     	
	}
	@AfterTest
	public void logout() {
		Logoututility.caLogout();
	}


}
