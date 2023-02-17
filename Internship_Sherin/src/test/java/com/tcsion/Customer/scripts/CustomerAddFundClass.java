package com.tcsion.Customer.scripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ictak.utility.Excelutility;
import com.ictak.utility.Logoututility;
import com.tcsion.Base.BaseClass;
import com.tcsion.Customer.pages.CustomerAddFunds;
import com.tcsion.Customer.pages.CustomerLinks;
import com.tcsion.Customer.pages.CustomerLogin;


public class CustomerAddFundClass extends BaseClass{
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
@Test(priority=1)
	public void verifyCustLinks() throws IOException, InterruptedException
	{
		CustomerLinks objlinks=new CustomerLinks(driver);
		objlinks.clickAddFunds();

	}
	
	@Test(priority=2)
	public void verifyCustAddFunds() throws IOException, InterruptedException
	{
		CustomerAddFunds objcAddfund=new CustomerAddFunds(driver);
		objcAddfund.clickPaypal();
		objcAddfund.clickPayNow();
		//driver.close();
	}

}
