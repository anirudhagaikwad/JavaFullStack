package model;

public class Address {
	private Integer id;
	private String city;
	private String state;
	private String zipCode;
	
	// Default constructor
	public Address() {}

	// Parameterized constructor
	public Address(String city, String state, String zipCode) {
	    this.city = city;
	    this.state = state;
	    this.zipCode = zipCode;
	}

	// Getters and Setters
	public Integer getId() {
	    return id;
	}

	public void setId(Integer id) {
	    this.id = id;
	}

	public String getCity() {
	    return city;
	}

	public void setCity(String city) {
	    this.city = city;
	}

	public String getState() {
	    return state;
	}

	public void setState(String state) {
	    this.state = state;
	}

	public String getZipCode() {
	    return zipCode;
	}

	public void setZipCode(String zipCode) {
	    this.zipCode = zipCode;
	}

	@Override
	public String toString() {
	    return "Address{id=" + id + ", city='" + city + "', state='" + state + "', zipCode='" + zipCode + "'}";
	}
	
}
