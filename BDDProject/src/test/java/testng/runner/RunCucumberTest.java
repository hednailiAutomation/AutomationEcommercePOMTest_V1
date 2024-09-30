package testng.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//resources//Features", glue = {"commun","pages","stepDefinitions" ,"testng.runner" }, plugin = { "pretty","html:target/HtmlReports/index.html","json:target/JsonReports/report.json","junit:target/JUnitReports/report.xml" },
		monochrome = true,
		tags = "@InvalidCredentials1 or @InvalidCredentials2 or @InvalidCredentials3 or @InvalidCredentials4 or @ValidCredentials")

public class RunCucumberTest  {

}
