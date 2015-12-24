import model.Email;
import model.Person;
import service.EmailService;
import service.PersonService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sb on 24.12.2015.
 */
public class Application {

    public static void main(String [] args) throws Exception {
        //creating some emails
        List<Email> emailList = getSomeEmails();

        //getting persons from file
        PersonService personService = new PersonService();
        List<Person> personList = personService.getPersonsFromFile();

        //Emails are sending simultaneously
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<EmailService> myCallables = new ArrayList<>();

        for(Email email: emailList) {
            //If system is designed for a huge environment, personList can design using cursor.
            //because, millions of person information cannot hold in a list
            for (Person person : personList) {
                if (person.getIsActive()) {
                    myCallables.add(new EmailService(email, person));
                }
            }
        }

        executor.invokeAll(myCallables);
        executor.shutdown();

        System.out.println("Completed email sending!");
    }

    public static List<Email> getSomeEmails() {
        Person sender = new Person("Seyda", "Benzer", 25, "seydaborabenzer@gmail.com", true);
        List<Email> emailList = new ArrayList<>();
        Email email1 = new Email(sender, "subject1", "content1");
        Email email2 = new Email(sender, "subject2", "content2");
        Email email3 = new Email(sender, "subject3", "content3");
        Email email4 = new Email(sender, "subject4", "content4");
        Email email5 = new Email(sender, "subject5", "content5");
        Email email6 = new Email(sender, "subject6", "content6");
        Email email7 = new Email(sender, "subject7", "content7");
        Email email8 = new Email(sender, "subject8", "content8");
        emailList.add(email1);
        emailList.add(email2);
        emailList.add(email3);
        emailList.add(email4);
        emailList.add(email5);
        emailList.add(email6);
        emailList.add(email7);
        emailList.add(email8);
        return emailList;
    }
}
