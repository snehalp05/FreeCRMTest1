package seleniumSessions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Program Files\\\\Selenium Browser Drivers\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://ui.freecrm.com/");

		driver.findElement(By.name("email")).sendKeys("snehalp05@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Snehalpatil@6");
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		
		Thread.sleep(3000);
		
		//1. get all the links withtags a and img
		List<WebElement>linkList=driver.findElements(By.tagName("a"));
		List<WebElement>linksWithImgTag=driver.findElements(By.tagName("img"));
		
		linkList.addAll(linksWithImgTag);
		System.out.println(linkList.size());
		
		//2. get the active links by eliminating links which has href is null
		List<WebElement>activeLinks=new ArrayList<WebElement>();
		
		for(int i=0;i<linkList.size();i++) {
			if(linkList.get(i).getAttribute("href")!=null) {
				activeLinks.add(linkList.get(i));
			}
		}
		System.out.println(activeLinks.size());
		
		//3. use HTTP api to test href url
		for(int j=0;j<activeLinks.size();j++) {
			HttpURLConnection connection=(HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection(); 
			// create object of URL class and pass the href link in it
			//store it in HttpURLConnection class reference and cast into HttpURLConnection
			//openConnection()
			
			connection.connect();
			String response=connection.getResponseMessage();
			int reponseCode=connection.getResponseCode();
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href")+"--"+reponseCode+"--"+response);
			
		}

	}

}
