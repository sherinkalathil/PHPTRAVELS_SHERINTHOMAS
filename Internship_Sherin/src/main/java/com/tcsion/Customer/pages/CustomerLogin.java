package com.tcsion.Customer.pages;

import java.time.Duration;

import org.apache.hc.core5.reactor.AbstractIOSessionPool;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tcsion.Base.BaseClass;

public class CustomerLogin extends BaseClass{
	
	
	@FindBy(css = "input[name='email'][placeholder='Email']")
	private WebElement CustomerUsername;
	
	@FindBy(xpath="//input[@name='password' and @type='password']")
	private WebElement CustomerPassword;
	
	@FindBy(xpath="//span[text()=\"Login\"]")
	private WebElement CustomerLogin;
	
	public CustomerLogin(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		custAgentUrl();
		  
		}
	
	public void setCustomerUsername(String custUname) {
		
		CustomerUsername.sendKeys(custUname);
		
		
	}
	public void setCustomerPassword(String custPass) {
		
		CustomerPassword.sendKeys(custPass);
	}
	
	public void clickLogin()
	{
		CustomerLogin.click();
	}
	

}
