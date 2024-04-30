package tn.care4elders.clinivia.service.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.care4elders.clinivia.entity.Complaint;
import tn.care4elders.clinivia.entity.Department;
import tn.care4elders.clinivia.repository.DepartmentRepository;
import tn.care4elders.clinivia.service.DepartmentService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    public DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(long Id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(Id);
        return optionalDepartment.orElse(null);
    }

    @Override
    public void deleteDepartment(long Id) {
        departmentRepository.deleteById(Id);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }


}

