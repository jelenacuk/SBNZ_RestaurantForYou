package com.sbnz.RestaurantForYou.dto;

public class CommentDto {
	
	private Long restaurantId;
	private Long userId;
	private String text;
	private String authorName;
	private long size;
	
	public CommentDto() {
		// TODO Auto-generated constructor stub
	}
	

	public CommentDto(Long restaurantId, String text, String authorName, long size) {
		super();
		this.restaurantId = restaurantId;
		this.text = text;
		this.authorName = authorName;
		this.size = size;
	}


	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


	public long getSize() {
		return size;
	}


	public void setSize(long size) {
		this.size = size;
	}
	
	

}
