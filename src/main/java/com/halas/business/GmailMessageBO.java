package com.halas.business;

import com.halas.model.Message;
import com.halas.page.gmail.GmailFormSendMessage;
import com.halas.page.gmail.GmailHomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GmailMessageBO {
    private static final Logger LOG = LogManager.getLogger(GmailMessageBO.class);
    private GmailFormSendMessage sendMessage;
    private GmailHomePage homePage;

    public GmailMessageBO() {
        sendMessage = new GmailFormSendMessage();
        homePage = new GmailHomePage();
    }

    public void openMessageActivityAndCreateDraftMessage(Message message) {
        LOG.info("openMessageActivityAndCreateDraftMessage");
        homePage.clickOnComposeButton();
        sendMessage.setReceiverLetterEmail(message.getTo());
        sendMessage.clickOnOpenCcAndBccFields();
        sendMessage.setReceiverCopyEmail(message.getCc());
        sendMessage.setReceiverHiddenCopyEmail(message.getBcc());
        sendMessage.setSubjectMessage(message.getSubject());
        sendMessage.setMessage(message.getMessage());
    }

    public void goToDraftMessage() {
        sendMessage.goBackToPreviousPage();
        homePage.clickOnOpenMenuGmail();
        homePage.clickOnOpenGraftMessages();
    }
}
