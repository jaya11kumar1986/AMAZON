package alert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SweetAlert {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://letcode.in/alert");
		
        driver.findElement(By.xpath("//*[text()='Modern Alert']")).click();
        
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='modal-close is-large']")));
        String text = driver.findElement(By.cssSelector("[class='title']")).getText();
        System.out.println(text);
        element.click();

	}

}
