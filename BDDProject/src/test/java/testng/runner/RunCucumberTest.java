package testng.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/resources/Features",
glue = { "commun","pages","stepDefinitions",
		"testng.runner" }, plugin = { "pretty", "html:target/HtmlReports/index.html",
				"json:target/JsonReports/report.json",
				"junit:target/JUnitReports/report.xml" }, monochrome = true)

public class RunCucumberTest extends AbstractTestNGCucumberTests{

}