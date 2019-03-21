package com.nytcoder.originator.server.db.migration;

import java.io.FileReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;

public class V4__InsertQuestions implements SpringJdbcMigration {
	@Override
	public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
		FileReader dataFile = new FileReader(
				getClass().getClassLoader().getResource("insertData/question.csv").getPath());

		Iterable<CSVRecord> csvRecords = CSVFormat.EXCEL.withHeader().parse(dataFile);

		for (CSVRecord record : csvRecords) {
			String question = record.get("question");
			Long typeId = Long.valueOf(record.get("type_id"));
			String answer = record.get("answer");
			Boolean isImage = Boolean.valueOf(record.get("is_image"));
			Long subjectId = Long.valueOf(record.get("subject_id"));
			jdbcTemplate.update("insert into questions(question, type_id, answer, is_image, subject_id) " +
			"values (?, ?, ?, ?, ?)", question, typeId, answer, isImage, subjectId);

		}
	}

}
