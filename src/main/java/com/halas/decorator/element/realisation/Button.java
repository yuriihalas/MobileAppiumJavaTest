package com.halas.decorator.element.realisation;

import com.halas.decorator.element.CommonElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class Button extends CommonElement {
    private static final Logger LOG = LogManager.getLogger(Button.class);

    public Button(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        LOG.info("method click.");
        webElement.click();
    }

    public boolean isDisplayed() {
        LOG.info("method isDisplayed.");
        return webElement.isDisplayed();
    }
}
