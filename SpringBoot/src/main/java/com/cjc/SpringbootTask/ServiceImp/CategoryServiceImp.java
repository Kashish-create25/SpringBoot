package com.cjc.SpringbootTask.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cjc.SpringbootTask.ServiceI.CategoryServiceI;
import com.cjc.SpringbootTask.model.Category;
import com.cjc.SpringbootTask.repository.CategoryRepository;
@Service
public class CategoryServiceImp implements CategoryServiceI{

	@Autowired
	private CategoryRepository cr;

	@Override
	public Page<Category> getAllCategories(PageRequest of) {
		return cr.findAll(of);
	}

	@Override
	public Category getCategoryById(Long id) {
		return cr.findById(id).orElseThrow(()-> new RuntimeException("category not found"));
	}

	@Override
	public Category createCategory(Category category) {
		return cr.save(category);
	}

	@Override
	public Category updateCategory(Long id, Category categoryDetails) {
		Category category=getCategoryById(id);
		category.setName(categoryDetails.getName());
		return cr.save(category);
	}

	@Override
	public void deleteCategory(Long id) {
		cr.deleteById(id);
	}


	
}