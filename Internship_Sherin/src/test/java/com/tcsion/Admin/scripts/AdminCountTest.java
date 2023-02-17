package com.tcsion.Admin.scripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ictak.utility.Excelutility;
import com.ictak.utility.Logoututility;
import com.tcsion.Admin.pages.AdminCountVerify;
import com.tcsion.Admin.pages.AdminLogOut;
import com.tcsion.Admin.pages.AdminLogin;
import com.tcsion.Base.BaseClass;

public class AdminCountTest extends BaseClass{
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
	public void Dashboard()
	{
		AdminCountVerify objconfirm=new AdminCountVerify(driver);
		objconfirm.DashboardCount();
		objconfirm.clickPendBook();
		objconfirm.clickConfirm();
		boolean actual=objconfirm.clickDashboard();
		assertTrue(actual);
		//driver.close();
	}
	@AfterMethod
	public void logout() {
		/*AdminLogOut objLogout=new AdminLogOut(driver);
		objLogout.clickperson();
		String Actual=objLogout.clicklogout();
		System.out.println(Actual);
		String Expected="https://phptravels.net/api/admin";
		assertEquals(Actual, Expected);*/
		Logoututility.adminlogout();

	}
}
