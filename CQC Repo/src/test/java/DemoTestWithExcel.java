import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DemoTestWithExcel {
	
	 WebDriver driver = null;

	    ExtentReports report;
	    ExtentTest test;
	    File currentDir = new File("");

	@Test
	public void DemoTestWithExcel() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",currentDir.getAbsolutePath() + "\\web_driver/chromedriver.exe");
        driver = new ChromeDriver();
        
        report = new ExtentReports(currentDir.getAbsolutePath() + "\\demo_test_with_excel.html", true);
        
        test = report.startTest("Demo Test With Excel");
        
        // this test will not work without a pre constructed .xls spreadsheet, simply create one with a 4 character word in
        // the upper leftmost column
        // once you have created the spreadsheet you need to specify its location in the FileInputStream below
        // i.e replace "C:/Users/admin/workspace/login.xls" with your filepath

        String user = null;

        String pass = null;

        FileInputStream file = null;
        try {
            file = new FileInputStream(currentDir.getAbsolutePath() + "\\login.xls");
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

        Cell cell = sheet.getRow(0).getCell(0);

        user = cell.getStringCellValue();

        pass = cell.getStringCellValue();

        driver.manage().window().maximize();

        driver.get("http://thedemosite.co.uk");
        Thread.sleep(2000); // Let the user actually see something!
        String title = driver.getTitle();

        WebElement addAUser = driver.findElement(By.cssSelector(
                "body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)"));
        addAUser.click();


        WebElement testUsernameField = driver.findElement(By.xpath("//*[@name='username'][@tabindex=1][@maxlength=16]"));
        testUsernameField.sendKeys(user);
        Thread.sleep(1000);

        WebElement testPasswordField = driver.findElement(By.cssSelector(
                "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
        testPasswordField.sendKeys(pass);
        Thread.sleep(1000);

        WebElement testButton = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));

        testButton.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        
        test.log(LogStatus.INFO, "Set up user");

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
        
        test.log(LogStatus.INFO, "Attempted to login");

        WebElement loginMessage = driver.findElement(By.cssSelector(
                "body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b"));

        assertEquals(loginMessage.getText(), "**Successful Login**");

        if (loginMessage.getText().equals("**Successful Login**")) {
            test.log(LogStatus.PASS, "Login valid");
        } else {
            test.log(LogStatus.FAIL, "Login failed");
        }

        driver.quit();
        report.endTest(test);
        report.flush();
	}

}
