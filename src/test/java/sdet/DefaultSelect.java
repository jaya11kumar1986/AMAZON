package sdet;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DefaultSelect {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("http://localhost:8888/ords/r/htss_ws1/employee/login");
		driver.switchTo().activeElement().sendKeys("admin"+Keys.TAB);
		driver.switchTo().activeElement().sendKeys("Htss123"+Keys.TAB);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.switchTo().activeElement().click();
		Thread.sleep(2000);
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("http://localhost:8888/ords/r/htss_ws1/employee/login");
		driver.switchTo().activeElement().sendKeys("admin"+Keys.TAB);
		driver.switchTo().activeElement().sendKeys("Htss12"+Keys.TAB);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.switchTo().activeElement().click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("t-Alert-header")));
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File des=new File(System.getProperty("user.dir")+"./reports/ScreenShot/Failed.png");
		FileUtils.copyFile(src, des);
		
		driver.quit();
		

	}

}
