package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium Browser Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://www.google.com");
		
		driver.findElement(By.name("q")).sendKeys("testing");
		Thread.sleep(3000);
		
		driver.quit();
		
	/*-	List<WebElement>elements=driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::b"));

		//*[@id="tsf"]/div[2]/div[1]/div[2]/div[2]/ul/li[6]/div/div[2]/div/span/b
		
		System.out.println(elements.size());
		
		for(int i=0;i<elements.size();i++) {
			String names=elements.get(i).getText();
			System.out.println(names);
			if(names.equals("tutorial")) {
				elements.get(i).click();
				break;
			}
		}
*/
	}

}
