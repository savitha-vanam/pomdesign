package com.qa.hubspot.basepage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.hubspot.utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsmanager;
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver>();
	/**
	 * This method is initializing the driver on the basis of given browsername 
	 * @param browserName
	 * return driver
	 */
	public WebDriver init_driver(Properties prop) {
		
		String browserName=prop.getProperty("browser").trim();
		System.out.println("browser name is"+ browserName);
		
		 optionsmanager=new OptionsManager(prop);
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
		   // driver=new ChromeDriver(optionsmanager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsmanager.getChromeOptions()));
		  
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
		//driver=new FirefoxDriver(optionsmanager.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver(optionsmanager.getFirefoxOptions()));
		}
		else if(browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			//driver=new SafariDriver();
			tlDriver.set(new SafariDriver());
		}
		else {
			System.out.println(browserName +"is not found please pass the correct browsername");
		}
		
		getDriver().manage().deleteAllCookies();
	    getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("url"));
		return getDriver();
			
	}
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	/**
	 * This method is intializing the properties from config.properties file
	 * return prop
	 */
	public Properties init_prop() {
		prop=new Properties();
		String path=null;
		String env=null;
		
		try {
      		env=System.getProperty("env");
      		
		if(env==null) {
			path="./src/main/java/com/qa/hubspot/config/config.properties";
		} else{
			switch (env) {
			
			case "dev":
				path="./src/main/java/com/qa/hubspot/config/dev.config.properties";
					break;
			case "qa":
				path="./src/main/java/com/qa/hubspot/config/qa.config.properties";
                   break;
			case "stage":
			   path="./src/main/java/com/qa/hubspot/config/stage.config.properties";
			break;
			default:
				System.out.println("please pass correct env value"+env);
				break;
			}
			
		}
		
		
			FileInputStream Ip=new FileInputStream(path);
			prop.load(Ip);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
			}
	public String getScreenshot() {
		File src=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
		File destination=new File(path);
		try {
			FileUtils.copyFile(src,destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
		
	}
	
	
	

}
