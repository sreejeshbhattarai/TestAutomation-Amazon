package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/Features"}, 
		glue = {"StepDefinitions"},
		plugin = {"summary",
				 "html:target/TestReports/html/report.html",
				 "json:target/TestReports/json/report.json",
				 "junit:target/TestReports/junit/report.xml"}	
		)

public class TestRunner {

}
