package com.halas.decorator.element.realisation;

import com.halas.decorator.element.CommonElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class EditText extends CommonElement {
    private static final Logger LOG = LogManager.getLogger(EditText.class);

    public EditText(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(String text) {
        LOG.info("method sendKeys.");
        webElement.sendKeys(text);
    }

    public void click() {
        LOG.info("method click.");
        webElement.click();
    }

    public String getText() {
        LOG.info("method getText.");
        return webElement.getText();
    }
}
