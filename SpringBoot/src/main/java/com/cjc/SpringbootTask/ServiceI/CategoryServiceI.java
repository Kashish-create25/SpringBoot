package com.cjc.SpringbootTask.ServiceI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cjc.SpringbootTask.model.Category;

public interface CategoryServiceI {

	Page<Category> getAllCategories(PageRequest of);
	
	Category getCategoryById(Long id);

	Category createCategory(Category category);

	Category updateCategory(Long id, Category categoryDetails );

	void deleteCategory(Long id);

}
