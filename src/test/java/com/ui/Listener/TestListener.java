package com.ui.Listener;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.test.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReportUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener {
	Logger logger = LoggerUtility.getLogger(this.getClass());

	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;

	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
logger.info(result.getMethod().getMethodName() + " " + "PASSED");
ExtentReportUtility.getExtentTest().log(Status.PASS, result.getMethod().getMethodName()+" "+"PASSED ");
	}

	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + " " + "FAILED");
		logger.error(result.getThrowable().getMessage());
		ExtentReportUtility.getExtentTest().log(Status.FAIL, result.getMethod().getMethodName()+" "+"FAILED ");
		ExtentReportUtility.getExtentTest().log(Status.FAIL,result.getThrowable().getMessage());
		Object testClass=result.getInstance();
		logger.info("Capturing Screenshots for failed cases");
		BrowserUtility browserUtility=((TestBase)testClass).getInstance();
		String screenShotPath=browserUtility.takeScreenshot(result.getMethod().getMethodName());
		logger.info("Attaching  screenshots to HTML File");
		ExtentReportUtility.getExtentTest().addScreenCaptureFromPath(screenShotPath);
		
	}

	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + " " + "SKIPPED");
		ExtentReportUtility.getExtentTest().log(Status.SKIP, result.getMethod().getMethodName()+" "+"SKIPPED ");
	}

	public void onStart(ITestContext context) {
		logger.info("TestSuite Started");
		ExtentReportUtility.setupSparkReporter();
		
	}

	public void onFinish(ITestContext context) {
		logger.info("TestSuite Completed");
		ExtentReportUtility.flushReport();
	}

}
