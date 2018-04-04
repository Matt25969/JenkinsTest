package test.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseClickTest {

	WebDriver driver = null;

	Actions action = null;

	public void selectTab(String tabCSS) {

		WebElement tab = driver.findElement(By.cssSelector(tabCSS));
		tab.click();

	}

	public void screenshot() {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = "C:/Users/Admin/eclipse-workspace/Portfolio Workspace/Java-Portfolio/Selenium Test/screen/"
				+ "Pass" + dateName + ".png";

		File finalDestination = new File(destination);

		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Before

	public void setUp() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");

		driver = new ChromeDriver();

		action = new Actions(driver);

		driver.get("http://demoqa.com/");

		driver.manage().window().maximize();

	}

	@Test
	@Ignore
	public void firstTest() throws InterruptedException {

		selectTab("#menu-item-374 > a");

		WebElement firstName = driver.findElement(By.id("name_3_firstname"));

		firstName.sendKeys("Matt");

		action.sendKeys(Keys.TAB).perform();

		HelperMethods.sleepHelper();

		action.sendKeys("Hunt").perform();

		action.sendKeys(Keys.TAB).perform();

		action.sendKeys(Keys.SPACE).perform();

		action.sendKeys(Keys.TAB).perform();

		action.sendKeys(Keys.SPACE).perform();

		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.TAB).perform();

		action.sendKeys(Keys.ARROW_DOWN).perform();
		HelperMethods.sleepHelper();

		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.ARROW_DOWN).perform();
		HelperMethods.sleepHelper();

		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.ARROW_DOWN).perform();
		HelperMethods.sleepHelper();

		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.ARROW_DOWN).perform();
		HelperMethods.sleepHelper();

		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("4456896584").perform();

		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("jhgfdfkjghsdfslkdajfhglidajhgsdfsdflkdajfhgl").perform();

		// Do something with random for these 2

		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("afesdfwra@sgfrwersfdsf.com").perform();

		action.sendKeys(Keys.TAB).perform();

		driver.switchTo().frame(0);

		// action.sendKeys(Keys.ENTER).perform();
		//
		action.sendKeys("andy.png").perform();
		//
		action.sendKeys(Keys.ENTER).perform();

		driver.switchTo().defaultContent();

		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("I HEART BURGERS").perform();

		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("I HEART BURGERS").perform();

		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("I HEART BURGERS").perform();

		HelperMethods.sleepHelper();
		HelperMethods.sleepHelper();
		HelperMethods.sleepHelper();
		HelperMethods.sleepHelper();

		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.ENTER).perform();

		HelperMethods.sleepHelper();
		HelperMethods.sleepHelper();
		HelperMethods.sleepHelper();
		HelperMethods.sleepHelper();

		HelperMethods.screenshot();

		driver.quit();

	}

	@Test
	@Ignore
	public void secondTest() throws InterruptedException {

		selectTab("#menu-item-140 > a");

		WebElement dragMeAround = driver.findElement(By.cssSelector("#draggable > p"));

		action.dragAndDropBy(dragMeAround, 100, 100).perform();

		HelperMethods.sleepHelper();

		screenshot();

	}

	@Test
	@Ignore
	public void thirdTest() {

		selectTab("#menu-item-141 > a");

		WebElement dragMeAround = driver.findElement(By.cssSelector("#draggableview > p"));

		WebElement dropGround = driver.findElement(By.cssSelector("#droppableview"));

		action.dragAndDrop(dragMeAround, dropGround).perform();

		HelperMethods.sleepHelper();

		screenshot();

	}

	@Test
	@Ignore
	public void fourthTest() {

		selectTab("#menu-item-143 > a");

		WebElement resizeElement = driver.findElement(By.cssSelector(
				"#resizable > div.ui-resizable-handle.ui-resizable-se.ui-icon.ui-icon-gripsmall-diagonal-se"));

		action.dragAndDropBy(resizeElement, 1000, 1000).perform();

		HelperMethods.sleepHelper();

		screenshot();

	}

	@Test
	@Ignore

	public void fifthTest() {

		selectTab("#menu-item-142 > a");

		WebElement item = null;

		action.keyDown(Keys.LEFT_CONTROL).perform();

		for (int i = 1; i < 8; i += 1) {

			item = driver.findElement(By.cssSelector("#selectable > li:nth-child(" + i + ")"));

			action.moveToElement(item).perform();

			action.click().perform();

		}

		HelperMethods.sleepHelper();

		screenshot();

	}

	@Test
	@Ignore

	public void sixthTest() {

		selectTab("#menu-item-151");

		WebElement item = null;

		for (int i = 1; i < 8; i += 2) {

			item = driver.findElement(By.cssSelector("#sortable > li:nth-child(" + i + ")"));

			action.dragAndDropBy(item, 0, 100).perform();

		}

		HelperMethods.sleepHelper();

		screenshot();

	}

	@Test
	@Ignore
	public void seventhTest() {

		selectTab("#menu-item-144 > a");

		WebElement item = null;

		for (int i = 4; i < 11; i += 2) {

			item = driver.findElement(By.cssSelector("#ui-id-" + i));

			item.click();

		}

		HelperMethods.sleepHelper();

		screenshot();

	}

	@Test
	@Ignore
	public void eighthTest() throws InterruptedException {

		selectTab("#menu-item-145 > a");

		WebElement firstItem = driver.findElement(By.cssSelector("#tagss"));
		firstItem.click();

		action.sendKeys("Sc").perform();
		HelperMethods.sleepHelper();

		for (int i = 0; i < 4; i++) {

			action.sendKeys(Keys.ARROW_DOWN).perform();
			HelperMethods.sleepHelper();

		}

		action.sendKeys(Keys.ENTER).perform();

		HelperMethods.sleepHelper();

		screenshot();

	}

	@Test
	@Ignore
	public void ninthTest() {

		selectTab("#menu-item-146 > a");

		WebElement calendarElement = driver.findElement(By.cssSelector("#datepicker1"));

		calendarElement.click();

		WebElement dateElement = driver.findElement(
				By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(3) > td:nth-child(3) > a"));

		dateElement.click();

		HelperMethods.sleepHelper();

		screenshot();

	}

	@Test
	@Ignore
	public void tenthTest() {

		selectTab("#menu-item-147 > a");

		for (int i = 1; i < 6; i++) {

			WebElement menuElement = driver.findElement(By.cssSelector("#navigate > ul > li:nth-child(" + i + ") > a"));

			menuElement.click();

			HelperMethods.sleepHelper();

			screenshot();

		}

	}

	@Test
	@Ignore

	public void eleventhTest() {

		selectTab("#menu-item-97 > a");

		WebElement sliderElement = driver.findElement(By.xpath("//*[@id=\"slider-range-max\"]/span"));

		action.moveToElement(sliderElement).clickAndHold().moveByOffset(300, 0).perform();

		HelperMethods.sleepHelper();

		screenshot();

	}

	@Test
	@Ignore

	public void twelfthTest() {

		selectTab("#menu-item-98 > a");

		for (int i = 1; i < 4; i++) {

			WebElement item = driver.findElement(By.xpath("//*[@id=\"ui-id-" + i + "\"]"));

			action.moveToElement(item).click().perform();

			HelperMethods.sleepHelper();

			screenshot();

		}

	}

	@Test
	@Ignore

	public void thirteenthTest() {

		selectTab("#menu-item-99 > a");

		WebElement item = null;

		for (int i = 1; i < 3; i++) {

			item = driver.findElement(By.cssSelector("#tabs-1 > div > p:nth-child(" + i + ") > a"));

			action.moveToElement(item).perform();

			HelperMethods.sleepHelper();

			screenshot();

		}

		item = driver.findElement(By.xpath("//*[@id=\"age\"]"));
		action.moveToElement(item).perform();

		HelperMethods.sleepHelper();

		screenshot();

	}

	@Test
	@Ignore

	public void fourteenthTest() {

		selectTab("#menu-item-148 > a");

		WebElement item = driver.findElement(By.cssSelector("#tabs-1 > div > p > a"));

		action.moveToElement(item).click().perform();

		HelperMethods.sleepHelper();

		screenshot();

	}

	@Test
	@Ignore

	public void cookieTest() {

		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(("size of cookies") + cookies.size());
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + ": " + cookie.getValue());
		}
		driver.manage().deleteAllCookies();

		cookies = driver.manage().getCookies();
		System.out.println("Size of cookies :" + cookies.size());

	}

	@After
	public void tearDown() {

		driver.quit();

	}
}
