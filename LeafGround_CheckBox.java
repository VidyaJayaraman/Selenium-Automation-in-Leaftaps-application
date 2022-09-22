package week2.day2;
  //****************CHECKBOX SELECTION*********************

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround_CheckBox {
	
	public static void main(String[] args) throws InterruptedException {
		
		// Driver setup , disable notification and launch URL
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
		
		// To select Basic check box
		
		driver.findElement(By.xpath("//span[text()='Basic']")).click();
		Thread.sleep(3000);
		boolean selectedBasic = driver.findElement(By.xpath("//h5[contains(text(),'Basic')]/following::span[1]")).isEnabled();
		System.out.println("Checkbox basic selected: " + selectedBasic);
		
		// To select Ajax check box
		
		driver.findElement(By.xpath("//span[text()='Ajax']")).click();
		
		//To select favourite language
		
		driver.findElement(By.xpath("//label[text()='Java']")).click();
		
		//To select Tristate checkbox
		
		driver.findElement(By.xpath("//div[contains(@id,'ajaxTriState')]")).click();
		
		// To select Toggle switch
		
		driver.findElement(By.className("ui-toggleswitch-slider")).click();
		
		// To check the checkbox is disabled.
		
		boolean enabled = driver.findElement(By.xpath("//h5[contains(text(),'Verify')]/following::div[5]")).isSelected();
		if(enabled==true)
		{
		System.out.println("Checkbox is enabled");
		}
		else
		{
			System.out.println("Checkbox is disabled");	
		}
		
		//Select Multiple
		
		driver.findElement(By.xpath("//ul[@data-label='Cities']")).click();
		driver.findElement(By.xpath("(//label[text()='Paris'])[2]")).click();
		driver.findElement(By.xpath("(//label[text()='London'])[2]")).click();
		
	
	}

}
