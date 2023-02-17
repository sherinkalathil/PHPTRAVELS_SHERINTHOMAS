package com.tcsion.Agent.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tcsion.Base.BaseClass;

public class AgentCurrency extends BaseClass{
	
	//@FindBy(xpath="//*[@class='dropdown-item-waves-effect'][text()=' USD']")
	//@FindBy(xpath="//*[text()=' USD'][@href='https://phptravels.net/currency-USD']")
	@FindBy(xpath="//button[@id='currency'][contains(text(),'USD')]")
	private WebElement USD;
	//@FindBy(xpath="//*[@class='dropdown-item-waves-effect'][text()=' INR']")
	//@FindBy(xpath="//*[text()=' INR'][@href='https://phptravels.net/currency-INR']")
	@FindBy(xpath = " //*[@class='dropdown-item waves-effect'][text()=' INR']")
	private WebElement INR;
	@FindBy(xpath="//button[@id='currency'][contains(text(),'INR')]")
	private WebElement inr;
	
	@FindBy(xpath = "//*[@class='btn btn-primary dropdown-toggle waves-effect']")
	private WebElement lgaccount;
	@FindBy(xpath = "//a[@class='dropdown-item waves-effect' and @href='https://phptravels.net/account/dashboard']")
	private WebElement logout;
	
	
	public AgentCurrency(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		//custAgentUrl();  
	}
	public void clickUSD()
	{		

        USD.click();
	}
	public String clickINR()
	
	{
		INR.click();
		String actual=inr.getText();
		System.out.println("inr="+actual);
		return actual;
		
	}
	
	public void logout() {
		lgaccount.click();
		logout.click();
		
}

}
