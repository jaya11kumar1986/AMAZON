package alert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PromptAlert {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://letcode.in/alert");
		
        driver.findElement(By.xpath("//*[text()='Prompt Alert']")).click();
        
        driver.switchTo().alert().sendKeys("Test");
		
		Thread.sleep(3000);
		
		driver.switchTo().alert().accept();

	}

}
