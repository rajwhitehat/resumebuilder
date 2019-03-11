load data local infile "./src/main/resources/insertData/ques_type.csv" INTO TABLE que_type
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\r\n'
IGNORE 1 rows;