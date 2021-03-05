package com.test.csvtojson;

import com.test.csvtojson.config.Constants;
import com.test.csvtojson.services.CSVToPersonService;
import com.test.csvtojson.services.PersonToJsonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.StringReader;
import java.util.Scanner;


@SpringBootApplication
public class CSVToJsonApplication implements CommandLineRunner {

	@Autowired
	private PersonToJsonService personToJsonService;

	@Autowired
	private CSVToPersonService csvToPersonService;

	Logger logger = LoggerFactory.getLogger(CSVToJsonApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CSVToJsonApplication.class, args);
	}


	@Override
	public void run(String... args) {

		Scanner in = new Scanner(System.in);
		try {
			instructions();

			String typeOfInput = in.nextLine();
			if (Constants.TEXT.equalsIgnoreCase(typeOfInput)) {
				StringBuffer stringBuffer = new StringBuffer();
				while (in.hasNext()) {
					String line = in.nextLine();
					if (Constants.END.equalsIgnoreCase(line)) {
						break;
					}
					stringBuffer.append(line + "\n");
				}
				StringReader stringReader = new StringReader(stringBuffer.toString());
				personToJsonService.personsToJson(csvToPersonService.parseCSVtoJson(stringReader));

			} else if (Constants.FILE.equalsIgnoreCase(typeOfInput)) {
				String fileName = in.nextLine();
				personToJsonService.personsToJson(csvToPersonService.parseCSVtoJson(fileName));
			} else {
				logger.info("\n\n-------------------- Wrong input --------------------\n\n");
				System.out.println("\n\n----------------- Wrong input -----------------\n\n");
				instructions();

				logger.info("\n\n-------------------- Try again by following above instructions --------------------\n\n");
				System.out.println("\n\n----------------- Try again by following above instructions -----------------\n\n");
			}
		}  finally {
			in.close();
		}



	}

	private void instructions() {
		logger.info("\nThis App expects two inputs: \n 1. Type of input. valid values are 'text' or 'file'. " +
				"\n 2. If it is 'text' paste your text in csv format and enter 'end' after completing else enter absolute file path \n\n");

		System.out.println("\nThis App expects two inputs: \n 1. Type of input. valid values are 'text' or 'file'. " +
				"\n 2. If it is 'text' paste your text in csv format and enter 'end' after completing else enter absolute file path \n\n");
	}

}
