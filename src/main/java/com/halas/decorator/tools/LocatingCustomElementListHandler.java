package com.halas.decorator.tools;

import com.halas.decorator.element.CommonElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class LocatingCustomElementListHandler
        implements InvocationHandler {
    private final ElementLocator locator;
    private final Class<CommonElement> clazz;

    public LocatingCustomElementListHandler(ElementLocator locator,
                                            Class<CommonElement> clazz) {
        this.locator = locator;
        this.clazz = clazz;
    }

    public Object invoke(Object object, Method method,
                         Object[] objects) throws Throwable {
        // Found a list of WebElement and handles each of its elements,
        // return new list with elements of this custom class
        List<WebElement> elements = locator.findElements();
        List<CommonElement> customs = new ArrayList<>();
        for (WebElement element : elements) {
            customs.add(WrapperFactory.createInstance(clazz, element));
        }
        try {
            return method.invoke(customs, objects);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }
}