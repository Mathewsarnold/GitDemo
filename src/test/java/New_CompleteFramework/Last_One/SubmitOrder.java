package New_CompleteFramework.Last_One;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrder {

	public static void main(String[] args) {
        String productName="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		LandingPage landing=new LandingPage(driver);
		landing.goTo();
		ProductCategory productLog=landing.logniPage("mathew@gmail.com","Pass@123");
		
		List<WebElement> products=productLog.getProductList();
		productLog.addProductToCart(productName);
		CartPage cart=productLog.goToCartPage();
		Boolean match=cart.VerifyProductDisplay(productName);
	
		Assert.assertTrue(match);
		CheckoutPage checkout=cart.goToCheckout();
		checkout.selectCountry("India"); 
		ConfirmationPage confirm=checkout.submitOrder();
		
	    String confirmMessage = confirm.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();	

	}

}
 