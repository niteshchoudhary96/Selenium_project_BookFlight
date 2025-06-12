package Utilities;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class Browser  {
	public   WebDriver driver;
	public Properties pr = new Properties();
	public FileReader fr;

	@BeforeTest

	public void Open_broser() throws IOException {
		
		String Browser = "chrome1";

		if (Browser.equals("chrome")) {
           driver = new ChromeDriver();

		} else if (Browser.equalsIgnoreCase(Browser)) {
			driver = new FirefoxDriver();

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	


		FileReader fr = new FileReader(
				"C:\\Users\\nites\\OneDrive\\Desktop\\Selenium_Concepts\\Selenium_Concept\\Properties_data\\WEBURL.properties");
		this.pr.load(fr);

		System.out.println("weburl:  " + pr.getProperty("Website"));

	

}

	
	}


