package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.basepage.BasePageTest;
import com.qa.hubspot.testlistners.AllureReport;
import com.qa.hubspot.utils.ConstantUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic - 101 :design loginpage features...")
@Feature("US - 201: desig loginpage signup,loginpage title and login with modules...")
@Listeners(AllureReport.class)
public class LoginPageTest extends BasePageTest {
	@Description("verify signup link on loginpage")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=1)
	public void verifySignUpLinkTest() {
		boolean flag=loginpage.getSignUpLinkExist();
		Assert.assertEquals(flag, true);	
	}
	@Description("verify loginpage title on loginpage")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=2)
	public void verifygetLoginPageTitle() {
		String title=loginpage.getLoginPageTitle();
		System.out.println("Title is"+ title);
		Assert.assertEquals(title,ConstantUtil.LOGIN_PAGE_TITLE);
	}
	@Description("verify user is able to loginpage")
	@Severity(SeverityLevel.MINOR)
	@Test(priority=3)
	public void doLogin(){
		loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	
}
