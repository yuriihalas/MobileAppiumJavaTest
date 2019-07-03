package com.halas.page.gmail;

import com.halas.decorator.element.realisation.Button;
import com.halas.decorator.element.realisation.EditText;
import com.halas.page.CommonPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class GmailFormSendMessage extends CommonPage {
    private static final Logger LOG = LogManager.getLogger(GmailFormSendMessage.class);

    @FindBy(id = "to")
    private EditText receiverLetterEmail;
    @FindBy(id = "cc")
    private EditText receiverCopyEmail;
    @FindBy(id = "bcc")
    private EditText receiverHiddenCopyEmail;
    @FindBy(id = "subject")
    private EditText subjectMessage;
    @FindBy(id = "wc_body_layout")
    private EditText message;
    @FindBy(id = "add_cc_bcc")
    private Button openCcAndBccFields;
    @FindBy(className = "android.widget.ImageButton")
    private Button previousActivity;

    public void setReceiverLetterEmail(String email) {
        LOG.info("method setReceiverLetterEmail.");
        receiverLetterEmail.sendKeys(email);
    }

    public void setReceiverCopyEmail(String email) {
        LOG.info("method setReceiverCopyEmail.");
        receiverCopyEmail.sendKeys(email);
    }

    public void setReceiverHiddenCopyEmail(String email) {
        LOG.info("method setReceiverHiddenCopyEmail.");
        receiverHiddenCopyEmail.sendKeys(email);
    }

    public void setSubjectMessage(String subject) {
        LOG.info("method setSubjectMessage.");
        subjectMessage.sendKeys(subject);
    }

    public void setMessage(String message) {
        LOG.info("method setMessage.");
        this.message.sendKeys(message);
    }

    public String getReceiverLetterEmail() {
        LOG.info("method getReceiverLetterEmail.");
        return receiverLetterEmail.getText();
    }

    public String getReceiverCopyEmail() {
        LOG.info("method getReceiverCopyEmail.");
        return receiverCopyEmail.getText();
    }

    public String getReceiverHiddenCopyEmail(String email) {
        LOG.info("method getReceiverHiddenCopyEmail.");
        return receiverHiddenCopyEmail.getText();
    }

    public String getSubjectMessage(String subject) {
        LOG.info("method getSubjectMessage.");
        return subjectMessage.getText();
    }

    public String getMessage(String message) {
        LOG.info("method getMessage.");
        return "";
    }

    public void clickOnOpenCcAndBccFields() {
        LOG.info("method clickOnOpenCcAndBccFields.");
        openCcAndBccFields.click();
    }

    public void goBackToPreviousPage() {
        LOG.info("method goBackToPreviousPage.");
        previousActivity.click();
    }
}
