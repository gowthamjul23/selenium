package com.trigent.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.trigent.pages.LoginPage;
import com.trigent.pages.VerifyEmailpage;
import com.trigent.utils.PropertyReader;
import com.trigent.utils.Xls_Reader;

public class BaseTest {
	
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
		 
		/* PropertyReader propread = new PropertyReader();
		
		String UrlToLoad = propread.getBaseURL();
		System.out.println("URL being used is" + UrlToLoad);
		driver.get(UrlToLoad);
		*/
		driver.get("https://52.205.8.106/index.php/main/signin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		
		
	/*	driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS); */
	}	
	
	
	
	@BeforeMethod(alwaysRun = true)
	public void login() throws FileNotFoundException, InterruptedException {
		System.out.println("Before method starts");
		initConfiguration();
		System.out.println("Logger initiated");
		initDriver();
		System.out.println("Driver initiated");		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login(Config.getProperty("userName"), Config.getProperty("userPassword"));
		System.out.println("Before method ends");
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDownAfterMethod() throws InterruptedException{
		System.out.println("After method starts");
		driver.quit();
		System.out.println("Driver Quit");
		System.out.println("After method ends");
	}
		
/*	@AfterSuite(alwaysRun = true)
	public void quitDriver() throws InterruptedException{
		driver.quit();
		System.out.println("Driver Quit");
	}
*/
}
