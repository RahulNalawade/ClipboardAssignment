package com.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.HomePage;
import com.pages.ProductDetailsPage;
import com.pages.SearchResultPage;
import com.utils.CommonActions;
import com.utils.PageUtils;

public class AmazonProductVerification extends BaseTest{

	HomePage homePage;
	SearchResultPage searchResult;
	CommonActions commonActions;
	ProductDetailsPage productPage;

	@BeforeMethod
	public void beforeMethod()
	{
		homePage=new HomePage(driver);
		searchResult=new SearchResultPage(driver);
		commonActions=new CommonActions(driver);
		productPage=new ProductDetailsPage(driver);
	}

	@Test
	public void searchProdcuts() throws InterruptedException
	{	
		homePage.filterProduct();
		//searchResult.sort("Price: Low to High");
		searchResult.sort("Price: High to Low");
		searchResult.clickOnSecondHighestPriced();
		commonActions.switchToTab(1);
		String aboutThisItemText =productPage.aboutThisItemText();
		Assert.assertEquals(aboutThisItemText, "About this item", aboutThisItemText);
		System.out.println(aboutThisItemText);
	}
}
