package org.luma.ecommerce.testcases;

import java.io.IOException;

import org.luma.ecommerce.pages.AddressPage;
import org.luma.ecommerce.pages.CartIcon;
import org.luma.ecommerce.pages.LoginPage;
import org.luma.ecommerce.pages.ProductPage;
import org.luma.ecommerce.pages.ProductsMenuPage;
import org.luma.ecommerce.pages.ThankYouPage;
import org.luma.ecommerce.tests.Base_Tests;
import org.luma.ecommerce.tests.Retry_Failed;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Negative_Validation extends Base_Tests
{
	public static String tee = "Iris Workout Top";
	
	
	@Test 
	public void loginNegative_Validation() throws IOException, InterruptedException
	{
        
		
		LoginPage login = home.homePage();
		login.loginDetails("ashafj11@gmail.com", "Ashafj12!");
		Assert.assertEquals("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.", login.LoginError());
		
		
	}
	
}
