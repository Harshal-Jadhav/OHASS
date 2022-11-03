package com.masai.Model.Service;

import java.util.List;

import com.masai.Exceptions.CredentialsException;
import com.masai.Exceptions.InvalidInputException;
import com.masai.Exceptions.RecordsNotFoundException;
import com.masai.Model.Entities.Complaints;
import com.masai.Model.Entities.Employee;

public interface EmployeeServices {

//	Method to Register a new Employee.
	public boolean registerEmployee(String fname, String lname, String dept, String username, String password)
			throws RecordsNotFoundException;

//	Method to Check the login Credentials and return Employee Object if all are correct.
	public Employee employeeLogin(String username, String password) throws CredentialsException;

//	Method for Employee to Raise a new Complaint.
	public boolean raiseComplaint(int EmpId, String description, String type) throws RecordsNotFoundException;

//	Method to Check the status of the complaint.
	public Complaints checkComplaintStatus(String CompId, int empid)
			throws InvalidInputException, RecordsNotFoundException;

//	Method to Get all the Raised Complaints by the Employee.
	public List<Complaints> getAllRaisedComplaints(int EmpId) throws RecordsNotFoundException;

}
