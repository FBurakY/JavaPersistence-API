package entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	// DIKKAT @Embeddable larda @Id bulunmaz.
	private String street;
	private String road;
	private String no;
	private String city;
	private String zip;
	
	public Address(String street, String road, String no, String city, String zip) {
		super();
		this.street = street;
		this.road=road;
		this.no = no;
		this.city = city;
		this.zip = zip;
	}
	
	//Embeddable'larda no-arg constructor'a sahip olmalidir.
	public Address() {
		super();
	}

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", road=" + road + ", no=" + no + ", city=" + city + ", zip=" + zip + "]";
	}

	

}
