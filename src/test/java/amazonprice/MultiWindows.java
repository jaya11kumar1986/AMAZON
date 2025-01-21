package amazonprice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiWindows {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://letcode.in/windows");
		driver.findElement(By.id("multi")).click();
		
		Set<String> set = driver.getWindowHandles();
		
		ArrayList<String> arr=new ArrayList<String>(set);
		
		for(String test:arr) {
			
			String currentUrl = driver.switchTo().window(test).getCurrentUrl();
			
			if(currentUrl.equals("https://letcode.in/alert")) {
				
				driver.switchTo().window(test);
				break;
			}
		}

	}

}
