package com.masai.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Models.Complaint;

public interface ComplaintRepo extends JpaRepository<Complaint, String> {

}
