package com.ictak.utility;

import static org.testng.Assert.assertEquals;
import com.tcsion.Admin.pages.*;
import static org.testng.Assert.assertTrue; 



import com.tcsion.Base.BaseClass;
import com.tcsion.Customer.pages.Logout;
import com.tcsion.Supplier.pages.SupplierLogout;
public class Logoututility extends BaseClass {
	
	public  static void  caLogout() {
	
		Logout objlog=new Logout(driver);
		String Actual=objlog.clickLogout();
		assertEquals(Actual,"https://phptravels.net/login");
	}
	public static void  adminlogout() {
		AdminLogOut objLogout=new AdminLogOut(driver);
		objLogout.clickperson();
		String Actual=objLogout.clicklogout();
		String Expected="https://phptravels.net/api/admin";
		assertEquals(Actual, Expected);

	}
	public static void  supplierlogout() {
		SupplierLogout objLogout=new SupplierLogout(driver);
		objLogout.clickperson();
		String Actual=objLogout.clicklogout();
		String Expected="https://phptravels.net/api/supplier";
		assertEquals(Actual, Expected);
		
	}
	

}
