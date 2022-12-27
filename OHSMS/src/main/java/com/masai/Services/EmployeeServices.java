package com.masai.Services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.masai.Models.Complaint;
import com.masai.Models.Employee;
import com.masai.Payload.Request.SignUpRequest;

public interface EmployeeServices {

	// Method to register new Employee;
	public Employee registerNewEmployee(SignUpRequest signUpRequest);

	//	Method to get All complaints raised so far.
	public List<Complaint> getAllComplaints(HttpServletRequest httpServletRequest);

	// Method to get Complaint by Id;
	public Complaint getComplaintById(HttpServletRequest httpServletRequest, String complaintId);

}