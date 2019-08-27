package com.trigent.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.trigent.base.BaseTest;
import com.trigent.pages.PaymentTypes;
import com.trigent.pages.EmployeeClasses;

public class OnlineInvoicePayment extends BaseTest{
	
	EmployeeClasses employeeClassesPage;
	PaymentTypes CreditPayment;
	
	@Test
	
	public void Billing() throws InterruptedException 
	{
		
		employeeClassesPage =PageFactory.initElements(driver, EmployeeClasses.class); 
		employeeClassesPage.SelectEmployerStatusA();
		
		CreditPayment=PageFactory.initElements(driver, PaymentTypes.class); 
	    CreditPayment.ClickInvoiceTab();  
	    CreditPayment.VerifyUnpaidStatustopayOnline();
	    CreditPayment.VerifyConfirmationMessage();
}
}