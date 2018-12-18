load data local infile './insertData/question.csv' into table questions
Fields terminated by ','
OPTIONALLY ENCLOSED BY '"'
Lines terminated by '\n'
ignore 1 rows
(ques_id,question,type_id,answer,@is_image,subject_id) set
is_image=cast(@is_image as signed);