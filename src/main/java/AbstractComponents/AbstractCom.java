package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import New_CompleteFramework.Last_One.CartPage;

public class AbstractCom {
    WebDriver driver;
	public AbstractCom(WebDriver driver)
	{
    this.driver=driver;
	PageFactory.initElements(driver, this);

	}

	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	
	
	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	
	public void waitForElementToDisappear(WebElement ele)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));

	}
	
	public CartPage goToCartPage()
	{
		cartHeader.click();
		CartPage cart=new CartPage(driver);
        return cart;
	}
	
	
	
	
	
	
	
	
	
}
