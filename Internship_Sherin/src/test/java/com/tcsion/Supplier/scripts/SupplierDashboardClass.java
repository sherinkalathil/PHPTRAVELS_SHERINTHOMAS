package com.tcsion.Supplier.scripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ictak.utility.Excelutility;
import com.tcsion.Base.BaseClass;
import com.tcsion.Supplier.pages.SupplierDashboardView;
import com.tcsion.Supplier.pages.SupplierLogin;
import com.tcsion.Supplier.pages.SupplierLogout;

public class SupplierDashboardClass extends BaseClass {
	@BeforeTest
	public void verifySupplierLogin() throws IOException, InterruptedException
	{


		SupplierLogin objSupp=new SupplierLogin(driver);
		String username=Excelutility.getCellData("supplogin",0, 0);
		String password=Excelutility.getCellData("supplogin",0, 1);
		
		
		objSupp.setSupplierUsername(username);
		objSupp.setSupplierPassword(password);
		objSupp.clickLogin();
	}	
	@Test(priority=1)	
	public void verifyDashboardView()
	{
	SupplierDashboardView objSuppView=new SupplierDashboardView(driver);
	objSuppView.viewDashboard();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(80));   
	assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Sales overview & summary']"))).isDisplayed());
	assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://phptravels.net/api/supplier/bookings/confirmed']"))).isDisplayed());
	assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://phptravels.net/api/supplier/bookings/pending']"))).isDisplayed());
	assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://phptravels.net/api/supplier/bookings/cancelled']"))).isDisplayed());
	assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://phptravels.net/api/supplier/bookings/paid']"))).isDisplayed());
	assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://phptravels.net/api/supplier/bookings/unpaid']"))).isDisplayed());
	assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://phptravels.net/api/supplier/bookings/refunded']"))).isDisplayed());
	
	
	}
	
	@Test(priority=2)	
	public void verifyRevenueBreakdown()
	{

	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(80));   
	assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Revenue Breakdown 2023']"))).isDisplayed());
	assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='dashboardBarChart']"))).isDisplayed());
	}
	
	@AfterTest
	public void logout() {
		SupplierLogout objLogout=new SupplierLogout(driver);
		objLogout.clickperson();
		String Actual=objLogout.clicklogout();
		assertEquals(Actual, "https://phptravels.net/api/supplier");
	}

}
