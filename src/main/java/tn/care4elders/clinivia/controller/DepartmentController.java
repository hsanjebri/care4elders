package tn.care4elders.clinivia.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.care4elders.clinivia.entity.Complaint;
import tn.care4elders.clinivia.entity.Department;
import tn.care4elders.clinivia.service.DepartmentService;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/department")
HEAD

@CrossOrigin("*")
public class DepartmentController {
    DepartmentService departmentService;
    @PostMapping("/add")
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }
    @GetMapping ("/getbyid/{id}")
    public Department getDepartmentById(@PathVariable("id") long id) {
        return departmentService.getDepartmentById(id);
    }
    @PutMapping("/update")
    public Department updateDepartment(@RequestBody Department department) {
        return departmentService.updateDepartment(department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable("id") long id) {
        departmentService.deleteDepartment(id);
    }
    @GetMapping("/getall")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

}
