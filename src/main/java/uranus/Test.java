package uranus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeOptions ch= new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.get("https://www.zigwheels.com/");
		
//		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); WebElement
//		 new_bikes=driver.findElement(By.linkText("New Bikes")); 
//		 Actions action1 = new Actions(driver); action1.moveToElement(new_bikes).build().perform();
//		 driver.findElement(By.xpath("//a[text()='Upcoming Bikes']")).click();
//		 Thread.sleep(2000); //Apply filter manufacture as "Honda" and price 1lac
//		 driver.findElement(By.xpath("//ul[@class='mk-filter']/li[3]/span")).click();
		 
		
		// code for chennai 
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); 
		WebElement usedcars=driver.findElement(By.xpath("//a[@data-track-label='used-cars']"));
		Actions action2 = new Actions(driver);
		action2.moveToElement(usedcars).build().perform();
		driver.findElement(By.xpath("//a[@city='Chennai']")).click();
	}

}
