package com.halas.business;

import com.halas.page.gmail.GmailHomePage;
import com.halas.page.gmail.GmailWelcomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GmailAuthorisationBO {
    private static final Logger LOG = LogManager.getLogger(GmailMessageBO.class);
    private GmailWelcomePage welcomePage;
    private GmailHomePage homePage;

    public GmailAuthorisationBO() {
        welcomePage = new GmailWelcomePage();
        homePage = new GmailHomePage();
    }

    public void authoriseUserAndCloseAllAlerts(final String login) {
        welcomePage.clickOnWelcomeButton();
        welcomePage.isUserAuthorized(login);
        welcomePage.clickOnGoToGmail();
        homePage.clickOnOpenGmail();
        homePage.clickOnChooseDefaultView();
    }
}
