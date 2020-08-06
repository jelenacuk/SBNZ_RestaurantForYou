package com.sbnz.RestaurantForYou.dto.api;

public class ImagesWrapperDTO {

	private ImagesDTO images;
	
	public ImagesWrapperDTO() {
		// TODO Auto-generated constructor stub
	}

	public ImagesDTO getImages() {
		return images;
	}

	public void setImages(ImagesDTO images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "ImagesWrapperDTO [images=" + images + "]";
	}
	
}
