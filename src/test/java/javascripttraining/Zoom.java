package javascripttraining;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Zoom {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://en.wikipedia.org/wiki/List_of_international_cricket_centuries_by_Sachin_Tendulkar");
		
		JavascriptExecutor jt=(JavascriptExecutor)driver;
		jt.executeScript("document.body.style.zoom='150%'");

	}

}
