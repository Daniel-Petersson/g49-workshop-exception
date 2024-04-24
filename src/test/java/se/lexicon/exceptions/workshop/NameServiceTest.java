package se.lexicon.exceptions.workshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.exceptions.workshop.data_access.NameService;

import se.lexicon.exceptions.workshop.domain.Person;
import se.lexicon.exceptions.workshop.exception.DuplicateNameException;
import se.lexicon.exceptions.workshop.fileIO.CSVReader_Writer;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NameServiceTest {

    private NameService nameService;
    private List<String> maleFirstNames;
    private List<String> femaleFirstNames;
    private List<String> lastNames;

    @BeforeEach
    void setUp() throws IOException {
        maleFirstNames = CSVReader_Writer.getMaleFirstNames();
        femaleFirstNames = CSVReader_Writer.getFemaleFirstNames();
        lastNames = CSVReader_Writer.getLastNames();
        nameService = new NameService(maleFirstNames, femaleFirstNames, lastNames);
    }

    @Test
    void getNewRandomPerson_returnsPerson() {
        Person person = nameService.getNewRandomPerson();
        assertNotNull(person);
    }

    @Test
    void addFemaleFirstName_throwsExceptionForDuplicateName() {
        assertThrows(DuplicateNameException.class, () -> nameService.addFemaleFirstName("Mary"));
    }

    @Test
    void addFemaleFirstName_addsNameForNewName() throws DuplicateNameException {
        nameService.addFemaleFirstName("Vega");
        assertTrue(femaleFirstNames.contains("Vega"));
    }

    @Test
    void addMaleFirstName_throwsExceptionForDuplicateName() {
        assertThrows(DuplicateNameException.class, () -> nameService.addMaleFirstName("John"));
    }

    @Test
    void addMaleFirstName_addsNameForNewName() throws DuplicateNameException {
        nameService.addMaleFirstName("Daniel");
        assertTrue(maleFirstNames.contains("Daniel"));
    }

    @Test
    void addLastName_throwsExceptionForDuplicateName() {
        assertThrows(DuplicateNameException.class, () -> nameService.addLastName("Smith"));
    }

    @Test
    void addLastName_addsNameForNewName() throws DuplicateNameException {
        nameService.addLastName("Larsson");
        assertTrue(lastNames.contains("Larsson"));
    }
}