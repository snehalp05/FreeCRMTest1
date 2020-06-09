package seleniumSessions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReadPropertyFile {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
		//create properties class(inbuilt class in java) object
		Properties prop=new Properties();
		//FileInputSTream will create input stream between java code and properties file
		FileInputStream ip=new FileInputStream("C:\\Users\\Snehalesh\\eclipse-workspace\\SeleniumTraining\\src\\seleniumSessions\\config.properties");
		prop.load(ip);
		
		String browserName=prop.getProperty("browser");
		String url=prop.getProperty("URL");
		
		if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Selenium Browser Drivers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium Browser Drivers\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();	
		}
		else if(browserName.equals("internetExplorer")) {
			System.setProperty("webdriver.IE.driver", "C:\\Program Files\\Selenium Browser Drivers\\IEDriverServer_Win32_3.9.0\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();	
		}
		else {
			System.out.println("Browser Name not specified in Properties file");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get(url);
		
		driver.findElement(By.id(prop.getProperty("nameId"))).sendKeys("name");
		driver.findElement(By.id(prop.getProperty("mobNumId"))).sendKeys("mobNum");
	
	}

}
