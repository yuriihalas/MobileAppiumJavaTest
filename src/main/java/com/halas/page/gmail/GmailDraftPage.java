package com.halas.page.gmail;

import com.halas.decorator.element.realisation.Image;
import com.halas.decorator.element.realisation.TextView;
import com.halas.page.CommonPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GmailDraftPage extends CommonPage {
    private static final Logger LOG = LogManager.getLogger(GmailDraftPage.class);

    @FindBy(xpath = "//android.view.View[@resource-id='com.google.android.gm:id/thread_list_view']/android.view.View/android.view.View[1]")
    private List<TextView> messages;
    @FindBy(id = "edit_draft")
    private Image editImagePen;
    @FindBy(xpath = "//android.widget.ImageView")
    private Image settings;

    public void clickOnMessageWithGivenTime(String time) {
        LOG.info(String.format("method clickOnMessageWithGivenTime. with time:[%s]", time));
        getElementWithMessage(time).click();
    }

    public void clickOnEditDraftMessage() {
        editImagePen.click();
    }

    public void openSettings() {
        settings.click();
    }

    public void clickOnBackButton(){
        ((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    private TextView getElementWithMessage(String content) {
        return messages.stream().filter(e -> e.getElement().getAttribute("contentDescription")
                .contains(content)).findFirst().orElse(null);
    }
}
