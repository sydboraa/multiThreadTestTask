package service;

import model.Person;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sb on 24.12.2015.
 */
public class FileService {

    public List<Person> readFile(String fileName) {
        List<Person> personList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            for(String line; (line = br.readLine()) != null; ) {
                String[] words = line.split(" ");
                if(words.length == 5) {
                    Person newPerson = new Person(words[0], words[1], Integer.parseInt(words[2]), words[3], Boolean.parseBoolean(words[4]));
                    personList.add(newPerson);
                }
            }
            return personList;
        } catch (IOException ex) {
            throw new RuntimeException("Exception occured. Details: " + ex.getMessage());
        }
    }


}
