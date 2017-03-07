package pageObjectModel;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class customListeners implements ITestListener  {
	@Override
	public void onTestStart(ITestResult result) {
		Log.info("Test Started : " + result.getName());		
	}

	@Override
	public void onTestSuccess(ITestResult result) {		
		Log.info("Test sucessfully TestName : " + result.getTestName());
		Log.info("Test sucessfully Method : " + result.getMethod());
		Log.info("Test sucessfully Instance : " + result.getInstanceName());
		Log.info("Test sucessfully is success : " + result.isSuccess());
	}

	@Override
	public void onTestFailure(ITestResult result) {	
		Log.info("Test Failed" + result.getName());
		String TC_Name = result.getName();
		utilsClass.fn_TakeScreenShot(TC_Name+".jpg");		
		Log.info("Test Failed & screenshot captured : ");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Log.info("Test Skipped " + result.getName());		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
	
		
	}

}
