package com.nsdl.kra.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsdl.kra.exceptions.NoDataException;
import com.nsdl.kra.model.dao.EmployeesDao;
import com.nsdl.kra.model.dto.Employees;
import com.nsdl.kra.repository.EmployeeType;
import com.nsdl.kra.repository.EmployeesRepository;

@Service
public class EmployeesService {

    @Autowired
    private EmployeesRepository employeesRepository;

    public EmployeesDao saveEmployee(Employees employee) {
        EmployeesDao emp = new EmployeesDao();
        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());
        emp.setDepartment(employee.getDepartment());
        emp.setHireDate(employee.getHireDate());
        return employeesRepository.save(emp);
    }

    public List<Employees> getAllEmployees() throws Exception {

        List<EmployeesDao> empList = employeesRepository.findAll();
        List<Employees> empListDTO = new ArrayList<>();
        if ((empList.size() > 1)) {
            throw new NoDataException("Welcome");
        }

        for (EmployeesDao employee : empList) {
            Employees emp = new Employees();
            emp.setId(employee.getId());
            emp.setName(employee.getName());
            emp.setEmail(employee.getEmail());
            emp.setDepartment(employee.getDepartment());
            emp.setHireDate(employee.getHireDate());
            empListDTO.add(emp);
        }
        try {
            throw new NoDataException("Testing");
        } catch (Exception e) {
            System.out.println("Testub");
        }
        return null;

    }

    public void createEmployee(String name, String email, String department, Date hireDate) {
        employeesRepository.insert_Employee(name, email, department, hireDate);
    }

    public void createCustomEmp(Employees employees) {
        EmployeeType empType = new EmployeeType();
        empType.setName(employees.getName());
        empType.setEmail(employees.getEmail());
        empType.setDepartment(employees.getDepartment());
        empType.setHire_date(employees.getHireDate());
        EmployeesDao employeesDao = new EmployeesDao();
        employeesDao.setName(employees.getName());
        employeesDao.setEmail(employees.getEmail());
        employeesDao.setDepartment(employees.getDepartment());
        employeesDao.setHireDate(employees.getHireDate());
        // employeesDao.setEmployeeType(empType);
        employeesRepository.insertEmployeeCustomType(empType);

    }

}
