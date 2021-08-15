package Message.sendtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class yahoo extends DriverSetup{

	public static String URL= "https://www.yahoo.com/";
	public static  String email= "tonbegum@yahoo.com";
	public static  String pass= "112233&299";
	public static String expectedUser="ton";
	public static String To = "popyalam11@gmail.com";
	public static String Subject = " Hello ";
	public static String Body = " Hello World";
	public static String actualText;
	public static String expectedText="Hello World";
	public static WebElement element;
	
	
	
	
	
	
	@BeforeTest
	public static void login() throws InterruptedException {
	
		//code for navigating to the URL & maximizing browser
		driver.get(URL);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);;
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//a[@href='https://login.yahoo.com/?.lang=en-US&src=homepage&.done=https%3A%2F%2Fwww.yahoo.com%2F&pspid=2023538075&activity=ybar-signin']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys(email);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='login-signin']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='login-passwd']")).sendKeys(pass);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@value='Next']")).click();
		Thread.sleep(1000);
		
	  
	
	}
	
	
	@Test
	public static void yahoologinValidation() throws InterruptedException{
		
		
		element = driver.findElement(By.xpath("//span[@role='presentation']"));
		Thread.sleep(1000);
		String actualUIUser = element.getText();
		System.out.println("Actual user in UI = " + actualUIUser);
		
		// code for validation using if else condition
		if(actualUIUser.equals(expectedUser)) {
			AssertJUnit.assertTrue(true);
			System.out.println("Application user = " +actualUIUser+ "matches with the given expected user = " + expectedUser);
		}else {
			System.out.println("Application user = " +actualUIUser+ " do not match with the given expected user = " + expectedUser);
			AssertJUnit.fail();

	}
		
	
	}
	
	
	@Test
	public static void MessageSent() throws InterruptedException{
		
		

		
		
		driver.findElement(By.xpath("//a[@id='ybarMailLink']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[@href='/d/compose/']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='message-to-field']")).sendKeys(To);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@data-test-id='compose-subject']")).sendKeys(Subject);
		Thread.sleep(1000);
		
		
		driver.findElement(By.xpath("//div[@aria-label='Message body']")).sendKeys(Body);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@data-test-id='compose-send-button']")).click();
		Thread.sleep(1000);
	}
	
	
	@Test
	public static void MessageValidation() throws InterruptedException{
		
		driver.findElement(By.xpath("//a[@href='/d/folders/2']")).click();
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//a[@aria-label=\"popyalam11@gmail.com's email\"]")).click();
		Thread.sleep(3000);
		actualText = driver.findElement(By.xpath(
				"//div[@data-test-id='message-body-container']"))
				.getText();

		if (actualText.equals(expectedText)) {
			System.out.println("Successfully send message");
			AssertJUnit.assertTrue(true);
		} else {
			System.out.println("There will be problem.Try another way");
			AssertJUnit.assertTrue(false);
		}
		
	
	}
	
	
}
