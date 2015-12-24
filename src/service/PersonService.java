package service;

import model.Person;

import java.util.List;

/**
 * Created by sb on 24.12.2015.
 */
public class PersonService {

    public List<Person> getPersonsFromFile() {
        FileService fileService = new FileService();
        List<Person> personList = fileService.readFile("src/receivers.txt");
        return personList;
    }


}
