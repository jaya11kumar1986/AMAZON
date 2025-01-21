package OracleApex;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("http://192.168.1.123:8888/ords/r/htss_ws1/hr/login?session=79773174603");
		driver.findElement(By.id("P9999_USERNAME")).sendKeys("Admin");
		driver.findElement(By.id("P9999_PASSWORD")).sendKeys("Htss123");
		driver.findElement(By.xpath("//*[text()='Sign In']")).click();
		
		driver.findElement(By.cssSelector("[class='t-Header-controls']")).click();
		driver.findElement(By.xpath("//*[text()='EMPLOYEE']")).click();
		driver.findElement(By.xpath("//*[text()='Create']")).click();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		driver.findElement(By.id("P3_NAME")).click();
		driver.findElement(By.id("P3_NAME")).sendKeys("Jayakumar");
	    driver.findElement(By.xpath("//*[text()='Create']")).click();
	    driver.switchTo().defaultContent();
	    driver.findElement(By.xpath("//*[text()='Create']")).click();
		
		
		
		//driver.findElement(By.xpath("//div[@class='t-Header-controls']")).click();

	}

}
