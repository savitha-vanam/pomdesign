package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.basepage.BasePageTest;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.ConstantUtil;

public class HomePageTest extends BasePageTest  {
	
	
     HomePage homepage;
     @BeforeClass
     public void homePageSetUp() {
    	 homepage=loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
         }
		
	@Test(priority=1)
	public void verifygetHomePageTitle() {
		String title=homepage.getHomePageTitle();
		System.out.println("Title is:"+ title);
		Assert.assertEquals(title,ConstantUtil.HOME_PAGE_TITLE);
	}
	@Test(priority=2)
	public void verifygetHeader() {
		String header=homepage.getHeader();
		System.out.println("Header is:"+ header);
		Assert.assertEquals(header,ConstantUtil.HOME_PAGE_HEADER );
	}
	@Test(priority=3)
	public void verifygetLoggedAccountText() {
		String accountname=homepage.getLoggedAccountText();
		System.out.println("Accountname is: "+ accountname);
		Assert.assertEquals(accountname,prop.getProperty("accountname"));
		}
	
}
