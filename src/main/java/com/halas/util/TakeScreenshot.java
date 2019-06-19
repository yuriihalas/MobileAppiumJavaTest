package com.halas.util;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static com.halas.driver.WebDriverManager.getWebDriver;

public final class TakeScreenshot {
    private static final Logger LOG = LogManager.getLogger(TakeScreenshot.class);

    private TakeScreenshot() {
    }

    public static void takeScreenshot(File outputDirectory) {
        try {
            File scrFile = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, outputDirectory);
            LOG.info("Screenshot taken.");
        } catch (IOException e) {
            LOG.error("Can't save screenshot file, in takeScreenshot, maybe bad directory path..");
            LOG.error("Class: " + e.getClass());
            LOG.error("Message: " + e.getMessage());
            LOG.error(e.getStackTrace());
        }
    }
}
