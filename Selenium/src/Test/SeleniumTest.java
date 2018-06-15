package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class SeleniumTest {

	static WebDriver driver;
	static WebElement webElement;

	public static void main(String[] args) 
	
	{
		TestSuite1 testSuite1 = new TestSuite1();
		testSuite1.runFirstTestSuite();
		
		TestSuite2 testSuite2 = new TestSuite2();
		testSuite2.runSecondTestSuite();
		
		TestSuite3 testCase3 = new TestSuite3();
		testCase3.runThirdTestSuite();
	}

}