package com.sbnz.RestaurantForYou.events;

import java.io.Serializable;
import java.util.Date;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import com.sbnz.RestaurantForYou.model.Review;


@Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Expires("2h30m")
public class RatingEvent implements Serializable {

	private static final long serialVersionUID = 1L;
    private Date executionTime;
    private Review review;
    
    public RatingEvent() {
	}

	public RatingEvent(Date executionTime, Review review) {
		this.executionTime = executionTime;
		this.review = review;
	}

	public Date getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Date executionTime) {
		this.executionTime = executionTime;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
