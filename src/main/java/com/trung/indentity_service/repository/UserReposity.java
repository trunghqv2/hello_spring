package com.trung.indentity_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trung.indentity_service.entity.User;

public interface  UserReposity extends  JpaRepository<User,String>{
    
}
    