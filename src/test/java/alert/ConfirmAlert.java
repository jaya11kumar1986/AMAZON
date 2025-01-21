package alert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConfirmAlert {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://letcode.in/alert");
		
        driver.findElement(By.xpath("//*[text()='Confirm Alert']")).click();
		
		Thread.sleep(3000);
		
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		
		//driver.switchTo().alert().accept();
		
		driver.switchTo().alert().dismiss();
		
		

	}

}
