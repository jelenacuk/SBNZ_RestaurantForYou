package com.sbnz.RestaurantForYou.dto.api;

public class ImagesDTO {
	
	private ImageDTO small;
	private ImageDTO thumbnail;
	private ImageDTO original;
	private ImageDTO large;
	private ImageDTO medium;
	
	public ImagesDTO() {
		// TODO Auto-generated constructor stub
	}

	public ImageDTO getSmall() {
		return small;
	}

	public void setSmall(ImageDTO small) {
		this.small = small;
	}

	public ImageDTO getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(ImageDTO thumbnail) {
		this.thumbnail = thumbnail;
	}

	public ImageDTO getOriginal() {
		return original;
	}

	public void setOriginal(ImageDTO original) {
		this.original = original;
	}

	public ImageDTO getLarge() {
		return large;
	}

	public void setLarge(ImageDTO large) {
		this.large = large;
	}

	public ImageDTO getMedium() {
		return medium;
	}

	public void setMedium(ImageDTO medium) {
		this.medium = medium;
	}

	@Override
	public String toString() {
		return "ImagesDTO [small= " + small + ", thumbnail=" + thumbnail + ", original=" + original + ", large=" + large
				+ ", medium=" + medium + "]";
	}
	
	

}
