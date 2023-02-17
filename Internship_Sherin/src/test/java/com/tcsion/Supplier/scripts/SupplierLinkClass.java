package com.tcsion.Supplier.scripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ictak.utility.Excelutility;
import com.tcsion.Base.BaseClass;
import com.tcsion.Supplier.pages.SupplierLinks;
import com.tcsion.Supplier.pages.SupplierLogin;
import com.tcsion.Supplier.pages.SupplierLogout;

public class SupplierLinkClass	extends BaseClass {
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
		public void suppViewLinks() throws InterruptedException
		{
			SupplierLinks objSuppLink=new SupplierLinks(driver);
			boolean[] a=new boolean[2];
			//objSuppLink.clickSupplierFlight();
			
			//objSuppLink.clickSupplierVisa();
			a=objSuppLink.clickSupplierBooking();
			assertTrue(a[0]);
			a=objSuppLink.clickSupplierTour();
			assertTrue(a[0]);
			assertTrue(a[1]);
			
		}
		@AfterMethod
		public void logout() {
			SupplierLogout objLogout=new SupplierLogout(driver);
			objLogout.clickperson();
			String Actual=objLogout.clicklogout();
			assertEquals(Actual, "https://phptravels.net/api/supplier");
		}
}
