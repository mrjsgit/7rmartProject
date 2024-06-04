package generatereport;

import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testscript.Base;
import utilities.ExtendReportUtility;

//listner class listens the console and helps in creating customized report
public class Listeners extends Base implements ITestListener
{
	
	ExtentTest test;

	ExtentReports extent = ExtendReportUtility.createExtentReports();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
//starting of testcase; ITestListner fetch the method name of the testcase and add it to extend report
	public void onTestStart(ITestResult result) {

		ITestListener.super.onTestStart(result);
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test); //adding name to extend report

	}
//if testcase is passed
	public void onTestSuccess(ITestResult result) {

		ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "Test Passed");//pass status 'Test Passed' to extend report

	}
	
/*public void onTestFailure(ITestResult result) {

		ITestListener.super.onTestFailure(result);
		extentTest.get().log(Status.FAIL, "Test Failed");
		extentTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException e) {

			e.printStackTrace(); //print exception msg
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (NoSuchFieldException e) {

			e.printStackTrace();
		} catch (SecurityException e) {

			e.printStackTrace();
		}

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
		}
	}   
	*/
	
	public void onTestFailure(ITestResult result)
	{
        try 
           {
            // Attempting to access a field named 'driver'
            Field field = result.getTestClass().getRealClass().getDeclaredField("driver");
            field.setAccessible(true);
            WebDriver driver = (WebDriver) field.get(result.getInstance());
            // Perform your actions with the driver here, e.g., taking a screenshot
             } 
        catch (NoSuchFieldException e)
             {
            System.err.println("NoSuchFieldException: The field 'driver' does not exist in the test class.");
            e.printStackTrace();
             } 
        catch (IllegalAccessException e) 
             {
            System.err.println("IllegalAccessException: Failed to access the 'driver' field.");
            e.printStackTrace();
             } 
        catch (Exception e) 
                {
            System.err.println("Exception: An unexpected error occurred.");
            e.printStackTrace();
                }
	}
	
      public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);
		extentTest.get().log(Status.SKIP, "Test Skipped");
		String testMethodName = result.getMethod().getMethodName();

	}
  //for graph creation
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}
	//for graph creation

    public void onTestFailedWithTimeout(ITestResult result) {

		ITestListener.super.onTestFailedWithTimeout(result);
	}
  //for graph creation

	public void onStart(ITestContext context) {

		ITestListener.super.onStart(context);
	}
   
	public void onFinish(ITestContext context) {

		ITestListener.super.onFinish(context);
		extent.flush();//flush method will create the report else only the folder will be generated
	}
}
