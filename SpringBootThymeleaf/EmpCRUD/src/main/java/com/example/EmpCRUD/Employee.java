package com.example.EmpCRUD;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="empcrud")
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="emp_id")
private Long empId;

@Column(name="name",nullable = false)
private String empName;

@Column(name="email",nullable = false)
private String empEmail;

@Column(name="salary",precision = 10,scale = 2)
private BigDecimal sal;

public Employee() {}

public Employee(Long empId, String empName, String empEmail, BigDecimal sal) {
	this.empId = empId;
	this.empName = empName;
	this.empEmail = empEmail;
	this.sal = sal;
}

public Long getEmpId() {
	return empId;
}

public void setEmpId(Long empId) {
	this.empId = empId;
}

public String getEmpName() {
	return empName;
}

public void setEmpName(String empName) {
	this.empName = empName;
}

public String getEmpEmail() {
	return empEmail;
}

public void setEmpEmail(String empEmail) {
	this.empEmail = empEmail;
}

public BigDecimal getSal() {
	return sal;
}

public void setSal(BigDecimal sal) {
	this.sal = sal;
}

@Override
public String toString() {
	return "Employee [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", sal=" + sal + "]";
}

@Override
public int hashCode() {
	return Objects.hash(empEmail, empId, empName, sal);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employee other = (Employee) obj;
	return Objects.equals(empEmail, other.empEmail) && Objects.equals(empId, other.empId)
			&& Objects.equals(empName, other.empName) && Objects.equals(sal, other.sal);
}





}

/*
- Precision defines the total number of digits that can be stored in a column, including both the digits before and after the decimal point.
For example, precision = 10 means the total number of digits allowed for the column is 10.
- Scale defines the number of digits to the right of the decimal point.
For example, scale = 2 means there can be 2 digits after the decimal point.
   */