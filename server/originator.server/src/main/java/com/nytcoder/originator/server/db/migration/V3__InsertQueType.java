package com.nytcoder.originator.server.db.migration;

import java.io.FileReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;

public class V3__InsertQueType implements SpringJdbcMigration {
	@Override
	public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
		FileReader dataFile = new FileReader(
				getClass().getClassLoader().getResource("insertData/ques_type.csv").getPath());

		Iterable<CSVRecord> csvRecords = CSVFormat.EXCEL.withHeader().parse(dataFile);

		for (CSVRecord record : csvRecords) {
			String typeName = record.get("type_name");

			jdbcTemplate.update("insert into que_type(type_name) " + "values (?)", typeName);

		}
	}

}
