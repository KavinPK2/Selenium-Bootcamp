package uranus;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewOpportunity {

	public static void main(String[] args) {
	
		//Browser Launch
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//open url
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		//Login
		driver.findElement(By.id("username")).sendKeys("pkkavin007-h9bx@force.com");
		driver.findElement(By.id("password")).sendKeys("Kavin@123");
		driver.findElement(By.id("Login")).click();

		
	}

}
