package com.utils;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseTest;

public class CommonActions extends BaseTest {

	public CommonActions(WebDriver driver)
	{
		this.driver = driver; 
	}

	public void switchToTab(int tab)
	{
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(tab));

	}
}
