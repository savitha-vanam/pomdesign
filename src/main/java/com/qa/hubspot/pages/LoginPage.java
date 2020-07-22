package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.utils.ConstantUtil;
import com.qa.hubspot.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage{
	private WebDriver driver;
	ElementUtil elementutil;
	//creating By locators
By emailId=By.id("username");
By password=By.id("password");
By loginButton=By.id("loginBtn");
By signuplink=By.linkText("Sign up11");
//creating constructor of  the pageclass

public LoginPage(WebDriver driver) {
   this.driver =driver;
   elementutil=new ElementUtil(this.driver);
}
//page actions

@Step("getting login page title")
public String getLoginPageTitle() {
	//String title=driver.getTitle();
	//return title;
	return elementutil.doGetPageTitleWithIsTitle(10, ConstantUtil.LOGIN_PAGE_TITLE);
}
@Step(" getting signup link is presence")
public boolean getSignUpLinkExist() {
	//return driver.findElement(signuplink).isDisplayed();
	return elementutil.doIsDisplayed(signuplink);
	
	}
@Step("getting username:{0},password {1}")
public HomePage doLogin(String username,String pwd) {
//	driver.findElement(emailId).sendKeys(username);
//	driver.findElement(password).sendKeys(pwd);
//	driver.findElement(loginButton).click();
	System.out.println("Loging with app-----> " + username + ":" + pwd);
	elementutil.waitForElementPresent(emailId, 10);
	elementutil.doSendKeys(emailId,username);
	elementutil.doSendKeys(password, pwd);
	elementutil.doClick(loginButton);
	return new HomePage( driver);
	
}





}