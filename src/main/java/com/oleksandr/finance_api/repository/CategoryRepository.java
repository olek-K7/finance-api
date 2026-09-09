package com.oleksandr.finance_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.oleksandr.finance_api.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
