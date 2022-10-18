package com.utils;

import java.text.NumberFormat;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.base.BaseTest;

public class PageUtils extends BaseTest{


	public static void sendInput(WebDriver driver,WebElement ele,String input)
	{
		ele.clear();
		ele.sendKeys(input);
	}

	public static void clickOnElement(WebElement ele)
	{
		ele.click();
	}

	public static void selectCheckBox(WebElement ele)
	{
		if(!ele.isSelected())
		{
			ele.click();
		}
	}

	public static void dropDown(WebElement ele,String text)
	{
		Select select=new Select(ele);
		select.selectByVisibleText(text);
	}

	public static String getText(WebElement ele)
	{
		String text=ele.getText();	
		return text;
	}

	public static void scrollToElement(WebDriver driver, WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ele);
	}
	
	public static void scrollToExactText(WebDriver driver,String element) {
		JavascriptExecutor jse =(JavascriptExecutor)driver;
		WebElement el = driver.findElement(By.xpath("//*[contains(text(),'"+element+"')]"));
		jse.executeScript("arguments[0].scrollIntoView();", el);
	}
	
	 public static void isElementTextExits(WebDriver driver,String value) {
		 
	    	String string="//*[contains(text(),'%s')]";
	        WebElement ele = driver.findElement(By.xpath(String.format(string, value)));
	        ele.isDisplayed();
	 }
	

	public static void scroll(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,000)", "");
	}

	  public static void clickOnText(WebDriver driver,String value) {
	    	String string="//*[text()='%s']";
	        WebElement ele = driver.findElement(By.xpath(String.format(string, value)));
	        ele.click();
	    }

	  public static String convertToDefaultCurrencyFormat(String amountToConvert){
		    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
		    String moneyString = formatter.format(Double.valueOf(amountToConvert));
		    return moneyString;
		}  
	  
	  public static String getIndianCurrencyFormat(String amount) {
		    StringBuilder stringBuilder = new StringBuilder();
		    char amountArray[] = amount.toCharArray();
		    int a = 0, b = 0;
		    for (int i = amountArray.length - 1; i >= 0; i--) {
		        if (a < 3) {
		            stringBuilder.append(amountArray[i]);
		            a++;
		        } else if (b < 2) {
		            if (b == 0) {
		                stringBuilder.append(",");
		                stringBuilder.append(amountArray[i]);
		                b++;
		            } else {
		                stringBuilder.append(amountArray[i]);
		                b = 0;
		            }
		        }
		    }
		    return stringBuilder.reverse().toString();
		}
}
