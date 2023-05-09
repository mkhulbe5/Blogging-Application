package com.mohit.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit.blog.entities.Comment;
import com.mohit.blog.entities.Post;
import com.mohit.blog.exceptions.ResourceNotFoundException;
import com.mohit.blog.payload.CommentDto;
import com.mohit.blog.payload.PostDto;
import com.mohit.blog.repositories.CommentRepo;
import com.mohit.blog.repositories.PostRepo;
import com.mohit.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;

	@Autowired
	private ModelMapper modelmapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		// TODO Auto-generated method stub
		Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "postId", postId));
		Comment comment = this.modelmapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment savedComment = this.commentRepo.save(comment);
		return this.modelmapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		// TODO Auto-generated method stub
		Comment com = this.commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment", "commentId", commentId));
		    this.commentRepo.delete(com);
	}

	
}
