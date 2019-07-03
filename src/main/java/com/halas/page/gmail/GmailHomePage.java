package com.halas.page.gmail;

import com.halas.decorator.element.realisation.Button;
import com.halas.decorator.element.realisation.EditText;
import com.halas.page.CommonPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class GmailHomePage extends CommonPage {
    private static final Logger LOG = LogManager.getLogger(GmailHomePage.class);
    private static final String GO_TO_DRAFT = "label:draft";

    @FindBy(id = "gm_dismiss_button")
    private Button openGmail;
    @FindBy(id = "gm_dismiss_button")
    private Button chooseDefaultView;
    @FindBy(id = "compose_button")
    private Button composeLayout;
    @FindBy(id = "open_search_bar_text_view")
    private EditText draftMessages;

    public void clickOnOpenGmail() {
        LOG.info("method clickOnOpenGmail.");
        openGmail.click();
    }

    public void clickOnChooseDefaultView() {
        LOG.info("method clickOnChooseDefaultView.");
        chooseDefaultView.click();
    }

    public void clickOnComposeButton() {
        LOG.info("method clickOnComposeButton.");
        composeLayout.click();
    }

    public void openGraftMessages() {
        LOG.info("method openGraftMessages.");
        draftMessages.sendKeys(GO_TO_DRAFT);
        ((AndroidDriver) (driver)).pressKeyCode(AndroidKeyCode.ENTER);
    }
}
