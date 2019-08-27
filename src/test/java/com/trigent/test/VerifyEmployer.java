package com.trigent.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.xml.fastinfoset.sax.Properties;
import com.trigent.base.BaseTest;
import com.trigent.pages.EmployerList;

public class VerifyEmployer extends BaseTest{
	Properties config = new Properties();
	
	EmployerList employerListPage;
	@Test
	public void verifyEmployerListLabel() throws Exception{
		//Verify Employer List Page
		employerListPage=PageFactory.initElements(driver, EmployerList.class);
		employerListPage.verifyEmployerListPage();		
		Assert.assertTrue(employerListPage.verifyEmployerListPage(), "Employer list label is missing");

//Click Employer List
		employerListPage.clickOnEmployerList();
		
		employerListPage.VerifyNumofEmployer_ListtheNames();
		
	}
}
  