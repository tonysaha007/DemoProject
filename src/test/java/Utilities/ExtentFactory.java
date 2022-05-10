package Utilities;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {

	public static ExtentReports getInstance() {
		ExtentReports extent;
		String Path = "F:\\Zoom\\Personal Document\\2. Automation Test\\ExtentReports\\report-demo.html";
		extent = new ExtentReports(Path, false);
		extent.addSystemInfo("Selenium Version", "4.1.2").addSystemInfo("Platform", "Windows");

		return extent;
	}

	
}
