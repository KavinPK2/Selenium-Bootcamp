package uranus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S08_31_EditAccount {

	public static void main(String[] args) throws InterruptedException {
//	1) Launch the app
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
//	2) Click Login
//	3) Login with the credentials
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("India$321");
		driver.findElement(By.xpath("//input[@id='Login']")).click();

//	4) Click on the App Laucher Icon left to Setup
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
//	5) Click on Accounts
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		Thread.sleep(10000);
		WebElement sales= driver.findElement(By.xpath("//p[text()='Sales']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",sales );
		
		sales.click();
		Thread.sleep(10000);
		WebElement accounts=driver.findElement(By.xpath("(//span[contains(text(),'Accounts')])[1]"));
		js.executeScript("arguments[0].click();",accounts);
//	6) Search for the Account Using the unique account name created by you 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Search=driver.findElement(By.xpath("//input[@name='Account-search-input']"));
		Search.sendKeys("Kavin");
		Search.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
//	7) Click on the displayed Account Dropdown icon and select Edit
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement dropdown=driver.findElement(By.xpath("//td[@role='gridcell']//a[@role='button']"));
		js.executeScript("arguments[0].click();",dropdown);
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
//	8) Select Type as Technology Partner
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Type =driver.findElement(By.xpath("(//label[text()='Type']/following::button)[1]"));
		js.executeScript("arguments[0].ScrollDownIntoView;",Type);
		js.executeScript("arguments[0].click();",Type);
		driver.findElement(By.xpath("//span[text()='Technology Partner']")).click();
//	9) Select Industry as Healthcare 
		WebElement Industry =driver.findElement(By.xpath("(//label[text()='Industry']/following::button)[1]"));
		js.executeScript("arguments[0].ScrollDownIntoView;",Industry);
		js.executeScript("arguments[0].click();",Industry);
		WebElement Healthcare= driver.findElement(By.xpath("//span[text()='Healthcare']"));
		js.executeScript("arguments[0].ScrollDownIntoView;",Healthcare);
		js.executeScript("arguments[0].click();",Healthcare);
//	10)Enter Billing Address
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement BillingStreet= driver.findElement(By.xpath("(//label[text()='Billing Street']/following::div)[1]"));
		js.executeScript("arguments[0].ScrollDownIntoView;",BillingStreet);
		js.executeScript("arguments[0].click();",BillingStreet);

		BillingStreet.sendKeys("xyz");
		WebElement BillingCity= driver.findElement(By.xpath("(//label[text()='Billing City']/following::div/input)[1]"));
		js.executeScript("arguments[0].ScrollDownIntoView;",BillingCity);
		BillingCity.sendKeys("Chennai");
		WebElement BillingState= driver.findElement(By.xpath("(//label[text()='Billing State/Province']/following::div/input)[1]"));
		js.executeScript("arguments[0].ScrollDownIntoView;",BillingState);
		BillingState.sendKeys("Tamilnadu");
		WebElement BillingZip= driver.findElement(By.xpath("(//label[text()='Billing Zip/Postal Code']/following::div/input)[1]"));
		js.executeScript("arguments[0].ScrollDownIntoView;",BillingZip);
		BillingZip.sendKeys("600045");
		WebElement BillingCountry= driver.findElement(By.xpath("(//label[text()='Billing Country']/following::div/input)[1]"));
		js.executeScript("arguments[0].ScrollDownIntoView;",BillingCountry);
		BillingCountry.sendKeys("India");
		
//	11)Enter Shipping Address
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement ShippingStreet= driver.findElement(By.xpath("(//label[text()='Shipping Street']/following::div)[1]"));
		js.executeScript("arguments[0].ScrollDownIntoView;",ShippingStreet);
		js.executeScript("arguments[0].Click();",ShippingStreet);
		ShippingStreet.sendKeys("xyz");
		WebElement ShippingCity= driver.findElement(By.xpath("(//label[text()='Shipping City']/following::div/input)[1]"));
		js.executeScript("arguments[0].ScrollDownIntoView;",ShippingCity);
		ShippingCity.sendKeys("Chennai");
		WebElement ShippingState= driver.findElement(By.xpath("(//label[text()='Shipping State/Province']/following::div/input)[1]"));
		js.executeScript("arguments[0].ScrollDownIntoView;",ShippingState);
		ShippingState.sendKeys("Tamilnadu");
		WebElement ShippingZip= driver.findElement(By.xpath("(//label[text()='Shipping Zip/Postal Code']/following::div/input)[1]"));
		js.executeScript("arguments[0].ScrollDownIntoView;",ShippingZip);
		ShippingZip.sendKeys("600045");
		WebElement ShippingCountry= driver.findElement(By.xpath("(//label[text()='Shipping Country']/following::div/input)[1]"));
		js.executeScript("arguments[0].ScrollDownIntoView;",ShippingCountry);
		ShippingCountry.sendKeys("India");
//	12)Select Customer Priority as Low
		WebElement CustomerPriority =driver.findElement(By.xpath("(//label[text()='Customer Priority']/following::button)[1]"));
		js.executeScript("arguments[0].ScrollDownIntoView;",CustomerPriority);
		js.executeScript("arguments[0].click();",CustomerPriority);
		driver.findElement(By.xpath("//span[text()='Low']")).click();
		
//	13)Select SLA as Silver
		WebElement SLA =driver.findElement(By.xpath("(//label[text()='SLA']/following::button)[1]"));
		js.executeScript("arguments[0].ScrollDownIntoView;",SLA);
		js.executeScript("arguments[0].click();",SLA);
		driver.findElement(By.xpath("//span[text()='Silver']")).click();
//	14) Select Active as NO 
		WebElement Active =driver.findElement(By.xpath("(//label[text()='Active']/following::button)[1]"));
		js.executeScript("arguments[0].ScrollDownIntoView;",Active);
		js.executeScript("arguments[0].click();",Active);
		driver.findElement(By.xpath("//span[text()='No']")).click();
//	15) Enter Unique Number in Phone Field
		WebElement Phone= driver.findElement(By.xpath("(//label[text()='Phone']/following::div)[1]"));
		js.executeScript("arguments[0].ScrollDownIntoView;",Phone);
		Phone.sendKeys("9042599941");
//	16)Select Upsell Opportunity as No
		WebElement UpsellOpportunity =driver.findElement(By.xpath("(//label[text()='Upsell Opportunity']/following::button)[1]"));
		js.executeScript("arguments[0].ScrollDownIntoView;",UpsellOpportunity);
		js.executeScript("arguments[0].click();",UpsellOpportunity);
		driver.findElement(By.xpath("//span[text()='No']")).click();
//	17)Click on save and verfiy Phone number
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement Phnumber= driver.findElement(By.xpath("//span[text()='(904) 259-9941']"));
		
	
		if(Phnumber.isDisplayed()){
	
			System.out.println("Phone Number is Displayed");
		}else{
			System.out.println("Phone Number is Not Displayed");
		}
		
	}

}
