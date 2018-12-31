load data local infile "./insertData/subject.csv" INTO TABLE subject
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\r\n'
IGNORE 1 rows;