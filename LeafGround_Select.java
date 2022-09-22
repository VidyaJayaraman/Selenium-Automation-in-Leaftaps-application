package week2.day2;

import java.awt.List;
import java.time.Duration;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.*;
public class LeafGround_Select {

public static void main(String[] args) throws InterruptedException {
		
		// Setup ChromeDriver and Launch URL and Clear browser Notifications 

				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("disable-notifications");
				
				ChromeDriver driver = new ChromeDriver(options);
				driver.get("https://leafground.com/select.xhtml");
			    driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
	   // Select UI Tool
				
				WebElement uiToolSelect = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
				
				
				Select dd1 = new Select(uiToolSelect);
				dd1.selectByIndex(3);
				
      // Select Country
				
				driver.findElement(By.xpath("(//label[contains(@id,'country_label')] /following::div)[1]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//li[text()='Brazil']")).click();
		        Thread.sleep(3000);
				
		        
     // Select City
				
				driver.findElement(By.xpath("(//label[contains(@id,'city_label')] /following::div)[1]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//li[text()='Salvador']")).click();
		        Thread.sleep(3000);
		        
	 // To verify Cities under Brazil
		       
		        System.out.println("To verify cities under Brazil");
		        driver.findElement(By.xpath("(//label[contains(@id,'city_label')] /following::div)[1]")).click();
				Thread.sleep(3000);
		        java.util.List<WebElement> cityListBrazil = driver.findElements(By.xpath("//ul[contains(@id,'city_items')]/li"));
		        for (WebElement eachElement : cityListBrazil) {
		        	
		        	String text = eachElement.getText();
					System.out.println(text);
				}
		        
		       
	// Select Course
		        
		         driver.findElement(By.xpath("//button[@aria-label='Show Options']")).click();
		         Thread.sleep(3000);
		         driver.findElement(By.xpath("//li[text()='Playwright']")).click();
			     Thread.sleep(3000);
			
	//  Select Language
				
		        driver.findElement(By.xpath("(//label[contains(text(),'Language')] /following::div)[1]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//li[text()='Tamil']")).click();
		        Thread.sleep(3000);
		        
	// Select values
		        
		        driver.findElement(By.xpath("//label[contains(text(),'Values')] /following::div[1]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//li[text()='இரண்டு']")).click();
		        Thread.sleep(3000);
			   
				                                          
				
}	  
	
}
