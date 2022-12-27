package com.masai.Models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.masai.Enums.ComplaintStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Complaint {

	@Id
	private String Id;

	private String title;

	private String description;

	@Enumerated(EnumType.STRING)
	private ComplaintStatus status = ComplaintStatus.UNASSIGNED;

	private String remarks = "No Remarks Added.";

	@CreatedDate
	private LocalDate raised_On;

	@UpdateTimestamp
	private LocalDate last_Updated_On;

	@ManyToOne
	private Employee raisedBy;

	@ManyToOne
	private Engineer assignedTo;

}
