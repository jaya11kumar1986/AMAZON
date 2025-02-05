package sdet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkOpenInNewTab {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.google.com/");
		
		String tab=Keys.chord(Keys.CONTROL,Keys.RETURN);
		String tab1=Keys.chord(Keys.CONTROL,Keys.TAB);
		
		driver.findElement(By.linkText("Gmail")).sendKeys(tab);
		

	}

}
