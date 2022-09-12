package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebelementLocator_Xpath {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		
		driver.findElement(By.xpath("//input[contains(@class,'decorative')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		driver.findElement(By.xpath("//a[text() = 'Leads']")).click();
		
		driver.findElement(By.xpath("//a[text() = 'Create Lead']")).click();
		
		driver.getTitle();
		
		driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).sendKeys("TestLeaf");
		
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Vidya");
		
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Vidya");
		
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		
	}

}
