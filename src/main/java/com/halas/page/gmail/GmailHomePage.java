package com.halas.page.gmail;

import com.halas.decorator.element.realisation.Button;
import com.halas.decorator.element.realisation.Image;
import com.halas.page.CommonPage;
import org.openqa.selenium.support.FindBy;

public class GmailHomePage extends CommonPage {
    @FindBy(id = "gm_dismiss_button")
    private Button openGmail;
    @FindBy(id = "gm_dismiss_button")
    private Button chooseDefaultView;
    @FindBy(id = "compose_button")
    private Button openComposeLayout;
    @FindBy(className = "android.widget.ImageButton")
    private Image openMenuGmail;
    @FindBy(xpath = "//*[text()='Чернетки']")
    private Button openDraftMessages;

    public void clickOnOpenGmail() {
        openGmail.click();
    }

    public void clickOnChooseDefaultView() {
        chooseDefaultView.click();
    }

    public void clickOnComposeButton() {
        openComposeLayout.click();
    }

    public void clickOnOpenMenuGmail() {
        openMenuGmail.click();
    }

    public void clickOnOpenGraftMessages() {
        openDraftMessages.click();
    }
}
