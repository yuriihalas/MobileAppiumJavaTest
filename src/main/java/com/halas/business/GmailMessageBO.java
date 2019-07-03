package com.halas.business;

import com.halas.model.Message;
import com.halas.page.gmail.GmailDraftPage;
import com.halas.page.gmail.GmailFormSendMessage;
import com.halas.page.gmail.GmailHomePage;
import com.halas.util.MyDate;

public class GmailMessageBO {
    private GmailFormSendMessage sendMessage;
    private GmailHomePage homePage;
    private GmailDraftPage draftPage;
    private String timeCreatedDraftMessage;

    public GmailMessageBO() {
        sendMessage = new GmailFormSendMessage();
        homePage = new GmailHomePage();
        draftPage = new GmailDraftPage();
    }

    public void openMessageActivityAndCreateDraftMessage(Message message) {
        homePage.clickOnComposeButton();
        sendMessage.setReceiverLetterEmail(message.getTo());
        sendMessage.clickOnOpenCcAndBccFields();
        sendMessage.setReceiverCopyEmail(message.getCc());
        sendMessage.setReceiverHiddenCopyEmail(message.getBcc());
        sendMessage.setSubjectMessage(message.getSubject());
        sendMessage.setMessage(message.getMessage());
        sendMessage.goBackToPreviousPage();
        timeCreatedDraftMessage = MyDate.getCurrentTimeHoursMinutes();
    }

    public void goToPreviouslyCreatedDraftMessage() {
        homePage.openGraftMessages();
        draftPage.clickOnMessageWithGivenTime(timeCreatedDraftMessage);
        draftPage.openSettings();
        draftPage.clickOnBackButton();
        draftPage.clickOnEditDraftMessage();
    }
}
