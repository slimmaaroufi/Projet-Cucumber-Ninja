package runner;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features"},
		plugin = {"pretty","html:target/cucumber-report.html"}, //les rapports
		//tags = ("@login"),
		publish=true,
		glue= {"stepdefinitions","hooks"},
		//{"src/test/java/com/e2etest/automation/step_definitions"},//nesta3mlouha ki yebdew mch meme niveau m3a class RUN
		monochrome = true, // ynathem elconsole
		snippets = CAMELCASE)

public class TestRunner {

}
