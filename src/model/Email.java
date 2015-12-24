package model;

import java.util.List;

/**
 * Created by sb on 24.12.2015.
 */
public class Email {

    private Person sender;
    private String subject;
    private String content;
    private Person receiver;

    public Email(Person sender,
                 String subject,
                 String content) {
        setSender(sender);
        setSubject(subject);
        setContent(content);
    }


    public void setSender(Person sender) {
        this.sender = sender;
    }

    public String getContent() { return content; }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


}
