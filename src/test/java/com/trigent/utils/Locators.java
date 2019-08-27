package com.trigent.utils;

public class Locators {
	
	// login page locators
	public static final String userName = "//input[@name='username']";
	public static final String userPassword = "//input[@name='password']";
	public static final String loginButton = "//button[@id='submitBtn']";
	public static final String invalidLoginMsg = "//div[@class='alert alert-danger']/strong";
	
	// dashboard page locators
	public static final String employerListLabel = "//div[contains(@class,'panel-heading')]/span[contains(text(),'Employer List')]";
	public static final String administartionlink="//div[contains(@class,'collapse navbar-collapse navbar-ex1-collapse')]/ul[1]/li[1]/a";
	public static final String employerListlink="//div[contains(@class,'collapse navbar-collapse navbar-ex1-collapse')]/ul[1]/li[2]";
	public static final String addNewEmployerButton="//button[@id='addEmployerBtn']";
	public static final String welcome = "//a[@id='welcome']";
	//pim header
	public static final String pim = "//b[contains(text(),'PIM')]";
	public static final String addEmployee = "//a[@id='menu_pim_addEmployee']";
	//Administration locators
//	public static final String administartionlink="//div[contains(@class,'collapse navbar-collapse navbar-ex1-collapse')]/ul[1]/li[1]/a";
	

	//Add Employer locators
	public static final String addEmployerBtn="//button[@id='addEmployerBtn']";
	public static final String employerName="//input[@name='Name']";
	public static final String employerAddress1="//input[@name='Address1']";
	 
	public static final String employerEffectiveDate="//table[@id='customFields']/tbody/tr[1]/td[2]/input[@name='EffectiveDate[]']";
	
	public static final String employerTerminationDate="//table[@id='customFields']/tbody/tr[1]/td[3]/input[@name='TerminationDate[]']";
	public static final String  saveNewEmployerButton="//div[@class='panel-heading']/span[2]/button[@id='saveNewEmployerBtn']";
	public static final String editEmployerAddAgencyButton="//a[contains(@class,'btn btn-small btn-warning addCF')]";
	public static final String addEmployeeLink="//div[contains(@class,'bs-example')]/ul/li[3]";
	public static final String addEmployerSuccessfullyMessage="//div[@class='modal-body']/div[2]/div[@id='message']";
	public static final String employerStateMandaoryField="//form[@id='employerInfoForm']/span[contains(text(),'* Employer State Cannot be Blank.')]";
	
	
	//Employer Edit
	
	public static final String  editEmployerBtn="//button[@id='editEmployerInfo']";
	public static final String  editEmployerName="//form[@id='employerInfoForm']/input[@name='Name']";
	public static final String saveEditEmployerBtn="//span[@id='edit_info_btn']/button[@id='saveEmployerInfo']";
	public static final String deleteAgencyBtn="//table[@id='customFields']/tbody/tr[1]/td[4]/button[contains(text(),'Remove')]";
	//Add Agency
	public static final String addAgencyButton="//form[@id='employerInfoForm']/table[@id='customFields']/thead/tr/th[4]/span/a";
	public static final String viewAgnecyLink="//table[@id='formsTable']/tbody/tr[1]/td[1]";
	
	public static final String cancelEmployerBtn="//div[@class='panel-heading']/span[2]/button[2][contains(text(),Cancel)]";
	public static final String AgencyNameColumn="//div[@id='employerEditFrmSection']/table[@id='formsTable']/thead/tr[1]/th[1]";
	public static final String AgencyNameLabel="//table[@id='formsTable']/thead/tr/th[1]";
	public static final String effectiveDateLabel="//table[@id='formsTable']/thead/tr/th[2]";
	public static final String terminationdateLabel="//table[@id='formsTable']/thead/tr/th[3]";
//plan information
	
	public static final String employerListLink="//div[contains(@class,'collapse navbar-collapse navbar-ex1-collapse')]/ul[1]/li[2]";
		
//invoice Page
	public static final String invoiceLabel="//span[contains(text(),'Invoices')]";
	public static final String payTotalOutStandingBalanceBtn="//button[@id='bulkPayButton']";
	public static final String selectPayBtnDropdownBtn="//tbody[@aria-live='polite']//tr[2]//td[12]//div[1]//button[2]//span[1]";
	public static final String clickCreditOption="//table[@id='invoiceTable']/tbody/tr[2]/td[12]/div/ul/li[1]";
	public static final String confirmYesBtnOfInvoicePay="//button[@id='yesConfirm']";
	public static final String confirmNOPayNowOfInvoice="//button[@id='noConfirm']";
	public static final String selecteEmployeeCheckBox="//input[@id='selectedEmployee']";
	public static final String confirmationMessageOfTotalPay="//div[@id='infoMsgGeneral'][contains(text(),'Are you sure you want to pay total outstanding balance of')]";
	public static final String confirmationMessageAfterPayNoNowBtn="//div[@id='infoMsg']/h2[contains(text(),'Premium processed & Commission calculated for the InvoiceID:')]";
	public static final String closeBtnAfterPayNoNowBtn="//button[@id='infoCloseBtn']";
	public static final String confirmYesBtnForTotalPay="//div[@class='modal-footer']/button[@id='yesConfirmtotbal']";
	public static final String confirmNoBtnForTodtalPay="//div[@class='modal-footer']/button[@id='noConfirmtotbal']";
	public static final String invoiceNumber="//th[@class='tablesorter-header tablesorter-headerUnSorted']//div[@class='tablesorter-header-inner'][contains(text(),'Invoice Number')]";
	public static final String invoiceType="//table[@id='invoiceTable']/thead/tr/th[3]/div[contains(text(),'Invoice Type')]";
	public static final String invoiceDate="//table[@id='invoiceTable']/thead/tr/th[4]/div[contains(text(),'Invoice Date')]";
	public static final String dueDate="//table[@id='invoiceTable']/thead/tr/th[5]/div[contains(text(),'Due Date')]";
	public static final String invoiceAmount="//table[@id='invoiceTable']/thead/tr/th[6]/div[contains(text(),'Invoice Amount')]";
	public static final String amountPaid="//table[@id='invoiceTable']/thead/tr/th[7]/div[contains(text(),'Amount Paid')]";
	public static final String lastPaidDate="//table[@id='invoiceTable']/thead/tr/th[8]/div[contains(text(),'Last Paid Date')]";
	public static final String outstandingBalance="//table[@id='invoiceTable']/thead/tr/th[9]/div[contains(text(),'Outstanding Balance')]";
	public static final String paidStatus="//table[@id='invoiceTable']/thead/tr/th[10]/div[contains(text(),'Paid Status')]";
	public static final String viewInvoicePDF="//table[@id='invoiceTable']/thead/tr/th[11]/div[contains(text(),'View Invoice PDF')]";
	public static final String payOption="//table[@id='invoiceTable']/thead/tr/th[12]/div[contains(text(),'Pay Option')]";
	
	public static final String viewInvoicePDFBtn="//div[@class='tab-pane fade active in']//tbody[@aria-live='polite']//tr[1]//td[11]//button[1]";
}
