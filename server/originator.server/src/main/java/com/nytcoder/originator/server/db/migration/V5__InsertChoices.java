package com.nytcoder.originator.server.db.migration;

import java.io.FileReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;

public class V5__InsertChoices implements SpringJdbcMigration {
	@Override
	public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
		FileReader dataFile = new FileReader(
				getClass().getClassLoader().getResource("insertData/que_choices.csv").getPath());

		Iterable<CSVRecord> csvRecords = CSVFormat.EXCEL.withHeader().parse(dataFile);

		for (CSVRecord record : csvRecords) {
			String choice = record.get("choice");
			Boolean isImage = Boolean.valueOf(record.get("is_image"));
			Long questionId = Long.valueOf(record.get("question_id"));
			
			jdbcTemplate.update("insert into choices(choice, is_image, question_id) " +
			"values (?, ?, ?)", choice, isImage, questionId);

		}
	}

}
