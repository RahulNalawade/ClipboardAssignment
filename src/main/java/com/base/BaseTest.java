package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static Properties properties ;
	public  WebDriver driver;

	public BaseTest()
	{
		properties = new Properties();
		File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\config\\config.properties");

		try {
			FileInputStream inputStream = new FileInputStream(file);

			properties.load(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
		} catch (FileNotFoundException fie) {
			fie.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	@BeforeMethod
	public void intilization()
	{
		String browser=properties.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			ChromeOptions chromeOptions = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
		}

		if(browser.equalsIgnoreCase("edge"))
		{
			EdgeOptions edgeOptions = new EdgeOptions();
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(edgeOptions);
		}

		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	
	@AfterMethod
	public void quit()
	{
		driver.quit();
	}

}
