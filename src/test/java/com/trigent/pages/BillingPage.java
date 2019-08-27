package com.trigent.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;


import com.trigent.base.BaseTest;


public class BillingPage extends BaseTest{
	public WebDriver driver;
	
	
	@FindBy(linkText ="Billing")
	WebElement ClickBillingmenu;
	
	@FindBy(xpath ="//div[@id='page1']/div/div[1]/h3")
	WebElement CheckBillingTitle; 
	
	@FindBy(xpath ="//select[@id='billingDate']")
	WebElement BillingDateField;
	
	@FindBy(xpath ="//button[@id='createBillBtn']")
	WebElement CreateBillButton;
	
	@FindBy(xpath ="//div[@id='waiting_modal']/div/div/div/div/div[1]")
	WebElement BillRunHeader;   //after clicking generate pdf button 
	
	@FindBy(xpath ="//button[@id='reRunBtn']")
	WebElement Rerunbutton;
	
	@FindBy(xpath ="//div[@id='modal']/div/div/div[2]/button")
	WebElement Closebutton;
	
	@FindBy(xpath ="//button[@id='genPDFBtn']")
	WebElement GeneratePDF; 
	
	@FindBy(xpath ="//div[@id='modal']/div/div/div[1]")  
	WebElement BillData;

		public BillingPage(WebDriver dr) {
			// TODO Auto-generated constructor stub
			driver=dr;
		}
		
		 
	// To Click Billing sub-menu 	
	   public void BillingSubmenu() throws InterruptedException {		 
		 ClickBillingmenu.click(); 
		 Thread.sleep(3000);
	   }
	   
	   public void VerifyGenerateBillingpage() throws InterruptedException {
		 String Pageheader = CheckBillingTitle.getText();	 
		 System.out.print("Title of Billing Page : " + Pageheader);
		 Thread.sleep(5000);
		 String ExpectedPageheader = "Billing";
		 Assert.assertEquals(Pageheader, ExpectedPageheader);
		 System.out.print("\nVerified the Page Header\n");
	   }
		 
		 //To select Billing Date
		 public void GenerateBilling() throws InterruptedException {
		 Select oSelect = new Select(BillingDateField);

		 oSelect.selectByVisibleText("04/01/2019");  
	//	 System.out.print("\nSuccessfully date value has been selected\n");
		  
		 //To click Create Bill button
		 CreateBillButton.click(); 
		 Thread.sleep(3000);  
		  
		 try {
			// driver.findElement(By.xpath("//button[@id='reRunBtn']")).isEnabled()
			 
				Rerunbutton.click();
				System.out.println("Re-Run Button is displayed");
		 
		 }
		 catch(Exception e){

		 System.out.println("Re-Run Button is not displayed"); 
		 } 
		 
		 Thread.sleep(50000);  
		 GeneratePDF.click();
		 Thread.sleep(5000);
		 
		// BillData.getText();
		 System.out.println("Invoice Message: "  + BillData.getText());
		 Closebutton.click();
	
	   }
}