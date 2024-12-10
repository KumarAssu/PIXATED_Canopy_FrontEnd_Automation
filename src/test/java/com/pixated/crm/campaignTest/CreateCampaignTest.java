package com.pixated.crm.campaignTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pixated.crm.beseTest.BaseClass;
import com.pixated.crm.generic.webDriverUtility.UtilityClassObject;
import com.pixated.crm.objectrepositoryUtility.HomePage;

public class CreateCampaignTest extends BaseClass {
@Test
public void createCampaignTest() throws Exception {
	UtilityClassObject.getTest().log(Status.INFO, "readData From Excel");
	String campName = elib.getDataFromExcel("Contact", 1, 3) + jlib.getRandomNumber();
	/* navigate to contact page */
	UtilityClassObject.getTest().log(Status.INFO, "navigate to contact page");
	HomePage hp = new HomePage(driver);
	hp.getContacts().click();
	UtilityClassObject.getTest().log(Status.INFO, "Click on create contact page");
	/* click on create contact page */
}
}
