/**
 * @author Sai Prasuna
 */

package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemCheckoutView {
	//Price of item in the checkout view page
	//@FindBy(xpath="(//span[contains(@class,'a-color-price')])[2]")
	@FindBy(xpath="//*[@id=\"hlb-subcart\"]/div[1]/span/span[2]")
	WebElement checkOutViewprice;
	
	//proceed to checkout button
	@FindBy(css="#hlb-ptc-btn-native")
	WebElement proceedTocheckout;
	
	public ItemCheckoutView(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Get item price from checkout view page
	public String get_item_price() {
		return checkOutViewprice.getText();
	}
	
	//Click on proceed to checkout
   public void clickonProceedtoCheckout() {
	   this.proceedTocheckout.click();
   }
}
