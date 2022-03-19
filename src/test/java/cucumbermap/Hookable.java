package cucumbermap;

import java.net.UnknownHostException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import methods.HTMLReportGenerator;

public class Hookable {
	
	@Before
	public void before(Scenario scenario) throws UnknownHostException
	{
		HTMLReportGenerator.TestSuiteStart("D:\\Software Testing\\TutorialsNinja\\TutorialsNinja\\target\\htmlreport.html", "tutorialNinjaProject");
		HTMLReportGenerator.TestCaseStart(scenario.getName(), scenario.getStatus());
		System.out.println("--------------------------scenario starts---------------------------");
	}
	
	
	@After
	public void after(Scenario scenario)
	{
		HTMLReportGenerator.TestCaseEnd();
		HTMLReportGenerator.TestSuiteEnd();
		System.out.println("--------------------------scenario ends---------------------------");
	}

}
