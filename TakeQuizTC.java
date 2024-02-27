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

public class TakeQuizTC {
	WebDriver driver;

	@BeforeMethod
	public void beforemethod() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void aftermethod() {
		driver.close();
	}
	


	@Test(priority = 1)
	public void takeQuizTc9() {   //take a quiz when by default ques select to 10
		
		driver.findElement(By.xpath("//p[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("loginmobile")).sendKeys("7896543213");
		driver.findElement(By.id("loginbtn")).click();

		JavascriptExecutor jses =(JavascriptExecutor)driver;
		for(int o=1;o<=9;o++) 
		{
			jses.executeScript("window.scrollBy(0,130)");
			driver.findElement(By.xpath("//*[text()='Next »']")).click();
		}
		driver.findElement(By.xpath("(//a[@id='qsubmit'])[1]")).click();

		String Expected_r ="10";
		String Actual_r =driver.findElement(By.xpath("(//span[@id='total'])[1]")).getText();
		Assert.assertEquals(Expected_r, Actual_r);

	}



	@Test(priority = 2)
	public void takeQuizTc10() {   //take a quiz when by user select 20 questions

		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.xpath("//input[@value='20']")).click();
		//or driver.findElement(By.name("count")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("loginmobile")).sendKeys("7896543213");
		driver.findElement(By.id("loginbtn")).click();

		JavascriptExecutor jses =(JavascriptExecutor)driver;
		for(int n=1;n<=19;n++) 
		{
			jses.executeScript("window.scrollBy(0,130)");
			driver.findElement(By.xpath("//*[text()='Next »']")).click();	
		}
		driver.findElement(By.xpath("(//a[@id='qsubmit'])[1]")).click();

		String Expected_r ="20";
		String Actual_r =driver.findElement(By.xpath("(//span[@id='total'])[1]")).getText();
		Assert.assertEquals(Expected_r, Actual_r);

	}

	@Test(priority = 3)
	public void takeQuizTc11() {   //take a quiz when by user select 25 questions

		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.xpath("//input[@value='25']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("loginmobile")).sendKeys("7896543213");
		driver.findElement(By.id("loginbtn")).click();

		JavascriptExecutor jses =(JavascriptExecutor)driver;
		for(int m=0;m<=24;m++) 
		{
			jses.executeScript("window.scrollBy(0,130)");
			driver.findElement(By.xpath("//*[text()='Next »']")).click();
		}
		driver.findElement(By.xpath("(//a[@id='qsubmit'])[1]")).click();

		String Expected_r ="25";
		String Actual_r =driver.findElement(By.xpath("(//span[@id='total'])[1]")).getText();
		Assert.assertEquals(Expected_r, Actual_r);
	}


}
