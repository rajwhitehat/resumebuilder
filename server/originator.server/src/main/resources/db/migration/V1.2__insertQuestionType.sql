load data local infile ${question_type_insert} INTO TABLE que_type
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\r\n'
IGNORE 1 rows;