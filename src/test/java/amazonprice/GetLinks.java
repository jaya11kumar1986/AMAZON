package amazonprice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.google.com/");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("link size:"+links.size());
		for(int i=0;i<links.size();i++) {
			
			String text = links.get(i).getAttribute("href");
			
			if(text == null || text.isEmpty() ) {
				
				System.out.println("Url is empty");
				
				}
			else {
				HttpURLConnection http=(HttpURLConnection)new URL(text).openConnection();
				int responseCode = http.getResponseCode();
				
				if(responseCode>400) {
					System.err.println("Url is broken :"+text);
				}
				else
				{
					System.out.println("Url :"+text);
				}
			}
		}

	}

}
