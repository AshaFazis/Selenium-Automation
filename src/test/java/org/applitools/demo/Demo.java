package org.applitools.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		Eyes eyes = new Eyes();
		eyes.setApiKey("0LXBzPxfLgA77yCtEjNEiPw8eh85Wkr98xhp7h2105gTho110");
		
		try
		{
			eyes.open(driver, "Hello World!", "My first Selenium Java test!", new RectangleSize(800,600));
			
			driver.get("https://applitools.com/helloworld/?diff2");
			
			eyes.checkWindow("Hello!");
			
			driver.findElement(By.tagName("button")).click();
			
			eyes.checkWindow("Click!");
			
			eyes.close();
		}
		
		finally
		{
			driver.close();
		}

	}

}
