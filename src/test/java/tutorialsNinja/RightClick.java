package tutorialsNinja;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClick {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.google.com/");
		
		WebElement element = driver.findElement(By.linkText("Gmail"));
		
		Actions act=new Actions(driver);
		act.contextClick(element)
		.sendKeys(Keys.ARROW_DOWN)
		.sendKeys(Keys.RETURN)
		.build().perform();
		
	
		
		

	}

}
