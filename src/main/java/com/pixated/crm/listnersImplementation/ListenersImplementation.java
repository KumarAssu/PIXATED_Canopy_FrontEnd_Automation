package com.pixated.crm.listnersImplementation;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.pixated.crm.beseTest.BaseClass;
import com.pixated.crm.generic.webDriverUtility.UtilityClassObject;

public class ListenersImplementation implements ITestListener, ISuiteListener {
	public ExtentReports report;
	public static ExtentTest test;
	String time = new Date().toString().replace(" ", "_").replace(":", "_");

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_" + time + ".html");
		// Add report file configuration
		spark.config().setDocumentTitle("VtigerSuiteResult");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);
		// Add env information and create Test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows");
		report.setSystemInfo("browser", "Chrome-126.00");
		report.setSystemInfo("url", "https://localhost:8888/");
		report.setSystemInfo("enviorment name", "testing");
		report.setSystemInfo("author name", "AsitKumar");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report Configuration");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		System.out.println("---->" + testName + "Start");
		test = report.createTest(testName);
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, testName + "Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		System.out.println("---->" + testName + "END");
		test.log(Status.PASS, testName + "Completed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		TakesScreenshot eDriver = (TakesScreenshot) BaseClass.sdriver;
		String filePath = eDriver.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filePath, testName + "_" + time);
		// To get the exact status we have to use "result.getThrowable()" method
		test.log(Status.FAIL, result.getThrowable());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		test.log(Status.SKIP, testName + "_-->is Skipped");
		test.log(Status.SKIP, result.getThrowable());

	}

}
