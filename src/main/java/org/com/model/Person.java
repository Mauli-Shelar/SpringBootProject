package org.com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Person_records")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer personId;
	
	@Column
	private String personName;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<MobileNumber> mobileNumbers;
	
	@Column
	private String personEmail;
	
	@Column
	private String personGender;
	
	@Column
	private String personBirthPlace;
	
	@Column
	private String personBday;
	
	public Person(Integer personId, String personName, List<MobileNumber> mobileNumbers, String personEmail,
			String personGender, String personBirthPlace, String personBday, String personLocation) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.mobileNumbers = mobileNumbers;
		this.personEmail = personEmail;
		this.personGender = personGender;
		this.personBirthPlace = personBirthPlace;
		this.personBday = personBday;
		this.personLocation = personLocation;
	}

	public String getPersonBday() {
		return personBday;
	}

	public void setPersonBday(String personBday) {
		this.personBday = personBday;
	}

	@Column
	private String personLocation;


	
	
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", mobileNumbers=" + mobileNumbers
				+ ", personEmail=" + personEmail + ", personGender=" + personGender + ", personBirthPlace="
				+ personBirthPlace + ", personBday=" + personBday + ", personLocation=" + personLocation + "]";
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public List<MobileNumber> getMobileNumbers() {
		return mobileNumbers;
	}

	public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
		this.mobileNumbers = mobileNumbers;
	}

	public String getPersonEmail() {
		return personEmail;
	}

	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}

	public String getPersonGender() {
		return personGender;
	}

	public void setPersonGender(String personGender) {
		this.personGender = personGender;
	}

	public String getPersonBirthPlace() {
		return personBirthPlace;
	}

	public void setPersonBirthPlace(String personBirthPlace) {
		this.personBirthPlace = personBirthPlace;
	}

	public String getPersonLocation() {
		return personLocation;
	}

	public void setPersonLocation(String personLocation) {
		this.personLocation = personLocation;
	}
	
	
	
}
