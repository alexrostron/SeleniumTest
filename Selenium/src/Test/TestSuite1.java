package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSuite1 {
	static WebDriver driver;
	static WebElement webElement;

	public static void setBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alex\\Desktop\\Selenium\\ChromeDriver.exe");
		driver = new ChromeDriver();
	}

	public static void loadPageFirstTestSuite() {

		driver.get("http://the-internet.herokuapp.com/login");
	}

	public static void loginWithCorrectUsernameandIncorrectPassword() {

		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("WrongPassword");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		webElement = driver.findElement(By.xpath("//div[contains(.,'password is invalid')]"));

		if (webElement.isDisplayed() ) 
		{
			System.out.println("loginWithCorrectUsernameandIncorrectPassword Test Pass - Invalid password validated");
		} 
		
		else System.out.println("loginWithCorrectUsernameandIncorrectPassword Fail - Login Failed");

		driver.close();
	}

	public static void loginWithIncorrectUsernameandCorrectPassword() {

		driver.findElement(By.id("username")).sendKeys("IncorrectUsername");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		webElement = driver.findElement(By.xpath("//div[contains(.,'username is invalid')]"));

		if(webElement.isDisplayed() ) {
			System.out.println("loginWithIncorrectUsernameandCorrectPassword Test Pass - Invalid username validated");
		} else    
			System.out.println("loginWithIncorrectUsernameandCorrectPassword Test Fail - Invalid username not validated");

		driver.close();
	}

	public static void LoginWithCorrectUsernameandPasswordandLogout() {

		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.cssSelector("a[href*='/logout']")).click();
		webElement = driver.findElement(By.xpath("//div[contains(.,'You logged out of the secure area!')]"));

		if(webElement.isDisplayed() ) {
			System.out.println("LoginWithCorrectUsernameandPasswordandLogout Test Pass - Login and Logout Succesful");
		} else    
			System.out.println("LoginWithCorrectUsernameandPasswordandLogout Test Fail - Login and Logout Fail");

		driver.close();
	}

	public void runFirstTestSuite() {

		setBrowser();
		loadPageFirstTestSuite();
		loginWithCorrectUsernameandIncorrectPassword();

		setBrowser();
		loadPageFirstTestSuite();
		loginWithIncorrectUsernameandCorrectPassword();

		setBrowser();
		loadPageFirstTestSuite();
		LoginWithCorrectUsernameandPasswordandLogout();
	}

}
