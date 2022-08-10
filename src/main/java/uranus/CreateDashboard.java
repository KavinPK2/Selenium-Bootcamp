package uranus;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDashboard {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String actualResult="Dashboard saved";
		//Chrome Browser path
		WebDriverManager.chromedriver().setup();
		//To disable chrome notifications
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		//Object creation For Chrome
		ChromeDriver driver=new ChromeDriver(option);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//1.Launch application
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		WebElement usr=	driver.findElement(By.id("username"));
		usr.sendKeys("hari.radhakrishnan@qeagle.com");
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("India$321");
		driver.findElement(By.name("Login")).click();
		Thread.sleep(15000);
		//driver.close();
		//2.Toggle menu button
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//driver.findElement(By.xpath("//button[@class='slds-button slds-show']/div")).click();
		Thread.sleep(15000);
		//3.Click View all
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(10000);
		//Scroll mouse for Dashboard
		WebElement Dashboard= driver.findElement(By.xpath("//p[text()='Dashboards']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",Dashboard);
		Thread.sleep(10000);
		// Click Dashboard alternative method
		//driver.findElement(By.xpath("//p[text()='Dashboards']")).click();
		Thread.sleep(10000);
		//4.Click New Dashboard option
		driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();
		Thread.sleep(10000);
		//5.Enter Name as 'Salesforce Automation by Your Name ' 
		//Enter frame using Index
		driver.switchTo().frame(0);
		//interact with element inside frame
		WebElement create_name =driver.findElement(By.xpath("//input[@id='dashboardNameInput']"));
		//Thread.sleep(15000);
		create_name.sendKeys("Salesforce Automation by Hepzi");
		Thread.sleep(10000);
		//Click on Create
		driver.findElement(By.xpath("//button[contains(text(),'Create')]")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		//6.Click on Save 
		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		//Verify Dashboard name.
		String verifyMessage= driver.findElement(By.xpath("//span[text()='Dashboard saved']")).getText();
		if(verifyMessage.equals(actualResult)) {
			System.out.println("New Dashboard created successfully");
		}
		else {
			System.out.println("Dashboard not created");
		}
		driver.close();
		//Expected Result: The New Dashboard is created Successfully
	}

	}


