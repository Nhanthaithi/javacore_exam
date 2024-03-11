DROP DATABASE IF EXISTS final_exam;
CREATE DATABASE final_exam;
USE final_exam;

DROP TABLE IF EXISTS users;
CREATE TABLE users (
    id          INT PRIMARY KEY AUTO_INCREMENT,
    full_name   VARCHAR(50)                     NOT NULL,
    email       VARCHAR(50) UNIQUE KEY          NOT NULL,
    password    VARCHAR(50)                     NOT NULL,
    role        ENUM('MANAGER', 'EMPLOYEE')       NOT NULL,
    project_id   INT                             NOT NULL,
    pro_skill   VARCHAR(50),
    exp_in_year INT
);

INSERT INTO users (full_name        , email              , password  , role, project_id		 , pro_skill, exp_in_year)
VALUES            ('Thái Thị Nhàn', 'nhan.tt@gmail.com', '123456Q' , 'MANAGER', 1, NULL   , 10       ),
                  ('Lê Thiên Ngọc Trâm', 'tram.lt@gmail.com', '123456Q' , 'MANAGER', 1, NULL   , 7       ),
                  ('Thái Nguyễn Siêu', 'sieu.tt@gmail.com', '123456Q' , 'MANAGER', 1, NULL   , 5       ),
				  ('Nguyễn Trương Nga', 'nga.nt@gmail.com' , '123456Q' , 'EMPLOYEE'  ,1 , "Java"     , NULL         ),
                  ('Nguyễn Trương Mỹ', 'my.nt@gmail.com' , '123456Q' , 'EMPLOYEE'  ,1 , "ReactJS"     , NULL         );

