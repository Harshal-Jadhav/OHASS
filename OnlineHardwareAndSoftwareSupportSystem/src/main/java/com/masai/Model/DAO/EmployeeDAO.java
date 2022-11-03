package com.masai.Model.DAO;

import java.util.List;

import com.masai.Model.Entities.Complaints;
import com.masai.Model.Entities.Employee;

public interface EmployeeDAO {

//	Method to Register a new Employee.
	public boolean registerEmployee(String fname, String lname, String dept, String username, String password);

//	Method to Check the login Credentials and return Employee Object if all are correct.
	public Employee employeeLogin(String username, String password);

//	Method for Employee to Raise a new Complaint.
	public boolean raiseComplaint(int EmpId, String description, String type);

//	Method to Check the status of the complaint.
	public Complaints checkComplaintStatus(String CompId, int empid);

//	Method to Get all the Raised Complaints by the Employee.
	public List<Complaints> getAllRaisedComplaints(int EmpId);

}
