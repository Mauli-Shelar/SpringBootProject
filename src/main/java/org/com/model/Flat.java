package org.com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FlatRecords")
public class Flat {

	@Id
	private Integer flatId;

	@Column
	private String buildNumber;

	@Column
	private String flatFamilyName;

	@Column
	private String joinSoc;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Person> familyMembers;



	@Override
	public String toString() {
		return "Flat [flatId=" + flatId + ", buildNumber=" + buildNumber + ", flatFamilyName=" + flatFamilyName
				+ ", joinSoc=" + joinSoc + ", familyMembers=" + familyMembers + "]";
	}

	public Flat(Integer flatId, String buildNumber, String flatFamilyName, String joinSoc, List<Person> familyMembers) {
		super();
		this.flatId = flatId;
		this.buildNumber = buildNumber;
		this.flatFamilyName = flatFamilyName;
		this.joinSoc = joinSoc;
		this.familyMembers = familyMembers;
	}

	public Flat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getFlatId() {
		return flatId;
	}

	public void setFlatId(Integer flatId) {
		this.flatId = flatId;
	}

	public String getBuildNumber() {
		return buildNumber;
	}

	public void setBuildNumber(String buildNumber) {
		this.buildNumber = buildNumber;
	}

	public String getFlatFamilyName() {
		return flatFamilyName;
	}

	public void setFlatFamilyName(String flatFamilyName) {
		this.flatFamilyName = flatFamilyName;
	}

	public String getJoinSoc() {
		return joinSoc;
	}

	public void setJoinSoc(String joinSoc) {
		this.joinSoc = joinSoc;
	}

	public List<Person> getFamilyMembers() {
		return familyMembers;
	}

	public void setFamilyMembers(List<Person> familyMembers) {
		this.familyMembers = familyMembers;
	}

}
