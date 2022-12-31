package com.masai.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exceptions.InvalidInputException;
import com.masai.Exceptions.RecordsNotFoundException;
import com.masai.Models.Complaint;
import com.masai.Payload.Request.UpdateComplaintRequest;
import com.masai.Services.EngineerServices;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/ohsms/engineer")
public class EngineerController {

	@Autowired
	private EngineerServices engineerServices;

	@GetMapping("/complaints/new")
	public ResponseEntity<List<Complaint>> getNewlyAssignedComplaints(HttpServletRequest httpServletRequest) throws RecordsNotFoundException{
		List<Complaint> complaints = engineerServices.getNewlyAssignedComplaints(httpServletRequest);
		return new ResponseEntity<List<Complaint>>(complaints,HttpStatus.OK);
	}

	@GetMapping("/complaints/resolved")
	public ResponseEntity<List<Complaint>> getAllResolvedComplaints(HttpServletRequest httpServletRequest)
			throws RecordsNotFoundException {
		List<Complaint> complaints = engineerServices.getAllResolvedComplaints(httpServletRequest);
		return new ResponseEntity<List<Complaint>>(complaints, HttpStatus.OK);
	}

	@GetMapping("/complaints/under-progress")
	public ResponseEntity<List<Complaint>> getAllUnderPrgressComplaints(HttpServletRequest httpServletRequest)
			throws RecordsNotFoundException {
		List<Complaint> complaints = engineerServices.getAllUnderProgressComplaints(httpServletRequest);
		return new ResponseEntity<List<Complaint>>(complaints, HttpStatus.OK);
	}

	@PutMapping("/complaint/update")
	public ResponseEntity<Complaint> updateStatusOfComplaint(HttpServletRequest httpServletRequest,
			@RequestBody UpdateComplaintRequest complaintRequest)
					throws RecordsNotFoundException, InvalidInputException {
		Complaint complaint = engineerServices.UpdateStatusOfComplaint(httpServletRequest, complaintRequest);
		return new ResponseEntity<Complaint>(complaint, HttpStatus.OK);
	}
}
