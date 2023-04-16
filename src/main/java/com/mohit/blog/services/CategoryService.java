package com.mohit.blog.services;

import java.util.List;
import com.mohit.blog.payload.CategoryDto;
public interface CategoryService {

	
	//create
	CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	
	//Delete
	void deleteCategory(Integer categoryId);
	
	//Get
	CategoryDto getCategory(Integer categoryId);
	
	//Get All Categories
	
	List<CategoryDto> getCategories();
}
