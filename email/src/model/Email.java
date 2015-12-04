package model;

import java.util.Date;
import java.util.List;

/**
 * Created by Sergey on 04.12.2015.
 */
public class Email {
    private final String subject; //тема
    private final String from; //отправитель denis@gmail.com ; denis@ukr.net
    private final String to; // получатель
    private final Date sendDate;//дата отправки
    private final String body; //текст письма
    private final List<Attachment> attachments;

    public static EmailBuilder newBuilder() {
        return new EmailBuilder();
    }

    Email(EmailBuilder emailBuilder) {
        this.attachments = emailBuilder.getAttachments();
        this.body = emailBuilder.getBody();
        this.from = emailBuilder.getFrom();
        this.sendDate = emailBuilder.getSendDate();
        this.to = emailBuilder.getTo();
        this.subject = emailBuilder.getSubject();
    }

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
}

