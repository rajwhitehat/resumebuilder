load data local infile './insertData/que_choices.csv' into table choices
Fields terminated by ','
OPTIONALLY ENCLOSED BY '"'
Lines terminated by '\r\n'
ignore 1 rows
(choice_id,choice,@is_image,question_id) set
is_image=cast(@is_image as signed);
