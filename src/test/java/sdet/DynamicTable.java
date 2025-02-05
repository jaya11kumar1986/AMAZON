package sdet;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://practice.expandtesting.com/dynamic-table");
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
		
		System.out.println(rows.size());
		
		for(int i=1;i<=rows.size();i++) {
			
			
			WebElement name = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td[1]"));
			//System.out.println(name.getText());
			
			if(name.getText().equalsIgnoreCase("chrome")) {
				
				WebElement element = driver.findElement(By.xpath("//td[normalize-space()='Chrome']/following-sibling::*[contains(text(),'%')]"));
				String text = element.getText();
				
				System.out.println(text);
				break;
			}
				
			}
		}

	}


