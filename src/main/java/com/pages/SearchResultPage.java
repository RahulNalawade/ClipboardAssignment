package com.pages;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseTest;
import com.utils.PageUtils;
import com.utils.WaitUtility;

public class SearchResultPage extends BaseTest {
	
	public SearchResultPage(WebDriver driver)
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	public enum LocatorType {
		Id, Xpath, CssSelector, Linktext, PartiallinkText, Tagname, Name, ClassName;
	}
		
	@FindBy(id="s-result-sort-select") 
	WebElement sortDropdown;
	
	@FindBy(xpath="//span[@class='a-price-whole']") 
	List<WebElement> tvDetails;
	
	
    public void sort(String visibleText)
    {  
    	WaitUtility.waitForElement(driver,sortDropdown);
    	PageUtils.dropDown(sortDropdown, visibleText);
    	WaitUtility.waitForElement(driver,sortDropdown);

    }
    
    public void clickOnSecondHighestPriced()
    {  
    	
		List<Integer> list = new ArrayList<>();
		for (WebElement ele : tvDetails) {
			String name = ele.getText().replaceAll(",", "");
			list.add(Integer.valueOf(name));
		}
		
		Collections.sort(list);  
		String element=list.get(list.size()-2).toString();  
		
		System.out.println(element);
		
		//String amount =new DecimalFormat("##,##,##0").format(element);
		
		//System.out.println(amount);
    	
		String amt=PageUtils.getIndianCurrencyFormat(element);
		
		System.out.println(amt);

		
    	PageUtils.clickOnText(driver,amt);
    	
    	
    	//WaitUtility.waitForElement(driver, tvDetails.get(1));
    	//WaitUtility.waitForElement(driver, tvDetails.get(1));
    	//PageUtils.clickOnElement(tvDetails.get(1));
    }

}
