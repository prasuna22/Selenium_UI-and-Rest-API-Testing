/**
 * @author Sai Prasuna
 */
package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckoutPage {
	
	
	@FindBy(xpath="//*[@id='subtotals-marketplace-table']/tbody/tr[1]/td[2]")
	WebElement checkout_price;
	
	public CheckoutPage(WebDriver driver) {
	PageFactory.initElements(driver, this);	
	}
	
	//Price from checkout page
	public String getCheckoutPrice() {
		return this.checkout_price.getText();
	}

}
