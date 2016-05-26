
from airflow import DAG
from airflow.operators import BashOperator, HiveOperator
from datetime import datetime, timedelta

default_args = {
    'owner': 'sunny',
    'start_date': datetime(2016, 5, 5),
    'retries': 1,
    'retry_delay': timedelta(minutes=5)
}

dag = DAG('incremental_load', default_args=default_args)

sqoop_incremental_job = """
 sh sqoop_incremental.sh
"""

sqoop_merge_job = """
 sh sqoop_merge.sh
"""



# Importing the incremental data from Mysql table to HDFS
task1 = BashOperator(
        task_id= 'sqoop_incremental_import',
        #bash_command=sqoop_incremental_job,
	bash_command='./sqoop_incremental.sh',
        dag=dag
)

# merge the data from Mysql table to HDFS
task2 = BashOperator(
        task_id= 'sqoop_merge_import',
        bash_command='./sqoop_merge.sh',
        dag=dag
)

# Inserting the data from Hive external table to the target table
task3 = HiveOperator(
        task_id= 'hive_insert',
        hql='LOAD DATA INPATH "/user/cloudera/employeeprofilemerge" OVERWRITE INTO TABLE employee_profile;',
        depends_on_past=True,
        dag=dag
)

# Inserting the data from Hive table with masked ssn external table to the target table
task4 = HiveOperator(
        task_id= 'hive_insert_masked',
        hql='add jar /home/cloudera/Masking.jar;create TEMPORARY function masking as \'Masking\';INSERT OVERWRITE table employee_profile_masked SELECT profile_id,first_name,last_name,modified_date,masking(ssn) FROM employee_profile;',
        depends_on_past=True,
        dag=dag
)
# defining the job dependency
task2.set_upstream(task1)
task3.set_upstream(task2)
task4.set_upstream(task3)
