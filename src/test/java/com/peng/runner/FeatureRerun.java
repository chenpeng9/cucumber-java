package com.peng.runner;


import com.cucumber.listener.ExtentCucumberFormatter;
import com.peng.functions.EnvironmentContext;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.peng.steps"},
        features = "@target/rerun.txt",
        plugin = {
                "pretty",
                "com.cucumber.listener.ExtentCucumberFormatter"}
)
public class FeatureRerun {
    @BeforeClass
    public static void writeReport() {
        EnvironmentContext environmentContext = new EnvironmentContext();
        String reportPath = environmentContext.getProperty("reportPath");
        ExtentCucumberFormatter.initiateExtentCucumberFormatter(new File(reportPath),false);
    }
}
