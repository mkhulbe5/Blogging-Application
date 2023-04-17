package com.mohit.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mohit.blog.entities.Category;
import com.mohit.blog.entities.Post;
import com.mohit.blog.payload.PostDto;

@Service
public interface PostService {

	//Create Post
	Post createPost(PostDto postDto);
	
	//Update Post
	Post updatePost(PostDto postDto,Integer postId);
	
	//Delete Post
	void deletePost(Integer postId);
	
	//Get Post
	Post getPostById(Integer postId);
	
	//Get All Post
	List<Post> getAllPost();
	
	//get All By Category
	List<Post>getAllPostByCategory(Integer categoryId);
	
	//Get All Post By User
	List<Post> getAllPostByUser(Integer userId);
}
