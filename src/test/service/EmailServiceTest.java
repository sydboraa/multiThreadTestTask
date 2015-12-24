package test.service;

import main.model.Email;
import main.model.Person;
import main.service.EmailService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sb on 24.12.2015.
 */
public class EmailServiceTest {

    @Test
    public void testSendEmail() {
        Person testSender = new Person("testFirsName", "testLastName", 35, "deneme@deneme.com", true);
        Person testReceiver= new Person("testReceiverFirsName", "testReceiverLastName", 35, "deneme@deneme.com", true);
        Email testEmail = new Email(testSender, "testSubject", "testContent");
        EmailService emailService = new EmailService(testEmail, testReceiver);
        assertEquals(emailService.sendEmail(testEmail, testReceiver), testEmail);
    }

    @Test(expected=NullPointerException.class)
    public void testSendEmailWithNullEmailParam() {
        Person testReceiver= new Person("testReceiverFirsName", "testReceiverLastName", 35, "deneme@deneme.com", true);
        EmailService emailService = new EmailService(null, testReceiver);
        emailService.sendEmail(null, testReceiver);
    }

    @Test(expected=NullPointerException.class)
    public void testSendEmailWithNullPersonParam() {
        Person testSender = new Person("testFirsName", "testLastName", 35, "deneme@deneme.com", true);
        Email testEmail = new Email(testSender, "testSubject", "testContent");
        EmailService emailService = new EmailService(testEmail, null);
        emailService.sendEmail(testEmail, null);
    }
}
