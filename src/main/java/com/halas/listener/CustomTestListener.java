package com.halas.listener;

import com.halas.util.MyDate;
import com.halas.util.TakeScreenshot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;

public class CustomTestListener extends TestListenerAdapter {
    private static final Logger LOG = LogManager.getLogger(CustomTestListener.class);
    private static final String PATH_TO_SAVE_SCREEN_FORMAT = "src/main/resources/screenshots/%s.png";

    @Override
    public void onTestFailure(ITestResult testResult) {
        outputErrors(testResult.getThrowable());
        String nameNewImg = testResult.getThrowable().getClass().getSimpleName() + MyDate.getCurrentDateTime();
        File outputFolder = new File(String.format(
                PATH_TO_SAVE_SCREEN_FORMAT, nameNewImg));
        TakeScreenshot.takeScreenshot(outputFolder);
    }

    private void outputErrors(Throwable throwable) {
        LOG.error("Test failed..");
        LOG.error("Class: " + throwable.getClass());
        LOG.error("Message: " + throwable.getMessage());
        LOG.error(throwable.getStackTrace());
    }
}
