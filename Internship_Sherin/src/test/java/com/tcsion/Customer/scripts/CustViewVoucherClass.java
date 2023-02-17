package com.tcsion.Customer.scripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ictak.utility.Excelutility;
import com.ictak.utility.Logoututility;
import com.tcsion.Base.BaseClass;
import com.tcsion.Customer.pages.CustomerLinks;
import com.tcsion.Customer.pages.CustomerLogin;
import com.tcsion.Customer.pages.CustomerViewVoucher;

public class CustViewVoucherClass extends BaseClass{
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
		objlinks.clickBookings();

	}
@Test(priority=2)
public void verifyCustViewVoucher() throws IOException, InterruptedException
{
	CustomerViewVoucher objvoucher=new CustomerViewVoucher(driver);
	
	boolean view=objvoucher.clickVoucher();
	System.out.println(view);
	assertTrue(view);
	//driver.close();

}
@AfterTest
public void logout() {
	Logoututility.caLogout();
}

}
