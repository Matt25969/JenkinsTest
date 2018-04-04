package Test;
import java.io.*;
import java.util.Iterator;

import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING;
import static org.junit.Assert.*;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.*;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.util.Iterator;
import java.util.Scanner;


public class ContactsTest {
	
	 WebDriver driver = null;

	 ExtentReports report;
	 ExtentTest test;
	 File currentDir = new File("");


    @Before

    public void setup() {
    	
    	System.out.println(System.getProperty("os.name"));

        System.out.println(currentDir.getAbsolutePath());

        //change this variable (0,1,2) to use different browsers
        int choice = 1;

        switch (choice) {
            case 0:
                System.setProperty("webdriver.gecko.driver", currentDir.getAbsolutePath() + "\\web_driver/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            // run and comeplete
            case 1:
                System.setProperty("webdriver.chrome.driver",currentDir.getAbsolutePath() + "\\web_driver/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            //run and complete
            case 2:
                System.setProperty("webdriver.ie.driver", currentDir.getAbsolutePath() + "\\web_driver/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                //run and comeplete
                break;
            case 3:
                System.setProperty("webdriver.edge.driver", currentDir.getAbsolutePath() + "\\web_driver/MicrosoftWebDriver.exe");
                driver = new EdgeDriver();
                break;
            //failed

        }
        
        driver.manage().window().maximize();
        
        //I have omitted the 3 fields below due to the insecure nature of GitHub

//      url of CRMTest
      // could use the UAT one here whatever you want
        
      driver.get("");

      //Here you will need to add your username
      driver.findElement(By.xpath("//*[@id='s_swepi_1']")).sendKeys("");

      //Here you will need to add your password
      driver.findElement(By.xpath("//*[@id='s_swepi_2'")).sendKeys("");

      driver.findElement(By.xpath("//*[@id='s_swepi_22']")).click();
        

    }

    @Test

    public void ContactsTest() throws InterruptedException {       

//        driver.findElement(By.xpath("//*[@id=\"ui-id-136\"]/span\"]")).click();
//        This line is incorrect, it was accessing the wrong element - next steps will be
//        - using Chrome, find the auto generated XPath of the correct element
//        - plug this into the test
//        - if the auto generated XPath utilises the ui-id-*** style it will not work
//        - this is a simple thing that we overlooked on Wednesday

        driver.findElement(By.xpath("//*[@id='s_4_2_19_0_mb']")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[3]/td[3]/div/input")).sendKeys("Smith");

        driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[4]/td[3]/div/input")).sendKeys("Jane");

        driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[5]/td[3]/div/input")).sendKeys("Joseph");

        driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[6]/td[3]/div/input")).sendKeys("Jones");

        driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[8]/td[3]/div/input")).sendKeys("Miss");

        driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[11]/td[3]/div/input")).sendKeys("01789452244");

        driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[12]/td[3]/div/input")).sendKeys("01245855696");

        driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[13]/td[3]/div/input")).sendKeys("01245654855");

        driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[14]/td[3]/div/input")).sendKeys("jane.smith@gmail.com");

        driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[16]/td[3]/div/input")).sendKeys("smith.jane@gmail.com");

        // second column
        // first element 'title' will need to look into this further
        // when I have the UAT open in front of me

        driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[4]/td[5]/div/input")).sendKeys("Son");

        // same with DOB and use of dropdown etc

        driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[4]/td[5]/div/input")).sendKeys("JS");

        driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[11]/td[5]/div/input")).sendKeys("+01546");

        driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[12]/td[5]/div/input")).sendKeys("01545458444");

        driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[13]/td[6]/div/input")).sendKeys("01256458986");

        // Department - the one in the exampels POC notes
        // not sure if this would work exactly as i intend it too
        // due to previous issues and zero testing

        driver.findElement(By.xpath("//*[@id='s_2_1_32_0_icon']")).click();

        driver.findElement(By.xpath("//*[@id='a_2]/div/table/tbody/tr[21]/td[3]/div/textarea")).sendKeys("Created with Automated Software for Testing Purposes");

        // after all the fields have you been filled in that you want
        // the line of code below should click the '+' button to create a new record.

        driver.findElement(By.xpath("//*[@id='s_2_1_229_0_Ctrl']")).click();

    }

    @Test

    public void ContactsWithExcelTest() throws InterruptedException {


//          I have made the spreadsheet available on the Drive
        //  replace "C:/Users/admin/workspace/CQCContactCreation.xls" with your filepath
        // once you have downloaded it

        FileInputStream file = null;
        try {
            file = new FileInputStream(currentDir.getAbsolutePath() + "\\CQCContactCreation.xls");
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

        HSSFSheet sheet = workbook.getSheetAt(0);

//        driver.findElement(By.xpath("//*[@id=\"ui-id-136\"]/span\"]")).click();
//        This line is incorrect, it was accessing the wrong element - next steps will be
//        - using Chrome, find the auto generated XPath of the correct element
//        - plug this into the test
//        - if the auto generated XPath utilises the ui-id-*** style it will not work
//        - this is a simple thing that we overlooked on Wednesday

        driver.findElement(By.xpath("//*[@id='s_4_2_19_0_mb']")).click();

        Thread.sleep(5000);

        //start the loop that iterates through the rows of the excel sheet

        for (int i = 1; i < 10; i++) {

            Cell surnameCell = sheet.getRow(i).getCell(0);

            String surname = surnameCell.getStringCellValue();

            driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[3]/td[3]/div/input")).sendKeys(surname);

            Cell firstNameCell = sheet.getRow(i).getCell(1);
            String firstName = firstNameCell.getStringCellValue();

            driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[4]/td[3]/div/input")).sendKeys(firstName);

            Cell middleNameCell = sheet.getRow(i).getCell(2);
            String middleName = middleNameCell.getStringCellValue();

            driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[5]/td[3]/div/input")).sendKeys(middleName);

            Cell previousNameCell = sheet.getRow(i).getCell(3);
            String previousName = previousNameCell.getStringCellValue();

            driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[6]/td[3]/div/input")).sendKeys(previousName);

            Cell titleCell = sheet.getRow(i).getCell(4);
            String title = titleCell.getStringCellValue();
            driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[8]/td[3]/div/input")).sendKeys(title);

            Cell firstPhoneCell = sheet.getRow(i).getCell(5);
            String firstPhone = firstPhoneCell.getStringCellValue();

            driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[11]/td[3]/div/input")).sendKeys(firstPhone);


            Cell secondPhoneCell = sheet.getRow(i).getCell(6);
            String secondPhone = secondPhoneCell.getStringCellValue();
            driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[12]/td[3]/div/input")).sendKeys(secondPhone);

            Cell thirdPhoneCell = sheet.getRow(i).getCell(7);
            String thirdPhone = thirdPhoneCell.getStringCellValue();

            driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[13]/td[3]/div/input")).sendKeys(thirdPhone);

            Cell emailCell = sheet.getRow(i).getCell(8);
            String email = emailCell.getStringCellValue();

            driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[14]/td[3]/div/input")).sendKeys(email);

            Cell secondEmailCell = sheet.getRow(i).getCell(9);
            String secondEmail = secondEmailCell.getStringCellValue();

            driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[16]/td[3]/div/input")).sendKeys(secondEmail);

            // second column
            // first element 'title' will need to look into this further
            // when I have the UAT open in front of me

            Cell suffixCell = sheet.getRow(i).getCell(10);
            String suffix = suffixCell.getStringCellValue();

            driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[4]/td[5]/div/input")).sendKeys(suffix);

            // same with DOB and use of dropdown etc


            Cell aliasCell = sheet.getRow(i).getCell(12);
            String alias = aliasCell.getStringCellValue();
            driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[4]/td[5]/div/input")).sendKeys(alias);


            Cell contact1Cell = sheet.getRow(i).getCell(13);
            String contact1 = contact1Cell.getStringCellValue();
            driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[11]/td[5]/div/input")).sendKeys(contact1);
            Cell contact2Cell = sheet.getRow(i).getCell(14);
            String contact2 = contact2Cell.getStringCellValue();
            driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[12]/td[5]/div/input")).sendKeys(contact2);
            Cell contact3Cell = sheet.getRow(i).getCell(15);
            String contact3 = contact3Cell.getStringCellValue();
            driver.findElement(By.xpath("//*[@id='a_2']/div/table/tbody/tr[13]/td[6]/div/input")).sendKeys(contact3);

            // Department - the one in the exampels POC notes
            // not sure if this would work exactly as i intend it too
            // due to previous issues and zero testing

//         From memory there are 3 potential values from the dropdown options for this field
//         I have left the default one enabled - the optional usgae alongside the spreadsheet will be similar to the commented out code below

            driver.findElement(By.xpath("//*[@id='s_2_1_32_0_icon']")).click();

            Cell contactChoiceCell = sheet.getRow(i).getCell(16);
            String contactChoice = contactChoiceCell.getStringCellValue();

//            switch (contactChoice){
//                case "Do not contact":
//                    driver.findElement(By.xpath("//*[@id='s_2_1_32_0_icon']")).click();
//                    break;
//                case "Contact By Phone":
//                    driver.findElement(By.xpath("//*[@id='s_2_1_32_0_icon']")).click();
//                    break;
//                case "Contact by email":
//                    driver.findElement(By.xpath("//*[@id='s_2_1_32_0_icon']")).click();
//                    break;
//            }

            driver.findElement(By.xpath("//*[@id='a_2]/div/table/tbody/tr[21]/td[3]/div/textarea")).sendKeys("Created with Automated Software for Testing Purposes");

            // after all the fields have you been filled in that you want
            // the line of code below should click the '+' button to create a new record.
            Thread.sleep(2000);

            driver.findElement(By.xpath("//*[@id='s_2_1_229_0_Ctrl']")).click();

            Thread.sleep(2000);
        }
    }

}

