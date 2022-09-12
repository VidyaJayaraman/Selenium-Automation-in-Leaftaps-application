package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class Facebook_test {
	
	
	public static void main(String[] args) {
		
		// Create new Account in FaceBook - automation
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://en-gb.facebook.com");
		
		driver.manage().window().maximize();
		
		// Implicit Wait
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//button[@title = 'Only allow essential cookies']")).click();
		
		driver.findElement(By.xpath("//a[text() = 'Create New Account']")).click();
		
		driver.findElement(By.name("firstname")).sendKeys("Anitha");
		
		driver.findElement(By.name("lastname")).sendKeys("Jay");
		
		driver.findElement(By.name("reg_email__")).sendKeys("+918056163331");
		
		driver.findElement(By.name("reg_passwd__")).sendKeys("Vodafone@123");
		
		// Selecting Date of Birth from dropdowns
		
		WebElement select1 = driver.findElement(By.xpath("//select[@id = 'day']"));
		
		Select dd1 = new Select(select1);
		
		dd1.selectByIndex(13);
		
		WebElement select2 = driver.findElement(By.xpath("//select[@id = 'month']"));
		
        Select dd2 = new Select(select2);
		
		dd2.selectByIndex(8);
		
        WebElement select3 = driver.findElement(By.xpath("//select[@id = 'year']"));
		
        Select dd3 = new Select(select3);
		
		dd3.selectByIndex(34);
		
		//Gender Selection Female 
		
        driver.findElement(By.xpath("//label[text() = 'Female']")).click();
        
        // Male
        
        driver.findElement(By.xpath("//label[text() = 'Male']")).click();
        
        //Custom
        
        driver.findElement(By.xpath("//label[text() = 'Custom']")).click();
        
        driver.findElement(By.name("websubmit")).click();
		
	}

}
