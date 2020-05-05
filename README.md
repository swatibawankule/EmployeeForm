# EmployeeForm
Steps to Execute-
1)Import the project as Maven Project in STS or Intellj
2) Change Mysql Properties to your own DB Configuration-
   spring.jpa.hibernate.ddl-auto=update
   spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/db_example
   spring.datasource.username=springuser
   spring.datasource.password=ThePassword
 3)Once the Project is buid, Run the project as SpringBootApp
 4)Launch the application at http://localhost:8080/
 5)Index.html Page will render with following details-
 
      Welcome
      Add Employee Form.
      View Employees
 6) Click on add Employee to add Employees.   
    
    
