package com.pixated.crm.contactTest;

/**
 * This class is for test the crete contacttest
 */
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.pixated.crm.beseTest.BaseClass;
import com.pixated.crm.generic.webDriverUtility.UtilityClassObject;
import com.pixated.crm.listnersImplementation.ListenersImplementation;
import com.pixated.crm.objectrepositoryUtility.ContactInfoPage;
import com.pixated.crm.objectrepositoryUtility.ContactPage;
import com.pixated.crm.objectrepositoryUtility.CreateContactPage;
import com.pixated.crm.objectrepositoryUtility.CreatingNewOrganizationPage;
import com.pixated.crm.objectrepositoryUtility.HomePage;
import com.pixated.crm.objectrepositoryUtility.OrganizationInfoPage;
import com.pixated.crm.objectrepositoryUtility.OrganizationPage;
import com.pixated.crm.objectrepositoryUtility.OrganizationsWindow;

public class CreateContactTest extends BaseClass {
	/**
	 * This method is used for test the create contact using mandatory field
	 * Scenario:Login==>navigateContact==>createContact==>Verify
	 * @throws Exception
	 */
	@Test(groups = "smokeTest")
	public void createContactTest() throws Exception {
		UtilityClassObject.getTest().log(Status.INFO, "readData From Excel");
		/* read the data from excel */
		String lName = elib.getDataFromExcel("Contact", 1, 3) + jlib.getRandomNumber();
		/* navigate to contact page */
		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact page");
		HomePage hp = new HomePage(driver);
		hp.getContacts().click();
		UtilityClassObject.getTest().log(Status.INFO, "Click on create contact page");
		/* click on create contact page */
		ContactPage cPage = new ContactPage(driver);
		cPage.getCreateContactButton().click();
		/* Enter data and create new contact */
		UtilityClassObject.getTest().log(Status.INFO, "Enter data all the details and create new contact");
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.createContact(lName);
		UtilityClassObject.getTest().log(Status.INFO, "Verify header message expected result");
		/* Verify header message expected result */
		ContactInfoPage cip = new ContactInfoPage(driver);
		String headerinfo = cip.getHeaderMessage().getText();
		boolean status = headerinfo.contains(lName);
		Assert.assertEquals(status, true);
		UtilityClassObject.getTest().log(Status.PASS, "It is created and verified");
		/* Verify header message expected result */
		String actualLname = cip.getLastNameMessage().getText();
		SoftAssert s = new SoftAssert();
		s.assertEquals(actualLname, lName);
	}

	/**
	 * This method is used for test the create contact using mandatory field
	 * Scenario:Login==>navigateContact==>createContact==>Verify
	 * @throws Exception
	 */
	@Test(groups = "regressionTest")
	public void createContactWithOganisationTest() throws Exception {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Execution Started");
		/* read the data from excel */
		String orgname = elib.getDataFromExcel("Contact", 1, 4) + jlib.getRandomNumber();
		String lName = elib.getDataFromExcel("Contact", 1, 3) + jlib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.getOrganisation().click();
		/* Click on create Organization page */
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationButton().click();
		/* Enter data all= the details and create new organization */
		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);
		cno.getOrgName().sendKeys(orgname);
		cno.getSavebutton().click();
		/* Verify header message expected result */
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getOrgNameMessage().getText();
		Assert.assertEquals(actOrgName, orgname);
		/* Create Contant With this organization name */
		hp.getContacts().click();
		ContactPage cPage = new ContactPage(driver);
		cPage.getCreateContactButton().click();
		/* Enter data all= the details and create new contact */
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getLastname().sendKeys(lName);
		ccp.getAddOrganizationbtn().click();
		/* Switch to child Window */
		wlib.switchToChildTabOnTitle(driver, "module=Accounts");
		OrganizationsWindow ow = new OrganizationsWindow(driver);
		ow.getSearchBox().sendKeys(orgname);
		ow.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();
		/* Switch to parent Window */
		wlib.switchToChildTabOnTitle(driver, "Contacts&action");
		ccp.getSavebtn().click();
		/* Verify same organization name is showing */
		ContactInfoPage cip = new ContactInfoPage(driver);

		String actOrgName1 = cip.getOrgMessage().getText();
		SoftAssert s = new SoftAssert();
		s.assertEquals(actOrgName1, orgname);

	}
}
