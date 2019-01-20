package com.abhibus.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.abhibus.commons.ExcelLibClass;
import com.abhibus.commons.SuperPage;

public class Homepage {
	
	@FindBy(xpath="/html/body/div[3]/div[1]/a/img")
	private WebElement abhiBusLogo;	
	
	@FindBy(xpath="//*[@id='source']")	
	private WebElement leavingFrom;	
	
	@FindBy(xpath="//ul[@id='ui-id-1']")	
	private List<WebElement> listOfSources;	
	
	@FindBy(xpath="//*[@id='destination']")
	private WebElement goingTo;	
	@FindBy(xpath="//ul[@id='ui-id-2']")
	private List<WebElement> listOfDestinations;
	
	@FindBy(xpath="//*[@id='datepicker1']")
	private WebElement doj;
	@FindBy(xpath="/html/body/div[7]/div[1]/table/tbody/tr[4]/td[2]/a")
	private WebElement selectDate22Jan;
	
	@FindBy(xpath="//*[@id='datepicker2']")
	private WebElement doj_return;
	@FindBy(xpath="/html/body/div[7]/div[1]/table/tbody/tr[5]/td[1]/a")
	private WebElement selectDate28Jan;
	
	@FindBy(linkText="Search")
	private WebElement searchButton;
	
	public Homepage(){
		PageFactory.initElements(SuperPage.driver, this);
	}
	
	public String getLogoText() throws Exception {
		Actions act=new Actions(SuperPage.driver);
		act.moveToElement(abhiBusLogo).build().perform();
		Thread.sleep(2000);
		return abhiBusLogo.getAttribute("alt");		
	}
	
	public void enterSourceInTextbox(String source) throws Exception
	{
		leavingFrom.sendKeys(source);
		Thread.sleep(2000);		
		listOfSources.get(0).click();
	}
	
	public void enterDestinationInTextbox(String destination) throws Exception
	{
		goingTo.sendKeys(destination);
		Thread.sleep(2000);		
		listOfDestinations.get(0).click();
	}
	
	public void enterDateOfJurney() {
		doj.click();
		SuperPage.driver.findElement(By.linkText(ExcelLibClass.readXlsData("Sheet1", 2, 4))).click();
	}
	
	public void enterDateOfJurneyReturn() {
		doj_return.click();
		SuperPage.driver.findElement(By.linkText(ExcelLibClass.readXlsData("Sheet1", 2, 5))).click();
	}
	
	public void clickOnSearch() {
		searchButton.click();
	}

}
