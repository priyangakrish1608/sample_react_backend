package com.react.sample.model;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	private static List<EmployeeEntity> EMPLOYEE_LIST = new ArrayList<EmployeeEntity>();
	private static int EMPLOYEE_COUNT = 7;
	static {
		
	
		  EMPLOYEE_LIST.add(new EmployeeEntity(1, "Loy", 25, "Female",
		  "loy@example.com", 25000, "Sales")); EMPLOYEE_LIST.add(new EmployeeEntity(2,
		  "Aswin", 22, "Male", "aswin@example.com", 25000, "Accounts"));
		  EMPLOYEE_LIST.add(new EmployeeEntity(3, "Preethi", 27, "Female",
		  "preethi@example.com", 27000, "Testing")); EMPLOYEE_LIST.add(new
		  EmployeeEntity(4,"Chandharan", 29, "Male", "chandharan@example.com", 30000,
		  "HR")); EMPLOYEE_LIST.add(new EmployeeEntity(5, "Sreesha", 23, "Female",
		  "sreesha@example.com", 10000, "Supporting")); EMPLOYEE_LIST.add(new
		  EmployeeEntity(6, "Amutha", 28,"Female", "aumtha@example.com", 15000,
		  "Supporting")); EMPLOYEE_LIST.add(new EmployeeEntity(7, "shakthi", 23,
		  "Male", "shakthi@example.com", 32000, "Project Manager"));
		 
		 
		
		}
	
	public List<EmployeeEntity> findAll() {
		return EMPLOYEE_LIST;
	}
	
	public EmployeeEntity findOne(int id) {
		return EMPLOYEE_LIST.stream().filter(t -> {
			if(t.getId() == id) {
				return true;
			}
			return false;
		}).findFirst().get();
	}
	public EmployeeEntity save(EmployeeEntity employeeBean) {
		if (employeeBean.getId() == null) {
			employeeBean.setId(++EMPLOYEE_COUNT);
			EMPLOYEE_LIST.add(employeeBean);
		}
		return employeeBean;
	}
	public EmployeeEntity update(EmployeeEntity employeeBean) {
		for (int i = 0; i < EMPLOYEE_LIST.size();i++) {
			EmployeeEntity tmpEmployeeBean = EMPLOYEE_LIST.get(i);
			if (tmpEmployeeBean.getId() == employeeBean.getId()) {
				EMPLOYEE_LIST.set(i, employeeBean);
			}
		}
		return employeeBean;
	}
	public void delete(int Id) {
		EMPLOYEE_LIST.removeIf(t -> {
			if (t.getId() == Id) {
				return true;
			}
			return false;
		});
	}

}
