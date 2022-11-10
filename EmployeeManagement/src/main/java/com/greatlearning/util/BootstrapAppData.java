package com.greatlearning.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.greatlearning.entity.Employee;
import com.greatlearning.entity.Role;
import com.greatlearning.entity.User;
import com.greatlearning.repository.UserRepository;
import com.greatlearning.repository.employeeRepository;

@Component
public class BootstrapAppData {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private employeeRepository empRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@EventListener(ApplicationReadyEvent.class)
	public void insertData(ApplicationReadyEvent event) {
		Employee employee = new Employee();
		employee.setFirstName("Java 11");
		employee.setLastName("Head-First Java");
		employee.setEmail("programming");
		
		Employee employee2 = new Employee();
		employee2.setFirstName("Node js");
		employee2.setLastName("Practical NodeJS");
		employee2.setEmail("programming");
		
		Employee employee3 = new Employee();
		employee3.setFirstName("python");
		employee3.setLastName("Head-First Python");
		employee3.setEmail("programming");
		
		this.empRepository.save(employee);
		this.empRepository.save(employee2);
		this.empRepository.save(employee3);

	}
		
	@EventListener(ApplicationReadyEvent.class)
	public void insertUsers(ApplicationReadyEvent event) {
		
		User janani = new User();
		janani.setUsername("janani");
		janani.setPassword(this.passwordEncoder.encode("HelloJava"));
		
		User Balaji = new User();
		Balaji.setUsername("Balaji");
		Balaji.setPassword(this.passwordEncoder.encode("HelloJava"));
		
		Role userRole = new Role();
		userRole.setName("ROLE_USER");
		
		Role adminRole = new Role();
		adminRole.setName("ROLE_ADMIN");
		
		List<Role> roles = janani.getRoles();
		roles.add(userRole);
		
		Role BalajiuserRole = new Role();
		BalajiuserRole.setName("ROLE_USER");
		
		List<Role> BalajiRoles = Balaji.getRoles();
		BalajiRoles.add(adminRole);
		BalajiRoles.add(BalajiuserRole);
		
		this.userRepository.save(janani);
		this.userRepository.save(Balaji);

	}
		
	
}
