package com.fita.taskmanagement.bean;

import java.util.List;

public class CompanyDTO {
	private Integer companyId;
	private String companyName;
	private String address;
	private String pincode;
	private List<Integer> teamIds;
	
	public CompanyDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Iterable<Integer> getTeamIds() {
		return teamIds;
	}

	public void setTeamList(List<Integer> teamIds) {
		this.teamIds = teamIds;
	}
	
	
}
