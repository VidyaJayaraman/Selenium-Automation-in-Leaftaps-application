package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround_Input {

	public static void main(String[] args) throws InterruptedException {
		
	// Setup ChromeDriver and Launch URL
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/input.xhtml");
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	              
	// Type the name  
		              
		driver.findElement(By.xpath("//input[@id = 'j_idt88:name']")).sendKeys("Vidya");
		
	// Type the country
		
		driver.findElement(By.xpath("//input[@id = 'j_idt88:j_idt91']")).sendKeys("-India");
		
	// Check the button is disabled or not
			
		boolean enabled = driver.findElement(By.xpath("//input[@id = 'j_idt88:j_idt93']")).isEnabled();
	    System.out.println("The button is enabled " + enabled);
				 	
 	//  Clear the text which is present in value attribute already present
				 	
		driver.findElement(By.xpath("//input[@id = 'j_idt88:j_idt95']")).clear();
				 		
	// Retrive the typed text
				 		
	    String attribute = driver.findElement(By.xpath("//input[@id='j_idt88:j_idt97']")).getAttribute("value");	
		System.out.println("Retrieved text is  " + attribute);
				 		
	// Type email and press tab
				 		
 		driver.findElement(By.xpath("//input[@id = 'j_idt88:j_idt99']")).sendKeys("vvv@gmail.com");
 		driver.findElement(By.xpath("//input[@id = 'j_idt88:j_idt99']")).sendKeys(Keys.TAB);	
 		
	// Type about yourself 
 		
 		driver.findElement(By.xpath("//textarea[@id='j_idt88:j_idt101']")).sendKeys(" I am passionate to learn");
 		
	// Type Description and Select Font style.
 		
 		driver.findElement(By.xpath("//span[@class='ql-picker-label']")).click();	
 		Thread.sleep(3000);
 		driver.findElement(By.xpath("//span[@data-value='serif']")).click();
 		Thread.sleep(3000);
 		driver.findElement(By.xpath("//div[@class = 'ql-editor ql-blank']")).sendKeys("Week2 Assignments in Selenium");
 		
 	// Press Enter in Age and check error message
 					
		driver.findElement(By.xpath("//input[@id = 'j_idt106:thisform:age']")).sendKeys(Keys.ENTER);
		boolean displayErrorMessage = driver.findElement(By.xpath("//span[text() = 'Age is mandatory']")).isDisplayed();
 		System.out.println("displayErrorMessage " + displayErrorMessage);
		
  // Verify position of username label after click 
		
		Point location1 = driver.findElement(By.xpath("//input[@id = 'j_idt106:float-input']")).getLocation();
 		System.out.println(location1);	
 		
 //	Verify position of username label after click  	
 		
 		driver.findElement(By.xpath("//input[@id = 'j_idt106:float-input']")).click();
 		Point location2 = driver.findElement(By.xpath("//label[@id = 'j_idt106:j_idt113']")).getLocation();
 		System.out.println(location2);	
 		
 //comparing two locations	
 		
 		boolean location = location1.equals(location2);
 		if(location == false)
 			System.out.println("label position changed");
 		else
 			System.out.println("label position not changed");
 			
 	// Enter name and choose third position
 			
 			driver.findElement(By.xpath("//input[@id = 'j_idt106:auto-complete_input']")).sendKeys("Vidya");
 			driver.findElement(By.xpath("//span[@id='j_idt106:auto-complete_panel']//li[3]")).click();
 			Thread.sleep(3000);
 			
   //  Entering date
 			
 		driver.findElement(By.xpath("//input[@name = 'j_idt106:j_idt116_input']")).sendKeys("7/14/1988");	
 		Thread.sleep(3000);
 			
 //	  Type number and spin to confirm value changed
 			
 		driver.findElement(By.id("j_idt106:j_idt118_input")).sendKeys("11");	
 		driver.findElement(By.xpath("//span[@class = 'ui-icon ui-c ui-icon-triangle-1-n']")).click();
 		String value = driver.findElement(By.id("j_idt106:j_idt118_input")).getAttribute("aria-valuenow");
 			
 		if(value.contains("12"))
 			System.out.println("Spin Worked");
 		else
 			System.out.println("Spin Not worked");
 					
	// Checking slide movement by changing number value
 					
		Point location3 = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']")).getLocation();		
		System.out.println(location3);
 		driver.findElement(By.xpath("//input[@id ='j_idt106:slider']")).sendKeys("10");
 	    Thread.sleep(3000);
	    Point location4 = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']")).getLocation();
 	    System.out.println(location4);
 	    boolean slideMove = location3.equals(location4);
 		if(slideMove == true)
 			System.out.println("Slide bar movement not worked");
 		else
 			System.out.println("Slide bar movement worked");
 							
	// checking that keyboard is displaying after click
 							
		 driver.findElement(By.xpath("//input[@id='j_idt106:j_idt122']")).click();
		 boolean displayed = driver.findElement(By.xpath("//div[@class='ui-widget ui-widget-content ui-corner-all ui-shadow keypad-popup ui-input-overlay']")).isDisplayed();					
 		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//button[text()='Close']")).click();	
		 System.out.println("Keyboard is displayed " + displayed);
	 		
	}

}
