package com.springboot.blog.payload;

import java.util.List;


public class PostResponse {
	
	private List<PostDto> content;
	private int pageNo;
	private int pageSize;
	private long totalElements;
	private int totalpages;
	private boolean last;
	public List<PostDto> getContent() {
		return content;
	}
	public void setContent(List<PostDto> content) {
		this.content = content;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
	public int getTotalpages() {
		return totalpages;
	}
	public void setTotalpages(int totalpages) {
		this.totalpages = totalpages;
	}
	public boolean isLast() {
		return last;
	}
	public void setLast(boolean last) {
		this.last = last;
	}
	public PostResponse(List<PostDto> content, int pageNo, int pageSize, long totalElements, int totalpages,
			boolean last) {
		super();
		this.content = content;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalElements = totalElements;
		this.totalpages = totalpages;
		this.last = last;
	}
	public PostResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
