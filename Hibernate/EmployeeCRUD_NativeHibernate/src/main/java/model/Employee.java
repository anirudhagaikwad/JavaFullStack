package model;

public class Employee {
	private Integer id;
	private String name;
	private String email;
	private Address address;
	
	// Default constructor
	public Employee() {}

	// Parameterized constructor
	public Employee(String name, String email, Address address) {
	    this.name = name;
	    this.email = email;
	    this.address = address;
	}

	// Getters and Setters
	public Integer getId() {
	    return id;
	}

	public void setId(Integer id) {
	    this.id = id;
	}

	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public String getEmail() {
	    return email;
	}

	public void setEmail(String email) {
	    this.email = email;
	}

	public Address getAddress() {
	    return address;
	}

	public void setAddress(Address address) {
	    this.address = address;
	}

	@Override
	public String toString() {
	    return "Employee{id=" + id + ", name='" + name + "', email='" + email + "', address=" + address + "}";
	}
}
