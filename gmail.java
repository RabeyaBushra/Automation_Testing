package Message.sendtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class gmail extends DriverSetup {
	
	
	public static String URL= "http://www.gmail.com";
	public static  String email= "popyalam11@gmail.com";
	public static  String pass= "Accpopy123";
	public static String expectedUser="popyalam11@gmail.com";
	public static WebElement element;
	
	@BeforeTest
	public static void login() throws InterruptedException {
	
		//code for navigating to the URL & maximizing browser
		driver.get(URL);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);;
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='passwordNext']")).click();
		Thread.sleep(1000);
		
	  
	
	}
	@Test
	public static void loginValidation() throws InterruptedException{
		
		
		
		driver.findElement(By.xpath("//a[contains(@class,'gb_D gb_Na gb_i')]")).click();
		
		
		
		element = driver.findElement(By.xpath("//div[contains(@class,'gb_ob')]"));
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
	
	

}
	
	
