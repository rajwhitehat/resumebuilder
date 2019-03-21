package com.nytcoder.originator.server.db.migration;

import java.io.FileReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;

public class V2__InsertSubject implements SpringJdbcMigration {
	@Override
	public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
		FileReader dataFile = new FileReader(
				getClass().getClassLoader().getResource("insertData/subject.csv").getPath());

		Iterable<CSVRecord> csvRecords = CSVFormat.EXCEL.withHeader().parse(dataFile);

		for (CSVRecord record : csvRecords) {
			String subjectName = record.get("subject_name");

			jdbcTemplate.update("insert into subject(subject_name) " + "values (?)", subjectName);

		}
	}

}
