package test.service;

import main.model.Email;
import main.model.Person;
import main.service.FileService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by sb on 24.12.2015.
 */
public class FileServiceTest {

    @Test(expected=NullPointerException.class)
    public void testReadFileAndCreatePersonWithNullFileName() {
        FileService fileService = new FileService();
        fileService.readFileAndCreatePerson(null);
    }

    @Test(expected=RuntimeException.class)
    public void testReadFileAndCreatePersonWrongFileName() {
        FileService fileService = new FileService();
        fileService.readFileAndCreatePerson("wrongFileName");
    }

    @Test
    public void testReadFileAndCreatePerson() {
        String fileName = "src/receivers.txt";
        FileService fileService = new FileService();
        List<Person> personList = fileService.readFileAndCreatePerson(fileName);
        assertEquals(personList.size(), 8);
    }

    @Test
    public void testReadFileAndCreatePersonWithEmptyFile() {
        String fileName = "src/forTestEmptyFile.txt";
        FileService fileService = new FileService();
        List<Person> personList = fileService.readFileAndCreatePerson(fileName);
        assertEquals(personList.size(), 0);
    }
}
