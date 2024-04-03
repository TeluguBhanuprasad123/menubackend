package com.codelibary.www.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codelibary.www.entity.ClientEntity;
import com.codelibary.www.entity.Departments;
import com.codelibary.www.repository.DepartmentsRepository;
import com.codelibary.www.service.DepartmentService;

@Service
public class DepartmentServiceimpl implements DepartmentService {

	@Autowired
	private DepartmentsRepository departmentsRepository;

	@Override
	public Departments saveDepartment(ClientEntity bussiness_id, String depName) {
		Departments d = new Departments();
		d.setClientEnitys(bussiness_id);
		d.setDepName(depName);
		return departmentsRepository.save(d);
	}

	@Override
	public Departments getDepartmentById(long id) {
		Optional<Departments> optionalDepartment = departmentsRepository.findById(id);
		return optionalDepartment.orElse(null);
	}

	@Override
	public List<Departments> getAllDepartments() {
		return departmentsRepository.findAll();
	}

	@Override
	public void deleteDepartment(long id) {
		departmentsRepository.deleteById(id);
	}

	@Override
	public Departments updateDepartment(long id, String depName) {
	    Optional<Departments> optionalDepartment = departmentsRepository.findById(id);
	    if (optionalDepartment.isPresent()) {
	        Departments department = optionalDepartment.get();
	        if (depName != null) {
	            department.setDepName(depName);
	        }
	        return departmentsRepository.save(department);
	    } else {
	        return null; 
	    }
	}


	@Override
	public List<Departments> getDepartmentsByBusinessId(String businessId) {
	    return departmentsRepository.findByBusinessIdNative(businessId);
	}


}
