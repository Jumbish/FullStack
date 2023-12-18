package com.springboot.blog.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blog.payload.PostDto;
import com.springboot.blog.payload.PostResponse;
import com.springboot.blog.service.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	private PostService postService;

	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto) {
		return new ResponseEntity<PostDto>(postService.createPost(postDto), HttpStatus.CREATED);
	}

	@GetMapping
	public PostResponse getAllPost(@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "ASC", required = false) String sortDir) {
		return postService.getAllPost(pageNo, pageSize, sortBy, sortDir);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok(postService.getPost(id));
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable(name = "id") Long id) {

		PostDto postDtoResponse = postService.updatePostById(postDto, id);

		return new ResponseEntity<>(postDtoResponse, HttpStatus.OK);

	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePost(@PathVariable(name = "id") Long id) {

		postService.deletePost(id);

		return new ResponseEntity<String>("Post Entity deleted successfully", HttpStatus.OK);

	}
}
