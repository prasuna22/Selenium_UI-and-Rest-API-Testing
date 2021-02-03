/**
 * @author Sai Prasuna
 */

package testscripts;
import org.testng.annotations.Test;

import pagefactory.CheckoutPage;
import pagefactory.Homepage;
import pagefactory.ItemCheckoutView;
import pagefactory.Itempage;
import pagefactory.Loginpage;
import pagefactory.Paymentpage;
import pagefactory.Resultspage;
import pagefactory.ShippingAddress;
import pagefactory.Shippingpage;
import utility.PropertyFileRead;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class PricingTestScript {
	WebDriver driver;
	Homepage homepage;
	Resultspage resultspage;
	Itempage itempage;
	ItemCheckoutView checkoutview;
	Loginpage loginpage;
	ShippingAddress shippingaddress;
	Shippingpage shippingpage;
	Paymentpage paymentpage;
	CheckoutPage checkoutpage;
	String search_str = null;
	PropertyFileRead propertyfileread;
	
  @Test
  public void pricingCompare(){         
	 
	  //Initialize all the pages from page factory 
	  homepage = new Homepage(driver);
	  resultspage = new Resultspage(driver);
	  itempage = new Itempage(driver);
	  checkoutview = new ItemCheckoutView(driver);
	  checkoutpage = new CheckoutPage(driver);
	  loginpage = new Loginpage(driver);
	  shippingaddress = new ShippingAddress(driver);
	  shippingpage = new Shippingpage(driver);
	  paymentpage = new Paymentpage(driver);
		  	  
	  //Search for qa for testing book 
	  homepage.searchItem(search_str);
	  homepage.search();
	  
	  //Get price of the first item in the results page
	  String rpage_price = resultspage.getItemPrice();
	  
	  //Item price in results page -> Step 3 price
	  String final_rprice = rpage_price.replaceAll("\\s+","");  
	  
	  //Go to Item page and get price of first item
	  resultspage.clickFirstItemofResults();
	  String item_price = itempage.getItemPrice();
	  String final_iprice = item_price.replace(".", "");
	  //Compare item price with price from step 3
	  Assert.assertEquals(final_rprice, final_iprice);
	  
	  //Click on add to cart on item page
	  itempage.addToCart();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  String price_chkout_view = checkoutview.get_item_price();
	  	  
	  //Compare price in check out view with price in results page
	  String final_cvprice = price_chkout_view.replace(".", "");
	  
	  //Compare price before checkout and price from step 3
	  Assert.assertEquals(final_rprice, final_cvprice);
	  
	  //Click on proceed to checkout
	  checkoutview.clickonProceedtoCheckout();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  //Choose Delivery address
	  shippingaddress.clickOnDelivertoAddr();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  //Choose shipping option and click on continue
	  shippingpage.chooseRadiobutton();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  Actions action = new Actions(driver);
	  action.moveToElement(shippingpage.getContinueelement()).click().build().perform();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  //Choose a payment option and click on continue
	  action.moveToElement(paymentpage.getPaymRadiobutton()).click().build().perform();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  paymentpage.clickOnContinue();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  //Get price from the check out page
	  String checkoutprice = checkoutpage.getCheckoutPrice();
	  String final_cp_price = checkoutprice.replaceAll("\\s+", "");
	  String final_price = price_chkout_view.replace(".", "");
	  	  
	  //Compare price in the checkout page and price from step 3
	  Assert.assertEquals(final_rprice, final_price);  
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  //Initialize webdriver and set system property
	  propertyfileread = new PropertyFileRead();
	  String chromeDriverPath = propertyfileread.getProperties("chromedriverpath");
	  System.setProperty("webdriver.chrome.driver", chromeDriverPath);
	  driver = new ChromeDriver();
	  search_str = propertyfileread.getProperties("amazon_search_string");
	  
	//Goto amazon.com page
	  driver.get(propertyfileread.getProperties("amazonurl"));
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	  
	  //Login setup
	  loginpage = new Loginpage(driver);
	  loginpage.clickOnHelloSignin();
	  loginpage.enterUsername(propertyfileread.getProperties("username"));
	  loginpage.clickOnContinue();
	  loginpage.enterPassword(propertyfileread.getProperties("password"));
	  loginpage.clickonsignin();
  }

  @AfterMethod
  public void afterMethod() {
	  //close the browser windows
	 driver.quit();
  }

}
