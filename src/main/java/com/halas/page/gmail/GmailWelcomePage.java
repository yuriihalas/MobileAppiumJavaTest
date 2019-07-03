package com.halas.page.gmail;

import com.halas.decorator.element.realisation.Button;
import com.halas.decorator.element.realisation.TextView;
import com.halas.page.CommonPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class GmailWelcomePage extends CommonPage {
    private static final Logger LOG = LogManager.getLogger(GmailWelcomePage.class);

    @FindBy(id = "welcome_tour_got_it")
    private Button welcomeButton;
    @FindBy(id = "action_done")
    private Button goToGmail;
    @FindBy(id = "account_address")
    private List<TextView> usersEmails;
    @FindBy(id = "setup_addresses_list")
    private TextView usersInfo;

    public void clickOnWelcomeButton() {
        LOG.info("method clickOnWelcomeButton.");
        driverWait.until(ExpectedConditions.visibilityOf(welcomeButton.getElement()));
        driverWait.until(ExpectedConditions.elementToBeClickable(welcomeButton.getElement()));
        welcomeButton.click();
    }

    public void clickOnGoToGmail() {
        LOG.info("method clickOnGoToGmail.");
        goToGmail.click();
    }

    public boolean isUserAuthorized(String email) {
        LOG.info("method isUserAuthorized.");
        waitUntilNotLoadedAllUsers();
        return usersEmails.stream().anyMatch(a -> a.getText().equals(email));
    }

    private void waitUntilNotLoadedAllUsers() {
        driverWait.until(ExpectedConditions.visibilityOf(usersInfo.getElement()));
    }
}
