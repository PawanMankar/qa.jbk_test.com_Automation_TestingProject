package AutomationsTC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupTC {        //POP-UP Functionality 
	WebDriver driver;
	@BeforeMethod
	public void beforemethod() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void aftermethod () {
		driver.close();
	}

	@Test
	public void check_SendMe_StuddyStuff_PopUpTc_31() { //enter valid email in popup succesfully email should send 
		//iframe Acccess 3 ways bealow
		//driver.switchTo().frame(1); //by index where index always start form 0 1 ....
		//driver.switchTo().frame("webform"); // name or id both are ok
		WebElement iframeElement = driver.findElement(By.xpath("/html/body/div[3]/iframe")); // (//div[@id='grwf2_S4ibL_y0v2l'])[1]/iframe)
		driver.switchTo().frame(iframeElement);

		//enter email
		driver.findElement(By.xpath("/html/body/div/div/form/div/div[4]/div/div[2]/div[1]/div/input")).sendKeys("pawanmankar69@gmail.com");

		//click on button
		driver.findElement(By.xpath("//button/span[text()='SEND ME STUDY STUFF!']")).click();

		driver.switchTo().defaultContent();

	}

	@Test
	public void check_SendMe_StuddyStuff_PopUpTc_32() { //enter Same email in popup error message should appear
		//iframe Acccess 3 ways bealow
		//driver.switchTo().frame(1); //by index where index always start form 0 1 ....
		//driver.switchTo().frame("webform"); // name or id both are ok
		WebElement iframeElement = driver.findElement(By.xpath("/html/body/div[3]/iframe")); // (//div[@id='grwf2_S4ibL_y0v2l'])[1]/iframe)
		driver.switchTo().frame(iframeElement);

		//enter email
		driver.findElement(By.xpath("/html/body/div/div/form/div/div[4]/div/div[2]/div[1]/div/input")).sendKeys("pawanmankar69@gmail.com");

		//click on button
		driver.findElement(By.xpath("//button/span[text()='SEND ME STUDY STUFF!']")).click();

		String Exprct_res = "You are already subscribed!";
		String Actut_res = driver.findElement(By.xpath("//div/p[text()='You are already subscribed!']")).getText();
		Assert.assertEquals(Exprct_res, Actut_res);
		//we only automate this
		driver.switchTo().defaultContent();

	}


	@Test
	public void check_SendMe_StuddyStuff_PopUpTc_33() { //close the popup
		//iframe Acccess 3 ways bealow
		//driver.switchTo().frame(1); //by index where index always start form 0 1 ....
		//driver.switchTo().frame("webform"); // name or id both are ok

		WebElement iframeElement = driver.findElement(By.xpath("/html/body/div[3]/iframe")); // (//div[@id='grwf2_S4ibL_y0v2l'])[1]/iframe)
		driver.switchTo().frame(iframeElement);
		driver.findElement(By.xpath("//div[@id='webform_preview']/div")).click(); // click on close x

		driver.switchTo().defaultContent();


	}
}
