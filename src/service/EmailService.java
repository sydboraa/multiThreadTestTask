package service;

import model.Email;
import model.Person;
import java.util.concurrent.Callable;

/**
 * Created by sb on 24.12.2015.
 */
public class EmailService implements Callable<Email> {

    private Email email;
    private Person receiver;

    public EmailService(Email email, Person receiver) {
        this.email = email;
        this.receiver = receiver;
    }

    public Email call() throws Exception {
        return sendEmail(this.email, this.receiver);
    }

    public Email sendEmail(Email email, Person receiver) {
        System.out.println("The " + email.getSubject() + " email was sent to " + receiver.getEmaill());
        return email;
    }

}
