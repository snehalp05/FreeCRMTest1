package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Selenium Browser Drivers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies(); 
		
		//for drag and drop 3 steps
		//1. click on it  2. drag and drop  3. release it
		driver.switchTo().frame(0);
		Actions action=new Actions(driver);
		action.clickAndHold(driver.findElement(By.id("draggable"))).moveToElement(driver.findElement(By.id("droppable"))).release().build().perform();
		//clickAndHold()  , moveToElement() ,  release()
		
		
		
		

		
		
	}

}
