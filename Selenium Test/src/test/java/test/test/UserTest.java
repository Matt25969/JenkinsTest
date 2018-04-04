package test.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Admin\\eclipse-workspace\\Portfolio Workspace\\Java-Portfolio\\Selenium Test\\user.feature",

		glue = "C:\\Users\\Admin\\eclipse-workspace\\Portfolio Workspace\\Java-Portfolio\\Selenium Test\\src\\test\\java\\test\\test"

)

public class UserTest {
}
