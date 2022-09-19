package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround_Buttons {

	public static void main(String[] args) throws InterruptedException {
		
	 // Setup ChromeDriver and Launch URL
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/button.xhtml");
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	 // Click and get the Title
				
	    driver.findElement(By.xpath("//button[@id = 'j_idt88:j_idt90']/span[text()='Click']")).click();
	    String title = driver.getTitle();
	    System.out.println(title);
	    
	// Check the button is disabled
	   
	   driver.get("https://leafground.com/button.xhtml");
	   driver.manage().window().maximize();
	   boolean enabled = driver.findElement(By.xpath("//button[@id = 'j_idt88:j_idt92']")).isEnabled();
	   System.out.println("Button is enabled " + enabled);
	
	// Find the position of submit button
	   
	   Point location = driver.findElement(By.xpath("//button[@id = 'j_idt88:j_idt94']/span[text()='Submit']")).getLocation();
	   System.out.println("Position of Submit button " + location);
	   
	// Color of save button
	   
	   String cssValue1 = driver.findElement(By.xpath("//button[@id = 'j_idt88:j_idt96']")).getCssValue("background-color");
	   System.out.println("Color of Save Button " + cssValue1);
	   
	// Find the length and width of submit button   
	 
	   Dimension size = driver.findElement(By.xpath("//button[@id = 'j_idt88:j_idt98']/span[text()='Submit']")).getSize();
	   System.out.println("Length and width of Submit button " + size);
	  
	// Check color change after mouse hover
	   
	   String cssValue2 = driver.findElement(By.xpath("//button[@id = 'j_idt88:j_idt100']")).getCssValue("background-color");
	   System.out.println("Before mouse hover " + cssValue2);
	   
	// Creating instance for action class to perform mouse hover
	   
	    Actions a = new Actions(driver);
	    a.moveToElement(driver.findElement(By.xpath("//button[@id='j_idt88:j_idt100']"))).build().perform();
	    
	// Check color change after Mouse Hover
	    
	    String cssValue3 = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt100']")).getCssValue("background-color");
		System.out.println("After Mouse hover " + cssValue3);
		
		if(cssValue2!=cssValue3)
			
			System.out.println("Color change on mouse hover successful");
		else
			
			System.out.println("Color change on mouse hover not successful");
		
	// Click on Image Button and Click on any hidden buttons
		
		driver.findElement(By.xpath("//button[@name='j_idt88:j_idt102:imageBtn']")).click();
		driver.findElement(By.xpath("//button[@name='j_idt88:j_idt102:imageBtn']/following-sibling::div")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[@name='j_idt88:j_idt102:imageBtn']")).click();
		
	    
	}

}
