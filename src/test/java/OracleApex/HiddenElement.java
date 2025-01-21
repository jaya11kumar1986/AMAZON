package OracleApex;

import java.awt.Desktop;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HiddenElement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.letskodeit.com/practice");
		
		driver.findElement(By.id("hide-textbox")).click();
		//driver.findElement(By.id("displayed-text")).sendKeys("Test");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementById('displayed-text').value='Test';");
		
		driver.findElement(By.id("show-textbox")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		

	}

}
