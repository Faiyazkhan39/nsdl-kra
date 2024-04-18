package com.nsdl.kra.model.dao;

import java.util.Date;

import lombok.Data;

@Data
//@Embeddable
// @Entity
public class EmployeesCustom {

    // @Column(insertable=false, updatable=false)
    private String name;
    // @Column(insertable=false, updatable=false)
    private String email;
    // @Column(insertable=false, updatable=false)
    private String department;
    // @Column(insertable=false, updatable=false)
    private Date hire_date;
}
