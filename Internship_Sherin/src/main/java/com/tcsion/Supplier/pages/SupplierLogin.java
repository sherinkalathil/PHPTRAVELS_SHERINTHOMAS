package com.tcsion.Supplier.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcsion.Base.BaseClass;

public class SupplierLogin extends BaseClass {

	
	@FindBy(xpath="//*[@name=\"email\"]")
	private WebElement SupplierUsername;
	
	@FindBy(xpath="//*[@name=\"password\"]")
	private WebElement SupplierPassword;
	
	@FindBy(xpath="//span[text()=\"Login\"]")
	private WebElement SupplierLogin;
	
	public SupplierLogin(WebDriver driver)
	{
		BaseClass.driver=driver;
		PageFactory.initElements(driver,this);
		SupplierUrl();  
		}
	
	public void setSupplierUsername(String suppUname) {
		SupplierUsername.sendKeys(suppUname);
	}
	public void setSupplierPassword(String suppPass) {
		SupplierPassword.sendKeys(suppPass);
	}
	
	public void clickLogin()
	{
		SupplierLogin.click();
	}



}
