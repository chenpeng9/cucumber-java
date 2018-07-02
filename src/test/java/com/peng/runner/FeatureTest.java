package com.peng.runner;


import com.cucumber.listener.Reporter;
import com.peng.functions.EnvironmentContext;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.peng.steps"},
        tags = {"@test"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
        "rerun:target/rerun.txt" }
)
public class FeatureTest {
    @AfterClass
    public static void writeReport() {
        EnvironmentContext environmentContext = new EnvironmentContext();
        String reportConfigPath = environmentContext.getProperty("reportConfigPath");
        Reporter.loadXMLConfig(new File(reportConfigPath));
    }


}
