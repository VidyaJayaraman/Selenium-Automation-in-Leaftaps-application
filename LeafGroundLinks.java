package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundLinks {

	public static void main(String[] args) throws InterruptedException {
		
		// Setup ChromeDriver and Launch URL
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/link.xhtml");
	    driver.manage().window().maximize();
	    Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		//Go to Dashboard
         
		driver.findElement(By.xpath("//a[text()='Go to Dashboard']")).click();
		String title1 = driver.getTitle();
		System.out.println("Resulted page is-----> "+title1);
		
		// Go back to the previous page.
		
		driver.navigate().back(); // https://leafground.com/link.xhtml                
		String title2 = driver.getTitle();
		System.out.println("Current URL-----> "+title2);
		
		//Find the URL without clicking me
		
		String urlName = driver.findElement(By.xpath("//a[text()='Find the URL without clicking me.']")).getAttribute("href");
		System.out.println("Find the URL without clicking me is ----->"+ urlName);
		
		//Am I broken link?
		
		driver.findElement(By.xpath("//a[text()='Broken?']")).click();
		String title3 = driver.getTitle();
		System.out.println("Am I broken link?");
		if(title3.contains("404")) {
			System.out.println("It is a Broken Link");
		}
		else {
			System.out.println("It is not a Broken Link");
		}
		
		// Go back to the previous page.
		
		driver.navigate().back(); // https://leafground.com/link.xhtml                
				
		
		//Duplicate Link
		String dupUrlName = driver.findElement(By.xpath("//a[@class='logo']")).getAttribute("href");
		
		if(dupUrlName.equals(dupUrlName))
		{
			System.out.println("Is it a Duplicate Link?");
			System.out.println("It is a Duplicate Link");
		}
		else
		{
			System.out.println("It is not a Duplicate Link");
		}
		
		//Count Links
		
		List<WebElement> numOfLinks = driver.findElements(By.tagName("a"));
		System.out.println("How many links in this page-------> " +numOfLinks.size());
		
		// Count Layout Links
		// First click on the link and then find the links count under "a" tag in resulting page
		
		driver.findElement(By.xpath("//a[text()='How many links in this layout?']")).click();
		List<WebElement> countLayoutLinks = driver.findElements(By.tagName("a")); // no of links in resulting page
		System.out.println("Count Layout Links------>"+countLayoutLinks.size());
		
		
	}
        
}
