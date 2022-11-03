package com.masai.Model.DAO;

import java.util.List;

import com.masai.Model.Entities.Complaints;
import com.masai.Model.Entities.Engineer;

public interface EngineerDAO {

	public Engineer login(String username, String password);

	public List<Complaints> viewAssignedProblems(int EngId);

	public boolean updateStatus(String compId, String Status, int engId);

	public List<Complaints> viewAllAttendedProblems(int EngId);

	public boolean changePassword(int EngId, String oldpass, String newpass);

}
