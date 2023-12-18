package com.springboot.blog.payload;



import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class PostDto {
	
	private Long id;
	
	
	@NotEmpty
	@Size(min=2, message="Post title should have at least 2 charactetrs")
	private String title;
	
	@NotEmpty
	@Size(min=10, message="Post title should have at least 10 charactetrs")
	private String description;
	
	@NotEmpty
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

}
