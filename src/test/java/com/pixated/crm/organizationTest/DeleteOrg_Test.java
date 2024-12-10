package com.pixated.crm.organizationTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.pixated.crm.beseTest.BaseClass;
import com.pixated.crm.objectrepositoryUtility.CreatingNewOrganizationPage;
import com.pixated.crm.objectrepositoryUtility.HomePage;
import com.pixated.crm.objectrepositoryUtility.OrganizationPage;

public class DeleteOrg_Test extends BaseClass {
	@Test(groups = "smokeTest")
	public void deleteTest() throws Exception {

		String orgname = elib.getDataFromExcel("practise", 1, 1) + jlib.getRandomNumber();
		// navigate to organization page

		HomePage hp = new HomePage(driver);
		hp.getOrganisation().click();
		// Click on create Organization page

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationButton().click();

		// Enter data all= the details and create new organization
		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);
		cno.createOrg(orgname);
		Thread.sleep(4900);

		// Go back to Organization page
		hp.getOrganisation().click();

		// Search for Organization
		op.getSearchBox().sendKeys(orgname);
		wlib.selectByValue(op.getsearchDropDown(), "accountname");
		op.getSearchBtn().click();
		// In dynamic webtable select and delete Organization
		driver.findElement(By.xpath("//a[text()='" + orgname + "']/../../td[8]/a[text()='del']")).click();
		wlib.switchToAlertAndAccept(driver);

	}
}
