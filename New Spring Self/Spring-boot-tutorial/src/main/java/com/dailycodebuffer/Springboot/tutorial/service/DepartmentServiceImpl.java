package com.dailycodebuffer.Springboot.tutorial.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.error.DepartmentNotFoundexception;
import com.dailycodebuffer.Springboot.tutorial.repository.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {

        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundexception {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (!department.isPresent()) {
            throw new DepartmentNotFoundexception("Department not found");
        } else {
            return department.get();
        }
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);

    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department deptDB = departmentRepository.findById(departmentId).get();
        if (Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())) {
            deptDB.setDepartmentName(department.getDepartmentName());
        }
        if (Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())) {
            deptDB.setDepartmentCode(department.getDepartmentCode());
        }
        if (Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            deptDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepository.save(deptDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }
}
