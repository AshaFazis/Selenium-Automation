package org.luma.ecommerce.testcases;

import java.io.FileInputStream;
import java.io.IOException;


import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.luma.ecommerce.pages.AddressPage;
import org.luma.ecommerce.pages.CartIcon;
import org.luma.ecommerce.pages.HomePage;
import org.luma.ecommerce.pages.LoginPage;
import org.luma.ecommerce.pages.ProductPage;
import org.luma.ecommerce.pages.ProductsMenuPage;
import org.luma.ecommerce.pages.ThankYouPage;
import org.luma.ecommerce.tests.Base_Tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends Base_Tests
{

	public static String tee = "Iris Workout Top";
	
	
	@Test(groups = "smoke", dataProvider = "testData")
	public void login(String email,String password) throws IOException, InterruptedException
	{
        
		
		LoginPage login = home.homePage();
		login.loginDetails(email, password);
		
		
    }
	
	

}
