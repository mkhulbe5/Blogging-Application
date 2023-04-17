package com.mohit.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit.blog.entities.Category;
import com.mohit.blog.entities.Post;
import com.mohit.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	List<Post> findByUser(User user);
	List<Category>findByCategory(Category category);

}
