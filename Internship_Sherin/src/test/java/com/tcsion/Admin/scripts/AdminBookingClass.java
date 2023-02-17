package com.tcsion.Admin.scripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ictak.utility.Excelutility;
import com.ictak.utility.Logoututility;
import com.tcsion.Admin.pages.AdminLogOut;
import com.tcsion.Admin.pages.AdminLogin;
import com.tcsion.Admin.pages.AdminViewBooking;
import com.tcsion.Base.BaseClass;

public class AdminBookingClass extends BaseClass {
    @BeforeMethod
	public void verifyAdminLogin() throws IOException, InterruptedException
	{


		AdminLogin objAdmin=new AdminLogin(driver);
		String username=Excelutility.getCellData("adminlogin",0, 0);
		String password=Excelutility.getCellData("adminlogin",0, 1);
		
		
		objAdmin.setAdminUsername(username);
		objAdmin.setAdminPassword(password);
		objAdmin.clickLogin();					
				
	}
    @Test
    public void verifyAdminBooking()
    {
    	AdminViewBooking objAdmin=new AdminViewBooking(driver);
    	//objAdmin.clickBooking();
    	boolean correct=objAdmin.clickInvoice();
    	assertTrue(correct);
    	//driver.close();
    	
    }
    @AfterMethod
	public void logout() {
		//AdminLogOut objLogout=new AdminLogOut(driver);
		//objLogout.clickperson();
		//String Actual=objLogout.clicklogout();
		//System.out.println(Actual);
		//String Expected="https://phptravels.net/api/admin";
		//assertEquals(Actual, Expected);
    	Logoututility.adminlogout();


	}
}
