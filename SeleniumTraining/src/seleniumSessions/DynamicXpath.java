package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DynamicXpath {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Selenium Browser Drivers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://www.amazon.com/");
		
		//1. Normal relative xpath
	//	driver.findElement(By.xpath("//span[@class='nav-line-2']")).click();
		
		//2. contains Method
		//id=test123 next time,
		//id=test124
		//for dynamic Id - use xpath with contains function -- contains(@id,'test_')
				
	//	driver.findElement(By.xpath("//span[contains(@id,'glow-ingress-line1')]")).click();
	//	driver.findElement(By.xpath("//a[contains(@class,'nav-a nav-a-2 a-popover-trigger a-declarative')]")).click();
	//	driver.findElement(By.xpath("//a[@class='nav-a nav-a-2 a-popover-trigger a-declarative']")).click();
		
	//	driver.findElement(By.id("glow-ingress-line2")).click();
		
		
		//3. Starts With Method
	//	driver.findElement(By.xpath("//span[starts-with(@class,'nav-line-2')]")).click();
		
		//4. Ends WIth Method
	//	driver.findElement(By.xpath("//img[ends-with(@alt,'Track your package')]")).click();
		
		//5. specially for Links
		driver.findElement(By.xpath("//a[contains(text(),'Registry')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Gift Cards')]")).click();
	}

}
