package com.tcsion.Admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcsion.Base.BaseClass;

public class AdminLogin extends BaseClass{

	
	//@FindBy(name="email")
	//@FindBy(xpath="//*[@name=\"email\"]")
	@FindBy(css="input[name='email'][type='text']")
	private WebElement AdminUsername;
	
	//@FindBy(name="password")
	//@FindBy(xpath="//*[@name=\"password\"]")
	@FindBy(css="input[name='password'][type='password']")
	private WebElement AdminPassword;
	
	@FindBy(xpath="//span[text()=\"Login\"]")
	private WebElement AdminLogin;
	
	public AdminLogin(WebDriver driver)
	{
		BaseClass.driver=driver;
		PageFactory.initElements(driver,this);
		AdminUrl() ;
		}
	
	public void setAdminUsername(String adminUname) {
		AdminUsername.sendKeys(adminUname);
	}
	public void setAdminPassword(String adminPass) {
		AdminPassword.sendKeys(adminPass);
	}
	public void clickLogin()
	{
		AdminLogin.click();
	}
	


}
