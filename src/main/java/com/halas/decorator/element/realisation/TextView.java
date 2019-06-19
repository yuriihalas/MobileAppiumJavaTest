package com.halas.decorator.element.realisation;

import com.halas.decorator.element.CommonElement;
import org.openqa.selenium.WebElement;

public class TextView extends CommonElement {
    public TextView(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        webElement.click();
    }

    public String getText() {
        return webElement.getText();
    }
}
