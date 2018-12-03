# Companies Management

Companies Management is a REST API server that registers and lists Companies and Employees.

---
This project was developed using:
 - Java8
 - Spring Framework
 - Gradle
 - H2 Database

---
You can download this repository and run our server by typing `./gradlew bootRun` into its directory.

---
Docker Image: gustavoyama/companies-management-api  
You can run a container of companies-management-api by running: `docker run -idt --name companies-management -p 8080:8080 gustavoyama/companies-management`.

---
After running you can start to use it, you will need the base url: http://localhost:8080.  

It will require a token to access any endpoint, you can create it in the following uri: `/oauth/token`  
Use the credentials `admin` username and `s3cr3t` password. You will also need the grant_type `password`, client-id `gustavo`
and client-secret `p4ss`.

With this token, you can now access the whole project.

You can see below a brief explanation of each resource and how to use them:

Industry  
* GET method in `/industries` uri lists all industries available.

Company
* POST method in `/companies` uri creates a new company.  
  - Body request example:  
  ```json
  {
  "name": "Company 1",
  "cnpj": "22222222222222",
  "telephone": "123456",
  "website": "stubsite.com",
  "industry": {
    "id": 1
    }
  }
  ```

* GET method in `/companies` uri lists all companies registered.
* GET method in `/companies/{id}` shows infos of company with id: {id}.
* GET method in `/companies?companyName={word}` lists all companies whose names contains {word} in their name.
* GET method in `/companies?industry={id}` lists all companies whose industry has id: {id}.
* GET method in `/companies/{id}/employees` lists all employees whose employer has id: {id}.

Employee
* POST method in `/employees` uri creates a new employee.  
  - Body request example:  
  ```json
  {
  "cpf": "11111111111",
  "employer": {
    "id": 1
    },
  "jobTitle": "Software Developer",
  "seed": "761a3b5df2147bca"
  }
  ```

* GET method in `/employees` uri lists all employees registered.
* GET method in `/employees/{id}` shows infos of employees with id: {id}.
* GET method in `/employees?jobTitle={word}` lists all employees whose jobTitle contains {word}.
