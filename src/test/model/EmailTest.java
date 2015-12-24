package test.model;

import main.model.Email;
import main.model.Person;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sb on 24.12.2015.
 */
public class EmailTest {

    @Test
    public void testValidateEmail() {
        Person testSender = new Person("senderFirsName", "senderLastName", 35, "deneme@deneme.com", true);
        Email testEmail = new Email(testSender, "testSubject", "testContent");
        assertEquals(testEmail.getContent(), "testContent");
        assertEquals(testEmail.getSubject(), "testSubject");
    }

    @Test
    public void nullValuesOnEmail() {
        Email testEmail = new Email(null, null, null);
        assertEquals(testEmail.getContent(), null);
        assertEquals(testEmail.getSubject(), null);
    }

    @Test(expected=NullPointerException.class)
    public void nullEmailTryToGetSubject() {
        Email testEmail = null;
        testEmail.getSubject();
    }

    @Test(expected=NullPointerException.class)
    public void nullEmailTryToGetContent() {
        Email testEmail = null;
        testEmail.getContent();
    }

    @Test(expected=NullPointerException.class)
    public void nullEmailTryToSetSubject() {
        Email testEmail = null;
        testEmail.setSubject("testSubject");
    }

    @Test(expected=NullPointerException.class)
    public void nullEmailTryToSetContent() {
        Email testEmail = null;
        testEmail.setContent("testContent");
    }

    @Test(expected=NullPointerException.class)
    public void nullEmailTryToSetSender() {
        Email testEmail = null;
        testEmail.setSender(new Person("testFirsName", "testLastName", 35, "deneme@deneme.com", true));
    }

    @Test
    public void setEmailContentTest() {
        Person testSender = new Person("senderFirsName", "senderLastName", 35, "deneme@deneme.com", true);
        Email testEmail = new Email(testSender, "testSubject", "testContent");
        assertEquals(testEmail.getContent(), "testContent");
        testEmail.setContent("newContent");
        assertEquals(testEmail.getContent(), "newContent");
    }

    @Test
    public void setEmailSubjectTest() {
        Person testSender = new Person("senderFirsName", "senderLastName", 35, "deneme@deneme.com", true);
        Email testEmail = new Email(testSender, "testSubject", "testContent");
        assertEquals(testEmail.getSubject(), "testSubject");
        testEmail.setSubject("newSubject");
        assertEquals(testEmail.getSubject(), "newSubject");
    }
}
