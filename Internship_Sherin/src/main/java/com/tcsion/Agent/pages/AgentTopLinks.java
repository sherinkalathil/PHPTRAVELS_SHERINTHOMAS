package com.tcsion.Agent.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcsion.Base.BaseClass;

public class AgentTopLinks extends BaseClass{

	
	@FindBy(xpath="//*[text()='Hotels']")
	
	private WebElement AgentHotels;
	
	@FindBy(xpath="//*[text()='flights']")
	private WebElement AgentFlights;
	
	@FindBy(xpath="//*[text()='Tours']")
	private WebElement AgentTours;
	
	@FindBy(xpath="//*[text()='visa']")
	private WebElement AgentVisa;
	
	@FindBy(xpath="//*[text()='Blog']")
	private WebElement AgentBlog;
	
	@FindBy(xpath="//*[text()='Offers']")
	private WebElement AgentOffers;
	
	@FindBy(xpath = "//*[@class='btn btn-primary dropdown-toggle waves-effect']")
	private WebElement lgaccount;
	@FindBy(xpath = "//a[@class='dropdown-item waves-effect' and @href='https://phptravels.net/account/dashboard']")
	private WebElement logout;
	
	public AgentTopLinks(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		//custAgentUrl(); 
		}
	
	public void clickAgentHotel()

	{
		AgentHotels.click();
	}
	public void clickAgentFlight()
	{
		AgentFlights.click();
	}
	public void clickAgentTour()
	{
		AgentTours.click();
	}
	public void clickAgentBlog()
	{
		AgentBlog.click();
	}
	public void clickAgentOffer()
	{
		AgentOffers.click();
	}
	public void clickAgentVisa()
	{
		AgentVisa.click();
	}
	public void logout() {
		lgaccount.click();
		logout.click();
		
}
	

}
