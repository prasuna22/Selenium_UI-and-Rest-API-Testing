/**
 * @author Sai Prasuna
 */
package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Paymentpage {
	//payment option radio button
	@FindBy(xpath="(//input[@type='radio'])[1]")
	WebElement payradiobutton;
	
	@FindBy(xpath="(//input[contains(@class,'a-button-input')])[2]")
	WebElement coninueButton;
	
	public Paymentpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Choose first payment option
	public void choosePaymOption() {
		this.payradiobutton.click();
	}
	
	//Click on continue button
	public void clickOnContinue() {
		this.coninueButton.click();
	}
	
	public WebElement getPaymRadiobutton() {
		return this.payradiobutton;
	}

}
