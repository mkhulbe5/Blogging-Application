package com.mohit.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mohit.blog.entities.Category;
import com.mohit.blog.entities.Post;
import com.mohit.blog.payload.PostDto;
import com.mohit.blog.payload.PostResponse;

public interface PostService {

	//Create Post
	PostDto createPost(PostDto postDto,Integer postId,Integer categoryId);
	
	//Update Post
	PostDto updatePost(PostDto postDto,Integer postId);
	
	//Delete Post
	void deletePost(Integer postId);
	
	//Get Post
	PostDto getPostById(Integer postId);
	
	//Get All Post
	PostResponse getAllPost(Integer pageNumber,Integer pageSize);
	
	//get All By Category
	List<PostDto>getPostByCategory(Integer categoryId);
	
	//Get All Post By User
	List<PostDto> getAllPostByUser(Integer userId);
	
	//Search A Post By Keyword
	List<Post> searchPosts(String keyword);
}
