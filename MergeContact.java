package week4.day1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		WebElement user_name = driver.findElement(By.id("username"));
		user_name.sendKeys("Demosalesmanager");
		
		WebElement pass_word = driver.findElement(By.id("password"));
		pass_word.sendKeys("crmsfa");
		
		WebElement login_btn = driver.findElement(By.className("decorativeSubmit"));
		login_btn.click();
		
		WebElement 	c = driver.findElement(By.linkText("CRM/SFA"));
		c.click();
		
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("//span[text()='From Contact']//following::a[1]")).click();
		
		Set<String> allwindowHandles = driver.getWindowHandles();
		List<String> currentwindow = new ArrayList<String>(allwindowHandles);
		String newwindow = currentwindow.get(1);
		driver.switchTo().window(newwindow);
		driver.findElement(By.xpath("//button[@class='x-btn-text']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])/a")).click();
		driver.switchTo().window(currentwindow.get(0));
		driver.findElement(By.xpath("//span[text()='To Contact']//following::a[1]")).click();	
	
		Set<String> windowHandles = driver.getWindowHandles();  //there is no get option in set so, we converting set into List
		List<String> allWindowHandleList = new ArrayList<String>(windowHandles);
		
		String newwindow1 = allWindowHandleList.get(1);
		driver.switchTo().window(newwindow1);
		driver.findElement(By.xpath("//button[@class='x-btn-text']")).click();
				driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
		driver.switchTo().window(allWindowHandleList.get(0));
		driver.findElement(By.linkText("Merge")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		if (driver.getTitle().contains("View Contact")) {
			System.out.println("Page Title Matches");
		}else {
			System.out.println("Page Title is not Match");
		}
		driver.close();
	}
		
		
		

}
