package com.abhibus.userscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.abhibus.commons.ExcelLibClass;
import com.abhibus.commons.SuperPage;
import com.abhibus.pages.BusListPage;
import com.abhibus.pages.Homepage;

public class PlanJurneyTC extends SuperPage {
	
	@Test(priority=0)
	public void testLogoTextVerification() throws Exception {
		Homepage homepage=new Homepage();		
		assertEquals(homepage.getLogoText(), ExcelLibClass.readXlsData("Sheet1", 2,6));		
	}	
	
	@Test(priority=1)
	public void testEnterJurneyDetails() throws Exception
	{
		Homepage homepage=new Homepage();
		String source=ExcelLibClass.readXlsData("Sheet1", 2, 2);
		String dest=ExcelLibClass.readXlsData("Sheet1", 2, 3);
		homepage.enterSourceInTextbox(source);
		homepage.enterDestinationInTextbox(dest);
		homepage.enterDateOfJurney();
		homepage.enterDateOfJurneyReturn();
		homepage.clickOnSearch();
	}
	
	@Test(priority=2)
	public void testSelectBusSeats() throws Exception
	{
		BusListPage searchedDetails=new BusListPage();
		searchedDetails.selectOperator();
		searchedDetails.selectSeats();		
		searchedDetails.selectBoardingPoint();
		searchedDetails.clickOnSubmit();
		
	}
	
	@Test(priority=3)
	public void testReturnSelection() throws Exception
	{		
		BusListPage searchedDetails=new BusListPage();
		searchedDetails.selectOperatorReturn(); 
		searchedDetails.selectSeatsReturn();
		searchedDetails.selectBoardingPointReturn();
		searchedDetails.clickOnContinuePayment();			
	}
}
