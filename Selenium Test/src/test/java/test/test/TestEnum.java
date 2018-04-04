package test.test;

public enum TestEnum {

	CHROME("Chrome", "webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe"), FIREFOX("Firefox",
			"webdriver.gecko.driver", "C:/Development/web_driver/geckodriver.exe");

	final String type;
	final String webDriverName;
	final String webDriverLocation;

	TestEnum(String type, String webDriverName, String webDriverLocation) {

		this.type = type;
		this.webDriverName = webDriverName;
		this.webDriverLocation = webDriverLocation;
	}

}
