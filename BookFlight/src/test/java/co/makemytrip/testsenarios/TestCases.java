package co.makemytrip.testsenarios;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import co.makemytrip.pagefactory.POFlight;



public class TestCases extends Testbase{

	@Test
	public void Allcalls() {
	
		try {
			POFlight pg= PageFactory.initElements(driver, POFlight.class);
			pg.FromTO("Goa, India", "Mumbai India");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
