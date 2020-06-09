package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsConcept {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Selenium Browser Drivers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize(); //maximize window
		driver.manage().deleteAllCookies(); //delete cache
		
		Actions action=new Actions(driver); //pass Webdriver reference to action class
		action.moveToElement(driver.findElement(By.id("highlight-addons"))).build().perform();
		Thread.sleep(3000);
	
		driver.findElement(By.linkText("Seat + Meal Combo")).click();
		

	}

}
