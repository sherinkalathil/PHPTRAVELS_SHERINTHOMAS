package com.tcsion.Supplier.scripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ictak.utility.Excelutility;
import com.tcsion.Base.BaseClass;
import com.tcsion.Supplier.pages.SupplierCountVerify;
import com.tcsion.Supplier.pages.SupplierLogin;
import com.tcsion.Supplier.pages.SupplierLogout;

public class SupplierCountTest extends BaseClass{
	@BeforeMethod
	public void verifySupplierLogin() throws IOException, InterruptedException
	{

		SupplierLogin objSupp=new SupplierLogin(driver);
		String username=Excelutility.getCellData("supplogin",0, 0);
		String password=Excelutility.getCellData("supplogin",0, 1);
		
		
		objSupp.setSupplierUsername(username);
		objSupp.setSupplierPassword(password);
		objSupp.clickLogin();
			
	}
	@Test
	public void Dashboard()
	{
		SupplierCountVerify objconfirm=new SupplierCountVerify(driver);
		objconfirm.DashboardCount();
		objconfirm.clickPendBook();
		objconfirm.clickConfirm();
		boolean actual=objconfirm.clickDashboard();
		assertTrue(actual);
		//driver.close();
	}
	@AfterMethod
	public void logout() {
		SupplierLogout objLogout=new SupplierLogout(driver);
		objLogout.clickperson();
		String Actual=objLogout.clicklogout();
		assertEquals(Actual, "https://phptravels.net/api/supplier");
	}
	

}
