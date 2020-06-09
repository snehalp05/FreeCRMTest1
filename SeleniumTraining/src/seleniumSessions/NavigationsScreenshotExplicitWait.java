package seleniumSessions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationsScreenshotExplicitWait {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Selenium Browser Drivers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//1. Navigations
		driver.get("http://www.google.com/");
		driver.navigate().to("http://www.amazon.com");
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().back();
		
		driver.navigate().refresh();
		
		//2. ScreenShot
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Snehalesh\\eclipse-workspace\\SeleniumTraining\\src\\seleniumSessions\\test.png"));
		
		//3. explicit wait
		WebElement locator=driver.findElement(By.linkText("Images"));
		new WebDriverWait(driver,20).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	
	}

}
