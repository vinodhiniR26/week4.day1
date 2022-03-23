package week4.day1;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Actions builder = new Actions(driver);
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		WebElement lop = driver.findElement(By.xpath("(//a[text()=\"L'Oreal Paris\"])[1]"));
		
		builder.moveToElement(brands).pause(1000).click(lop).perform();
		
		String title = driver.getTitle();
		System.out.println("The title is : " + title);
		
		driver.findElement(By.xpath("//div[@class='filters']//div[@id='filter-sort']")).click();
		driver.findElement(By.xpath("(//span[@class='title'])[4]")).click();
		
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text='Hair care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']/following::div[1]")).click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']/following::div[1]")).click();
		
		List<WebElement> filtersapplied = driver.findElements(By.className("filter-value"));
		for (int i = 0; i < filtersapplied.size(); i++) {
			System.out.println(filtersapplied.get(i).getText());
		}
		
		driver.findElement(By.xpath("//img[@alt=\"L'Oreal Paris Colour Protect Shampoo\"]")).click();
		Set<String> allwindowHandles = driver.getWindowHandles();
		List<String> allwindows = new ArrayList<String>(allwindowHandles);
		String newwindow = allwindows.get(1);
		driver.switchTo().window(newwindow);
		WebElement element = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select dd = new Select (element);
		dd.selectByVisibleText("175ml");
		System.out.println("Rate" + driver.findElement(By.xpath("//span[@class='css-1jczs19'][1]")).getText());
		driver.findElement(By.xpath("//span[text()='ADD TO BAG'][1]")).click();
		driver.findElement(By.xpath("//button[@class='css-g4vs13']")).click();
		
		WebElement elementframe = driver.findElement(By.xpath("//iframe[@src='/mobileCartIframe?ptype=customIframeCart']"));
	driver.switchTo().frame(elementframe);
	String GTotal = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		System.out.println("Grand Total " + GTotal);
		driver.findElement(By.xpath("//span[text()='PROCEED']")).click();
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		String Total = driver.findElement(By.xpath("//i[@class='icon']/parent::div[1]")).getText();
		if (GTotal.equals(Total)) {
			System.out.println("Totals Matched");
		}else {
			System.out.println("Totals Not Matched");
		}
		driver.quit();		
}
}
