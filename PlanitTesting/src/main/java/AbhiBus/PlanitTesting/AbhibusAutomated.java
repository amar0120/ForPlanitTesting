package AbhiBus.PlanitTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AbhibusAutomated {

	public static void main(String[] args) throws Exception {		
				
		System.setProperty("webdriver.gecko.driver","./resources/drivers/geckodriver.exe" );
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.abhibus.com/");
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
			
		Case2_toolTip(driver);	
		Case3_FromToDateSearch(driver);
		
//		js.executeScript("scrollBy(5000,0)");
		
	
		
		driver.findElement(By.xpath("(//span[@class='f-left'][contains(.,'Operator')])[1]")).click();
		driver.findElement(By.xpath("//label[@for='TravelsName5'][contains(.,'Ganga Travels')]")).click();
		driver.findElement(By.xpath("(//span[@class='f-left'][contains(.,'Operator')])[1]")).click();
		
		driver.findElement(By.xpath("(//span[@class='book'][contains(.,'Select Seat')])[2]")).click();
		
		System.out.println(driver.findElement(By.xpath("//a[contains(@id,'O4-8ZZ')]")).getAttribute("class"));		
				
		
//		WebElement wElement=driver.findElement(By.xpath("//h2[contains(.,'We are social ! Connect with us on  FaceBook , Twitter , Google+ and Youtube')]"));		
//		js.executeScript("arguments[0].scrollIntoView(true);", wElement);
		/*
		 * js.executeScript("scrollBy(1000,0)"); Thread.sleep(2000);
		 * js.executeScript("scrollBy(1000,0)"); Thread.sleep(2000);
		 */		
		
		js.executeScript("scroll(0, 350);");
		js.executeScript("scroll(0, 350);");

		
						
		driver.findElement(By.xpath("//a[contains(@id,'O4-8ZZ')]")).click();
		driver.findElement(By.xpath("//a[contains(@id,'O5-8ZZ')]")).click();
		
		System.out.println("Total fare --> "+driver.findElement(By.xpath("//*[@id='totalfare']")).getText());
		
		Select select=new Select(driver.findElement(By.xpath("//*[@id='boardingpoint_id1']")));
		
		select.selectByIndex(2);
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'red-landmark')]")).getText());
		
	
		Thread.sleep(2000);
				
		// Return Ticket
		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
		
		driver.findElement(By.xpath("(//span[@class='f-left'][contains(.,'Operator')])[2]")).click();
		driver.findElement(By.xpath("//label[@for='TravelsNameR6'][contains(.,'Ganga Travels')]")).click();
		driver.findElement(By.xpath("(//span[@class='f-left'][contains(.,'Operator')])[2]")).click();
		driver.findElement(By.xpath("(//span[@class='book'][contains(.,'Select Seat')])[4]")).click();

		js.executeScript("scroll(0,350);");
		js.executeScript("scroll(0,250);");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//a[@id='O4-10ZZ'])[2]")).click();
		driver.findElement(By.xpath("(//a[@id='O5-10ZZ'])[2]")).click();
		
		Select select1=new Select(driver.findElement(By.xpath("//*[@id='boardingpoint_id2']")));
		
		select1.selectByIndex(1);
		System.out.println(driver.findElement(By.xpath("(//div[contains(@class,'red-landmark')])[2]")).getText());
		
		driver.findElement(By.xpath("(//input[contains(@value,'Continue to Payment ')])[2]")).click();
		
		Thread.sleep(5000);		
//		driver.close();
	}

	private static void Case3_FromToDateSearch(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='source']")).sendKeys("Delh");
		Thread.sleep(3000);
		List <WebElement> listOfSources = driver.findElements(By.xpath("//ul[@id='ui-id-1']"));
		listOfSources.get(0).click();
		
		driver.findElement(By.xpath("//*[@id='destination']")).sendKeys("Agr");
		Thread.sleep(3000);
		List <WebElement> listOfDest = driver.findElements(By.xpath("//ul[@id='ui-id-2']"));
		listOfDest.get(0).click();
				
		driver.findElement(By.xpath("//*[@id='datepicker1']")).click();		
		driver.findElement(By.xpath("/html/body/div[7]/div[1]/table/tbody/tr[4]/td[2]/a")).click();		
		
		driver.findElement(By.xpath("//*[@id='datepicker2']")).click();		
		driver.findElement(By.xpath("/html/body/div[7]/div[1]/table/tbody/tr[5]/td[1]/a")).click();		
		
		driver.findElement(By.linkText("Search")).click();
	}

	private static void Case2_toolTip(WebDriver driver) {
		Actions act=new Actions(driver);
		WebElement logo=driver.findElement(By.xpath("/html/body/div[3]/div[1]/a/img"));
		act.moveToElement(logo).build().perform();
		
		String toolTipText="abhibus.com - India's Fastest Online bus ticket booking site";
		
		if(logo.getAttribute("alt").equals(toolTipText)) {
			System.out.println("Tool tip verified");
		}else {
			System.out.println("Tool tip verification failed.");
		}
	}

}
