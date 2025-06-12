package Selenium_Concept.Selenium_Concept;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

public class Flight_Select_page extends Flilght_booking_site {

	@Test(priority = 6)
	public void ss() throws InterruptedException {
		FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"splitClsListingDetailsBottom\"]")));
		Thread.sleep(10000);

		List<WebElement> priceElements = driver.findElements(By.xpath("//*[@class='fontSize22 boldFont' and text()]"));
		Map<Integer, WebElement> priceMap = new TreeMap<>(); // TreeMap keeps keys sorted

		for (WebElement element : priceElements) {
			String text = element.getText().replaceAll("[^0-9]", "");
			if (!text.isEmpty()) {
				int priceValue = Integer.parseInt(text);
				priceMap.put(priceValue, element);
			}
		}

		// Click the lowest-priced element
		WebElement cheapestOption = priceMap.entrySet().iterator().next().getValue();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", cheapestOption);
		driver.manage().window().maximize();

		js.executeScript("arguments[0].scrollIntoView(true);", cheapestOption);

	}

}
