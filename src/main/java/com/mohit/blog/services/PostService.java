package com.mohit.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mohit.blog.entities.Category;
import com.mohit.blog.entities.Post;
import com.mohit.blog.payload.PostDto;

public interface PostService {

	//Create Post
	PostDto createPost(PostDto postDto,Integer postId,Integer categoryId);
	
	//Update Post
	Post updatePost(PostDto postDto,Integer postId);
	
	//Delete Post
	void deletePost(Integer postId);
	
	//Get Post
	Post getPostById(Integer postId);
	
	//Get All Post
	List<Post> getAllPost();
	
	//get All By Category
	List<PostDto>getPostByCategory(Integer categoryId);
	
	//Get All Post By User
	List<PostDto> getAllPostByUser(Integer userId);
	
	//Search A Post By Keyword
	List<Post> searchPosts(String keyword);
}
