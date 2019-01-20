package com.abhibus.commons;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.abhibus.commons.SuperPage;

public class Listener implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
		takeScreenShot(result.getName());
		
	}

	public void takeScreenShot(String methodName)
	{
		EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(SuperPage.driver);
		File sourceFile = eventFiringWebDriver.getScreenshotAs(OutputType.FILE);
		File targetFile = new File("./resources/failureScreenShots/"+methodName+".png");
		try
		{
			FileUtils.moveFile(sourceFile, targetFile);
		}
		catch (IOException io)
		{
			
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
}
