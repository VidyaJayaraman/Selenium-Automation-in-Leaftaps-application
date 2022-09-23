package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround_Radio {
	
public static void main(String[] args) {
	
	
	//  Driver setup , disable notification and launch URL
	
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	ChromeDriver driver = new ChromeDriver(options);
	
	// launch URL and Maximize Window
	
	driver.get("https://leafground.com/radio.xhtml");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	// Select favourite browser radio button
	
	driver.findElement(By.xpath("//label[text()='Chrome']")).click();
	
	//Unselectable
	
	driver.findElement(By.xpath("//label[text()='Chennai']")).click();
	
	// To find default select button
	
	String text = driver.findElement(By.xpath("//h5[contains(text(),'default')]/following::input[@checked='checked']/following::label")).getText();
    System.out.println("Default tab is "+text);
	
	// Select the age group (only if not selected)
    
    boolean selected = driver.findElement(By.xpath("//h5[contains(text(),'age')]/following::input[@checked='checked']")).isSelected();
    
    if(selected==true)
    {
    System.out.println("Already selected age 21-40");
    }
    else
    {
    driver.findElement(By.xpath("//label[text()='21-40 Years']")).click();
    }
    
    
   }
}
