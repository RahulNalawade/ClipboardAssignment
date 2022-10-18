package com.pages;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseTest;
import com.utils.PageUtils;
import com.utils.WaitUtility;

public class HomePage extends BaseTest{

	public HomePage(WebDriver driver)
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	public enum LocatorType {
		Id, Xpath, CssSelector, Linktext, PartiallinkText, Tagname, Name, ClassName;
	}

	@FindBy(xpath="//a[@aria-label='Open Menu']") 
	WebElement hamburgerMenu;

	@FindBy(xpath="//div[text()='TV, Appliances, Electronics']//parent::a") 
	WebElement tvAppElectronicsOption;

	@FindBy(xpath="//a[text()='Televisions']") 
	WebElement televisionOption;

	@FindBy(xpath="//span[text()='Samsung']//parent::a") 
	WebElement samsung;



	public void filterProduct() throws InterruptedException
	{
		PageUtils.clickOnElement(hamburgerMenu);
		//PageUtils.scrollToExactText(driver, "Shop By Category");
		//PageUtils.isElementTextExits(driver,"Shop By Category");
		WaitUtility.waitForElementToBeClickable(driver, tvAppElectronicsOption);
		PageUtils.clickOnElement(tvAppElectronicsOption);
		PageUtils.clickOnElement(televisionOption);
		WaitUtility.waitForElementToBeClickable(driver, samsung);
		PageUtils.selectCheckBox(samsung);
	}



}
