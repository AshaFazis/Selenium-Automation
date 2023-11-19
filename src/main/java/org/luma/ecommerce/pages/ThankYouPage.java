package org.luma.ecommerce.pages;

import org.luma.ecommerce.base.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThankYouPage extends Common
{
	

	public ThankYouPage (WebDriver driver) //this will be executing first in a class
	{
		super(driver);
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='base']")
	WebElement message;
	
	public void thankYouMessage()
	{
		System.out.println(message.getText());
	}
}
