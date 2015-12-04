package model;

import java.util.Date;
import java.util.List;

/**
 * Created by Sergey on 04.12.2015.
 */
public class EmailBuilder {
    private String subject; //тема
    private String from; //отправитель denis@gmail.com ; denis@ukr.net
    private String to; // получатель
    private Date sendDate;//дата отправки
    private String body; //текст письма
    private List<Attachment> attachments;

    EmailBuilder(){}

    public String getSubject() {
        return subject;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public String getBody() {
        return body;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public EmailBuilder subject(String subject) {
        this.subject = subject;
        return this;
    }

    public EmailBuilder from(String from) {
        this.from = from;
        return this;
    }

    public EmailBuilder to(String to) {
        this.to = to;
        return this;
    }

    public EmailBuilder sendDate(Date sendDate) {
        this.sendDate = sendDate;
        return this;
    }

    public EmailBuilder body(String body) {
        this.body = body;
        return this;
    }

    public EmailBuilder attachments(List<Attachment> attachments) {
        this.attachments = attachments;
        return this;
    }

    public Email build() {
        if(sendDate == null) {//установка значени€ по умолчанию
            this.sendDate = new Date();
        }
        return new Email(this);
    }
}

