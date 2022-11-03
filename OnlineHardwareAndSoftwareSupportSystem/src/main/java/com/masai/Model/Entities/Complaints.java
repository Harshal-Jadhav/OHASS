package com.masai.Model.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Complaints {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String compId;
	private String description;
	private String type;
	private String status;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Employee_ID", referencedColumnName = "empId")
	private Employee employee;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Engineer_ID", referencedColumnName = "engId")
	private Engineer engineer;

	public Complaints() {
		// TODO Auto-generated constructor stub
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Engineer getEngineer() {
		return engineer;
	}

	public void setEngineer(Engineer engineer) {
		this.engineer = engineer;
	}

	@Override
	public String toString() {
		return "Complaints [compId=" + compId + ", description=" + description + ", type=" + type + ", status=" + status
				+ ", employee=" + employee + ", engineer=" + engineer + "]";
	}

}
