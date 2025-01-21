package amazonprice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	
	@Test
	public void amazon() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobile"+Keys.ENTER);

		List<WebElement> elements = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		ArrayList<Integer>list=new ArrayList<Integer>();
		for(int i=0;i<elements.size();i++) {

			//System.out.println(elements.get(i).getText());

			String replace = elements.get(i).getText().replace(",","");
			list.add(Integer.parseInt(replace));
		}

		Collections.sort(list);

		for(int temp:list) {

			System.out.println(temp);
		}

		System.out.println("----------------------");
		Collections.sort(list,Collections.reverseOrder());
		for(int temp1:list) {

			System.out.println(temp1);
		}
	}


}
