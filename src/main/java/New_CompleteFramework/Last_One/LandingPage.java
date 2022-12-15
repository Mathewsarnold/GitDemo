package New_CompleteFramework.Last_One;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractCom;

public class LandingPage extends AbstractCom {

	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		//Initialization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//		driver.findElement(By.id("userEmail")).sendKeys("mathew@gmail.com");  
	// Normal type -> WebElement email=driver.findElement(By.id("userEmail"));
	//driver.findElement(By.id("userPassword")).sendKeys("Pass@123");
	//		driver.findElement(By.id("login")).click();

	
	//PageFactory
	@FindBy(id="userEmail")
	WebElement username; 
	
	@FindBy(id="userPassword")
	WebElement passwordele;
	
	@FindBy(id="login")
	WebElement submit;
	
	public ProductCategory logniPage(String email, String pwd)
	{
		
		username.sendKeys(email);
		passwordele.sendKeys(pwd);
		submit.click();
		ProductCategory productLog=new ProductCategory(driver);
        return productLog;
	}
	
	public void goTo()
	{
		
		driver.get("https://rahulshettyacademy.com/client");

	}
	 
	
}
