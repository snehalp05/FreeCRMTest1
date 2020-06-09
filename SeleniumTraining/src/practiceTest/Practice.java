package practiceTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice {
	
	static String departMonthYear;
	static String leftMonthYear;
	static String rightMonthYear;
	 

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium Browser Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.spicejet.com/");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@class='ui-datepicker-trigger']")).click();
		
		String monthsInYear[]=new String[12];
		monthsInYear[0]="January";
		monthsInYear[1]="February";
		monthsInYear[2]="March";
		monthsInYear[3]="April";
		monthsInYear[4]="May";
		monthsInYear[5]="June";
		monthsInYear[6]="July";
		monthsInYear[7]="August";
		monthsInYear[8]="September";
		monthsInYear[9]="October";
		monthsInYear[10]="November";
		monthsInYear[11]="December";
		
		String departDate="5-June-2021";
		String returnDate="10-June-2020";
		
		String departDateArr[]=departDate.split("-");
		String departDay=departDateArr[0];
		String departMonth=departDateArr[1];
		String departYear=departDateArr[2];
		int intdepartYear=Integer.parseInt(departYear);
		String departMonthYear=departDateArr[1]+" "+departDateArr[2];
		System.out.println("Depart Month Year "+departMonthYear);
		
		String returnDateArr[]=returnDate.split("-");
		String returntDay=returnDateArr[0];
		String returnMonth=returnDateArr[1];
		String returnYear=returnDateArr[2];
		int intReturnYear=Integer.parseInt(returnYear);
		String returnMonthYear=returnDateArr[1]+" "+returnDateArr[2];
		System.out.println("Return Month Year "+returnMonthYear);
		
		String leftMonth=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/div/span[1]")).getText();
		System.out.println(leftMonth);
		String leftYear=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/div/span[2]")).getText();
		System.out.println(leftYear);
		int intleftYear=Integer.parseInt(leftYear);
		
		leftMonthYear=leftMonth+" "+leftYear;
		System.out.println("Left Month Year "+leftMonthYear);
		
		String rightMonth=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/div/span[1]")).getText();
		System.out.println(rightMonth);
		String rightYear=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/div/span[2]")).getText();
		System.out.println(rightYear);
		int intrightYear=Integer.parseInt(rightYear);
		
		String rightMonthYear=rightMonth+" "+rightYear;
		System.out.println("Right Month Year "+rightMonthYear);
		
		int rightMonthIndex = 0,departMonthIndex = 0;
		for(int i=0;i<monthsInYear.length;i++) {
			if(monthsInYear[i].equals(rightMonth)) {
				rightMonthIndex=i;}
			if(monthsInYear[i].equals(departMonth)) {
				departMonthIndex=i;
			}
			
		}
		
		String beforeXpath = null;
		
		if(departMonthYear.equals(leftMonthYear)) {
			beforeXpath="//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[";
		}
		else if(departMonthYear.equals(rightMonthYear)) {
			beforeXpath="//*[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[";
		}else
		{
			int yearDiff=Math.abs(intrightYear-intdepartYear)*12;
			int monthDiff=rightMonthIndex-departMonthIndex;
			int loopCount=yearDiff-monthDiff;
			for(int i=0;i<loopCount;i++) {
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/a")).click();
			}
			beforeXpath="//*[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[";
			
		}
		
			dateClick(driver,departDay,beforeXpath);
	}

	
	private static void dateClick(WebDriver driver, String departDate, String beforeXpath) {
		String afterXpath="]/td[";
		int rowCount=6;
		int colCount=7;
		String day;
		
		
		for(int rowNum=1;rowNum<=rowCount;rowNum++) {
			for(int colNum=1;colNum<=colCount;colNum++) {
				try {
				day=driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]/a")).getText();
				}catch(NoSuchElementException e) {
					day="";
				}
				if(day.equals(departDate)) {
					driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]/a")).click();
				}
			}
		}
		
	}

}
