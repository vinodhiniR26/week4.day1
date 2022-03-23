package week4.day1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Draggable {
		
		public static void main(String[] args) throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://www.leafground.com/pages/drag.html");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
			/*WebElement fF = driver.findElement(By.tagName("iframe"));
			driver.switchTo().frame(fF);*/
			WebElement dragEle = driver.findElement(By.id("draggable"));
			
			Actions builder = new Actions(driver);
			builder.dragAndDropBy(dragEle, 50, 20).click().build().perform();
			driver.switchTo().parentFrame();
			System.out.println("Done Dragging");
			driver.close();
			}

	}

