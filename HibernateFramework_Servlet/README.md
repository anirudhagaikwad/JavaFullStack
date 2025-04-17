
### Maven Project Setup Guide  
#### Prerequisites:  
- Java 17  
- Apache Tomcat 10.1.39  
- Eclipse IDE / STS 4
- Eclipse Plugin : Eclipse Enterprise Java and Web Developer Tools 3.36 
- PostgreSQL

### Steps to Set Up the Maven Project  

1. Create a Maven Project.  
2. Add Dependencies to `pom.xml`:  
   - Jakarta EE Platform  
   - Hibernate 6.6.11 Final  
   - PostgreSQL JDBC Driver  
3. Build the Project: Run `mvn clean install`.  
4. Verify Dependencies:  
   - Check the Maven dependencies in your project.  
   - Ensure all required libraries are downloaded as specified in `pom.xml`.  
5. Configure Hibernate:  
   - Create `hibernate.cfg.xml` inside the `resources` folder.  
   - Set database credentials in the `<property>` tags.  
6. Create Frontend Files:  
   - Place HTML files in the `webapp` folder.  
7. Write Java Code:  
   - Add Java files inside the `java` folder.  
   - Organize them into appropriate packages as per project requirements.  
8. Check for Errors:  
   - Review all files and fix any issues.  
9. Rebuild the Project:  
   - Run `mvn clean install` again.  
10. Verify the Build:  
    - Check the `target` folder.  
    - Ensure a `.war` file is generated.  
    - Confirm that all required `.jar` files are present.  
11. Setup PostgreSQL Database:  
    - Open PostgreSQL and create the required database.  
12. Deploy & Run on Tomcat.  

---

### Troubleshooting  

#### If Stuck at Step 4 (Dependencies Missing):  
1. Delete all files inside the `.m2/repository` folder.  
2. Re-run `mvn clean install`.  

#### If Stuck at Step 10 (WAR File Not Generated):  
1. Run `mvn clean package`.  
2. Run `mvn clean -X` (for debugging).  
3. Run `mvn install`.  
4. Check the `target` folder again. If the issue persists, repeat the steps above.  

---------------------------------------------------------------------------

### How to create or read code
1)POM.XML : after add all dependency ->clean install
2)Entity Files
3)hibernate.cfg.xml & HibernateUtil.java
4)DAO Java Files
5)Servlet Java Files
6)Html Files
7)mvn clean package
8)mvn install
