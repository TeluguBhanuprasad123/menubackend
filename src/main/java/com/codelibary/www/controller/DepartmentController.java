package com.codelibary.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codelibary.www.entity.ClientEntity;
import com.codelibary.www.entity.Departments;
import com.codelibary.www.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/save/{bussiness_id}")
	public ResponseEntity<Departments> saveDepartment(@PathVariable ClientEntity bussiness_id,
			@RequestParam String depName) {
		Departments depsave = departmentService.saveDepartment(bussiness_id, depName);

		return new ResponseEntity<>(depsave, HttpStatus.CREATED);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Departments> getDepartmentById(@PathVariable long id) {
		Departments department = departmentService.getDepartmentById(id);
		if (department != null) {
			return new ResponseEntity<>(department, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getalldepartments")
	public ResponseEntity<List<Departments>> getAllDepartments() {
		List<Departments> departments = departmentService.getAllDepartments();
		return new ResponseEntity<>(departments, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteDepartment(@PathVariable long id) {
		departmentService.deleteDepartment(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Departments> updateDepartment(@PathVariable long id, @RequestParam String depName) {
		Departments updatedDepartment = departmentService.updateDepartment(id, depName);
		if (updatedDepartment != null) {
			return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/business/{businessId}")
	public ResponseEntity<List<Departments>> getDepartmentsByBusinessId(@PathVariable String businessId) {
		List<Departments> departments = departmentService.getDepartmentsByBusinessId(businessId);
		return new ResponseEntity<>(departments, HttpStatus.OK);
	}

}
