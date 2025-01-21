package OracleApex;

import org.openqa.selenium.By;

public class Employee extends Base {

	public static void login(String userName,String passWord) {

		driver.findElement(By.id("P9999_USERNAME")).sendKeys(userName);
		driver.findElement(By.id("P9999_PASSWORD")).sendKeys(passWord);
		driver.findElement(By.xpath("//*[text()='Sign In']")).click();
	}

	public static void employeeNameEntry(String name) throws InterruptedException {
		Report.startTest("Smoke Testing");

		driver.findElement(By.cssSelector("[class='t-Header-controls']")).click();
		driver.findElement(By.xpath("//*[text()='Employee_Name']")).click();
		driver.findElement(By.xpath("//*[text()='Create']")).click();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		driver.findElement(By.id("P5_NAME")).click();
		driver.findElement(By.id("P5_NAME")).sendKeys(name);
		driver.findElement(By.xpath("//*[text()='Create']")).click();
		driver.switchTo().defaultContent();
		Report.reportStep("EmployeeName","Pass");
		
	}

}
