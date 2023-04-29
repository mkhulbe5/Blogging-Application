package com.mohit.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.blog.entities.Post;
import com.mohit.blog.payload.ApiResponse;
import com.mohit.blog.payload.PostDto;
import com.mohit.blog.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostService postService;

	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(
			@RequestBody PostDto postDto, @PathVariable Integer userId,@PathVariable Integer categoryId){
	  PostDto createdPost = this.postService.createPost(postDto, userId, categoryId);
	  return new ResponseEntity<PostDto>(createdPost,HttpStatus.CREATED);
	}
	
	  
	  //get By User
	  @GetMapping("/user/{userId}/posts")
	  public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
		  List<PostDto> allPostByUser = this.postService.getAllPostByUser(userId);
		  return new ResponseEntity<List<PostDto>>(allPostByUser,HttpStatus.OK);
	  }
	  
	//get By Category
	  @GetMapping("/category/{categoryId}/posts")
	  public ResponseEntity<List<PostDto>> getPostCategory(@PathVariable Integer categoryId){
		  List<PostDto> allPostByUser = this.postService.getPostByCategory(categoryId);
		  return new ResponseEntity<List<PostDto>>(allPostByUser,HttpStatus.OK);
	  }
	  
	  //get all posts
	  @GetMapping("/posts")
	  public ResponseEntity<List<PostDto>>getAllPost(){
		  List<PostDto> allPost = this.postService.getAllPost();
		  return new ResponseEntity<List<PostDto>>(allPost,HttpStatus.OK);
	  }
	  
	  //get single post
	  @GetMapping("/posts/{postId}")
	  public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
		  PostDto postById = this.postService.getPostById(postId);
		  return new ResponseEntity<PostDto>(postById,HttpStatus.OK);
	  }
	  
	  //Update Post
	  @PutMapping("/posts/{postId}")
	  public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId){
		  PostDto updatePost =  this.postService.updatePost(postDto, postId);
		  return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
	  }
	  
	  //Delete a post
	  @DeleteMapping("/posts/{postId}")
	  public ApiResponse DeletePost(@PathVariable Integer postId) {
		 this.postService.deletePost(postId);
		 return new ApiResponse("Post has been deleted successfully",true);
	  }
	
	  
}
