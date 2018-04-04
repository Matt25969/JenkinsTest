package test.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicSeleniumTest {

	@Test
	public void testQA() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.qa.com/");
		Thread.sleep(2000); // Let the user actually see something!
		assertEquals(driver.getCurrentUrl(), "https://www.qa.com/");

		driver.quit();

	}

}
