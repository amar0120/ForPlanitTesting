package com.abhibus.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.abhibus.commons.SuperPage;

public class BusListPage {
	
	@FindBy(xpath="(//span[@class='f-left'][contains(.,'Operator')])[1]")
	private WebElement busOperators;	
	@FindBy(xpath="//label[@for='TravelsName5'][contains(.,'Ganga Travels')]")
	private WebElement gangaTraveles;	
	@FindBy(xpath="(//span[@class='book'][contains(.,'Select Seat')])[2]")
	private WebElement selectSeat;	
	@FindBy(id="O4-8ZZ")
	private WebElement seat1;	
	@FindBy(id="O5-8ZZ")
	private WebElement seat2;	
	@FindBy(xpath="//*[@id='boardingpoint_id1']")
	private WebElement boardingPoint;	
	@FindBy(xpath="//div[contains(@class,'red-landmark')]")
	private WebElement addressLandmark;	
	@FindBy(xpath="//input[contains(@type,'submit')]")
	private WebElement submitButton;	
	@FindBy(xpath="(//span[@class='f-left'][contains(.,'Operator')])[2]")
	private WebElement busOperatorReturn;	
	@FindBy(xpath="//label[@for='TravelsNameR6'][contains(.,'Ganga Travels')]")
	private WebElement gangaTravelesReturn;	
	@FindBy(xpath="(//span[@class='book'][contains(.,'Select Seat')])[4]")
	private WebElement selectSeatReturn;
	@FindBy(xpath="(//a[@id='O4-10ZZ'])[2]")	
	private WebElement seat1_Return;	
	@FindBy(xpath="(//a[@id='O5-10ZZ'])[2]")
	private WebElement seat2_Return;	
	@FindBy(xpath="//*[@id='boardingpoint_id2']")
	private WebElement boardingPointReturn;	
	@FindBy(xpath="(//div[contains(@class,'red-landmark')])[2]")
	private WebElement addressLandmarkReturn;	
	@FindBy(xpath="(//input[contains(@value,'Continue to Payment ')])[2]")
	private WebElement contiueToPayment;
	
	
	public BusListPage() {
		PageFactory.initElements(SuperPage.driver, this);
	}
	
	public void selectOperator() {
		busOperators.click();
		gangaTraveles.click();
		busOperators.click();
	}
	
	public void selectSeats() {
		selectSeat.click();
		
		JavascriptExecutor js=(JavascriptExecutor) SuperPage.driver;
		js.executeScript("scroll(0, 350);");
		js.executeScript("scroll(0, 350);");
		
		seat1.click();
		seat2.click();
	}
	
	public void selectBoardingPoint() throws Exception {
		Select select=new Select(boardingPoint);		
		select.selectByIndex(2);
		Thread.sleep(2000);
	}
	
	public void clickOnSubmit() {
		submitButton.click();
	}
	
	public void selectOperatorReturn() {
		busOperatorReturn.click();
		gangaTravelesReturn.click();
		busOperatorReturn.click();
	}
	
	public void selectSeatsReturn() throws Exception
	{
		selectSeatReturn.click();	
		
		JavascriptExecutor js=(JavascriptExecutor) SuperPage.driver;
		js.executeScript("scroll(0,350);");
		js.executeScript("scroll(0,250);");
		
		seat1_Return.click();
		seat2_Return.click();
	}
	
	public void selectBoardingPointReturn() throws Exception {
		Select select=new Select(boardingPointReturn);		
		select.selectByIndex(1);
		Thread.sleep(2000);
	}
	
	public void clickOnContinuePayment() {
		contiueToPayment.click();
	}
	
	
}
