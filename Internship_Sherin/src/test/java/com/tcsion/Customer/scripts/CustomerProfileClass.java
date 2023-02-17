package com.tcsion.Customer.scripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.ictak.utility.Excelutility;
import com.ictak.utility.Logoututility;
import com.tcsion.Base.BaseClass;
import com.tcsion.Customer.pages.CustomerLinks;
import com.tcsion.Customer.pages.CustomerLogin;
import com.tcsion.Customer.pages.CustomerProfile;

public class CustomerProfileClass extends BaseClass {
	
	
	@BeforeMethod
	public void verifyCustLogin() throws IOException, InterruptedException
	{
		CustomerLogin objCustomer=new CustomerLogin(driver);
		
		String username=Excelutility.getCellData("custlogin",0, 0);
		String password=Excelutility.getCellData("custlogin",0, 1);
		
		
		objCustomer.setCustomerUsername(username);
		objCustomer.setCustomerPassword(password);
		objCustomer.clickLogin();		
	   		
	}
	
	
	@Test(priority=1)
	public void verifyCustProfile() throws IOException, InterruptedException
	{
		CustomerProfile objcProfile=new CustomerProfile(driver);
		objcProfile.clickProfile();
		
		String addr1=Excelutility.getCellData("custprofile",0, 0);
		String addr2=Excelutility.getCellData("custprofile",1, 0);
		objcProfile.setCustAddr1(addr1);
	    objcProfile.setCustAddr2(addr2);
		boolean a=objcProfile.clickUpdate();
		assertTrue(a);
				
	}
	@AfterMethod
	public void logout() {
		Logoututility.caLogout();
	}
}

