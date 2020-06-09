package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DynamicWebTableHandle {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\\\Program Files\\\\Selenium Browser Drivers\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://ui.freecrm.com/");

		driver.findElement(By.name("email")).sendKeys("snehalp05@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Snehalpatil@6");
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"main-nav\"]/a[3]/span")).click();
		Thread.sleep(3000);
		
		//table[@class='ui celled sortable striped table custom-grid table-scroll']/tbody/tr[1]/td[2]
		//table[@class='ui celled sortable striped table custom-grid table-scroll']/tbody/tr[2]/td[2]
		//table[@class='ui celled sortable striped table custom-grid table-scroll']/tbody/tr[3]/td[2]
		//table[@class='ui celled sortable striped table custom-grid table-scroll']/tbody/tr[4]/td[2]
		
		String beforeXpath="//table[@class='ui celled sortable striped table custom-grid table-scroll']/tbody/tr[";
		String afterXpath="]/td[2]";
		String clickXpath = null;
		Actions action = new Actions(driver); 
		for (int i=1;i<=4;i++) {
			String names=driver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();
			if(names.equals("Snehal Patil")) {
				WebElement element = driver.findElement(By.xpath(beforeXpath+i+"]/td[1]/div/label"));

				action.moveToElement(element).click().build().perform();
			}
		}
		
		
	
	}

}
