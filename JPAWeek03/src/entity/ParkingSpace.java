package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ParkingSpace {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int flat;
	private String location;

//	@OneToOne
//	private Employee employee;
	// Bi directional degildir.
	// Burada 2 tane unidirectional iliski oldu.

	// owning side
	// inverse side

	@OneToOne(mappedBy = "parkingSpace", cascade = CascadeType.ALL)
	private Employee employee;

	// OneToOne bi directional iliski oldu.
	// Iliskinin sahibi owning side -> Employee tarafidir
	// Foreign key bilgisi Employee tarafinda yer alir.
	// Inverse Side -> ParkingSpace tarafidir. burada foreign key bilgisi yer almaz.

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFlat() {
		return flat;
	}

	public void setFlat(int flat) {
		this.flat = flat;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "ParkingSpace [id=" + id + ", flat=" + flat + ", location=" + location + ", employee=" + employee + "]";
	}

	
	
}

// 1 calisanin - 1 tane park alani olsun.
// one-to-one bir iliski/relationship olsun.