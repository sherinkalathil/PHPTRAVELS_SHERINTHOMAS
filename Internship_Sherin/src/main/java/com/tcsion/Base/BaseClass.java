package com.tcsion.Base;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
		public static WebDriver driver;
		public static Properties prop=null;
		public static void TestBaseClass() throws IOException
		{
			prop=new Properties();
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources"+"/config.properties");
			prop.load(ip);
		}
		@BeforeSuite
		public void onSetup() throws IOException
		{

            TestBaseClass();
			String browserName=prop.getProperty("browser");
			if (browserName.equals("chrome"))
			{
				
				driver=new ChromeDriver();
			}
			else if (browserName.equals("firefox"))
			{
				
				driver=new FirefoxDriver();
			}
			
		}
		public void custAgentUrl()
		{
			driver.get(prop.getProperty("url1"));
			driver.manage().window().maximize();
					
		}
		public void AdminUrl()
		{
			driver.get(prop.getProperty("url2"));
			driver.manage().window().maximize();
					
		}
		public void SupplierUrl()
		{
			driver.get(prop.getProperty("url3"));
			driver.manage().window().maximize();
					
		}
		
		@AfterSuite
		public void tearDown()
		{
			driver.close();
		}

	}


