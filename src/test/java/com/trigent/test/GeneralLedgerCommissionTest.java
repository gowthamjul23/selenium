package com.trigent.test;
import java.awt.AWTException;
import java.util.Hashtable;
import java.util.Properties;
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

public class GeneralLedgerCommissionTest extends BaseTest{
	
	Properties config = new Properties();	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	ProducerPage producerpage;	
	UploadPaymentPage uploadpaymentpage;	
	GeneralLedgerCommissionPage genLedCommissionpage;
	
	@DataProvider
	public Object[][] getVerifyAmountField(){
		return TestUtil.getData("VerifyAmountField","GenLedCom", xls);				
	}	
	@DataProvider
	public Object[][] getVerifyAddDebit_Submit(){
		return TestUtil.getData("VerifyAddDebit_Submit","GenLedCom", xls);				
	}	
	@DataProvider
	public Object[][] getPaymenttoProducer(){
		return TestUtil.getData("PaymenttoProducer","GenLedCom", xls);				
	}	
	
	@Test (enabled = true, priority = 1, groups = "GeneralLedgerCommission", description = "Verify General Ledger Commission Page")	
	public void verify_GeneralLedgerCommissionPage() throws InterruptedException, AWTException {		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.clickOnAdministration();
		Thread.sleep(3000);
		GeneralLedgerCommissionPage genLedCommissionpage = PageFactory.initElements(driver, GeneralLedgerCommissionPage.class);
		genLedCommissionpage.click_ValidateGeneralLC();
		Thread.sleep(3000);		
}
	@Test (enabled = true, priority = 2, groups = "GeneralLedgerCommission", description = "Verify From Date and To Date")	
	public void verify_FromDate_ToDate() throws InterruptedException, AWTException {		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.clickOnAdministration();
		Thread.sleep(3000);
		GeneralLedgerCommissionPage generalLedgerCommissionPage = PageFactory.initElements(driver, GeneralLedgerCommissionPage.class);
		generalLedgerCommissionPage.clickGeneralLC();
		Thread.sleep(3000);
	    generalLedgerCommissionPage.verifyFromandTodates();
		Thread.sleep(3000);
	}
	
		@Test (enabled = true, priority = 3, groups = "GeneralLedgerCommission", description = "Assert Add Debit Page")
	public void verifyAddDebits() throws InterruptedException, AWTException {		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.clickOnAdministration();
		Thread.sleep(3000);
		GeneralLedgerCommissionPage generalLedgerCommissionPage = PageFactory.initElements(driver, GeneralLedgerCommissionPage.class);
		generalLedgerCommissionPage.clickGeneralLC();
		Thread.sleep(5000);
		generalLedgerCommissionPage.clickAddDebits();
		Thread.sleep(3000);
		generalLedgerCommissionPage.assertAddDebitPage();
		Thread.sleep(3000);
	}
	
	
	
	@Test (dataProvider = "getVerifyAmountField", enabled = true, priority = 4, groups = "GeneralLedgerCommission", description = "Verify Add Debit Screen")
	public void verifyAddDebitsScreen(Hashtable<String,String>data) throws InterruptedException, AWTException {		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.clickOnAdministration();
		Thread.sleep(3000);
		GeneralLedgerCommissionPage generalLedgerCommissionPage = PageFactory.initElements(driver, GeneralLedgerCommissionPage.class);
		generalLedgerCommissionPage.clickGeneralLC();
		Thread.sleep(5000);
		generalLedgerCommissionPage.clickAddDebits();
		Thread.sleep(3000);
		generalLedgerCommissionPage.verifyAddDebitDesc(data.get("Description"));
		Thread.sleep(1000);
		generalLedgerCommissionPage.verifyAmountField(data.get("Amount"));
		Thread.sleep(3000);
		generalLedgerCommissionPage.amountMaxChar();
		Thread.sleep(3000);
		generalLedgerCommissionPage.verifyAddDebitDate();
		Thread.sleep(5000);
	} 
	
	
	@Test (dataProvider = "getVerifyAddDebit_Submit", enabled = true, priority = 5, groups = "GeneralLedgerCommission", description = "Verify Add Debit_Submit")
	public void verifyAddDebit_Submit(Hashtable<String,String>data) throws InterruptedException, AWTException {		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.clickOnAdministration();
		Thread.sleep(3000);
		GeneralLedgerCommissionPage generalLedgerCommissionPage = PageFactory.initElements(driver, GeneralLedgerCommissionPage.class);
		generalLedgerCommissionPage.clickGeneralLC();
		Thread.sleep(5000);
		generalLedgerCommissionPage.clickAddDebits();
		Thread.sleep(3000);
		generalLedgerCommissionPage.verifyAddDebitDesc(data.get("Description"));
		Thread.sleep(1000);
		generalLedgerCommissionPage.verifyAmountField(data.get("Amount"));
		Thread.sleep(3000);
		generalLedgerCommissionPage.verifyAddDebitDate();
		Thread.sleep(5000);
		generalLedgerCommissionPage.clickDebitSubmit();		
	}
	
	
	@Test (dataProvider = "getPaymenttoProducer", enabled = true, priority = 6, groups = "GeneralLedgerCommission", description = "Verify Payment to Producer")
	public void verifyPaymenttoProducer_submit(Hashtable<String,String>data) throws InterruptedException, AWTException {		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.clickOnAdministration();
		Thread.sleep(3000);
		GeneralLedgerCommissionPage generalLedgerCommissionPage = PageFactory.initElements(driver, GeneralLedgerCommissionPage.class);
		generalLedgerCommissionPage.clickGeneralLC();
		Thread.sleep(5000);
		generalLedgerCommissionPage.clickPayProducer();
		Thread.sleep(3000);			
		generalLedgerCommissionPage.validateDescrip(data.get("pay_Description"));
        Thread.sleep(3000);                  
        generalLedgerCommissionPage.chq();
        Thread.sleep(3000);
        generalLedgerCommissionPage.chqno(data.get("CheckNum"));
        Thread.sleep(3000);
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
        generalLedgerCommissionPage.clickPayProdSubmit();
        Thread.sleep(3000);
	}
	  
	
	@Test (dataProvider = "getPaymenttoProducer", enabled = true, priority = 7, groups = "GeneralLedgerCommission", description = "Verify Payment to Producer")
	public void verifyPayproducer_Validate_Check(Hashtable<String,String>data) throws InterruptedException, AWTException {		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.clickOnAdministration();
		Thread.sleep(3000);
		GeneralLedgerCommissionPage generalLedgerCommissionPage = PageFactory.initElements(driver, GeneralLedgerCommissionPage.class);
		generalLedgerCommissionPage.clickGeneralLC();
		Thread.sleep(5000);
		generalLedgerCommissionPage.clickPayProducer();
		Thread.sleep(3000);	
		generalLedgerCommissionPage.validateDescrip(data.get("pay_Description"));
        Thread.sleep(3000);
		generalLedgerCommissionPage.checkDateToday();
		Thread.sleep(3000);
		generalLedgerCommissionPage.chq();
        Thread.sleep(3000);
        generalLedgerCommissionPage.chqno(data.get("CheckNum"));
        Thread.sleep(3000);
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
        generalLedgerCommissionPage.amountMaxChar();
        Thread.sleep(3000);
               
	}
	
	@Test (dataProvider = "getPaymenttoProducer", enabled = true, priority = 8, groups = "GeneralLedgerCommission", description = "Verify Payment to Producer")
	public void verifyPayproducer_Validate_ACH(Hashtable<String,String>data) throws InterruptedException, AWTException {		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.clickOnAdministration();
		Thread.sleep(3000);
		GeneralLedgerCommissionPage generalLedgerCommissionPage = PageFactory.initElements(driver, GeneralLedgerCommissionPage.class);
		generalLedgerCommissionPage.clickGeneralLC();
		Thread.sleep(5000);
		generalLedgerCommissionPage.clickPayProducer();
		Thread.sleep(3000);	
		generalLedgerCommissionPage.validateDescrip(data.get("pay_Description"));
        Thread.sleep(3000);
        generalLedgerCommissionPage.clickPayProdACH();
        Thread.sleep(5000);
		generalLedgerCommissionPage.clickPayProdACHDetails();
		Thread.sleep(3000);
		generalLedgerCommissionPage.checkbox();
        Thread.sleep(3000);       
	}
	
	
	@Test (dataProvider = "getPaymenttoProducer", enabled = true, priority = 9, groups = "GeneralLedgerCommission", description = "Verify Payment to Producer")
	public void verifyPaytoProducer_AmountField(Hashtable<String,String>data) throws InterruptedException, AWTException {		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.clickOnAdministration();
		Thread.sleep(3000);
		GeneralLedgerCommissionPage generalLedgerCommissionPage = PageFactory.initElements(driver, GeneralLedgerCommissionPage.class);
		generalLedgerCommissionPage.clickGeneralLC();
		Thread.sleep(5000);
		generalLedgerCommissionPage.clickPayProducer();
		Thread.sleep(3000);			
		generalLedgerCommissionPage.validateDescrip(data.get("pay_Description"));
        Thread.sleep(3000);                  
        generalLedgerCommissionPage.chq();
        Thread.sleep(3000);
        generalLedgerCommissionPage.chqno(data.get("CheckNum"));
        Thread.sleep(3000);
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
        generalLedgerCommissionPage.amountMaxChar();	
        Thread.sleep(3000);
        generalLedgerCommissionPage.clickPayProducer();
        Thread.sleep(3000);
	} 
	
	
	
	
}

