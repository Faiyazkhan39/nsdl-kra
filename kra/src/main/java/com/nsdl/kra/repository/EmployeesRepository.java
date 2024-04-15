package com.nsdl.kra.repository;



import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.nsdl.kra.model.dao.EmployeesDao;

import io.lettuce.core.dynamic.annotation.Param;

@Repository
public interface EmployeesRepository extends JpaRepository<EmployeesDao,Long>{

      @Procedure(name = "insert_employee")
      void insert_Employee(
        @Param("p_name") String name,
        @Param("p_email") String email,
        @Param("p_department") String department,
        @Param(value = "p_hire_date") Date hireDate
    );

      @Procedure(name = "insert_employee")
     void insertEmployeeCustomType(@Param("p_employee") EmployeeType employee_type);

}
