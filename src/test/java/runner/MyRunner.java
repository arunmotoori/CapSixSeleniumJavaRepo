package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin={"html:target/cucumber_html_report.html"},
features="src/test/java/features",
glue="stepdefinitions",
tags="@all")
public class MyRunner extends AbstractTestNGCucumberTests{

}
