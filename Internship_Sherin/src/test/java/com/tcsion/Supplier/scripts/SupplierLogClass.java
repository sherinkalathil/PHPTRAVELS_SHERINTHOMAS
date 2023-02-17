package com.tcsion.Supplier.scripts;

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
import com.tcsion.Base.BaseClass;
import com.tcsion.Supplier.pages.SupplierLogin;



public class SupplierLogClass extends BaseClass {
	SupplierLogin objSupp;
	@BeforeMethod
	public void objCreation()
	{
	 objSupp=new SupplierLogin(driver);
	}
	
	@Test(priority=1)
	public void verifyinvalid1SupplierLogin() throws IOException, InterruptedException
	{
		
		
		String username=Excelutility.getCellData("supplogin",1, 0);
		String password=Excelutility.getCellData("supplogin",1, 1);
		
		
		objSupp.setSupplierUsername(username);
		objSupp.setSupplierPassword(password);
		objSupp.clickLogin();
			
				
	}
	@Test(priority=2)
	public void verifyinvalid2SupplierLogin() throws IOException, InterruptedException
	{
		
		String username=Excelutility.getCellData("supplogin",2, 0);
		String password=Excelutility.getCellData("supplogin",2, 1);
		
		
		objSupp.setSupplierUsername(username);
		objSupp.setSupplierPassword(password);
		objSupp.clickLogin();
			
			
				
	}
	@Test(priority=3)
	public void verifyinvalid3SupplierLogin() throws IOException, InterruptedException
	{


		
		String username=Excelutility.getCellData("supplogin",3, 0);
		String password=Excelutility.getCellData("supplogin",3, 1);
		
		
		objSupp.setSupplierUsername(username);
		objSupp.setSupplierPassword(password);
		objSupp.clickLogin();
			
			
				
	}
	@Test(priority=4)
	public void verifySupplierLogin() throws IOException, InterruptedException
	{


		
		String username=Excelutility.getCellData("supplogin",0, 0);
		String password=Excelutility.getCellData("supplogin",0, 1);
		
		
		objSupp.setSupplierUsername(username);
		objSupp.setSupplierPassword(password);
		objSupp.clickLogin();
			
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(80));   
		assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Sales overview & summary']"))).isDisplayed());
		
			
				
	}
	

}