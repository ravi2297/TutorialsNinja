package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions

		(
			plugin = "pretty",
			features="src/test/resources/BUSINESS_LOGIC/CUCUMBER_SUITES",
			tags= "@SmokeTest",
			glue="cucumbermap",
			monochrome=true		
		)

public class Test
{
	








}