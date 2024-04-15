package com.nsdl.kra.repository;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeeType {
    private String name;
    private String email;
    private String department;
    private Date hire_date;

}
