package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSuite3 {
	
 static WebDriver driver;
 static WebElement webElement;

	
 	public  void setBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alex\\Desktop\\Selenium\\ChromeDriver.exe");
		driver = new ChromeDriver();
	}
 	
	public  void loadPageThirdTestSuite() {
		
		driver.get("http://the-internet.herokuapp.com/key_presses");
	}

	public  void pressKeysTest() {

		driver.findElement(By.cssSelector("body")).sendKeys("u");

		webElement = driver.findElement(By.id("result"));

		String uKeypress = webElement.getText();

		String uColour = driver.findElement(By.xpath("//*[@id=\"result\"]")).getCssValue("color");

		driver.findElement(By.cssSelector("body")).sendKeys("p");

		webElement = driver.findElement(By.id("result"));

		String pColour = driver.findElement(By.xpath("//*[@id=\"result\"]")).getCssValue("color");

		String pKeypress = webElement.getText();

		driver.findElement(By.cssSelector("body")).sendKeys("l");

		webElement = driver.findElement(By.id("result"));

		String lKeypress = webElement.getText();

		String lColour = driver.findElement(By.xpath("//*[@id=\"result\"]")).getCssValue("color");

		String textColour;

		if (pColour.equals("rgba(0, 128, 0, 1)") & uColour.equals("rgba(0, 128, 0, 1)") & lColour.equals("rgba(0, 128, 0, 1)")  );

		{
			textColour = "The color of the text is green";
		}

		System.out.println(
				"Third Test Suite Results:\n" +
						uKeypress + ". " + textColour + 
						"\n" + pKeypress + ". " + textColour + 
						"\n" + lKeypress + ". " + textColour);

		driver.close();
	}

	public  void runThirdTestSuite() {

		setBrowser();
		loadPageThirdTestSuite();
		pressKeysTest();

	}
	
}
