package com.nsdl.kra.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Employees {
    private Long id;
    private String name;
    private String email;
    private String department;
    private Date hireDate;
}
