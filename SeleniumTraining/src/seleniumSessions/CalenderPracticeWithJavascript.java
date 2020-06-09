package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderPracticeWithJavascript {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium Browser Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.spicejet.com/");
		Thread.sleep(2000);
		
		WebElement date=driver.findElement(By.id("ctl00_mainContent_txt_Fromdate"));
		System.out.println(date.getAttribute("id"));
		System.out.println(date.getAttribute("value"));
		String dateVal="02-06-2020";
		
		selectDateByJS(driver,dateVal,date);
		
	}
	
	public static void selectDateByJS(WebDriver driver,String dateVal,WebElement date) {
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", date);
	}

}
