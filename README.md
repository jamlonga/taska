---
Developer: Jamlong Khamphachua
Stack: Java
Framework: SpringBoot

---

Taska
=========

RESTFul API for CURD operation on Task information including

 - id : Task id
 - subject : Task subject
 - content : Task detail
 - status : Task status ('Done' or 'Pending')

Taska DB
--------------------------------
Taska use HyperSQL DataBase ([hsqldb](http://hsqldb.org/)) : RDBMS embedded in Java virtual machine ,
create new database on Runtime

----------
Taska Setup
--------------------------------
The step you need to do for making Taska up and running on your machine.

**Prerequisite**
- java (require JDK version 8)
- maven (require version 3)
- git

**Clone project from repository**
`git clone git@github.com:jamlonga/taska.git`

**Build project**
`mvn clean inatall`

**Run project**
`cd frontier-service; mvn spring-boot:run`

API will run on port 8080
e.g., http://localhost:8080/api/service/v1/tasks

API docs
--------------------------------
1. Create/add new task
POST: http://localhost:8080/api/service/v1/tasks
JSON Request Body example:
```json
{
    "id":null,
    "subject":"subject here",
    "content":"content here",
    "status":"Done"
}
```

2. Get all tasks , will return in JSON format
GET: http://localhost:8080/api/service/v1/tasks

3. Get tasks by id
GET: http://localhost:8080/api/service/v1/tasks/{id}

4. Update task by id
PUT: http://localhost:8080/api/service/v1/tasks/{id}
JSON Request Body when need to update status for task id=0:
```json
{
    "id":0,
    "subject":"subject here",
    "content":"content here",
    "status":"Pending"
}
```

5. Delete task by id
DELETE: http://localhost:8080/api/service/v1/tasks/{id}

