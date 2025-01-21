package dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ForLoopConcept {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://letcode.in/dropdowns");
		
		WebElement ele = driver.findElement(By.id("lang"));
		
		Select sel=new Select(ele);
		List<WebElement> options = sel.getOptions();
		
		for(WebElement opt:options) {
			
			String text = opt.getText();
			
			if(text.equals("Python")) {
				
				opt.click();
				break;
			}
		}
		
	}

}
