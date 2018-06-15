package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestSuite2 {
	
	static WebDriver driver;
	 static WebElement webElement;
		
	 	public static  void setBrowser() {

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alex\\Desktop\\Selenium\\ChromeDriver.exe");
			driver = new ChromeDriver();
		}
	
public static void loadPageSecondTestSuite() {
		
		driver.get("http://the-internet.herokuapp.com/infinite_scroll");
		driver.manage().window().maximize();
	}

	public static void scrollDownUsingENDKey() {

		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
	}

	public static void scrollToTopandConfirmh3Content() {

		driver.findElement(By.id("content"));
		String infiniteScrollHeader = driver.findElement(By.tagName("h3")).getText(); 
		System.out.println("Second Test Suite Results:");
		if (!"Infinite Scroll".equals(infiniteScrollHeader))


			System.out.println("The header Infinite Scroll is not present"); 
		else 
			System.out.println("The header Infinite Scroll is present");

		driver.close();
	}

	public void runSecondTestSuite() {
		
		setBrowser();
		loadPageSecondTestSuite();
		scrollDownUsingENDKey();
		scrollToTopandConfirmh3Content();
	}

}
