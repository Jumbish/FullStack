package com.springboot.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.springboot.blog.entity.Comment;
import com.springboot.blog.entity.Post;
import com.springboot.blog.exception.BlogApiException;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.repository.CommentRepository;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	private CommentRepository commentRepository;

	private PostRepository postRepository;

	private ModelMapper modelMapper;

	public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository,
			ModelMapper modelMapper) {
		this.commentRepository = commentRepository;
		this.postRepository = postRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public CommentDto createComment(long postId, CommentDto commentDto) {
		// TODO Auto-generated method stub

		Comment comment = mapToEntity(commentDto);
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

		comment.setPost(post);

		Comment newComment = commentRepository.save(comment);

		mapToCommentDto(newComment);
		return mapToCommentDto(newComment);
	}

	private Comment mapToEntity(CommentDto commentDto) {
		
		Comment comment = modelMapper.map(commentDto, Comment.class);
//		Comment comment = new Comment();
//		comment.setId(commentDto.getId());
//		comment.setBody(commentDto.getBody());
//		comment.setEmail(commentDto.getEmail());
//		comment.setName(commentDto.getName());
		return comment;

	}

	private CommentDto mapToCommentDto(Comment comment) {
		
		CommentDto commentDto = modelMapper.map(comment, CommentDto.class);
		
//		CommentDto commentDto = new CommentDto();
//		commentDto.setId(comment.getId());
//		commentDto.setBody(comment.getBody());
//		commentDto.setEmail(comment.getEmail());
//		commentDto.setName(comment.getName());
		return commentDto;

	}

	@Override
	public List<CommentDto> getAllComment(long postId) {
		// TODO Auto-generated method stub
		List<Comment> comments= null;
		try {
			comments = commentRepository.findByPostId(postId);
			 if (comments.isEmpty()) {
			       throw new ResourceNotFoundException("Post", "id", postId);
			 }
		}catch (Exception e) {
			// TODO: handle exception
			throw new ResourceNotFoundException("Post", "id", postId);
		}
		

		List<CommentDto> allComment = comments.stream().map(comment -> mapToCommentDto(comment))
				.collect(Collectors.toList());
		return allComment;
	}

	@Override
	public CommentDto getCommentById(long postId, long id) {

		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
		Comment comment = commentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("comments", "id", id));

		if (!comment.getPost().getId().equals(post.getId())) {
			throw new BlogApiException(HttpStatus.BAD_REQUEST, "comment does not belong to post");
		}
		// TODO Auto-generated method stub
		CommentDto commentDto = mapToCommentDto(comment);
		return commentDto;
	}

	@Override
	public CommentDto updateComment(Long postId, Long id, CommentDto commentRequest) {
		// TODO Auto-generated method stub
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
		Comment comment = commentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("comments", "id", id));
		comment.setBody(commentRequest.getBody());
		comment.setEmail(commentRequest.getEmail());
		comment.setName(commentRequest.getName());
		if (!comment.getPost().getId().equals(post.getId())) {
			throw new BlogApiException(HttpStatus.BAD_REQUEST, "comment does not belong to post");
		}
		Comment updatedComment = commentRepository.save(comment);
		return mapToCommentDto(updatedComment);
	}

	@Override
	public void deleteComment(Long postId, Long id) {
		// TODO Auto-generated method stub
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
		Comment comment = commentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("comments", "id", id));
		if (!comment.getPost().getId().equals(post.getId())) {
			throw new BlogApiException(HttpStatus.BAD_REQUEST, "comment does not belong to post");
		}

		commentRepository.delete(comment);
	}

}
