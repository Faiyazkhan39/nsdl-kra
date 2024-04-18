package com.nsdl.kra.model.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "users")
@Entity
public class UserDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_type_id")
    private Long userTypeId;

    @Column(name = "branch")
    private String branch;

    @Column(name = "certificate_no")
    private String certificateNo;

    @Column(name = "department")
    private String department;

    @Column(name ="designation")
    private String designation;

    @Column(name ="email_id")
    private String emailId;

    @Column(name = "group_id")
    private String groupId;

    @Column(name ="issuerca")
    private String issuerCa;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_no")
    private String phoneNumber;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;
}
