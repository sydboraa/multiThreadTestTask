package service;

import model.Email;
import model.Person;
import java.util.Random;
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
        try {
            /*
            *  I added this code block because, I want to simulate the network latency while sending email.
            * */
            Random random = new Random();
            int randomSleepTime = random.nextInt(200 - 1 + 1) + 1;
            Thread.sleep(randomSleepTime);
            /* end of simulation*/

            System.out.println("Subject: " + email.getSubject() + " Content: " + email.getContent() + " Receiver: " + receiver.getEmaill());
            return email;
        } catch (InterruptedException ex) {
            System.out.println("Email cannot sent! " + ex.getMessage());
            return email;
        }
    }

}
