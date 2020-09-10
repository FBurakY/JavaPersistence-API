package entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String name;

	@Embedded
	//birden fazla kolon icin isim override edilecekse @AttributeOverrides kullanilabilir.
	//@AttributeOverrides icerisinde @AttributeOverride annotation kullanarak bu islemi yapabiliriz.
	@AttributeOverrides(value ={
			@AttributeOverride(name = "road", column = @Column(name = "avenue")),
			@AttributeOverride(name = "zip", column = @Column(name = "postal_code"))
	})
	//eger sadece birtane kolon icin isim override edilecekse @AttributeOverride kullanilabilir.
	//birden fazla @AttributeOverride 'i alt alta kullanmak legal degildir.
	@AttributeOverride(name = "city", column = @Column(name = "province"))
	private Address address;

	
	public Company() {
		super();
	}

	public Company(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", address=" + address + "]";
	}
		
}
