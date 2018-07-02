package com.peng.functions;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by PeChen on 3/14/17.
 */
public class DriverFactory {
    protected static WebDriver driver;
    private final EnvironmentContext environmentContext = new EnvironmentContext();

    public DriverFactory() {
        initialize();
    }

    public void initialize() {
        if (driver == null) {
            createNewDriverInstance();
        }
    }

    private void createNewDriverInstance() {
        ChromeOptions chromeOptions = new ChromeOptions();
        if (environmentContext.hasProperty("chrome.parameters")) {
            String chromeProperty = environmentContext.getProperty("chrome.parameters");
            chromeOptions.addArguments(Lists.newArrayList(chromeProperty.split(",")));
        }
        driver = new ChromeDriver(chromeOptions);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void destoryDriver() {
        driver.quit();
        driver = null;
    }

    @Test
    public void testCreateNewDriverInstance() throws Exception {
        DriverFactory driverFactory = new DriverFactory();
        driverFactory.initialize();
    }
}
