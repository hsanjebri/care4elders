package tn.care4elders.clinivia.service;

import org.springframework.stereotype.Service;
import tn.care4elders.clinivia.entity.Department;

import java.util.List;

@Service
public interface DepartmentService {
    Department saveDepartment(Department department);
    Department getDepartmentById(long id);
    void deleteDepartment(long id);
    List<Department> getAllDepartments();
    Department updateDepartment(Department department);
}
