package com.trigent.test;

import java.awt.AWTException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.trigent.base.BaseTest;
import com.trigent.pages.DashboardPage;
import com.trigent.pages.EmployerListPage;
import com.trigent.pages.ProducerPage;

public class VerifyProducerDetails extends BaseTest{	
	
	EmployerListPage employerlistPage;
	
	@Test 
	public void VerifyProducers() throws InterruptedException, AWTException{
		//Click Administration Menu
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.clickOnAdministration();
		Thread.sleep(5000);
		
		//Click Producer Sub-menu
		ProducerPage producerpage = PageFactory.initElements(driver, ProducerPage.class);
		producerpage.clickOnProducers();
		Thread.sleep(5000);		
		
		//Verify the number of Producers in the grid and print their names
		producerpage.verifyNumofRows_ProducerAgency();
		Thread.sleep(5000);
		
		//Now we are verifying the Producer in a Particular Employer		 
		dashboardPage.clickOnEmployerList();
		Thread.sleep(5000);	
		
		//Click any employer from the grid
		EmployerListPage employerlistPage = PageFactory.initElements(driver, EmployerListPage.class);
		//employerlistPage.ClickFirstEmployer();
		employerlistPage.checkEmployerStatus(); 
		Thread.sleep(5000);	
		
		//verify the ProducerAgency name of the Employer
		employerlistPage.click_Verify_ProducerAgencyName();
		Thread.sleep(5000);	
					
	}
}
