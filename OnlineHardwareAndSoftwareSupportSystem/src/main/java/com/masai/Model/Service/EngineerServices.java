package com.masai.Model.Service;

import java.util.List;

import com.masai.Exceptions.CredentialsException;
import com.masai.Exceptions.InvalidInputException;
import com.masai.Exceptions.RecordsNotFoundException;
import com.masai.Model.Entities.Complaints;
import com.masai.Model.Entities.Engineer;



public interface EngineerServices {

	public Engineer login(String username, String password) throws CredentialsException;

	public List<Complaints> viewAssignedProblems(int EngId) throws RecordsNotFoundException;

	public boolean updateStatus(String compId, String Status, int engId)
			throws RecordsNotFoundException, InvalidInputException;

	public List<Complaints> viewAllAttendedProblems(int EngId) throws RecordsNotFoundException;

	public boolean changePassword(int EngId, String oldpass, String newpass) throws InvalidInputException;

}
