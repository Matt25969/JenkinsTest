package test.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestChromeDriver {

	@Test
	public void testGoogleSearch() throws InterruptedException {
		// Optional, if not specified, WebDriver will search your path for .
		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com/xhtml");
		Thread.sleep(2000); // Let the user actually see something!
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Bunnies");
		searchBox.submit();
		Thread.sleep(2000); // Let the user actually see something!
		WebElement imageBox = driver.findElement(By.className("qs"));
		imageBox.click();
		Thread.sleep(5000);

		driver.quit();
	}

}
