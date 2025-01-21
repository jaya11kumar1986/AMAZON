package dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClassMethod {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

		driver.get("https://letcode.in/dropdowns");

		WebElement ele = driver.findElement(By.id("lang"));

		Select sel = new Select(ele);
		// sel.selectByIndex(2);
		// sel.selectByValue("py");
		sel.selectByVisibleText("Python");
		WebElement firstSelectedOption = sel.getFirstSelectedOption();

		String text = firstSelectedOption.getText();
		System.out.println(text);

		WebElement element = driver.findElement(By.id("superheros"));

		Select sel1 = new Select(element);

		boolean multiple = sel1.isMultiple();

		System.out.println(multiple);
		
		sel1.selectByIndex(1);
		sel1.selectByIndex(2);
		sel1.selectByIndex(3);
		sel1.selectByIndex(4);
		
		List<WebElement> allSelectedOptions = sel1.getAllSelectedOptions();
		
		for(WebElement all:allSelectedOptions) {
			
			System.out.println(all.getText());
		}
		
		sel1.deselectByIndex(1);
		Thread.sleep(3000);
		sel1.deselectAll();
		
		
		
		


	}

}
