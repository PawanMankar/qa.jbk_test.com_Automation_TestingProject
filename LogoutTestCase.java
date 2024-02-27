package AutomationsTC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LogoutTestCase {
	
	WebDriver driver;

	@BeforeMethod
	public void beforemethod() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void afterMethod () {
		driver.close();
	}
	
	@Test
	public void checkLogOutTC8() {  //iframe pop up arrived after logout so we cant got this
		
		
	driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
	driver.findElement(By.id("countbtn")).click();
	//login
	driver.findElement(By.id("loginmobile")).sendKeys("7896543213");
	driver.findElement(By.id("loginbtn")).click();
	
	//logouts
	driver.findElement(By.linkText("Logout")).click();
	
	
	String Exprct_res = "jbktest.com";
	String Actut_res = driver.findElement(By.partialLinkText("jbktest")).getText();
	Assert.assertEquals(Exprct_res, Actut_res);
	

}
}
