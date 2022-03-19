package methods;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

import io.cucumber.java.Status;



public class HTMLReportGenerator {

	static ExtentReports testsuiteobj=null;
	static ExtentTest testcaseobj; 
	static boolean isShowImage=false;
	static String imageFolderPath=null;
	public HTMLReportGenerator(String HTMLFilePath,String UserName) throws UnknownHostException
	{
		
		TestSuiteStart(HTMLFilePath,UserName);
		isShowImage=false;
	}
	public HTMLReportGenerator(String HTMLFilePath,String UserName,String ImageFolderPath) throws UnknownHostException
	{
		isShowImage=true;
		this.imageFolderPath=ImageFolderPath;
		TestSuiteStart(HTMLFilePath,UserName);
	}
	public static void TestSuiteStart(String ResultHTMLFilePath,String UserName) throws UnknownHostException
	{
		testsuiteobj=new ExtentReports(ResultHTMLFilePath,false,NetworkMode.OFFLINE);
		
		testsuiteobj
			.addSystemInfo("Host Name", InetAddress.getLocalHost().getHostName())
	        .addSystemInfo("Environment", "QA")
	        .addSystemInfo("User Name", UserName);
	}
	public static void TestSuiteEnd()
	{
		testsuiteobj.flush();testsuiteobj.close();
	}
	public static void TestCaseStart(String TestName,Status status)
	{
		testcaseobj=testsuiteobj.startTest(TestName);
	}
	public static void TestCaseEnd()
	{
		testsuiteobj.endTest(testcaseobj);
		
	}
	
	public static void StepDetails(String Status,String StepName,String StepDetails)
	{
		String stepinfo=null;
	
			if(isShowImage)
			{
				stepinfo=StepDetails+"<br>"+testcaseobj.addScreenCapture(imageFolderPath+"\\"+StepName.replace(" ", "_")+"...png");
			}
			else
			{
				stepinfo=StepDetails;
			}
				if(Status.equalsIgnoreCase("pass"))
				{		testcaseobj.log(LogStatus.PASS,StepName,stepinfo);}
				else if(Status.equalsIgnoreCase("fail"))
				{		testcaseobj.log(LogStatus.FAIL,StepName, stepinfo);}
				else if(Status.equalsIgnoreCase("error"))
				{		testcaseobj.log(LogStatus.ERROR,StepName, stepinfo);}
				else if(Status.equalsIgnoreCase("info"))
				{		testcaseobj.log(LogStatus.INFO,StepName, stepinfo);}
				else
				{testcaseobj.log(LogStatus.INFO,StepName, stepinfo);}
	
		
	}

	
	/*public static void main(String[] args) throws UnknownHostException {
		
		HTMLReportGenerator reportGenerator = new HTMLReportGenerator("D:\\Results\\result.html", "ejagruti","D:\\Reults\\Screenshots");
		//TestSuiteStart("C:\\eJagruti\\Result\\manish.html", "ejagruti");
		System.out.println("Starts execution");
		TestCaseStart("TEST CASE 1", "this is test case description 1");
		StepDetails("fail", "STEP 1.1", "this is step details 1");
		StepDetails("pass", "STEP 1.2", "this is step details 2");
		System.out.println("Endsssssssssssssssssss");
		TestCaseEnd();
		
		System.out.println("Ends execution");
		TestCaseStart("TEST CASE 2", "this is test case description 2");
		StepDetails("pass", "STEP 2.1", "this is step details1");
		StepDetails("pass", "STEP 2.2", "this is step details2");
		StepDetails("pass", "STEP 2.3", "this is step details3");
		StepDetails("pass", "STEP 2.4", "this is step details4");
		TestCaseEnd();
		System.out.println("Total end all works well");
		TestSuiteEnd();

	}*/

}
