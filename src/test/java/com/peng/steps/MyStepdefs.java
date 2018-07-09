package com.peng.steps;

import com.peng.functions.CommonOperations;
import com.peng.functions.DriverFactory;
import com.peng.functions.EnvironmentContext;
import com.peng.functions.PageFileParser;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by PeChen on 3/14/17.
 */
public class MyStepdefs {
    private WebDriver driver = new DriverFactory().getDriver();
    private EnvironmentContext environmentContext = new EnvironmentContext();
    private PageFileParser page = new PageFileParser();
    private CommonOperations commonOperations = new CommonOperations();

    @When("^user inputs \"([^\"]*)\" in the field \"([^\"]*)\"$")
    public void userInputsInTheField(String keyword, String field) throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id(page.getElementSelector(field))).sendKeys(keyword);
    }

    @Then("^user click \"([^\"]*)\" button$")
    public void userClick(String field) throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(page.getElementSelector(field))).click();
    }

    @Then("^user should see \"([^\"]*)\" on the page$")
    public void userShouldSeeOnThePage(String text) throws Throwable {
        Assert.assertTrue(driver.getPageSource().contains(text));
    }

    @Given("^user lands on \"([^\"]*)\" home page$")
    public void userLandsOnHomePage(String homepage) throws Throwable {
        driver.get(environmentContext.getProperty(homepage+".url"));
        page.loadPage("home page");
    }

    @Then("^user should land on \"([^\"]*)\" page$")
    public void userShouldLandOnPage(String pageName) throws Throwable {
        page.loadPage(pageName);
        Assert.assertTrue(driver.getPageSource().contains(pageName));
    }

    @After
    public void afterScenario (Scenario scenario) {
        new DriverFactory().destoryDriver();
    }

    @Then("^user take a screenshot$")
    public void userTakeAScreenshot() throws Throwable {
        commonOperations.takeScreenshot(driver);
    }

    @Then("^user capture this page as \"([^\"]*)\" and save to \"([^\"]*)\"$")
    public void userCaptureThisPageAsAndSaveTo(String fileName, String filePath) throws Throwable {
        commonOperations.takeScreenshot(driver, filePath, fileName);
    }
}
