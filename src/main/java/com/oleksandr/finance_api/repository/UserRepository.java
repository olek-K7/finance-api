package com.oleksandr.finance_api.repository;

import com.oleksandr.finance_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
    public boolean existsByEmail(String email);
}
