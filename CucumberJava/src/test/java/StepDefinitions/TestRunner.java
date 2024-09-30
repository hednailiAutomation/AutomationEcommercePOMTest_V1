package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//resources//Features//login.feature", glue = {
		"StepDefinitions","Hooks" }, monochrome = true, plugin = { "pretty", "html:target/HtmlReports/index.html",
				"json:target/JsonReports/report.json", "junit:target/JUnitReports/report.xml" })

public class TestRunner {

}



