package com.springboot.blog.controller;

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

import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.service.CommentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class CommentController {

	private CommentService commentService;

	@Autowired
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	@PostMapping("/posts/{postId}/comments")
	public ResponseEntity<CommentDto> createComment(@Valid @RequestBody CommentDto commentDto,
			@PathVariable(name = "postId") Long postId) {
		System.out.println("============" + commentDto.getEmail());
		return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
	}

	@GetMapping("/posts/{postId}/comments")
	public List<CommentDto> getAllComment(@PathVariable(name = "postId") Long postId) {
		return commentService.getAllComment(postId);
	}

	@GetMapping("/posts/{postId}/comments/{id}")
	public ResponseEntity<CommentDto> getCommentById(@PathVariable(name = "id") long id,
			@PathVariable(name = "postId") long postId) {
		return new ResponseEntity<>(commentService.getCommentById(postId, id), HttpStatus.OK);
	}

	@PutMapping("/posts/{postId}/comments/{id}")
	public ResponseEntity<CommentDto> updatedComment(@PathVariable(name = "id") long id, @PathVariable(name = "postId") long postId,
			@Valid @RequestBody CommentDto commentRequest) {
		return new ResponseEntity<>(commentService.updateComment(postId, id, commentRequest), HttpStatus.OK);

	}
	
	@DeleteMapping("/posts/{postId}/comments/{id}")
	public ResponseEntity<String> deleteComment(@PathVariable(name = "id") long id, @PathVariable(name = "postId") long postId) {
		commentService.deleteComment(postId, id);
		return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
	}

}
