package Mes;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.Assert;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFile {
	
	public static void main(String []args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();
		HashMap<String,Object>map=new  HashMap<String, Object>();
		String path="D:\\log";
		map.put("download.default_directory", path);
		opt.setExperimentalOption("prefs", map);
		WebDriver driver=new ChromeDriver(opt);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("http://omayo.blogspot.com/p/page7.html");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("ZIP file")).click();
		
         

	}

}
