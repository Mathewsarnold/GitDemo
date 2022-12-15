package New_CompleteFramework.Last_One;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractCom;

public class CartPage extends AbstractCom {

	WebDriver driver;
	@FindBy(css=".totalRow .btn-primary")
	WebElement checkoutele;
	
	@FindBy(css=".cartSection h3")
	private List<WebElement> cartProducts;
	public CartPage(WebDriver driver)
	{
		//Initialization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean VerifyProductDisplay(String productName)
	{
		 Boolean match=
					cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase("productName"));
		return null;
		
		
	}

	public CheckoutPage goToCheckout()
	{
		checkoutele.click();
		return new CheckoutPage(driver);
	}
	
	
}
