package New_CompleteFramework.Last_One;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractComponents.AbstractCom;

public class ProductCategory extends AbstractCom{

	WebDriver driver;
	
	public ProductCategory(WebDriver driver)
	{
		super(driver);
		//Initialization

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
//	List<WebElement> products=driver.findElements(By.cssSelector(".mb-3")); 

	//PageFactory
	@FindBy(css=".mb-3")
	List<WebElement> products; 
	
	@FindBy(css="(\".ng-animating\")")
	WebElement spinner;
	
	//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
   
	By productsBy=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement prod=getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        return prod;
		
	}
	
	
	public void addProductToCart(String productName)
	{
		WebElement prod=getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToDisappear(spinner);
		//	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
