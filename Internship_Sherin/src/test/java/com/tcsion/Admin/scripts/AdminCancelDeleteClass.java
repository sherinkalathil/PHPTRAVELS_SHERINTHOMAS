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
import com.tcsion.Admin.pages.AdminCancelDelete;
import com.tcsion.Admin.pages.AdminLogOut;
import com.tcsion.Admin.pages.AdminLogin;
import com.tcsion.Base.BaseClass;

public class AdminCancelDeleteClass extends BaseClass {
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
    public void verifyAdminCancelDelete()
    {
    	AdminCancelDelete objDel=new AdminCancelDelete(driver);
    	objDel.clickCancel();
    	String message=objDel.clickDelete();
    	if(message!=null)
    	{
    		assertTrue(message.contains("Are you sure to delete?"));
    	}
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
