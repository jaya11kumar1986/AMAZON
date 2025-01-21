package OracleApex;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	static WebDriver driver;
	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("http://localhost:8888/ords/r/htss_ws1/employee/login?session=8185631771550");

	}

	public static void signOut() {

		driver.findElement(By.cssSelector("[class='a-Icon icon-down-arrow']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
	
	public static void screenShot(String fileName,int num) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des=new File("D:\\OracleScreenShot\\"+fileName+num+".jpg");
		FileUtils.copyFile(src, des);
	}

}
