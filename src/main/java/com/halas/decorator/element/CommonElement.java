package com.halas.decorator.element;

import org.openqa.selenium.WebElement;

public abstract class CommonElement {
    protected WebElement webElement;

    public CommonElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public WebElement getElement() {
        return webElement;
    }
}
