package PageObjectModelWithReport;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.Screenshots;
import Utilities.ExtentFactory;

public class Login {

	private WebDriver driver;
	private String baseUrl;
	ExtentReports report;
	ExtentTest test;
	LoginPageFactory hp;

	@BeforeClass
	public void beforeClass() {
		baseUrl = "https://courses.letskodeit.com/";
		report = ExtentFactory.getInstance();
		test = report.startTest("Verify Welcome Text");
		System.setProperty("webdriver.chrome.driver",
				"F:\\Zoom\\Personal Document\\2. Automation Test\\browserdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		hp = new LoginPageFactory(driver, test);
		test.log(LogStatus.INFO, "Browser Started...");

		// Maximize the browser's window
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser Maximized");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Web application opened");
	}

	@Test
	public void test1_validLoginTest() throws Exception {
		hp.login("test@email.com", "abcabc");

		Thread.sleep(3000);

		boolean result = hp.isWelcomeTextPresent();
		Assert.assertTrue(result);
		test.log(LogStatus.PASS, "Verified Welcome Text.....");
	}

	@AfterMethod
	// Take Screenshot & add to report for every @Test methods if success
	public void tearDown(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.SUCCESS) { // Make this "SUCCESS" or "FAILURE" depending when you want
																// to take screenshot
			// Create object of SimpleDateFormat class and decide the format
			String ImgFileName = testResult.getName();
			String path = Screenshots.takeScreenshot(driver, ImgFileName);
			// testResult.getName() = test1_validLoginTest, Multiple screenshot if taken
			// within same method or any methods have same name the image could replaced by
			// new one. Adaptive name generator is recommended
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.INFO, "Screenshot taken succesfully", imagePath);
			// End taking screenshot
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
		report.endTest(test);
		report.flush();
		
	}
}