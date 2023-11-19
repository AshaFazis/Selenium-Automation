package org.luma.ecommerce.pages;

import org.luma.ecommerce.base.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductsMenuPage extends Common
{
	
		
	public ProductsMenuPage (WebDriver driver) //this will be executing first in a class
	{
		super(driver);
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//span[text()='Women']")
	WebElement womenSection;
	
	@FindBy(how = How.XPATH, using = "//a[@id='ui-id-9']//span[text()='Tops']")
	WebElement womenTops;
	
	@FindBy(xpath = "//a[@id='ui-id-13']//span[text()='Tees']")
	WebElement womenTees;
	
	
	public void productMenu()
	{
		actionsBuild(womenSection);
	}
	
	public void clothCategories() 
	{
		actionsBuild(womenTops);
	}
	
	public ProductPage clothSubCategories() 
	{
		actionsClick(womenTees);
		return new ProductPage(driver);
        
		
	}
	
	
	
	
}
