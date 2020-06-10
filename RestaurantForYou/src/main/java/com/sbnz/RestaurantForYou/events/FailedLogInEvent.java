package com.sbnz.RestaurantForYou.events;

import java.io.Serializable;
import java.util.Date;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import com.sbnz.RestaurantForYou.model.User;


@Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Expires("5m")
public class FailedLogInEvent implements Serializable{

	private static final long serialVersionUID = 1L;
	private Date executionTime;
	private User user;
	
	public FailedLogInEvent() {
		// TODO Auto-generated constructor stub
	}

	public FailedLogInEvent(Date executionTime, User user) {
		super();
		this.executionTime = executionTime;
		this.user = user;
	}

	public Date getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Date executionTime) {
		this.executionTime = executionTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
