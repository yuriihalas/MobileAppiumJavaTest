package com.halas.driver;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static com.halas.util.parser.JsonParser.getBaseUrl;
import static com.halas.util.property.HandleProperty.getValueProperty;

public final class WebDriverManager {
    private static final Logger LOG = LogManager.getLogger(WebDriverManager.class);
    private static final ThreadLocal<WebDriver> DRIVER_POOL = new ThreadLocal<>();

    private WebDriverManager() {
    }

    public static WebDriver getWebDriver() {
        if (Objects.isNull(DRIVER_POOL.get())) {
            createWebDriver();
        }
        return DRIVER_POOL.get();
    }

    public static void shutdown() {
        DRIVER_POOL.get().quit();
        DRIVER_POOL.set(null);
    }

    private static void createWebDriver() {
        DRIVER_POOL.set(getDriver());
    }

    private static WebDriver getDriver() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "HUAWEI TIT-U02");
        cap.setCapability("udid", "TCY9KA9640903417");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "5.1");
        cap.setCapability("appPackage", "com.google.android.gm");
        cap.setCapability("appActivity", "com.google.android.gm.ConversationListActivityGmail");
        cap.setCapability("unicodeKeyboard", "true");
        cap.setCapability("resetKeyboard", "true");

        AndroidDriver driver = new AndroidDriver(Objects.requireNonNull(getURL()), cap);
        driver.manage()
                .timeouts()
                .implicitlyWait(Integer.valueOf(getValueProperty("implicit-wait-time")), TimeUnit.SECONDS);
        return driver;
    }

    private static URL getURL() {
        try {
            return new URL(getBaseUrl());
        } catch (MalformedURLException e) {
            LOG.error("Bad URL.. Error.");
            e.printStackTrace();
        }
        return null;
    }
}
