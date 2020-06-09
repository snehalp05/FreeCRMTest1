package practiceTest;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderSelectTest {

	public static void main(String[] args) throws InterruptedException {
	

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium Browser Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		Thread.sleep(2000);
		
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
		
		String date="18-May-2020";
		String dateArr[]=date.split("-");
		String day=dateArr[0]; //18
		String chooseMonth=dateArr[1];	//Septemeber
		String year=dateArr[2];
		int chooseYear=Integer.parseInt(year);
		
		String selectedMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		String currentYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		int selectedYear=Integer.parseInt(currentYear);
		
		int yearCount=(chooseYear-selectedYear)*12;
		//int yearDiff =yearCount*12;
		System.out.println(yearCount);
		int yearDiff=Math.abs(yearCount);
		System.out.println(yearDiff);
		
		int count1 = 0,count2 = 0;
		for(int i=0;i<monthsInYear.length;i++) {
			if(monthsInYear[i].equals(chooseMonth))
				count1=i;
			if(monthsInYear[i].equals(selectedMonth))
				count2=i;
		}
		int monthDiff=count1-count2;
		System.out.println(monthDiff);
		 int loopCount;
				
			if(selectedYear>chooseYear) {
				loopCount=yearDiff-monthDiff;
					for(int i=0;i<loopCount;i++) {
						driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
			}}
			else if(selectedYear<chooseYear) {
				loopCount=yearDiff+monthDiff;	
					for(int i=0;i<loopCount;i++) {
						driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
			}}else {
				if(monthDiff<0) {
					for(int i=0;i<Math.abs(monthDiff);i++) {
						driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
			}
				}
				else {
					for(int i=0;i<Math.abs(monthDiff);i++) {
						driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
			}
				}
			}
		Thread.sleep(3000);
		
		//*[@id="ui-datepicker-div"]/table/tbody/tr[1]/td[2]/a
		//*[@id="ui-datepicker-div"]/table/tbody/tr[2]/td[1]/a	
		//*[@id="ui-datepicker-div"]/table/tbody/tr[3]/td[1]/a
		//*[@id="ui-datepicker-div"]/table/tbody/tr[2]/td[7]/a
		String beforeXpath="//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[";
		String afterXpath="]/td[";
		int rowCount=6;
		int colCount=7;
		String varDay = null;
		for(int rowNum=1;rowNum<rowCount;rowNum++) {
			for(int colNum=1;colNum<=colCount;colNum++) {
				try {
				varDay=driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]/a")).getText();
				}catch(org.openqa.selenium.NoSuchElementException e) {
					e.getStackTrace();
					System.out.println("Null Value");
					break;
				}
				System.out.println(varDay);	
				if(varDay.equals(day)) {
						driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]/a")).click();
					}
			}
		}
		
	}

}
