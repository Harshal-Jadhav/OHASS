package com.masai.Model.DAO;

import java.util.List;

import com.masai.Model.Entities.Complaints;
import com.masai.Model.Entities.Engineer;

public interface AdminDAO {

	public boolean register(String fname, String lname, String dept, String username, String password);

	public List<Engineer> viewAllEngineers();

	public boolean removeEngineer(int id);

	public List<Complaints> viewUnassignedComplaints();

	public List<Complaints> viewAssignedComplaints();

	public List<Complaints> viewAllComplaints();

	public boolean assignEngineer(String compId, int EngId);

	public String login(String username, String password);

}
