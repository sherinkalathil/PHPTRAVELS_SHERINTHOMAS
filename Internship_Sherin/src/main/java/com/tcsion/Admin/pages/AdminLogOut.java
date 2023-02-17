package com.tcsion.Admin.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tcsion.Base.BaseClass;

public class AdminLogOut extends BaseClass
{
	
	@FindBy (xpath = "//button[@id='dropdownMenuProfile']")
	private WebElement person;
	@FindBy (xpath = "//*[text()='Logout']")
	private WebElement logout;
	@FindBy(xpath = ".//*[@type='submit']")
	private WebElement login;
	
	public AdminLogOut(WebDriver driver)
	{
		 BaseClass.driver=driver;
		 PageFactory.initElements(driver,this);
		 
	}
	public void clickperson() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
    	wait.until(ExpectedConditions.visibilityOf(person));
		person.click();
	}
	public String clicklogout() {
		logout.click();

	   	return driver.getCurrentUrl(); 

}
}
