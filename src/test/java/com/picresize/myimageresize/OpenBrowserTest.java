package com.picresize.myimageresize;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpenBrowserTest {

	String baseURL;
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.gecko.driver",
				"F:\\Zoom\\Personal Document\\2. Automation Test\\browserdrivers\\geckodriver.exe");
		baseURL = "https://courses.letskodeit.com/";

		// Profile configuration
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile fxProfile = profile.getProfile("MyWebAutomation");
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(fxProfile);
		driver = new FirefoxDriver(options);
	}

	@Test
	public void testmethods() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		System.out.println("Navigating to URL");
	}

	@AfterClass
	public void cleanup() {

		driver.quit();
		System.out.println("Browser Quited...");
	}

}
