package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ImplicitWait {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Selenium Browser Drivers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	
		//dynamic wait, we are giving 30 sec implicit wait, if page is loaded before that remaining time is ignored
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//when page is fully loaded but some of the webelements are not loaded yet, so we need to give implicit wait to load webelement
		//dynaic wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		//hard wait

	}

}
