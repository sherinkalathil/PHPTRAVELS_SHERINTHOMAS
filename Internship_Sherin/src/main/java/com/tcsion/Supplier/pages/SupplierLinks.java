package com.tcsion.Supplier.pages;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tcsion.Base.BaseClass;

public class SupplierLinks  extends BaseClass{


		//@FindBy(xpath="//*[@aria-controls='flightsmodule'][@class='nav-link mdc-ripple-upgraded']")
		//private WebElement SuppFlights;
		
		@FindBy(xpath="//*[@aria-controls='toursmodule']")
		private WebElement SuppTours;
		
		@FindBy(xpath="//*[@id='toursmodule']")
		private WebElement SuppTours1;
		
		//@FindBy(xpath="//*[@aria-controls='visamodule'][@class='nav-link mdc-ripple-upgraded collapsed']")
		//private WebElement SuppVisa;
		
		//@FindBy(xpath="//*[@href='https://phptravels.net/api/supplier/bookings'][@class='loadeffect nav-link collapsed mdc-ripple-upgraded']")
		@FindBy(xpath="//*[text()='Bookings']")
		private WebElement SuppBooking;
		
        boolean[] a=new boolean[2];

		
		public SupplierLinks(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
			SupplierUrl(); 
			}
		


		/*public void clickSupplierFlight()
		{
			SuppFlights.click();
		}*/
		public boolean[] clickSupplierTour() throws InterruptedException
		{
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));   
		    wait.until(ExpectedConditions.visibilityOf(SuppTours));
		    a[0]=SuppTours.isDisplayed();
		    System.out.println(a[0]);
		  SuppTours.click();
		  a[1]=SuppTours1.isDisplayed();
		  SuppTours1.click();
		  return a;
		}
		public boolean[] clickSupplierBooking()
		{
			a[0]=SuppBooking.isDisplayed();
			System.out.println(a[0]);
			return a;
			
			//SuppBooking.click();
		}
		/*public void clickSupplierVisa()
		{
			SuppVisa.click();
		}*/
		
		
 

}
