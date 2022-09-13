package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class EditLead {
	
	
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
		
		driver.findElement(By.linkText("Ahalya")).click();
		
		// Verifying title of resulting page
		
		driver.getTitle();
		
		boolean equals = driver.getTitle().contains("View Lead");
		
		if(equals == true) {
			
		System.out.println("Title verified as true");
		}
		else {
		
	    System.out.println("Title verified as false");
		
		}
		 
		 	// Editing the existing company value with new value. 
		
		driver.findElement(By.xpath("//a[text() = 'Edit']")).click();
		
		String text = driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).getAttribute("value");
		
		System.out.println(text);
		
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
		
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys("Qmelk");
		
		driver.findElement(By.xpath("//input[@value = 'Update']")).click();
		
		//Checking the new value got updated or not
		
		String text2 = driver.findElement(By.xpath("//span[contains(text(),'Qmelk')]")).getText();
		
		if(text2.contains("Qmelk")) {
			
			System.out.println("Company name got updated");
			
			}
		else {
			
			System.out.println("Company name has not got updated");
		}
	
	
	
		driver.close();	
	}

}
