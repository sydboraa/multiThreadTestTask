package test.model;

import main.model.Person;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by sb on 24.12.2015.
 */
public class PersonTest {

    @Test
    public void testValidatePerson() {
        Person testPerson = new Person("testFirsName", "testLastName", 35, "deneme@deneme.com", true);
        assertEquals(testPerson.getEmaill(), "deneme@deneme.com");
        assertEquals(testPerson.getIsActive(), true);
    }

    @Test
    public void nullValuesOnPerson() {
        Person testPerson = new Person(null, null, 0, null, true);
        assertEquals(testPerson.getEmaill(), null);
        assertEquals(testPerson.getIsActive(), true);
    }

    @Test(expected=NullPointerException.class)
    public void nullPersonTryToGetEmail() {
        Person testPerson = null;
        testPerson.getEmaill();
    }

    @Test(expected=NullPointerException.class)
    public void nullPersonTryToSetEmail() {
        Person testPerson = null;
        testPerson.setEmail("testEmail@testEmail.com");
    }

    @Test
    public void setEmailTest() {
        Person testPerson = new Person("testFirsName", "testLastName", 35, "deneme@deneme.com", true);
        assertEquals(testPerson.getEmaill(), "deneme@deneme.com");
        testPerson.setEmail("newEmail@newEmail.com");
        assertEquals(testPerson.getEmaill(), "newEmail@newEmail.com");
    }

    @Test
    public void setIsActiveTest() {
        Person testPerson = new Person("testFirsName", "testLastName", 35, "deneme@deneme.com", true);
        assertEquals(testPerson.getIsActive(), true);
        testPerson.setActive(false);
        assertEquals(testPerson.getIsActive(), false);
    }

}
