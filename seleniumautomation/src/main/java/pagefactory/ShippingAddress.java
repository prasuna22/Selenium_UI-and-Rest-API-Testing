/**
 * @author Sai Prasuna
 */

package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingAddress {
	
	//Choose first address
		@FindBy(xpath="(//span[@class='a-button-inner'])[1]")
		WebElement deliveryButton;
		
 public ShippingAddress(WebDriver driver) {
	 PageFactory.initElements(driver, this);
 }
 
 //Click on the delivery button for first address
  public void clickOnDelivertoAddr() {
	  deliveryButton.click();
  }

}
