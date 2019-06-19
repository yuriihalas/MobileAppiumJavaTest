package com.halas.page.gmail;

import com.halas.decorator.element.realisation.Button;
import com.halas.decorator.element.realisation.EditText;
import com.halas.page.CommonPage;
import org.openqa.selenium.support.FindBy;

public class GmailFormSendMessage extends CommonPage {
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
        receiverLetterEmail.sendKeys(email);
    }

    public void setReceiverCopyEmail(String email) {
        receiverCopyEmail.sendKeys(email);
    }

    public void setReceiverHiddenCopyEmail(String email) {
        receiverHiddenCopyEmail.sendKeys(email);
    }

    public void setSubjectMessage(String subject) {
        subjectMessage.sendKeys(subject);
    }

    public void setMessage(String message) {
        this.message.sendKeys(message);
    }

    public String getTextReceiverLetterEmail() {
        return receiverLetterEmail.getText();
    }

    public String getTextReceiverCopyEmail() {
        return receiverCopyEmail.getText();
    }

    public String getTextReceiverHiddenCopyEmail() {
        return receiverHiddenCopyEmail.getText();
    }

    public String getTextSubjectMessage() {
        return subjectMessage.getText();
    }

    public String getTextMessage() {
        return message.getText();
    }

    public void clickOnOpenCcAndBccFields() {
        openCcAndBccFields.click();
    }

    public void goBackToPreviousPage() {
        previousActivity.click();
    }
}
