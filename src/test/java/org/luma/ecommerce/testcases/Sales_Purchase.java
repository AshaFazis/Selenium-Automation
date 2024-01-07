package org.luma.ecommerce.testcases;

import org.luma.ecommerce.pages.AddressPage;
import org.luma.ecommerce.pages.CartIcon;
import org.luma.ecommerce.pages.LoginPage;
import org.luma.ecommerce.pages.ProductPage;
import org.luma.ecommerce.pages.ProductsMenuPage;
import org.luma.ecommerce.pages.Sales;
import org.luma.ecommerce.pages.ThankYouPage;
import org.luma.ecommerce.tests.Base_Tests;
import org.testng.annotations.Test;

public class Sales_Purchase extends Base_Tests
{
	public String tee = "Iris Workout Top";
	
	@Test
    public void sales_purchase_flow() throws InterruptedException
    {
		LoginPage login = home.homePage();
		ProductsMenuPage productmenupage = login.loginDetails("ashafj11@gmail.com", "Ashafj11!");
		
		Sales salespage = productmenupage.productMenu_sales();
		
		ProductPage productpage = salespage.sales_tees();
		productpage.shoppingOptionsSize();
		productpage.shoppingOptionsColor();
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
