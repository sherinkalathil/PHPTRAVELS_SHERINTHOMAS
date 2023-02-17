package com.tcsion.Supplier.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tcsion.Base.BaseClass;

public class SupplierCountVerify  extends BaseClass {
	@FindBy(xpath="//*[text()='Pending Bookings']")
	private WebElement pendbook;
	
	@FindBy(xpath="//*[@id='booking_status']")
	private WebElement pending ;
	
	@FindBy(xpath="//*[text()='Pending Bookings']//preceding::div[1]")
	private WebElement pendcount ;
	
	@FindBy(xpath="//*[text()='Confrimed Bookings']//preceding::div[1]")
	private WebElement confirmcount ;
	
	@FindBy(xpath="//*[text()='Dashboard']//parent::a")
	private WebElement dashboard ;
	
	int confirmCountExp,pCountExp,confirmCountAct,pCountAct;
	boolean actual;
	public SupplierCountVerify(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		SupplierUrl() ;
	}
	
	public void DashboardCount()
	{
		String confirmCount=confirmcount.getText();
		System.out.println("cncount="+confirmCount);
		int confirmCountNow=Integer.parseInt(confirmCount);
		confirmCountExp=confirmCountNow+1;
		System.out.println("cexp="+confirmCountExp);
		String pendCount=pendcount.getText();
		System.out.println("pcount="+pendCount);
		int pCountNow=Integer.parseInt(pendCount);
		pCountExp=pCountNow-1;
		System.out.println("pExp="+pCountExp);
	}
	public void clickPendBook()
	{
		pendbook.click();
	}
	
	public void clickConfirm()
	{
		Select sel=new Select(pending);
		sel.selectByVisibleText("Confirmed");
	}
	public boolean clickDashboard()
	{
		driver.navigate().back();
		String confirmCount=confirmcount.getText();
		System.out.println("cncount="+confirmCount);
		confirmCountAct=	Integer.parseInt(confirmCount);
		System.out.println("cact="+confirmCountAct);
		
		String pendCount=pendcount.getText();
		System.out.println("pcount="+pendCount);
		pCountAct=Integer.parseInt(pendCount);
		System.out.println("pact="+pCountAct);
		
		if((confirmCountExp==confirmCountAct)  &&  (pCountExp==pCountAct))
		{
			actual=true;
		}
		else
		{
			actual=false;
		}
		System.out.println("actual="+actual);
		return actual;
	}


}
