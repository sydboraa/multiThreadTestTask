package main.model;

/**
 * Created by sb on 24.12.2015.
 */
public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private boolean isActive;

    public Person(String firstName,
                  String lastName,
                  int age,
                  String email,
                  boolean isActive) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setEmail(email);
        setActive(isActive);
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmaill() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

}

