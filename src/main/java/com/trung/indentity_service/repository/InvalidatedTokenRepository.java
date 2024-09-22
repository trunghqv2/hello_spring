package com.trung.indentity_service.repository;

import com.trung.indentity_service.entity.InvalidatedToken;
import com.trung.indentity_service.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvalidatedTokenRepository extends JpaRepository<InvalidatedToken, String> {
}
