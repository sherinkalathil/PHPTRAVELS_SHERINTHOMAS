package com.tcsion.Agent.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcsion.Base.BaseClass;

public class AgentLogin extends BaseClass{

	
	//@FindBy(id="exampleInputEmail1")
    @FindBy(css = "input[name='email'][placeholder='Email']")
	private WebElement AgentUsername;
	
	//@FindBy(name="password")
    @FindBy(xpath="//input[@name='password' and @type='password']")
	private WebElement AgentPassword;
	
	@FindBy(xpath="//span[text()=\"Login\"]")
	private WebElement AgentLogin;
	
	public AgentLogin(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		custAgentUrl(); 
		}
	public void setAgentPassword(String agentPass) {
		AgentPassword.sendKeys(agentPass);
	}
	public void setAgentUsername(String agentUname) {
		AgentUsername.sendKeys(agentUname);
	}
	
	public void clickAgentLogin()
	{
		AgentLogin.click();
	}


}
