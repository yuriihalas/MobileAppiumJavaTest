package com.halas.decorator.element.realisation;

import com.halas.decorator.element.CommonElement;
import org.openqa.selenium.WebElement;

public class EditText extends CommonElement {
    public EditText(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(String text) {
        webElement.sendKeys(text);
    }

    public void click() {
        webElement.click();
    }

    public String getText() {
        return webElement.getText();
    }
}
