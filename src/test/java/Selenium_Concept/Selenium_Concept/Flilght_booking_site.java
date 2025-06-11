package Selenium_Concept.Selenium_Concept;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Utilities.Browser;

public class Flilght_booking_site extends Browser {

	@Test(priority = 1)
	public void Open_Website() {

		driver.get(pr.getProperty("Website"));// open Web-site

	}

	@Test(priority = 2)
	public void SearchFromFlight() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click(); // close login pop-up

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/label[@for=\"fromCity\"]"))).click();

		driver.findElement(By.xpath("//input[@placeholder=\"From\"]")).sendKeys("de");

//		WebElement ToLocationSearchBox = driver.findElement(By.xpath("//input[@id=\"fromCity\"]"));
//		ToLocationSearchBox.click();

		String fromcity = "NEW Delhi";
		List<WebElement> fromcityList = driver.findElements(By.xpath("//*[@id=\"react-autowhatever-1\"]//li"));

		for (int i = 0; i < fromcityList.size(); i++) {

			String fromcitylist = fromcityList.get(i).getText();
			// Thread.sleep(5000);
			if (fromcitylist.contains(fromcity)) {
				fromcityList.get(i).click();
				break;
			}

		}
	}

	@Test(priority = 3)
	public void SearchTOFlight() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/label[@for=\"toCity\"]"))).click();
	driver.findElement(By.xpath("//input[@placeholder=\"To\"]")).sendKeys("beng");
	
Thread.sleep(4000);
		String Tocity = "Bengaluru";
	//String tocity1 = "Dhanbad";
		List<WebElement> TocityList = driver.findElements(By.xpath("//div[@id=\"react-autowhatever-1\"]//li/div"));
		
		
		for(int i=0;i<TocityList.size();i++) {
			
			System.out.println("all city:     "+TocityList.get(i).getText());
			
			
		//	driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-0\"]//div")).click();
			if(TocityList.contains(Tocity)) {
				System.out.println("condition 1");
				TocityList.get(i).click();}
			else {
				System.out.println("condition 2");
driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-0\"]//div")).click();	
		break;	}
		}
		
		
		
		
		
		
		
		
		

//		for (WebElement Tocitys : TocityList) {
//
//			String AllTocitylist = Tocitys.getText();
//System.out.println(AllTocitylist);
//			if (AllTocitylist.contains(Tocity)) {
//				
//				//driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-0\"]")).click();
//				Tocitys.click();
//				
//			}else {
//				System.out.println("from city condition 2");
//				driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-0\"]")).click();
//			}
//
//		}
	}

	@Test(priority = 4)
	public void FlightDate_ClassType() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//div[@aria-label=\"Fri Jul 18 2025\"]//p[text()='18']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@class=\"flt_fsw_inputBox dates reDates inactiveWidget \"]")))
				.click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@aria-label=\"Sun Aug 24 2025\"]//p[text()='24']"))).click();

		driver.findElement(By.xpath("//div[@data-cy=\"flightTraveller\"]")).click();

		String MyAdultPassenger = "5";

		List<WebElement> Adult_Passenger = driver
				.findElements(By.xpath("//p[contains(text(), 'ADULTS (12y +)')]/following-sibling::ul"));

		for (int i = 0; i < Adult_Passenger.size(); i++) {
			String AlistValue = Adult_Passenger.get(i).getText(); // Parse integer safely

			if (AlistValue.contains(MyAdultPassenger)) {
				Adult_Passenger.get(i).click();

				break;
			}

		}

		String Mychild = "2";
		List<WebElement> Child = driver
				.findElements(By.xpath("//p[contains(text(), 'CHILDREN (2y - 12y )')]/following-sibling::ul//li"));

		for (WebElement childlist : Child) {

			String allnumchildsheet = childlist.getText();

			if (allnumchildsheet.contains(Mychild)) {

				childlist.click();
				break;

			}
		}

		String Mynewborn = "1";
		List<WebElement> newborn = driver
				.findElements(By.xpath("//p[contains(text(), 'INFANTS (below 2y)')]/following-sibling::ul//li"));

		for (WebElement newbornlist : newborn) {

			String allnumchildsheet = newbornlist.getText();

			if (allnumchildsheet.contains(Mynewborn)) {

				newbornlist.click();
				break;
			}
		}

		driver.findElement(By.xpath("//*[@data-cy=\"travelClass-1\" and contains(text(), 'Premium Economy')]")).click();

		driver.findElement(By.xpath("//*[@class=\"primaryBtn btnApply pushRight\"]")).click();

		driver.findElement(By.xpath("//*[@data-cy=\"submit\"]/a")).click();

	}

}
