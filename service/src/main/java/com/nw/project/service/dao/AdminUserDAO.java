package com.nw.project.service.dao;

import com.nw.project.service.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminUserDAO extends JpaRepository<AdminUser,Integer> {
    AdminUser findByUserNameAndPassword(String userName, String password);

    List<AdminUser> findByUserName(String userName);
}
