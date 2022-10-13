package co.makemytrip.pagefactory;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;




public class POFlight {
	WebDriver driver ;
 public POFlight(WebDriver driver) {
	 this.driver=driver;
	 }
	
	// options/check box.
	@FindBy(how = How.XPATH, using = "//li[@data-cy='roundTrip']")
	WebElement roundtrip;
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'fsw')]//li[3]")
	WebElement studentfair;

	// Departure/input field/drop down.
	@FindBy(how = How.XPATH, using = "//label[@for='fromCity']")
	WebElement fromcity;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='From']")
	WebElement inputfrom;
	@FindBy(how = How.CSS, using = "#react-autowhatever-1")
	List<WebElement> fromcitylist; // List

	// Arrival/ input field/ drop down.
	@FindBy(how = How.XPATH, using = "//label[@for='toCity']")
	WebElement tocity;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='To']")
	WebElement inputtocity;
	@FindBy(how = How.CSS, using = "#react-autowhatever-1")
	List<WebElement> tocitylist; // List
	// @FindBy(how=How.,using="")WebElement ;
	
	// method to pass parameters in input field and select.
	public void FromTO(String fcity, String tcity) {
			try {
			
			roundtrip.click();
			studentfair.click();

			fromcity.click();
			inputfrom.sendKeys(fcity);
			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			for (WebElement li : fromcitylist) {
				Thread.sleep(2000);
				String str = li.getText();
				System.out.println("  LOOP 1 "+str);
				if (str.equals(fcity)) {
					li.click();
					break;
				}
			}
			
			tocity.click();
			inputtocity.sendKeys(tcity);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
			for (WebElement li : tocitylist) {
				Thread.sleep(2000);
				String str = li.getText();
				System.out.println("  LOOP  2 "+str);
				if (str.equals(tcity)) {
					li.click();
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
		System.out.println("the error is "+e);
		}
	}
}
