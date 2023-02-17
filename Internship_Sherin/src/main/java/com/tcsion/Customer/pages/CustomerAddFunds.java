package com.tcsion.Customer.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tcsion.Base.BaseClass;

public class CustomerAddFunds extends BaseClass {
//WebDriver driver;
	
	@FindBy(xpath="//input[@id='gateway_paypal' and @type='radio']")
	private WebElement paypal;
	
	
	//@FindBy(xpath="//button[text()='Pay Now ']")   
	
	@FindBy(xpath="//*[@type='submit']")
	private WebElement payNow;
	
	public CustomerAddFunds(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);	
		//custAgentUrl();
	}
	public void clickPaypal()
    {	
    	
	   paypal.click();
    }
	public void clickPayNow()
    {
	   payNow.click();
    }
}
