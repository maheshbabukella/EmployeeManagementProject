package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//if we perform crud operations first implement one runner
public class EmployeeprojectApplication implements CommandLineRunner{

//after create an employee now stored in database means repository
	@Autowired
	employeerepository emprepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	//	we create one employee that is stored in our databse
		
		employeedetails emp=new employeedetails();
		emp.setName("mahesh");
		emp.setSalary(10000);
		
		employeedetails emp1=new employeedetails();
		emp1.setName("varshi");
		emp1.setSalary(500);
		
		employeedetails emp2=new employeedetails();
		emp2.setName("sita");
		emp2.setSalary(10);
		
		
		List<employeedetails> listofallemployees=Arrays.asList(emp,emp1,emp2);
//saveall method returns the list so we create it		
		
		
		
//after intialized repository we can perform crud operations
		emprepo.saveAll(listofallemployees);
		
		
// now we get the employee based on id
	Optional<employeedetails> employee=emprepo.findById(1);
	System.out.println(employee.get());
//or this is the another method to get it
//	employeedetails employee=empreo.findById(1).get();
	
	
	
	
	
	//now update the employee details
	
	employeedetails employee1=emprepo.findById(1).get();
	employee1.setName("mahesh babu");
	employee1.setSalary(2400000);
	emprepo.save(employee1);
	System.out.println("updated!!");
	
	
	
	
	
	
    //now delete the employee
	
	employeedetails employee2=emprepo.findById(3).get();
	emprepo.delete(employee2);
	System.out.println("deleted!!!");
	
	
	
	
	
	
	}

}
