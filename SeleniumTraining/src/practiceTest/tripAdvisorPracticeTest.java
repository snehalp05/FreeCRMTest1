package practiceTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class tripAdvisorPracticeTest {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium Browser Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.tripadvisor.in/");
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(2000);
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//span[@class='ui_button w100p regEmailContinue newRegFormButtonStyles']")).click();
		
		driver.findElement(By.xpath("//div[@class='ui_button primary regSubmitBtn']")).click();

	}

}
