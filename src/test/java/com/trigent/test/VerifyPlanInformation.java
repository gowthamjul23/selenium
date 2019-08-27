package com.trigent.test;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.xml.fastinfoset.sax.Properties;
import com.trigent.base.BaseTest;
import com.trigent.pages.DashboardPage;
import com.trigent.pages.EmployeeClasses;
import com.trigent.pages.EmployerList;
import com.trigent.pages.EmployerListPage;
import com.trigent.pages.LoginPage;
import com.trigent.pages.PlanInformation;
import com.trigent.utils.TestUtil;

public class VerifyPlanInformation extends BaseTest{
	LoginPage loginPage;
	DashboardPage dashBoardPage;
	EmployerList employerListPage;
	EmployerListPage emplist;
	PlanInformation planInformationPage;
	Properties config = new Properties();
	
	public void verifyEmployee() throws InterruptedException {
		//click Employer List
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.clickOnEmployerList();
		Thread.sleep(5000);
	}


	
		@Test
		public void planinfo() throws InterruptedException {
			employerListPage=PageFactory.initElements(driver, EmployerList.class);
			employerListPage.clickOnEmployerList(); 
			
			EmployeeClasses employeeClassesPage = PageFactory.initElements(driver, EmployeeClasses.class);
			employeeClassesPage.SelectEmployerStatusA();
			
			planInformationPage=PageFactory.initElements(driver, PlanInformation.class);
			planInformationPage.PlanInfo();
			planInformationPage.Selectplan();
		}	
			
	}
	

