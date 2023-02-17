package com.tcsion.Customer.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcsion.Base.BaseClass;

public class CustomerViewVoucher extends BaseClass {
	
	
		@FindBy(xpath="//a[text()=' View Voucher']")
		private WebElement voucher;
		
		@FindBy(xpath="//button[@id='download']")
		private WebElement download;
		public CustomerViewVoucher(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);		
			//custAgentUrl();
		}
		
		public boolean clickVoucher()
		{
			boolean actual=false;
			voucher.click();
			System.out.println(driver.getCurrentUrl());
			String mainWin=driver.getWindowHandle();
			System.out.println(mainWin);
			Set<String> s1=driver.getWindowHandles();
			Iterator<String> win=s1.iterator();
			while(win.hasNext())
			{
				String childWin=win.next();
				System.out.println(childWin);
				if(!mainWin.equalsIgnoreCase(childWin))
				{
					System.out.println(childWin);
					driver.switchTo().window(childWin);
					System.out.println(driver.getCurrentUrl());
					actual=download.isDisplayed();
					System.out.println(actual);
					driver.close();
				}
				
			}
			driver.switchTo().window(mainWin);
			System.out.println(mainWin);
			System.out.println(actual);
			return actual;
			
		}

}
