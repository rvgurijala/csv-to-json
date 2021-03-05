package com.test.csvtojson.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.test.csvtojson.exception.CSVToJsonException;
import com.test.csvtojson.models.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PersonToJsonService {

    private Logger logger = LoggerFactory.getLogger(PersonToJsonService.class);

    public void personsToJson(List<Person> persons) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(persons);
            System.out.println("-------------------------------------------------------");
            System.out.println(jsonInString);
        } catch (IOException ex) {
            logger.error("IOException while parsing", ex.getMessage());
            throw new CSVToJsonException("IOException while parsing", ex);
        }
    }
}
