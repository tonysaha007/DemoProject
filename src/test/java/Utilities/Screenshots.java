package Utilities;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Screenshots {
	
		public static String takeScreenshot(WebDriver driver, String fileName) throws IOException {
		fileName = fileName + ".png";
		String directory = "F:\\Zoom\\Personal Document\\2. Automation Test\\ExtentReports\\";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(sourceFile, new File(directory + fileName));
		String destination = directory + fileName;
		return destination;
		
		
	}
}