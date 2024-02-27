package AutomationsTC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class SignUpTestCases {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver,chrome,driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}


	@Test(priority = 1)   //Test Case No.1
	public void checkSignUpTC1 () {  //Enter valid credentials Sign up should be done successful 

		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("signup-tab")).click();
		driver.findElement(By.id("name")).sendKeys("Mukul Manikraos");
		driver.findElement(By.id("emailid")).sendKeys("mukulm4@gmail.com");
		driver.findElement(By.id("mobile")).sendKeys("7896543569");

		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.TAB).perform();
		driver.findElement(By.id("agree")).click();
		driver.findElement(By.id("emailbtn")).click();

		String Expected_res= " Logout";
		String Actual_res = driver.findElement(By.partialLinkText("Logout")).getText();
		Assert.assertEquals(Expected_res,Actual_res );
	}


	@Test(priority = 2)
	public void checkSignUpTC2() {  //enter invalid mobile no error message should appear

		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("signup-tab")).click();
		driver.findElement(By.id("name")).sendKeys("Pawan Mankar");
		driver.findElement(By.id("emailid")).sendKeys("pawan7@gmail.com");
		driver.findElement(By.id("mobile")).sendKeys("12308652156"); //11 digit no.(boundry value)

		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.TAB).perform();
		driver.findElement(By.id("agree")).click();
		driver.findElement(By.id("emailbtn")).click();

		String Expected_res= " Logout";
		String Actual_res = driver.findElement(By.partialLinkText("Logout")).getText();
		Assert.assertEquals(Expected_res,Actual_res );


	}


	@Test(priority = 3)
	public void checkSignUpTc3() {  //Enter Invalid Email error message should appear

		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("signup-tab")).click();
		driver.findElement(By.id("name")).sendKeys("Pawan Mankar");

		driver.findElement(By.id("emailid")).sendKeys("pawan@gmails.cons"); //invalid email //Bug

		driver.findElement(By.id("mobile")).sendKeys("7896553544");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.TAB).perform();
		driver.findElement(By.id("agree")).click();
		driver.findElement(By.id("emailbtn")).click();

		String Expected_res= " Logout";
		String Actual_res = driver.findElement(By.partialLinkText("Logout")).getText();
		Assert.assertEquals(Expected_res,Actual_res );
		
	}
	
	@Test(priority = 4)
	public void checkSighUpTc4() { //regester functionality link working or not  //passed
		
		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.xpath("//*[text()='Not having an account? Register Here']")).click();
		
		/*String str = driver.findElement(By.id("quizcontent")).getText();
		System.out.println(str);*/
		
		String Expected_res="Name";
		String Actual_res = driver.findElement(By.xpath("//*[text()='Name']")).getText();
		Assert.assertEquals(Expected_res,Actual_res );
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
