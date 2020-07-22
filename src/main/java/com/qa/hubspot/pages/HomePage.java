package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.utils.ConstantUtil;
import com.qa.hubspot.utils.ElementUtil;

public class HomePage extends BasePage {
	private WebDriver driver;
	ElementUtil elementutil;
	
 //creating By locators
	By header=By.cssSelector("h1.dashboard-selector__title");
	By accountname=By.cssSelector("#account-menu > svg");
	By accname=By.cssSelector("div.user-info-name");
	By primarycontacts=By.id("nav-primary-contacts-branch");
	By secondarycontacts=By.id("nav-secondary-contacts");
    //By secondarycontacts=By.xpath("(//*[@id=\"nav-secondary-contacts\"]/div[1])[position()=1]");
	
	//creating constructor
		public HomePage(WebDriver driver) {
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
		
	}
	//actions
	public String getHomePageTitle() {
		//return driver.getTitle();
		 return elementutil.doGetPageTitleWithContains(10, ConstantUtil.HOME_PAGE_TITLE);
	}
	public String getHeader() {
		if(elementutil.doIsDisplayed(header))
		return elementutil.doGetText(header);
		return null;
	
		
	}
	
	public void getAccount() {
		  //driver.findElement(accountname).click();
		elementutil.doClick(accountname);
		}
	
	public String getLoggedAccountText() 
	{	
		   getAccount();
			if( elementutil.doIsDisplayed(accname))
	   return elementutil.doGetText(accname);
		return null;
	}
	public void clickOnContacts()  {
		
		elementutil.waitForElementPresent(primarycontacts,10);
		elementutil.clickWhenReady(primarycontacts, 10);
		elementutil.waitForElementPresent(secondarycontacts, 10);
		elementutil.clickWhenReady(secondarycontacts, 10);
		
		
	}
	public ContactsPage goToContactsPage()  {
		clickOnContacts();
		return new ContactsPage(driver);
	}
	
	

}
