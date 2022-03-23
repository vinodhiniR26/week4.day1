package week4.day1;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class ExplictWaitAppear {
		public static void main(String[] args) throws IOException {
			
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			//open url
			driver.get("http://www.leafground.com/pages/appear.html");
			//maximize window
			driver.manage().window().maximize();
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			
			File screenshot = driver.getScreenshotAs(OutputType.FILE);
			File targetFile = new File("./images/BeforeElementAppears.jpg");
			FileUtils.copyFile(screenshot, targetFile);
				
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='flex']//button[3]")));
			
			String missingText = driver.findElement(By.xpath("//div[@class='flex']//button[3]")).getText();
			System.out.println(missingText);
			
			File screenshot1 = driver.getScreenshotAs(OutputType.FILE);
			File targetFile1 = new File("./images/AfterElementAppears.jpg");
			FileUtils.copyFile(screenshot1, targetFile1);

		}
}
