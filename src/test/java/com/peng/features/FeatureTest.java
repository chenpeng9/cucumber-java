package com.peng.features;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.peng.steps"},
        tags = {"@test"},
        plugin = {"pretty",
        "html:target/cucumber-reports",
        "json:target/cucumber.json",
        "rerun:target/rerun.txt" }
)
public class FeatureTest {

}
