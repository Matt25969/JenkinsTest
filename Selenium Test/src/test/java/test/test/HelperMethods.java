package test.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HelperMethods {

	ExtentReports report;

	static WebDriver driver;

	static String user = null;

	static String pass = null;

	static String browser = null;

	public static void sleepHelper() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void rowHelper(Iterator<Row> rowIterator, ExtentTest test) {

		while (rowIterator.hasNext()) {

			Row row = rowIterator.next();

			Iterator<Cell> cellIterator = row.cellIterator();

			for (int j = 0; j < 3; j++) {

				Cell cell = cellIterator.next();

				if (cell.getColumnIndex() == 0) {

					browser = cell.getStringCellValue();

				}
				if (cell.getColumnIndex() == 1) {

					user = cell.getStringCellValue();

				}
				if (cell.getColumnIndex() == 2) {

					pass = cell.getStringCellValue();

				}

			}

			browserHelper(test);

		}

	}

	public static void browserHelper(ExtentTest test) {

		if (browser.equalsIgnoreCase(TestEnum.CHROME.type)) {

			System.setProperty(TestEnum.CHROME.webDriverName, TestEnum.CHROME.webDriverLocation);

			driver = new ChromeDriver();

		}
		if (browser.equalsIgnoreCase(TestEnum.FIREFOX.type)) {

			System.setProperty(TestEnum.FIREFOX.webDriverName, TestEnum.FIREFOX.webDriverLocation);

			driver = new FirefoxDriver();

		}

		try {
			runHelper(test);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void runHelper(ExtentTest test) throws InterruptedException {

		driver.manage().window().maximize();

		sleepHelper(); // Let the user actually see something!

		test.log(LogStatus.INFO, "Browser started");

		System.out.println(driver);

		driver.get("http://thedemosite.co.uk");
		sleepHelper(); // Let the user actually see something!
		String title = driver.getTitle();

		userCreateHelper();

		loginHelper();

	}

	public static void userCreateHelper() throws InterruptedException {

		WebElement addAUser = driver.findElement(By.cssSelector(WebElements.ADDAUSER.value));
		addAUser.click();

		WebElement testUsernameField = driver.findElement(By.cssSelector(WebElements.testUsernameField.value));
		testUsernameField.sendKeys(user);
		sleepHelper();

		WebElement testPasswordField = driver.findElement(By.cssSelector(WebElements.testPasswordField.value));
		testPasswordField.sendKeys(pass);
		sleepHelper();

		WebElement testButton = driver.findElement(By.cssSelector(WebElements.testButton.value));
		testButton.click();
		sleepHelper();

		screenshot();

	}

	public static void loginHelper() throws InterruptedException {

		WebElement login = driver.findElement(By.cssSelector(WebElements.login.value));
		login.click();

		WebElement loginUsernameField = driver.findElement(By.cssSelector(WebElements.loginUsernameField.value));
		loginUsernameField.sendKeys(user);
		sleepHelper();
		WebElement loginPasswordField = driver.findElement(By.cssSelector(WebElements.loginPasswordField.value));
		loginPasswordField.sendKeys(pass);
		sleepHelper();
		WebElement loginButton = driver.findElement(By.cssSelector(WebElements.loginButton.value));
		loginButton.click();
		sleepHelper();

		WebElement loginMessage = driver.findElement(By.cssSelector(WebElements.loginMessage.value));
		assertEquals(loginMessage.getText(), "**Successful Login**");

		screenshot();

		driver.quit();

	}

	public static void screenshot() {

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

	public static void selectTab(String tabCSS) {

		WebElement tab = driver.findElement(By.cssSelector(tabCSS));
		tab.click();

	}

}
