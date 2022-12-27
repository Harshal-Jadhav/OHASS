package com.masai.Payload.Request;

import com.masai.Enums.ComplaintStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateComplaintRequest {

	private ComplaintStatus status;

	private String remarks;
}
