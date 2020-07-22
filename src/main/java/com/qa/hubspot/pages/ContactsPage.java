package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.utils.ConstantUtil;
import com.qa.hubspot.utils.ElementUtil;

public class ContactsPage extends BasePage{
	private WebDriver driver;
	ElementUtil elementutil;
	//By locators
	By header=By.linkText("Contacts");
	By primarycontacts=By.xpath("//span[text( )='Create contact']");
	By email=By.xpath("//input[@data-field='email']");
	By firstname=By.xpath("//input[@data-field='firstname']");
	By lastname=By.xpath("//input[@data-field='lastname']");
	By jobtitle=By.xpath("//input[@data-field='jobtitle']");
	By secondarycontacts=By.xpath("(//span[text()='Create contact'])[position()=2]");
	By createcontacttext=By.xpath("(//span[text()='Sandya Thota'])[position()=2]");
	By clickchange=By.xpath("(//span[@class='UIIcon__IconContent-sc-1ngbkfp-0 bVjkIp'])[position()=1]");
	By fname=By.xpath("(//input[@value='Sandya'])[position()=2]");
	By lname=By.xpath("(//input[@value='Thota'])[position()=2]");
	By backlink=By.xpath("(//span[@class='UIIcon__IconContent-sc-1ngbkfp-0 bVjjGG'])[position()=1]");
	//constructor creating
	public  ContactsPage(WebDriver driver) {
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
	}
	//Actions
	public String getTitle() {
		
		return elementutil.doGetPageTitleWithIsTitle(10,ConstantUtil.CONTACTS_PAGE_TITLE);
	}
	public String getHeader() {
		elementutil.waitForElementPresent(header, 10);
	  if(elementutil.doIsDisplayed(header))
		 return elementutil.doGetText(header);
	    return null;
		}
	public void getContacts(String emailId,String firstName,String lastName,String jobTitle) {
//		String text=null;
		elementutil.waitForElementPresent(primarycontacts, 20);
		elementutil.doClick(primarycontacts);
		elementutil.waitForElementToBeVisible(email,20);
		elementutil.doSendKeys(this.email, emailId);;
		elementutil.doSendKeys(this.firstname, firstName);
		elementutil.doSendKeys(this.lastname, lastName);
		elementutil.waitForElementToBeVisible(jobtitle,30);
	    elementutil.doActionsSendKeys(this.jobtitle, jobTitle);
		elementutil.doClick(secondarycontacts);
//        elementutil.waitForElementPresent(clickchange, 30);
//        elementutil.doClick(clickchange);
    	//String text=elementutil.doGetText(fname);
    	
//    	if(elementutil.doIsDisplayed(fname))
//      	 text= elementutil.doGetText(createcontacttext);
    	
//    	String text1=elementutil.doGetText(lname);
//    	String text3=("text"+" "+"text1");
   	
//	    elementutil.waitForElementPresent(backlink, 20);
//		elementutil.doActionsClick(backlink);
		elementutil.clickWhenReady(backlink, 20);
//	    return text ;
	    
			
	}
	
	
	
	
	
}	
	

