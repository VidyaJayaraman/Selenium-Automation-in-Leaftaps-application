package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {


	// To delete and verify the particular record by find option using id or phone num
		
		public static void main(String[] args) throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();
			
			ChromeDriver driver = new ChromeDriver();
			
			
			driver.get("http://leaftaps.com/opentaps/control/main");
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			driver.findElement(By.id("username")).sendKeys("DemoCSR");
			
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			
			driver.findElement(By.className("decorativeSubmit")).click();
			
			driver.findElement(By.linkText("CRM/SFA")).click();
			
			driver.findElement(By.linkText("Leads")).click();
			 
			driver.findElement(By.linkText("Find Leads")).click();
			
			// To find Lead details - Advanced Xpath ---> Parent to Child Xpath
			
			driver.findElement(By.xpath("//div[@class = 'x-form-element']/input[@name = 'id']")).sendKeys("10001");
			
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			
			driver.findElement(By.xpath("//span[text() = 'Phone']")).click();
			
			driver.findElement(By.name("phoneCountryCode")).clear();
			
			driver.findElement(By.name("phoneCountryCode")).sendKeys("91");
			
			driver.findElement(By.xpath("//input[@name = 'phoneNumber']")).sendKeys("7418529630");
			
			driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
			
			driver.findElement(By.xpath("//a[text() = '10304']")).click();
			
			// delete button
			
			driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
		
			// To be specific with Find Lead button - Xpath locator is used
			
			// To verify whether the deleted ID is not exists
			
			driver.findElement(By.xpath("//a[text() = 'Find Leads']")).click();
			
			driver.findElement(By.xpath("//input[@name='id']")).sendKeys("10304");
			
			driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
			
			
	}

}
