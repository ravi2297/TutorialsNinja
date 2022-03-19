package methods;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumOperations {
	public static WebDriver driver;
	
	public static Hashtable<String,Object> outputParameters=new Hashtable<String,Object>();
	
	public static Hashtable<String,Object> openBrowser(Object[] inputParameters)
	{
		try 
		{
		String browserName=(String) inputParameters[0];
		String exe=(String) inputParameters[1];
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", exe);
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", exe);
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		
		outputParameters.put("STATUS", "PASS");
		outputParameters.put("MESSAGE", "Method_Used : openBrowser input_Data : " +  inputParameters[1].toString());
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS", "FAIL");
			outputParameters.put("MESSAGE", "Method_Used : openBrowser input_Data : " +  inputParameters[1].toString());
		}
		return outputParameters;
	}
	
	public static Hashtable<String,Object>  openUrl(Object[] inputParameters)
	{
		try
		{
		String url=(String) inputParameters[0];
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		
		outputParameters.put("STATUS","PASS");
		outputParameters.put("MESSAGE","Method_Used : openUrl input_Data : " + inputParameters[0].toString());
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS","FAIL");
			outputParameters.put("MESSAGE","Method_Used : openUrl input_Data : " + inputParameters[0].toString());
		}
		return outputParameters;
	}
	
	public static Hashtable<String,Object>  clickMethod(Object[] inputParameters)
	{
		try
		{
		String xpath=(String) inputParameters[0];
		driver.findElement(By.xpath(xpath)).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		outputParameters.put("STATUS","PASS");
		outputParameters.put("MESSAGE","Method_Used : clickMethod input_Data : " + inputParameters[0].toString());
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS","FAIL");
			outputParameters.put("MESSAGE","Method_Used : clickMethod input_Data : " + inputParameters[0].toString());
		}
		return outputParameters;
	}
	
	public static Hashtable<String,Object>  sendTextMethod(Object[] inputParameters)
	{
		try
		{
		String xpath=(String) inputParameters[0];
		String text=(String) inputParameters[1];
		
		driver.findElement(By.xpath(xpath)).sendKeys(text);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		outputParameters.put("STATUS","PASS");
		outputParameters.put("MESSAGE","Method_Used : sendTextMethod input_Data : " + inputParameters[1].toString());
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS","FAIL");
			outputParameters.put("MESSAGE","Method_Used : sendTextMethod input_Data : " + inputParameters[1].toString());
		}
		return outputParameters;
	}
	
	public static Hashtable<String,Object>  validationForMethod(Object[] inputParameters)
	{
		try
		{
		String givenText=(String) inputParameters[0];
		String xpath=(String) inputParameters[1];
		
		String actualText=driver.findElement(By.xpath(xpath)).getText();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if (givenText.equalsIgnoreCase(actualText))
		{
			System.out.println("Test case has been Passed.");
		}
		else
		{
			System.out.println("Test case has been Failed.");
		}
		
		outputParameters.put("STATUS","PASS");
		outputParameters.put("MESSAGE","Method_Used : validationForMethod input_Data : " + inputParameters[1].toString());
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS","FAIL");
			outputParameters.put("MESSAGE","Method_Used : validationForMethod input_Data : " + inputParameters[1].toString());
		}
		return outputParameters;
	}
	
	public static void main(String[] args)
	{
		//launch browser
		Object[] input=new Object[2];
		input[0]="chrome";
		input[1]="D:\\Software Testing\\TutorialsNinja\\TutorialsNinja\\src\\test\\resources\\DRIVERS\\chromedriver.exe";
		SeleniumOperations.openBrowser(input);
		
		//open Url
		Object[] input1=new Object[1];
		input1[0]="http://tutorialsninja.com/demo/";
		SeleniumOperations.openUrl(input1);
		
		//click on My Account
		Object[] input2=new Object[1];
		input2[0]="//*[text()='My Account']";
		SeleniumOperations.clickMethod(input2);
		
		//click on Login button
		Object[] input3=new Object[1];
		input3[0]="//*[text()='Login']";
		SeleniumOperations.clickMethod(input3);
		
		//enter username
		Object[] input4=new Object[2];
		input4[0]="//*[@name='email']";
		input4[1]="ravibhalerao9970@gmail.com";
		SeleniumOperations.sendTextMethod(input4);
		
		//enter password
		Object[] input5=new Object[2];
		input5[0]="//*[@name='password']";
		input5[1]="ravikiran";
		SeleniumOperations.sendTextMethod(input5);
		
		//click on Login
		Object[] input6=new Object[1];
		input6[0]="//*[@value='Login']";
		SeleniumOperations.clickMethod(input6);
		
		//user Logged in successfully
		Object[] input7=new Object[2];
		input7[0]="Your Store";
		input7[1]="//*[text()='Your Store']";
		SeleniumOperations.validationForMethod(input7);
		
	}

}
