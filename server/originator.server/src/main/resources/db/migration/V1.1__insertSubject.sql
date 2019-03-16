load data local infile 
${subject_insert}
 INTO TABLE subject 
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\r\n' 
IGNORE 1 rows;