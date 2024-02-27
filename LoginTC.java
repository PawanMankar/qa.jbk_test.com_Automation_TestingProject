package AutomationsTC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTC {

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

	@Test(priority = 1)
	public void checkLoginTC4() { // enter valid credentials Login should done successfully //passed

		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("loginmobile")).sendKeys("8888558802"); //8888558802
		driver.findElement(By.id("loginbtn")).click();
		//String sr =driver.findElement(By.partialLinkText("Logout")).getText();
		//System.out.println(sr);

		String Expect_res= " Logout";
		String Actu_res = driver.findElement(By.partialLinkText("Logout")).getText();
		Assert.assertEquals(Expect_res, Actu_res);

	}

	@Test
	public void checkLoginTC5() { // enter invalid credentials error message should display //passed

		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("loginmobile")).sendKeys("888841696666");
		driver.findElement(By.id("loginbtn")).click();
		
		/*String sr =driver.findElement(By.id("loginerr")).getText();
		System.out.println(sr);*/
  
		String Expect_res= "Please enter valid mobile number, If you have not registered, please click signup tab to get registered.";
		String Actu_res = driver.findElement(By.id("loginerr")).getText();
	    Assert.assertEquals(Expect_res, Actu_res);
	    
	}
	
	@Test
	public void checkLoginTC6() { // enter (abcxyz)char invalid credentials error message should display //passed

		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("loginmobile")).sendKeys("abcxyz"); //char
		driver.findElement(By.id("loginbtn")).click();
		
		/*String sr =driver.findElement(By.id("loginerr")).getText();
		System.out.println(sr);*/
  
		String Expect_res= "Please enter valid mobile number, If you have not registered, please click signup tab to get registered.";
		String Actu_res = driver.findElement(By.id("loginerr")).getText();
	    Assert.assertEquals(Expect_res, Actu_res);
	    
	}
	
	@Test  //Already having an account? Click to login Here
	
	public void checkLoginTC7() { //Already having an account? Click to login Here functionalaity check  //passed

		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("signup-tab")).click();
		driver.findElement(By.xpath("//*[text()='Already having an account? Click to login Here']")).click();
		
		
		String Expect_res="Enter your Mobile Number";
		String Actu_res = driver.findElement(By.xpath("//*[text()='Enter your Mobile Number']")).getText();
	    Assert.assertEquals(Expect_res, Actu_res);
	    
	}
	


	



}
