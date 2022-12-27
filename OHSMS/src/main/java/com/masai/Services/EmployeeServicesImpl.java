package com.masai.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;

import com.masai.Models.Complaint;
import com.masai.Models.Employee;
import com.masai.Models.Users;
import com.masai.Payload.Request.SignUpRequest;
import com.masai.Repositories.EmployeeRepo;
import com.masai.Repositories.UserRepo;

import io.jsonwebtoken.Jwts;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper mapper;

	@Value("${ohsms.jwt.secretKey}")
	private String secretKey;

	@Value("${ohsms.jwt.cookieName}")
	private String cookieName;

	@Override
	public Employee registerNewEmployee(SignUpRequest signUpRequest) {

		Users savedUser = userRepo.save(mapper.map(signUpRequest, Users.class));

		Employee savedEmployee = employeeRepo.save(mapper.map(savedUser, Employee.class));

		return savedEmployee;
	}

	@Override
	public List<Complaint> getAllComplaints(HttpServletRequest httpServletRequest) {
		String username = getUserName(httpServletRequest);

		Optional<Employee> employee = employeeRepo.findByUsername(username);

		return employee.get().getComplaints();
	}

	@Override
	public Complaint getComplaintById(HttpServletRequest httpServletRequest, String complaintId) {
		String username = getUserName(httpServletRequest);

		Optional<Employee> employee = employeeRepo.findByUsername(username);

		List<Complaint> complaint = employee.get().getComplaints().stream().filter(c -> c.getId() == complaintId)
				.collect(Collectors.toList());

		return complaint.get(0);
	}

	protected String getUserName(HttpServletRequest httpServletRequest) {
		String username = Jwts.parser().setSigningKey(secretKey)
				.parseClaimsJws((WebUtils.getCookie(httpServletRequest, cookieName)).getValue()).getBody().getSubject();

		return username;
	}

}
