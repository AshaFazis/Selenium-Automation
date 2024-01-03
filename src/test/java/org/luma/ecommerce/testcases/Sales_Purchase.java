package org.luma.ecommerce.testcases;

import org.luma.ecommerce.pages.LoginPage;
import org.luma.ecommerce.pages.ProductsMenuPage;
import org.luma.ecommerce.tests.Base_Tests;
import org.testng.annotations.Test;

public class Sales_Purchase extends Base_Tests
{
	@Test
    public void sales_purchase_flow()
    {
		LoginPage login = home.homePage();
		ProductsMenuPage productmenupage = login.loginDetails("ashafj11@gmail.com", "Ashafj11!");
		productmenupage.productMenu_sales();
    }
}
