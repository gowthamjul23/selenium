package com.trigent.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.trigent.pages.LoginPage;
import com.trigent.utils.Xls_Reader;

public class CreateQuarterlyInvoice {
	public static WebDriver driver;
	public static Properties Config;
	public static Logger applicationLogs;
	public static String userName;
	public static String userPassword;
	public static String loginButton;
	Properties config = new Properties();
	public Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir") + "\\TestData\\Test-Cases.xlsx");
	
	public void initConfiguration() throws FileNotFoundException{
		if (Config==null){
			applicationLogs = Logger.getLogger("devpinoyLogger");
		Config= new Properties();
		try{
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
		Config.load(fs);
		}catch(Exception e){
			e.printStackTrace();
			}
		}
	}
	
	public void initDriver() {
		if(Config.getProperty("browser").equals("FF")){
			driver=new FirefoxDriver();
		}
		else if(Config.getProperty("browser").equals("IE")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			}
		else if(Config.getProperty("browser").equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			}
	}
		
		
	
	@BeforeMethod
	public void QuarterlyInvoice() throws FileNotFoundException  {		
		System.out.println("Before method starts");
		initConfiguration();
		System.out.println("Logger initiated");
		initDriver();		
		System.out.println("Before Method Ends");			
		
	}
	
	@Test 
	public void Firsturl() throws InterruptedException {
		driver.get("https://52.205.8.106/index.php/main/signin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		
		//Login as Admin User
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login(Config.getProperty("userName"), Config.getProperty("userPassword"));
		Thread.sleep(5000);
		System.out.println("Logged in the Application as Administration User");
		
		driver.getWindowHandle();
	    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
	    System.out.println("Opened the New Tab");
	    
	    //Process for Quarterly Invoice
		driver.get("https://52.205.8.106/admin/quarterly_invoice");
		Thread.sleep(10000);		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		System.out.println(".........................");		
		Thread.sleep(5000);
		System.out.println("Get the Quarterly Invoice URL");
		Thread.sleep(5000);
		
		driver.getWindowHandle();
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		System.out.println("Opened the New Tab to send Quarterly Invoice");
		
		//Process to send Quarterly Invoice
		driver.get("https://52.205.8.106/cron/send_quarterly_invoice");
		Thread.sleep(10000);		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		System.out.println(".........................");			
		Thread.sleep(10000);
		System.out.println("Send Quarterly Invoice URL Launched");	
		Thread.sleep(10000);
	}
	
	
	@AfterMethod
	public void tearDownAfterMethod() throws InterruptedException{
	System.out.println("After method starts");
	driver.quit();
	System.out.println("Driver Quit");
	System.out.println("After method ends");

}
}