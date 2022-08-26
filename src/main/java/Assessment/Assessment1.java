package Assessment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assessment1 {

	public static void main(String[] args) throws InterruptedException {
//		    1. Login to https://login.salesforce.com
        WebDriverManager.chromedriver().setup();
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("saturn@testleaf.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Bootcamp$123");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
//			2. Click on toggle menu button from the left corner
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
//			3. Click view All 
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
//			4. Click Sales from App Launcher
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement sales= driver.findElement(By.xpath("//p[text()='Sales']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",sales );
		
		sales.click();
//			5. Select Home from the DropDown
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement Home=driver.findElement(By.xpath("//span[text()='Home']"));
		js.executeScript("arguments[0].click();",Home );
		
//			6. Add CLOSED + OPEN values and result should set as the GOAL (If the result is less than 10000 then set the goal as 10000)

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(2000);
		String closevalue =driver.findElement(By.xpath("(//span[text()='Closed'])[1]/following-sibling::lightning-formatted-text")).getText();
		Thread.sleep(2000);
		System.out.println(closevalue);
		Thread.sleep(2000);
		String newStr1 = closevalue.replaceAll("\\D", "");
        System.out.println(newStr1);
        Thread.sleep(2000);
        int parseInt1 = Integer.parseInt(newStr1);
        System.out.println(parseInt1);
        
        Thread.sleep(2000);
		String Openvalue =driver.findElement(By.xpath("(//span[text()='Open (>70%)'])[1]/following-sibling::lightning-formatted-text")).getText();
		System.out.println(Openvalue);
		Thread.sleep(2000);
		String newStr2 = Openvalue.replaceAll("\\D", "");
        System.out.println(newStr2);
        Thread.sleep(2000);
        int parseInt2 = Integer.parseInt(newStr2);
        System.out.println(parseInt2);
        Thread.sleep(2000);
        int sum = parseInt1+parseInt2;
        System.out.println(sum);
        
        if(sum<10000) {
        	driver.findElement(By.xpath("//button[@title='Edit Goal']")).click();
        	driver.findElement(By.xpath("//input[@aria-describedby='currencyCode']")).clear();
        	driver.findElement(By.xpath("//input[@aria-describedby='currencyCode']")).sendKeys("10000");
        	driver.findElement(By.xpath("//div[@class='buttonGroup']/button[@type='button'][2]")).click();
        	System.out.println("Value lessthan 10000");
        }else {
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//button[@title='Edit Goal']")).click();
        	//convert the string
            String strSum = sum+"";
            driver.findElement(By.xpath("//input[@aria-describedby='currencyCode']")).clear();
        	driver.findElement(By.xpath("//input[@aria-describedby='currencyCode']")).sendKeys(strSum);
        	
        	driver.findElement(By.xpath("//div[@class='buttonGroup']/button[@type='button'][2]")).click();
        	System.out.println("Value greaterthan 10000");
        
        }
        	
        
//			7. Navigate to Dashboard tab
        WebElement Dashboard= driver.findElement(By.xpath("//span[text()='Dashboards']"));
		
		js.executeScript("arguments[0].click();",Dashboard);
		Thread.sleep(10000);
//			8. Click on New Dashboard
		driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();
		Thread.sleep(10000);
//			9. Enter the Dashboard name as "YourName_Workout"
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).sendKeys("Kavin_Workout");
		
//			10. Enter Description as Testing and Click on Create
		
		driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']")).sendKeys("Testing");
		
//			11. Click on Create
		driver.findElement(By.xpath("//button[contains(text(),'Create')]")).click();
//			12. Click on Done
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[text()='Done']")).click();
//			13. Click on Dashboard tab
		WebElement Dashboard1= driver.findElement(By.xpath("//span[text()='Dashboards']"));
		js.executeScript("arguments[0].click();",Dashboard1);
		Thread.sleep(10000);
//			14. Verify the Dashboard is Created
		driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']")).sendKeys("Kavin_Workout");
		
		WebElement verify=driver.findElement(By.xpath("//span[text()='Kavin_Workout']"));
		
		if (verify != null) {
			System.out.println("Kavin_Workout created Successfully");
			
		} else {
			System.out.println("Kavin_Workout Not created");
		}
		
		
//			15. Click on the newly created Dashboard
		js.executeScript("arguments[0].click();",verify);
		Thread.sleep(10000);
		
		
		
//			16. Click on Subscribe
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.switchTo().frame(1);
		WebElement Subscribe =driver.findElement(By.xpath("//button[text()='Subscribe']"));
//		js.executeScript("arguments[0].click();",Subscribe);
//		Thread.sleep(10000);
		Subscribe.click();
		
//			14. Select Frequency as "Daily"
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//span[text()='Daily']")).click();
//			15. Time as 10:00 AM
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("time")).click();
		WebElement time= driver.findElement(By.xpath("//option[text()='10:00 AM']"));
		js.executeScript("arguments[0].scrollIntoView();",time );
		js.executeScript("arguments[0].click();",time);
//			16. Click on Save
		driver.findElement(By.xpath("//button[@title='Save']")).click();
//			17. Verify "You started Dashboard Subscription" message displayed or not
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String verifyMessage= driver.findElement(By.xpath("//span[text()='You started a dashboard subscription.']")).getText();
		
		System.out.println(verifyMessage);
		if(verifyMessage.equals("You started a dashboard subscription.")) {
			System.out.println("Dashboard Subscription successfully");
		}
		else {
			System.out.println("Dashboard Subscription not Subscriped");
		}
//			18. Click on Dashboards tab
		js.executeScript("arguments[0].click();",Dashboard1);
		Thread.sleep(10000);
//			19. Verify the newly created Dashboard is available
		driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']")).sendKeys("Kavin_Workout");
		if (verify != null) {
			System.out.println("newly created Dashboard is available");
			
		} else {
			System.out.println("newly created Dashboard is not available");
		}
//			20. Click on dropdown for the item
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement dropdown=driver.findElement(By.xpath("(//span[text()='Show actions'])[6]"));
		js.executeScript("arguments[0].click();",dropdown);
		
		
//		    21. Select Delete
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
//		    22. Confirm the Delete
		driver.findElement(By.xpath("(//span[text()='Delete'])[2]")).click();
//		    23. Verify the item is not available under Private Dashboard folder
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//a[@title='Private Dashboards'])[1]")).click();
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//input[@placeholder='Search private dashboards...']")).sendKeys("Kavin_Workout");
		WebElement verify1 = driver.findElement(By.xpath("//span[text()='No results found']"));
		if (verify1 != null) {
			System.out.println("item is not available under Private Dashboard folder");
			
		} else {
			System.out.println("item is available under Private Dashboard folder");
		}
	}

}
