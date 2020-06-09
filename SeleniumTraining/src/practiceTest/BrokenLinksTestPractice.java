package practiceTest;

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

public class BrokenLinksTestPractice {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium Browser Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.amazon.in/");
		
		List<WebElement>allLinks=driver.findElements(By.tagName("a"));
		List<WebElement>linksWithImgTag=driver.findElements(By.tagName("img"));
				
				allLinks.addAll(linksWithImgTag);
				
				System.out.println(allLinks.size());
		
		List<WebElement> activeLinks=new ArrayList<WebElement>();
		
		for(int i=0;i<allLinks.size();i++) {
			if(allLinks.get(i).getAttribute("href")!=null && !(allLinks.get(i).getAttribute("href").contains("javascript"))) {
				activeLinks.add(allLinks.get(i));
			}
		}
		
		System.out.println(activeLinks.size());
		
		for(int j=0;j<activeLinks.size();j++) {
			
			HttpURLConnection connection=(HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			
			connection.connect();
			String responseMsg=connection.getResponseMessage();
			int responseCode=connection.getResponseCode();
			connection.disconnect();
			
			System.out.println(activeLinks.get(j).getAttribute("href")+" "+responseCode+" "+responseMsg);
		}
		
		
	}

}
