package com.cjc.SpringbootTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjc.SpringbootTask.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
