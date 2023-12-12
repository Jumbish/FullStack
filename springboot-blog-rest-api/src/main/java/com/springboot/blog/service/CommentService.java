package com.springboot.blog.service;

import java.util.List;

import com.springboot.blog.payload.CommentDto;

public interface CommentService {
	
	
	CommentDto createComment(long postId, CommentDto commentDto);
	
	List<CommentDto> getAllComment(long postId);
	
	CommentDto getCommentById(long postId, long id);
	
	CommentDto updateComment(Long postId, Long id, CommentDto commentRequest);
	
	public void deleteComment(Long postId, Long id);
}
