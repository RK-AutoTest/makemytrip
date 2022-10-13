package co.makemytrip.testsenarios;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Testbase {

static WebDriver driver=null;

    // method to initialize browser driver;
	@BeforeTest
	public void initialize() throws IOException {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver\\chromedriver.exe");
		 driver = new ChromeDriver();
			driver.get("https://www.makemytrip.com/");
			 driver.manage().window().maximize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	// method to quit browser
	
	@AfterTest
	public void teardown() throws InterruptedException {
		try {
			Thread.sleep(3000);
			
			driver.manage().deleteAllCookies();
			driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

