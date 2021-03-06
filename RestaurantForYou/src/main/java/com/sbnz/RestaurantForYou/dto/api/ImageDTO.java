package com.sbnz.RestaurantForYou.dto.api;

public class ImageDTO {
	
	private int width;
	private int height;
	private String url;
	
	public ImageDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "(width: " + width + ", height: " + height + ", url: " + url + ") ";
	}

}
