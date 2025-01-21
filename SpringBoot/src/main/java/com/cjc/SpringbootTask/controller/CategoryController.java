package com.cjc.SpringbootTask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.SpringbootTask.ServiceI.CategoryServiceI;
import com.cjc.SpringbootTask.model.Category;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryServiceI cs;
	
	@GetMapping("/getAllData")
	public Page<Category> getAllCategories(@RequestParam(defaultValue ="0")int page,@RequestParam(defaultValue = "10")int size)
	{
		return cs.getAllCategories(PageRequest.of(page, size));
	}
	
	
	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable Long id)
	{
		return cs.getCategoryById(id);
	}
	
	@PostMapping("/createCategory")
	public Category CreateCategory(@RequestBody Category category)
	{
		return cs.createCategory(category);
	}
	
	@PutMapping("/{id}")
	public Category updateCategory(@PathVariable Long id,@RequestBody Category category)
	{
		return cs.updateCategory(id,category);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Long id)
	{
		cs.deleteCategory(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
