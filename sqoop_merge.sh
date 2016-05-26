



echo "[INFO]: Deleting directory :-----> /user/cloudera/employeeprofilemerge"

hadoop fs -rmr /user/cloudera/employeeprofilemerge

sqoop merge --new-data /user/cloudera/incremental  --onto /user/cloudera/tabledata  --jar-file /home/jars/employee_profile.jar --class-name employee_profile --target-dir /user/cloudera/employeeprofilemerge --merge-key profile_id

