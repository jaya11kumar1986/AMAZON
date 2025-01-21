package windows;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Multi {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/windows");
		
driver.findElement(By.id("multi")).click();
        
        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();
        
        // Convert Set to ArrayList for easier manipulation
        ArrayList<String> windowList = new ArrayList<>(windowHandles);
        
        // Iterate through the window handles and switch to the one with the specific URL
        for (String handle : windowList) {
            // Switch to the current window handle
            driver.switchTo().window(handle);
            
            // Check if the current URL matches the target URL
            if (driver.getCurrentUrl().equalsIgnoreCase("https://letcode.in/alert")) {
                // Once found, break out of the loop
                break;
            }
        }
        
        // Optionally, print the current URL after switching to the desired window
        System.out.println("Switched to the window with URL: " + driver.getCurrentUrl());
        
        // Perform further actions or close the driver
       // driver.quit();
		

	}

}
