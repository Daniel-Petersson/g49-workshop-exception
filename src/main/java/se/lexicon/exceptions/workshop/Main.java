package se.lexicon.exceptions.workshop;

import java.io.IOException;
import java.util.List;

import se.lexicon.exceptions.workshop.data_access.NameService;
import se.lexicon.exceptions.workshop.domain.Gender;
import se.lexicon.exceptions.workshop.domain.Person;
import se.lexicon.exceptions.workshop.exception.DuplicateNameException;
import se.lexicon.exceptions.workshop.fileIO.CSVReader_Writer;

public class Main {

	public static void main(String[] args) throws IOException, DuplicateNameException {
		
		List <String> maleFirstNames = CSVReader_Writer.getMaleFirstNames();
        List <String> femaleFirstNames = CSVReader_Writer.getFemaleFirstNames();
        List<String> lastNames = CSVReader_Writer.getLastNames();

        try {
            lastNames = CSVReader_Writer.getLastNames();
        }catch (IOException e){
            System.out.println(e.toString());
        }


        NameService nameService = new NameService(maleFirstNames, femaleFirstNames,lastNames);


        Person test = nameService.getNewRandomPerson();
        System.out.println(test);
            // Test getNewRandomPerson method
            Person randomPerson = nameService.getNewRandomPerson();
            System.out.println(randomPerson);

            // Test addFemaleFirstName method
            try {
                    nameService.addFemaleFirstName("Alice");
                    System.out.println("Successfully added new female first name.");
            } catch (DuplicateNameException e) {
                    System.out.println("Failed to add new female first name: " + e.getMessage());
            }

            // Test addMaleFirstName method
            try {
                    nameService.addMaleFirstName("David");
                    System.out.println("Successfully added new male first name.");
            } catch (DuplicateNameException e) {
                    System.out.println("Failed to add new male first name: " + e.getMessage());
            }

            // Test addLastName method
            try {
                    nameService.addLastName("Brown");
                    System.out.println("Successfully added new last name.");
            } catch (DuplicateNameException e) {
                    System.out.println("Failed to add new last name: " + e.getMessage());
            }


	}

}
