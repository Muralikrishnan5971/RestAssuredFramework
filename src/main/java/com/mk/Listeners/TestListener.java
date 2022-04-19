package com.mk.Listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.mk.Reports.ExtentLogger;
import com.mk.Reports.GenerateReport;

public class TestListener implements ITestListener, ISuiteListener {

	// Important feature of java 8, it allows public methods in the interface, so
	// if we want we can implement it
	// It will not force us to do so.
	
	// we have added  new listener, but we have to tell testNG about this.
	// go to tesng.xml file and add the info SEE testNG.xml file

	/**
	 * This method is invoked before the SuiteRunner starts.
	 *
	 * @param suite
	 *            The suite
	 */
	@Override
	public void onStart(ISuite suite) {
		GenerateReport.initReports();
	}

	/**
	 * This method is invoked after the SuiteRunner has run all the tests in the
	 * suite.
	 *
	 * @param suite
	 *            The suite
	 */
	@Override
	public void onFinish(ISuite suite) {
		GenerateReport.endReports();
	}

	/**
	 * Invoked each time before a test will be invoked. The <code>ITestResult</code>
	 * is only partially filled with the references to class, method, start millis
	 * and status.
	 *
	 * @param result
	 *            the partially filled <code>ITestResult</code>
	 * @see ITestResult#STARTED
	 */
	@Override
	public void onTestStart(ITestResult result) {

		GenerateReport.createTest(result.getName());
	}

	/**
	 * Invoked each time a test succeeds.
	 *
	 * @param result
	 *            <code>ITestResult</code> containing information about the run test
	 * @see ITestResult#SUCCESS
	 */
	@Override
	public void onTestSuccess(ITestResult result) {

		ExtentLogger.pass(String.valueOf(result.getName() + " is PASSED"));
	}

	/**
	 * Invoked each time a test fails.
	 *
	 * @param result
	 *            <code>ITestResult</code> containing information about the run test
	 * @see ITestResult#FAILURE
	 */
	@Override
	public void onTestFailure(ITestResult result) {

		ExtentLogger.fail(String.valueOf(result.getThrowable()));
	}
	
	public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }

	  /**
	   * Invoked each time a method fails but has been annotated with successPercentage and this failure
	   * still keeps it within the success percentage requested.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
	   */
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	  /**
	   * Invoked each time a test fails due to a timeout.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   */
	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	  /**
	   * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt; tag
	   * and calling all their Configuration methods.
	   *
	   * @param context The test context
	   */
	  public void onStart(ITestContext context) {
	    // not implemented
	  }

	  /**
	   * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have run
	   * and all their Configuration methods have been called.
	   *
	   * @param context The test context
	   */
	  public void onFinish(ITestContext context) {
	    // not implemented
	  }
}
