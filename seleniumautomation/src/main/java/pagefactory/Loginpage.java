/**
 * @author Sai Prasuna
 */
package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	//Sign in 
	@FindBy(xpath="//*[@id='nav-link-accountList-nav-line-1']")
	WebElement signin_link;
	
	//Username
	@FindBy(id="ap_email")
	WebElement username;
	
	//Continue button
	@FindBy(id="continue")
	WebElement continue_button;
	
	//password
	@FindBy(id="ap_password")
	WebElement password;
	
	//signin button
	@FindBy(id="signInSubmit")
	WebElement signin_button;
	
	public Loginpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Click on Hello, Sign in link
	public void clickOnHelloSignin() {
		this.signin_link.click();
	}
	
	//Give username
	public void enterUsername(String uname) {
		this.username.sendKeys(uname);
	}
	
	//Give password
	public void enterPassword(String pass) {
		this.password.sendKeys(pass);
	}
	
	//Click on Continue
	public void clickOnContinue() {
		this.continue_button.click();
	}
	
	//Click on Signin button
	public void clickonsignin() {
		this.signin_button.click();
	}
	


}
