package uranus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S08_33_VerifySorting {

	public static void main(String[] args) throws InterruptedException {
//		    1. Login to https://login.salesforce.com
WebDriverManager.chromedriver().setup();
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("India$321");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
//			2. Click on toggle menu button from the left corner
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

//			3. Click view All and click Sales from App Launcher
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		Thread.sleep(10000);
		WebElement sales= driver.findElement(By.xpath("//p[text()='Sales']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",sales );
		
		sales.click();
//			4. Click on Accounts tab 
		Thread.sleep(10000);
		WebElement accounts=driver.findElement(By.xpath("(//span[contains(text(),'Accounts')])[1]"));
		js.executeScript("arguments[0].click();",accounts);
//			5. Click sort arrow in the Account Name to sort in ascending order
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement sort=driver.findElement(By.xpath("(//span[text()='Sort'])[1]"));
		js.executeScript("arguments[0].click();",sort);
		
		driver.close();

	}

}
