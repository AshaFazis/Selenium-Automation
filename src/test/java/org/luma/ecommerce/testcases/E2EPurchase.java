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
import org.testng.annotations.Test;

public class E2EPurchase extends Base_Tests
{
	   public String tee = "Iris Workout Top";
		
		@Test(retryAnalyzer = Retry_Failed.class)
		public void purchaseFlow() throws IOException, InterruptedException
		{
	        LoginPage login = home.homePage();
			ProductsMenuPage productmenupage = login.loginDetails("ashafj11@gmail.com", "Ashafj11!");
			productmenupage.productMenu();
			productmenupage.clothCategories();
			
			ProductPage productpage = productmenupage.clothSubCategories();
			productpage.shoppingOptionsSize();
			productpage.shoppingOptionsColor();
			productpage.getProductsList();
			productpage.getProductNames(tee);
			productpage.addToCart();
			
			CartIcon carticon =  productpage.itemAddedMessage();
			carticon.cart();
			
			AddressPage address = carticon.checkOutButton();
			address.shippingMethods();
			
			ThankYouPage thankyoupage = address.paymentMethods();
			thankyoupage.thankYouMessage();
		}
			
}
