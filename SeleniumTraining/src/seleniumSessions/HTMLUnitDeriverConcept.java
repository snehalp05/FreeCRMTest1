package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HTMLUnitDeriverConcept {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Program Files\\\\Selenium Browser Drivers\\\\chromedriver_win32\\\\chromedriver.exe");
		
		//WebDriver driver=new ChromeDriver();
		WebDriver driver=new HtmlUnitDriver();
		
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("test");
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]")).click();
		System.out.println(driver.getTitle());
	/*	driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://ui.freecrm.com/");

		driver.findElement(By.name("email")).sendKeys("snehalp05@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Snehalpatil@6");
		driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]")).click();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		
		*/
		//a java based implementation of a web browser without a GUI
		//HTMLUnit driver - no browser launch , testing is happening behind the scene
		//very fast, improves performance
		//not suitable for Actions class - mousehover, double click, drag and drop
		//for small scripts
		//also called ghost driver for Headless browser
		//Other Headless drivers -- 1. Fantom JS - for JS
	
	}

}
 