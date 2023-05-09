package com.mohit.blog.payload;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.mohit.blog.entities.Category;
import com.mohit.blog.entities.Comment;
import com.mohit.blog.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	
	private Integer postId;
	private String title; 
	private String content;
	private String imageName;
	private Date addedDate;
	private CategoryDto category;
	private UserDTO user;
	private Set<Comment> comments = new HashSet<>();
	
}
