package seleniumSessions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Program Files\\\\Selenium Browser Drivers\\\\chromedriver_win32\\\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://ui.freecrm.com/");

		driver.findElement(By.name("email")).sendKeys("snehalp05@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Snehalpatil@6");
	//	driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		
		//highlight Login button
		WebElement loginButton=driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
		
	//	flash(loginButton,driver); -- highlight button
	//	drawBorder(loginButton,driver); //-- draw border for the webelement which is having bug
		//take screenshot
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// now copy the screenshot to desired location using copyFile //method
		FileUtils.copyFile(src, new File("C:\\Users\\Snehalesh\\eclipse-workspace\\SeleniumTraining\\src\\seleniumSessions/element.png"));
		
		//generate Alert -- create RunTime ALert for any bug
	//	generateAlert(driver,"There is an issue with Login Button");
		
		//click element by JS
		clickElementByJS(driver,loginButton);
		
		//Refresh Browser by JS
	//	refreshBrowserByJS(driver);
		
		//Page title by JS
		//System.out.println(getTitleByJS(driver));
		
		//get page Inner text
		//System.out.println(getInnerText(driver));
		
		//page scroll
	//	scrollPageDown(driver);
		
		Thread.sleep(2000);
		WebElement contactElement=driver.findElement(By.xpath("//i[@class='right floated setting icon color-gray']"));
		scrollIntoView(driver,contactElement);
		
	}

		public static void flash(WebElement element, WebDriver driver) {
			String bgColor=element.getCssValue("backgroundColor");
			for(int i=0;i<50;i++) {
				changeColor("rgb(0,200,0)", element,driver);
				changeColor(bgColor,element,driver);
			}
		}

		public static void changeColor(String color, WebElement element, WebDriver driver) {
			//create JavascriptExecutor class(inbuilt class in selenium) refernce, and cast Webdriver object 
			JavascriptExecutor js =((JavascriptExecutor) driver);
		  	js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",  element);
		  	
		//	js1.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid yellow;');", element);
			
		}
		
		public static void drawBorder(WebElement element, WebDriver driver) {
			JavascriptExecutor js=((JavascriptExecutor) driver);
			js.executeScript("arguments[0].style.border='3px solid red'", element);
		}
		
		public static void generateAlert(WebDriver driver, String msg) {
			JavascriptExecutor js=((JavascriptExecutor) driver);
			js.executeScript("alert('"+msg+"')");
		}
		public static void clickElementByJS(WebDriver driver, WebElement element) {
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("arguments[0].click();", element);
		}
		public static void refreshBrowserByJS(WebDriver driver) {
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("history.go(0)");
		}
		public static String getTitleByJS(WebDriver driver) {
			JavascriptExecutor js=((JavascriptExecutor)driver);
			String title =js.executeScript("return document.title;").toString();
			return title;
		}
		public static String getInnerText(WebDriver driver) {
			JavascriptExecutor js=((JavascriptExecutor)driver);
			String innerText=js.executeScript("return document.documentElement.innerText;").toString();
			return innerText;
		}
		public static void scrollPageDown(WebDriver driver) {
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		}
		public static void scrollIntoView(WebDriver driver, WebElement element ) {
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			//JavascriptExecutor js = ((JavascriptExecutor) driver);
	    	//js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
}

