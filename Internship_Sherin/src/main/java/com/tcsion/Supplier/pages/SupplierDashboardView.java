package com.tcsion.Supplier.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcsion.Base.BaseClass;

public class SupplierDashboardView extends BaseClass {
	
	
		@FindBy(xpath="//*[text()='Dashboard' and @class='text-uppercase font-monospace']")
		private WebElement SupplierDashboard;
		
		
		
		
		public SupplierDashboardView(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
			SupplierUrl();  
			}
		


		public void viewDashboard()
		{
			SupplierDashboard.click();
		}
		


	}


