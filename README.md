Code to demonstrate, how to write basic Airflow to achieve incremental import from Mysql to Hive.
#Problem Statement :- 
Mysql has table called 'employee_profile' having employee information having first name, last name and SSN. Script should check for new and modified records in table and update corresponding hive table with modified recrods, and also have additional table in hive with masked social security number (SSN). Use Sqoop to achieve incremental import and use Airflow for automate the process.

## 1) Setup data
### i) create table in mysql

		CREATE TABLE `employee_profile` (
			`profile_id` VARCHAR(255) NOT NULL,
			`first_name` VARCHAR(45) NULL,
			`last_name` VARCHAR(45) NULL,
			`modified_date` DATETIME NULL,
			`ssn` VARCHAR(45) NULL,
			 PRIMARY KEY (`profile_id`) );
			 
###ii) Insert base data in mysql employee_profile

		INSERT INTO `employee_profile` (`profile_id`, `first_name`, `last_name`, `modified_date`,`ssn`) VALUES ('1', 'FristName1', 'LastName1', '2015-12-01 11:24:35','111-11-1111');

		INSERT INTO `employee_profile` (`profile_id`, `first_name`, `last_name`, `modified_date`,`ssn`) VALUES ('2', 'FristName2', 'LastName2', '2015-12-02 11:24:35','222-22-2222');

		INSERT INTO `employee_profile` (`profile_id`, `first_name`, `last_name`, `modified_date`,`ssn`) VALUES ('3', 'FristName3', 'LastName3', '2015-12-03 11:24:35','333-33-3333');

		INSERT INTO `employee_profile` (`profile_id`, `first_name`, `last_name`, `modified_date`,`ssn`) VALUES ('4', 'FristName4', 'LastName4', '2015-12-04 11:24:35','444-44-4444');

		INSERT INTO `employee_profile` (`profile_id`, `first_name`, `last_name`, `modified_date`,`ssn`) VALUES ('5', 'FristName5', 'LastName5', '2015-12-05 11:24:35','555-55-5555');



### iii) Import base data of SQL table in HDFS

        sqoop import --connect jdbc:mysql://localhost/employee --username root --password cloudera --table employee_profile --m 1 --target-dir /user/cloudera/base/


### iv) Create base table in hive


        a)CREATE EXTERNAL TABLE employee_profile (profile_id string, first_name string,last_name string,modified_date string, ssn string) row format delimited fields terminated by ',' stored as textfile LOCATION '/user/cloudera/tabledata/'

	    	b)LOAD DATA INPATH '/user/cloudera/base/' INTO TABLE employee_profile;

        c)CREATE EXTERNAL TABLE employee_profile_masked (profile_id string, first_name string,last_name string,modified_date string, ssn string) row format delimited fields terminated by ',' stored as textfile LOCATION '/user/cloudera/tabledatamask/'



###     v) update data in mysql to test incremental import
			INSERT INTO `employee_profile` (`profile_id`, `first_name`, `last_name`, `modified_date`,`ssn`) VALUES ('6', 'FristName6', 'LastName6', '2015-12-11 11:25:35','666-66-6666');

			INSERT INTO `employee_profile` (`profile_id`, `first_name`, `last_name`, `modified_date`,`ssn`) VALUES ('7', 'FristName7', 'LastName7', '2016-12-12 11:24:35','111-22-1111');

			UPDATE employee_profile set last_name = 'LastName2_new',modified_date = '2015-12-13 11:24:35' where profile_id = 2;

			UPDATE employee_profile set first_name = 'FristName3_new',modified_date = '2015-12-14 11:24:35' where profile_id = 3;


## Install Airflow

Airflow runs on python 2.7 and pip2.7

CentOS Install
### 1)Development tools required :

SSH onto the target machine

sudo yum groupinstall "Development tools"

### 2)Extra libs needed:

sudo yum install zlib-devel

sudo yum install bzip2-devel

sudo yum install openssl-devel

sudo yum install ncurses-devel

sudo yum install sqlite-devel

sudo yum install python-devel

**Note:- If Python installed is lower than Python 2.7.x then follow these steps 3 and 4.**
### 3)$Python -V

### 4)Downloading and installing Python 2.7.6

cd /opt

sudo wget --no-check-certificate https://www.python.org/ftp/python/2.7.6/Python-2.7.6.tar.xz

tar xf Python-2.7.6.tar.xz

cd Python-2.7.6

./configure --prefix=/usr/local

make && make altinstall

ls -ltr /usr/local/bin/python*

$vi ~/.bashrc

add this line alias python='/usr/local/bin/python2.7'

### 5)Getting the setup Tools:
sudo wget https://bootstrap.pypa.io/ez_setup.py

sudo /usr/local/bin/python2.7 ez_setup.py

sudo unzip setuptools-20.4.zip

cd setuptools-20.4

sudo /usr/local/bin/easy_install-2.7 pip

### 6)Installing Airflow and other required packages:

sudo yum install numpy scipy python-matplotlib ipython python-pandas sympy python-nose

 airflow needs a home, ~/airflow is the default,
 
 but you can lay foundation somewhere else if you prefer
 (optional)
 
export AIRFLOW_HOME=~/airflow

sudo /usr/local/bin/pip2.7 install pysqlite

sudo /usr/local/bin/pip2.7 install airflow

sudo pip2.7 install airflow[hive]

sudo pip2.7 install airflow[celery]

sudo pip2.7 install airflow[mysql]

yum install rabbitmq-server

airflow initdb

for using celery executor use below in airflow.cfg

sql_alchemy_conn =mysql://root:cloudera@localhost:3306/airflowdb
 
executor = CeleryExecutor
 
broker_url = amqp://guest:guest@localhost:5672/
 
celery_result_backend = db+mysql://root:cloudera@localhost:3306/airflow


## Now use our Airflow script to do the incremental import job

### Start webserver to check task airflow through UI

sudo airflow webserver -p 8080

### To run the Airflow use below command

airflow backfill incremental_load -s 2015-06-01

### To test the individual task in a airflow DAG use below command

airflow test incremental_load hive_insert_masked 2015-06-01;


## Command used inside airflow script is below for refrence.

### 1) incremental import to HDFS

sqoop import --connect jdbc:mysql://localhost:3306/employee --table employee_profile --username root --password cloudera --check-column modified_date --incremental lastmodified --last-value "2015-12-05 11:24:35" --target-dir /user/cloudera/incremental/


### 2) For imcremental import sqoop creates java class for table use it for sqoop merge

sqoop merge --new-data /user/cloudera/incremental --onto /user/hive/warehouse/employee_profile --jar-file /home/jars/employee_profile.jar --class-name employee_profile --target-dir /user/cloudera/employeeprofilemerge --merge-key profile_id

LOAD DATA INPATH '/user/cloudera/employeeprofilemerge' OVERWRITE INTO TABLE employee_profile;

### 3) Add UDF in hive
add jar /home/cloudera/Masking.jar;
create function masking as 'Masking';

### 4) how to use UDF 
INSERT OVERWRITE table temp SELECT profile_id,first_name,last_name,modified_date,masking(ssn) FROM employee_profile;




