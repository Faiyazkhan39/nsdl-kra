package com.nsdl.kra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nsdl.kra.model.dao.UserDao;


@Repository
public interface UsersRepository extends JpaRepository<UserDao,Long>{
    UserDao findByUserId(String userId);
    UserDao findByUserName(String userName);
}
