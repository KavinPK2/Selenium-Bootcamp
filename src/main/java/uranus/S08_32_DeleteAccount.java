package uranus;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S08_32_DeleteAccount {

	public static void main(String[] args) throws InterruptedException {
		// Browser Launch
				WebDriverManager.chromedriver().setup();
				
				ChromeOptions option=new ChromeOptions();
				option.addArguments("--disable-notifications");
				
				ChromeDriver driver=new ChromeDriver(option);
				driver.manage().window().maximize();
//		    1. Login to https://login.salesforce.com
				driver.get("https://login.salesforce.com/");
				driver.findElement(By.xpath("//input[@name='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys("India$321");
				driver.findElement(By.xpath("//input[@id='Login']")).click();
//				2. Click on toggle menu button from the left corner
				Thread.sleep(10000);
				driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
//					3. Click view All and click Sales from App Launcher
			
				Thread.sleep(10000);
				driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
				Thread.sleep(10000);
				WebElement sales= driver.findElement(By.xpath("//p[text()='Sales']"));

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();",sales );
				
				sales.click();
//					4. Click on Accounts tab 
				Thread.sleep(10000);
				WebElement accounts=driver.findElement(By.xpath("(//span[contains(text(),'Accounts')])[1]"));
				js.executeScript("arguments[0].click();",accounts);
//			5. Search the account 'Your Name'
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				WebElement Search=driver.findElement(By.xpath("//input[@name='Account-search-input']"));
				Search.sendKeys("Kavin");
				Search.sendKeys(Keys.ENTER);
				
//			6. Click on  the Dropdown icon and Select Delete
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				WebElement dropdown=driver.findElement(By.xpath("//td[@role='gridcell']//a[@role='button']"));
				js.executeScript("arguments[0].click();",dropdown);
				driver.findElement(By.xpath("//a[@title='Delete']")).click();
				driver.findElement(By.xpath("//span[text()='Delete']")).click();
//			7. Verify Whether account is Deleted using account Name
				String verifyMessage= driver.findElement(By.xpath("//span[text()='No items to display.']")).getText();
				if(verifyMessage.equals("No items to display.")) {
					System.out.println("Account Deleted successfully");
				}
				else {
					System.out.println("Account not Deleted");
				}
				driver.close();
	}

}
