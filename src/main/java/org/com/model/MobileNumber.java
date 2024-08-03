package org.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MobileBook")
public class MobileNumber {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer mobileId;

	@Column
	private String mobileNumber;

	@ManyToOne
	private Person personMobile;

	@Override
	public String toString() {
		return "MobileNumber [mobileId=" + mobileId + ", mobileNumber=" + mobileNumber + ", personMobile="
				+ personMobile + "]";
	}

	public MobileNumber() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MobileNumber(Integer mobileId, String mobileNumber, Person personMobile) {
		super();
		this.mobileId = mobileId;
		this.mobileNumber = mobileNumber;
		this.personMobile = personMobile;
	}

	public Integer getMobileId() {
		return mobileId;
	}

	public void setMobileId(Integer mobileId) {
		this.mobileId = mobileId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Person getPersonMobile() {
		return personMobile;
	}

	public void setPersonMobile(Person personMobile) {
		this.personMobile = personMobile;
	}

}
