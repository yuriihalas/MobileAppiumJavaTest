package com.halas.decorator.tools;

import com.halas.decorator.element.CommonElement;
import org.openqa.selenium.WebElement;


public class WrapperFactory {

    /**
     * Create instance,
     * implemented IElement,
     * invoke constructor with arguments WebElement
     */
    public static CommonElement createInstance(Class<CommonElement> clazz,
                                                                  WebElement element) {
        try {
            return clazz.getConstructor(WebElement.class).
                    newInstance(element);
        } catch (Exception e) {
            throw new AssertionError(
                    "WebElement can't be represented as " + clazz
            );
        }
    }
}