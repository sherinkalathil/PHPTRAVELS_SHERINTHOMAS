package com.tcsion.Customer.scripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ictak.utility.Excelutility;
import com.ictak.utility.Logoututility;
import com.tcsion.Base.BaseClass;
import com.tcsion.Customer.pages.CustomerLogin;



public class CustLogClass extends BaseClass {
	CustomerLogin objCustomer;
	@BeforeMethod
	public void login() {
		objCustomer=new CustomerLogin(driver);
	}
	@Test(priority=1)
	public void verifyinvalid1CustLogin() throws IOException, InterruptedException
	{
		
		
		String username=Excelutility.getCellData("custlogin",1, 0);
		String password=Excelutility.getCellData("custlogin",1, 1);
		
		
		objCustomer.setCustomerUsername(username);
		objCustomer.setCustomerPassword(password);
		objCustomer.clickLogin();
			
				
	}
	@Test(priority=2)
	public void verifyinvalid2CustLogin() throws IOException, InterruptedException
	{
	
		
		String username=Excelutility.getCellData("custlogin",2, 0);
		String password=Excelutility.getCellData("custlogin",2, 1);
		
		
		objCustomer.setCustomerUsername(username);
		objCustomer.setCustomerPassword(password);
		objCustomer.clickLogin();
			
				
	}
	@Test(priority=3)
	public void verifyinvalid3CustLogin() throws IOException, InterruptedException
	{
		
		
		String username=Excelutility.getCellData("custlogin",3, 0);
		String password=Excelutility.getCellData("custlogin",3, 1);
		
		
		objCustomer.setCustomerUsername(username);
		objCustomer.setCustomerPassword(password);
		objCustomer.clickLogin();
			
				
	}
	@Test(priority=4)
	public void verifyCustLogin() throws IOException, InterruptedException
	{
		
		
		String username=Excelutility.getCellData("custlogin",0, 0);
		String password=Excelutility.getCellData("custlogin",0, 1);
		
		
		objCustomer.setCustomerUsername(username);
		objCustomer.setCustomerPassword(password);
		objCustomer.clickLogin();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(80));   
		assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=' waves-effect'][text()=' My Bookings']"))).isDisplayed());
		
		//driver.close();
		Logoututility.caLogout();
				
	}	
		


}


