package com.mohit.blog.services;

import com.mohit.blog.payload.CommentDto;

public interface CommentService {

	public CommentDto createComment(CommentDto commnDto,Integer postId);
	
	public void deleteComment(Integer commentId);
}
