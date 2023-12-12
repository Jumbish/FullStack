package com.springboot.blog.service;

import com.springboot.blog.payload.PostDto;
import com.springboot.blog.payload.PostResponse;

public interface PostService {
	
	
	public PostDto createPost(PostDto postDto);
	
	public PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);
	
	public PostDto getPost(Long id);
	
	public PostDto updatePostById(PostDto postDto, Long id);
	
	public void deletePost(Long id);

}
