

echo "[INFO]: Deleting directory :-----> /user/cloudera/incremental"

hadoop fs -rmr /user/cloudera/incremental

echo "[INFO]: Importing new records from employee_profile"

sqoop import --connect jdbc:mysql://localhost:3306/employee --table employee_profile -m 1 --username root --password cloudera --check-column modified_date --incremental lastmodified --last-value "2015-12-05 11:24:35" --target-dir /user/cloudera/incremental
