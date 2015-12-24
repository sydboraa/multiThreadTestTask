package test.service;

import main.model.Person;
import main.service.FileService;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by sb on 24.12.2015.
 */
public class PersonServiceTest {

    @Test
    public void testGetPersonsFromFile() {
        List<Person> testPersonList = new ArrayList<>();
        Person testPerson = new Person("testFirsName", "testLastName", 35, "deneme@deneme.com", true);
        testPersonList.add(testPerson);
        FileService mockFileService = Mockito.mock(FileService.class);
        when(mockFileService.readFileAndCreatePerson("testFileName")).thenReturn(testPersonList);
        assertEquals(mockFileService.readFileAndCreatePerson("testFileName").size(), 1);
    }

    @Test(expected=NullPointerException.class)
    public void testGetPersonsFromFileWithNullFileName() {
        FileService mockFileService = Mockito.mock(FileService.class);
        doThrow(new NullPointerException()).when(mockFileService).readFileAndCreatePerson(null);
        mockFileService.readFileAndCreatePerson(null);
    }
}
