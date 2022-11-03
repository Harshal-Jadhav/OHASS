package com.masai.Model.Service;

import java.util.List;

import com.masai.Exceptions.CredentialsException;
import com.masai.Exceptions.InvalidInputException;
import com.masai.Exceptions.RecordsNotFoundException;
import com.masai.Model.Entities.Complaints;
import com.masai.Model.Entities.Engineer;



public interface AdminServices {

	public boolean register(String fname, String lname, String dept, String username, String password)
			throws RecordsNotFoundException;

	public List<Engineer> viewAllEngineers() throws RecordsNotFoundException;

	public boolean removeEngineer(int id) throws RecordsNotFoundException;

	public List<Complaints> viewUnassignedComplaints() throws RecordsNotFoundException;

	public List<Complaints> viewAssignedComplaints() throws RecordsNotFoundException;

	public List<Complaints> viewAllComplaints() throws RecordsNotFoundException;

	public boolean assignEngineer(String compId, int EngId) throws InvalidInputException;

	public String login(String username, String password) throws CredentialsException;

}
