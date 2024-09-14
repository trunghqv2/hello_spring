package com.trung.indentity_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.security.Permission;

@Repository
public interface PremissionRepository extends JpaRepository<Permission, String> {
}
