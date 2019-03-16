load data local infile ${questions_insert} into table questions
Fields terminated by ','
OPTIONALLY ENCLOSED BY '"'
Lines terminated by '\r\n'
ignore 1 rows
(question_id,question,type_id,answer,@is_image,subject_id) set
is_image=cast(@is_image as signed);