package javascripttraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SendKeysInput {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("http://localhost:8888/ords/r/htss_ws1/mes107796149250/login");
		WebElement uname=driver.findElement(By.id("P9999_USERNAME"));
		
		JavascriptExecutor jt=(JavascriptExecutor)driver;
		jt.executeScript("arguments[0].value='admin'",uname);

	}

}
