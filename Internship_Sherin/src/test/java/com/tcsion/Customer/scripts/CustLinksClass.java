package com.tcsion.Customer.scripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ictak.utility.Excelutility;
import com.ictak.utility.Logoututility;
import com.tcsion.Base.BaseClass;
import com.tcsion.Customer.pages.CustomerLinks;
import com.tcsion.Customer.pages.CustomerLogin;


public class CustLinksClass extends BaseClass {
	@BeforeTest
	public void verifyCustLogin() throws IOException, InterruptedException
	{
		CustomerLogin objCustomer=new CustomerLogin(driver);
		
		String username=Excelutility.getCellData("custlogin",0, 0);
		String password=Excelutility.getCellData("custlogin",0, 1);
		
		
		objCustomer.setCustomerUsername(username);
		objCustomer.setCustomerPassword(password);
		objCustomer.clickLogin();	
		
	   		
	}
	@Test
	public void verifyCustLinks() throws IOException, InterruptedException
	{
		CustomerLinks objlinks=new CustomerLinks(driver);
		objlinks.clickBookings();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
		assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=' waves-effect'][text()=' My Bookings']"))).isDisplayed());
		
		objlinks.clickAddFunds();
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10)); 
		assertTrue(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=' waves-effect'][text()=' Add Funds']"))).isDisplayed());
		
		
         objlinks.clickProfile(); 
         WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(10)); 
         assertTrue(wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=' waves-effect'][text()=' My Profile']"))).isDisplayed());
		
		objlinks.clickLogout();
		WebDriverWait wait3 = new WebDriverWait(driver,Duration.ofSeconds(10)); 
        assertTrue(wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password' and @type='password']"))).isDisplayed());
		
				
	}
	


}
