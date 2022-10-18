package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseTest;
import com.utils.PageUtils;
import com.utils.WaitUtility;

public class ProductDetailsPage extends BaseTest {

	public ProductDetailsPage(WebDriver driver)
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	public enum LocatorType {
		Id, Xpath, CssSelector, Linktext, PartiallinkText, Tagname, Name, ClassName;
	}
	
	@FindBy(xpath="//div[@id='feature-bullets']//h1") 
	WebElement aboutThisItem;
	
	
    public String aboutThisItemText()
    {  
    	
    	PageUtils.scrollToExactText(driver,"About this item");
    	PageUtils.scrollToElement(driver, aboutThisItem);
    	WaitUtility.waitForElement(driver, aboutThisItem);
    	String aboutThisItemText=PageUtils.getText(aboutThisItem);
    	return aboutThisItemText;
    }


	
    
}
