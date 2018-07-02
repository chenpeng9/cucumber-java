package com.peng.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.peng.steps"},
        features = "@target/rerun.txt",
        plugin = {"pretty",
        "html:target/cucumber-reports",
        "json:target/cucumber.json",
        "rerun:target/rerun.txt" }
)
public class FeatureRerun {

}
