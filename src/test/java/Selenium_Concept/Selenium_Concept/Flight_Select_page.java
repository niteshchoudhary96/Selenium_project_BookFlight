package Selenium_Concept.Selenium_Concept;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

public class Flight_Select_page extends Flilght_booking_site {

	
	
	@Test
	public void ss() throws InterruptedException {
		FluentWait<WebDriver> wait = new FluentWait<>(driver)
			    .withTimeout(Duration.ofSeconds(15))
			    .pollingEvery(Duration.ofSeconds(5))
			    .ignoring(NoSuchElementException.class);	

		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"splitClsListingDetailsBottom\"]")));
		Thread.sleep(10000);
		
	List<WebElement> images = driver.findElements(By.xpath("//*[@class=\"splitClsListingDetailsBottom\"]"));
	
	
	for (WebElement listimg :images) {
		System.out.println(listimg);
	}
	
	
	
	
	
	}
	
	
	
	
}
