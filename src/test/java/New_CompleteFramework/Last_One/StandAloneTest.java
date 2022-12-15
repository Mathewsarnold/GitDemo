package New_CompleteFramework.Last_One;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		LandingPage landing=new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("mathew@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Pass@123");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3")); 
		
		WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-containe")));
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
		
		 Boolean match=
		cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase("ZARA COAT 3"));
		
		 
		 Assert.assertTrue(match);
		 
		 driver.findElement(By.cssSelector(".totalRow .btn-primary")).click();
		
		 Actions a = new Actions(driver);
			a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
			
			driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;

	         // Launch the desired application


	        //  Scroll down to the desired location

	             js.executeScript("window.scrollBy(0,1000)");
			driver.findElement(By.cssSelector(".action__submit ")).click();
			
			String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
			Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
			//driver.close();	

	}

}
 