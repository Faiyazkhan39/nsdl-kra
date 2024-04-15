package com.nsdl.kra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsdl.kra.model.dao.EmployeesDao;
import com.nsdl.kra.model.dto.Employees;
import com.nsdl.kra.services.EmployeesService;


@RestController
@RequestMapping("/emp")
public class EmployeesController {

    @Autowired
    private EmployeesService employeesService;

    @GetMapping()
    public List<Employees> getAllEmployees(){
        return employeesService.getAllEmployees();
    }

    @PostMapping()
    public EmployeesDao saveEmployees(@RequestBody Employees employees){
        return employeesService.saveEmployee(employees);
    }

    @PostMapping("/sp")
    public String saveEmployeesBySP(@RequestBody Employees employees){
         //employeesService.createEmployee(employees.getName(),employees.getEmail(),employees.getDepartment(),employees.getHireDate());
        employeesService.createCustomEmp(employees);
        return "successfully save";
    }
}
