package tutorialsNinja;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--Headless");
		driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.navigate().to("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("tamil");
		
		System.out.println(driver.getTitle());
		
		//driver.navigate().refresh();
		
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("location.reload()");
		
		//driver.get(driver.getCurrentUrl());
		
		
		
		

	}

}
