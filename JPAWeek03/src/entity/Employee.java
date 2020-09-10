package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
//@Table(name = "Employee_New_Name")
public class Employee {

	@Id
	// Annotation lari property/instance degisken ya da getter metotlar uzerine
	// koyabiliriz.
	// setter uzerine koymak anlam ifade etmez.

	// AUTO
	// TABLE
	// SEQUENCE
	// IDENTITY
	@GeneratedValue(strategy = GenerationType.AUTO)
	// MYSQL icin SEQUENCE adinda bir tablo olusur.
	// SEQ_NAME SEQ_COUNT kolonlari
	// ROW/RECORD -> SEQ_GEN default allocation 50

	// @GeneratedValue(strategy=GenerationType.TABLE)
	// SEQUENCE tablosu olusur.
	// ROW/RECORD -> SEQ_GEN_TABLE

//	@TableGenerator(name="EMP_GEN")
//	@GeneratedValue(generator="EMP_GEN")

//	@TableGenerator(name="EMP_GEN_DETAILED", table="KEY_GEN" , pkColumnName="ID_NAME" , valueColumnName="COUNT" , initialValue=1000)
//	@GeneratedValue(generator="EMP_GEN_DETAILED")

	// @GeneratedValue(strategy=GenerationType.SEQUENCE)
	// MYSQL de Sequence kavrami yerine AUTO_INCREMENT kavrami vardir.

	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	// AUTO_INCREMENT
	//

//	@SequenceGenerator(name="SEQ_GEN" , sequenceName="ilgili veritabandaki sequence objesinin adi")
//	@GeneratedValue(generator="SEQ_GEN")

	@Column(name = "emp_id")
	private int id;

	@Column(name = "emp_name")
	private String name;

	@Column(name = "emp_surname")
	private String surname;

	@Column(name = "emp_salary")
	private int salary;

	@Column(name = "emp_type")
	// varsayilan olarak enumdaki ordinal sirasina gore veritabanina deger kaydeder.

	@Enumerated(EnumType.STRING)
	private EmployeeType employeeType;

	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Column(name = "emp_image")
	@Lob
	private byte[] image;

	// Many -> Employee
	// One -> Department

	@ManyToOne
	@JoinColumn(name = "dept_id")
	// @Column(name = "dept_id")
	// burada @Column annotation i OLMAZ
	// Exception Description: Entity class [class entity.Employee] must use a
	// @JoinColumn instead of @Column to map its relationship attribute
	// [department].
	private Department department;

	// Employee tablosunda bu iliski icin bir column olusur.
	// (foreign key)
	// varsayilan olarka ismi propertyName_idName

	@OneToOne
	@JoinColumn(name = "ps_id", unique = true)
	// @OneToOne JPA spect ine gore 1-1 olmali.
	// fakat EclipseLink bu kurala uymuyor.
	// Hibernate JPA da test edilirse unique olmayan bir durumda patlar.
	// bu durumda unique attribute unu kullanabiliriz!
	private ParkingSpace parkingSpace;

	//

	@OneToMany
//	@JoinTable(name="EMP_PHN" ,
//	joinColumns= @JoinColumn( name="EMP_ID"),
//	inverseJoinColumns=@JoinColumn(name="PHN_ID"))
//	
	@JoinColumn(name = "EMP_ID")
	private List<Phone> phones = new ArrayList<>();

	//

	@ManyToMany
	// ManyToMany bir iliskide ayri bir tablo olmak zorundadir.
	// Tabloyu modifiye edebiliriz.
	@JoinTable(name = "EMP_PR", joinColumns = @JoinColumn(name = "EMP_ID"), inverseJoinColumns = @JoinColumn(name = "PR_ID"))
	private List<Project> projects;

	// bu haliyle unidirectional ManyToMany bir iliski vardir.

	// eger Project tarafinda da List<Employee> olursa bu durumda bir tarafi
	// owningside secmemiz gerekir.
	// manytomany bir iliskide owning side secimliktir.bi tarafi seceriz.
	// inverse side tarafinda mappedBy attribute unu kullaniriz.
	// eger mappedBy kullanilmazsa bu durumda 2 tane tablo olusur.

	@Embedded
	private Address address;

	//

	// String -> Entity degil!
	@ElementCollection
	// @CollectionTable annotation ile konfigurasyon yapabiliriz.
	@CollectionTable(name = "EMP_EMAILS", joinColumns = @JoinColumn(name = "EMP_ID"))
	@Column(name = "EMAIL_ADDRESS")
	private List<String> emails;

	@ElementCollection
	@CollectionTable(name="EMP_PHN_MAP" , joinColumns=@JoinColumn(name="EMP_ID"))
	@MapKeyColumn(name="PHN_TYPE")
	@Column(name="PHN_NUM")
	private Map<String, String> phoneNumbers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public ParkingSpace getParkingSpace() {
		return parkingSpace;
	}

	public void setParkingSpace(ParkingSpace parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public Map<String, String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Map<String, String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary
				+ ", employeeType=" + employeeType + ", startDate=" + startDate + ", image=" + Arrays.toString(image)
				+ ", department=" + department + "]";
	}

}
