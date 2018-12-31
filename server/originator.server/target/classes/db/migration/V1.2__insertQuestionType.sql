load data local infile "./insertData/ques_type.csv" INTO TABLE que_type
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\r\n'
IGNORE 1 rows;