/**
 * @author Sai Prasuna
 */
package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shippingpage {
	
	
	//Radio button for shipping
	@FindBy(css="input[value='sss-us-4']")
	WebElement shippingOption;
	
	//Click on continue button
	@FindBy(css="input[value='Continue']")
	WebElement continueButton;
	
	public Shippingpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Choose first address
	public void chooseRadiobutton() {
		this.shippingOption.click();
	}

	//Click on Continue button
	public void clickOnContinue() {
		this.continueButton.click();
	}
	
	public WebElement getContinueelement() {
		return this.continueButton;
	}
	
}
