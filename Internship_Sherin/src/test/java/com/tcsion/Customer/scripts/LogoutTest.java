package com.tcsion.Customer.scripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ictak.utility.Excelutility;
import com.tcsion.Customer.pages.*;
import com.tcsion.Base.BaseClass;
import com.tcsion.Customer.pages.CustomerLogin;

public class LogoutTest extends BaseClass {
	
	@BeforeMethod
	public void Login() throws IOException {
		
  CustomerLogin objCustomer=new CustomerLogin(driver);
		
		String username=Excelutility.getCellData("custlogin",0, 0);
		String password=Excelutility.getCellData("custlogin",0, 1);
		
		
		objCustomer.setCustomerUsername(username);
		objCustomer.setCustomerPassword(password);
		objCustomer.clickLogin();
	}
	@Test
	public void logout() {
		Logout objlog=new Logout(driver);
		String Actual=objlog.clickLogout();
		assertEquals(Actual,"https://phptravels.net/login");
	}

}
