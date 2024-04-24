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

        List<String> lastNames = null;
        try {
            lastNames = CSVReader_Writer.getLastNames();
        }catch (IOException e){
            System.out.println(e.toString());
        }


        NameService nameService = new NameService(maleFirstNames, femaleFirstNames,lastNames);


        Person test = nameService.getNewRandomPerson();
        System.out.println(test);
        Person person1 = new Person("Daniel","Petersson", Gender.MALE);
        Person person2 = new Person("Daniel", "Olsson",Gender.MALE);
        nameService.addFemaleFirstName("Alice");


	}

}
