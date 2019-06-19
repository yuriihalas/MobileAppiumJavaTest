package com.halas.decorator.element.realisation;

import com.halas.decorator.element.CommonElement;
import org.openqa.selenium.WebElement;

public class Button extends CommonElement {
    public Button(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        webElement.click();
    }

    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }
}
