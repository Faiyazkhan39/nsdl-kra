package com.nsdl.kra.model.dao;

import java.util.Date;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.nsdl.kra.repository.EmployeeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@NamedStoredProcedureQuery(name = "employee_type", procedureName = "insert_employee", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, type = EmployeeType.class, name = "p_employee") })
@Entity
@TypeDefs({ @TypeDef(name = "employee_type", typeClass = EmployeeType.class) })
@TypeDef(name = "employee_type", typeClass = com.nsdl.kra.repository.EmployeeType.class)
@Table(name = "employees")
public class EmployeesDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;
    private String name;
    private String email;
    private String department;
    @Column(name = "hire_date")
    private Date hireDate;

}
