/**
 * @author Sai Prasuna
 */
package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Itempage {
	//Price of item on item page
	@FindBy(css="span[id='newBuyBoxPrice']")
	WebElement itemPrice;
	
	//Add to cart button 
	@FindBy(id="add-to-cart-button")
	WebElement addtocartbutton;
	
	public Itempage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Add item to the cart
	public void addToCart() {
		this.addtocartbutton.click();
	}
	
	//Get price from item page
	public String getItemPrice() {
		return this.itemPrice.getText();
	}

}
