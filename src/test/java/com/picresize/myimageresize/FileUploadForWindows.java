package com.picresize.myimageresize;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUploadForWindows {
	public WebDriver driver;

	public JavascriptExecutor js;
	String MyFileLocation;
	StringSelection ss;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {

		System.setProperty("webdriver.chrome.driver",
				"F:\\Zoom\\Personal Document\\2. Automation Test\\browserdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		// js.executeScript("window.location = 'https://picresize.com/'"); // this also
		// can be use instead driver.get methods
		driver.get("https://picresize.com/");
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void fileUpload() throws AWTException, InterruptedException {

		js.executeScript("window.scrollBy(0, 60);");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// Wait for element to be click able as this element takes few times to load.
		// We will Explicitly wait
		// Wait will time out after 30 Secs
		WebElement browserBtn = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='picresize-upload']//a[@href='#']")));
		browserBtn.click();
		Thread.sleep(3000);

		MyFileLocation = "F:\\Zoom\\Personal Document\\2. Automation Test\\TigerMY.png";
		fileBrows(MyFileLocation);
		System.out.println(MyFileLocation);

		// Wait for element to be click able as this element takes few times to load.
		// We will Explicitly wait
		js.executeScript("window.scrollBy(0, 100);");// Scroll down a bit
		WebElement rotateBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='im_rotate_ccw']"))); // Wait
																													// until
		// out
		rotateBtn.click();
		Thread.sleep(3000); // Waiting to see the rotate btn

		js.executeScript("window.scrollBy(0, 800);");// Scroll down to imDome element
		WebElement imDoneBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//form[@id='resize_form']/fieldset[@class='step-4']/div[2]/button")));
		imDoneBtn.click();

		// Browser will navigate to "Result page" and the scroller will be initialized
		// to
		// top.
		Thread.sleep(3000); // give browser some time to load the Result page
		js.executeScript("window.scrollBy(0, 80);");// Scroll a bit to new Result page
		WebElement saveBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Save to Disk')]")));
		saveBtn.click();
		Thread.sleep(6000); // give some time to save the file before browser quite
	}

	public void fileBrows(String fileLocation) throws AWTException, InterruptedException {
		// defining file location
		String location = fileLocation;
		ss = new StringSelection(location);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// file location Ctrl + v
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		// Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

}
//Close file explorer is closed. clear tree. Also make sure all browser are closed. Then run the test