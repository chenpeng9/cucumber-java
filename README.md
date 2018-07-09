# cucumber-java
![](cucumber.png?raw=true)

For UI automation test framework - hope this one is enough if you are using java.

This framework is based on cucumber-java and selenium-java, try to let it more stable and have enough functions to do the web-UI testing.

## Existing Feature
1. Basic funcitons about Cucumber;
2. PageObject
3. Properties management
4. Integrate with Cucumber-Extend reports
5. Rerun failed scenarios
6. Take full screenshots
7. Take fail step screenshots and embed to report

## In Progress Feature List
1. WaitUntil : before error happening, wait few seconds and keep retry.
2. Take Full Screenshot whenever you want. -- Done
3. Take screenshot when error occur. -- Done
4. Friendly test report.   -- Done.
5. support cssSelector\xPath\id
6. Parallel execute test.
7. Integrate with BrowserStack
8. Rerun failed scenarios  -- Done
...

# Functions
## Rerun Failed Scenarios
If you just want to run the failed scenarios manually, Please execute this file: 
```cmd
FeatureRerun.java
```

If you are running on pipeline, please use this command:
```cmd
$ gradle clean test
```
the failed scenarios will be run again, and the temporary result will be ignored. Only rerun failed the build will be marked as failed.

## Report
you can change your report path in this file:
```cmd
environment.properties -> reportPath
```

if you want rewrite the existing report, put "ture" for the second parameter:
```java
ExtentCucumberFormatter.initiateExtentCucumberFormatter(new File(reportPath),true);
```

## Take Full ScreenShot
This function is basing on AShot plugin. You can take a full screenshots whenever you want.

Using this cmd then it will capture current screen and embed to report:
```cucumber
Then user take a screenshot
```

Using following cmd then you capture current screen and save to somewhere:
```cucumber
Then user capture this page as "screenshotName" and save to "Path"
```


# Notice
1. please make sure your java version is greater than 1.8.152


