package com.trigent.test;
import java.awt.AWTException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.trigent.base.BaseTest;
import com.trigent.pages.DashboardPage;
import com.trigent.pages.UploadPaymentPage;

public class VerifyCheckUpload extends BaseTest{
	@Test
	public void CheckUpload() throws InterruptedException, AWTException {
	DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
	dashboardPage.clickOnAdministration();
	Thread.sleep(5000);
	UploadPaymentPage uploadpaymentpage = PageFactory.initElements(driver, UploadPaymentPage.class);
	uploadpaymentpage.clickUploadPaymentMenu();
	Thread.sleep(3000);
	uploadpaymentpage.clickUploadPaymentBtn();
	Thread.sleep(3000);
	//uploadpaymentpage.chooseFile_Unmatchedpayment();
	uploadpaymentpage.chooseFile_Matchedpayment();
	Thread.sleep(3000);		
	uploadpaymentpage.clickUploadBtn2();
	Thread.sleep(5000);
	uploadpaymentpage.validateUploadSuccessMsg();			
	 
	}
}
