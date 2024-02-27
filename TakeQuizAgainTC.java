package AutomationsTC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TakeQuizAgainTC {  //check Quiz Again test Case 
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	@Test
	public void checkTakeQuizAgainTc13() {

		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		//login
		driver.findElement(By.id("loginmobile")).sendKeys("7896543213");
		driver.findElement(By.id("loginbtn")).click();

		JavascriptExecutor jse =(JavascriptExecutor)driver;
		for(int p=1;p<=9;p++) {
			jse.executeScript("window.scrollBy(0,120)");
			driver.findElement(By.xpath("//*[text()='Next »']")).click();
		}
		//submit
		driver.findElement(By.xpath("//*[text()='Submit']")).click();


		// view answer
		driver.findElement(By.xpath("//*[text()='View Answer']")).click();

		//take a quiz again
		jse.executeScript("window.scrollBy(0,330)");
		driver.findElement(By.xpath("//*[text()='Take a Quiz Again']")).click();

		//testing
		String Expected_res = "Your Result";
		String Actual_res = driver.findElement(By.xpath("(//h3[@id='quizheading'])[1]")).getText();
		Assert.assertEquals(Expected_res, Actual_res);

	}



}
