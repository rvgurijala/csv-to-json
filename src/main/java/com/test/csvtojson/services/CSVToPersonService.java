package com.test.csvtojson.services;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.test.csvtojson.exception.CSVToJsonException;
import com.test.csvtojson.models.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

@Service
public class CSVToPersonService {

    private Logger logger = LoggerFactory.getLogger(CSVToPersonService.class);

    public List<Person> parseCSVtoJson(String fileName) {

        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            return new CsvToBeanBuilder(reader)
                    .withType(Person.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException ex) {
            logger.error(fileName + " is not found", ex.getMessage());
            throw new CSVToJsonException(fileName + " is not found", ex);
        } catch (IOException ex) {
            logger.error("IOException while parsing", ex.getMessage());
            throw new CSVToJsonException("IOException while parsing", ex);
        }
    }

    public List<Person> parseCSVtoJson(Reader reader) {
        return new CsvToBeanBuilder(reader)
                .withType(Person.class)
                .build()
                .parse();
    }
}
