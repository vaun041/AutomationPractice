package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "Features"
,glue= {"glue"},
plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
monochrome = true
)
public class RunCucumber {

}
