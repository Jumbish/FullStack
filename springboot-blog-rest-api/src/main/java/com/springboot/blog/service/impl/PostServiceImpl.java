package com.springboot.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.blog.entity.Post;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.payload.PostDto;
import com.springboot.blog.payload.PostResponse;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	private PostRepository postRepository;
	
	private ModelMapper modelMapper;
	//it can be ommit @Autowired because this class we configured as a spring bea and it has only one constroctor
	@Autowired
	public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
		this.postRepository = postRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public PostDto createPost(PostDto postDto) {
		// TODO Auto-generated method stub\

//		Post post = new Post();
//		post.setId(postDto.getId());
//		post.setTitle(postDto.getTitle());
//		post.setContent(postDto.getContent());
//		post.setDescription(postDto.getDescription());

		Post post = mapToPost(postDto);

		Post newPost = postRepository.save(post);

		PostDto postResponse = mapTotDto(newPost);

//		postResponse.setId(newPost.getId());
//		postResponse.setTitle(newPost.getTitle());
//		postResponse.setDescription(newPost.getDescription());
//		postResponse.setContent(newPost.getContent());

		return postResponse;
	}

	@Override
	public PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir) {
		// TODO Auto-generated method stub

		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

		Page<Post> page = postRepository.findAll(pageable);

		List<Post> posts = page.getContent();

		List<PostDto> content = posts.stream().map(post -> mapTotDto(post)).collect(Collectors.toList());

		PostResponse postResponse = new PostResponse();

		postResponse.setContent(content);
		postResponse.setPageNo(page.getNumber());
		postResponse.setPageSize(page.getSize());
		postResponse.setLast(page.isLast());
		postResponse.setTotalElements(page.getTotalElements());
		postResponse.setTotalpages(page.getTotalPages());

		return postResponse;

//		List<PostDto> postDtoList = new ArrayList<>();
//		
//		for (Post p : post) {
//			PostDto postDto = new PostDto();
//			System.out.println("http://localhost:8080/api/posts===="+p.getId());
//			postDto.setTitle(p.getTitle());
//			postDto.setContent(p.getContent());
//			postDto.setDescription(p.getDescription());
//			postDto.setId(p.getId());
//			postDtoList.add(postDto);
//		}
//		return postDtoList;
	}

	private PostDto mapTotDto(Post post) {
		
		PostDto postDto = modelMapper.map(post, PostDto.class);
		
//		PostDto postDto = new PostDto();
//		postDto.setTitle(post.getTitle());
//		postDto.setContent(post.getContent());
//		postDto.setDescription(post.getDescription());
//		postDto.setId(post.getId());
		return postDto;
	}

	private Post mapToPost(PostDto postDto) {
		
		Post post = modelMapper.map(postDto, Post.class);
//		Post post = new Post();
//		post.setId(postDto.getId());
//		post.setTitle(postDto.getTitle());
//		post.setContent(postDto.getContent());
//		post.setDescription(postDto.getDescription());
		return post;
	}

	@Override
	public PostDto getPost(Long id) {
//		Post post = postRepository.getOne(id);
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
		PostDto postDto = mapTotDto(post);
		return postDto;
	}

	@Override
	public PostDto updatePostById(PostDto postDto, Long id) {
		// TODO Auto-generated method stub

		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

		post.setContent(postDto.getContent());
		post.setDescription(postDto.getDescription());
		post.setTitle(postDto.getDescription());
//		Post post = mapToPost(postDto1);
		Post post1 = postRepository.save(post);
		PostDto postResponse = mapTotDto(post1);
		return postResponse;
	}

	@Override
	public void deletePost(Long id) {
		// TODO Auto-generated method stub
//		Post post = postRepository.getOne(id);

		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
		postRepository.delete(post);
	}

}
