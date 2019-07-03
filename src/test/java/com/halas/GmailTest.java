package com.halas;

import com.halas.business.GmailAuthorisationBO;
import com.halas.business.GmailMessageBO;
import com.halas.driver.WebDriverManager;
import com.halas.listener.CustomTestListener;
import com.halas.model.Message;
import com.halas.page.gmail.GmailDraftPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import java.util.Iterator;
import java.util.stream.Stream;

import static com.halas.util.parser.JsonParser.*;

@Listeners({CustomTestListener.class})
public class GmailTest {
    private static final Logger LOG = LogManager.getLogger(GmailTest.class);
    private static final int AMOUNT_USERS = 1;

    @DataProvider(parallel = true)
    public Iterator<Object[]> usersLoginPassword() {
        return Stream.of(getUsers(AMOUNT_USERS)).iterator();
    }

    @Test(dataProvider = "usersLoginPassword")
    void testSingInAndGoToSavedMessageAndCheckCorrectAndSendMess(String login) throws InterruptedException {
        LOG.info("testSingInAndGoToSavedMessageAndCheckCorrectAndSendMess");
        GmailAuthorisationBO authorisationBO = new GmailAuthorisationBO();
        authorisationBO.authoriseUserAndCloseAllAlerts(login);

        Message message = new Message(getWhoReceiveMessage(), getWhoReceiveCopyMessage(), getWhoReceiveHiddenCopyMessage(), getThemeMessage(), getMessage());
        GmailMessageBO messageBO = new GmailMessageBO();
        messageBO.openMessageActivityAndCreateDraftMessage(message);
        messageBO.goToPreviouslyCreatedDraftMessage();
    }

    @AfterMethod
    void closeResources() {
        WebDriverManager.shutdown();
    }
}
