package uranus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S08_34_CreateLegalEntity {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

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
//			2. Click on the toggle menu button from the left corner
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
//			3. Click View All and click Legal Entities from App Launcher
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		Thread.sleep(10000);
		WebElement legal= driver.findElement(By.xpath("//p[text()='Legal Entities']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",legal );
		
		legal.click();
//			4. Click on the Dropdown icon in the legal Entities tab
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("(//a[@class='slds-button slds-button_reset'])[15]")).click();
		
//			5. Click on New Legal Entity
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement Newlegal= driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		js.executeScript("arguments[0].click();", Newlegal);
//			6. Enter Name as 'Salesforce Automation by Your Name'
		String name="Salesforce Automation by Kavin";
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("((//span[text()='Name'])[2]/following::input)[1]")).sendKeys(name);
//			7.Click save and verify Legal Entity Name
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String verifyMessage= driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		
		System.out.println(verifyMessage);
		if(verifyMessage.equals("Legal Entity "+'"'+name+'"'+" was created.")) {
			System.out.println("Legal Entity created successfully");
		}
		else {
			System.out.println("Legal Entity not created");
		}
	}

}
