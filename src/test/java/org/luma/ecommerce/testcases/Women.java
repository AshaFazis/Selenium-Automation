package org.luma.ecommerce.testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Women {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		String colour = "Red";
		String teename = "Iris Workout Top";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/what-is-new.html");
		driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
		driver.findElement(By.id("email")).sendKeys("ashafj11@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Ashafj11!");
		driver.findElement(By.xpath("//button[@class='action login primary']/span[text()='Sign In']")).click();
		
		Actions action = new Actions(driver);
		
		WebElement womenSection = driver.findElement(By.xpath("//span[text()='Women']"));
		action.moveToElement(womenSection).build().perform();
		
		WebElement womenTops = driver.findElement(By.xpath("//a[@id='ui-id-9']//span[text()='Tops']"));
		action.moveToElement(womenTops).build().perform();
		
		WebElement womenTees = driver.findElement(By.xpath("//a[@id='ui-id-13']//span[text()='Tees']"));
		action.moveToElement(womenTees).click().perform();
		
		WebElement size = driver.findElement(By.xpath("//div[@class='filter-options']/div[@class='filter-options-item']/div[text()='Size']"));
		action.moveToElement(size).click().perform();
	
	    size.findElement(By.xpath("//div//div[@class='swatch-attribute-options clearfix']//a[@class='swatch-option-link-layered']/div[text()='M']")).click();
	    
	    
	    WebElement color = driver.findElement(By.xpath("//div[@class='filter-options']/div[@class='filter-options-item']/div[text()='Color']"));
	    action.moveToElement(color).click().perform();
	    
	    color.findElement(By.xpath("//div//div[@class='swatch-attribute-options clearfix']//a[@class='swatch-option-link-layered']/div[@option-label='"+colour+"']")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ol[@class='products list items product-items']")));
	    
	    List<WebElement> teesList = driver.findElements(By.xpath("//ol[@class='products list items product-items']/li"));
	    System.out.println(teesList.size());
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ol[@class='products list items product-items']")));
	    List<WebElement> teesName = driver.findElements(By.xpath("//div[@class='product-item-info']/div[@class='product details product-item-details']/strong/a"));
	    
	    for(WebElement tee : teesName)
	    {
	       String teeNames = tee.getText();
	       System.out.println(teeNames);
	       if(teeNames.contains(teename))
	       {
	    	   
	    	   js.executeScript("window.scrollBy(0,1200)"); 
				 
				  
	    	   WebElement item =driver.findElement(By.xpath("//div[@class='product-item-info']/div[@class='product details product-item-details']/strong/a[normalize-space()='"+teename+"']"));
			   action.moveToElement(item).build().perform();
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-item-info']/div[@class='product details product-item-details']/strong/a[normalize-space()='"+teename+"']")));
			    
			   WebElement addToCart = driver.findElement(By.xpath("//div[@class='product-item-info']/div[@class='product details product-item-details']/strong/a[normalize-space()='"+teename+"']/following::div[@class='actions-primary']/form[@data-role='tocart-form']/button/span"));
			   action.moveToElement(addToCart).build().perform();
			   
			   addToCart.click();
			  
			      
	            
	       }
	    }
	    js.executeScript("window.scrollBy(0,-1200)", "");
	 System.out.println(driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText());
	 Assert.assertEquals(driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText(), "You added "+teename+ " to your shopping cart.");
	 
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='header content']/div[@class='minicart-wrapper']")));
	 WebElement cartIcon = driver.findElement(By.xpath("//div[@class='header content']/div[@class='minicart-wrapper']"));
     action.moveToElement(cartIcon).click().build().perform();
     
     driver.findElement(By.className("cart-item-qty")).sendKeys(Keys.BACK_SPACE);
     driver.findElement(By.className("cart-item-qty")).sendKeys("2");
     driver.findElement(By.xpath("//span[text()='Update']")).click();
     
     WebElement viewAndEditCart = driver.findElement(By.xpath("//a[@class='action viewcart']"));
     action.moveToElement(viewAndEditCart).click().build().perform();
    
     WebElement editCart = driver.findElement(By.xpath("//div[@class='actions-toolbar']//a[@class='action action-edit']"));
     action.moveToElement(editCart).click().build().perform();
     
	 driver.findElement(By.xpath("//div[@class='swatch-attribute-options clearfix']/div[text()='S']")).click();
	    
	 driver.findElement(By.id("qty")).sendKeys(Keys.BACK_SPACE);
	 driver.findElement(By.id("qty")).sendKeys("3");
	 
	 driver.findElement(By.xpath("//button[@type='submit']/span[text()='Update Cart']")).click();
	 
	 System.out.println(driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText());
	//Assert.assertEquals(driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText(), "" +teename+ " was updated in your shopping cart.");
	
	driver.findElement(By.xpath("//span[normalize-space()='Update Shopping Cart']")).click();
    Thread.sleep(5000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Loading...']")));
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cart-summary']")));
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cart-summary']//ul[@class='checkout methods items checkout-methods-items']/li/button/span")));
	WebElement checkOut = driver.findElement(By.xpath("//div[@class='cart-summary']//ul[@class='checkout methods items checkout-methods-items']/li/button/span"));
    action.moveToElement(checkOut).click().build().perform();
	
    //Thread.sleep(5000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Loading...']")));
	/*
	 * driver.findElement(By.xpath(
	 * "//div[@class='control']/input[@name='street[0]']")).
	 * sendKeys("19 Cary street");
	 * driver.findElement(By.xpath("//div[@class='control']/input[@name='city']")).
	 * sendKeys("Missippi");
	 * 
	 * WebElement citydropDown = driver.findElement(By.className("select")); Select
	 * select = new Select(citydropDown); select.selectByVisibleText("Oklahoma");
	 * 
	 * driver.findElement(By.xpath("//div[@class='control']/input[@name='postcode']"
	 * )).sendKeys("123456"); driver.findElement(By.
	 * xpath("//div[@class='control _with-tooltip']/input[@name='telephone']")).
	 * sendKeys("0000000000000000");
	 */
    driver.findElement(By.xpath("//table[@class='table-checkout-shipping-method']//input[@name='ko_unique_1']")).click();
    
    
    WebElement nextButton = driver.findElement(By.xpath("//div[@class='primary']/button/span[text()='Next']"));
    action.moveToElement(nextButton).click().build().perform();
    Thread.sleep(5000);
    WebElement placeOrderButton = driver.findElement(By.xpath("//div[@class='primary']/button[@class='action primary checkout']/span[text()='Place Order']"));
    action.moveToElement(placeOrderButton).click().build().perform();
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Loading...']")));
    System.out.println(driver.findElement(By.xpath("//span[@class='base']")).getText());
	
	}
}
