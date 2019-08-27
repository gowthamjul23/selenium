package com.trigent.test;

import java.awt.AWTException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.xml.fastinfoset.sax.Properties;
import com.trigent.base.BaseTest;
import com.trigent.pages.DashboardPage;
import com.trigent.pages.EmployeeClasses;
import com.trigent.pages.EmployerList;
import com.trigent.pages.LoginPage;
import com.trigent.pages.PlanInformation;
import com.trigent.pages.UploadCensusPage;


public class VerifyUploadCensus extends BaseTest {
	LoginPage loginPage;
	DashboardPage dashBoardPage;
	EmployerList employerListPage;
	EmployeeClasses employeeClassesPage;
	PlanInformation planInformationPage;  
	UploadCensusPage UploadCensus;
	
	Properties config = new Properties();
	
	//***************************************************************************************************************************************************************************
		//Smoke Test Cases Method
		@Test
		public void CensusUpload() throws InterruptedException, AWTException {
			
			//Click Employer list
			employerListPage=PageFactory.initElements(driver, EmployerList.class); 
			employerListPage.clickOnEmployerList();	
			
			//Select the employer whose status is waiting
			employeeClassesPage=PageFactory.initElements(driver, EmployeeClasses.class);
		//	employeeClassesPage.SelectEmployerByName();
			employeeClassesPage.SelectEmployerStatusW(); 
			
			// Select the Employee
			UploadCensus=PageFactory.initElements(driver, UploadCensusPage.class);	
			
			UploadCensus.SelectEmployee(); 
			
			// Verify the Upload Census popup
			UploadCensus.verifyUploadCensusPage();  
			
			 //Upload the census file
			UploadCensus.UploadCensus(); 
			
			 //Verify the uploaded file 
			UploadCensus.VerifyCensus(); 
			
			 // Select the Employee tab and count the record of census
			UploadCensus.SelectEmployee(); 
			UploadCensus.CountCensusRecord(); 
			

	 	}

		
}
