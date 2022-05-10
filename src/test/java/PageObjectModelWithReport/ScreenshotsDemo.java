package PageObjectModelWithReport;

import java.io.File;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class ScreenshotsDemo {
	private WebDriver driver;
	private String baseUrl;

	@BeforeClass
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"F:\\Zoom\\Personal Document\\2. Automation Test\\browserdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://www.expedia.com/";
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testScreenshots() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//div[@id='wizardMainRegionV2']//ul[@role='tablist']/li[2]/a[@role='tab']/span[@class='uitk-tab-text']")).click();
		
		// Find Elements


		WebElement search = driver.findElement(By.xpath("/html//form[@id='wizard-flight-pwa-1']//button[@type='submit']"));
		
		// Send data to elements

		search.click();
	}
	
	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for (int i = 0; i < length; i++) {
			int index = (int) (Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		String fileName = getRandomString(10) + ".png";
		String directory = "F:\\Zoom\\Personal Document\\2. Automation Test\\";
		
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(sourceFile, new File(directory + fileName));
		driver.quit();
	}
}
