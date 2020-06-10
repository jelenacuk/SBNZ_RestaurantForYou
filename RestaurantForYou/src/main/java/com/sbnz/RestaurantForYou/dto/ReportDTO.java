package com.sbnz.RestaurantForYou.dto;

public class ReportDTO {

	private double average;
	private long numOfReviews;
	private long ones;
	private long twos;
	private long threes;
	private long fours;
	private long fives;
	
	public ReportDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ReportDTO(double average, long numOfReviews, long ones, long twos, long threes, long fours, long fives) {
		super();
		this.average = average;
		this.numOfReviews = numOfReviews;
		this.ones = ones;
		this.twos = twos;
		this.threes = threes;
		this.fours = fours;
		this.fives = fives;
	}
	
	public ReportDTO(double average, long numOfReviews) {
		super();
		this.average = average;
		this.numOfReviews = numOfReviews;
		this.ones = 0;
		this.twos = 0;
		this.threes = 0;
		this.fours = 0;
		this.fives = 0;
	}



	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public long getOnes() {
		return ones;
	}

	public void setOnes(long ones) {
		this.ones = ones;
	}

	public long getTwos() {
		return twos;
	}

	public void setTwos(long twos) {
		this.twos = twos;
	}

	public long getThrees() {
		return threes;
	}

	public void setThrees(long threes) {
		this.threes = threes;
	}

	public long getFours() {
		return fours;
	}

	public void setFours(long fours) {
		this.fours = fours;
	}

	public long getFives() {
		return fives;
	}

	public void setFives(long fives) {
		this.fives = fives;
	}

	public long getNumOfReviews() {
		return numOfReviews;
	}

	public void setNumOfReviews(long numOfReviews) {
		this.numOfReviews = numOfReviews;
	}
	
	
}
