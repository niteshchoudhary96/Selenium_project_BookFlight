package Selenium_Concept.Selenium_Concept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import Utilities.Browser;

public class Implicit_wait extends Browser {
	
	

	
	
	@Test
	public void implicit_wait()  {
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//open wesite
	driver.get(pr.getProperty("Website"));
		
	driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		
	}
	
	public void SearchFlight() {
		
	WebElement SearchButton =	driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']"));
	//SearchButton.click();
	
		try  {
			
			//SearchButton.click();
			
		}catch (Exception e) {
			
			
			System.out.println(e.getMessage());
		}
		finally {
			if(SearchButton.isDisplayed()) {
				SearchButton.click();
			}
			
		}
		
	}
	
	

}
