package OracleApex;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report extends Base {
	static ExtentSparkReporter reporter;
	static ExtentReports extent;
	static ExtentTest test;
	static File file;

	public static String htmlReportPath="./reports/result"+new SimpleDateFormat("dd-MMM-yy - HH.mm.ss ").format(new Date())+".html";
	public static String screenShotFolder="./reports/ScreenShot"+new SimpleDateFormat("dd-MMM-yy - HH.mm.ss").format(new Date())+"/";

	public static void startReport( ){

		//String htmlReportPath="./reports/result"+new SimpleDateFormat("dd-MMM-yy - HH.mm.ss ")
		//.format(new Date())+".html";
		file=new File(System.getProperty("user.dir")+"./reports/result"+new SimpleDateFormat("dd-MMM-yy - HH.mm.ss ")
				.format(new Date())+".html");

		reporter=new ExtentSparkReporter(file);
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("Employee Details");

		extent=new ExtentReports();

		extent.attachReporter(reporter);
		extent.setSystemInfo("Java version",System.getProperty("java.version"));
		extent.setSystemInfo("Java version",System.getProperty("user.name"));
	}

	public static void reportStep(String desc, String status) {

		String fileName = new SimpleDateFormat("dd-MMM-yy - HH-mm-ss").format(new Date());
		try {
			TakesScreenshot ts = (TakesScreenshot)driver; // Down casting
			File scrfile = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrfile , new File(screenShotFolder+"Sample"+"/"+fileName+".jpg"));
		} catch (WebDriverException | IOException e) {
			e.printStackTrace();
		}


		if(status.toUpperCase().equals("PASS")){
			//test.log(LogStatus.PASS, desc+test.addScreenCaptureFromPath("./."+screenShotFolder+testCaseName+"/"+fileName+".jpg"));
			test.log(Status.PASS, desc+test.addScreenCaptureFromPath("./."+screenShotFolder+"Sample"+"/"+fileName+".jpg"));
			//test.log(Status.PASS, desc+MediaEntityBuilder.createScreenCaptureFromPath("./."+screenShotFolder+"Sample"+"/"+fileName+".jpg").build());
		}else if(status.toUpperCase().equals("FAIL")){
			//test.log(LogStatus.FAIL, desc+test.addScreenCaptureFromPath("./."+screenShotFolder+testCaseName+"/"+fileName+".jpg"));
			test.log(Status.FAIL, desc+test.addScreenCaptureFromPath("./."+screenShotFolder+"Sample"+"/"+fileName+".jpg"));
		}else if(status.toUpperCase().equals("INFO")){
			//test.log(LogStatus.INFO, desc);
			test.log(Status.INFO, desc+test.addScreenCaptureFromPath("./."+screenShotFolder+"Sample"+"/"+fileName+".jpg"));
		}
	}

	public static void stopReport() throws IOException {

		extent.flush();
		Desktop.getDesktop().browse(file.toURI());
	}

	public static void startTest(String TestcaseName) {
		test=extent.createTest(TestcaseName);


	}

	public static void screenShot(String imageName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sc=ts.getScreenshotAs(OutputType.FILE);
		File dc=new File(imageName);
		try {
			FileUtils.copyFile(sc,dc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.fail("Failed");
		test.addScreenCaptureFromPath(imageName);
		extent.flush();

	}

}
