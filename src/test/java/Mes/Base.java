package Mes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
static WebDriver driver;
	public static void main(String[] args) throws IOException {
		//Mes
		Properties pro=new Properties();
		File file=new File(".\\src\\test\\java\\Mes\\config.properties");
		FileInputStream fis=new FileInputStream(file);
		pro.load(fis);
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("http://localhost:8888/ords/r/htss_ws1/mes107796149250/login");
		driver.findElement(By.id("P9999_USERNAME")).sendKeys(pro.getProperty("username"));
		driver.findElement(By.id("P9999_PASSWORD")).sendKeys(pro.getProperty("password"));
		driver.findElement(By.xpath("//*[text()='Sign In']")).click();
		
		driver.findElement(By.cssSelector("[class=t-Header-controls]")).click();
		driver.findElement(By.xpath("//*[text()='Structure']/parent::div/preceding::span[1]")).click();
		
		//driver.findElement(By.xpath("//*[text()='Parties']/parent::div/preceding::span[1]")).click();
		driver.findElement(By.xpath("//*[text()='Organization Structure']")).click();
		
		driver.findElement(By.xpath("//*[text()='Jayakumar']")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btn_add']")));
		element.click();
		

	}

}
