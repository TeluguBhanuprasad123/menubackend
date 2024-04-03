package com.codelibary.www.service;

import java.util.List;

import com.codelibary.www.entity.ClientEntity;
import com.codelibary.www.entity.Departments;

public interface DepartmentService {

	Departments saveDepartment(ClientEntity bussiness_id, String depName);

	Departments getDepartmentById(long id);

	List<Departments> getAllDepartments();

	void deleteDepartment(long id);

	Departments updateDepartment(long id, String depName);

	List<Departments> getDepartmentsByBusinessId(String businessId);

}
