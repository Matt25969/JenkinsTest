package test.test;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class IntermediateSeleniumTests {

	ExtentReports report;

	ExtentTest test;

	WebDriver driver;

	String user = null;

	String pass = null;

	String browser = null;

	Iterator<Row> rowIterator = null;

	@Test
	@Ignore

	public void verifyHomePageTitle() {

		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\Firstautomationreport.html", true);

		test = report.startTest("Verify application Title");
		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// add a note to the test
		test.log(LogStatus.INFO, "Browser started");
		driver.get("https://www.qa.com/");
		String title = driver.getTitle();
		System.out.println(title);
		if (title.equals("IT Training | Project Management Training | Business Skills Training | QA")) {
			// report the test as a pass
			test.log(LogStatus.PASS, "verify Title of the page");
		} else {
			test.log(LogStatus.FAIL, "verify Title of the page");
		}
		report.endTest(test);
		report.flush();

		driver.quit();
	}

	@Test
	@Ignore

	public void testLoginTestChrome() throws InterruptedException {

		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\Firstautomationreport.html", true);
		test = report.startTest("Verify application Title");

		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		test.log(LogStatus.INFO, "Browser started");

		driver.get("http://thedemosite.co.uk");
		Thread.sleep(2000); // Let the user actually see something!
		String title = driver.getTitle();

		WebElement addAUser = driver.findElement(By.cssSelector(
				"body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)"));
		addAUser.click();

		WebElement testUsernameField = driver.findElement(By.cssSelector(
				"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
		testUsernameField.sendKeys("bert");
		Thread.sleep(1000);

		WebElement testPasswordField = driver.findElement(By.cssSelector(
				"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
		testPasswordField.sendKeys("bert");
		Thread.sleep(1000);

		WebElement testButton = driver.findElement(By.cssSelector(
				"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
		testButton.click();
		Thread.sleep(1000);

		WebElement login = driver.findElement(By.cssSelector(
				"body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)"));
		login.click();

		WebElement loginUsernameField = driver.findElement(By.cssSelector(
				"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
		loginUsernameField.sendKeys("bert");
		Thread.sleep(1000);
		WebElement loginPasswordField = driver.findElement(By.cssSelector(
				"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
		loginPasswordField.sendKeys("bert");
		Thread.sleep(1000);
		WebElement loginButton = driver.findElement(By.cssSelector(
				"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
		loginButton.click();
		Thread.sleep(1000);

		WebElement loginMessage = driver.findElement(By.cssSelector(
				"body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b"));
		assertEquals(loginMessage.getText(), "**Successful Login**");

		report.endTest(test);
		report.flush();

		driver.quit();

	}

	@Test
	@Ignore

	public void testLoginTestFirefox() throws InterruptedException {

		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\Secondautomationreport.html", true);
		test = report.startTest("Verify application Title");

		System.setProperty("webdriver.gecko.driver", "C:/Development/web_driver/geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();

		test.log(LogStatus.INFO, "Browser started");

		driver.get("http://thedemosite.co.uk");
		Thread.sleep(2000); // Let the user actually see something!
		String title = driver.getTitle();

		WebElement addAUser = driver.findElement(By.cssSelector(
				"body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)"));
		addAUser.click();

		WebElement testUsernameField = driver.findElement(By.cssSelector(
				"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
		testUsernameField.sendKeys("bert");
		Thread.sleep(1000);

		WebElement testPasswordField = driver.findElement(By.cssSelector(
				"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
		testPasswordField.sendKeys("bert");
		Thread.sleep(1000);

		WebElement testButton = driver.findElement(By.cssSelector(
				"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
		testButton.click();
		Thread.sleep(1000);

		WebElement login = driver.findElement(By.cssSelector(
				"body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)"));
		login.click();

		WebElement loginUsernameField = driver.findElement(By.cssSelector(
				"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
		loginUsernameField.sendKeys("bert");
		Thread.sleep(1000);
		WebElement loginPasswordField = driver.findElement(By.cssSelector(
				"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
		loginPasswordField.sendKeys("bert");
		Thread.sleep(1000);
		WebElement loginButton = driver.findElement(By.cssSelector(
				"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
		loginButton.click();
		Thread.sleep(1000);

		WebElement loginMessage = driver.findElement(By.cssSelector(
				"body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b"));
		assertEquals(loginMessage.getText(), "**Successful Login**");

		report.endTest(test);
		report.flush();

		driver.quit();

	}

	@Test
	@Ignore

	public void testLoginTestFirefoxWithExcel() throws InterruptedException {

		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\Secondautomationreport.html", true);
		test = report.startTest("Verify application Title");

		System.setProperty("webdriver.gecko.driver", "C:/Development/web_driver/geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();

		test.log(LogStatus.INFO, "Browser started");

		driver.get("http://thedemosite.co.uk");
		Thread.sleep(2000); // Let the user actually see something!
		String title = driver.getTitle();

		WebElement addAUser = driver.findElement(By.cssSelector(
				"body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)"));
		addAUser.click();

		WebElement testUsernameField = driver.findElement(By.cssSelector(
				"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
		testUsernameField.sendKeys(user);
		Thread.sleep(1000);

		WebElement testPasswordField = driver.findElement(By.cssSelector(
				"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
		testPasswordField.sendKeys(pass);
		Thread.sleep(1000);

		WebElement testButton = driver.findElement(By.cssSelector(
				"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
		testButton.click();
		Thread.sleep(1000);

		WebElement login = driver.findElement(By.cssSelector(
				"body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)"));
		login.click();

		WebElement loginUsernameField = driver.findElement(By.cssSelector(
				"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
		loginUsernameField.sendKeys(user);
		Thread.sleep(1000);
		WebElement loginPasswordField = driver.findElement(By.cssSelector(
				"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
		loginPasswordField.sendKeys(pass);
		Thread.sleep(1000);
		WebElement loginButton = driver.findElement(By.cssSelector(
				"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
		loginButton.click();
		Thread.sleep(1000);

		WebElement loginMessage = driver.findElement(By.cssSelector(
				"body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b"));
		assertEquals(loginMessage.getText(), "**Successful Login**");

		report.endTest(test);
		report.flush();

		driver.quit();

	}

	@Before

	public void setUp() {

		FileInputStream file = null;
		try {
			file = new FileInputStream("C:/Users/admin/workspace/login.xls");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Get the workbook instance for XLS file
		HSSFWorkbook workbook = null;
		try {
			workbook = new HSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Get first sheet from the workbook
		HSSFSheet sheet = workbook.getSheetAt(0);

		// Iterate through each rows from first sheet
		rowIterator = sheet.iterator();

		// For each row, iterate through each columns

	}

	@Test

	public void multiBrowserTest() throws InterruptedException {

		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\Firstautomationreport.html", true);
		test = report.startTest("Multi Browser Test");

		HelperMethods.rowHelper(rowIterator, test);

		report.endTest(test);
		report.flush();

	}

}
