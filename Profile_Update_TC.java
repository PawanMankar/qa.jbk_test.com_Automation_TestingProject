package AutomationsTC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Profile_Update_TC { //inside MY Account Functionality PROFILE UPDATE Main Functionality
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

	@Test(priority = 1)
	public void checkTc_20() { //to test that Profile Functionality profile option open or not //passed

		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		//login
		driver.findElement(By.id("loginmobile")).sendKeys("8888416950");
		driver.findElement(By.id("loginbtn")).click();

		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.xpath("//a[text()='View Profile ']")).click();
		//String txt = driver.getCurrentUrl();
		//System.out.println(txt);

		String Expected="https://www.qa.jbktest.com/profile";  
		String Actual_Res = driver.getCurrentUrl();
		Assert.assertEquals(Expected,Actual_Res);

	}
	//*************************************************************************************//
	//profile Update Functionality /module (NAME)

	@Test(priority = 2)
	public void checkProfileUpdateNameTc_21 () { //to test that updating valid name  === Passed

		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		//login
		driver.findElement(By.id("loginmobile")).sendKeys("8888416950");
		driver.findElement(By.id("loginbtn")).click();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.xpath("//a[text()='View Profile ']")).click();
		driver.findElement(By.id("name")).clear();

		driver.findElement(By.id("name")).sendKeys("Jethalal Gada");    //Jethalal Gada
		driver.findElement(By.id("updatebtn")).click();

		String str = driver.findElement(By.xpath("//div[text()='Profile successfully updated']")).getText();
		System.out.println(str);

		String Expected="Profile successfully updated";  
		String Actual_Res = driver.findElement(By.xpath("//div[text()='Profile successfully updated']")).getText();
		Assert.assertEquals(Expected,Actual_Res);

	}

	@Test
	public void checkProfileUpdateNameTc_22 () { //to test that updating name that contain SPECIAL CHAR then
		//	error mesge should appear =====Failed --Bug

		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		//login
		driver.findElement(By.id("loginmobile")).sendKeys("8888416950");
		driver.findElement(By.id("loginbtn")).click();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.xpath("//a[text()='View Profile ']")).click();
		driver.findElement(By.id("name")).clear();

		driver.findElement(By.id("name")).sendKeys("jeth@lal G@d@$");    //jeth@lal G@d@$
		driver.findElement(By.id("updatebtn")).click();

		String str = driver.findElement(By.xpath("//div[text()='Profile successfully updated']")).getText();
		System.out.println(str);

		String Expected="Profile successfully updated";  
		String Actual_Res = driver.findElement(By.xpath("//div[text()='Profile successfully updated']")).getText();
		Assert.assertEquals(Expected,Actual_Res);

	}

	@Test
	public void checkProfileUpdateNameTc_23 () { //to test that updating name with entering NUMBER then 
		//error mesage should appear   === failed Bug
		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		//login
		driver.findElement(By.id("loginmobile")).sendKeys("8888416950");
		driver.findElement(By.id("loginbtn")).click();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.xpath("//a[text()='View Profile ']")).click();
		driver.findElement(By.id("name")).clear();

		driver.findElement(By.id("name")).sendKeys("1234 5678");    // 1234 5678
		driver.findElement(By.id("updatebtn")).click();

		String str = driver.findElement(By.xpath("//div[text()='Profile successfully updated']")).getText();
		System.out.println(str);

		String Expected="Profile successfully updated";  
		String Actual_Res = driver.findElement(By.xpath("//div[text()='Profile successfully updated']")).getText();
		Assert.assertEquals(Expected,Actual_Res);


	}

	@Test
	public void checkProfileUpdateNameTc_24 () { //to test that updating name with LONG NAME 30 + char then 
		//Error messga eshould Appear == Failed Bug
		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		//login
		driver.findElement(By.id("loginmobile")).sendKeys("8888416950"); 
		driver.findElement(By.id("loginbtn")).click();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.xpath("//a[text()='View Profile ']")).click();
		driver.findElement(By.id("name")).clear();

		driver.findElement(By.id("name")).sendKeys("PawanMankar_Pune_maharstra_India_ABCDEFGHIJKLMNOPQRSTUVWXYZ_jrthalalGada_Gokuldhamsociaty_goregaon_East");   
		// 
		driver.findElement(By.id("updatebtn")).click();

		String str = driver.findElement(By.xpath("//div[text()='Profile successfully updated']")).getText();
		System.out.println(str);

		String Expected="Profile successfully updated";  
		String Actual_Res = driver.findElement(By.xpath("//div[text()='Profile successfully updated']")).getText();
		Assert.assertEquals(Expected,Actual_Res);

	}

	//****************************************************************************//

	//(UPDATE EMAIL FUNCTIONALITY)

	@Test
	public void checkProfileUpdateEmailTc_25 () { //to test that updating email with other valid Email ==passed 

		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		//login
		driver.findElement(By.id("loginmobile")).sendKeys("8888416950"); 
		driver.findElement(By.id("loginbtn")).click();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.xpath("//a[text()='View Profile ']")).click();
		driver.findElement(By.id("emailid")).clear();

		driver.findElement(By.id("emailid")).sendKeys("pawanman7@gmail.com");  //valid gmail 

		driver.findElement(By.id("updatebtn")).click();

		String str = driver.findElement(By.xpath("//div[text()='Profile successfully updated']")).getText();
		System.out.println(str);

		String Expected="Profile successfully updated";  
		String Actual_Res = driver.findElement(By.xpath("//div[text()='Profile successfully updated']")).getText();
		Assert.assertEquals(Expected,Actual_Res);

	}

	@Test
	public void checkProfileUpdateEmailTc_26 () { //to test that updating Email With Invalid Email = bugs

		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		//login
		driver.findElement(By.id("loginmobile")).sendKeys("8888416950"); 
		driver.findElement(By.id("loginbtn")).click();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.xpath("//a[text()='View Profile ']")).click();
		driver.findElement(By.id("emailid")).clear();

		driver.findElement(By.id("emailid")).sendKeys("pm@gmails.con");  //pm@gmails.con = invalid gmails

		driver.findElement(By.id("updatebtn")).click();

		String str = driver.findElement(By.xpath("//div[text()='Profile successfully updated']")).getText();
		System.out.println(str);

		String Expected="Profile successfully updated";  
		String Actual_Res = driver.findElement(By.xpath("//div[text()='Profile successfully updated']")).getText();
		Assert.assertEquals(Expected,Actual_Res);

	}

	//**********************************************************************************************************//
	//(TO UPDATE MOBILE FUNCTIONALITY)

	@Test
	public void checkProfileUpdateMobileTc_27 () { //to test that updating mobile number with other valid mobile number
		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		//login
		driver.findElement(By.id("loginmobile")).sendKeys("8888416950"); 
		driver.findElement(By.id("loginbtn")).click();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.xpath("//a[text()='View Profile ']")).click();
		driver.findElement(By.id("mobile")).clear();

		driver.findElement(By.id("mobile")).sendKeys("9755634856");  //10 digit valid mob number

		driver.findElement(By.id("updatebtn")).click();

		String str = driver.findElement(By.xpath("//div[text()='Profile successfully updated']")).getText();
		System.out.println(str);

		String Expected="Profile successfully updated";  
		String Actual_Res = driver.findElement(By.xpath("//div[text()='Profile successfully updated']")).getText();
		Assert.assertEquals(Expected,Actual_Res);

	}

	@Test
	public void checkProfileUpdateNameTc_28 () { //to test that updating mobile number with 5 digits invalid mobile number then error meesg should appiear

		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		//login
		driver.findElement(By.id("loginmobile")).sendKeys("9755634856"); 
		driver.findElement(By.id("loginbtn")).click();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.xpath("//a[text()='View Profile ']")).click();
		driver.findElement(By.id("mobile")).clear();

		driver.findElement(By.id("mobile")).sendKeys("97556");  //5 digit invalid mob number

		driver.findElement(By.id("updatebtn")).click();

		String str = driver.findElement(By.xpath("//div[text()='Profile successfully updated']")).getText();
		System.out.println(str);

		String Expected="Profile successfully updated";  
		String Actual_Res = driver.findElement(By.xpath("//div[text()='Profile successfully updated']")).getText();
		Assert.assertEquals(Expected,Actual_Res);

	}

	@Test  					
	public void checkProfileUpdateNameTc_29 () { //to test that updating mobile number with (9 digits & one any char) invalid mobile number then error meesg should appiear

		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click(); //bug
		driver.findElement(By.id("countbtn")).click();
		//login
		driver.findElement(By.id("loginmobile")).sendKeys("9755634856"); 
		driver.findElement(By.id("loginbtn")).click();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.xpath("//a[text()='View Profile ']")).click();
		driver.findElement(By.id("mobile")).clear();

		driver.findElement(By.id("mobile")).sendKeys("975563485@");  //9 digit + 1 char invalid mob number (975563485@)

		driver.findElement(By.id("updatebtn")).click();

		String str = driver.findElement(By.xpath("//div[text()='Profile successfully updated']")).getText();
		System.out.println(str);

		String Expected="Profile successfully updated";  
		String Actual_Res = driver.findElement(By.xpath("//div[text()='Profile successfully updated']")).getText();
		Assert.assertEquals(Expected,Actual_Res);
		
		//NOTE : it willupdate wrong no but not able to logine by using this updated no

	}


	@Test
	public void checkProfileUpdateNameTc_30 () { //to test that updating mobile number with (15 digits) invalid mobile number then error message should appear

		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click(); //bug
		driver.findElement(By.id("countbtn")).click();
		//login
		driver.findElement(By.id("loginmobile")).sendKeys("8888416950"); 
		driver.findElement(By.id("loginbtn")).click();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.xpath("//a[text()='View Profile ']")).click();
		driver.findElement(By.id("mobile")).clear();

		driver.findElement(By.id("mobile")).sendKeys("888841695051525");  //15 digits invalid mob number (888841695051525)

		driver.findElement(By.id("updatebtn")).click();

		String str = driver.findElement(By.xpath("//div[text()='Profile successfully updated']")).getText();
		System.out.println(str);

		String Expected="Profile successfully updated";  
		String Actual_Res = driver.findElement(By.xpath("//div[text()='Profile successfully updated']")).getText();
		Assert.assertEquals(Expected,Actual_Res);

	}











}
