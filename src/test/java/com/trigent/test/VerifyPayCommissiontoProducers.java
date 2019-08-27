package com.trigent.test;
import java.awt.AWTException;
import java.util.Hashtable;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.trigent.base.BaseTest;
import com.trigent.pages.DashboardPage;
import com.trigent.pages.GeneralLedgerCommissionPage;
import com.trigent.pages.ProducerPage;
import com.trigent.pages.LoginPage;
import com.trigent.pages.UploadPaymentPage;
import com.trigent.utils.TestUtil;

	


public class VerifyPayCommissiontoProducers extends BaseTest{
		Properties config = new Properties();	
		LoginPage loginPage;
		DashboardPage dashboardPage;
		ProducerPage producerpage;	
		UploadPaymentPage uploadpaymentpage;	
		GeneralLedgerCommissionPage genLedCommissionpage;
		
		
		@DataProvider
		public Object[][] getPaymenttoProducer(){
			return TestUtil.getData("PaymenttoProducer","GenLedCom", xls);				
		}	
	@Test (dataProvider = "getPaymenttoProducer", enabled = true, groups = "GeneralLedgerCommission", description = "Verify Payment to Producer")
	public void verifyPaymenttoProducer_submit(Hashtable<String,String>data) throws InterruptedException, AWTException {				
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class); 
		Thread.sleep(3000); 
		dashboardPage.clickOnAdministration();
		Thread.sleep(3000); 
		GeneralLedgerCommissionPage generalLedgerCommissionPage = PageFactory.initElements(driver, GeneralLedgerCommissionPage.class);
		generalLedgerCommissionPage.clickGeneralLC();
		Thread.sleep(5000);
		
		//Click Pay Producer
		generalLedgerCommissionPage.clickPayProducer();
		Thread.sleep(3000);		
		
		//Enter value in Pay Description
		generalLedgerCommissionPage.validateDescrip(data.get("pay_Description"));
        Thread.sleep(5000);               
        
        //Click Check
        generalLedgerCommissionPage.chq();
        Thread.sleep(3000);
        generalLedgerCommissionPage.SelectBank();
        Thread.sleep(3000);
        
        //Enter Check Number
        generalLedgerCommissionPage.chqno(data.get("CheckNum"));
        Thread.sleep(5000);
         
        //Select Date
        generalLedgerCommissionPage.date();
        Thread.sleep(3000); 
        generalLedgerCommissionPage.selectDate();
        Thread.sleep(3000); 
        generalLedgerCommissionPage.select();  
        Thread.sleep(3000);
          
        generalLedgerCommissionPage.selectvalue();
        Thread.sleep(3000);
        generalLedgerCommissionPage.checkbox();  
        Thread.sleep(3000);
        
        //Click Submit Button 
        generalLedgerCommissionPage.clickPayProdSubmit();  
        Thread.sleep(3000);   
        generalLedgerCommissionPage.Check_Print_Confirmation();
		Thread.sleep(5000);
		generalLedgerCommissionPage.clickprintbutton();
		Thread.sleep(5000);
	}
}
