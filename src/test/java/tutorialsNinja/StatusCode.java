package tutorialsNinja;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatusCode {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.google.com/");
		String url="https://www.google.com/";
		//URL url1 = new URL(url);
		HttpURLConnection http=(HttpURLConnection) new URL(url).openConnection();
		
		int responseCode = http.getResponseCode();
		String responseMessage = http.getResponseMessage();
		
		System.out.println(responseCode);
		System.out.println(responseMessage);
				
	}

}
