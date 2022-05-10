package PageObjectModelWithReport;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPageFactory {
	
	ExtentTest test;
	WebDriver driver = null;

	public LoginPageFactory(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	

	
	public void clickLoginLink() {
		WebElement loginLink = driver.findElement(By.linkText("SIGN IN"));
		loginLink.click();
		test.log(LogStatus.INFO, "Clicked on login link");
	}
	
	public void enterEmail(String email) {
		WebElement emailField = driver.findElement(By.xpath("//div[@class='form-group']/input[@id='email']"));
		emailField.sendKeys(email);
		test.log(LogStatus.INFO, "Enter email");
	}
	
	public void enterPassword(String password) {
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys(password);
		test.log(LogStatus.INFO, "Enter password");
	}
	
	public void clickGoLink() {
		WebElement goButton = driver.findElement(By.xpath("//input[@value='Login']"));
		goButton.click();
		test.log(LogStatus.INFO, "Clicked Go button");
	}
	
	public boolean isWelcomeTextPresent() {
		WebElement welcomeText = null;
		try {
			welcomeText = driver.findElement(By.xpath("//button[@id='dropdownMenu1']/img"));
			if (welcomeText != null) {
				return true;
			}
		}
		catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}
	
	public void login(String email, String password) {
		clickLoginLink();
		enterEmail(email);
		enterPassword(password);
		clickGoLink();
	}
}