package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.basepage.BasePageTest;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.ConstantUtil;
import com.qa.hubspot.utils.ExcelUtil;

public class ContactPageTest  extends BasePageTest{
	HomePage homepage;
	ContactsPage contactspage;
	@BeforeClass
	public void ContactsPageSetUp()  {
		homepage=loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		contactspage=homepage.goToContactsPage();
		
	}
	@Test(priority=1)
	public void verifygetTitle() {
		String title=contactspage.getTitle();
		System.out.println("Title is"+ title);
		Assert.assertEquals(title,ConstantUtil.CONTACTS_PAGE_TITLE);
		}
	
	@Test(priority=2)
	public void verifygetHeader() {
		String header=contactspage.getHeader();
		System.out.println("Header is"+header);
		Assert.assertEquals(header,ConstantUtil.CONTACTS_PAGE_HEADER);
		}
	
	@DataProvider
	public Object[][] getContactsTestData() {
	Object data[][]=ExcelUtil.getTestData(ConstantUtil.CONTACT_SHEET_NAME);
	return data;
		}
	@Test(priority=3,dataProvider="getContactsTestData")
	public void verifygetContacts(String emailid,String firstname,String lastname,String jobtitle) {
		contactspage.getContacts(emailid,firstname,lastname,jobtitle);
//				Assert.assertEquals(contact, ConstantUtil.CREATE_CONTACT_TEXT);
	
	}
	

}
