# TestTasks 

ParseTheStringTask_v3 - will work even if we change the input string

For example: 
Input: 
"(id,created,employee(id,firstname,employeeType2(id2, employee2(id2,firstname2,employeeType2(id2), lastname2, number2(id2))), lastname, number(id)),location)"

Result : 
created
employee
-employeeType2
--employee2
---employeeType2
----id2
---firstname2
---id2
---lastname2
---number2
----id2
--id2
-firstname
-id
-lastname
-number
--id
id
location

