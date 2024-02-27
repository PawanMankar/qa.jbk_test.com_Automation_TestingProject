package AutomationsTC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TotalTopicCoverdTC {   //inside MY Account(Dashbord)Functionality
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
	public void checkTotalTopicCoverTc19() { //to test that total topic coverd Functions = Passed

		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		//login
		driver.findElement(By.id("loginmobile")).sendKeys("8888416950");
		driver.findElement(By.id("loginbtn")).click();

		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.xpath("(//a[text()='View Details '])[5]")).click();
		//String txt = driver.getCurrentUrl();
		//System.out.println(txt);
		
		

		String Expected="https://www.qa.jbktest.com/topics-covered";  
		String Actual_Res = driver.getCurrentUrl();
		//or
		//String Actual_Res = driver.getTitle();
		Assert.assertEquals(Expected,Actual_Res);

	}
	
	
	
}
