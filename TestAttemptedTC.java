package AutomationsTC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAttemptedTC {   //inside MY Account(Dashbord)Functionality 
	WebDriver driver ;

	@BeforeMethod
	public void beforeMethod () {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();	

	}

	@AfterMethod
	public void afterMethod() {
		driver.close();  }

	@Test
	public void checkTestAttemptedTc14() { //to test that test attempted functionality test case  =passed


		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		//login
		driver.findElement(By.id("loginmobile")).sendKeys("8888416950");
		driver.findElement(By.id("loginbtn")).click();

		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.xpath("//a[@class='text-white']")).click();

		String Expected="https://www.qa.jbktest.com/test/test-attempted";  
		String Actual_Res = driver.getCurrentUrl();
		Assert.assertEquals(Expected,Actual_Res);

	}
	
	@Test
	public void checkTestAttemptedTc15() { //to test that check test attempted on differnt date by clicking on
										//Action button functionality test case  = passed


		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		//login
		driver.findElement(By.id("loginmobile")).sendKeys("8888416950");
		driver.findElement(By.id("loginbtn")).click();

		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.xpath("//a[@class='text-white']")).click();

		//Action button contain test details
		driver.findElement(By.xpath("//i[@class='fa fa-eye']")).click();
		

		String Expected="https://www.qa.jbktest.com/exam/70019";  
		String Actual_Res = driver.getCurrentUrl();
		Assert.assertEquals(Expected,Actual_Res);
		
		

	}
}
