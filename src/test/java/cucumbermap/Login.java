package cucumbermap;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import methods.HTMLReportGenerator;
import methods.SeleniumOperations;
import plainTestCase.UnitTestCase;

public class Login {
	public static WebDriver driver;
	
	@Given("user open chrome browser with exe as {string}")
	public void user_open_chrome_browser_with_exe_as(String exe) {
		Object[] input=new Object[2];
		input[0]="chrome";
		input[1]="D:\\Software Testing\\TutorialsNinja\\TutorialsNinja\\src\\test\\resources\\DRIVERS\\chromedriver.exe";
		Hashtable<String,Object> output=SeleniumOperations.openBrowser(input);
		HTMLReportGenerator.StepDetails(output.get("STATUS").toString(), "user open chrome browser with exe as {string}", output.get("MESSAGE").toString());
	}

	@Given("user open url as {string}")
	public void user_open_url_as(String url) {
		Object[] input1=new Object[1];
		input1[0]="http://tutorialsninja.com/demo/";
		Hashtable<String,Object> output1= SeleniumOperations.openUrl(input1);
		HTMLReportGenerator.StepDetails(output1.get("STATUS").toString(), "user open url as {string}", output1.get("MESSAGE").toString());

	}

	@Given("user click on My Account")
	public void user_click_on_my_account() {
		Object[] input2=new Object[1];
		input2[0]="//*[text()='My Account']";
		Hashtable<String,Object> output2=SeleniumOperations.clickMethod(input2);
		HTMLReportGenerator.StepDetails(output2.get("STATUS").toString(), "user click on My Account", output2.get("MESSAGE").toString());

	}

	@Given("user click on Login button")
	public void user_click_on_login_button() {
		Object[] input3=new Object[1];
		input3[0]="//*[text()='Login']";
		Hashtable<String,Object> output3= SeleniumOperations.clickMethod(input3);
		HTMLReportGenerator.StepDetails(output3.get("STATUS").toString(), "user click on Login button", output3.get("MESSAGE").toString());

	}

	@When("user enter {string} as username")
	public void user_enter_as_username(String text) {
		Object[] input4=new Object[2];
		input4[0]="//*[@name='email']";
		input4[1]=text;
		Hashtable<String,Object> output4=SeleniumOperations.sendTextMethod(input4);
		HTMLReportGenerator.StepDetails(output4.get("STATUS").toString(), "user enter {string} as username", output4.get("MESSAGE").toString());

	}

	@When("user enter {string} as password")
	public void user_enter_as_password(String text) {
		Object[] input5=new Object[2];
		input5[0]="//*[@name='password']";
		input5[1]=text;
		Hashtable<String,Object> output5=SeleniumOperations.sendTextMethod(input5);
		HTMLReportGenerator.StepDetails(output5.get("STATUS").toString(), "user enter {string} as password", output5.get("MESSAGE").toString());

	}

	@When("user click on Login")
	public void user_click_on_login() {
		Object[] input6=new Object[1];
		input6[0]="//*[@value='Login']";
		Hashtable<String,Object> output6=SeleniumOperations.clickMethod(input6);
		HTMLReportGenerator.StepDetails(output6.get("STATUS").toString(), "user click on Login", output6.get("MESSAGE").toString());

	}
	
	@Then("user is logged in successfully")
	public void user_is_logged_in_successfully() {
		Object[] input7=new Object[2];
		input7[0]="Your Store";
		input7[1]="//*[text()='Your Store']";
		Hashtable<String,Object> output7=SeleniumOperations.validationForMethod(input7);
		HTMLReportGenerator.StepDetails(output7.get("STATUS").toString(), "user is logged in successfully", output7.get("MESSAGE").toString());

	}
}
