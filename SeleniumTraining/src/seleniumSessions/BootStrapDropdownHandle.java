package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapDropdownHandle {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium Browser Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.jquery-az.com/bootstrap4/demo.php?ex=79.0_1");
		
		driver.findElement(By.id("btnDropdownDemo")).click();
		Thread.sleep(2000);
	
		
		List<WebElement>links=driver.findElements(By.xpath("//div[@class='dropdown-menu show']//a"));
		System.out.println(links.size());
		
		for(int i=0;i<links.size();i++) {
			
			if(links.get(i).getText().equals("jQuery")) {
				links.get(i).click();
				break;
			}
		}
	}

}
