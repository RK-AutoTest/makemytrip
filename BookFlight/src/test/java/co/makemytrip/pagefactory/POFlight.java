package co.makemytrip.pagefactory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class POFlight {
	WebDriver driver;

	public POFlight(WebDriver driver) {
		this.driver = driver;
	}

	// options/check box/closing pop up ads
	@FindBy(how = How.XPATH, using = "//a[@class='close']")
	WebElement adclose;
	@FindBy(how = How.XPATH, using = "//span[@class='langCardClose']")
	WebElement adclose2;
	@FindBy(how = How.XPATH, using = "//li[@data-cy='roundTrip']")
	WebElement roundtrip;
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'fsw')]//li[3]")
	WebElement studentfair;

	// Departure/input field/drop down.
	@FindBy(how = How.XPATH, using = "//label[@for='fromCity']")
	WebElement fromcity;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='From']")
	WebElement inputfrom;
	@FindBy(how = How.XPATH, using = "//div[@class='react-autosuggest__section-container react-autosuggest__section-container--first']//li[1]")
	List<WebElement> fromcitylist; // List

	// Arrival/ input field/ drop down.
	@FindBy(how = How.XPATH, using = "//label[@for='toCity']")
	WebElement tocity;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='To']")
	WebElement inputtocity;
	@FindBy(how = How.XPATH, using = "//div[@class='react-autosuggest__section-container react-autosuggest__section-container--first']//li[1]")
	List<WebElement> tocitylist; // List
	// @FindBy(how=How.,using="")WebElement ;

	// method to pass parameters in input field and select.
	public void FromTO(String fcity, String tcity) {
		
		try {
			Thread.sleep(3000);
		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
			adclose.click();
			driver.switchTo().defaultContent();
			
			
			roundtrip.click();
			studentfair.click();
			fromcity.click();
			inputfrom.sendKeys(fcity);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			for (WebElement li : fromcitylist) {
				Thread.sleep(1000);
				String str = li.getText();
				System.out.println("  LOOP 1 \n" );
				String[] str1 = str.split("\\n");

				for (String al : str1) {
					
					System.out.println("  "+al );
					if (al.equalsIgnoreCase(fcity)) {

					li.click();
						
						System.out.println(" milla " + al);

					}
					
				}

			}
			adclose2.click();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", tocity);
			
			inputtocity.sendKeys(tcity);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			for (WebElement li : tocitylist) {
				//Thread.sleep(2000);
				String str = li.getText();
			System.out.println("  LOOP  2 \n" );
				String[] str4 = str.split("\\n");

				for (String al : str4) {
					System.out.println("  splited  " + al);
				
					if (al.equalsIgnoreCase(tcity)) {

						li.click();
						System.out.println(" milla " + al );
						break;
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("the error is " + e);
		}
	}
}
