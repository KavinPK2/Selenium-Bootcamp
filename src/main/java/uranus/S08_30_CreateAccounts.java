package uranus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S08_30_CreateAccounts {

	public static void main(String[] args) throws InterruptedException {
		// Browser Launch
				WebDriverManager.chromedriver().setup();
				
				ChromeOptions option=new ChromeOptions();
				option.addArguments("--disable-notifications");
				
				ChromeDriver driver=new ChromeDriver(option);
				driver.manage().window().maximize();
				//driver.manage().timeouts().implicitlyWait(15, null);
//				    1. Login to https://login.salesforce.com
				driver.get("https://login.salesforce.com/");
				driver.findElement(By.xpath("//input[@name='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys("India$321");
				driver.findElement(By.xpath("//input[@id='Login']")).click();
				
//					2. Click on toggle menu button from the left corner
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
//					5. Click on New button
				Thread.sleep(10000);
				driver.findElement(By.xpath("//div[@title='New']")).click();
				
			
//					6. Enter 'your name' as account name
				String name="Kavin";
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				WebElement Accname= driver.findElement(By.xpath("(//label[text()='Account Name']/following::div/input)[1]"));
				js.executeScript("arguments[0].ScrollDownIntoView;",Accname);
				Accname.sendKeys(name);
//					7. Select Ownership as Public           
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				WebElement ownership =driver.findElement(By.xpath("(//label[text()='Ownership']/following::button)[1]"));
				js.executeScript("arguments[0].ScrollDownIntoView;",ownership);
				js.executeScript("arguments[0].click();",ownership);
				driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Public']")).click();

//					8. Click save and verify Account name 
					

				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				String verifyMessage= driver.findElement(By.xpath("//span[text()='Account']")).getText();
				
				System.out.println(verifyMessage);
				if(verifyMessage.equals("Account "+'"'+name+'"'+" was created.")) {
					System.out.println("Account created successfully");
				}
				else {
					System.out.println("Account not created");
				}
				
				driver.close();
			}

		}
