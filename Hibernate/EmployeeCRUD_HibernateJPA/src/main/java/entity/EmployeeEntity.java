package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="empdetails")
public class EmployeeEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int emp_id;

@Column(name ="first_name")
private String firstName;

@Column(name ="last_name")
private String lastName;

@Column(name="email")
private String email;

@Column(name="hire_date")
private java.sql.Date hireDate;

public EmployeeEntity() {}

public int getEmp_id() {
	return emp_id;
}

public void setEmp_id(int emp_id) {
	this.emp_id = emp_id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public java.sql.Date getHireDate() {
	return hireDate;
}

public void setHireDate(java.sql.Date hireDate) {
	this.hireDate = hireDate;
}

}
