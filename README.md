create table in mysql

CREATE TABLE `employee_profile` (
`profile_id` VARCHAR(255) NOT NULL,
`first_name` VARCHAR(45) NULL,
`last_name` VARCHAR(45) NULL,
`modified_date` DATETIME NULL,
`ssn` VARCHAR(45) NULL,
PRIMARY KEY (`profile_id`) );


insert the data mysql:-

INSERT INTO `employee_profile` (`profile_id`, `first_name`, `last_name`, `modified_date`,`ssn`) VALUES ('1', 'FristName1', 'LastName1', '2015-12-01 11:24:35','111-11-1111');

INSERT INTO `employee_profile` (`profile_id`, `first_name`, `last_name`, `modified_date`,`ssn`) VALUES ('2', 'FristName2', 'LastName2', '2015-12-02 11:24:35','222-22-2222');

INSERT INTO `employee_profile` (`profile_id`, `first_name`, `last_name`, `modified_date`,`ssn`) VALUES ('3', 'FristName3', 'LastName3', '2015-12-03 11:24:35','333-33-3333');

INSERT INTO `employee_profile` (`profile_id`, `first_name`, `last_name`, `modified_date`,`ssn`) VALUES ('4', 'FristName4', 'LastName4', '2015-12-04 11:24:35','444-44-4444');

INSERT INTO `employee_profile` (`profile_id`, `first_name`, `last_name`, `modified_date`,`ssn`) VALUES ('5', 'FristName5', 'LastName5', '2015-12-05 11:24:35','555-55-5555');



Import base data of SQL table in HDFS

sqoop import --connect jdbc:mysql://localhost/employee --username root --password cloudera --table employee_profile --m 1 --target-dir /user/cloudera/base/


table in hive :-


CREATE EXTERNAL TABLE employee_profile (profile_id string, first_name string,last_name string,modified_date string, ssn string) row format delimited fields terminated by ',' stored as textfile LOCATION '/user/cloudera/tabledata/'
LOAD DATA INPATH '/user/cloudera/base/' INTO TABLE employee_profile;

CREATE EXTERNAL TABLE employee_profile_masked (profile_id string, first_name string,last_name string,modified_date string, ssn string) row format delimited fields terminated by ',' stored as textfile LOCATION '/user/cloudera/tabledatamask/'

LOAD DATA INPATH '/user/cloudera/base/' INTO TABLE employee_profile;


update data in mysql to test incremental import :-
INSERT INTO `employee_profile` (`profile_id`, `first_name`, `last_name`, `modified_date`,`ssn`) VALUES ('6', 'FristName6', 'LastName6', '2015-12-11 11:25:35','666-66-6666');

INSERT INTO `employee_profile` (`profile_id`, `first_name`, `last_name`, `modified_date`,`ssn`) VALUES ('20', 'FristName20', 'LastName20', '2016-12-12 11:24:35','111-22-1111');

UPDATE employee_profile set last_name = 'LastName2_new',modified_date = '2015-12-13 11:24:35' where profile_id = 2;

UPDATE employee_profile set first_name = 'FristName3_new',modified_date = '2015-12-14 11:24:35' where profile_id = 3;

Now use our Airflow script to do the incremental import job


airflow backfill incremental_load -s 2009-01-01




Command used inside airflow script is below for  refrence.

incremental import to HDFS

sqoop import --connect jdbc:mysql://localhost:3306/employee --table employee_profile --username root --password cloudera --check-column modified_date --incremental lastmodified --last-value "2015-12-05 11:24:35" --target-dir /user/cloudera/incremental/


for imcremental import sqoop creates java class for table use it for sqoop merge

sqoop merge --new-data /user/cloudera/incremental --onto /user/hive/warehouse/employee_profile --jar-file /home/jars/employee_profile.jar --class-name employee_profile --target-dir /user/cloudera/employeeprofilemerge --merge-key profile_id

LOAD DATA INPATH '/user/cloudera/employeeprofilemerge' OVERWRITE INTO TABLE employee_profile;


INSERT INTO `employee_profile` (`profile_id`, `first_name`, `last_name`, `modified_date`,`ssn`) VALUES ('8', 'FristName8', 'LastName10', '2015-12-11 11:25:35','888-88-8888');

INSERT INTO `employee_profile` (`profile_id`, `first_name`, `last_name`, `modified_date`,`ssn`) VALUES ('9', 'FristName9', 'LastName10', '2015-12-12 11:24:35','999-99-9999');

UPDATE employee_profile set last_name = 'LastName2_newnew',modified_date = '2015-12-13 11:24:35' where profile_id = 2;

UPDATE employee_profile set first_name = 'FristName3_newnew',modified_date = '2015-12-14 11:24:35' where profile_id = 3;

INSERT INTO `employee_profile` (`profile_id`, `first_name`, `last_name`, `modified_date`,`ssn`) VALUES ('10', 'FristName22', 'LastName133', '2015-12-13 11:24:35','123-12-1234');

add jar /home/cloudera/Masking.jar;
create function masking as 'Masking';


INSERT OVERWRITE table temp SELECT profile_id,first_name,last_name,modified_date,masking2(ssn) FROM employee_profile;




