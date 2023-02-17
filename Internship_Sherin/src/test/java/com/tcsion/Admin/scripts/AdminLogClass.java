package com.tcsion.Admin.scripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ictak.utility.Excelutility;
import com.ictak.utility.Logoututility;
import com.tcsion.Admin.pages.AdminLogin;
import com.tcsion.Base.BaseClass;
import com.tcsion.Customer.pages.CustomerLogin;
import com.tcsion.Supplier.pages.SupplierLogin;

public class AdminLogClass extends BaseClass {
	AdminLogin objAdmin;
	@BeforeMethod
	public void objCreation()
	{
		objAdmin=new AdminLogin(driver);
	}

	 
	@Test(priority=1)
	public void verifyinvalid1AdminLogin() throws IOException, InterruptedException
	{
		
		
		String username=Excelutility.getCellData("adminlogin",1, 0);
		String password=Excelutility.getCellData("adminlogin",1, 1);
		
		
		objAdmin.setAdminUsername(username);
		objAdmin.setAdminPassword(password);
		objAdmin.clickLogin();
			
				
	}
	@Test(priority=2)
	public void verifyinvalid2AdminLogin() throws IOException, InterruptedException
	{
		
		String username=Excelutility.getCellData("adminlogin",2, 0);
		String password=Excelutility.getCellData("adminlogin",2, 1);
		
		
		objAdmin.setAdminUsername(username);
		objAdmin.setAdminPassword(password);
		objAdmin.clickLogin();
			
			
				
	}
	@Test(priority=3)
	public void verifyinvalid3dminLogin() throws IOException, InterruptedException
	{


		
		String username=Excelutility.getCellData("adminlogin",3, 0);
		String password=Excelutility.getCellData("adminlogin",3, 1);
		
		
		objAdmin.setAdminUsername(username);
		objAdmin.setAdminPassword(password);
		objAdmin.clickLogin();
			
			
				
	}
	@Test(priority=4)
	public void verifyAdminLogin() throws IOException, InterruptedException
	{


		
		String username=Excelutility.getCellData("adminlogin",0, 0);
		String password=Excelutility.getCellData("adminlogin",0, 1);
		
		
		objAdmin.setAdminUsername(username);
		objAdmin.setAdminPassword(password);
		objAdmin.clickLogin();
			
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(80));   
		assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Sales overview & summary']"))).isDisplayed());
		Logoututility.adminlogout();	
				
	}
	
		 
		
	
}



