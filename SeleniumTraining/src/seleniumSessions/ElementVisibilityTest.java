package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\\\Program Files\\\\Selenium Browser Drivers\\\\chromedriver_win32\\\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://api.cogmento.com/register/");
		
		//1. isDispayed - applicable for all the elements
		//presence on the page
		boolean b1=driver.findElement(By.name("action")).isDisplayed();
		System.out.println(b1);
		
		//2. isEnabled -- if element is enabled
		boolean b2=driver.findElement(By.cssSelector("body > div.ui.middle.aligned.center.aligned.grid > div > div.ui.three.bottom.attached.steps > div:nth-child(3) > div > div.description")).isEnabled();
		System.out.println(b2);
		
		//3. isSelected -- only for checkbox, radio button and dropdown
		boolean b3=driver.findElement(By.xpath("//input[@name='terms']")).isSelected();
		System.out.println(b3);
	}

}
