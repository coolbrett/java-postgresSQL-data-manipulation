-- use \c holliday to connect to the holliday database beforehand

-- university database; used in exercises 3.11 and 3.12
-- copying data into the table using \copy; \copy, unlike copy 
-- does not require the user to be superuser
-- @author Mark Holliday
-- @version 19 January 2016

\copy classroom from '/home/badale2/cs453/assignmentThree/university_db/university_db_data/sks_classroom_data.txt';

\copy department from '/home/badale2/cs453/assignmentThree/university_db/university_db_data/sks_department_data.txt';

\copy course from '/home/badale2/cs453/assignmentThree/university_db/university_db_data/sks_course_data.txt';

\copy instructor from '/home/badale2/cs453/assignmentThree/university_db/university_db_data/sks_instructor_data.txt';

\copy section from '/home/badale2/cs453/assignmentThree/university_db/university_db_data/sks_section_data.txt';

\copy teaches from '/home/badale2/cs453/assignmentThree/university_db/university_db_data/sks_teaches_data.txt';

\copy student from '/home/badale2/cs453/assignmentThree/university_db/university_db_data/sks_student_data.txt';

\copy takes from '/home/badale2/cs453/assignmentThree/university_db/university_db_data/sks_takes_data.txt';

\copy advisor from '/home/badale2/cs453/assignmentThree/university_db/university_db_data/sks_advisor_data.txt';

\copy time_slot from '/home/badale2/cs453/assignmentThree/university_db/university_db_data/sks_time_slot_data.txt';

\copy prereq from '/home/badale2/cs453/assignmentThree/university_db/university_db_data/sks_prereq_data.txt';













